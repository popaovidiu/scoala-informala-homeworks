// A test driver for Library

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
   
   
    // CODE REVIE - all class member names have to be camelCased!
	ArrayList<String> library_books = new ArrayList<String>(); 
	ArrayList<String> library_albums = new ArrayList<String>(); 
	Novel dummy_novel = new Novel("","","");
	Album dummy_album = new Album("","","");
	Scanner input = new Scanner(System.in);
	
	
	//Library is populated with objects: novels and albums
	
	public void addNovel(Novel novel){	
		
		System.out.println("How many novels are there in the library?   ");
		int novelNumbers = input.nextInt();
	
		for (int i=0; i<novelNumbers; i++){
			String title = dummy_novel.getTitle();
			String type = dummy_novel.getType();
			String pageNumber = dummy_novel.getPageNumber();
			library_books.add(title);
			library_books.add(type);
			library_books.add(pageNumber);
			}
		System.out.println("------------------------------------------------------------");//For me to monitor the console more easily
	}
	
	public void addAlbum(Album album){ 		
		System.out.println("How many art albums are there in the library?   ");
		int albumNumbers = input.nextInt();
	
		for (int i=0; i<albumNumbers; i++){
			String title = dummy_album.getTitle();
			String quality = dummy_album.getQuality();
			String pageNumber = dummy_album.getPageNumber();
			library_albums.add(title);
			library_albums.add(quality);
			library_albums.add(pageNumber);
			}
		System.out.println("------------------------------------------------------------");//For me to monitor the console more easily
	}
	//The content of the library is listed
	
	public void listContent(){
		int bookNumber = 1;
		System.out.println("The novels are:");
		for (int i=0; i< library_books.size();i=i+3){
			System.out.println("Catalog number "+bookNumber+": " + library_books.get(i) +" "+library_books.get(i+1)+" "+library_books.get(i+2));
			bookNumber++;
			}
		System.out.println("------------------------------------------------------------");//For me to monitor the console more easily
		
		int albumNumber = 1;
		System.out.println("The art albums are:");
		for (int i=0; i< library_albums.size();i=i+3){
			System.out.println("Catalog number "+albumNumber+": " + library_albums.get(i) +" "+library_albums.get(i+1)+" "+library_albums.get(i+2));
			albumNumber++;
			}
		System.out.println("------------------------------------------------------------");//For me to monitor the console more easily
	}
	
	
	//Some of the content is removed
	
	
	public void deleteNovel(Novel novel){
		System.out.println("Do you want to delete a novel from the library? 1=yes/0=no"); 
		int deleteChoiceNovel = input.nextInt();
	
		if (deleteChoiceNovel == 1){
			System.out.println("What novel do you want to delete (type the catalog number): ");
			int novelCatalogNumber = input.nextInt();
			library_books.remove(3*novelCatalogNumber-3);
			library_books.remove(3*novelCatalogNumber-3);
			library_books.remove(3*novelCatalogNumber-3);
		}
	}

	public void deleteAlbum(Album album){
		System.out.println("Do you want to delete an art album from the library? 1=yes/0=no"); 
		int deleteChoiceAlbum = input.nextInt();	
		if (deleteChoiceAlbum == 1){	
			System.out.println("What art album do you want to delete (type the catalog number): ");
			int albumCatalogNumber = input.nextInt();
			library_albums.remove(3*albumCatalogNumber-3);
			library_albums.remove(3*albumCatalogNumber-3);
			library_albums.remove(3*albumCatalogNumber-3);
			 
		} 
	}	
		
	 
	 

}
