package com.eventcontrol;

import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;

    public Event(String title, String date, String description) {
        // Проверка на null
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название события не может быть пустым");
        }
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Дата события не может быть пустой");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Описание события не может быть пустым");
        }
        
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название события не может быть пустым");
        }
        this.title = title;
    }

    public void setDate(String date) {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("Дата события не может быть пустой");
        }
        this.date = date;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Описание события не может быть пустым");
        }
        this.description = description;
    }

    public boolean isValid() {
        return title != null && !title.isEmpty() 
                && date != null && !date.isEmpty()
                && description != null && !description.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(date, event.date) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}