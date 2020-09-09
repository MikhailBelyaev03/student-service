package com.example.student.impl.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

import com.example.student.api.controller.StudentController;
import com.example.student.api.dto.StudentDto;
import com.example.student.domain.StudentEntity;
import com.example.student.impl.repository.StudentRepository;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getStudents() {
        return convertStudentsToDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto getStudent(Long id) {
        return convertStudentToDto(studentRepository.findById(id));
    }

    @Override
    public List<StudentDto> getStudentsByGroupId(Long groupId) {
        if (new Random().nextBoolean()) {
            log.info("THROW 503");
            throw new ResponseStatusException(SERVICE_UNAVAILABLE, "Unable to find resource");
        }
        log.info("REQUEST PASSED");
        return convertStudentsToDtos(studentRepository.findByGroupId(groupId));
    }

    private List<StudentDto> convertStudentsToDtos(List<StudentEntity> entities) {
        return entities.stream()
            .map(this::convertStudentToDto)
            .collect(toList());
    }

    private StudentDto convertStudentToDto(StudentEntity studentEntity) {
        return new StudentDto(studentEntity.getId(), studentEntity.getFullName(), studentEntity.getGroupId());
    }
}
