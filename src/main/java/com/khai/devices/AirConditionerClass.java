package com.khai.devices;
import com.khai.interfaces.DeviceInterface;
import java.util.*;

public class AirConditionerClass implements DeviceInterface {
    private boolean isOn = false;
    private int temperature = 24;
    private String name;

    public AirConditionerClass(String name) {
        this.name = name;
    }


    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Air conditioner "+name+" is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Air conditioner "+name+" is turned off.");
    }

    @Override
    public void setParameters(Map<String, String> params) {
        if (params.containsKey("temperature")) {
            temperature = Integer.parseInt(params.get("temperature"));
            System.out.println("Air conditioner "+name+" temperature set to " + temperature);
        } else {
            System.out.println("No valid parameter found for Air Conditioner.");
        }
    }

    @Override
    public String toString() {
        return "Air conditioner  "+ name +"  is " + (isOn ? "on" : "off") + ", temperature: " + temperature;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
