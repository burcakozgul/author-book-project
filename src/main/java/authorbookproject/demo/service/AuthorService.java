package authorbookproject.demo.service;

import authorbookproject.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import authorbookproject.demo.entity.Author;
import authorbookproject.demo.exception.GeneralException;
import authorbookproject.demo.model.CreateAuthorRequest;
import authorbookproject.demo.model.UpdateAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void createAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author = Author.builder()
                .id(UUID.randomUUID().toString())
                .gender(createAuthorRequest.getGender())
                .name(createAuthorRequest.getName())
                .build();
        authorRepository.save(author);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }


    public Author getById(String id) {
        return authorRepository.findById(id)
                .orElseThrow(()-> new GeneralException("Author id is not found"));
    }

    public Author updateAuthor(UpdateAuthorRequest authorRequest) {
        Author author = authorRepository.findById(authorRequest.getId())
                .map(author1 -> {
                    author1.setName(authorRequest.getName());
                    author1.setGender(authorRequest.getGender());
                    return authorRepository.save(author1);
                })
                .orElseThrow(()-> new GeneralException("Author id is not found"));
        return author;

    }

    public void deleteAuthor(String id) {
        Author author = authorRepository.findById(id)
                    .orElseThrow(()-> new GeneralException("Author id is not found"));
        authorRepository.deleteById(id);
    }
}