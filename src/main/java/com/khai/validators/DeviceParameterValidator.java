package com.khai.validators;
import java.util.Map;
import java.util.HashMap;

public class DeviceParameterValidator {

    public static void validateLightParameters(Map<String, String> params) {

        String brightnessStr = params.get("brightness");
        try {
            int brightness = Integer.parseInt(brightnessStr);
            if (brightness < 0 || brightness > 100) {
                throw new IllegalArgumentException("Brightness must be between 0 and 100.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Brightness must be a valid number.");
        }
    }

    public static void validateAirConditionerParameters(Map<String, String> params) {

        String temperatureStr = params.get("temperature");
        try {
            int temperature = Integer.parseInt(temperatureStr);
            if (temperature < -25 || temperature > 50) {
                throw new IllegalArgumentException("Temperature must be between -25 and 50 degrees Celsius.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Temperature must be a valid number.");
        }
    }

    public static void validateCleanerParameters(Map<String, String> params) {

        String speedStr = params.get("speed");
        try {
            int speed = Integer.parseInt(speedStr);
            if (speed < 1 || speed > 10) {
                throw new IllegalArgumentException("Cleaning speed must be between 1 and 10.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Speed must be a valid number.");
        }
    }
}

