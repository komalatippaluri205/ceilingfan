package com.ceilingfan.ceiling_fan.Pojo;

import com.ceilingfan.ceiling_fan.pojo.CeilingFan;
import com.ceilingfan.ceiling_fan.pojo.Direction;
import com.ceilingfan.ceiling_fan.pojo.Speed;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CeilingFanTest {

    @Test
    public void test_pullCord1(){
        /*
         * pulling cord1 continuously will take the speed settings from 1,2,3, and 0 and back to 1
         */
        CeilingFan fan = new CeilingFan();
        String speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.getSpeed(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.getSpeed(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED3.getSpeed(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.OFF.getSpeed(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.getSpeed(), speed);
    }


    @Test
    public void test_pullCord2(){
        /*
        pulling cord 1 and 2 randomly changes speed and direction accordingly.
         */
        CeilingFan fan = new CeilingFan();
        IntStream.range(1,2).forEach(i -> fan.pullCord1());

        String speed = fan.getSpeed();
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.getSpeed(), speed);

        fan.pullCord2();
        String direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.REVERSE.getDirection(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.getSpeed(), speed);

        fan.pullCord1();
        direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.REVERSE.getDirection(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.getSpeed(), speed);

        fan.pullCord2();
        direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.FORWARD.getDirection(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.getSpeed(), speed);

    }
}
