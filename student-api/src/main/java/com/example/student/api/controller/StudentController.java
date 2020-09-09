package com.example.student.api.controller;

import com.example.student.api.dto.StudentDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "StudentController", url = "${ms.student.url}")
public interface StudentController {

    @GetMapping(value = "/students")
    List<StudentDto> getStudents();

    @GetMapping(value = "/students/{id}")
    StudentDto getStudent(@PathVariable Long id);

    @GetMapping(value = "/students/group/{groupId}")
    List<StudentDto> getStudentsByGroupId(@PathVariable Long groupId);
}
