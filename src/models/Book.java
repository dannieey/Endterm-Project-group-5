package models;

public class Book {
  private String title;
    private String author;
    private String genre;
    private int yearOfPublication;
    private boolean isAvailableForPurchase;

    public Book(String title, String author, String genre, int yearOfPublication, boolean isAvailableForPurchase) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.isAvailableForPurchase = isAvailableForPurchase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public boolean isAvailableForPurchase() {
        return isAvailableForPurchase;
    }

    public void setAvailableForPurchase(boolean availableForPurchase) {
        isAvailableForPurchase = availableForPurchase;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Year of Publication: " + yearOfPublication);
        System.out.println("Available for Purchase: " + (isAvailableForPurchase ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, true);

        book1.displayBookDetails();
    }
}
