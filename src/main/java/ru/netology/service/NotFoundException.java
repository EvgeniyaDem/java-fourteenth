package ru.netology.service;
public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Книга с id = " + id + " не найдена");
    }
}
