package com.solomka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Alarm {

    @Id
    private BigInteger id;

    private Date date;

    private boolean disable;

    private String name;

    private String ringtone;

    private Schedule schedule;
}
