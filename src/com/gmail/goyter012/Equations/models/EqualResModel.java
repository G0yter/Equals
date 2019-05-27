package com.gmail.goyter012.Equations.models;

public class EqualResModel {

    private double res;

    public EqualResModel(double res) {
        this.res = res;
    }

    public EqualResModel() {
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }


    @Override
    public String toString() {
        return "EqualResModel{" +
                "res=" + res +
                '}';
    }
}
