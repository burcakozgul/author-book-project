package authorbookproject.demo.service;

import authorbookproject.demo.entity.Book;
import authorbookproject.demo.exception.GeneralException;
import authorbookproject.demo.repository.BookRepository;
import authorbookproject.demo.model.CreateBookRequest;
import authorbookproject.demo.model.UpdateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    public void createBook(CreateBookRequest createBookRequest) {
        Book book = Book.builder()
                .id(UUID.randomUUID().toString())
                .bookName(createBookRequest.getName())
                .authorId(createBookRequest.getAuthorId())
                .type(createBookRequest.getType())
                .totalPage(createBookRequest.getTotalPage())
                .build();
        bookRepository.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();

    }

    public Book getById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(()->new GeneralException("Book is not found"));


    }

    public Book updateBook(UpdateBookRequest bookRequest) {
        Book book=bookRepository.findById(bookRequest.getId())
                .map(book1 -> {
                    book1.setBookName(bookRequest.getName());
                    book1.setAuthorId(bookRequest.getAuthorId());
                    book1.setType(bookRequest.getType());
                    book1.setTotalPage(bookRequest.getTotalPage());
                    return bookRepository.save(book1);
                })
                .orElseThrow(()-> new GeneralException("Book is not found"));
        return book;
    }

    public void deleteBook(String  id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new GeneralException("Book is not found"));
        bookRepository.deleteById(id);
    }

    public List<Book> getByAuthorId(String id) {
        return bookRepository.findByAuthorId(id);
    }
}
