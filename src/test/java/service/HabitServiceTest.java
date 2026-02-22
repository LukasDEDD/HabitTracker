package service;

import model.Habit;
import model.HabitRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.HabitRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HabitServiceTest {

    @Mock
    private HabitRepository repository;

    @InjectMocks
    private HabitService service;

    @Test
    void findAll_returnsRepositoryList() {
        List<Habit> mockList = new ArrayList<>();
        mockList.add(new Habit(1, "Run", "Morning run", LocalDate.now()));
        when(repository.findAll()).thenReturn(mockList);

        List<Habit> result = service.findAll();

        assertEquals(1, result.size());
        assertEquals("Run", result.get(0).getName());
        verify(repository, times(1)).findAll();
    }
    @Test
    void createHabit_savesNewHabitWithIncrementedId() {

        List<Habit> existingHabits = new ArrayList<>();
        existingHabits.add(new Habit(1, "Old Habit", "Desc", LocalDate.now()));
        when(repository.findAll()).thenReturn(existingHabits);

        Habit created = service.createHabit("New Habit", "New Desc");

        assertEquals(2, created.getId());
        assertEquals("New Habit", created.getName());
        verify(repository).save(anyList());
    }

    @Test
    void addRecord_addsRecordToExistingHabit() {
        Habit habit = new Habit(1, "Run", "Desc", LocalDate.now());
        List<Habit> habits = new ArrayList<>(List.of(habit));
        when(repository.findAll()).thenReturn(habits);

        service.addRecord(1, LocalDate.now(), "Felt great");

        verify(repository).save(habits);

    }

}

