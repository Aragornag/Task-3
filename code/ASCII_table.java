package com.company;

import com.jakewharton.fliptables.FlipTable;

public class ASCII_table {
    public static void makeTable(String[] args){
        String[] headers = new String[args.length + 1];
        String[][] data = new String[args.length][args.length + 1];
        headers[0] = "PC / User";

        for (int i = 0; i < args.length; i++){
            headers[i + 1] = args[i];
            data[i][0] = args[i];
        }

        for (int j = 0; j < args.length; j++)
            for (int i = 1; i <= args.length; i++){
                data[j][i] = rules.makeWinner(args,j + 1,i);
            }

        System.out.println(FlipTable.of(headers, data));
        return ;
    }
}
