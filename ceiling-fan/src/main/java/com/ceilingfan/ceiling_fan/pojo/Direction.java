package com.ceilingfan.ceiling_fan.pojo;

public enum Direction {
    FORWARD("FORWARD"),REVERSE("REVERSE");

    private String direction;
    Direction(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return this.direction;
    }
}
