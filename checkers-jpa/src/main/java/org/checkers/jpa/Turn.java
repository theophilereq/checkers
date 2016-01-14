package org.checkers.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.checkers.core.PieceColour;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @ManyToOne
    Game game;

    private String colour;

    @Column(name="col")
    private int column;

    public Turn() {

    }

    public Turn(Game game, PieceColour colour, int column) {
        this.game = game;
        this.colour = colour.toString();
        this.column = column;
    }

    public PieceColour getColour() {
        return PieceColour.valueOf(colour);
    }

    public int getColumn() {
        return column;
    }


}