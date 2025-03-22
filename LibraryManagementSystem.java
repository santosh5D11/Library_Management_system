import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    BookDAO.addBook(bookId, title, author);
                    break;
                case 2:
                    BookDAO.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    BookDAO.deleteBook(deleteId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Person's Name: ");
                    String issuedTo = scanner.nextLine();
                    IssueBookDAO.issueBook(issueId, issuedTo);
                    break;
                case 5:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = scanner.nextInt();
                    IssueBookDAO.returnBook(returnId);
                    break;
                case 6:
                    IssueBookDAO.displayIssuedBooks();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you! 😊");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }
    }
}
