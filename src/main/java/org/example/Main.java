package org.example;

import org.example.Service.RateService;
import org.example.Service.StudentService;
import org.example.repository.Repository;

/**
 * Класс {@link Main}.
 *
 * @author DmitrySheyko
 */
public class Main {

    private static final Repository repository = new Repository();
    private static final StudentService studentService = new StudentService(repository);
    private static final RateService rateService = new RateService(repository);
    private static final AppEngine appEngine = new AppEngine(studentService, rateService);
    public static boolean continueWork = true;

    public static void main(String[] args) {
        startAppEngine();
    }

    public static void startAppEngine() {
        while (continueWork) {
            appEngine.applyCommand();
        }
    }

}