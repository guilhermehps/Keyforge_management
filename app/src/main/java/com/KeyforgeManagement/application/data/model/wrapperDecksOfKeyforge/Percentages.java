package com.KeyforgeManagement.application.data.model.wrapperDecksOfKeyforge;

public class Percentages {
    private int x;
    private double y;

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Percentages{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
