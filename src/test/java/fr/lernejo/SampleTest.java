package fr.lernejo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SampleTest {

    private final Sample sample = new Sample();

    @ParameterizedTest
    @CsvSource({
        "ADD, 2, 2, 4",
        "ADD, 0, 7, 7",
        "ADD, -6, 23, 17",
        "MULT, 2, 2, 4",
        "MULT, 3, 4, 12",
    })
    void addition_of_2_and_2_should_be_4(Sample.Operation operation,
                                         int a,
                                         int b,
                                         int expectedResult) {
        int result = sample.op(operation, a, b);

        assertEquals(result,expectedResult);
    }

    @Test
    void fact_of_4() {
        int result = sample.fact(4);

        assertEquals(result,24);
    }

    @Test
    void fact_of_negative_number_throws() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,() -> {sample.fact(-3);}, "N should be positive");
        Assertions.assertEquals("N should be positive", thrown.getMessage());
    }
}
