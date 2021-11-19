package com.think.design.command.command.implement;

import com.think.design.command.command.Command;
import com.think.design.command.receiver.Light;

/**
 * @author Java男朋友
 * @date 2021-11-19 7:45
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(){
        this.light = new Light();
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
