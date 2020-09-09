package com.example.student.api.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {

    private static final long serialVersionUID = 4860812666378794976L;

    private Long id;

    private String fullName;

    private Long groupId;
}
