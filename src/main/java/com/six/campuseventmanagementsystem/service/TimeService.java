package com.six.campuseventmanagementsystem.service;

import org.springframework.stereotype.Service;

@Service
public interface TimeService {
    /**
     *获取当前系统时间
     */
    String getPresentlyTime();
    String getPresentlyDate();
}
