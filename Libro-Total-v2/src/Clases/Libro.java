package Clases;

import javax.swing.JOptionPane;

public class Libro {
	final int max_autores = 5;
	public String titulo;
	public String ciudad;
	public String localidad;
	public int dia;
	public int mes;
	public int ano;
	public int ejemplares;
	public int monto;
	private long codigo;
	public Editorial editorial;
	public Autor autores[];
	
	public Libro(String titulo,String ciudad,String localidad,int dia,int mes,int ano,int ejemplares,int monto,long codigo,Editorial editorial) {
		this.titulo = titulo;
		this.ciudad = ciudad;
		this.localidad = localidad;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano; /*metodo constructor uqe sirve para registrar el libro en la empresa */
		this.ejemplares = ejemplares;
		this.monto = monto;
		this.codigo = codigo;
		this.editorial = editorial;
		this.autores = new Autor[max_autores];
	}
	
	public void modificar_libro(String titulo,String ciudad,String localidad,int dia,int mes,int ano,int ejemplares,int monto,long codigo,Editorial editorial) {
		this.titulo = titulo;
		this.ciudad = ciudad;
		this.localidad = localidad;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.ejemplares = ejemplares; /* metodo para modificar que recibe los parametros enviados desde la empresa al metoodo del libro y ser modificados*/
		this.monto = monto;
		this.editorial = editorial;
	}
	
	public int es_vacio_autor() {
		int es_vacio = -1;
		boolean band = false;
		int i=0; /*algoritmo para saber si hay un espacio vacio edentro del arreglo autores del libro */
		while(band == false && i<this.autores.length) {
			if(this.autores[i] == null) {
				es_vacio = i;
				band = true;
			}
			else {
				i++;
			}
		}
		return es_vacio;
	}
	
	public int buscar_autor(long cedula) {
		int encontrado = -1;
		boolean band = false; /* algoritmo de busqueda para saber si existe o no un autor dentro del arreglo de autores libro*/
		int i = 0;
		while(band == false && i<this.autores.length) {
			if(this.autores[i] != null) {
				if(this.autores[i].getCedula() == cedula) {
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
	
	public void anadir_autor(Autor autor) { /* se añade un autor al libro */
		if(es_vacio_autor() != -1) {
			int indice_autor = es_vacio_autor(); /* se verifica que no exista, */
			if(buscar_autor(autor.getCedula()) == -1 ) { /* y se verifica que tenga espacio para almacenarlo ed lo contrario enviara una ventana emergente indicando porque no pudo*/
				this.autores[indice_autor] = autor;
				JOptionPane.showMessageDialog(null, "Anadido con exito!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya se encuentra asignado");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
	}
	public long getCodigo() {
		return this.codigo;
	}
}
