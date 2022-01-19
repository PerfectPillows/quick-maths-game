package com.company;

public class Question {

    private int num1;
    private int num2;
    private char operator;
    private final char[] operators = {'+','-','x'};

    public Question() {}

    public String generateQuestion(int difficulty){
        StringBuilder question = new StringBuilder();
        num1 = generateRandomNumber(1,10 * difficulty);
        num2 = generateRandomNumber(1,10 * difficulty) ;
        if(num2 > num1) swap();
        operator = operators[generateRandomNumber(0,2)];
        return question.append(num1).append(" ").append(operator).append(" ").append(num2).toString();
    }

    private void swap(){
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }

    public boolean checkAnswer(int answer){
        int correctAnswer = Integer.MIN_VALUE;
        switch (operator) {
            case '+' -> correctAnswer = num1 + num2;
            case '-' -> correctAnswer = num1 - num2;
            case 'x' -> correctAnswer = num1 * num2;
            default -> {
            }
        }
        return correctAnswer == answer;
    }

    private int generateRandomNumber(int min,int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
