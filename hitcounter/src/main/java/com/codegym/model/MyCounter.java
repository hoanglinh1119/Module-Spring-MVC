package com.codegym.model;

public class MyCounter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public  MyCounter(){

    }

    public MyCounter(int counter) {
        this.counter = counter;
    }
    public int increment(){
        return counter++;
    }
}
