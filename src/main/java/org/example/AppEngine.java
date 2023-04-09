package org.example;

import org.example.Service.RateService;
import org.example.Service.StudentService;

import java.util.Scanner;

/**
 * Класс {@link AppEngine}. В данном классе реализовано основное меню приложения.
 *
 * @author DmitrySheyko
 */
public class AppEngine {
    private final StudentService studentService;
    private final RateService rateService;
    private final Scanner scan;

    public AppEngine(StudentService studentService, RateService rateService) {
        this.studentService = studentService;
        this.rateService = rateService;
        scan = new Scanner(System.in);
    }

    public void applyCommand() {
        printMenu();
        int commandInt = getCommand();
        switch (commandInt) {
            case 1:
                studentService.addNewStudent(scan);
                break;
            case 2:
                studentService.removeStudent(scan);
                break;
            case 3:
                rateService.addNewRate(scan);
            case 4:
                rateService.getAllRates();
                break;
            case 5:
                rateService.getRatesOfOneStudent(scan);
                break;
            case 0:
                stopApp();
                break;
            default:
                System.out.println("Введена некорректная команда, повторите ввод");
        }
    }

    public void printMenu() {
        System.out.println("""
                \n
                Введите номер команды:
                1 - добавить нового студента;
                2 - удалить студента;
                3 - добавить оценку студента;
                4 - посмотреть оценки всех студентов
                5 - посмотреть оценки конкретного студента;
                0 - закончить работу.
                """);
    }

    public int getCommand() {
        final Scanner scan = new Scanner(System.in);
        int commandInt = scan.nextInt();
        while (commandInt < 0 || commandInt > 5) {
            System.out.println("Введена некорректная команда, пожалуйста повторите ввод:");
            printMenu();
            commandInt = scan.nextByte();
        }
        return commandInt;
    }

    private void stopApp() {
        System.out.println("Приложение завершило работу.");
        scan.close();
        Main.continueWork = false;
    }

}