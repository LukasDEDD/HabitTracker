package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Habit;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileHabitRepository implements HabitRepository {

    private static final String FILE_PATH = "data/habits.json";
    private final Gson gson = new Gson();

    @Override
    public List<Habit> findAll() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Habit>>(){}.getType();
            List<Habit> habits = gson.fromJson(reader, listType);
            return habits != null ? habits : new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Habit findById(long id) {
        return findAll().stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(List<Habit> habits) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(habits, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

