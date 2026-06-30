package com.eventcontrol;

import com.eventcontrol.model.User;
import com.eventcontrol.service.AuthService;

/**
 * Главный класс приложения EventControl.
 * Демонстрирует работу аутентификации и контроля доступа.
 */
public final class Main {

    /**
     * Приватный конструктор для утилитарного класса.
     */
    private Main() {
        throw new UnsupportedOperationException(
                "Utility class should not be instantiated");
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        // 1. Создаём сервис аутентификации
        final AuthService authService = new AuthService();

        // 2. Регистрация нового пользователя
        System.out.println("=== Регистрация ===");
        User newUser = authService.registerUser(
                "user@example.com", "securePassword123", "Иван Петров");
        System.out.println("Зарегистрирован пользователь: " + newUser.getFullName());

        // 3. Попытка регистрации с существующим email
        try {
            authService.registerUser("user@example.com", "pass", "Пётр");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }

        // 4. Аутентификация
        System.out.println("\n=== Аутентификация ===");
        try {
            User authenticatedUser = authService.authenticate(
                "user@example.com", "securePassword123");
            System.out.println("Вход выполнен: "
                +authenticatedUser.getFullName());

            // 5. Проверка неверного пароля
            authService.authenticate("user@example.com", "wrongPassword");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка входа: " + e.getMessage());
        }

        // 6. Демонстрация контроля доступа
        System.out.println("\n=== Контроль доступа ===");
        EventManager manager = new EventManager();

        Event meeting = new Event("Встреча команды", "2026-07-15", "Обсуждение");
        manager.addEvent(meeting);

        User currentUser = authService.authenticate("user@example.com", "securePassword123");

        // Проверка доступа к событию
        boolean hasAccess = manager.hasAccessToEvent(
            meeting, currentUser);
        System.out.println("Доступ к событию: " 
            +(hasAccess ? "✅ Разрешён" : "❌ Запрещён"));

        // Получение списка событий для пользователя
        System.out.println("\nСобытия доступные пользователю:");
        manager.getEventsForUser(currentUser)
            .forEach(System.out::println);
    }
}