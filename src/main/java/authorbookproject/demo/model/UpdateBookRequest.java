package authorbookproject.demo.model;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UpdateBookRequest {
    private String id;
    private String name;
    private String authorId;
    private String type;
    private int totalPage;
}
