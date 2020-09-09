package com.example.student.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = -7042358981845050954L;

    private Long id;

    private String fullName;

    private Long groupId;
}
