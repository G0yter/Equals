package com.gmail.goyter012.Equations.models;

public class EqualDataSample {

    private double a;
    private double b;
    private double e;


    public EqualDataSample(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }


    @Override
    public String toString() {
        return "EqualDataSample{" +
                "a=" + a +
                ", b=" + b +
                ", e=" + e +
                '}';
    }
}
