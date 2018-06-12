package com.company;

public class Game {

    private String title;
    private String type;
    private int idNumber;
    private String dueDate;


    public Game(String title, String type, int idNumber) {
        this.title = title;
        this.type = type;
        this.idNumber = idNumber;
        dueDate= "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
