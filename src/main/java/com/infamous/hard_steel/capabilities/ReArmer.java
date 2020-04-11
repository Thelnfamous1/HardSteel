package com.infamous.hard_steel.capabilities;

public class ReArmer implements IReArmer{

    private boolean isReArmed;

    public ReArmer(){
        this.isReArmed = false;
    }

    @Override
    public boolean getReArmed() {
        return this.isReArmed;
    }

    @Override
    public void setReArmed(boolean isReArmed) {
        this.isReArmed = isReArmed;
    }
}
