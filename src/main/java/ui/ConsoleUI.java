package ui;

import service.HabitService;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {

    private final HabitService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(HabitService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== HABIT TRACKER ===");
            System.out.println("1. Create new habit");
            System.out.println("2. List all habits");
            System.out.println("3. Show habit details");
            System.out.println("4. Add record");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> createHabit();
                case "2" -> listHabits();
                case "3" -> showHabitDetail();
                case "4" -> addRecord();
                case "0" -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void createHabit() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        var habit = service.createHabit(name, description);
        System.out.println("Habit created: " + habit);
    }

    private void listHabits() {
        var habits = service.findAll();
        if (habits.isEmpty()) {
            System.out.println("No habits found.");
            return;
        }

        habits.forEach(h -> System.out.println(h.getId() + ": " + h.getName()));
    }

    private void showHabitDetail() {
        System.out.print("Enter habit ID: ");
        long id = Long.parseLong(scanner.nextLine());

        var habit = service.findById(id);
        if (habit == null) {
            System.out.println("Habit not found.");
            return;
        }

        System.out.println(habit);
    }

    private void addRecord() {
        System.out.print("Habit ID: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Note: ");
        String note = scanner.nextLine();

        try {
            service.addRecord(id, date, note);
            System.out.println("Record added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

