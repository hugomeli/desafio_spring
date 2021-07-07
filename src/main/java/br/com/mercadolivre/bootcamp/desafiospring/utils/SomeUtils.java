package br.com.mercadolivre.bootcamp.desafiospring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SomeUtils {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Date converteStringData(String dataString){
        try{
            return sdf.parse(dataString);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String converteDataString(Date date) {
        return sdf.format(date);
    }
}
