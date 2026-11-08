//  4. Library Book Inventory Using ArrayList //
import java.util.ArrayList;

class Book {
    String isbn, title, author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

 class BookMain {
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(" Adding Books ");
        addBook(new Book("B101", "The Java Handbook", "Tom Henry", 29.99));
        addBook(new Book("B102", "Data Structures", "Jane Doe", 45.50));
        addBook(new Book("B103", "Algorithms", "Matt Henry", 45.50));
        addBook(new Book("B101", "Duplicate Book", "Test", 10.00)); // Test Requirement 5

        System.out.println(" Searching ISBN B102 ");
        searchBook("B102");

        System.out.println(" Removing ISBN B101 ");
        removeBook("B101");

        System.out.println(" Displaying Remaining Books ");
        displayAll();
    }

    static void addBook(Book newBook) {
        for (Book b : books) {
            if (b.isbn.equals(newBook.isbn)) {
                System.out.println("Error: ISBN " + newBook.isbn + " already exists!");
                return; 
            }
        }
        books.add(newBook);
        System.out.println("Added: " + newBook.title);
    }

    static void searchBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn)) {
                System.out.println("Found: " + b.title + " by " + b.author);
            }
        }
    }

    static void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn.equals(isbn)) {
                System.out.println("Removed: " + books.get(i).title);
                books.remove(i);
                break; 
            }
        }
    }

    static void displayAll() {
        for (Book b : books) {
            System.out.println(b.isbn + " | " + b.title + " | $" + b.price);
        }
    }
}
