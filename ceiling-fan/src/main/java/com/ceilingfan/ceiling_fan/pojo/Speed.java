package com.ceilingfan.ceiling_fan.pojo;

public enum Speed {

    SPEED1("SPEED1"), SPEED2("SPEED2"), SPEED3("SPEED3"), OFF("OFF");

    private String speed;
    Speed(String speed) {
        this.speed = speed;
    }

    public String getSpeed(){
        return this.speed;
    }
}
