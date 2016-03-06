import java.util.Scanner;


public class Album {

  
  //Private variables
  
   private String title; 
   private String quality;
   private String pageNumber;
  
   static Scanner userInput = new Scanner(System.in);
   
 //Constructor for the Album
  
   public  Album (String title, String quality, String pageNumber){
	   this.title = title;
	   this.quality = quality;
	   this.pageNumber = pageNumber;
   }

 
  //Public methods for Title, Quality, Page Number
  
    public String getTitle(){  
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
  
  
  
  