package com.gmail.goyter012.Equations.services;

import com.gmail.goyter012.Equations.models.EqualDataSample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class Executor {

    public static void saveToJsonFile(EqualDataSample model, File file ){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String st = ((Gson) gson).toJson(model);
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(st);
        }catch (IOException e){
            e.printStackTrace();
        }
    }



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









}
