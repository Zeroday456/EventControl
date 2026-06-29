package com.eventcontrol;

/**
 * Главный класс приложения EventControl.
 */
public final class Main {

    private Main() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // 1. Создаём менеджер событий
        EventManager manager = new EventManager();

        // 2. Создаём сервис уведомлений
        NotificationService notifier = new NotificationService();

        // 3. Создаём события (используем улучшенный иммутабельный Event)
        Event meeting = new Event("Встреча команды", "2026-07-15", "Обсуждение проекта");
        Event interview = new Event("Собеседование", "2026-07-20", "Найм разработчика");

        // 4. Добавляем события через менеджер
        manager.addEvent(meeting);
        manager.addEvent(interview);

        // 5. Отправляем уведомления
        notifier.notifyEventCreated(meeting);
        notifier.notifyEventCreated(interview);

        // 6. Поиск событий
        System.out.println("\nПоиск по слову 'команды':");
        manager.searchByTitle("команды").forEach(System.out::println);

        // 7. Удаляем событие
        manager.removeEvent(meeting);
        notifier.notifyEventDeleted(meeting);

        // 8. Напоминание
        notifier.sendReminder(interview);
    }
}