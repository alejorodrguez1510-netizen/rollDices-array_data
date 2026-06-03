/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rolldices;

import java.util.Random;
import java.util.Scanner;

public class RollDices {

    public static int rollDices() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {

        Scanner data = new Scanner(System.in);

        int lives = 5;
        int dice1, dice2;

        int launchNumber = 0;
        int evenSums = 0;
        int oddSums = 0;
        int equalDices = 0;
        int consecutiveEquals = 0;

        String playerName;
        String key;

        System.out.println("::: WELCOME TO ROLL DICES :::");
        System.out.print("Your player name: ");
        playerName = data.nextLine();

        System.out.println("\nPress ENTER to start the game...");
        key = data.nextLine();

        boolean gameOver = false;
        boolean youWin = false;

        while (!gameOver && !youWin) {

            launchNumber++;

            dice1 = rollDices();
            dice2 = rollDices();

            int sum = dice1 + dice2;

            System.out.println("\n=========================");
            System.out.println("Launch L" + launchNumber);
            System.out.println("=========================");
            System.out.println("Player: " + playerName);
            System.out.println("Lives: " + lives);
            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            System.out.println("Sum: " + sum);

            // Si sale un 6 gana una vida
            if (dice1 == 6 || dice2 == 6) {
                lives++;
                System.out.println("BONUS! You got a 6. +1 life");
            }

            // Dados iguales
            if (dice1 == dice2) {
                equalDices++;
                consecutiveEquals++;

                System.out.println("Equal dices!");

                if (consecutiveEquals == 3) {
                    youWin = true;
                    System.out.println("\n***************");
                    System.out.println("   YOU WIN!    ");
                    System.out.println("***************");
                }

            } else {
                consecutiveEquals = 0;
            }

            // Suma par o impar
            if (sum % 2 == 0) {
                evenSums++;
                System.out.println("Even sum. Keep playing.");
            } else {
                oddSums++;
                lives--;
                System.out.println("Odd sum. You lose 1 life.");
            }

            // Verificar vidas
            if (lives <= 0) {
                gameOver = true;

                System.out.println("\n***************");
                System.out.println("  GAME OVER    ");
                System.out.println("***************");
            }

            if (!gameOver && !youWin) {
                System.out.println("\nPress ENTER to continue...");
                data.nextLine();
            }
        }

        // REPORTE FINAL
        System.out.println("\n=================================");
        System.out.println("          FINAL REPORT");
        System.out.println("=================================");
        System.out.println("Player: " + playerName);
        System.out.println("Remaining lives: " + lives);
        System.out.println("Total launches: " + launchNumber);
        System.out.println("Total even sums: " + evenSums);
        System.out.println("Total odd sums: " + oddSums);
        System.out.println("Total equal dices: " + equalDices);
        System.out.println("=================================");

        data.close();
    }
}