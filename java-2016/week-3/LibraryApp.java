


public class LibraryApp {
    
    public static void main(String...args) {
        
		Library library = new Library();
		Novel novel = new Novel("test", "test", "test");
		Album album = new Album ("test", "test", "test");
		
		library.addNovel(novel);
		library.addAlbum(album);
		library.listContent();
		library.deleteNovel(novel);
		library.deleteAlbum(album);
		library.listContent();
		
		
    }
    
}