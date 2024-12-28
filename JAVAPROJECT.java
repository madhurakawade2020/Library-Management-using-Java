import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Add a new book to the library
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // View all books in the library
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author +
                        ", Issued: " + (book.isIssued ? "Yes" : "No"));
            }
        }
    }

    // Issue a book to a user
    public void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isIssued) {
                    System.out.println("Book is already issued.");
                } else {
                    book.isIssued = true;
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book to the library
    public void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Display the main menu
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.displayMenu();
    }
}
