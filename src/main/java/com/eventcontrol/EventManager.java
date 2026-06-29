package com.eventcontrol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Менеджер для управления событиями.
 * Отвечает за хранение, добавление, удаление и поиск событий.
 * Использует иммутабельный класс {@link Event}.
 */
public class EventManager {

    private final List<Event> events = new ArrayList<>();

    /**
     * Добавляет событие в систему.
     *
     * @param event событие для добавления
     * @throws IllegalArgumentException если событие null или невалидно
     */
    public void addEvent(Event event) {
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
    public boolean removeEvent(Event event) {
        return event != null && events.remove(event);
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
     * Ищет события по частичному совпадению в названии.
     *
     * @param keyword ключевое слово для поиска (регистр не учитывается)
     * @return список найденных событий
     */
    public List<Event> searchByTitle(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAllEvents();
        }
        String lowerKeyword = keyword.toLowerCase();
        return events.stream()
                .filter(event -> event.getTitle().toLowerCase().contains(lowerKeyword))
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