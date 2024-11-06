// Class representing a boxed product with a brand name and quantity.
public class BoxedProduct {
    private String brand; // Brand name of the boxed product.
    private int quantity; // Number of items in the box.

    // Constructor to initialize the brand and quantity of the boxed product.
    public BoxedProduct(String brand, int quantity) {
        this.brand = brand;
        this.quantity = quantity;
    }

    // Method to return the brand name of the boxed product.
    public String getBrand() {
        return brand;
    }

    // Method to return the number of items in the box.
    public int getQuantity() {
        return quantity;
    }
}
