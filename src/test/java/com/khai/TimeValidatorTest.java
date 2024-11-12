package com.khai;

import com.khai.validators.TimeValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeValidatorTest {

    @Test
    void testValidateTimeFormat_ValidTime_AM() {
        String validTime = "08:30 AM";
        assertDoesNotThrow(() -> TimeValidator.validateTimeFormat(validTime));
    }

    @Test
    void testValidateTimeFormat_ValidTime_PM() {
        String validTime = "11:45 PM";
        assertDoesNotThrow(() -> TimeValidator.validateTimeFormat(validTime));
    }

    @Test
    void testValidateTimeFormat_InvalidTimeFormat_MissingAMPM() {
        String invalidTime = "08:30";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TimeValidator.validateTimeFormat(invalidTime));
        assertEquals("Invalid time format. Please use HH:mm AM/PM format.", exception.getMessage());
    }

    @Test
    void testValidateTimeFormat_InvalidTimeFormat_IncorrectFormat() {
        String invalidTime = "20:15 PM"; // Неправильний формат

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TimeValidator.validateTimeFormat(invalidTime));
        assertEquals("Invalid time format. Please use HH:mm AM/PM format.", exception.getMessage());
    }

    @Test
    void testValidateTimeFormat_InvalidTimeFormat_NonTimeString() {
        String invalidTime = "invalid_time"; // Недійсний рядок

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TimeValidator.validateTimeFormat(invalidTime));
        assertEquals("Invalid time format. Please use HH:mm AM/PM format.", exception.getMessage());
    }

    @Test
    void testValidateTimeFormat_InvalidTime_OutOfBounds() {
        String invalidTime = "13:00 PM"; // Година поза допустимими значеннями для 12-годинного формату

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> TimeValidator.validateTimeFormat(invalidTime));
        assertEquals("Invalid time format. Please use HH:mm AM/PM format.", exception.getMessage());
    }
}
