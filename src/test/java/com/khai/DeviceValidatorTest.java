package com.khai;

import com.khai.devices.LightClass;
import com.khai.interfaces.DeviceInterface;
import com.khai.room.RoomClass;
import com.khai.validators.DeviceValidator;
import com.khai.validators.RoomValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceValidatorTest {

    @Test
    void testIsValidRoomIndex_ValidIndex() {
        List<DeviceInterface> device = createRoomsList(3);
        int validIndex = 1; // Індекс у межах списку

        assertTrue(DeviceValidator.isValidDeviceIndex(validIndex, device), "Індекс повинен бути допустимим.");
    }

    @Test
    void testIsValidRoomIndex_IndexNegative() {
        List<DeviceInterface> device = createRoomsList(3);
        int invalidIndex = -1; // Негативний індекс

        assertFalse(DeviceValidator.isValidDeviceIndex(invalidIndex, device), "Негативний індекс повинен бути недопустимим.");
    }

    @Test
    void testIsValidRoomIndex_IndexTooLarge() {
        List<DeviceInterface> device = createRoomsList(3);
        int invalidIndex = 3; // Індекс за межами списку

        assertFalse(DeviceValidator.isValidDeviceIndex(invalidIndex, device), "Індекс, що перевищує розмір списку, повинен бути недопустимим.");
    }

    @Test
    void testIsValidRoomIndex_EmptyList() {
        List<DeviceInterface> emptyDevices = new ArrayList<>();
        int invalidIndex = 0; // Індекс для порожнього списку

        assertFalse(DeviceValidator.isValidDeviceIndex(invalidIndex, emptyDevices), "Індекс для порожнього списку повинен бути недопустимим.");
    }

    // Допоміжний метод для створення списку кімнат
    private List<DeviceInterface> createRoomsList(int numberOfDevice) {
        List<DeviceInterface> rooms = new ArrayList<>();
        for (int i = 0; i < numberOfDevice; i++) {
            rooms.add(new LightClass("test"));
        }
        return rooms;
    }
}
