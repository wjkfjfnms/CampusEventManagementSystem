package com.six.campuseventmanagementsystem.service.impl;

import com.six.campuseventmanagementsystem.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeServiceImpl implements TimeService{

    String presentlyTime;

    /**
     *获取当前系统时间
     * @return  返回当前时间
     */
    @Override
    public String getPresentlyTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String presentlyTime = currentDateTime.format(formatter);
        return presentlyTime;
    }

    @Override
    public String getPresentlyDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String presentlyTime = currentDateTime.format(formatter);
        return presentlyTime;
    }

}
