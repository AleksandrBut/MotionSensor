package com.ai164.motionsensor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int visitCounter;

    public Visit() {
    }

    public Visit(int year, int month, int day, int hour, int visitCounter) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.visitCounter = visitCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Visit visit = (Visit) o;
        return year == visit.year &&
                month == visit.month &&
                day == visit.day &&
                hour == visit.hour &&
                visitCounter == visit.visitCounter &&
                Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, day, hour, visitCounter);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", visitCounter=" + visitCounter +
                '}';
    }
}
