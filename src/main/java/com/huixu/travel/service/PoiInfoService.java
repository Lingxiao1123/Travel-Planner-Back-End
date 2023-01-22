package com.huixu.travel.service;

import com.huixu.travel.dao.PoiInfoDao;
import com.huixu.travel.entity.Cities;
import com.huixu.travel.entity.POIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiInfoService {

    @Autowired
    private PoiInfoDao poiInfoDao;

    public List<Cities> getCity() {
        return poiInfoDao.getCity();
    }

    public List<POIs> getAllPOI() { return poiInfoDao.getAllPOI(); }

//    public List<POIs> getAllPOI(int cityId) {
//        return poiInfoDao.getAllPOI(cityId);
//    }

    public POIs getPOI(int id) {
        return poiInfoDao.getPOI(id);
    }

    public List<POIs> getPOIbyCategory(String category) {
        return poiInfoDao.getPOIbyCategory(category);
    }
}
