package com.roytuts.java.junit.expected.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecondsToMinutesUtilsExceptionTest {

    private SecondsToMinutesUtils secsToMins;

    @BeforeEach
    public void setUp() throws Exception {
        secsToMins = new SecondsToMinutesUtils();
    }

    @Test
    public void testSecsToMins() {
        int seconds = 1;

        assertThrows(IllegalArgumentException.class, () -> secsToMins.secsToMins(seconds));
    }

}
