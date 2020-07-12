package authorbookproject.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "Book")
public class Book {


    @Id
    private String id;

    private String bookName;
    private String authorId;
    private String type;
    private int totalPage;
}
