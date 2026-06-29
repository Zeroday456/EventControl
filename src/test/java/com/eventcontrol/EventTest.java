package com.eventcontrol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertTrue(validEvent.isValid());

        // Создаём невалидное событие (пустое название)
        Event invalidEvent1 = new Event("", "2026-07-15", "Описание");
        assertFalse(invalidEvent1.isValid());

        // Создаём невалидное событие (null дата)
        Event invalidEvent2 = new Event("Встреча", null, "Описание");
        assertFalse(invalidEvent2.isValid());

        // Создаём невалидное событие (пустое описание)
        Event invalidEvent3 = new Event("Встреча", "2026-07-15", "");
        assertFalse(invalidEvent3.isValid());
    }

    @Test
    public void testEventToString() {
        Event event = new Event("Встреча", "2026-07-15", "Описание");
        String expected = "Event{title='Встреча', date='2026-07-15', description='Описание'}";
        assertEquals(expected, event.toString());
    }
}