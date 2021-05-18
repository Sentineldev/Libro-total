/*
 * Proyecto Realizado por Jesus Figuera y Luis Marcano
 * 						  29660012        28315753
 * 
 * ESpero el proyecto le compile profesor. A mi me compilo y me funciono perfectamente
 * Cabe destacar que tuve problemas creando el ejecutable .jar, no he logrado hacer que ejecute, siempre que lo genero me da un error
 * pero al ejecutar el programa por el codigo fuente me funciona perfectamente y sin errores.
 * Tengo entendido que no pidio archivo.jar
 * gracias. espero su opinion del proyecto Saludos.
 * 
 * 
 * 
 * 
 * */


package Clases;

/*import Ventanas.Inicio;
import Ventanas.Menu;*/

public class Main {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.eventos_usuario();
		empresa.eventos_propietario();
		empresa.eventos_editorial();
		empresa.eventos_autor();
		empresa.eventos_libro();
		empresa.eventos_libreria();
		empresa.eventos_panel_extra();
		empresa.inicio.setVisible(true);
		empresa.usuarios[0] = new Usuario("Jesus","Figuera","admin","admin",123,123);
	}
}
