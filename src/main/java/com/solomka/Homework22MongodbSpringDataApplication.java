package com.solomka;

import com.mongodb.client.MongoCollection;
import com.solomka.models.Alarm;
import com.solomka.models.Schedule;
import com.solomka.models.dtos.CreateAlarmDto;
import com.solomka.services.AlarmService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@SpringBootApplication
public class Homework22MongodbSpringDataApplication {

    private final AlarmService alarmService;

    @Autowired
    public Homework22MongodbSpringDataApplication(AlarmService alarmService) {
        this.alarmService = alarmService;
    }


    public static void main(String[] args) {
        SpringApplication.run(Homework22MongodbSpringDataApplication.class, args);
    }

    @PostConstruct
    public void fillMongoDB() {
        CreateAlarmDto createAlarmDto = new CreateAlarmDto();
        createAlarmDto.setDate(new Date());
        createAlarmDto.setRingtone("Leonard Cohen - Avalanche");
        createAlarmDto.setName(Utils.getRandomNameAlarm());
        alarmService.addAlarm(createAlarmDto);
    }
}
