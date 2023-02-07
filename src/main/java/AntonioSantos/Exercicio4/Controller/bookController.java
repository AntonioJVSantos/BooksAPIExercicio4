package AntonioSantos.Exercicio4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AntonioSantos.Exercicio4.Model.Book;
import AntonioSantos.Exercicio4.Model.BookSemID;
import AntonioSantos.Exercicio4.Service.BookService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/BooksAPI")
public class bookController {
    private final BookService bibliotecario;


    public bookController(@Autowired BookService bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    @PostMapping
    public Book insert(@RequestBody Book book){
        return bibliotecario.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bibliotecario.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getOneBook(HttpServletResponse servlet,@PathVariable String id){
        try{
            return bibliotecario.getOneBook(id);
        }catch(Exception e){
            servlet.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        
    }
    @PutMapping("/{id}")
    public Book updatBook(HttpServletResponse servlet,@PathVariable String id,@RequestBody BookSemID book){
        try{
            return bibliotecario.updateBook(id, book);
        }catch(Exception e){
            servlet.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println(e);
            return null;
        }
        
    }
    @DeleteMapping("/{id}")
    public Book deleteBook(HttpServletResponse servlet,@PathVariable String id){
        try{
            return bibliotecario.deleteBook(id);
        }catch(Exception e){
            servlet.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;            
        }
        
    }
    @GetMapping("/Params")
    public Book getSpecificBook(HttpServletResponse servlet,@RequestParam String author,@RequestParam String title){
        try{
            return bibliotecario.getSpecBook(author,title);
        }catch(Exception e){
            servlet.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;            
        }
    }
       

}


