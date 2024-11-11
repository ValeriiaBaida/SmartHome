package com.khai;

import com.khai.validators.DeviceParameterValidator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeviceParameterValidatorTest {
    @Test
    void testValidateLightParameters_ValidBrightness() {
        Map<String, String> params = new HashMap<>();
        params.put("brightness", "50"); // Допустиме значення

        assertDoesNotThrow(() -> DeviceParameterValidator.validateLightParameters(params));
    }

    @Test
    void testValidateLightParameters_BrightnessOutOfRange_Low() {
        Map<String, String> params = new HashMap<>();
        params.put("brightness", "-10"); // Яскравість нижче діапазону

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateLightParameters(params));
        assertEquals("Brightness must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void testValidateLightParameters_BrightnessOutOfRange_High() {
        Map<String, String> params = new HashMap<>();
        params.put("brightness", "150"); // Яскравість вище діапазону

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateLightParameters(params));
        assertEquals("Brightness must be between 0 and 100.", exception.getMessage());
    }

    @Test
    void testValidateLightParameters_BrightnessNotANumber() {
        Map<String, String> params = new HashMap<>();
        params.put("brightness", "not_a_number"); // Недійсне значення

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateLightParameters(params));
        assertEquals("Brightness must be a valid number.", exception.getMessage());
    }

    @Test
    void testValidateAirConditionerParameters_ValidTemperature() {
        Map<String, String> params = new HashMap<>();
        params.put("temperature", "20"); // Допустиме значення

        assertDoesNotThrow(() -> DeviceParameterValidator.validateAirConditionerParameters(params));
    }

    @Test
    void testValidateAirConditionerParameters_TemperatureOutOfRange_Low() {
        Map<String, String> params = new HashMap<>();
        params.put("temperature", "-30"); // Температура нижче діапазону

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateAirConditionerParameters(params));
        assertEquals("Temperature must be between -25 and 50 degrees Celsius.", exception.getMessage());
    }

    @Test
    void testValidateAirConditionerParameters_TemperatureOutOfRange_High() {
        Map<String, String> params = new HashMap<>();
        params.put("temperature", "60"); // Температура вище діапазону

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateAirConditionerParameters(params));
        assertEquals("Temperature must be between -25 and 50 degrees Celsius.", exception.getMessage());
    }

    @Test
    void testValidateAirConditionerParameters_TemperatureNotANumber() {
        Map<String, String> params = new HashMap<>();
        params.put("temperature", "not_a_number"); // Недійсне значення

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DeviceParameterValidator.validateAirConditionerParameters(params));
        assertEquals("Temperature must be a valid number.", exception.getMessage());
    }
}
