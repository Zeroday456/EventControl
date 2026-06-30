package com.eventcontrol.security;

/**
 * Валидатор сложности пароля.
 */
public final class PasswordValidator {

    /** Минимальная длина пароля. */
    private static final int MIN_LENGTH = 8;

    /**
     * Приватный конструктор для утилитарного класса.
     */
    private PasswordValidator() {
        throw new UnsupportedOperationException(
                "Utility class should not be instantiated");
    }

    /**
     * Проверяет, соответствует ли пароль требованиям безопасности.
     *
     * @param aPassword пароль для проверки
     * @return true, если пароль соответствует требованиям
     */
    public static boolean isValid(final String aPassword) {
        if (aPassword == null || aPassword.length() < MIN_LENGTH) {
            return false;
        }

        final boolean hasUppercase = aPassword.chars()
                .anyMatch(Character::isUpperCase);
        final boolean hasLowercase = aPassword.chars()
                .anyMatch(Character::isLowerCase);
        final boolean hasDigit = aPassword.chars()
                .anyMatch(Character::isDigit);

        return hasUppercase && hasLowercase && hasDigit;
    }
}
