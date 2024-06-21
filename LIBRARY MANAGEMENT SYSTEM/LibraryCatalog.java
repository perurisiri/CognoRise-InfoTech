import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnBook() {
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}

class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.checkOut();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.returnBook();
                return true;
            }
        }
        return false;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        
        // Adding books to the catalog
        catalog.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        catalog.addBook(new Book("1984", "George Orwell"));
        catalog.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        
        // Searching for books by title
        System.out.println("Search by title '1984': " + catalog.searchByTitle("1984"));
        
        // Searching for books by author
        System.out.println("Search by author 'George Orwell': " + catalog.searchByAuthor("George Orwell"));
        
        // Checking out a book
        if (catalog.checkOutBook("1984")) {
            System.out.println("'1984' has been checked out.");
        } else {
            System.out.println("'1984' is not available for check out.");
        }
        
        // Trying to check out the same book again
        if (catalog.checkOutBook("1984")) {
            System.out.println("'1984' has been checked out.");
        } else {
            System.out.println("'1984' is not available for check out.");
        }
        
        // Returning a book
        if (catalog.returnBook("1984")) {
            System.out.println("'1984' has been returned.");
        } else {
            System.out.println("'1984' was not checked out.");
        }
        
        // Display all books
        catalog.displayBooks();
    }
}
