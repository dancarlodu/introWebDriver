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

public class LoginAuditor {
	
	static WebDriver driver;
	static WebDriverWait wait;
	

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		
			
		
			for (int i = 0; i < 3 ; i++) {
			
			setUp ("firefox","http://www.auditor.net.co/auditor/");
		
			loginAuditor("hectordc","12aaju","PEREIRA ESPECIALIZADO MAC");
			
			validacion();
			
			salirAuditor();		
				
			System.out.println("Caso de prueba exitoso: "+i);
			
			closeBrowser();
		
			
		}
			
	
		
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS); 
		driver.get(url);
		
		
		
		

	}
		private static void salirAuditor() {
		// TODO Auto-generated method stub
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			
			//driver.switchTo().frame(0);
			WebElement validacionIngreso = driver.findElement(By.xpath("//*[@id=\"pagSuperior:lblUsuario\"]"));
			validacionIngreso.getText();			
			
			
			if(validacionIngreso.equals("HECTOR DANIEL CARDONA - PEREIRA ESPECIALIZADO MAC (PEREIRA)"))
					 
				System.out.println("Error ingreso ! ");
					
			else 
				System.out.println("Se ingreso correctamente");
			
			// Click en el botón salir
			//Thread.sleep(15000);			
			//driver.switchTo().frame("topFrame");
			//driver.switchTo().frame(0);
			WebElement botonSalir = driver.findElement(By.xpath("//input[@id='pagSuperior:btnSalir2']"));
			botonSalir.click();
			
			
			
			//Alerta de Confirmar salida
			Alert alert = driver.switchTo().alert();
			//String alertaSalir = alert.getText();
			//System.out.println(alertaSalir);
			alert.accept();				
			
			
		
	}
		
		private static void loginAuditor(String usuario, String password, String caf)  {
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
			WebElement botonSeleccionCaf = driver.findElement(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']"));
			botonSeleccionCaf.click();
			WebElement campoCaf = driver.findElement(By.name("pagLogin:txtCafcomboboxField"));
			campoCaf.clear();
			campoCaf.sendKeys(caf);
			
			//Ingresar del CAF
			WebElement botonIngresar = driver.findElement(By.id("pagLogin:btnIngresar")); 
			botonIngresar.click(); 
			
			
			
			
			
			
		
			
			
			
		
			//WebElement seleccionCaf = driver.findElement(By.cssSelector(".rich-combobox-item-selected"));
			//seleccionCaf.click();
			//myWaitVar.until(ExpectedConditions.elementToBeSelected(By.cssSelector(".rich-combobox-item-selected"))).click();
			
			
			
			
			//driver.findElement(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']")).click();
			//myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pagLogin:txtCafcomboboxButton']"))).click();
			//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated (By.id("pagLogin:txtCafcomboboxField"))).sendKeys(caf);
			//myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rich-combobox-item-selected"))).click();
			
		
			
							
		
			
				/*
				 * WebElement advertenciaIngreso =
				 * driver.findElement(By.xpath("//*[@id=\"pagLogin:error\"]"));
				 * if(advertenciaIngreso.
				 * equals("El caf ingresado no está permitido para éste usuario")) {
				 * 
				 * System.out.println("Error selección CAF ! ");
				 * 
				 * 
				 * } else {
				 * 
				 * System.out.println("El caf se ingreso correctamente"); WebElement
				 * botonIngresar = driver.findElement(By.id("pagLogin:btnIngresar"));
				 * botonIngresar.click();
				 * 
				 * }
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
		
		
		private static void closeBrowser() {		
			
			//driver.close();
			driver.quit();
			
			
		}

	}


