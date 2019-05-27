package com.gmail.goyter012.Equations.services;

import com.gmail.goyter012.Equations.models.EqualDataSample;
import com.gmail.goyter012.Equations.models.EqualResModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class Executor {

    public static EqualDataSample loaderFromJsonFile(File file){
        Gson gson = new Gson();
        EqualDataSample model = null;
        try{
            model = gson.fromJson(new FileReader(file),EqualDataSample.class);
        }catch (JsonIOException | JsonSyntaxException | FileNotFoundException e ){
            return null;
        }
        return model;
    }

    public static void saveToJson(EqualResModel model,String filename){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String modeljson = gson.toJson(model);
        try(PrintWriter pw = new PrintWriter(new File(filename))) {
            pw.println(modeljson);
        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    public static double f(double x ){
        return Math.pow(x,3) - 2*x*x + x + 1;
    }

    public static double methodChord(double a, double b, double e){
        double xNext = 0;   
        double temp;
        do{
            temp = xNext;
            xNext = b - f(b)*(a-b)/(f(a) - f(b));
            a = b;
            b = temp;
        }while (Math.abs(xNext - b) > e);
        return xNext;
    }









}
