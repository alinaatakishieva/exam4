package com.company;


import java.util.Date;

public class News {
    private int id;
    private String title;
    private String text;
    private Date publicationDate;

    public News(){}

    public News(int id, String title, String text, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString(){
        return "\nНовость о: " + title +
                "\t\t\tДата публикации: " + publicationDate + "\n" +
                text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
