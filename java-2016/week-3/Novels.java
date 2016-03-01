import java.util.Scanner;


public class Novels {

  
  //Private variables
  
   private String title; 
   private String type;
   private int pageNumber;
  
   static Scanner userInput = new Scanner(System.in);
   
 //Constructor for the novel
  
   public  Novels (String title, String type, int pageNumber){
	   this.title = title;
	   this.type = type;
	   this.pageNumber = pageNumber;
   }

 
  //Public methods for Title, Type, Page Number
  
    public String getTitle(){  
	System.out.println("Enter the name of the novel: ");
    title = userInput.nextLine();
	return title; 
	}
    
	public String getType(){
	System.out.println("Enter the type of the novel: ");
    type = userInput.nextLine();
	return type;  
	}
    
	public int getPageNumber(){
	System.out.println("Enter the page number for the novel: ");
    pageNumber = userInput.nextInt();
	return pageNumber;  }
        
    public String toString() {
      return title + " it's a " + type + " book of " + pageNumber + " pages.";
   }   
  }
  
  
  
  