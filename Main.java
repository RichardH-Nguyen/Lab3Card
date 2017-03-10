package com.Richard;

import javafx.util.StringConverter;

import java.util.Scanner;

public class Main {
    static Scanner stringScanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your card number.");
        String cardNum = stringScanner.nextLine();
	    boolean visaCheck = isVisaCreditCardNumber(cardNum);

	    if (visaCheck == true){
            System.out.println("YAY!");
        }else {
            System.out.println("NAY!");
        }
    }

    public static boolean isVisaCreditCardNumber(String cardNumber){
        char[] numArray = cardNumber.toCharArray();
        int cardTotal = 0;
        int digitCheck = 0;
        boolean visaCard = false;

        if(Character.getNumericValue(numArray[0]) == 4){
            for(int x = 2 ; x <= 14 ; x += 2){
                digitCheck = Character.getNumericValue(numArray[x]) * 2;
                if(digitCheck >= 10){
                    String decaString = Integer.toString(digitCheck);
                    char[] decaArray = decaString.toCharArray();
                    cardTotal += Character.getNumericValue(decaArray[0]) + Character.getNumericValue(decaArray[1]);
                }else{
                    cardTotal+= digitCheck;
                }
            }
            for(int x = 1 ; x <= 15 ; x += 2){
                cardTotal += Character.getNumericValue(numArray[x]);
            }
            cardTotal += 8;
        }

        double visaConfirm = cardTotal % 10;
        if(visaConfirm == 0){
            visaCard = true;
            return visaCard;
        }else{
            return visaCard;
        }
    }
}
