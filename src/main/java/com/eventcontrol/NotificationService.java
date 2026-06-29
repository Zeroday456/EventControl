package com.eventcontrol;

/**
 * Сервис для отправки уведомлений о событиях.
 */
public class NotificationService {

    /**
     * Отправляет уведомление о создании события.
     *
     * @param event созданное событие
     */
    public void notifyEventCreated(final Event event) {
        if (event == null) {
            return;
        }
        final String message = "[УВЕДОМЛЕНИЕ] Создано событие: "
                + event.getTitle();
        System.out.println(message);
    }

    /**
     * Отправляет уведомление об удалении события.
     *
     * @param event удалённое событие
     */
    public void notifyEventDeleted(final Event event) {
        if (event == null) {
            return;
        }
        final String message = "[УВЕДОМЛЕНИЕ] Удалено событие: "
                + event.getTitle();
        System.out.println(message);
    }

    /**
     * Отправляет напоминание о событии.
     *
     * @param event событие для напоминания
     */
    public void sendReminder(final Event event) {
        if (event == null) {
            return;
        }
        final String message = "[НАПОМИНАНИЕ] Напоминание о событии: "
                + event.getTitle() + " (" + event.getDate() + ")";
        System.out.println(message);
    }
}
