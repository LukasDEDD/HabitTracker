package main.repository;

import main.model.Habit;
import java.util.List;

public interface HabitRepository {

    List<Habit> findAll();

    Habit findById(long id);

    void save(List<Habit> habits);
}

