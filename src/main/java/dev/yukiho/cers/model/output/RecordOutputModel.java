package dev.yukiho.cers.model.output;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordOutputModel {

    @Size(min = 11, max = 11)
    @ApiModelProperty(example = "\"12345678910\"", position = 0)
    private String id;

    @Size(min = 1, max = 50)
    @ApiModelProperty(example = "ﾀﾀﾞﾉ ｺｳｼﾞ", position = 1)
    private String name;

    @Pattern(regexp = "(enter|leave)")
    @ApiModelProperty(example = "enter or leave", position = 2)
    private String mode;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @ApiModelProperty(example = "2020-03-18T11:10:22+09:00", position = 3)
    private Date acceptedAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @ApiModelProperty(example = "2020-03-18T11:10:22+09:00", position = 4)
    private Date createdAt;
}
