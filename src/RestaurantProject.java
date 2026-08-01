import java.util.*;

// Interface
interface Feedback {
    void giveFeedback();
}

// Base Class
class Restaurant {
    String name;
    int tableNo;

    void bookTable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Table Number: ");
        tableNo = sc.nextInt();

        System.out.println("Table " + tableNo + " booked for " + name);
    }
}

// Derived Class
class Order extends Restaurant implements Feedback {
    int choice, qty;
    double total = 0;

    void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Pizza - 200");
        System.out.println("2. Burger - 100");
        System.out.println("3. Pasta - 150");
        System.out.println("4. Cold Drink - 50");
        System.out.println("0. Exit");
    }

    void orderFood() {
        Scanner sc = new Scanner(System.in);

        do {
            showMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 0) break;

            System.out.print("Enter quantity: ");
            qty = sc.nextInt();

            switch (choice) {
                case 1: total += 200 * qty; break;
                case 2: total += 100 * qty; break;
                case 3: total += 150 * qty; break;
                case 4: total += 50 * qty; break;
                default: System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    void generateBill() {
        System.out.println("\n--- BILL ---");
        System.out.println("Customer: " + name);
        System.out.println("Table No: " + tableNo);
        System.out.println("Total Amount: " + total);
    }

    // Interface Method
    public void giveFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give Feedback (Good/Average/Bad): ");
        String fb = sc.nextLine();

        System.out.println("Thank you for your feedback: " + fb);
    }
}

// Main Class
public class RestaurantProject {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Order obj = new Order();

        int ch;

        try {
            do {
                System.out.println("\n===== RESTAURANT SYSTEM =====");
                System.out.println("1. Book Table");
                System.out.println("2. Order Food");
                System.out.println("3. Generate Bill");
                System.out.println("4. Give Feedback");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (ch) {
                    case 1: obj.bookTable(); break;
                    case 2: obj.orderFood(); break;
                    case 3: obj.generateBill(); break;
                    case 4: obj.giveFeedback(); break;
                    case 0: System.out.println("Thank you! Visit Again"); break;
                    default: System.out.println("Invalid choice");
                }

            } while (ch != 0);

        } catch (Exception e) {
            System.out.println("Invalid Input! Restart Program.");
        }
    }
}