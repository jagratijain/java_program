import java.util.*;

abstract class HostelItem {
    protected String name;
    protected double price;

    public HostelItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayItem();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

final class Room extends HostelItem {
    private int roomNumber;

    public Room(String name, double price, int roomNumber) {
        super(name, price);
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayItem() {
        System.out.println("Room: " + name + " (Room Number: " + roomNumber + "), Price: Rs" + price);
    }

    public void bookRoom() {
        System.out.println("--------------------------------");
        System.out.println("Booking room: " + roomNumber);
        System.out.println("--------------------------------");
    }
}

final class Meal extends HostelItem {
    private String type;

    public Meal(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public void displayItem() {
        System.out.println("Meal: " + name + " (Type: " + type + "), Price: Rs" + price);
    }

    public void customizeMeal(String preference) {
        System.out.println("--------------------------------");
        System.out.println("Customizing meal with " + preference);
        System.out.println("--------------------------------");
    }
}

public class lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueBooking = true;

        while (continueBooking) {
            System.out.println("\n\n\t --------------------Welcome to the HostelBookingApp !!--------------------\n\n");
            System.out.println("Select an option:");
            System.out.println("1. Room Booking");
            System.out.println("2. Meal Booking");
            System.out.println("3. Exit");
            System.out.println("-----------------------------------------------------------------------------");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookRoom(scanner);
                    break;
                case 2:
                    customizeMeal(scanner);
                    break;
                case 3:
                    continueBooking = false;
                    System.out.println("\n\n\t --------------Thank you for using HostelBookingApp.-------------- \n\t\t --------------Exiting!!!--------------");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void bookRoom(Scanner scanner) {
        System.out.print("Enter  name: ");
        String roomName = scanner.nextLine();

        System.out.print("Enter room price: ");
        double roomPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room room = new Room(roomName, roomPrice, roomNumber);

        System.out.print("Do you want to book the room? (yes/no): ");
        String bookOption = scanner.nextLine();

        if (bookOption.equalsIgnoreCase("yes")) {
            room.bookRoom();
        }

        System.out.println("\nBooked Hostel Item:");
        room.displayItem();
        System.out.println("--------------------------------");
    }

    private static void customizeMeal(Scanner scanner) {
        System.out.print("Enter meal name: ");
        String mealName = scanner.nextLine();

        System.out.print("Enter meal price: ");
        double mealPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter quantity: ");
        String mealType = scanner.nextLine();

        Meal meal = new Meal(mealName, mealPrice, mealType);

        System.out.print("Do you want to customize the meal? (yes/no): ");
        String customizeOption = scanner.nextLine();

        if (customizeOption.equalsIgnoreCase("yes")) {
            System.out.print("Enter preference for customization: ");
            String preference = scanner.nextLine();
            meal.customizeMeal(preference);
        }

        System.out.println("\nCustomized Hostel Item:");
        meal.displayItem();
        System.out.println("--------------------------------");
    }
}
