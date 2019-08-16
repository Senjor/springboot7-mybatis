package com.zhiyou.springboot7mybatis.service.impl;

import com.zhiyou.springboot7mybatis.dao.CityDao;

import com.zhiyou.springboot7mybatis.pojo.City;

import com.zhiyou.springboot7mybatis.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
