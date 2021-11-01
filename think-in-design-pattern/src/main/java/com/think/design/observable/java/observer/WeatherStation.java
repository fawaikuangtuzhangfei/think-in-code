package com.think.design.observable.java.observer;

import com.think.design.observable.java.subject.impl.WeatherData;
import com.think.design.observable.book.bean.WeatherDataDTO;
import com.think.design.observable.java.observer.impl.CurrentConditionsDisplay;
import com.think.design.observable.java.observer.impl.HeatIndexDisplay;

/**
 * @author Java男朋友
 * @date 2021-11-01 21:17
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        weatherData.measurementsChanger(new WeatherDataDTO(1.1f, 2.2f, 3.3f));
        System.out.println("==================数据变更======================");
        weatherData.deleteObserver(currentConditionsDisplay);
        weatherData.measurementsChanger(new WeatherDataDTO(3.1f, 1.2f, 6.3f));
    }
}
