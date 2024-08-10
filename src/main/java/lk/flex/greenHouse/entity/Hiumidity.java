package lk.flex.greenHouse.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "humiduty")
public class Hiumidity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "humidity_status")
    private String humidityStatus;

    public Hiumidity() {
    }

    public Hiumidity(String date, String time, String humidityStatus) {
        this.date = date;
        this.time = time;
        this.humidityStatus = humidityStatus;
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

    public String getHumidityStatus() {
        return humidityStatus;
    }

    public void setHumidityStatus(String humidityStatus) {
        this.humidityStatus = humidityStatus;
    }

    @Override
    public String toString() {
        return "Hiumidity{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", humidityStatus='" + humidityStatus + '\'' +
                '}';
    }
}
