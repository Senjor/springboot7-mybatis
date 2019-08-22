package com.zhiyou.springboot7mybatis.service.impl;

import com.zhiyou.springboot7mybatis.dao.CityDao;

import com.zhiyou.springboot7mybatis.pojo.City;

import com.zhiyou.springboot7mybatis.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);

    }

    /**
     * 获取城市逻辑：
     * 1 如果缓存存在，从缓存中获取城市信息
     * 2 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public City findCityById(Long id) {

        // 从缓存中获取城市信息
        String key = "city_" + id;

        ValueOperations<String, City> operations = redisTemplate.opsForValue();


        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);

        System.out.println("hasKey" + hasKey);
        if (hasKey) {

            City city = operations.get(key);

            System.out.println("从缓存中去");

            return city;
        }

        System.out.println("从DB中去");

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);

        // 插入缓存
        operations.set(key, city);

        return city;
    }
}
