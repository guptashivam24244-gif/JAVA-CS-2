
import java.util.*;

class Product1 {
    int id;
    String name;
    double price;

    Product1(int i, String n, double p) {
        id = i;
        name = n;
        price = p;
    }
}

class CartItem {
    Product1 product;
    int quantity;

    CartItem(Product1 p, int q) {
        product = p;
        quantity = q;
    }
}

class ShoppingCart {

    private HashMap<Integer, CartItem> cart = new HashMap<>();

    // Add product to cart
    void addProduct(Product1 p, int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        if (cart.containsKey(p.id)) {
            cart.get(p.id).quantity += quantity;
        } else {
            cart.put(p.id, new CartItem(p, quantity));
        }

        System.out.println(p.name + " added to cart.");
    }

    // Update product quantity
    void updateQuantity(int id, int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        if (cart.containsKey(id)) {
            cart.get(id).quantity = quantity;
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Remove product
    void removeProduct(int id) {

        if (cart.containsKey(id)) {
            cart.remove(id);
            System.out.println("Product with id: " + id + " removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display cart and calculate bill
    void displayCart() {

        double subtotal = 0;

        System.out.println("\nProduct\t\tQuantity\tAmount");

        for (CartItem item : cart.values()) {

            double amount = item.product.price * item.quantity;

            subtotal += amount;

            System.out.println(item.product.name + "\t\t" +
                item.quantity + "\t\t" +
                String.format("%.2f", amount));
        }

        double discount = 0;

        if (subtotal >= 5000) {
            discount = subtotal * 0.10;
        } else if (subtotal >= 1000) {
            discount = subtotal * 0.05;
        }

        double finalAmount = subtotal - discount;

        System.out.println("----------------------------------");

        System.out.printf("Subtotal: %.2f%n", subtotal);

        System.out.printf("Discount: %.2f%n", discount);

        System.out.printf("Final Amount: %.2f%n", finalAmount);
    }
}

class ProductMain {
    public static void main(String[] args) {

        Product1 p1 = new Product1(1, "Keyboard", 800);
        Product1 p2 = new Product1(2, "Mouse", 700);
        Product1 p3 = new Product1(3, "Monitor", 4000);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1, 2);
        cart.addProduct(p2, 1);
        cart.addProduct(p3, 1);

        cart.addProduct(p2, 1);

        cart.updateQuantity(2, 1);

        cart.removeProduct(3);

        cart.displayCart();


    }
}
