package com.think.design.facade;

import com.think.design.command.command.Command;
import com.think.design.command.command.implement.LightOffCommand;
import com.think.design.command.command.implement.LightOnCommand;

/**
 * 外观模式
 * 有点类似 API 接口和 IOS 的快捷指令，将多个操作合成一步，让客户端感觉自己在一键操作，其实背后进行了很多操作
 * 又有点像命令模式，但是意图不一样，外观模式仅仅是为了提供方便的入口，命令模式是为了将发送方和接收方解耦，以及更细粒度的控制
 * @author Java男朋友
 * @date 2021-12-12 16:19
 */
public class HomeTheaterTestDrive {

    public static void main(String[] args) {
        Command lightOff = new LightOffCommand();
        LightOnCommand lightOnCommand = new LightOnCommand();
        lightOff.execute();
        lightOnCommand.execute();
    }
}
