package org.checkers.web;

import org.checkers.core.PieceColour;

/**
 * Created by isen on 28/01/2016.
 */
public class ChipColourWrapper {

    private PieceColour cell;

    public ChipColourWrapper(PieceColour cell) {
        this.cell = cell;
    }

    public String getCssColor() {
        if(PieceColour.BLACK == cell) {
            return "black";
        } else if(PieceColour.WHITE ==cell) {
            return "white";
        } else {
            return "";
        }
    }
}
