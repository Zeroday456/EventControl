package com.eventcontrol;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventManagerTest {

    private EventManager manager;
    private Event event1;
    private Event event2;

    @BeforeEach
    void setUp() {
        manager = new EventManager();
        event1 = new Event("Встреча команды", "2026-07-15", "Обсуждение");
        event2 = new Event("Собеседование", "2026-07-20", "Найм");
    }

    @Test
    void testAddEvent() {
        manager.addEvent(event1);
        assertEquals(1, manager.getEventCount());
    }

    @Test
    void testAddNullEventThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> manager.addEvent(null));
    }

    @Test
    void testRemoveEvent() {
        manager.addEvent(event1);
        assertTrue(manager.removeEvent(event1));
        assertEquals(0, manager.getEventCount());
    }

    @Test
    void testGetAllEvents() {
        manager.addEvent(event1);
        manager.addEvent(event2);
        List<Event> allEvents = manager.getAllEvents();
        assertEquals(2, allEvents.size());
        assertTrue(allEvents.contains(event1));
        assertTrue(allEvents.contains(event2));
    }

    @Test
    void testSearchByTitle() {
        manager.addEvent(event1);
        manager.addEvent(event2);
        List<Event> result = manager.searchByTitle("команды");
        assertEquals(1, result.size());
        assertEquals(event1, result.get(0));
    }
}