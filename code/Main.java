package com.company;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        if ((args.length < 3) || (args.length % 2 == 0)){
            System.out.println("The minimum amount of arguments = 3, need an odd amount");
            return;
        }

        for (int i = 0; i < args.length - 1; i++){
            for (int j = i + 1; j < args.length; j++){
                if (args[i].equals(args[j])) {System.out.println("Arguments must be different\nExample: 1 2 3");return;}
            }
        }

        SecureRandom random = SecureRandom.getInstanceStrong();
        int max = args.length;
        int min = 1;
        int pcMove = random.nextInt(max-min+1)+min;

        String secretKey = Hmac.getSecretKey(8).toString();

        System.out.println("HMAC:\n" + Hmac.hmacSha256(args[pcMove - 1],secretKey));
        System.out.println("Available moves:");

        for (int i = 0; i < args.length; i++){
            System.out.println(i + 1 + " - " + args[i]);
        }
        System.out.println("0 - exit\n? - help");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move:");
        String userMove = scanner.nextLine();

        if(userMove.equals("?")){
            ASCII_table.makeTable(args);
            System.out.print("Enter your move:");
            userMove = scanner.nextLine();
        }
        if (Integer.parseInt(userMove) == 0) return;

        System.out.println("Your move:" + args[Integer.parseInt(userMove) - 1]);
        System.out.println("Computer move:" + args[pcMove - 1]);
        System.out.println(rules.makeWinner(args,pcMove,Integer.parseInt(userMove)));
        System.out.println("HMAC key: " + secretKey);
    }
}
