package com.Zh.photosclone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo {
    @Id
    private Integer id;

    @NotEmpty
    private String name;

    @JsonIgnore
    private byte [] arr;

    private String contentType;

}
