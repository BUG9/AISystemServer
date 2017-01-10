package com.swpu.service;

import com.swpu.model.Information;


import java.util.List;

/**
 * Created by BUG666 on 2017/1/4.
 */
public interface InformationService {

   void save(Information information);

    boolean findFanState();

    boolean findBulbState();

    boolean findDamState();


    float findGreenhouseHumidity();

    float findGreenhouseTemperature();

    float findLightIntensity();

    float findSoilTemperature();

    float findSoilHumidity();

    Information findLast();
    List<Information> findAll();

    void batchInsert(List<Information> list);
}
