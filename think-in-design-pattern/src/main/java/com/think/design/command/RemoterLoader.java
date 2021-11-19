package com.think.design.command;

import com.think.design.command.command.Command;
import com.think.design.command.command.implement.LightOffCommand;
import com.think.design.command.command.implement.LightOnCommand;
import com.think.design.command.command.implement.MacroCommand;
import com.think.design.command.invoker.SimpleRemoteControl;

/**
 * 命令模式
 *  有点类似线程池的执行
 *  Runnable是Command、
 * @author Java男朋友
 * @date 2021-11-19 8:00
 */
public class RemoterLoader {

    public static void main(String[] args) {
        // 制造遥控
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // 设置按钮
        simpleRemoteControl.setCommand(0, new LightOnCommand(), new LightOffCommand());
        // 执行操作
        simpleRemoteControl.onButtonWasPressed(0);
        simpleRemoteControl.offButtonWasPressed(0);
        // 撤销操作
        simpleRemoteControl.undo();

        System.out.println("------------------------宏命令---------------------------");
        // 宏命令
        Command[] onCommands = {new LightOnCommand(), new LightOffCommand()};
        MacroCommand onMacroCommand = new MacroCommand(onCommands);
        Command[] offCommands = {new LightOffCommand(), new LightOnCommand()};
        MacroCommand offMacroCommand = new MacroCommand(offCommands);

        simpleRemoteControl.setCommand(1, onMacroCommand, offMacroCommand);
        simpleRemoteControl.onButtonWasPressed(1);
        simpleRemoteControl.offButtonWasPressed(1);
        simpleRemoteControl.undo();
    }
}
