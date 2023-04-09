package org.example.Service;

import org.example.Main;
import org.example.model.Rate;
import org.example.model.Student;
import org.example.repository.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс {@link RateService}. В данном классе сосредоточена бизнес-логика, относящаяся к сущности Rate.
 *
 * @author DmitrySheyko
 */
public class RateService {

    private final Repository repository;

    public RateService(Repository repository) {
        this.repository = repository;
    }

    public void addNewRate(Scanner scan) {
        Student student = getStudent(scan);
        Byte rateValue = getRateValue(scan);
        Rate rate = Rate.builder()
                .value(rateValue)
                .studentName(student.getName())
                .CreatedOn(LocalDateTime.now())
                .build();
        student.getRatesList().add(rate);
        backToMainMenu();
    }

    public void getAllRates() {
        repository.getAllRates();
        backToMainMenu();
    }

    public void getRatesOfOneStudent(Scanner scan) {
        Student student = getStudent(scan);
        System.out.println(student);
        backToMainMenu();
    }

    private Student getStudent(Scanner scan) {
        String name = getStudentName(scan);
        Optional<Student> optionalStudent = repository.get(name);
        while (optionalStudent.isEmpty()) {
            System.out.printf("""
                    Студент %s не найден
                    \n""", name);
            name = getStudentName(scan);
            optionalStudent = repository.get(name);
        }
        return optionalStudent.get();
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

    private Byte getRateValue(Scanner scan) {
        System.out.println("""
                Ведите оценку от 1 до 5
                (0 - возврат в основное меню)""");
        byte rateValue = scan.nextByte();
        if (rateValue == 0) backToMainMenu();
        while (rateValue < 1 || rateValue > 5) {
            System.out.println("""
                    Оценка введена некорректно, повторите ввод
                    (0 - возврат в основное меню)""");
            rateValue = scan.nextByte();
            if (rateValue == 0) backToMainMenu();
        }
        return rateValue;
    }

    private void backToMainMenu() {
        Main.startAppEngine();
    }

}
