public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // 1. Borrowing a book with valid inputs
        try {
            library.borrowBook("Java Programming", 3, 101, "student");
        } catch (BookNotAvailableException | InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Borrowing a book with no available copies
        try {
            library.borrowBook("Data Structures", 0, 102, "faculty");
        } catch (BookNotAvailableException | InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Borrowing with invalid user credentials (negative ID)
        try {
            library.borrowBook("Algorithms", 5, -5, "student");
        } catch (BookNotAvailableException | InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Borrowing with invalid user role
        try {
            library.borrowBook("Operating Systems", 2, 103, "guest");
        } catch (BookNotAvailableException | InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Returning a book successfully
        try {
            library.returnBook("Database Systems", 104);
        } catch (InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 6. Triggering a NullPointerException with null book title
        try {
            library.returnBook(null, 105);
        } catch (InvalidUserException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram executed successfully without crashing!");
    }
}
