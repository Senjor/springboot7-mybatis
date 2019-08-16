package com.zhiyou.springboot7mybatis.service;

import com.zhiyou.springboot7mybatis.pojo.City;


public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */

    City findCityByName(String cityName);
}
