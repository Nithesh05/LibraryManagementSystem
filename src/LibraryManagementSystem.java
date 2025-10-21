import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("✅ Book added successfully!");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\n📚 List of Books:");
            for (Book book : books) {
                System.out.println("- " + book);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println("✅ Book issued successfully!");
                return;
            }
        }
        System.out.println("⚠️ Book not found or already issued.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("✅ Book returned successfully!");
                return;
            }
        }
        System.out.println("⚠️ Book not found or not issued.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.showBooks();
                    break;
                case 3:
                    System.out.print("Enter title to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 4:
                    System.out.print("Enter title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    System.out.println("📕 Exiting... Thank you!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice, try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
