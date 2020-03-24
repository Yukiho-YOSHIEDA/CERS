package dev.yukiho.cers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordModel {
    private String id;

    private String name;

    private Integer mode;

    private Date acceptedAt;

    private Date createdAt;
}
