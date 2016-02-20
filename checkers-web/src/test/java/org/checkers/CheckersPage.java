package org.checkers;

import java.util.List;

import org.checkers.core.PieceColour;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.collect.Lists;

public class CheckersPage {
	
    @FindBy(id = "board")
    WebElement board;

    @FindBy(id = "winner")
    WebElement winner;

    @FindBy(id = "reset")
    WebElement resetButton;

    public CheckersPage(WebDriver driver) {
        driver.get("http://localhost:9090/checkers-web/index.jsp");
    }

    public boolean hasBoard() {
        return board.isDisplayed();
    }
    
    public void play(int i, int j) {
        // Needs to be modified, as we click on a cell, and not only a column
    	// List<WebElement> cols = getColumns();
        // cols.get(i).click();
    	
        String xpath = String
                .format("//div[@class='column'][%d]/div/a", i + 1);
        List<WebElement> cells = Lists.reverse(board.findElements(By
                .xpath(xpath)));
        cells.get(j).click();
    }
    
    private List<WebElement> getColumns() {
        List<WebElement> cols = board.findElements(By
                .xpath("//div[@class='column']"));
        return cols;
    }
    
    public PieceColour getCell(int i, int j) {
        String xpath = String
                .format("//div[@class='column'][%d]/div/a", i + 1);
        List<WebElement> cells = Lists.reverse(board.findElements(By
                .xpath(xpath)));

        WebElement cell = cells.get(j);
        String cssClass = cell.getAttribute("class");    
        return colourFromClass(cssClass);
    }
    
    private PieceColour colourFromClass(String cssClass) {
        if (cssClass.contains("red")) {
            return PieceColour.WHITE;
        } else if (cssClass.contains("black")) {
            return PieceColour.BLACK;
        } else {
            return null;
        }
    }
    
    public Integer getColumnsNumber() {
        return getColumns().size();
    }
    
    public Integer getRowsNumber() {
        String xpath = String.format("//div[@class='column'][%d]/div/a", 1);
        List<WebElement> cells = Lists.reverse(board.findElements(By
                .xpath(xpath)));
        return cells.size();
    }
    
    public void reset() {
        resetButton.click();
    }
    
    public PieceColour getWinner() {
        try {
            return colourFromClass(winner.getAttribute("class"));
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    
}
