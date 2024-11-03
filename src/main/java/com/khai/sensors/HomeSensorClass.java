package com.khai.sensors;
import com.khai.interfaces.SensorInterface;
public class HomeSensorClass implements SensorInterface {

    @Override
    public double getTemperature() {
        // Тут можна отримати температуру з реального датчика
        return 22.5; // приклад
    }

    @Override
    public double getHumidity() {
        return 50.0; // приклад
    }

    @Override
    public double getLightLevel() {
        return 300; // приклад
    }
}
