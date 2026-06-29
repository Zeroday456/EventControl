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
    public void notifyEventCreated(Event event) {
        if (event == null) {
            return;
        }
        System.out.println("[УВЕДОМЛЕНИЕ] Создано событие: " + event.getTitle());
    }

    /**
     * Отправляет уведомление об удалении события.
     *
     * @param event удалённое событие
     */
    public void notifyEventDeleted(Event event) {
        if (event == null) {
            return;
        }
        System.out.println("[УВЕДОМЛЕНИЕ] Удалено событие: " + event.getTitle());
    }

    /**
     * Отправляет напоминание о событии.
     *
     * @param event событие для напоминания
     */
    public void sendReminder(Event event) {
        if (event == null) {
            return;
        }
        System.out.println("[НАПОМИНАНИЕ] Напоминание о событии: " + event.getTitle() + " (" + event.getDate() + ")");
    }
}