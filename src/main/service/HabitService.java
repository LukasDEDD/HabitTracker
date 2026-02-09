package main.service;

import main.model.Habit;

import java.util.List;

public interface HabitService {

    List<Habit> findAll();

    Habit findById(int id);

    Habit add(List<Habit>records);

}
