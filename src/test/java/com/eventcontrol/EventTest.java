package com.eventcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void testEventCreation() {
        // Создаём событие
        Event event = new Event("Встреча команды", "2026-07-15", "Обсуждение проекта");

        // Проверяем, что данные сохранились корректно
        assertEquals("Встреча команды", event.getTitle());
        assertEquals("2026-07-15", event.getDate());
        assertEquals("Обсуждение проекта", event.getDescription());
    }

   @Test
    public void testEventIsValid() {
        // Создаём валидное событие
        Event validEvent = new Event("Встреча", "2026-07-15", "Описание");
        // Проверяем, что для валидного события метод isValid() возвращает true
        assertTrue(validEvent.isValid());
    }

    @Test
    public void testEventToString() {
        Event event = new Event("Встреча", "2026-07-15", "Описание");
        String expected = "Event{title='Встреча', date='2026-07-15', description='Описание'}";
        assertEquals(expected, event.toString());
    }
}