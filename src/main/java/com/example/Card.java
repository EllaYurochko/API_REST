package com.example;

public class Card {
    // ключ name стал полем типа String
    private String name;

    // ключ link стал полем типа String
    private String link;



    // конструктор со всеми параметрами
    public Card(String name, String link){
        this.name = name;
        this.link = link;
    }

    // конструктор без параметров
    public Card(){
    };

    // геттер для поля name
    public String getName(){
        return name;
    }

    // сеттер для поля name
    public void setName(String name) {
        this.name = name;
    }

    // геттер для поля link
    public String getLink() {
        return link;
    }

    // сеттер для поля link
    public void setLink(String link) {
        this.link = link;
    }
}
