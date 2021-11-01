package com.think.design.observable.java.subject.impl;

import com.think.design.observable.book.bean.WeatherDataDTO;

import java.util.Observable;

/**
 * 观察者-主题类
 * 气象站
 * @author Java男朋友
 * @date 2021-11-01 20:58
 */
public class WeatherData extends Observable {

    /**
     * 封装气象参数
     */
    private WeatherDataDTO weatherDataDTO;

    public WeatherDataDTO getWeatherDataDTO() {
        return weatherDataDTO;
    }

    /**
     * 接受气象站的数据
     */
    public void measurementsChanger(WeatherDataDTO weatherDataDTO){
        this.weatherDataDTO = weatherDataDTO;
        setChanged();
        notifyObservers();
    }
}
