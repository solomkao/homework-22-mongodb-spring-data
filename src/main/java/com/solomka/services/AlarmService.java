package com.solomka.services;

import com.solomka.Utils;
import com.solomka.exceptions.AlarmNotFoundException;
import com.solomka.models.Alarm;
import com.solomka.models.Schedule;
import com.solomka.models.dtos.CreateAlarmDto;
import com.solomka.models.dtos.CreateScheduleDto;
import com.solomka.models.dtos.UpdateAlarmDto;
import com.solomka.repositories.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AlarmService {

    private final AlarmRepository alarmRepository;

    @Autowired
    public AlarmService(AlarmRepository alarmRepository) {
        this.alarmRepository = alarmRepository;
    }

    public List<Alarm> getAlarms() {
        return alarmRepository.findAll();
    }

    public Alarm addAlarm(CreateAlarmDto createAlarmDto) {
        Alarm alarm = new Alarm();
        alarm.setName(createAlarmDto.getName());
        alarm.setDate(createAlarmDto.getDate());
        alarm.setRingtone(createAlarmDto.getRingtone());
        alarm.setDisable(false);
        alarm.setSchedule(Schedule.ONCE);
        return alarmRepository.save(alarm);
    }

    public Alarm updateAlarm(BigInteger alarmId, UpdateAlarmDto updateAlarmDto) {
        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow(AlarmNotFoundException::new);
        alarm.setName(updateAlarmDto.getName());
        alarm.setDate(updateAlarmDto.getDate());
        alarm.setDisable(updateAlarmDto.isDisable());
        alarm.setRingtone(updateAlarmDto.getRingtone());
        return alarmRepository.save(alarm);
    }

    public Alarm addSchedule(BigInteger alarmId, CreateScheduleDto createScheduleDto) {
        Alarm alarm = alarmRepository.findById(alarmId).orElseThrow(AlarmNotFoundException::new);
        Schedule schedule = Utils.convertStringToSchedule(createScheduleDto.getSchedule());
        alarm.setSchedule(schedule);
        return alarmRepository.save(alarm);
    }
}
