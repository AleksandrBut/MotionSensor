package com.ai164.motionsensor.dto;

import java.time.LocalDateTime;

public class VisitCounterRequestItem {

    private LocalDateTime time;
    private int visitCounter;

    public VisitCounterRequestItem(LocalDateTime time, int visitCounter) {
        this.time = time;
        this.visitCounter = visitCounter;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getVisitCounter() {
        return visitCounter;
    }

    public void setVisitCounter(int visitCounter) {
        this.visitCounter = visitCounter;
    }
}
