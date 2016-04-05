package ro.sci.bookstore;

public class Book {

	private String title;
	private String genre;
	private String author;
	private int weight;
	private long isbn;
	private double price;

	public Book(int isbn2) {
		this.isbn=isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void add(Book cartEntryBook) {
		// TODO Auto-generated method stub
		
	}

	//quantity = quantity.cartEntry.setQuantity();

	





}
