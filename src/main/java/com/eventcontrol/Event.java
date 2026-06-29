package com.eventcontrol;

public class Event {
    private String title;
    private String date;
    private String description;

    // Конструктор
    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // Сеттеры
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Метод для проверки валидности события
    public boolean isValid() {
        return title != null && !title.isEmpty() 
                && date != null && !date.isEmpty()
                && description != null && !description.isEmpty();
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