import java.util.Scanner;


public class Novel {

  
  //Private variables
  
   private String title; 
   private String type;
   private String pageNumber;
  
   static Scanner userInput = new Scanner(System.in);
   
 //Constructor for the novel
  
   public  Novel (String title, String type, String pageNumber){
	   this.title = title;
	   this.type = type;
	   this.pageNumber = pageNumber;
   }

 
  //Public methods for Title, Type, Page Number
  
    public String getTitle(){  
	System.out.println("Enter the title of the novel: ");
    title = userInput.nextLine();
	return title; 
	}
    
	public String getType(){
	System.out.println("Enter the type of the novel: ");
    type = userInput.nextLine();
	return type;  
	}
    
	public String getPageNumber(){
	System.out.println("Enter the page number for the novel: ");
    pageNumber = userInput.nextLine();
	return pageNumber;  }
  

}
  
  
  
  