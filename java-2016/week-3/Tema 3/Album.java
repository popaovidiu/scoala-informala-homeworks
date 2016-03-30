import java.util.Scanner;


public class Album {

  
  //Private variables
  
   private String title; 
   private String quality;
   private String pageNumber;
  
    // CODE REVIEW - Since when does an album read a user input? Does the real-life object do this?
   static Scanner userInput = new Scanner(System.in);
   
 //Constructor for the Album
  
   public  Album (String title, String quality, String pageNumber){
	   this.title = title;
	   this.quality = quality;
	   this.pageNumber = pageNumber;
   }

 
  //Public methods for Title, Quality, Page Number
  
    public String getTitle(){  
        // CODE REVIEW - if every time you call this method, you force the user to input a value, this object is basically stateless and has no value.
	System.out.println("Enter the title of the art album: ");
    title = userInput.nextLine();
	return title; 
	}
    
	public String getQuality(){
	System.out.println("Enter the quality of the art album (gold/silver/bronze): ");
    quality = userInput.nextLine();
	return quality;  
	}
    
	public String getPageNumber(){
	System.out.println("Enter the page number for the art album: ");
    pageNumber = userInput.nextLine();
	return pageNumber;  }
    
  }
  
  
  
  