package com.think.design.strategy.observable.book.observer.impl;

import com.think.design.strategy.observable.book.bean.WeatherDataDTO;
import com.think.design.strategy.observable.book.observer.Observer;
import com.think.design.strategy.observable.book.other.DisplayElement;

/**
 * @author Java男朋友
 * @date 2021-11-01 21:07
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherDataDTO weatherDataDTO;

    @Override
    public void update(WeatherDataDTO weatherDataDTO) {
        this.weatherDataDTO = weatherDataDTO;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay: "+ weatherDataDTO.toString());
    }
}
