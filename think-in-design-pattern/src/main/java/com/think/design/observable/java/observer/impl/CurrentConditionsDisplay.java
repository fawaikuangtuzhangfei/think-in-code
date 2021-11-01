package com.think.design.observable.java.observer.impl;

import com.think.design.observable.book.other.DisplayElement;
import com.think.design.observable.java.subject.impl.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Java男朋友
 * @date 2021-11-01 21:07
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay: "+ weatherData.getWeatherDataDTO().toString());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            this.weatherData = (WeatherData) o;
            display();
        }
    }
}
