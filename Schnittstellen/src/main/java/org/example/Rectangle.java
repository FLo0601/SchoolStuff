package org.example;

public class Rectangle implements IShape{
    private double _width;
    private double _length;
    public Rectangle(double width, double length) {
        _width = width;
        _length = length;
    }
    @Override
    public double determineArea() {
        return _width * _length;
    }
}
