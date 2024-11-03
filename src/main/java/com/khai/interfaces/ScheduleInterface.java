package com.khai.interfaces;

public interface ScheduleInterface {
    void setSchedule(DeviceInterface deviceInterface, String time);
    void removeSchedule(DeviceInterface deviceInterface);
    void viewSchedules();
}
