package org.checkers.web;

import org.checkers.core.PieceColour;

/**
 * Created by isen on 28/01/2016.
 */
public class ChipColourWrapper {

    private int index;
    private PieceColour cell;

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
