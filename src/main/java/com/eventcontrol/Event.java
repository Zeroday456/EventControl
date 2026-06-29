package com.eventcontrol;

import java.util.Objects;

/**
 * Класс, представляющий событие в системе управления мероприятиями.
 * Содержит основную информацию о событии: название, дату и описание.
 */
public class Event {

    /** Название события. */
    private final String title;

    /** Дата проведения события. */
    private final String date;

    /** Описание события. */
    private final String description;

    /**
     * Конструктор для создания события.
     *
     * @param aTitle       название события (не может быть null или пустым)
     * @param aDate        дата проведения (не может быть null или пустой)
     * @param aDescription описание события (не может быть null или пустым)
     * @throws IllegalArgumentException если любое поле null или пустое
     */
    public Event(final String aTitle, final String aDate,
            final String aDescription) {
        if (aTitle == null || aTitle.isEmpty()) {
            throw new IllegalArgumentException(
                    "Название события не может быть пустым");
        }
        if (aDate == null || aDate.isEmpty()) {
            throw new IllegalArgumentException(
                    "Дата события не может быть пустой");
        }
        if (aDescription == null || aDescription.isEmpty()) {
            throw new IllegalArgumentException(
                    "Описание события не может быть пустым");
        }
        this.title = aTitle;
        this.date = aDate;
        this.description = aDescription;
    }

    /**
     * Возвращает название события.
     *
     * @return название события
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает дату проведения события.
     *
     * @return дата события
     */
    public String getDate() {
        return date;
    }

    /**
     * Возвращает описание события.
     *
     * @return описание события
     */
    public String getDescription() {
        return description;
    }

    /**
     * Проверяет, является ли событие валидным.
     * Событие валидно, если все поля заполнены (не null и не пустые).
     *
     * @return true, если событие валидно, иначе false
     */
    public boolean isValid() {
        return title != null && !title.isEmpty()
                && date != null && !date.isEmpty()
                && description != null && !description.isEmpty();
    }

    /**
     * Сравнивает текущее событие с другим объектом.
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Event event = (Event) o;
        return Objects.equals(title, event.title)
                && Objects.equals(date, event.date)
                && Objects.equals(description, event.description);
    }

    /**
     * Возвращает хеш-код события.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    /**
     * Возвращает строковое представление события.
     *
     * @return строка с данными события
     */
    @Override
    public String toString() {
        return "Event{"
                + "title='" + title + '\''
                + ", date='" + date + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
