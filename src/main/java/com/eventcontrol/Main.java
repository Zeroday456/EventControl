package com.eventcontrol;

/**
 * Главный класс приложения EventControl.
 * Содержит точку входа в программу.
 */
public final class Main {

    /**
     * Приватный конструктор для утилитарного класса.
     */
    private Main() {
        throw new UnsupportedOperationException(
                "Utility class should not be instantiated");
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        System.out.println("EventControl System started!");
    }
}
