package org.checkers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.checkers.core.PieceColour.WHITE;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@Test
	public void aPlayerMayMoveAPiece() throws Exception {
		page.play(1, 6, 2, 5);
		assertThat(page.getCell(1, 6)).isNull();
		assertThat(page.getCell(2, 5)).isEqualTo(WHITE);
	}

	@Test
	public void aGameMayBeReset() throws Exception {
		page.play(1, 6, 2, 5);
		assertThat(page.getCell(2,5)).isEqualTo(WHITE);
		assertThat(page.getCell(1,6)).isNull();
		page.reset();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("board")));

		assertThat(page.getCell(1,6)).isEqualTo(WHITE);
	}

	@Test
	public void aPlayerMayWin() throws Exception {
		assertThat(page.getWinner()).isNull();
		page.play(1,6,2,5);
		page.play(0,3,1,4);
		page.play(2,5,0,3);
		page.play(2,3,3,4);
		page.play(5,6,4,5);
		page.play(1,2,2,3);
		page.play(7,6,6,5);
		page.play(2,1,1,2);
		page.play(0,3,2,1);
		page.play(0,1,1,2);
		page.play(3,6,2,5);
		page.play(1,0,0,1);
		page.play(2,1,1,0);
		assertThat(page.getWinner()).isEqualTo(WHITE);
	}
}
