package authorbookproject.demo;

import authorbookproject.demo.entity.Book;
import authorbookproject.demo.repository.BookRepository;
import authorbookproject.demo.service.BookService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getAllTest(){
        Mockito.when(bookRepository.findAll()).thenReturn(Stream
                .of(new Book("2wf53fasda13","The Alchemist","4354534dass5ad3","Novel",184)
                        ,new Book("5sd96dsda5","Eleven Minutes","4354534dass5ad3","Fiction",273))
                .collect(Collectors.toList()));
        Assert.assertEquals(2,bookService.getAllBook().size());
    }

}
