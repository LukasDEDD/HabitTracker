import repository.FileHabitRepository;
import repository.HabitRepository;
import service.HabitService;

public class Main {

    public static void main( String[] args) {

        HabitRepository repo = new FileHabitRepository();
        HabitService service = new HabitService(repo);
        ui.ConsoleUI ui = new ui.ConsoleUI(service);
        ui.start();

            }
      }

