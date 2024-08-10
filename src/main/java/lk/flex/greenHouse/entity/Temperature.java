package lk.flex.greenHouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "temperature")
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "temperature_status")
    private String temperatureStatus;

    public Temperature() {
    }

    public Temperature(String date, String time, String temperatureStatus) {
        this.date = date;
        this.time = time;
        this.temperatureStatus = temperatureStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperatureStatus() {
        return temperatureStatus;
    }

    public void setTemperatureStatus(String temperatureStatus) {
        this.temperatureStatus = temperatureStatus;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", temperatureStatus='" + temperatureStatus + '\'' +
                '}';
    }
}
