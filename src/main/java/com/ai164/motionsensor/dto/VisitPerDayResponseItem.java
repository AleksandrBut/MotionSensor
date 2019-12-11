package com.ai164.motionsensor.dto;

import java.util.Objects;

public class VisitPerDayResponseItem {

    private int year;
    private int month;
    private int day;
    private int visitCounter;

    private VisitPerDayResponseItem() {
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
        VisitPerDayResponseItem that = (VisitPerDayResponseItem) o;
        return year == that.year &&
                month == that.month &&
                day == that.day &&
                visitCounter == that.visitCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, visitCounter);
    }

    public static Builder newBuilder() {
        return new VisitPerDayResponseItem().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setYear(int year) {
            VisitPerDayResponseItem.this.year = year;
            return this;
        }

        public Builder setMonth(int month) {
            VisitPerDayResponseItem.this.month = month;
            return this;
        }

        public Builder setDay(int day) {
            VisitPerDayResponseItem.this.day = day;
            return this;
        }

        public Builder setVisitCounter(int visitCounter) {
            VisitPerDayResponseItem.this.visitCounter = visitCounter;
            return this;
        }

        public VisitPerDayResponseItem build() {
            return VisitPerDayResponseItem.this;
        }
    }
}
