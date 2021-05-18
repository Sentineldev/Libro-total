package Clases;


import javax.swing.*;



public class Usuario {
	public String nombre;
	public String apellido;
	private String usuario;
	private String password;
	public long telefono;
	private long cedula;
	
	public Usuario(String nombre,String apellido,String usuario,String password,long telefono,long cedula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario; /* constructor del usuario */
		this.password = password;
		this.telefono = telefono;
		this.cedula = cedula;
	}
	
	public long getCedula() { /* getter para obtenre la cedula del usuario*/
		return this.cedula;
	}
	
	public String getUsuario() { /* getter para obtener el usuario encapsulado del usuario valga la redundancia */
		return this.usuario;
	}
	public String getPassword() { /* getter para obtener la contraseña del usuario */
		return this.password;
	}
	
	public void modificar_usuario(String contrasena) { /*  modificar la contraseña del usuario*/
		this.password = contrasena;
		JOptionPane.showMessageDialog(null, "MOdificacion exitosa");
	}
}
