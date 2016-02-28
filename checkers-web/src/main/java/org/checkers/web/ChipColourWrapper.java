package org.checkers.web;

import org.checkers.core.PieceColour;

public class ChipColourWrapper {

    private PieceColour cell;
    private int index;

    public ChipColourWrapper(PieceColour cell, int i) {
        this.cell = cell;
        this.index = i;
    }

    public String getCssColor() {
        if(PieceColour.BLACK == cell) {
            return "black";
        } else if(PieceColour.WHITE ==cell) {
            return "red";
        } else {
            return "null";
        }
    }

    public int getIndex() {
        return index;
    }
}
