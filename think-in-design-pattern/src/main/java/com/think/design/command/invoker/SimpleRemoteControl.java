package com.think.design.command.invoker;

import com.think.design.command.command.Command;
import com.think.design.command.command.implement.NoCommand;

import java.text.SimpleDateFormat;

/**
 * 执行者-遥控器
 * @author Java男朋友
 * @date 2021-11-19 7:49
 */
public class SimpleRemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public SimpleRemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];
        for (Command command : onCommands) {
            command = new NoCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    public void undo(){
        undoCommand.undo();
    }
}
