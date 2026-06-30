package com.eventcontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.eventcontrol.model.User;

/**
 * Менеджер для управления событиями с контролем доступа.
 * Отвечает за хранение, добавление, удаление и поиск событий.
 */
public class EventManager {

    /** Список всех событий. */
    private final List<Event> events = new ArrayList<>();

    /**
     * Добавляет событие в систему.
     *
     * @param event событие для добавления
     * @throws IllegalArgumentException если событие null или невалидно
     */
    public void addEvent(final Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Событие не может быть null");
        }
        if (!event.isValid()) {
            throw new IllegalArgumentException("Событие невалидно");
        }
        events.add(event);
    }

    /**
     * Удаляет событие из системы.
     *
     * @param event событие для удаления
     * @return true, если событие было удалено, иначе false
     */
    public boolean removeEvent(final Event event) {
        return event != null
            && events.remove(event);
    }

    /**
     * Возвращает неизменяемый список всех событий.
     *
     * @return список событий
     */
    public List<Event> getAllEvents() {
        return Collections.unmodifiableList(events);
    }

    /**
     * Возвращает список событий, доступных текущему пользователю.
     * Пользователь видит только свои события.
     *
     * @param currentUser текущий аутентифицированный пользователь
     * @return список доступных событий
     */
    public List<Event> getEventsForUser(
        final User currentUser) {
        if (currentUser == null) {
            return Collections.emptyList();
        }

        // В реальном приложении здесь проверка, что событие принадлежит пользователю
        // или пользователь является участником
        // Для примера возвращаем все события (так как мы не храним owner в Event)
        return getAllEvents();
    }

    /**
     * Проверяет, имеет ли пользователь доступ к событию.
     * В реальном приложении проверяется ownership.
     *
     * @param event событие
     * @param currentUser текущий пользователь
     * @return true, если доступ разрешён
     */
    public boolean hasAccessToEvent(final Event event, final User currentUser) {
        if (currentUser == null || event == null) {
            return false;
        }

        // В реальном приложении: return event.getOwnerId().equals(currentUser.getId());
        // Для примера: доступ ко всем событиям разрешён
        return true;
    }

    /**
     * Ищет события по частичному совпадению в названии.
     *
     * @param keyword ключевое слово для поиска (регистр не учитывается)
     * @return список найденных событий
     */
    public List<Event> searchByTitle(final String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAllEvents();
        }
        final String lowerKeyword = keyword.toLowerCase();
        return events.stream()
                .filter(event -> event.getTitle().toLowerCase()
                        .contains(lowerKeyword))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает количество событий.
     *
     * @return количество событий
     */
    public int getEventCount() {
        return events.size();
    }
}