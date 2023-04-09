package org.example.repository;

import org.example.model.Student;

import java.util.*;

/**
 * Класс {@link Repository} . Выполнен на базе HashMap т.к. хранит уникальные объекты Students и обеспечивает удобный доступ по
 * имени студента, которое в данном проекте, является уникальным идентификатором.
 *
 * @author DmitrySheyko
 */
public class Repository {

    private final Map<String, Student> studentsMap = new HashMap<>();

    public void saveNewStudent(Student student) {
        if (studentsMap.containsKey(student.getName())) {
            System.out.printf("Студент %s уже есть в базе.", student.getName());
        } else {
            studentsMap.put(student.getName(), student);
            System.out.printf("Студент %s успешно сохранен базе.", student.getName());
        }
    }

    public void deleteStudent(String name) {
        if (studentsMap.containsKey(name)) {
            studentsMap.remove(name);
            System.out.printf("Студент %s успешно удален из базы.", name);
        } else {
            System.out.printf("Студент %s не найден в базе.", name);
        }
    }

    public Optional<Student> get(String name) {
        return Optional.ofNullable(studentsMap.get(name));
    }

    public void getAllRates() {
        System.out.println("Оценки всех студентов:");
        for (Map.Entry<String, Student> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getRatesList());
        }
    }

}