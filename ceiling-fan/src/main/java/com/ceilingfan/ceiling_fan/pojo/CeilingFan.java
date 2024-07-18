package com.ceilingfan.ceiling_fan.pojo;

import java.util.LinkedList;
import java.util.List;

public class CeilingFan {

    private final List<Speed> settings = new LinkedList<>();
    private int index;
    private String speed;

    private String direction;

    public CeilingFan() {
        settings.add(Speed.OFF);
        settings.add(Speed.SPEED1);
        settings.add(Speed.SPEED2);
        settings.add(Speed.SPEED3);
        //setting initial speed of fan
        index = 0;

        //setting initial values of fan
        speed = Speed.OFF.toString();
        direction = Direction.FORWARD.toString();
    }

    public String getSpeed() {
        return this.speed;
    }

    public String getDirection(){
        return this.direction;
    }

    public String pullCord1() {
        if (++index == settings.size()) {
            index = 0;
        }
        this.speed = settings.get(index).toString();
        return this.speed;
    }

    public String pullCord2() {
        if (Direction.FORWARD.toString().equals(this.direction)) {
            this.direction = Direction.REVERSE.toString();
        } else {
            this.direction = Direction.FORWARD.toString();
        }
        return this.direction;
    }

    public CeilingFan reset(){
        this.speed = Speed.OFF.toString();
        this.direction = Direction.FORWARD.toString();
        this.index = 0;
        return this;
    }

    public enum Speed{
        SPEED1,SPEED2,SPEED3,OFF;
    }

    public enum Direction{
        FORWARD, REVERSE;
    }

}
