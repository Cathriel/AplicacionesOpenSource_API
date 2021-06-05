package com.roomies.cucumber.landlordcucumber.landlordcommon;

import com.roomies.roomies.RoomiesApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = RoomiesApplication.class)
public class CucumberSpringConfiguration {
}