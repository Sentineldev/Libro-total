package Clases;

public class Persona {
	public String nombre;
	public String nombre2;
	public String apellido;
	public String apellido2;
	public String direccion;
	public long telefono;
	private long cedula;
	
	public Persona(String nombre,String nombre2,String apellido,String apellido2,String direccion,long telefono,long cedula) {
		this.nombre = nombre;
		this.nombre2 = nombre2;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cedula = cedula;
	}
	
	public long getCedula() {
		return this.cedula;
	}
}
/*AUnque bueno, mi codigo no ha sido muy dinamico jaja*/
 /*Cllase utilizada para hereder los atributos a las clases autor y propietarios y evitar copiar los mimos atributos una y otrta vez al crear las clases y hacer el codigo mas dinamico */