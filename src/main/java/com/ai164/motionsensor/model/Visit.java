package com.ai164.motionsensor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime time;
    private int visitCounter;

    public Visit() {
    }

    public Visit(LocalDateTime time, int visitCounter) {
        this.time = time;
        this.visitCounter = visitCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", time=" + time +
                ", visitCounter=" + visitCounter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visitCounter == visit.visitCounter &&
                Objects.equals(id, visit.id) &&
                Objects.equals(time, visit.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, visitCounter);
    }
}
