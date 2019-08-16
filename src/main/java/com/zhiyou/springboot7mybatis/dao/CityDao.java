package com.zhiyou.springboot7mybatis.dao;

import com.zhiyou.springboot7mybatis.pojo.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public interface CityDao {


    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
