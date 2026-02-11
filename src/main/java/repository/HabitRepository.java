package repository;

import model.Habit;
import java.util.List;

public interface HabitRepository {

    List<Habit> findAll();

    Habit findById(long id);

    void save(List<Habit> habits);
}

