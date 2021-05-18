package Clases;

public class Editorial {
	public String nombre;
	public String pais;  /*Atributos de la EDitorial no hereda de ninguna de las clases anteriores */
	private long codigo;
	
	public Editorial(String nombre,String pais,long codigo) {
		this.nombre = nombre;   /* Metodo constructor de la clase editorial sirve tambien como registro del editorial una vez pasados los parametros indicados */
		this.pais = pais;
		this.codigo = codigo;
	}
	
	public long getCodigo() {
		return this.codigo;  //metodo getter para poder saber el codgio de la clase ya que esta encapsulado
	}
	
	public void modificar_editorial(String nombre,String pais) {
		this.nombre = nombre;  /* Modificar editorial, nada especial, se le pasan los parametros y se modifican de acuerdo a lo que indicado por el usuario */
		this.pais = pais;
	}
}
