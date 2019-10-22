package ru.netology.service.ci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

    class CashbackHackServiceTest {

        private CashbackHackService service;

        @BeforeEach
        void setUp() {
            service = new CashbackHackService();
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/CashbackData.csv", numLinesToSkip = 1)
        void shouldReturnZeroIfAmountIs1000(int amount, int expected, String message) {
             int actual = service.remain(amount);

             assertEquals(expected, actual, message);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "/CashbackData.csv", numLinesToSkip = 1)
        void shouldReturn100IfAmountIs900(int amount, int expected, String message) {
            int actual = service.remain(amount);

            assertEquals(expected, actual, message);
        }

        @Test
        void shouldThrowIfAmountIsZero() {

           assertThrows(IllegalArgumentException.class, () -> service.remain(0));
        }
}
