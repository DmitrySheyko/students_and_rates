package org.example.Service;

import org.example.Main;
import org.example.model.Rate;
import org.example.model.Student;
import org.example.repository.Repository;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс {@link StudentService}. В данном классе сосредоточена бизнес-логика, относящаяся к сущности Student.
 *
 * @author DmitrySheyko
 */
public class StudentService {

    private final Repository repository;

    public StudentService(Repository repository) {
        this.repository = repository;
    }

    public void addNewStudent(Scanner scan) {
        String name = getStudentName(scan);
        Student student = new Student(name, new LinkedList<Rate>());
        repository.saveNewStudent(student);
        backToMainMenu();
    }

    public void removeStudent(Scanner scan) {
        String name = getStudentName(scan);
        repository.deleteStudent(name);
        backToMainMenu();
    }

    private String getStudentName(Scanner scan) {
        System.out.println("""
                Введите имя студента
                (0 - возврат в основное меню)""");
        String name = scan.nextLine();
        if (name.equals("0")) backToMainMenu();
        while (name.isBlank()) {
            System.out.println("""
                    Имя введено некорректно, повторите ввод
                    (0 - возврат в основное меню)""");
            name = scan.nextLine();
            if (name.equals("0")) backToMainMenu();
        }
        return name;
    }

    private void backToMainMenu() {
        Main.startAppEngine();
    }

}