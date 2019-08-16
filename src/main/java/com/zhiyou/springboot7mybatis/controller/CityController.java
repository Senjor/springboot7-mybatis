/**
 * Copyright (C), 2009-2019, 智游集团
 * FileName: CityController
 * Author:   laosun
 * Date:     2019/8/9 11:35 AM
 * Description:
 */
package com.zhiyou.springboot7mybatis.controller;

import com.zhiyou.springboot7mybatis.pojo.City;
import com.zhiyou.springboot7mybatis.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

}
