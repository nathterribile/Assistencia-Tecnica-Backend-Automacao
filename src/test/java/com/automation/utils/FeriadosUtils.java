package com.automation.utils;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class FeriadosUtils {

    private static final int ANO_ATUAL = Year.now().getValue();

    public static final List<LocalDate> FERIADOS = Arrays.asList(
        LocalDate.of(ANO_ATUAL, 1, 1), // Ano Novo
        LocalDate.of(ANO_ATUAL, 4, 21), // Tiradentes
        LocalDate.of(ANO_ATUAL, 5, 1), // Dia do Trabalho
        LocalDate.of(ANO_ATUAL, 9, 7), // Independência do Brasil
        LocalDate.of(ANO_ATUAL, 10, 12), // Nossa Senhora Aparecida
        LocalDate.of(ANO_ATUAL, 11, 2), // Finados
        LocalDate.of(ANO_ATUAL, 11, 15), // Proclamação da República
        LocalDate.of(ANO_ATUAL, 12, 25), // Natal

        calcularPascoa(ANO_ATUAL).plusDays(60), // Corpus Christi

        calcularPascoa(ANO_ATUAL).minusDays(48), // Segunda-feira de Carnaval
        calcularPascoa(ANO_ATUAL).minusDays(47), // Terça-feira de Carnaval
        calcularPascoa(ANO_ATUAL).minusDays(46), // Quarta-feira de Cinzas

        calcularPascoa(ANO_ATUAL).minusDays(2) // Sexta-feira Santa
    );

    /**
     * Calcula a data da Páscoa dado o ano,
     * através do algoritmo de Meeus/Jones/Butcher:
     * (Referência da wikipédia)
     */
    private static LocalDate calcularPascoa(int ano) {
        int a = ano % 19;
        int b = ano / 100;
        int c = ano % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int mes = (h + l - 7 * m + 114) / 31;
        int dia = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(ano, mes, dia);
    }
    
}
