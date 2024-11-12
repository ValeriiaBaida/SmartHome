package com.khai;

import com.khai.room.RoomClass;
import com.khai.validators.RoomValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomValidatorTest {

    @Test
    void testIsValidRoomIndex_ValidIndex() {
        List<RoomClass> rooms = createRoomsList(3);
        int validIndex = 1; // Індекс у межах списку

        assertTrue(RoomValidator.isValidRoomIndex(validIndex, rooms), "Індекс повинен бути допустимим.");
    }

    @Test
    void testIsValidRoomIndex_IndexNegative() {
        List<RoomClass> rooms = createRoomsList(3);
        int invalidIndex = -1; // Негативний індекс

        assertFalse(RoomValidator.isValidRoomIndex(invalidIndex, rooms), "Негативний індекс повинен бути недопустимим.");
    }

    @Test
    void testIsValidRoomIndex_IndexTooLarge() {
        List<RoomClass> rooms = createRoomsList(3);
        int invalidIndex = 3; // Індекс за межами списку

        assertFalse(RoomValidator.isValidRoomIndex(invalidIndex, rooms), "Індекс, що перевищує розмір списку, повинен бути недопустимим.");
    }

    @Test
    void testIsValidRoomIndex_EmptyList() {
        List<RoomClass> emptyRooms = new ArrayList<>();
        int invalidIndex = 0; // Індекс для порожнього списку

        assertFalse(RoomValidator.isValidRoomIndex(invalidIndex, emptyRooms), "Індекс для порожнього списку повинен бути недопустимим.");
    }

    // Допоміжний метод для створення списку кімнат
    private List<RoomClass> createRoomsList(int numberOfRooms) {
        List<RoomClass> rooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            rooms.add(new RoomClass("test"));
        }
        return rooms;
    }
}
