package com.alurachallenge.models;

import com.alurachallenge.exceptions.OptionOutOfRangeException;

import java.util.Scanner;

public class AccessMenu {
    String[] currencyCodes = {"USD", "MXN", "ARS", "BRL", "COP", "BOB"};
    Scanner input = new Scanner(System.in);
    String menu = """
                1) US Dolar
                2) Mexico Pesos
                3) Argentina Pesos
                4) Brazil Real
                5) Colombia Peso
                6) Bolivia Boliviano""";

    public String getCode(){
        while (true) {
            try {
                System.out.println(menu);
                int option = input.nextInt();
                if (option <= 0 | option >= 7) {
                    throw new OptionOutOfRangeException("Please choose a valid option");
                }
                return currencyCodes[option - 1];
            } catch (OptionOutOfRangeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
