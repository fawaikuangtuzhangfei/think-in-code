package com.think.design.strategy.observable.book.bean;

/**
 * 封装了天气的数据的实体类
 * @author Java男朋友
 * @date 2021-11-01 21:09
 */
public class WeatherDataDTO {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataDTO() {
    }

    public WeatherDataDTO(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherDataDTO{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
