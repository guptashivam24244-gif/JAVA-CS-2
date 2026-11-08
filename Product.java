// 5. Product Catalogue Using HashMap //
import java.util.HashMap;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Price: Rs." + price + " | Qty: " + quantity);
    }
}

 class Main {
    public static void main(String[] args) {
        HashMap<Integer, Product> catalogue = new HashMap<>();

        addProduct(catalogue, new Product(101, "Laptop", 899.99, 5));
        addProduct(catalogue, new Product(102, "Smartphone", 499.99, 10));
        
        addProduct(catalogue, new Product(101, "Tablet", 299.99, 3)); 

        System.out.println(" All Products in Catalogue:");
        displayAllProducts(catalogue);

        System.out.println(" Searching for Product 102:");
        searchProduct(catalogue, 102);


        System.out.println(" Updating price of Product 101:");
        updatePrice(catalogue, 101, 849.99);

        System.out.println(" Removing Product 102:");
        removeProduct(catalogue, 102);

        System.out.println(" Final Catalogue:");
        displayAllProducts(catalogue);
    }

    public static void addProduct(HashMap<Integer, Product> catalogue, Product p) {
        if (catalogue.containsKey(p.id)) {
            System.out.println("Error: Product ID " + p.id + " already exists. Duplicate not inserted.");
        } else {
            catalogue.put(p.id, p);
            System.out.println("Added: " + p.name);
        }
    }

    public static void searchProduct(HashMap<Integer, Product> catalogue, int id) {
        if (catalogue.containsKey(id)) {
            catalogue.get(id).display();
        } else {
            System.out.println("Product ID " + id + " not found.");
        }
    }

    public static void updatePrice(HashMap<Integer, Product> catalogue, int id, double newPrice) {
        if (catalogue.containsKey(id)) {
            catalogue.get(id).price = newPrice;
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Product ID " + id + " not found to update price.");
        }
    }

    public static void removeProduct(HashMap<Integer, Product> catalogue, int id) {
        if (catalogue.containsKey(id)) {
            catalogue.remove(id);
            System.out.println("Product ID " + id + " removed successfully.");
        } else {
            System.out.println("Product ID " + id + " not found.");
        }
    }

    public static void displayAllProducts(HashMap<Integer, Product> catalogue) {
        if (catalogue.isEmpty()) {
            System.out.println("Catalogue is empty.");
            return;
        }
        for (Product p : catalogue.values()) {
            p.display();
        }
    }
}
