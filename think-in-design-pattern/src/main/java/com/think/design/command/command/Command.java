package com.think.design.command.command;

/**
 * 抽象的命令
 * @author Java男朋友
 * @date 2021-11-19 7:45
 */
public interface Command {
    /**
     * 用于命令模式执行命令
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();
}
