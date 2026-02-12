package service;

import repository.HabitRepository;
import model.Habit;

import java.time.LocalDate;
import java.util.List;

public class HabitService {

    private final HabitRepository repository;

    public HabitService(HabitRepository repository) {
        this.repository = repository;
    }

    public List<Habit> findAll() {
        return repository.findAll();
    }

    public Habit findById(long id) {
        return repository.findAll().stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Habit createHabit(String name, String description) {
        List<Habit> habits = repository.findAll();

        long newId = habits.stream()
                .mapToLong(Habit::getId)
                .max()
                .orElse(0) + 1;

        Habit habit = new Habit(newId, name, description, LocalDate.now());
        habits.add(habit);

        repository.save(habits);
        return habit;
    }

    public void addRecord(long habitId, LocalDate date, String note) {
        List<Habit> habits = repository.findAll();

        Habit habit = habits.stream()
                .filter(h -> h.getId() == habitId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Habit not found"));

        habit.addRecord(date, note);
        repository.save(habits);
    }
}


