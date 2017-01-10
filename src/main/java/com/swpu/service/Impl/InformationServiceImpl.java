package com.swpu.service.Impl;

import com.swpu.model.Information;
import com.swpu.repository.InformationRepository;
import com.swpu.service.InformationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Service
@Transactional
public class InformationServiceImpl implements InformationService {
    @Resource
    private InformationRepository informationRepository;

    @Override
    public void save(Information information) {
        informationRepository.save(information);
    }

    @Override
    public boolean findFanState() {
        return informationRepository.findFanState();
    }

    @Override
    public boolean findBulbState() {
        return informationRepository.findBulbState();
    }

    @Override
    public boolean findDamState() {
        return informationRepository.findDamState();
    }

    @Override
    public float findGreenhouseHumidity() {
        return informationRepository.findGreenhouseHumidity();
    }

    @Override
    public float findGreenhouseTemperature() {
        return informationRepository.findGreenhouseTemperature();
    }

    @Override
    public float findLightIntensity() {
        return informationRepository.findLightIntensity();
    }

    @Override
    public float findSoilTemperature() {
        return informationRepository.findSoilTemperature();
    }

    @Override
    public float findSoilHumidity() {
        return informationRepository.findSoilHumidity();
    }

    @Override
    public Information findLast() {
        return informationRepository.findLast();
    }

    @Override
    public List<Information> findAll() {
        return informationRepository.findAll();
    }

    @Override
    public void batchInsert(List<Information> informationList) {
        for (Information i: informationList
             ) {
            informationRepository.save(i);
        }
    }
}
