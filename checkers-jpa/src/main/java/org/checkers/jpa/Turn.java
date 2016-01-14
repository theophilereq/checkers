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

    @Column(name="rowSelected")
    private int rowSelected;
    
    @Column(name="columnSelected")
    private int columnSelected;
    
    @Column(name="rowTargeted")
    private int rowTargeted;
    
    @Column(name="columnTargeted")
    private int columnTargeted;

    public Turn() {

    }

    public Turn(Game game, PieceColour colour, int rowSelected, int columnSelected, int rowTargeted, int columnTargeted) {
        this.game = game;
        this.colour = colour.toString();
        this.rowSelected = rowSelected;
        this.columnSelected = columnSelected;
        this.rowTargeted = rowTargeted;
        this.columnTargeted = columnTargeted;
    }

    public PieceColour getColour() {
        return PieceColour.valueOf(colour);
    }
    
    public int getRowSelected() {
        return rowSelected;
    }

    public int getColumnSelected() {
        return columnSelected;
    }
    
    public int getRowTargeted() {
        return rowTargeted;
    }

    public int getColumnTargeted() {
        return columnTargeted;
    }


}