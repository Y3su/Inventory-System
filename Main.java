import java.util.InputMismatchException;
import java.util.Scanner;

// Main class to interact with the user and manage the inventory system.
public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager(); // Initialize inventory manager.
        Scanner scanner = new Scanner(System.in); // Scanner to read user input.

        boolean running = true; // Flag to control the loop.

        // Main loop to display the menu and process user choices.
        while (running) {
            try {
                // Display menu
                System.out.println("Options:");
                System.out.println("[1] Add Single Product");
                System.out.println("[2] Add Box Product");
                System.out.println("[3] Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        // Add single product
                        System.out.print("Brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        inventory.add(new SingleProduct(brand), quantity);
                        System.out.println("Added " + quantity + " single product(s) of brand: " + brand);
                        break;

                    case 2:
                        // Add box product
                        System.out.print("Brand: ");
                        String boxBrand = scanner.nextLine();

                        System.out.print("Items in Box: ");
                        int itemsInBox = scanner.nextInt();

                        System.out.print("Number of Boxes: ");
                        int boxQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        inventory.add(new BoxedProduct(boxBrand, itemsInBox), boxQuantity);
                        System.out.println("Added " + boxQuantity + " box(es) of brand: " + boxBrand + " with " + itemsInBox + " items each.");
                        break;

                    case 3:
                        // Display inventory report and exit
                        System.out.println("\n=======================");
                        System.out.println("|  Inventory Report   |");
                        System.out.println("=======================");

                        for (String brandName : inventory.getBrands()) {
                            int singleCount = inventory.getSingles(brandName).size(); // Count of single items
                            int boxCount = inventory.getBoxes(brandName).size(); // Count of boxes
                            int totalBoxedItems = inventory.getBoxes(brandName).stream() // Sum of items in all boxes
                                    .mapToInt(BoxedProduct::getQuantity).sum();

                            int totalPieces = singleCount + totalBoxedItems; // Total pieces for the brand

                            // Print the inventory report for each brand
                            System.out.println("\nBrand: " + brandName);
                            System.out.println("Singles: " + singleCount);
                            System.out.println("Boxes: " + boxCount);
                            System.out.println("Total Pieces: " + totalPieces);
                        }
                        running = false; // Exit the loop
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                // Catch invalid input (e.g., non-integer choices)
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        scanner.close(); // Close scanner
    }
}
