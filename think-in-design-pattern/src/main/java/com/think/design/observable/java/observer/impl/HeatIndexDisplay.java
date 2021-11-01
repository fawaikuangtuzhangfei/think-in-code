package com.think.design.observable.java.observer.impl;

import com.think.design.observable.book.other.DisplayElement;
import com.think.design.observable.java.subject.impl.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Java男朋友
 * @date 2021-11-01 21:07
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private Observable observable;

    public HeatIndexDisplay() {

    }

    public HeatIndexDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("HeatIndexDisplay: "+ weatherData.getWeatherDataDTO().toString());
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData){
            this.weatherData = (WeatherData) observable;
            display();
        }
    }
}
