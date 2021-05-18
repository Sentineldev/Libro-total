package Clases;


import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.swing.JOptionPane;

public class Propietario extends Persona{
	final int max_librerias = 500;
	public String estado;
	public DateFormat f_registro;
	public Libreria librerias[];
	
	public Propietario(String nombre,String nombre2,String apellido,String apellido2,String direccion,long telefono,long cedula,String estado) {
		super(nombre,nombre2,apellido,apellido2,direccion,telefono,cedula);
		this.estado = estado;
		this.f_registro = new SimpleDateFormat("dd/MM/YYYY");
		this.librerias = new Libreria[max_librerias];
	
	}
	
	public void modificar_propietario(String nombre,String nombre2,String apellido,String apellido2,String direccion,long telefono,String estado) {
		this.nombre = nombre;
		this.nombre2 = nombre2;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
		
	}
	
	public int es_vacio_libreria() {
		int es_vacio = -1;
		boolean band = false; /*algoritmo de busqueda es vacio para saber si hay espacio ono dentro edl arreglo de librerias del propietario */
		int i = 0;
		while(band == false && i<this.librerias.length) {
			if(this.librerias[i] == null) {
				es_vacio = i;
				band = true;
			}
			else {
				i++;
			}
		}
		
		return es_vacio;
	}

	public int buscar_libreria(long rif) { /* algoritmo de busqueda para saber si existe o no uan libreria dentro del arreglo de librerias */
		int encontrado = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.librerias.length) {
			if(this.librerias[i] != null) {
				if(this.librerias[i].getRif() == rif) {
					encontrado = i;
					band = true;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		return encontrado;
	}
	
	public void anadir_libreria(Libreria libreria) {
		if(es_vacio_libreria() != -1) {
			int indice_libreria = es_vacio_libreria(); /* se añade una libreria al propietario, recibe como parametro la libreria que se la va a añadir */
			if(buscar_libreria(libreria.getRif()) == -1) {
				this.librerias[indice_libreria] = libreria;
				JOptionPane.showMessageDialog(null, "Anadido con exito!");
			}
			else {
				JOptionPane.showMessageDialog(null, "La libreria ya posee un propietario");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima");
		}
	}
}
