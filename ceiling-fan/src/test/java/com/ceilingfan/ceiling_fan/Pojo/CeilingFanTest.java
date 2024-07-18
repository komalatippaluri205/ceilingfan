package com.ceilingfan.ceiling_fan.Pojo;

import com.ceilingfan.ceiling_fan.pojo.CeilingFan;
import com.ceilingfan.ceiling_fan.pojo.CeilingFan.Speed;
import com.ceilingfan.ceiling_fan.pojo.CeilingFan.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
        assertEquals(Speed.SPEED1.toString(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.toString(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED3.toString(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.OFF.toString(), speed);

        speed = fan.pullCord1();
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.toString(), speed);
    }


    @Test
    public void test_pullCord2(){
        /*
        pulling cord 1 and 2 randomly changes speed and direction accordingly.
         */
        CeilingFan fan = new CeilingFan();
        fan.pullCord1();
        String speed = fan.getSpeed();
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.toString(), speed);

        fan.pullCord2();
        String direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.REVERSE.toString(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED1.toString(), speed);

        fan.pullCord1();
        direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.REVERSE.toString(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.toString(), speed);

        fan.pullCord2();
        direction = fan.getDirection();
        speed = fan.getSpeed();
        assertNotNull(direction);
        assertEquals(Direction.FORWARD.toString(), direction);
        assertNotNull(speed);
        assertEquals(Speed.SPEED2.toString(), speed);

    }
}
