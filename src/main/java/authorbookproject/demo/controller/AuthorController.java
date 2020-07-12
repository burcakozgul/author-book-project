package authorbookproject.demo.controller;

import authorbookproject.demo.entity.Author;
import authorbookproject.demo.model.CreateAuthorRequest;
import authorbookproject.demo.model.UpdateAuthorRequest;
import authorbookproject.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        authorService.createAuthor(createAuthorRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Author> getById(@RequestParam(value = "id") String id){
        return ResponseEntity.ok(authorService.getById(id));
    }

    @PutMapping()
    public ResponseEntity<Author> updateAuthor(@RequestBody UpdateAuthorRequest updateAuthorRequest){
        return ResponseEntity.ok(authorService.updateAuthor(updateAuthorRequest));
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteAuthor(@RequestParam(value = "id") String id){
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
