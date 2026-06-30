package com.eventcontrol.security;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Защита от подбора пароля.
 * Ограничивает количество неудачных попыток входа.
 */
public final class BruteForceProtection {

    /** Максимальное количество попыток. */
    private static final int MAX_ATTEMPTS = 5;

    /** Длительность блокировки (15 минут). */
    private static final long LOCK_DURATION_MS = 15 * 60 * 1000;

    /** Хранилище количества попыток для каждого пользователя. */
    private final ConcurrentHashMap<String, Integer> attempts
            = new ConcurrentHashMap<>();

    /** Хранилище времени блокировки для каждого пользователя. */
    private final ConcurrentHashMap<String, Long> lockTime
            = new ConcurrentHashMap<>();

    /**
     * Регистрирует неудачную попытку входа.
     *
     * @param aEmail электронная почта пользователя
     * @return true, если аккаунт заблокирован
     */
    public boolean registerFailedAttempt(final String aEmail) {
        final int currentAttempts = attempts.getOrDefault(aEmail, 0) + 1;
        attempts.put(aEmail, currentAttempts);

        if (currentAttempts >= MAX_ATTEMPTS) {
            lockTime.put(aEmail, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    /**
     * Проверяет, заблокирован ли аккаунт.
     *
     * @param aEmail электронная почта пользователя
     * @return true, если аккаунт заблокирован
     */
    public boolean isLocked(final String aEmail) {
        final Long lockStart = lockTime.get(aEmail);
        if (lockStart == null) {
            return false;
        }
        final long elapsed = System.currentTimeMillis() - lockStart;
        if (elapsed > LOCK_DURATION_MS) {
            reset(aEmail);
            return false;
        }
        return true;
    }

    /**
     * Сбрасывает попытки для пользователя (при успешном входе).
     *
     * @param aEmail электронная почта пользователя
     */
    public void reset(final String aEmail) {
        attempts.remove(aEmail);
        lockTime.remove(aEmail);
    }
}
