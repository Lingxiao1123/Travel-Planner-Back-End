package com.huixu.travel.controller;


import com.huixu.travel.entity.Plan;
import com.huixu.travel.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlanController {
    @Autowired
    private PlanService planService;

    //public PlanSaveController(PlanService planService) {this.planService = planService;}

    @RequestMapping(value = "/plan", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)

    public void savePlan(@RequestBody Plan plan) {
        planService.savePlan(plan);
    }

    @RequestMapping(value = "/plan/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }
}

