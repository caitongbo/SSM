package com.ssm.command;

import com.ssm.entity.Point;

import java.util.Date;
/**
 * Created by caitongbo.
 * Date: 2018/6/4
 * Time: 11:53
 */
public class BinderCommand {
    // 坐标  entity.Point
    private Point point;

    // 生日
    private Date birthday;

    public BinderCommand() {
        super();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
