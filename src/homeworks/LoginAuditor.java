package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class LoginAuditor {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		
		for (int i = 0; i < 3 ; i++) {			
		
		
		setUp ("chrome","http://www.auditor.net.co/auditor/");
		
		loginAuditor("hectordc","12aaju","CIUDAD PEREIRA");
		
		validacion();
		
		//salirAuditor();	
		
				
		System.out.println("Caso de prueba exitoso: "+i);
		
		}
		
		closeBrowser();	
	
		
	}	
		private static void salirAuditor() {
		// TODO Auto-generated method stub
			
			// Click en el botón salir
			//Thread.sleep(4000);
			//new WebDriverWait(driver, 10).wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().frame("topFrame");			
			WebElement botonSalir = driver.findElement(By.xpath("//input[@id='pagSuperior:btnSalir2']"));
			botonSalir.click();
			
			
			
			//Alerta de Confirmar salida
			Alert alert = driver.switchTo().alert();
			//String alertaSalir = alert.getText();
			//System.out.println(alertaSalir);
			alert.accept();				
			
			
		
	}
		
		private static void loginAuditor(String usuario, String password, String caf) throws InterruptedException {
		// TODO Auto-generated method stub
			
			
			
			
			// Ingreso del usuario
			WebElement campoUsuario = driver.findElement(By.id("pagLogin:txtUsuario"));
			campoUsuario.clear();
			campoUsuario.sendKeys(usuario);
			
			// Ingreso de la contraseña			
			WebElement campoPassword = driver.findElement(By.id("pagLogin:txtClave"));
			campoPassword.clear();
			campoPassword.sendKeys(password);
			
			
			// Selección del CAF
			driver.findElement(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']")).click();
			WebElement campoCaf = driver.findElement(By.name("pagLogin:txtCafcomboboxField"));
			//Thread.sleep(5000);
			//campoCaf.clear();
			campoCaf.sendKeys(caf);
			driver.findElement(By.cssSelector(".rich-combobox-item-selected")).click();
			//myWaitVar.until(ExpectedConditions.elementToBeSelected(By.cssSelector(".rich-combobox-item-selected"))).click();
			
			
			
			
			//driver.findElement(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']")).click();
			//myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']"))).click();
			//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated (By.id("pagLogin:txtCafcomboboxField"))).sendKeys(caf);
			//myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rich-combobox-item-selected"))).click();
			
		
			
							
			/*
			 * String campoCafValidacion = campoCaf.getAttribute("value");
			 * if(campoCafValidacion.contentEquals(caf)) {
			 * System.out.println("El caf se ingreso correctamente ! " +
			 * campoCafValidacion);
			 * 
			 * WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
			 * myWaitVar.until(ExpectedConditions.elementToBeClickable
			 * (By.id("pagLogin:btnIngresar"))).click();
			 * 
			 * //WebElement botonIngresar =
			 * driver.findElement(By.id("pagLogin:btnIngresar")); //botonIngresar.click();
			 * 
			 * } else{ System.out.println("El caf no se ingreso correctamente" +
			 * campoCafValidacion); }
			 */
			
			
			//driver.findElement(By.id("pagLogin:txtCafcomboboxField")).sendKeys(caf);
			//driver.findElement(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']")).click();
			
			//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rich-combobox-item-selected"))).click();
			//driver.findElement(By.id("pagLogin:txtCafcomboboxField")).click();
			//driver.findElement(By.id("pagLogin:txtCafcomboboxButton")).click();
			//driver.findElement(By.id("pagLogin:txtCafcomboboxField")).clear();
			
			//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("pagLogin:txtCafcomboboxField")));
		
			//driver.findElement(By.cssSelector(".rich-combobox-item-selected")).click();
			
			
			
			
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 15);
			 * 
			 * WebElement listaCaf = (WebElement) wait.until
			 * (ExpectedConditions.numberOfElementsToBeMoreThan(
			 * By.cssSelector("span.rich-combobox-item.rich-combobox-item-selected"), 1));
			 * 
			 * 
			 * 
			 * 
			 * listaCaf.click();
			 */
			 
			//driver.findElement(By.cssSelector("span.rich-combobox-item.rich-combobox-item-selected")).click();
			
			//driver.findElement(By.id("pagLogin:txtCafcomboboxValue")).clear();
			//driver.findElement(By.id("pagLogin:txtCafcomboboxValue")).sendKeys(caf);
			 
			 
			
			//WebElement listaCaf = driver.findElement(By.id("pagLogin:txtCafcomboboxField"));
			//listaCaf.clear();
			//listaCaf.sendKeys(caf);			
			
				//WebDriverWait myWaitVar = new WebDriverWait(driver, 20);
				//myWaitVar.until(ExpectedConditions.elementToBeClickable (By.id("pagLogin:btnIngresar")));
				//WebElement botonIngresar = driver.findElement(By.id("pagLogin:btnIngresar"));
				//Thread.sleep(5000);
				//botonIngresar.click();
				

			//pagLogin:txtCafcomboboxButton
			// pagLogin:txtCafcomboBoxButtonBG
			// pagLogin:txtCafcomboboxValue
		
	}
		private static void validacion() {
		// TODO Auto-generated method stub
		
	}
		private static void setUp (String browser, String url) {
			switch(browser) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", "/usr/jnavarro/test");
				driver = new ChromeDriver();
				break;
			case "firefox":
				
				driver = new FirefoxDriver();
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Ese browser no existe");
				System.exit(-1);
			}
			driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS); 
			driver.get(url);

		}
		
		private static void closeBrowser() {		
			
			driver.close();
			driver.quit();
			
			
		}

	}


