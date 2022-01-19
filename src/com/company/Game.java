package com.company;

import java.util.Scanner;

public class Game {
    boolean isRunning;
    int points;


    public Game(){
        System.out.println("Let's start fast paced math game");
        points = 0;
        isRunning = true;
    }

    private int getDifficulty(){
        return ((int)points/3 + 1);
    }

    private void playGame() {
        try
        {
            Scanner sc = new Scanner(System.in);
            Question q = new Question();
            System.out.println("What is " + q.generateQuestion(getDifficulty()) + " ?");
            int answer = sc.nextInt();
            if(q.checkAnswer(answer)) points++;
            String message = q.checkAnswer(answer) ? "Correct" : "Wrong Answer. Please Try Again!!";
            System.out.println(message);
        }
        catch (Exception ex) {
            System.out.println("The answer is not in the correct format : " + ex.toString());
        }

    }

    public void run(){
        try {
            Scanner sc = new Scanner(System.in);
            String userInput;
            System.out.println("Do you want to play ? (Y/N)");
            userInput = sc.nextLine().toUpperCase();

            if(userInput.equals("N")){
                System.out.println("Thank you for playing! Your score was " + points);
                isRunning = false;
            }
            else if (userInput.equals("Y")) {
                playGame();
            }
            else {
                System.out.println("Please enter a valid input");
            }
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
