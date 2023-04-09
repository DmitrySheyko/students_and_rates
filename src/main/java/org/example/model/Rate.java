package org.example.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Класс {@link Rate}. Класс сохраняет данные о значении оценки, идентификаторе студента и времени получения оценки.
 *
 * @author DmitrySheyko
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

    private Byte value;
    private String studentName;
    private LocalDateTime CreatedOn;

    @Override
    public String toString() {
        return value.toString();
    }

}
