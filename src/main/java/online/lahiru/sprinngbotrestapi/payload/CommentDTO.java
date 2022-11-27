package online.lahiru.sprinngbotrestapi.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Api(value = "Comment model information")
public class CommentDTO {
    @ApiModelProperty(value = "Comment id")
    private long id;

    @ApiModelProperty(value = "Comment name")
    @NotEmpty(message = "name should not be empty")
    private String name;

    @ApiModelProperty(value = "Comment email")
    @NotEmpty(message = "email should not be empty")
    @Email
    private String emial;
    @NotEmpty
    @Size(min = 10, message = "you need to add minimum 10 charactors")
    @ApiModelProperty(value = "Comment body")
    private String body;

}
