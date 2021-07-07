package br.com.mercadolivre.bootcamp.desafiospring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SomeUtils {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    static Calendar calendar = Calendar.getInstance();

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

    public static Date getDataDuasSemanasAtras(Date dataAtual){
        calendar.setTime(dataAtual);
        calendar.add(Calendar.DATE, - 14);
        return calendar.getTime();
    }
}
