package com.ssm.entity;

/**
 * Created by caitongbo.
 * Date: 2018/6/4
 * Time: 11:55
 */
public class Point {
    private Double x; // x轴

    private Double y; // y轴

    public Point() {
        super();
    }

    public Point(Double x, Double y) {
        super();
        this.x = x;
        this.y = y;
    }



    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    // 方便测试数据(项目正式上线时要注释掉)
	/*@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}*/

}