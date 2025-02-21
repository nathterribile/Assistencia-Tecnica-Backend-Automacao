package com.automation.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DataValidaUtils {

    public static String getDataUtil() {
        LocalDate hoje = LocalDate.now();

        LocalDate diaSeguinte = hoje.plus(1, ChronoUnit.DAYS);
        LocalDate diaUtil = diaSeguinte;

        Boolean diaUtilEncontrado = false;

        while(diaUtilEncontrado == false) {
            if (isDataUtil(diaSeguinte)) {
                diaUtil = diaSeguinte;
                diaUtilEncontrado = true;
            } else {
                diaSeguinte = diaSeguinte.plus(1, ChronoUnit.DAYS);
            }
        }

        

        return formatarData(diaUtil);

    }

    private static boolean isDataUtil(LocalDate data) {
        List<LocalDate> feriados = FeriadosUtils.FERIADOS;

        return data.getDayOfWeek() != DayOfWeek.SATURDAY
                && data.getDayOfWeek() != DayOfWeek.SUNDAY
                && !feriados.contains(data);
    }

    private static String formatarData(LocalDate data) {
        String dia = String.format("%02d", data.getDayOfMonth());
        String mes = String.format("%02d", data.getMonthValue());
        int ano = data.getYear();

        return dia + "." + mes + "." + ano;

    }

    
    
}
