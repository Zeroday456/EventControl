package com.eventcontrol.model;

import java.util.Objects;

/**
 * Модель пользователя системы.
 * Содержит данные для аутентификации и авторизации.
 */
public final class User {

    /** Уникальный идентификатор пользователя. */
    private Long id;

    /** Имя пользователя (совпадает с email). */
    private String username;

    /** Электронная почта пользователя (уникальный идентификатор). */
    private String email;

    /** Хешированный пароль. */
    private String passwordHash;

    /** Полное имя пользователя. */
    private String fullName;

    /**
     * Конструктор для регистрации нового пользователя.
     *
     * @param aEmail       электронная почта
     * @param aPasswordHash хешированный пароль
     * @param aFullName    полное имя
     */
    public User(final String aEmail, final String aPasswordHash,
            final String aFullName) {
        this.email = aEmail;
        this.passwordHash = aPasswordHash;
        this.fullName = aFullName;
        this.username = aEmail;
    }

    /**
     * Возвращает идентификатор пользователя.
     *
     * @return идентификатор
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор пользователя.
     *
     * @param aId новый идентификатор
     */
    public void setId(final Long aId) {
        this.id = aId;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Возвращает электронную почту.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Устанавливает электронную почту.
     *
     * @param aEmail новый email
     */
    public void setEmail(final String aEmail) {
        this.email = aEmail;
    }

    /**
     * Возвращает хеш пароля.
     *
     * @return хеш пароля
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Устанавливает хеш пароля.
     *
     * @param aPasswordHash новый хеш
     */
    public void setPasswordHash(final String aPasswordHash) {
        this.passwordHash = aPasswordHash;
    }

    /**
     * Возвращает полное имя пользователя.
     *
     * @return полное имя
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Устанавливает полное имя.
     *
     * @param aFullName новое имя
     */
    public void setFullName(final String aFullName) {
        this.fullName = aFullName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", email='" + email
                + "', fullName='" + fullName + "'}";
    }
}
