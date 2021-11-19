package com.think.design.command.command.implement;

import com.think.design.command.command.Command;

/**
 * 空命令对象-初始化时使用
 * @author Java男朋友
 * @date 2021-11-19 7:54
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
