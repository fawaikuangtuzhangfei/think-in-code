package com.think.design.strategy.observable.book.observer;

import com.think.design.strategy.observable.book.bean.WeatherDataDTO;

/**
 * 观察者-观察者超类
 * @author Java男朋友
 * @date 2021-11-01 20:56
 */
public interface Observer {

    /**
     * 更新数据
     * @param weatherDataDTO 数据实体
     */
    void update(WeatherDataDTO weatherDataDTO);

}
