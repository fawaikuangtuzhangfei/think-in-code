package com.think.design.strategy.observable.book.subject.impl;

import com.think.design.strategy.observable.book.bean.WeatherDataDTO;
import com.think.design.strategy.observable.book.observer.Observer;
import com.think.design.strategy.observable.book.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者-主题类
 * 气象站
 * @author Java男朋友
 * @date 2021-11-01 20:58
 */
public class WeatherData implements Subject {

    /**
     * 封装气象参数
     */
    private WeatherDataDTO weatherDataDTO;

    /**
     * 所有观察者
     */
    private List<Observer> observerList;


    public WeatherData() {
        this.observerList = new ArrayList<>();
    }



    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if(i >= 0){
            observerList.remove(i);
        }
    }

    @Override
    public void notifyAllObserver() {
        observerList.forEach(obj -> obj.update(weatherDataDTO));
    }

    /**
     * 接受气象站的数据
     */
    public void measurementsChanger(WeatherDataDTO weatherDataDTO){
        this.weatherDataDTO = weatherDataDTO;
        notifyAllObserver();
    }
}
