package com.think.design.strategy.observable.book.subject;

import com.think.design.strategy.observable.book.observer.Observer;

/**
 * 观察者模式-主题超类
 * @author Java男朋友
 * @date 2021-11-01 20:54
 */
public interface Subject {

    /**
     * 观察者注册
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 观察者移除
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyAllObserver();

}
