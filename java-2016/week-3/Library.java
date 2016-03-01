// A test driver for the Novels and albums classes

public class Library {
   
   public static void main(String[] args) {
      
	  Novels dummy_novel = new Novels("LOTR", "fantasy", 152);
      System.out.println(dummy_novel);  
	  
	  
	  dummy_novel.getTitle();
	  dummy_novel.getType();
	  dummy_novel.getPageNumber();
	  System.out.println(dummy_novel); 
	  
	 
	  
	  Albums dummy_album = new Albums("Monet", "gold", 352);
      System.out.println(dummy_album);  
	  
	  dummy_album.getTitle();
	  dummy_album.getQuality();
	  dummy_album.getPageNumber();
	  System.out.println(dummy_album);
	  
	  
   }
}