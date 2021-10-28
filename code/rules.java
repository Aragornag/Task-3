package com.company;

public class rules {

    public static String makeWinner(String[] args, int pcMove, int userMove) {
        if (pcMove == userMove) {
            return "Draw!";
        }

        for (int i = 1; i <= args.length / 2; i++) {
            userMove++;
            if (userMove > args.length) userMove = 1;
            if (pcMove == userMove) return "Lose!";
        }
        return "Win!";
    }
}
