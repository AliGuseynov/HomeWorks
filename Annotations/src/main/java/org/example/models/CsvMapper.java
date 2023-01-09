package org.example.models;
import org.example.annotations.Csv;
import org.example.annotations.CsvColumn;
import org.example.exceptions.ColumnNotFoundException;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CsvMapper{

    public static Car mapCar(String[] vals, HashMap<String, Integer> keys) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ColumnNotFoundException {
        Car s = new Car();
        int i = 0;
        if(s.getClass().isAnnotationPresent(Csv.class)){

            for(Field f : Car.class.getDeclaredFields()){
//                System.out.println(f.getName());
                if(f.isAnnotationPresent(CsvColumn.class)){
                    CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String name = f.getName();
                    name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = Car.class.getMethod(name, String.class);
                    if (keys.containsKey(f.getName())){
                    method.invoke(s, vals[keys.get(f.getName())]);
                    } else {
                        throw new ColumnNotFoundException();
                    }
                }
            }
        }
        return s;
    }

    public static String carToCSV(Car car){
        StringBuilder csvOut = new StringBuilder();
        csvOut.append(",");

        if(car.getClass().isAnnotationPresent(Csv.class)){


            for(Field f : Car.class.getDeclaredFields()){
//                System.out.println(f.getName());
                if(f.isAnnotationPresent(CsvColumn.class)){
                    try {
                        CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String name = f.getName();
                    name = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);

                    Method method = Car.class.getMethod(name);
                    csvOut.append(method.invoke(car) + ",");

                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        System.out.println("error: " + e.getMessage());
                    }


                }
            }
                }
        csvOut.append(",\n");

        return String.valueOf(csvOut);
    }
}

