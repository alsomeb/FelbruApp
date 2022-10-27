package org.example.backend;

public class Piece {
    private int number;


    public Piece(){}

    public Piece(int number) {
        this.number = number;
    }

    //Default konstruktor för att kunna kontrollera att en Piece ska få värdet 0, som blir "tom"
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
