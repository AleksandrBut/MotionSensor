package com.ai164.motionsensor.dto;

public class VisitCounterRequestItem {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int visitCounter;

    private VisitCounterRequestItem() {

    }

    public static Builder newBuilder() {
        return new VisitCounterRequestItem().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setYear(int year) {
            VisitCounterRequestItem.this.year = year;
            return this;
        }

        public Builder setMonth(int month) {
            VisitCounterRequestItem.this.month = month;
            return this;
        }

        public Builder setDay(int day) {
            VisitCounterRequestItem.this.day = day;
            return this;
        }

        public Builder setHour(int hour) {
            VisitCounterRequestItem.this.hour = hour;
            return this;
        }

        public Builder setVisitCounter(int visitCounter) {
            VisitCounterRequestItem.this.visitCounter = visitCounter;
            return this;
        }

        public VisitCounterRequestItem build() {
            return VisitCounterRequestItem.this;
        }
    }
}
