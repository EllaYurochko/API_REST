package com.example;

public class SimpleExample {
    // значение у id целое, поэтому нужен тип int
    private int id;
    // для поля name нужен тип String
    private String name;

    // для каждого из полей создали геттер и сеттер методы
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
