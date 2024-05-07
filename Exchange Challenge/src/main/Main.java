package main;

import com.alurachallenge.models.AccessMenu;
import com.alurachallenge.models.ApiRequest;
import com.alurachallenge.models.Conversion;
import com.alurachallenge.models.ExchangeApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccessMenu menu = new AccessMenu();
        Scanner input = new Scanner(System.in);
        String baseCode;
        String targetCode;
        int exit = 0;
        while (exit != 1){
            try{
                System.out.println("*".repeat(50)+"\nChoose the base currency:");
                baseCode = menu.getCode();
                System.out.println("Amount: ");
                double amount = input.nextDouble();

                System.out.println("Convert to:");
                targetCode = menu.getCode();

                ApiRequest request = new ApiRequest(baseCode, targetCode);
                Conversion conversion = new Conversion(request.getInfo(), amount);

                System.out.println(conversion);

                System.out.println("*".repeat(50));

                System.out.println("""
                    ¿Continue?
                    - No -> press 1
                    - Yes -> press any other key""");
                exit = input.nextInt();

                if (exit == 1){
                    System.out.println("!Good Bye¡");
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}