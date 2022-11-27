package online.lahiru.sprinngbotrestapi.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel(description = "Post model infomation")
@Data
public class PostDTO {
    @ApiModelProperty(value = "Blog post Id")
    private Long id;

    @ApiModelProperty(value = "Blog post title")
    @NotEmpty
    @Size(min = 2,message = "Post title should have at least two charactors")
    private String title;

    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 10,message = "you need to add at least 10 charactors")
    private String description;

    @NotEmpty
    @ApiModelProperty(value = "Blog post contents")
    private String content;
    @ApiModelProperty(value = "Blog post comments")
    private Set<CommentDTO> comments;



}
