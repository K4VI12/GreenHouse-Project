package lk.flex.greenHouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "soil_moisture")
public class SoilMoisture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "soil_moisture_status")
    private String soilMoistureStatus;

    public SoilMoisture() {
    }

    public SoilMoisture(String date, String time, String soilMoistureStatus) {
        this.date = date;
        this.time = time;
        this.soilMoistureStatus = soilMoistureStatus;
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

    public String getSoilMoistureStatus() {
        return soilMoistureStatus;
    }

    public void setSoilMoistureStatus(String soilMoistureStatus) {
        this.soilMoistureStatus = soilMoistureStatus;
    }

    @Override
    public String toString() {
        return "SoilMoisture{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", soilMoistureStatus='" + soilMoistureStatus + '\'' +
                '}';
    }
}
