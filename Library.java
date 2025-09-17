public class Library {

    public void borrowBook(String bookTitle, int availableCopies, int userId, String userRole)
            throws BookNotAvailableException {

        if (userId < 0) {
            throw new InvalidUserException("Invalid user ID: " + userId);
        }

        if (userRole == null || (!userRole.equalsIgnoreCase("student") && !userRole.equalsIgnoreCase("faculty"))) {
            throw new InvalidUserException("Invalid user role: " + userRole);
        }

        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new NullPointerException("Book title cannot be null or empty.");
        }

        if (availableCopies < 0) {
            throw new IllegalArgumentException("Available copies cannot be negative.");
        }

        if (availableCopies == 0) {
            throw new BookNotAvailableException("Book '" + bookTitle + "' is not available for borrowing.");
        }

        System.out.println("Book borrowed successfully: " + bookTitle + " by User ID: " + userId);
    }
    public void returnBook(String bookTitle, int userId) {

        if (userId < 0) {
            throw new InvalidUserException("Invalid user ID: " + userId);
        }

        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new NullPointerException("Book title cannot be null or empty.");
        }

        System.out.println("Book returned successfully: " + bookTitle + " by User ID: " + userId);
    }
}
