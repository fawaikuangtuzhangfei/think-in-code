package com.think.design.command.command.implement;

import com.think.design.command.command.Command;

/**
 * 宏命令-快捷指令
 * @author Java男朋友
 * @date 2021-11-19 8:20
 */
public class MacroCommand implements Command {

    private Command[] commands;

    public MacroCommand(Command[] commands){
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
