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

public class LoginAuditor {
	
	static WebDriver driver;
	static WebDriverWait myWaitVar;
	

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub	
		
		
			setUp ("firefox","http://www.auditor.net.co/auditor/");
			
			for (int i = 0; i < 5 ; i++) {
		
				loginAuditor("hectordc","12aaju","CIUDAD PEREIRA");
				
				validacion();
				
				salirAuditor();
				
				System.out.println("Caso de prueba exitoso: "+i);			
				
			}
			
			closeBrowser();
			
	
		
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
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		
		
		

	}
		private static void salirAuditor() {
		// TODO Auto-generated method stub
			
			
			
			driver.switchTo().frame(1);
			WebElement validacionIngreso = driver.findElement(By.xpath("//*[contains(text(),'HECTORDC')]"));
			
			if (validacionIngreso.isDisplayed())
				System.out.println("Usuario registrado en Auditor");
			else
				System.exit(-1);			
			
			
			//Click en el botón salir
			//Thread.sleep(15000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame(0); // topFrame
			WebElement botonSalir = driver.findElement(By.xpath("//input[@id='pagSuperior:btnSalir2']"));
			botonSalir.click();
			
			
			
			//Alerta de Confirmar salida
			Alert alert = driver.switchTo().alert();
			//String alertaSalir = alert.getText();
			//System.out.println(alertaSalir);
			alert.accept();
			
			System.out.println("Saliendo del CAF. Vuelva pronto ..."); 
			
			
		
	}
		
		private static void loginAuditor(String usuario, String password, String caf)  {
		// TODO Auto-generated method stub
			
						
			//WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
			
			driver.switchTo().defaultContent();
			
			boolean advertenciaPresente;
			int contadorIntentosIngreso=1;
			
			do {			
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
			
			//WebElement seleccionCaf = driver.findElement(By.cssSelector(".rich-combobox-item-selected"));
			//seleccionCaf.click();
			//myWaitVar.until(ExpectedConditions.elementToBeSelected(By.cssSelector(".rich-combobox-item-selected"))).click();
	
				
			
			//Ingresar del CAF
			WebElement botonIngresar = driver.findElement(By.id("pagLogin:btnIngresar")); 
			botonIngresar.click();
			
			
			
			//Validación de ingreso			
			advertenciaPresente = driver.findElements(By.xpath("//*[contains (@title, 'Advertencia:')]")).size()  > 0;		
			
			
			if (advertenciaPresente) {				
			
				WebElement mensajeAdvertencia = driver.findElement(By.xpath("//*[contains (@title, 'Advertencia:')]"));					
		
					System.out.println(mensajeAdvertencia.getText());
					System.out.println("NO ingreso al CAF !");
					System.exit(-1);
					closeBrowser();
					
				} else {
					System.out.println("Ingresando al CAF ..."); 
					
					}
			
			System.out.println("Intento de ingreso: "+contadorIntentosIngreso);
			contadorIntentosIngreso=contadorIntentosIngreso+1;
			}			
			while (advertenciaPresente==true);
	
	}
		
		private static void validacion() {
		// TODO Auto-generated method stub
			
	
		}
		
		private static void closeBrowser() {		
			
			//driver.close();			
			driver.quit();
			
			
		}

	}


