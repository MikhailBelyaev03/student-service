package com.example.student.impl.repository;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import com.example.student.domain.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    private final List<StudentEntity> entities = asList(
        new StudentEntity(1L, "Ivan Ivanov", 1L),
        new StudentEntity(2L, "Sergey Petrov", 2L),
        new StudentEntity(3L, "Anton Sergeev", 1L),
        new StudentEntity(4L, "Mikhail Antonov", 3L)
    );

    public List<StudentEntity> findAll() {
        return new ArrayList<>(entities);
    }

    public StudentEntity findById(Long id) {
        return entities.stream()
            .filter(entity -> id.equals(entity.getId()))
            .findAny()
            .orElse(null);
    }

    public List<StudentEntity> findByGroupId(Long groupId) {
        return entities.stream()
            .filter(entity -> groupId.equals(entity.getGroupId()))
            .collect(toList());
    }
}
