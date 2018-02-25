package eu.thomaspro.raspberryPiDashboard.models;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class Clock extends TimerTask {
    public Clock(Label clockDate, Label clockTime) {
        this.clockDate = clockDate;
        this.clockTime = clockTime;
    }
    private Label clockDate, clockTime;
    @Override
    public void run() {
        Platform.runLater(() -> {
            setClockDate();
            setClockTime();
        });
    }
    /**
     * getting LocalDate, Mapping number of month with name in Polish, setting label clockDate in DashboardLayout
     */
    private void setClockDate(){
        LocalDate localDate = LocalDateTime.now().toLocalDate();
        Map<Integer, String> months = new HashMap<>();
        {
            months.put(1, "Styczeń");
            months.put(2, "Luty");
            months.put(3, "Marzec");
            months.put(4, "Kwiecień");
            months.put(5, "Maj");
            months.put(6, "Czerwiec");
            months.put(7, "Lipiec");
            months.put(8, "Sierpień");
            months.put(9, "Wrzesień");
            months.put(10, "Październik");
            months.put(11, "Listopad");
            months.put(12, "Grudzień");
        }
        String year = localDate.getYear() + "";
        String month = months.get(localDate.getMonthValue());
        int day = localDate.getDayOfMonth();
        clockDate.setText(String.format("%02d", day) + " " + month + " " + year);
    }
    /**
     * getting LocalTime, setting label clockTime with formatting in DashboardLayout
     */
    private void setClockTime(){
        LocalTime localTime = LocalDateTime.now().toLocalTime();
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();
        clockTime.setText(String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
    }
}

