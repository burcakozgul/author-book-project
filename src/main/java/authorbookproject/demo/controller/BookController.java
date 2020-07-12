package authorbookproject.demo.controller;

import authorbookproject.demo.entity.Book;
import authorbookproject.demo.model.CreateBookRequest;
import authorbookproject.demo.model.UpdateBookRequest;
import authorbookproject.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest createBookRequest){
        bookService.createBook(createBookRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/id")
    public ResponseEntity<Book> getById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("/authorId")
    public ResponseEntity<List<Book>> getByAuthorId(@RequestParam(value = "id") String id){
        return ResponseEntity.ok(bookService.getByAuthorId(id));
    }

    @PutMapping("/id")
    public ResponseEntity<Book> updateBook(@RequestBody UpdateBookRequest updateBook) {
        return ResponseEntity.ok(bookService.updateBook(updateBook));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Book> deleteBook(@RequestParam(value = "id") String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
