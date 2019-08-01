package com.SPO.workforce.entity;

public class Cleaners {

    private int senior;

    private int junior;

    public Cleaners(int senior, int junior) {
        this.senior = senior;
        this.junior = junior;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }
}
