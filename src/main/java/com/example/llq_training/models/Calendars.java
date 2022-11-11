package com.example.llq_training.models;

import java.sql.Blob;

public class Calendars {
    private String sched_name;
    private String calendar_name;
    private String calendar;

    public Calendars() {
    }

    public Calendars(String sched_name, String calendar_name, String calendar) {
        this.sched_name = sched_name;
        this.calendar_name = calendar_name;
        this.calendar = calendar;
    }

    public String getSched_name() {
        return sched_name;
    }

    public void setSched_name(String sched_name) {
        this.sched_name = sched_name;
    }

    public String getCalendar_name() {
        return calendar_name;
    }

    public void setCalendar_name(String calendar_name) {
        this.calendar_name = calendar_name;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }
}
