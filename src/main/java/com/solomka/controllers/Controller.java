package com.solomka.controllers;

import com.solomka.models.Alarm;
import com.solomka.models.dtos.CreateAlarmDto;
import com.solomka.models.dtos.CreateScheduleDto;
import com.solomka.models.dtos.UpdateAlarmDto;
import com.solomka.services.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

@RestController
public class Controller {

    private final AlarmService alarmService;

    @Autowired
    public Controller(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @GetMapping(value = "/alarms")
    public ResponseEntity<List<Alarm>> getAlarms() throws ParseException {
        var alarms = alarmService.getAlarms();
        return new ResponseEntity<>(alarms, HttpStatus.OK);
    }

    @PostMapping(value = "/alarms/add",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAlarm(
            @RequestBody CreateAlarmDto createAlarmDto
    ) {
        var result = alarmService.addAlarm(createAlarmDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping(value = "/alarms/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateAlarm(
            @PathVariable("id") String alarmId,
            @RequestBody UpdateAlarmDto updateAlarmDto
    ) {

        var result = alarmService.updateAlarm(new BigInteger(alarmId), updateAlarmDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/alarms/schedule/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSchedule(
            @PathVariable("id") String alarmId,
            @RequestBody CreateScheduleDto createScheduleDto
            ) {
        var result = alarmService.addSchedule(new BigInteger(alarmId), createScheduleDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}


