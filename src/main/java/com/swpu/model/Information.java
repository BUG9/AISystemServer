package com.swpu.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Entity
public class Information {
    @Id
            @GeneratedValue
    Long id;

    int soilHumidity;//土壤湿度

    int  soilTemperature;//土壤温度

    int  lightIntensity;//光照强度

    int greenhouseTemperature;//大棚温度

    int  greenhouseHumidity;//大棚湿度

    int  damState;//水泵状态

    int  fanState;//电扇状态

    int bulbState;//灯泡状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(int soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public int getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(int soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public int getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(int lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public int getGreenhouseTemperature() {
        return greenhouseTemperature;
    }

    public void setGreenhouseTemperature(int greenhouseTemperature) {
        this.greenhouseTemperature = greenhouseTemperature;
    }

    public int getGreenhouseHumidity() {
        return greenhouseHumidity;
    }

    public void setGreenhouseHumidity(int greenhouseHumidity) {
        this.greenhouseHumidity = greenhouseHumidity;
    }

    public int getDamState() {
        return damState;
    }

    public void setDamState(int damState) {
        this.damState = damState;
    }

    public int getFanState() {
        return fanState;
    }

    public void setFanState(int fanState) {
        this.fanState = fanState;
    }

    public int getBulbState() {
        return bulbState;
    }

    public void setBulbState(int bulbState) {
        this.bulbState = bulbState;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", soilHumidity=" + soilHumidity +
                ", soilTemperature=" + soilTemperature +
                ", lightIntensity=" + lightIntensity +
                ", greenhouseTemperature=" + greenhouseTemperature +
                ", greenhouseHumidity=" + greenhouseHumidity +
                ", damState=" + damState +
                ", fanState=" + fanState +
                ", bulbState=" + bulbState +
                '}';
    }
}
