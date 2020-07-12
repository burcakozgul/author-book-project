package authorbookproject.demo.model;

import lombok.Data;



@Data
public class CreateBookRequest {
    private String name;
    private String authorId;
    private String type;
    private int totalPage;
}
