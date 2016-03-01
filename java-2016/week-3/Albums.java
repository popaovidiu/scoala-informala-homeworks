import java.util.Scanner;


public class Albums {

  
  //Private variables
  
   private String title; 
   private String quality;
   private int pageNumber;
  
   static Scanner userInput = new Scanner(System.in);
   
 //Constructor for the novel
  
   public  Albums (String title, String quality, int pageNumber){
	   this.title = title;
	   this.quality = quality;
	   this.pageNumber = pageNumber;
   }

 
  //Public methods for Title, Quality, Page Number
  
    public String getTitle(){  
	System.out.println("Enter the name of the art album: ");
    title = userInput.nextLine();
	return title; 
	}
    
	public String getQuality(){
	System.out.println("Enter the quality of the art album: ");
    quality = userInput.nextLine();
	return quality;  
	}
    
	public int getPageNumber(){
	System.out.println("Enter the page number for the art album: ");
    pageNumber = userInput.nextInt();
	return pageNumber;  }
        
    public String toString() {
      return title + " it's an art album witch have" + " '" + quality  + "' " + "quality and " + pageNumber + " pages.";
   }   
  }
  
  
  
  