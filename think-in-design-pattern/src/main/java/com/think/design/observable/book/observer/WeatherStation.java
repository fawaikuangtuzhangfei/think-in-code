package com.think.design.observable.book.observer;

import com.think.design.observable.book.bean.WeatherDataDTO;
import com.think.design.observable.book.observer.impl.CurrentConditionsDisplay;
import com.think.design.observable.book.observer.impl.HeatIndexDisplay;
import com.think.design.observable.book.subject.impl.WeatherData;

/**
 * @author Java男朋友
 * @date 2021-11-01 21:17
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        weatherData.addObserver(currentConditionsDisplay);
        weatherData.addObserver(new HeatIndexDisplay());
        weatherData.measurementsChanger(new WeatherDataDTO(1.1f, 2.2f, 3.3f));
        System.out.println("==================数据变更======================");
        weatherData.removeObserver(currentConditionsDisplay);
        weatherData.measurementsChanger(new WeatherDataDTO(3.1f, 1.2f, 6.3f));
    }
}
