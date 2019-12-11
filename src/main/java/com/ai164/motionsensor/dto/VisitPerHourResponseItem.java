package com.ai164.motionsensor.dto;

import java.util.Objects;

public class VisitPerHourResponseItem {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int visitCounter;

    private VisitPerHourResponseItem() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitPerHourResponseItem that = (VisitPerHourResponseItem) o;
        return year == that.year &&
                month == that.month &&
                day == that.day &&
                hour == that.hour &&
                visitCounter == that.visitCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, hour, visitCounter);
    }

    public static Builder newBuilder() {
        return new VisitPerHourResponseItem().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setYear(int year) {
            VisitPerHourResponseItem.this.year = year;
            return this;
        }

        public Builder setMonth(int month) {
            VisitPerHourResponseItem.this.month = month;
            return this;
        }

        public Builder setDay(int day) {
            VisitPerHourResponseItem.this.day = day;
            return this;
        }

        public Builder setHour(int hour) {
            VisitPerHourResponseItem.this.hour = hour;
            return this;
        }

        public Builder setVisitCounter(int visitCounter) {
            VisitPerHourResponseItem.this.visitCounter = visitCounter;
            return this;
        }

        public VisitPerHourResponseItem build() {
            return VisitPerHourResponseItem.this;
        }
    }
}
