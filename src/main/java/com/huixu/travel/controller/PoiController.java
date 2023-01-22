package com.huixu.travel.controller;

import com.huixu.travel.entity.Cities;
import com.huixu.travel.entity.POIs;
import com.huixu.travel.service.PoiInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PoiController {
    @Autowired
    private PoiInfoService poiInfoService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    @ResponseBody
    public List<Cities> getCity(){
        return poiInfoService.getCity();
    }

    //@RequestMapping(value = "/city/{cityId}/POI", method = RequestMethod.GET)

    @RequestMapping(value = "/POI", method = RequestMethod.GET)
    @ResponseBody
    public List<POIs> getPOI()  {
        return poiInfoService.getAllPOI();
    }

//    @RequestMapping(value = "/city/{cityId}/POI", method = RequestMethod.GET)
//    @ResponseBody
//    public List<POIs> getPOI(@PathVariable(value = "cityId") int cityId) {
//        return poiInfoService.getAllPOI(cityId);
//    }
    @RequestMapping(value = "/POI/{category}", method = RequestMethod.GET)
    @ResponseBody
    public List<POIs> getPOIbyCategory(@PathVariable(value = "category") String category) {
        return (List<POIs>) poiInfoService.getPOIbyCategory(category);
    }
}
