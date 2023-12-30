class Book {
    String title;
    String author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added: " + newBook.title);
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title) && book.available) {
                book.available = false;
                System.out.println("Book borrowed: " + book.title);
                return;
            }
        }
        System.out.println("Book not available for borrowing: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title) && !book.available) {
                book.available = true;
                System.out.println("Book returned: " + book.title);
                return;
            }
        }
        System.out.println("Book not borrowed or already returned: " + title);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.available) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("To Kill a Mockingbird", "Harper Lee");

        library.displayAvailableBooks();

        library.borrowBook("The Great Gatsby");

        library.displayAvailableBooks();

        library.returnBook("The Great Gatsby");

        library.displayAvailableBooks();
    }
}
