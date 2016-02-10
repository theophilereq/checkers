package org.checkers.web;

import org.checkers.core.CheckersGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isen on 28/01/2016.
 */
public class CheckersColumn {

    private int index;
    private CheckersGame game;

    public CheckersColumn(int i, CheckersGame game) {
        this.index = i;
        this.game = game;
    }

    public List<ChipColourWrapper> getCells() {
        List<ChipColourWrapper> cells = new ArrayList<>();
        for (int i = game.getRowsNumber() - 1; i >= 0; i--) {
            cells.add(new ChipColourWrapper(game.getCell(index, i), i));
        }
        return cells;
    }

    public int getIndex() {
        return index;
    }

}
