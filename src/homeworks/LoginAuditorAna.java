package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAuditorAna {

static WebDriver driver;
static WebDriverWait wait;

public static void main(String[] args) {

abrirPagina("http://www.auditor.net.co/");
//verificarPaginaPrincipal();
ingresarCredenciales("hectordc", "12aaju", "CIUDAD PEREIRA");
verificarOpciones();
// digitarFormula("SALUD TOTAL EPS S S.A (BOGOTA)", "SALUD TOTAL E.P.S.", "EVENTO", "EVENTO");
//verificarListaPeliculas("it");
closeBrowser();
}


private static void abrirPagina(String url) {
driver = new ChromeDriver();
//driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(url);
wait = new WebDriverWait(driver, 30);
}

// private static void verificarPaginaPrincipal() {

// wait.until(ExpectedConditions.elementToBeClickable(By.id("pagLogin:txtUsuario")));
// }

private static void ingresarCredenciales(String user, String pass, String cafs) {

WebElement usuario = driver.findElement(By.id("pagLogin:txtUsuario"));
WebElement password = driver.findElement(By.id("pagLogin:txtClave"));
WebElement caf = driver.findElement(By.id("pagLogin:txtCafcomboboxField"));
WebElement combo = driver.findElement(By.id("pagLogin:txtCaflistParent"));
WebElement botonLogin = driver.findElement(By.id("pagLogin:btnIngresar"));


usuario.sendKeys(user);
password.sendKeys(pass);
caf.sendKeys(cafs);
// combo.click();
// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("pagLogin:txtCaflistParent")));
// WebElement lista = driver.findElement(By.className("rich-combobox-font-inactive rich-combobox-input-inactive"));
// lista.click();
botonLogin.click();

}



private static void verificarOpciones() {


//el elemento de abajo esta en un frame
//primero me voy acambiar al frame
driver.switchTo().frame("topFrame");
wait.until(ExpectedConditions.elementToBeClickable(By.id("btnFormulas"))).click();

//WebElement formulacion = driver.findElement(By.id("btnFormulas"));
//formulacion.click();
//pendientes
// WebElement pendiente = driver.findElement(By.id("btnPendientes"));
// pendiente.click();


}

private static void digitarFormula(String client, String ent, String contract, String subc) {

// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainFrame")));
/* driver.switchTo().frame("mainFrame");
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pagF:detalle:btnNueva\"]")));
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("pagF:cmbClientes")));
WebElement cliente = driver.findElement(By.id("pagF:cmbClientes"));
// WebElement entidad = driver.findElement(By.id("pagF:cmbEntidades"));
// WebElement contrato = driver.findElement(By.id("pagF:cmbTipoContrato"));
// WebElement subcuenta = driver.findElement(By.id("pagF:cmbSubcuentas"));
//
cliente.sendKeys(client);
// entidad.sendKeys(ent);
// contrato.sendKeys(contract);
// subcuenta.sendKeys(subc);
*/
}
private static void closeBrowser() {
// TODO Auto-generated method stub
driver.close();
driver.quit();
}

}
