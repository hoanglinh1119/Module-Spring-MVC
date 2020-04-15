package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name="picture")
public class PictureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String comment;
    private int view;
    private String src;
    public PictureModel(){

    }

    public PictureModel(int id, String name, String comment, int view,String src) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.view = view;
        this.src=src;
    }


    @Id
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

