package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTimeTest {

    private ChangeTime changeTime;

    @BeforeEach
    void setUp() {
        changeTime = new ChangeTime();
    }

    @Test
    public void shouldFailForMissingAMOrPM() {
        String invalidTime = "11:30";
        int minutesToAdd = 10;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            changeTime.addTime(invalidTime, minutesToAdd);
        });

        assertEquals("Format in the time incorrect", exception.getMessage());
    }
    @Test
    public void shouldFailForIncorrectFormat(){
        String invalidTime = "10:30 XZ"; // Different of AM/PM
        int minutesToAdd = 10;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            changeTime.addTime(invalidTime, minutesToAdd);
        });

        assertEquals("Format in the time incorrect", exception.getMessage());
    }
    @Test
    public void shouldFailForHoursGreaterThan12(){
        String invalidTime = "15:30 AM";
        int minutesToAdd = 10;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            changeTime.addTime(invalidTime, minutesToAdd);
        });

        assertEquals("Format in the time incorrect", exception.getMessage());
    }

    @Test
    public void shouldSuccessPassFromAMToPM() {
        String validTime = "09:13 AM";
        int minutesToAdd = 200;
        String result = changeTime.addTime(validTime, minutesToAdd);
        assertEquals("12:33 PM", result);
    }
    @Test
    public void shouldSuccessPassFromPMToAm() {
        String validTime = "09:13 PM";
        int minutesToAdd = 200;
        String result = changeTime.addTime(validTime, minutesToAdd);
        assertEquals("12:33 AM", result);
    }
}