package com.swpu.repository;

import com.swpu.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

    @Query(value = "select fan_state from information  where id in (select max(id) from information)",nativeQuery = true)
    boolean findFanState();

    @Query(value = "select bulb_state from information  where id in (select max(id) from information)",nativeQuery = true)
    boolean findBulbState();

    @Query(value = "select dam_state from information where id in (select max(id) from information) ",nativeQuery = true)
    boolean findDamState();

    @Query(value = "select greenhouse_humidity from information  where id in (select max(id) from information)",nativeQuery = true)
    float findGreenhouseHumidity();

    @Query(value = "select  greenhouse_temperature from information  where id in (select max(id) from information)",nativeQuery = true)
    float findGreenhouseTemperature();

    @Query(value = "select light_intensity from information  where id in (select max(id) from information)",nativeQuery = true)
    float findLightIntensity();

    @Query(value = "select soil_temperature from information  where id in (select max(id) from information)",nativeQuery = true)
    float findSoilTemperature();

    @Query(value = "select soil_humidity from information  where id in (select max(id) from information)",nativeQuery = true)
    float findSoilHumidity();

    @Query(value = "select * from information  where id in (select max(id) from information)",nativeQuery = true)
    Information findLast();


    List<Information> findAll();
}
