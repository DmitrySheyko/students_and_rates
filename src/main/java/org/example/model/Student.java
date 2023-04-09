package org.example.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс {@link Student}. Т.к. в ТЗ не было указано иное, идентификатором выбрано моле Имя.
 * Для хранения оценок использован LinkedList т.к. проект предполагает только операции по добавлению оценок
 * в конец списка и выведению полного списка оценок.
 *
 * @author DmitrySheyko
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @EqualsAndHashCode.Include
    private String name;
    private List<Rate> ratesList;

    @Override
    public String toString() {
        return "оценки: " + ratesList + "\n";
    }

}


