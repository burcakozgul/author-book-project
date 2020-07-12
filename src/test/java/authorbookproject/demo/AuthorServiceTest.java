package authorbookproject.demo;

import authorbookproject.demo.entity.Author;
import authorbookproject.demo.model.CreateAuthorRequest;
import authorbookproject.demo.repository.AuthorRepository;
import authorbookproject.demo.service.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Before
    public void setUp() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    public void createAuthorTest(){
        CreateAuthorRequest request = CreateAuthorRequest.builder()
                .name("Paulo Cello")
                .gender("male")
                .build();
        authorService.createAuthor(request);
        Author author = Author.builder()
                .id(UUID.randomUUID().toString())
                .name("Paulo Cello")
                .gender("male")
                .build();
        authorRepository.save(author);
        verify(authorRepository, Mockito.times(1)).save(author);
    }
}
