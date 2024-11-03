package com.khai.devices;
import com.khai.interfaces.DeviceInterface;
import java.util.*;

public class LightClass implements DeviceInterface {
    private boolean isOn = false;
    private int brightness = 100;
    private String name;

    public LightClass(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light is turned off.");
    }

    @Override
    public void setParameters(Map<String, String> params) {
        if (params.containsKey("brightness")) {
            brightness = Integer.parseInt(params.get("brightness"));
            System.out.println("Light brightness set to " + brightness);
        } else {
            System.out.println("No valid parameter found for Light.");
        }
    }

    @Override
    public String toString() {
        return "Light " + name + " is " + (isOn ? "on" : "off") + ", brightness: " + brightness;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}