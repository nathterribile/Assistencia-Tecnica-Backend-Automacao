package com.automation.utils;

import java.util.Random;

public abstract class CpfUtils {

    public static String geraCpfValido() {
        String cpfNoveDigitos = geraCpf();
        String cpfDezDigitos = criaCpfPrimeiroDigito(cpfNoveDigitos);
        return criaCpfSegundoDigito(cpfDezDigitos);
    }
    private static String geraCpf() {
        Random numeroAleatorio = new Random();
        String cpf = "";
        for(int i = 0; i < 9; i++) {
            cpf += String.valueOf(numeroAleatorio.nextInt(10));
        }
        return cpf;
    }

    private static String criaCpfPrimeiroDigito(String cpf) {
        String cpfPrimeiroDigito = cpf;
        Integer somaCpfPrimeiroDigito = 0;
        for(int i = 0; i <= 8; i++) {
            Integer fator = 10 - i;
            char caractere = cpf.charAt(i);
            Integer numero = Integer.valueOf(String.valueOf(caractere)) * fator;
            somaCpfPrimeiroDigito += numero;
        }
        Integer restoDivisao = somaCpfPrimeiroDigito % 11;
        if(restoDivisao >= 2) {
            Integer primeiroDigito = 11 - restoDivisao;
            cpfPrimeiroDigito += String.valueOf(primeiroDigito);
        } else {
            cpfPrimeiroDigito += "0";
        }
        return cpfPrimeiroDigito;
    }

    private static String criaCpfSegundoDigito(String cpf) {
        String cpfSegundoDigito = cpf;
        Integer somaCpfSegundoDigito = 0;
        for(int i = 0; i <= 9; i++) {
            Integer fator = 11 - i;
            char caractere = cpf.charAt(i);
            Integer numero = Integer.valueOf(String.valueOf(caractere)) * fator;
            somaCpfSegundoDigito += numero;
        }
        Integer restoDivisao = somaCpfSegundoDigito % 11;
        if(restoDivisao >= 2) {
            Integer primeiroDigito = 11 - restoDivisao;
            cpfSegundoDigito += String.valueOf(primeiroDigito);
        } else {
            cpfSegundoDigito += "0";
        }
        return cpfSegundoDigito;
    }
}
