
/*
 * La mayoria del codigo de las interfaces se repite muchas veces, por lo tanto creo que explicarle solo la primera parte estaria bien! espero entienda como funciona
 * */


package Ventanas;

import java.awt.Color;

import javax.swing.*;

public class Inicio  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panel;
	public JTabbedPane principal;
	public JPanel panel1;
	public JPanel panel2;
	public JButton boton1;
	public JButton boton2;
	public JTextField usuario; /* se crean atributos para la clase inicio que es un frame */
	public JPasswordField password; /* dichos atributos seran utilizados en las demas clases para mostrar los datos y añadir eventos a los botones */
	public JTextField nombre;
	public JTextField apellido;
	public JTextField telefono;
	public JTextField cedula;
	public JTextField usuario2;
	public JPasswordField password2;
	
	
	public Inicio() {
		//Accesorios del menu de inicio
		this.usuario = new JTextField();
		this.password = new JPasswordField();
		this.boton1 = new JButton();
		
		//Accesorios menu de registro de usuario
		this.nombre = new JTextField();
		this.apellido = new JTextField();
		this.telefono = new JTextField();
		this.cedula = new JTextField(); /* se crear un campo de texto*/
		this.usuario2 = new JTextField();
		this.password2 = new JPasswordField();
		this.boton2 = new JButton();
		
		//Ventana y panel principal
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.principal = new JTabbedPane(JTabbedPane.TOP);
		this.panel.setLayout(null);
		this.setSize(500, 300); /* se establece el tamaño de la ventana */
		this.setLocationRelativeTo(null); /*  se establece  la locacion relativa en null para que aparezca en el centro al momento de ejecutarse*/
		this.setTitle("Menu Principal"); /* Titulo principal de la ventana*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); /* se establece la opcion al presionar el boton 'X' para cerrar la pestaña y que el programa finalice */
		this.getContentPane().add(this.panel); /*se le añade al frame principal un panel para colocar accesorios */
		this.principal = new JTabbedPane(); /*Un panel sobre el cual se pueden colocar pestañas */
		this.principal.setBounds(0, 0, 500, 300); /* se establece la posicion dentro del frame principal del panel de pestaña */
		this.panel.add(principal); /*se añade al primer panel creado, el panel de pestañas principal */
		crear_paneles(); /* se crean todos los paneles */
		crear_etiquetas(); /*se crean todas las etiquetas, las que dicen registro, bienvido y esa s cosas */
		campos_texto(); /*se crean los campos de texto donde el usuario coloca sus datos */
		crear_botones(); /* los botoenes que activan las funciones al ser presionados */
		

	}
	
	
	
	private void crear_paneles() { /* se crean los paneles para cada uno, ya sea el inicio del usuario o el registro */
		
		
		this.panel1 = new JPanel();
		this.panel1.setBackground(Color.decode("#263d42")); /* se establece el color de la ventana */
		this.principal.addTab("Inicio", null, this.panel1, null); /* SE establece la pestaña y el nombre de la pestaña*/
		this.panel1.setLayout(null); /*  se deshabiltiada el diseño automatico de la ventana*/
		
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Registrarse", null, this.panel2, null);
		this.panel2.setLayout(null);
		
	
	}
	
	private void crear_etiquetas() {
		//Etiquetas panel 1
		JLabel titulo = new JLabel("Bievenido a Libro Total!",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 500, 20);
		titulo.setForeground(Color.white);
		this.panel1.add(titulo);
		
		JLabel subtitulo = new JLabel("Ingresar",SwingConstants.CENTER);
		subtitulo.setBounds(0,40, 500, 20);
		subtitulo.setForeground(Color.white);
		this.panel1.add(subtitulo);
		
		JLabel titulo_usuario = new JLabel("Usuario",SwingConstants.LEFT);
		titulo_usuario.setBounds(170, 60, 500, 20);
		titulo_usuario.setForeground(Color.white);
		this.panel1.add(titulo_usuario);
		
		JLabel titulo_password = new JLabel("Contrasena");
		titulo_password.setBounds(170, 110, 500, 20);
		titulo_password.setForeground(Color.white);
		this.panel1.add(titulo_password);
		
		//Etiquetas panel 2
		JLabel titulo2 = new JLabel("Registro. Ingrese sus datos",SwingConstants.CENTER);
		titulo2.setBounds(0, 10, 500, 20);
		titulo2.setForeground(Color.white);
		this.panel2.add(titulo2);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(100, 40, 100, 20);
		nombre.setForeground(Color.WHITE);
		this.panel2.add(nombre);
		
		JLabel apellido = new JLabel("Apellido");
		apellido.setBounds(100, 90, 100, 20);
		apellido.setForeground(Color.WHITE);
		this.panel2.add(apellido);
		
		JLabel telefono = new JLabel("Telefono");
		telefono.setBounds(260, 40, 100, 20);
		telefono.setForeground(Color.WHITE);
		this.panel2.add(telefono);
		
		JLabel cedula = new JLabel("Cedula");
		cedula.setBounds(100, 140, 100, 20);
		cedula.setForeground(Color.WHITE);
		this.panel2.add(cedula);
		
		JLabel password = new JLabel("Password");
		password.setBounds(260, 140, 100, 20);
		password.setForeground(Color.WHITE);
		this.panel2.add(password);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(260, 90, 100, 20);
		usuario.setForeground(Color.WHITE);
		this.panel2.add(usuario);
	}
	
	private void campos_texto() {
		//Entradas del primer panel inicio
		this.usuario.setBounds(170,80, 170,20);
		this.panel1.add(this.usuario);
		this.password.setBounds(170, 130, 170, 20);
		this.panel1.add(this.password);
		
		//Entradas del segundo panel. Panel de registro
		this.nombre.setBounds(100, 60, 120, 20);
		this.panel2.add(this.nombre);
		
		this.apellido.setBounds(100, 110, 120, 20);
		this.panel2.add(this.apellido);
		
		this.cedula.setBounds(100, 160, 120, 20);
		this.panel2.add(this.cedula);
		
		this.telefono.setBounds(260, 60, 120, 20);
		this.panel2.add(this.telefono);
		
		this.usuario2.setBounds(260, 110, 120, 20);
		this.panel2.add(this.usuario2);
		
		this.password2.setBounds(260, 160, 120, 20);
		this.panel2.add(this.password2);
	}
	
	private void crear_botones() {
		this.boton1.setBounds(205, 170, 100, 30);
		this.boton1.setText("Ingresar");
		this.panel1.add(this.boton1);
		
		this.boton2.setText("Registrarse");
		this.boton2.setBounds(185, 200, 120, 30);
		this.panel2.add(this.boton2);
		
		
	}
}
