package Clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.swing.JOptionPane;


public class Libreria {
	final int max_libros = 1000;
	public String nombre;
	public String direccion;
	public String estado;
	public String localidad;
	public long telefono;
	private long rif;
	public DateFormat f_registro;
	public Propietario propietario;
	public Libro inventario[];
	
	
	public Libreria(String nombre,String direccion,String estado,String localidad,long telefono,long rif) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estado = estado;
		this.localidad = localidad;
		this.telefono = telefono;
		this.rif = rif;
		this.f_registro = new SimpleDateFormat("dd/MM/YYYY"); 
		this.inventario = new Libro[max_libros];
		
	}
	
	public void anadir_propietario(Propietario propietario) {
		this.propietario = propietario; /* recibe como parametro el propietario que sera añadido a la libreria */
	}
	
	public int es_vacio_inventario() {
		int es_vacio = -1; /* se hace uso del algoritmo es vacio para buscar un espacio vacio dentro del inventario de la libreria */
		boolean band = false;
		int i = 0;
		while(band == false && i<this.inventario.length) {
			if(this.inventario[i] == null) {
				es_vacio = i;
				band = true;
			}
			else {
				i++;
			}
		}
		return es_vacio;
	}
	
	public int buscar_libro_inventario(long codigo) { /*se hace uso del algoritmo buscar, para buscar un libro especifico en el inventario */
		int encontrado = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.inventario.length) {
			if(this.inventario[i] != null) {
				if(this.inventario[i].getCodigo() == codigo) {
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
	
	public void anadir_libro(Libro libro,int ejemplares1) { /*Se añade un libro a la libreria */
		String titulo = libro.titulo;
		String ciudad = libro.ciudad;
		String localidad = libro.localidad;
		int dia = libro.dia;  /* se crean variables separadas del dato, para evitar crear una copia exacta del objeto */
		int mes = libro.mes; /* de esta manera al modificar un libro, no se modificaran tambien los que estan en las librerias */
		int ano = libro.ano; /* afectando la modificacion de ejemplares o el conteo. */
		int ejemplares = ejemplares1;
		int monto = libro.monto;
		long codigo = libro.getCodigo();
		Editorial editorial = libro.editorial;
		Autor autores[] = libro.autores;
		
		if(es_vacio_inventario() != -1) {
			int indice_inventario = es_vacio_inventario();
			if(buscar_libro_inventario(codigo) == -1) {
				this.inventario[indice_inventario] = new Libro(titulo,ciudad,localidad,dia,mes,ano,ejemplares,monto,codigo,editorial);
				this.inventario[indice_inventario].autores = autores;
				JOptionPane.showMessageDialog(null, "Ingresado a la libreria con exito");
			}
			else {
				JOptionPane.showMessageDialog(null, "El libro ya se encuentra en la libreria");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
	}
	
	public long getRif() {
		return this.rif; /* getter para mostra el rif encapsulado en la clase lbireria */
	}
}
