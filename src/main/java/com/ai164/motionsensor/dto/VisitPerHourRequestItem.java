package com.ai164.motionsensor.dto;

public class VisitPerHourRequestItem {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int visitCounter;

    public VisitPerHourRequestItem(int year, int month, int day, int hour, int visitCounter) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.visitCounter = visitCounter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    public void setVisitCounter(int visitCounter) {
        this.visitCounter = visitCounter;
    }
}
