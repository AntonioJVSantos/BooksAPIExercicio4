package AntonioSantos.Exercicio4.Db;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import AntonioSantos.Exercicio4.Model.Book;
import AntonioSantos.Exercicio4.Model.BookSemID;

@Component
public class BooksDB {
    private final HashMap<String,Book> booksDB;

    public BooksDB() {
        
        this.booksDB = new HashMap<>();

    }

    public Book getOneBook(String id) throws Exception {
        if(!booksDB.containsKey(id))
            throw new Exception("Could not Find any Book with id: "+id);  
        return booksDB.get(id);
    }

    public List<Book> getBooks(){
        return booksDB.values().stream().toList();
    }
    public Book updateBook(String id, BookSemID book) throws Exception{
        if(!booksDB.containsKey(id))
            throw new Exception("Could not Find any Book with id: "+id);        
        Book bookTemp= new Book(book.getTitle(),id,book.getAuthor());
        booksDB.put(id, bookTemp);                            
        return bookTemp;
    }
    public Book deleteBook(String id) throws Exception {
        if(!booksDB.containsKey(id))
            throw new Exception("Could not Find any Book with id: "+id);            

        Book bookTemp=booksDB.get(id);
        booksDB.remove(id);                       
        return bookTemp;
    }
    public Book addBook(Book book) {
        booksDB.put(book.getId(), book);
        return book;
    }
    public Book getSpecBook(String author,String title)throws Exception{        
        for(var entry:booksDB.entrySet()){
            if(entry.getValue().getAuthor().equalsIgnoreCase(author) && entry.getValue().getTitle().equalsIgnoreCase(title)){
                return entry.getValue();
            }            
        }
        throw new Exception("Could not Find any Book with Spoecified PArams");        
    }




    

}
