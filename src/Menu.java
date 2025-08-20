import java.util.*;

public class Menu {
    private List<String> options;
    private Scanner sc = new Scanner(System.in);

    public Menu(String... opts) {
        this.options = Arrays.asList(opts);
    }

    public Menu(List<String> opts) {
        this.options = opts;
    }

    public String displayMenu() {
        System.out.println("\n=== Employee Management Menu ===");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Enter your choice: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice >= 1 && choice <= options.size()) {
                return options.get(choice - 1);
            } else {
                System.out.println("Invalid option. Try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return displayMenu();
    }
}
