package ro.sci.bookstore;

/**
 * 
 * @author Ovidiu Popa This is a class that defines the Cart Entry which has: 
 * 			book - defined in Book class. 
 * 			quantityToBuy - defined in this class.
 *        
 */

public class CartEntry {

	Book book = new Book(0);
	private int quantityToBuy;
	
	
	public int getQuantityToBuy() {
		return quantityToBuy;
	}
	public void setQuantityToBuy(int quantityToBuy) {
		this.quantityToBuy = quantityToBuy;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
