import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class to manage inventory containing both single products and boxed products.
public class InventoryManager {
    private List<SingleProduct> singles; // List of individually packed single products.
    private List<BoxedProduct> boxes; // List of boxed products.

    // Constructor to initialize the inventory lists.
    public InventoryManager() {
        singles = new ArrayList<>();
        boxes = new ArrayList<>();
    }

    // Add a single product to the inventory.
    public void add(SingleProduct p) {
        singles.add(p);
    }

    // Add multiple single products to the inventory.
    public void add(SingleProduct p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            singles.add(new SingleProduct(p.getBrand()));
        }
    }

    // Add a boxed product to the inventory.
    public void add(BoxedProduct p) {
        boxes.add(p);
    }

    // Add multiple boxed products to the inventory.
    public void add(BoxedProduct p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            boxes.add(new BoxedProduct(p.getBrand(), p.getQuantity()));
        }
    }

    // Get a list of all unique brands in the inventory.
    public String[] getBrands() {
        Map<String, Boolean> brandMap = new HashMap<>();
        for (SingleProduct single : singles) {
            brandMap.put(single.getBrand(), true);
        }
        for (BoxedProduct box : boxes) {
            brandMap.put(box.getBrand(), true);
        }
        return brandMap.keySet().toArray(new String[0]);
    }

    // Get all boxes of a specific brand.
    public List<BoxedProduct> getBoxes(String brand) {
        List<BoxedProduct> brandBoxes = new ArrayList<>();
        for (BoxedProduct box : boxes) {
            if (box.getBrand().equals(brand)) {
                brandBoxes.add(box);
            }
        }
        return brandBoxes;
    }

    // Get all individually packed items of a specific brand.
    public List<SingleProduct> getSingles(String brand) {
        List<SingleProduct> brandSingles = new ArrayList<>();
        for (SingleProduct single : singles) {
            if (single.getBrand().equals(brand)) {
                brandSingles.add(single);
            }
        }
        return brandSingles;
    }
}
