package Controller;

import Model.Element;
import View.Menu;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MenuController extends Menu {

    private SortController sort;
    private SearchController search;

    public MenuController() {
        super("\nSortSearch Management", Arrays.asList(new String[]{"Sort Management", "Search Management", "Exit"}));
        sort = new SortController();
        search = new SearchController();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                sort.run();
                break;
            case 2:
                search.run();
                break;
            case 3:
                System.err.println("Exited. Bye bye!");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }
}
