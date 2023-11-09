import java.util.ArrayList;
import java.util.Scanner;

class VirtualItem {
    private int itemID;
    private String name;
    private double price;
    private int points;

    public VirtualItem(int itemID, String name, double price, int points) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.points = points;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "VirtualItem{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", points=" + points +
                '}';
    }
}

class PowerUp extends VirtualItem {
    private String effect;

    public PowerUp(int itemID, String name, double price, int points, String effect) {
        super(itemID, name, price, points);
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "PowerUp{" +
                "effect='" + effect + '\'' +
                "} " + super.toString();
    }
}

class Decoration extends VirtualItem {
    private String theme;

    public Decoration(int itemID, String name, double price, int points, String theme) {
        super(itemID, name, price, points);
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "theme='" + theme + '\'' +
                "} " + super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<VirtualItem> items = new ArrayList<>();
        items.add(new PowerUp(1, "Double Points", 10.0, 20, "Double the points earned"));
        items.add(new PowerUp(2, "Extra Life", 15.0, 30, "Gain an extra life"));
        items.add(new Decoration(3, "Space Theme", 5.0, 10, "Space-themed decoration"));
        items.add(new Decoration(4, "Fantasy Theme", 7.0, 15, "Fantasy-themed decoration"));

        Scanner scanner = new Scanner(System.in);
        int points = 100;
        ArrayList<VirtualItem> cart = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to the Shopping Game!");
            System.out.println("You have " + points + " points.");
            System.out.println("Please choose an option:");
            System.out.println("1. Shop for virtual items");
            System.out.println("2. Display the details of items in the shopping cart");
            System.out.println("3. Calculate and display the total points earned through purchased items");
            System.out.println("4. Apply a discount to the total price for purchasing multiple items");
            System.out.println("5. Track and display the remaining points");
            System.out.println("6. Quit the game");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Please choose an item to add to your cart:");
                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ". " + items.get(i).getName() + " (" + items.get(i).getPoints() + " points)");
                }
                int itemChoice = scanner.nextInt();
                if (itemChoice > 0 && itemChoice <= items.size()) {
                    VirtualItem item = items.get(itemChoice - 1);
                    if (points >= item.getPrice()) {
                        cart.add(item);
                        points -= item.getPrice();
                        System.out.println("Added " + item.getName() + " to your cart.");
                    } else {
                        System.out.println("You don't have enough points to buy " + item.getName() + ".");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (choice == 2) {
                System.out.println("Items in your cart:");
                for (VirtualItem item : cart) {
                    System.out.println(item.getName() + " (" + item.getPoints() + " points)");
                }
            } else if (choice == 3) {
                int totalPoints = 0;
                for (VirtualItem item : cart) {
                    totalPoints += item.getPoints();
                }
                System.out.println("Total points earned through purchased items: " + totalPoints);
            } else if (choice == 4) {
                double totalPrice = 0;
                for (VirtualItem item : cart) {
                    totalPrice += item.getPrice();
                }
                System.out.println("Total price before discount: " + totalPrice);
                if (cart.size() >= 3) {
                    totalPrice *= 0.9;
                    System.out.println("Discount applied: 10%");
                }
                System.out.println("Total price after discount: " + totalPrice);
            } else if (choice == 5) {
                System.out.println("Remaining points: " + points);
            } else if (choice == 6) {
                System.out.println("Thanks for playing!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

