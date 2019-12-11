package com.ai164.motionsensor.dto;

public class VisitRequestItem {

    String dateTime;
    private int visitCounter;

    public VisitRequestItem(String dateTime, int visitCounter) {
        this.dateTime = dateTime;
        this.visitCounter = visitCounter;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    public void setVisitCounter(int visitCounter) {
        this.visitCounter = visitCounter;
    }
}
