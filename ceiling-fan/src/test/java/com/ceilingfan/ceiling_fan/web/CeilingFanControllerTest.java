package com.ceilingfan.ceiling_fan.web;

import com.ceilingfan.ceiling_fan.pojo.Direction;
import com.ceilingfan.ceiling_fan.pojo.Speed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(CeilingFanController.class)
public class CeilingFanControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void test_pullCord1And2() throws Exception{
        /*
        pull cord1 to get speed1 and pull cord2 to speed0
         */
        MvcResult result = mockMvc.perform(get("/pullcord1")).andReturn();

        String speed = result.getResponse().getContentAsString();
        Assertions.assertNotNull(speed);
        Assertions.assertEquals(Speed.SPEED1.getSpeed(),speed);

        result = mockMvc.perform(get("/pullcord2")).andReturn();
        String direction = result.getResponse().getContentAsString();
        Assertions.assertNotNull(direction);
        Assertions.assertEquals(Direction.REVERSE.getDirection(),direction);

        /*
         * pull cord1 3 times to get speed3 and pull cord2 2 times to get speed1
         */
        result = mockMvc.perform(get("/pullcord1")).andReturn();
        speed = result.getResponse().getContentAsString();
        Assertions.assertNotNull(speed);
        Assertions.assertEquals(Speed.SPEED2.getSpeed(),speed);

        result = mockMvc.perform(get("/pullcord1")).andReturn();
        speed = result.getResponse().getContentAsString();
        Assertions.assertNotNull(speed);
        Assertions.assertEquals(Speed.SPEED3.getSpeed(),speed);

        result = mockMvc.perform(get("/pullcord2")).andReturn();
        direction = result.getResponse().getContentAsString();
        Assertions.assertNotNull(direction);
        Assertions.assertEquals(Direction.FORWARD.getDirection(),direction);

        result = mockMvc.perform(get("/pullcord2")).andReturn();
        direction = result.getResponse().getContentAsString();
        Assertions.assertNotNull(direction);
        Assertions.assertEquals(Direction.REVERSE.getDirection(),direction);

    }
}
