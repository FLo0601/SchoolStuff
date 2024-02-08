package org.example;

public class Circle implements IShape, Comparable<Circle>{
    private int _radius;
    public Circle(int radius) {
        _radius = radius;
    }
    @Override
    public double determineArea() {
        return _radius * _radius * PI;
    }

    @Override
    public int compareTo(Circle o) {
        return (int) (this.determineArea() - ((Circle) o).determineArea());
    }
}
