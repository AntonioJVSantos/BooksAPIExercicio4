package AntonioSantos.Exercicio4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AntonioSantos.Exercicio4.Db.BooksDB;
import AntonioSantos.Exercicio4.Model.Book;
import AntonioSantos.Exercicio4.Model.BookSemID;
@Service
public class BookService {
    private final BooksDB booksDB;

    public BookService(@Autowired BooksDB booksDB) {
        this.booksDB = booksDB;
    }

    public Book getOneBook(String id) throws Exception {
        return booksDB.getOneBook(id);
    }
    public List<Book> getAllBooks() {
        
        return booksDB.getBooks();
    }
    public Book updateBook(String id, BookSemID book) throws Exception {
        
        return booksDB.updateBook(id, book);
    }

    public Book deleteBook(String id) throws Exception {
        return booksDB.deleteBook(id);
    }

    public Book addBook(Book book) {

        return booksDB.addBook(book);
    }
    public Book getSpecBook(String author,String title)throws Exception{
        return booksDB.getSpecBook(author,title);
    }
                
}
