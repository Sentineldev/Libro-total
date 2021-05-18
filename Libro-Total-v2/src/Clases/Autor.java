package Clases;


//Heredar de persona!
public class Autor extends Persona{
	public int dia;                     
	public int mes;						/*Atributos de la clase autor que hereda de la clase Persona			*/					    
	public int ano;
	
	public Autor(String nombre,String nombre2,String apellido,String apellido2,String direccion,long telefono,long cedula,int dia,int mes,int ano) {
		super(nombre,nombre2,apellido,apellido2,direccion,telefono,cedula);
		this.dia = dia;
		this.mes = mes;  /* Metodo constructor que inicializa toda los atributos del objeto, dicho constructor funciona como forma de registro del autor en el programa */
		this.ano = ano;
	}
	
	public void modificar_autor(String nombre,String nombre2,String apellido,String apellido2,String direccion,long telefono,
								int dia,int mes,int ano) {
		this.nombre = nombre;
		this.nombre2 = nombre2;                    /* Se modifican todos los atributos del autor si el usuario lo desea, si alguno cambio dentro de la interfaz al ser enviado aca sera modificado */
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dia = dia;
		this.mes= mes;
		this.ano = ano;
		
	}
}
