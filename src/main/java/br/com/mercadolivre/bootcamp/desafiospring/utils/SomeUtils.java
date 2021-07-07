package br.com.mercadolivre.bootcamp.desafiospring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SomeUtils {

    public static Date converteStringData(String dataString){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            return sdf.parse(dataString);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
