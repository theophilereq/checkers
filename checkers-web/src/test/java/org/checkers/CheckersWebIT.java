package org.checkers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.checkers.core.PieceColour.BLACK;
import static org.checkers.core.PieceColour.WHITE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckersWebIT {
	
	private WebDriver driver;
	
	private CheckersPage page;
	
    @Before
    public void doBefore() throws Exception {
        driver = new FirefoxDriver();
        // Navigate to the right place
        driver.get("http://localhost:9090/checkers-web/index.jsp");
        page = PageFactory.initElements(driver, CheckersPage.class);
    }

    @After
    public void doAfter() {
        driver.quit();
    }
    
    @Test
    public void itCanBrowseThePage() throws Exception {
        assertThat(page.hasBoard()).isTrue();
        assertThat(page.getColumnsNumber()).isEqualTo(10);
        assertThat(page.getRowsNumber()).isEqualTo(10);
    }
}
