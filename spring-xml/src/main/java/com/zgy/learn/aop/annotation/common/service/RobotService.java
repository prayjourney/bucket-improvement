package com.zgy.learn.aop.annotation.common.service;

import com.zgy.learn.aop.annotation.common.pojo.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    @Autowired
    Robot robot;

    public void openRobot() {
        robot.openRobot();
    }

    public void sweepFloor() {
        robot.sweepFloor();
    }

    public void infuseTea() {
        robot.infuseTea();
    }

    public void closeRobot() {
        robot.closeRobot();
    }

}
