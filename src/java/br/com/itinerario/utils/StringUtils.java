/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Allyson
 */
public class StringUtils {
    
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    
    public static String dateToString(Date date){
        try{
            return new SimpleDateFormat(DATE_FORMAT).format(date);
        }catch(Exception e){
            e.printStackTrace();
            return "";
        } 
    }
    
    public static Date stringToDate(String dataStr){
        try{
            return new SimpleDateFormat(DATE_FORMAT).parse(dataStr);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
