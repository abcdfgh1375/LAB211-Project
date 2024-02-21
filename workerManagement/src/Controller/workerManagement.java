package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import model.SalaryHistory;
import view.Menu;
import model.worker;
import view.viewWorker;

public class workerManagement extends Menu {

    private final worker worker;
    private final viewWorker view;
    private final SalaryHistory salaryHistory;
    List<SalaryHistory> salaryList = new ArrayList<>();
    HashMap<String, worker> workerHash = new HashMap<>();

    public workerManagement() {
        super("Worker Management", Arrays.asList(new String[]{"Add Worker",
            "Up salary", "Down salary", "Display Information salary", "Exit"}));
        this.view = new viewWorker();
        this.worker = new worker();
        this.salaryHistory = new SalaryHistory();
    }

    enum choices {
        Add, Up, Down, Show, Exit;
    }

    public choices convertEnum(int c) {
        switch (c) {
            case 1 -> {
                return choices.Add;
            }
            case 2 -> {
                return choices.Up;
            }
            case 3 -> {
                return choices.Down;
            }
            case 4 -> {
                return choices.Show;
            }
            case 5 -> {
                return choices.Exit;
            }
            default -> {
                System.out.println("Invalid choice");
                run();
            }
        }
        return null;
    }

    @Override
    public void execute(int choice) {
        choices ch = convertEnum(choice);
        switch (ch) {
            case Add -> {
                try {
                    addWorker();
                    view.displayHash(workerHash);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Up -> {
                try {
                    upSalary();
                    view.displaySalaryHistory(salaryList);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Down -> {
                try {
                    downSalary();
                    view.displaySalaryHistory(salaryList);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Show -> {
                try {
                    view.displaySalaryHistory(salaryList);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case Exit -> {
                System.exit(0);
            }
        }

    }

    public void addWorker() throws Exception {
        view.displayTitle("Add Worker", '-');
        view.displayResultFunction(worker.addWorker(workerHash), "Add");
        
    }

    public void upSalary() throws Exception {
        view.displayTitle("Up Salary", '-');
        view.displayResultFunction(worker.changeSalary(workerHash,salaryList,"UP"), "Up Salary");
    }

    public void downSalary() throws Exception {
        view.displayTitle("Down Salary", '-');
        view.displayResultFunction(worker.changeSalary(workerHash,salaryList,"DOWN"), "Down Salary");
    }

}
