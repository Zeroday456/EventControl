package com.eventcontrol;

/**
 * Главный класс приложения EventControl.
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
        // Создаём менеджер событий
        final EventManager manager = new EventManager();

        // Создаём сервис уведомлений
        final NotificationService notifier = new NotificationService();

        // Создаём события
        final Event meeting = new Event("Встреча команды",
                "2026-07-15", "Обсуждение проекта");
        final Event interview = new Event("Собеседование",
                "2026-07-20", "Найм разработчика");

        // Добавляем события
        manager.addEvent(meeting);
        manager.addEvent(interview);

        // Отправляем уведомления
        notifier.notifyEventCreated(meeting);
        notifier.notifyEventCreated(interview);

        // Поиск событий
        System.out.println("\nПоиск по слову 'команды':");
        manager.searchByTitle("команды").forEach(System.out::println);

        // Удаляем событие
        manager.removeEvent(meeting);
        notifier.notifyEventDeleted(meeting);

        // Напоминание
        notifier.sendReminder(interview);
    }
}
