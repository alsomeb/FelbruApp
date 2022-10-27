package org.example.backend;

public class Piece {
    private int number;


    public Piece(){}

    public Piece(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "number=" + number +
                '}';
    }
}
