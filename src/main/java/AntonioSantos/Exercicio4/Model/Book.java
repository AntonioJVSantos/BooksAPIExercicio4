package AntonioSantos.Exercicio4.Model;

public class Book {
    
    private String title;
    private String id;
    private String author;
    public Book(String title, String id, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }

    
    
}
