package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMovieImdb {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

	public static void main(String[] args) {
		navegarPagina("https://imdb.com");
		verificarPaginaPrincipal();
		ingresarPelicula("it");
		verificarOpciones();
 	    realizarBusqueda();
 	    verificarListaPeliculas("it");
 	    closeBrowser();
	}

	private static void navegarPagina(String url) {
		// TODO Auto-generated method stub
		
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		wait = new WebDriverWait(driver, 15);
	
		
	}

	private static void verificarPaginaPrincipal() {
		// TODO Auto-generated method stub
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/registration/signin?ref=nv_generic_lgin']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home_img_holder")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("suggestion-search-button")));
		
		
		
	}

	private static void ingresarPelicula(String nombrePelicula) {
		// TODO Auto-generated method stub
		
		driver.findElement(By.name("q")).sendKeys(nombrePelicula);

	}

	private static void verificarOpciones() {
		// TODO Auto-generated method stub
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'imdb-header__search-menu')]")));
		
	}

	private static void realizarBusqueda() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("suggestion-search-button")).click();
		
		
	}

	private static void verificarListaPeliculas(String nombrePelicula) {
		// TODO Auto-generated method stub
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='findHeader']")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.linkText("It"), 1));
		
		
		
		
		
		
	}
	
	private static void closeBrowser() {
		
		System.out.println("El caso fue exitoso");
		//driver.close();
		driver.quit();
		
		
	}


}
