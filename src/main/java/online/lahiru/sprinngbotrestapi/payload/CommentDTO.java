package online.lahiru.sprinngbotrestapi.payload;

import lombok.Data;

@Data

public class CommentDTO {
    private long id;
    private String name;
    private String emial;
    private String body;

}
