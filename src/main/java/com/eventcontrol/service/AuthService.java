package com.eventcontrol.service;

import java.util.HashMap;
import java.util.Map;

import com.eventcontrol.model.User;
import com.eventcontrol.security.BruteForceProtection;
import com.eventcontrol.security.PasswordEncoder;
import com.eventcontrol.security.PasswordValidator;

/**
 * Сервис для аутентификации и регистрации пользователей.
 */
public final class AuthService {

    /** Хранилище пользователей (временное). */
    private final Map<String, User> userStorage = new HashMap<>();

    /** Защита от подбора пароля. */
    private final BruteForceProtection bruteForceProtection
            = new BruteForceProtection();

    /**
     * Регистрация нового пользователя.
     *
     * @param aEmail       электронная почта
     * @param aRawPassword пароль в открытом виде
     * @param aFullName    полное имя
     * @return созданный пользователь
     * @throws IllegalArgumentException если пользователь с таким email существует
     */
    public User registerUser(final String aEmail, final String aRawPassword,
            final String aFullName) {
        if (userStorage.containsKey(aEmail)) {
            throw new IllegalArgumentException(
                    "Пользователь с таким email уже существует");
        }

        // Проверка сложности пароля
        if (!PasswordValidator.isValid(aRawPassword)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать минимум 8 символов, "
                    + "заглавную и строчную букву, и цифру");
        }

        final String hashedPassword = PasswordEncoder.hashPassword(aRawPassword);
        final User user = new User(aEmail, hashedPassword, aFullName);
        user.setId((long) (userStorage.size() + 1));
        userStorage.put(aEmail, user);

        return user;
    }

    /**
     * Аутентификация пользователя.
     *
     * @param aEmail       электронная почта
     * @param aRawPassword пароль в открытом виде
     * @return пользователь, если аутентификация успешна
     * @throws IllegalArgumentException если email не найден или пароль неверный
     */
    public User authenticate(final String aEmail, final String aRawPassword) {
        // Проверка блокировки
        if (bruteForceProtection.isLocked(aEmail)) {
            throw new IllegalArgumentException(
                    "Аккаунт заблокирован на 15 минут");
        }

        final User user = userStorage.get(aEmail);
        if (user == null) {
            bruteForceProtection.registerFailedAttempt(aEmail);
            throw new IllegalArgumentException("Пользователь не найден");
        }

        if (!PasswordEncoder.checkPassword(aRawPassword, user.getPasswordHash())) {
            bruteForceProtection.registerFailedAttempt(aEmail);
            throw new IllegalArgumentException("Неверный пароль");
        }

        // Успешный вход — сбрасываем попытки
        bruteForceProtection.reset(aEmail);
        return user;
    }

    /**
     * Возвращает текущего аутентифицированного пользователя.
     *
     * @param aEmail электронная почта пользователя
     * @return пользователь или null
     */
    public User getCurrentUser(final String aEmail) {
        return userStorage.get(aEmail);
    }

    /**
     * Проверяет, существует ли пользователь с таким email.
     *
     * @param aEmail электронная почта
     * @return true, если пользователь существует
     */
    public boolean userExists(final String aEmail) {
        return userStorage.containsKey(aEmail);
    }
}
