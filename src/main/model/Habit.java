package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habit {

    long id;
    String name;
    String description;
    LocalDate createdDate;

    List<HabitRecord> records = new ArrayList<>();

    public Habit(long id, String name, String description, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
