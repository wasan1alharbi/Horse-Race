package com.mycompany.race;

public class Horse {
    // Fields of class Horse
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence;

    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;
        this.confidence = horseConfidence;
        this.distanceTravelled = 0;
        this.fallen = false;
    }

    // Other methods of class Horse
    public void fall() {
        fallen = true;
    }

    public double getConfidence() {
        return confidence;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void goBackToStart() {
        distanceTravelled = 0;
        fallen = false;
    }

    public boolean hasFallen() {
        return fallen;
    }

    public void moveForward() {
        distanceTravelled++;
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            this.confidence = newConfidence;
        } else {
            System.out.println("Confidence rating must be between 0 and 1.");
        }
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }

    
}
