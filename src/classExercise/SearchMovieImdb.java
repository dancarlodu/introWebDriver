package classExercise;

import org.openqa.selenium.WebDriver;

public class SearchMovieImdb {
	
	static WebDriver driver;

	public static void main(String[] args) {
		navegarPagina("https://imdb.com");
		verificarPaginaPrincipal();
		ingresarPelicula("it");
		verificarOpciones();
 	    realizarBusqueda();
 	    verificarListaPeliculas("it");
 	    closeBrowser();
	}

	private static void navegarPagina(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void verificarPaginaPrincipal() {
		// TODO Auto-generated method stub
		
	}

	private static void ingresarPelicula(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void verificarOpciones() {
		// TODO Auto-generated method stub
		
	}

	private static void realizarBusqueda() {
		// TODO Auto-generated method stub
		
	}

	private static void verificarListaPeliculas(String string) {
		// TODO Auto-generated method stub
		
	}
	
	private static void closeBrowser() {
		
		System.out.println("El caso fue exitoso");
		driver.close();
		driver.quit();
		
		
	}


}
