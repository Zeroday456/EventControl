package com.eventcontrol.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Утилитарный класс для хеширования и проверки паролей.
 * Использует BCryptPasswordEncoder для безопасного хранения.
 */
public final class PasswordEncoder {

    /** Кодировщик паролей BCrypt. */
    private static final BCryptPasswordEncoder ENCODER
            = new BCryptPasswordEncoder();

    /**
     * Приватный конструктор для утилитарного класса.
     */
    private PasswordEncoder() {
        throw new UnsupportedOperationException(
                "Utility class should not be instantiated");
    }

    /**
     * Хеширует пароль.
     *
     * @param aRawPassword пароль в открытом виде
     * @return хешированный пароль
     * @throws IllegalArgumentException если пароль null или пустой
     */
    public static String hashPassword(final String aRawPassword) {
        if (aRawPassword == null || aRawPassword.isEmpty()) {
            throw new IllegalArgumentException(
                    "Пароль не может быть пустым");
        }
        return ENCODER.encode(aRawPassword);
    }

    /**
     * Проверяет, соответствует ли пароль хешу.
     *
     * @param aRawPassword     пароль в открытом виде
     * @param aHashedPassword  хешированный пароль
     * @return true, если пароль совпадает
     */
    public static boolean checkPassword(final String aRawPassword,
            final String aHashedPassword) {
        if (aRawPassword == null || aHashedPassword == null) {
            return false;
        }
        return ENCODER.matches(aRawPassword, aHashedPassword);
    }
}
