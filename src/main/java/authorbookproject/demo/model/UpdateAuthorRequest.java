package authorbookproject.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAuthorRequest {
    private String id;
    private String name;
    private String gender;
}
