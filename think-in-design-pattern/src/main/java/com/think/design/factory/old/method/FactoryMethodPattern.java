package com.think.design.factory.old.method;

import com.think.common.utils.ReadPropertiesByClassLoader;

/**
 * 是否可以只拥有抽象产品和具体产品，在使用时直接反射产品而无需创建工厂，即使新增产品也只需要增加新产品代码+改变配置文件？
 * 工厂除了将创建和使用对象分离，还有一个作用就是可以屏蔽一些创建对象后初始化的事情，如果直接反射具体的产品对象，
 * 那么反射对象后，需要每次都做初始化的工作，而放在工厂中，就不需要每次都初始化了（单一职责）
 * 工厂方法模式的主要优点如下：
 *
 *        (1) 在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
 *
 *        (2) 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够让工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，就正是因为所有的具体工厂类都具有同一抽象父类。
 *
 *        (3) 使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了，这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。
 *
 * @author yc
 * @description
 * @date 2021-09-23 14:18
 */
public class FactoryMethodPattern {
    public static void main(String[] args) throws Exception {
        LoggerFactory factory = new FileLoggerFactory();
        Logger logger = factory.createLogger();
        logger.writeLog();
        System.out.println("===================通过配置文件+反射实现动态修改写日志方式==================");
//        LoggerFactory bean = (LoggerFactory) ReadPropertiesByClassLoader.getBean("design-pattern.properties", "factory.method.className");
//        bean.createLogger().writeLog();
        Class<?> aClass = Class.forName(ReadPropertiesByClassLoader.getStrFromProperties("design-pattern.properties", "factory.method.className"));
        LoggerFactory loggerFactory = (LoggerFactory) aClass.newInstance();
        Logger loggerFactoryLogger = loggerFactory.createLogger();
        loggerFactoryLogger.writeLog();
        System.out.println("===========================简化版写法:直接调用============================");
        LoggerSimpleFactory dataSourceLoggerFactory = new DataSourceLoggerFactory();
        dataSourceLoggerFactory.writeLog();
    }
}

//日志记录器接口：抽象产品
interface Logger {
    public void writeLog();
}

//数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}

//文件日志记录器：具体产品
class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录。");
    }
}

//日志记录器工厂接口：抽象工厂
interface LoggerFactory {
    public Logger createLogger();
    public Logger createLogger(String args);
    public Logger createLogger(Object obj);
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //使用默认方式连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }

    @Override
    public Logger createLogger(String args) {
        //使用参数args作为连接字符串来连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }

    @Override
    public Logger createLogger(Object obj) {
        //使用封装在参数obj中的连接字符串来连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        //使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略
        return logger;
    }
}



//文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码省略
        return logger;
    }

    @Override
    public Logger createLogger(String args) {
        return null;
    }

    @Override
    public Logger createLogger(Object obj) {
        return null;
    }
}

//简略版的工厂
abstract class LoggerSimpleFactory{
    void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
    abstract Logger createLogger();
}

class DataSourceLoggerFactory extends LoggerSimpleFactory{

    @Override
    Logger createLogger() {
        return new DatabaseLogger();
    }
}