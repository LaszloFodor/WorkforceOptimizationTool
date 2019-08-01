package com.SPO.workforce.entity;

import java.util.List;

public class Place {

    private List<Integer> rooms;

    private int seniorCleaner;

    private int juniorCleaner;

    public Place(List<Integer> rooms, int seniorCleaner, int juniorCleaner) {
        this.rooms = rooms;
        this.seniorCleaner = seniorCleaner;
        this.juniorCleaner = juniorCleaner;
    }

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
    }

    public int getSeniorCleanerCapacity() {
        return seniorCleaner;
    }

    public void setSeniorCleanerCapacity(int seniorCleaner) {
        this.seniorCleaner = seniorCleaner;
    }

    public int getJuniorCleanerCapacity() {
        return juniorCleaner;
    }

    public void setJuniorCleanerCapacity(int juniorCleaner) {
        this.juniorCleaner = juniorCleaner;
    }
}
