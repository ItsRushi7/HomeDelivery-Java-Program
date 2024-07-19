import java.util.ArrayList;
import java.util.Scanner;

class GroceryItem {
    String name;
    double price;

    GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    ArrayList<GroceryItem> items = new ArrayList<>();
    double totalCost = 0;

    void addItem(GroceryItem item) {
        items.add(item);
        totalCost += item.price;
    }

    void viewOrder() {
        System.out.println("Order Summary:");
        for (GroceryItem item : items) {
            System.out.println(item.name + ": $" + item.price);
        }
        System.out.println("Total Cost: $" + totalCost);
    }
}

public class HomeDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        Order order = new Order();

        // Sample grocery items
        groceryList.add(new GroceryItem("Milk", 2.50));
        groceryList.add(new GroceryItem("Bread", 1.20));
        groceryList.add(new GroceryItem("Eggs", 3.00));
        groceryList.add(new GroceryItem("Apple", 0.50));
        groceryList.add(new GroceryItem("Banana", 0.30));

        while (true) {
            System.out.println("Home Delivery Service");
            System.out.println("1. View Available Items");
            System.out.println("2. Place Order");
            System.out.println("3. View Order Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Items:");
                    for (int i = 0; i < groceryList.size(); i++) {
                        GroceryItem item = groceryList.get(i);
                        System.out.println((i + 1) + ". " + item.name + ": $" + item.price);
                    }
                    break;
                case 2:
                    System.out.print("Enter the number of the item to add to your order: ");
                    int itemNumber = scanner.nextInt();
                    if (itemNumber > 0 && itemNumber <= groceryList.size()) {
                        GroceryItem item = groceryList.get(itemNumber - 1);
                        order.addItem(item);
                        System.out.println(item.name + " added to your order.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    break;
                case 3:
                    order.viewOrder();
                    break;
                case 4:
                    System.out.println("Thank you for using the Home Delivery Service.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
