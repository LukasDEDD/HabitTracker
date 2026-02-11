package main.model;

import java.time.LocalDate;

public class HabitRecord {

    LocalDate date;
    String note;

    public HabitRecord(LocalDate date, String note) {
        this.date = date;
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "HabitRecord{" +
                "date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
