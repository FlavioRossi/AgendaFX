/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FLAVIO
 */
public class DateUtil {
    private static final String DD_MM_AAAA = "dd/MM/yyyy";
    
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern(DD_MM_AAAA);
    
    public static String formato(LocalDate date){
        if (date == null) {
            return null;
        }
        return FORMATO.format(date);
    }
    
    public static LocalDate parse(String dateString){
        try {
            return FORMATO.parse(dateString, LocalDate::from);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean validaDate(String dateString){
        return DateUtil.parse(dateString) != null;
    }
}
