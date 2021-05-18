/*
 * Igualmente que en la clase anterior el codigo es bastante repetitivo, se crean diferentes atributos, pero todos con el mismo fin solo que con posiciones diferente
 * la diferencia es que tuve que crear objeto de boton, y campo de texto diferente, para poder separarlos en los paneles
 * */

package Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Menu extends JFrame { /* dicho menu hereda de la clase JFrame para crear la ventana donde se visualiza todo */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JTabbedPane principal;
	
	//Campos de texto del propietario y accesorios para registrar
	public JTextField nombre_propietario;
	public JTextField nombre2_propietario;
	public JTextField apellido_propietario;
	public JTextField apellido2_propietario;
	public JTextField direccion_propietario;
	public JTextField estado_propietario; /* estos son los campos de texto y el boton para registrar un propietario */
	public JTextField cedula_propietario;
	public JTextField telefono_propietario;
	public JButton registrar_propietario;
	
	//Campos para eliminar un propietario
	public JTextField cedula_eliminar; /* campo de texto y boton para eliminar un propietario */
	public JButton eliminar_propietario;
	
	//Campos para agregar una libreria al propietario
	public JTextField agregar_libreria_cedula; /* campos de texto de rif y cedula, ademas del boton para añadir una libreria al propietario */
	public JTextField agregar_libreria_rif;
	public JButton agregar_libreria;
	
	//Campos para modificar el propietario
	public JTextField nombre1_modificar;
	public JTextField nombre2_modificar;
	public JTextField apellido1_modificar;
	public JTextField apellido2_modificar;
	public JTextField direccion_modificar;
	public JTextField estado_modificar; /* los campos de texto y el boton para modificar el usuario */
	public JTextField cedula_modificar; /* y asi sucesivamente con todos los botones que se pueden apreciar en la interfaz. */
	public JTextField telefono_modificar;
	public JButton buscar_boton_modificar;
	public JButton modificar_propietario;
	
	//Campos de texto y accesorios para el menu de editorial
	public JTextField nombre_editorial;
	public JTextField pais_editorial;
	public JTextField codigo_editorial;
	public JButton registrar_editorial;
	
	//Campos para modificar y buscar editorial
	public JTextField nombre_editorial_modificar;
	public JTextField pais_editorial_modificar;
	public JTextField codigo_editorial_modificar;
	public JButton buscar_editorial;
	public JButton modificar_editorial;
	
	//Campos para el menu de Autor registro
	public JTextField nombre_autor;
	public JTextField nombre2_autor;
	public JTextField apellido_autor;
	public JTextField apellido2_autor;
	public JTextField direccion_autor;
	public JTextField estado_autor;
	public JTextField cedula_autor;
	public JTextField telefono_autor;
	public JTextField dia_autor;
	public JTextField mes_autor;
	public JTextField ano_autor;
	public JButton registrar_autor;
	
	//buscar,mostrar y modificar un autor
	
	public JTextField nombre1_modificar_autor;
	public JTextField nombre2_modificar_autor;
	public JTextField apellido1_modificar_autor;
	public JTextField apellido2_modificar_autor;
	public JTextField direccion_modificar_autor;
	public JTextField dia_autor_modificar;
	public JTextField mes_autor_modificar;
	public JTextField ano_autor_modificar;
	public JTextField cedula_modificar_autor;
	public JTextField telefono_modificar_autor;
	public JButton buscar_boton_modificar_autor;
	public JButton modificar_autor;
	
	//registrar libro
	public JTextField titulo_libro;
	public JTextField ciudad_libro;
	public JTextField localidad_libro;
	public JTextField ejemplares_libro;
	public JTextField monto_libro;
	public JTextField dia_libro;
	public JTextField mes_libro;
	public JTextField ano_libro;
	public JTextField codigo_libro;
	public JTextField codigo_editorial_libro;
	public JButton registrar_libro;
	
	//buscar,mostrar y modificar un libro
	public JTextField titulo_libro_modificar;
	public JTextField ciudad_libro_modificar;
	public JTextField localidad_libro_modificar;
	public JTextField ejemplares_libro_modificar;
	public JTextField monto_libro_modificar;
	public JTextField dia_libro_modificar;
	public JTextField mes_libro_modificar;
	public JTextField ano_libro_modificar;
	public JTextField codigo_libro_editorial_modificar;
	public JTextField codigo_libro_modificar;
	public JButton buscar_libro_modificar;
	public JButton modificar_libro;
	
	//Eliminar libro
	public JTextField eliminar_libro;
	public JButton boton_eliminar_libro;
	
	//Campos para agregar un autor al Libro
	public JTextField agregar_autor_libro_codigo;
	public JTextField agregar_autor_libro_cedula;
	public JButton agregar_autor;
	
	//Campos de texto y accesorios para el registro de la libreria
	public JTextField nombre_libreria;
	public JTextField direccion_libreria;
	public JTextField estado_libreria;
	public JTextField localidad_libreria;
	public JTextField telefono_libreria;
	public JTextField rif_libreria;
	public JButton registrar_libreria;
	
	//Registro libro en libreria
	public JTextField agregar_libro_codigo_libreria;
	public JTextField agregar_libro_rif_libreria;
	public JTextField agregar_libro_libreria_ejemplares;
	public JButton agregar_libro_libreria;
	
	//Panel extra
	public JButton mostrar_editoriales;
	public JButton mostrar_propietarios;
	public JButton mostrar_autores;
	public JButton mostrar_libros;
	public JButton mostrar_librerias;
	//Campos para mostrar la editorial
	public JFrame ventana;
	public DefaultTableModel model_editorial;
	public String[] datos_editorial = new String[3];
	
	//Campos para mostrar los propietarios
	public JFrame ventana_propietarios;
	public DefaultTableModel model_propietarios;
	public String[] datos_propietarios = new String[9];
	
	//Campos para mostrar los autores
	public JFrame ventana_autores;
	public DefaultTableModel model_autores;
	public String[] datos_autores= new String[8];
	
	//Campos para mostrar libros
	public JFrame ventana_libros;
	public DefaultTableModel model_libros;
	public String[] datos_libros= new String[13];
	//Campos para mostrar librerias
	public JFrame ventana_librerias;
	public DefaultTableModel model_librerias;
	public String[] datos_librerias = new String[8];
	
	//Mostrar libros en librerias sin ejemplares
	public JTextField codigo_libro_no_ejemplares;
	public JButton mostrar_librerias_no_ejemplares;
	public JFrame ventana_libreras_libros;
	public DefaultTableModel model_librerias_libro;
	public String[] datos_libro_libreria = new String[3];
	//Mostrar Libros sin asignar a una libreria
	public JButton mostrar_libros_sin_asignar;
	public JFrame ventana_libros_sin_asignar;
	public DefaultTableModel model_libro_sin_asginar;
	public String[] datos_libro_sin_asignar = new String[3];
	//Mostrar un libro y todos sus datos
	public JTextField codigo_libro_mostrar;
	public JButton mostrar_libro;
	public JFrame ventana_mostrar_libro;
	public DefaultTableModel model_mostrar_libro;
	public String[] datos_libreria_mostrar_libro = new String[3];
	public String[] datos_libro = new String[13];
	
	//Mostrar cantidades de libros totalizadas
	public JButton mostrar_cantidad_totalizada;
	public JFrame ventana_mostrar_cantidades;
	public DefaultTableModel model_cantidades_totalizadas;
	public String[] datos_libro_totalizado;
	
	//Mostrar libros por cantidad de ejemplares
	public JTextField cantidad_ejemplares;
	public JButton buscar_libro_ejemplares;
	public JFrame ventana_mostrar_ejemplares;
	public DefaultTableModel model_mostrar_ejemplares;
	
	//modificar usuario cambiar contrasena//menu usuario
	public JTextField nueva_contrasena;
	public JButton cambiar_contrasena;
	public JLabel nombre_usuario;
	public JButton cerrar_sesion;
	
	
	public Menu() {
		panel = new JPanel(); /* El panel que se coloca encima de la ventana para colocar accesorios */
		principal = new JTabbedPane(); /* se coloca la pestaña principal de pestañas en la cual se colocaran las pestañas de los menus */
		this.setSize(800,600); /* se establece el tamaño de la ventana */
		this.setLocationRelativeTo(null); /* la posicion relativa null para que aparezca al centro */
		this.setTitle("Menu Principal"); /* Titulo de la pestaña*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); /* opcion de cierre para que finalice el programa la presionar la 'x'*/
		this.getContentPane().add(panel); /* se le añade a la ventana el panel donde se colocan todos los accesories  */
		this.panel.setLayout(null); /* se layout del panel en nulo para poder modificar la posicion de los botoenes */
		this.panel.add(this.principal); /* añadir el panel de pestañas principal al panel */
		this.principal.setBounds(0, 0, 800,600); /* y se establece el tamaño de dicho panel de pestañas */
		menu_usuario(); /* se crea el menu de usuarios */
		menu_propietario(); /* y el menu de cada uno, que se solicito en el enunciado */
		menu_autor();
		menu_editorial();
		menu_libro();
		menu_libreria();
		mostrar_datos();
		
	}
	
	private void menu_usuario() {
		JPanel panel_usuario = new JPanel(); /* se crea el panel*/
		panel_usuario.setLayout(null); /*  se desactiva el diseño predefinido*/
		panel_usuario.setBackground(Color.decode("#263d42")); /* color de fondo*/
		this.principal.addTab("Usuario", panel_usuario); /*Nombre de la pestaña */
		
		nombre_usuario = new JLabel("Menu de Usuario",SwingConstants.CENTER); /* posicion del texto principal*/
		nombre_usuario.setBounds(0, 10, 800, 20); /*  tamaño y posiciondel texto principal*/
		nombre_usuario.setFont(new Font("arial",Font.BOLD,20)); /*tamaño,tipo de letra y estilo de letra */
		nombre_usuario.setForeground(Color.white); /*color de le latra */
		panel_usuario.add(nombre_usuario); /*  panel al que se debe añadir*/
		//cerrar sesion                                                         /*todo el codigo de la interfaz es muy repetitivo, vera lo mismo de aqui hasta la creacion de las tablas en la linea 1000*/
		this.cerrar_sesion = new JButton("Cerrar sesion"); /*Texto del boton */
		this.cerrar_sesion.setBounds(0, 0, 200, 20); /* posicion del boton */
		panel_usuario.add(this.cerrar_sesion); /*panel al que se añade el boton */
		
		//modificar usuario cambiar contrasena
		JLabel modificar_contrasena = new JLabel("Modificar contrasena",SwingConstants.CENTER);
		modificar_contrasena.setBounds(0, 45, 800, 20);
		modificar_contrasena.setForeground(Color.white);
		modificar_contrasena.setFont(new Font("arial",Font.BOLD,16));
		panel_usuario.add(modificar_contrasena);
		
		JLabel nueva_contrasena = new JLabel("Nueva contrasena");
		nueva_contrasena.setBounds(310, 80, 800, 20);
		nueva_contrasena.setForeground(Color.white);
		panel_usuario.add(nueva_contrasena);
		
		this.nueva_contrasena = new JTextField();
		this.nueva_contrasena.setBounds(310, 100, 165, 20);
		panel_usuario.add(this.nueva_contrasena);
		
		this.cambiar_contrasena = new JButton("Cambiar");
		this.cambiar_contrasena.setBounds(330, 130, 120, 20);
		panel_usuario.add(this.cambiar_contrasena);
	}
	private void menu_propietario() {
		JPanel panel_propietario = new JPanel();
		panel_propietario.setLayout(null);
		panel_propietario.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Propietario", panel_propietario);
		
		
		//etiquetas del menu de propietario
		
		JLabel titulo = new JLabel("Menu de Propietario",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 800, 20);
		titulo.setFont(new Font("arial",Font.BOLD,20));
		titulo.setForeground(Color.white);
		panel_propietario.add(titulo);
		
		JLabel registro = new JLabel("Registrar");
		registro.setBounds(50, 45, 600, 20);
		registro.setFont(new Font("arial",Font.BOLD,18));
		registro.setForeground(Color.white);
		panel_propietario.add(registro);
		
		//campos de texto y leyendas de los campos de texto Registro del propietario
		this.nombre_propietario = new JTextField();
		this.nombre_propietario.setBounds(20, 90, 150, 20);
		panel_propietario.add(this.nombre_propietario);
		
		JLabel nombre_propietario = new JLabel("Primer Nombre");
		nombre_propietario.setBounds(20, 70, 130, 20);
		nombre_propietario.setForeground(Color.white);
		panel_propietario.add(nombre_propietario);
		
		this.nombre2_propietario = new JTextField();
		this.nombre2_propietario.setBounds(20, 140, 150, 20);
		panel_propietario.add(this.nombre2_propietario);
		
		JLabel nombre2_propietario = new JLabel("Segundo Nombre");
		nombre2_propietario.setBounds(20, 120, 130, 20);
		nombre2_propietario.setForeground(Color.white);
		panel_propietario.add(nombre2_propietario);
		
		this.apellido_propietario = new JTextField();
		this.apellido_propietario.setBounds(20, 190, 150, 20);
		panel_propietario.add(this.apellido_propietario);
		
		JLabel apellido_propietario = new JLabel("Apellido");
		apellido_propietario.setBounds(20, 170, 130, 20);
		apellido_propietario.setForeground(Color.white);
		panel_propietario.add(apellido_propietario);
		
		this.apellido2_propietario = new JTextField();
		this.apellido2_propietario.setBounds(20, 240, 150, 20);
		panel_propietario.add(this.apellido2_propietario);
		
		JLabel apellido2_propietario = new JLabel("Segundo Apellido");
		apellido2_propietario.setBounds(20, 220, 130, 20);
		apellido2_propietario.setForeground(Color.white);
		panel_propietario.add(apellido2_propietario);
		
		this.direccion_propietario = new JTextField();
		this.direccion_propietario.setBounds(20, 290, 150, 20);
		panel_propietario.add(this.direccion_propietario);
		
		JLabel direccion_propietario = new JLabel("Direccion");
		direccion_propietario.setBounds(20, 270, 130, 20);
		direccion_propietario.setForeground(Color.white);
		panel_propietario.add(direccion_propietario);
		
		this.estado_propietario = new JTextField();
		this.estado_propietario.setBounds(20, 340, 150, 20);
		panel_propietario.add(this.estado_propietario);
		
		JLabel estado_propietario = new JLabel("Estado");
		estado_propietario.setBounds(20, 320, 130, 20);
		estado_propietario.setForeground(Color.white);
		panel_propietario.add(estado_propietario);
		
		this.telefono_propietario = new JTextField();
		this.telefono_propietario.setBounds(20, 390, 150, 20);
		panel_propietario.add(this.telefono_propietario);
		
		JLabel telefono_propietario = new JLabel("Telefono");
		telefono_propietario.setBounds(20, 370, 130, 20);
		telefono_propietario.setForeground(Color.white);
		panel_propietario.add(telefono_propietario);
		
		this.cedula_propietario = new JTextField();
		this.cedula_propietario.setBounds(20, 440, 150, 20);
		panel_propietario.add(this.cedula_propietario);
		
		JLabel cedula_propietario = new JLabel("Cedula");
		cedula_propietario.setBounds(20, 420, 130, 20);
		cedula_propietario.setForeground(Color.white);
		panel_propietario.add(cedula_propietario);
		
		this.registrar_propietario = new JButton("Registrar");
		this.registrar_propietario.setBounds(40, 490, 100, 20);
		panel_propietario.add(registrar_propietario);
		
		//Campos y leyendas eliminar propietario o agregar una libreria
		
		JLabel eliminar_propietario = new JLabel("Eliminar propietario",SwingConstants.CENTER);
		eliminar_propietario.setBounds(0, 45, 800, 20);
		eliminar_propietario.setForeground(Color.white);
		eliminar_propietario.setFont(new Font("arial",Font.BOLD,16));
		panel_propietario.add(eliminar_propietario);
		
		JLabel cedula_eliminar = new JLabel("Cedula");
		cedula_eliminar.setBounds(300, 70, 800, 20);
		cedula_eliminar.setForeground(Color.white);
		panel_propietario.add(cedula_eliminar);
		
		this.cedula_eliminar = new JTextField();
		this.cedula_eliminar.setBounds(300, 90, 165, 20);
		panel_propietario.add(this.cedula_eliminar);
		
		this.eliminar_propietario = new JButton("Eliminar");
		this.eliminar_propietario.setBounds(320, 120, 120, 20);
		panel_propietario.add(this.eliminar_propietario);
		
		//Agregar una libreria al propietario
		
		JLabel agregar_libreria = new JLabel("Anadir Libreria",SwingConstants.CENTER);
		agregar_libreria.setBounds(0, 170, 750, 20);
		agregar_libreria.setForeground(Color.white);
		agregar_libreria.setFont(new Font("arial",Font.BOLD,16));
		panel_propietario.add(agregar_libreria);
		
		this.agregar_libreria_cedula = new JTextField();
		this.agregar_libreria_cedula.setBounds(300, 220, 165, 20);
		panel_propietario.add(this.agregar_libreria_cedula);
		
		JLabel etiqueta_agregar = new JLabel("Cedula",SwingConstants.LEFT);
		etiqueta_agregar.setBounds(300, 200, 790, 20);
		etiqueta_agregar.setForeground(Color.white);
		panel_propietario.add(etiqueta_agregar);
		
		this.agregar_libreria_rif = new JTextField();
		this.agregar_libreria_rif.setBounds(300, 270, 165, 20);
		panel_propietario.add(this.agregar_libreria_rif);
		
		JLabel etiqueta_agregar2 = new JLabel("Rif");
		etiqueta_agregar2.setBounds(300, 250, 790, 20);
		etiqueta_agregar2.setForeground(Color.white);
		panel_propietario.add(etiqueta_agregar2);
		
		this.agregar_libreria = new JButton("Anadir");
		this.agregar_libreria.setBounds(320, 320, 120, 20);
		panel_propietario.add(this.agregar_libreria);
		
		//Modificar un propietario
		
		JLabel modificar_propietario = new JLabel("Modificar",SwingConstants.RIGHT);
		modificar_propietario.setBounds(0, 45, 700, 20);
		modificar_propietario.setForeground(Color.white);
		modificar_propietario.setFont(new Font("arial",Font.BOLD,16));
		panel_propietario.add(modificar_propietario);
		
		JLabel etiqueta_nombre1 = new JLabel("Nombre");
		
		etiqueta_nombre1.setBounds(550, 70, 800, 20);
		etiqueta_nombre1.setForeground(Color.white);
		etiqueta_nombre1.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_nombre1);
		
		this.nombre1_modificar = new JTextField();
		this.nombre1_modificar.setBounds(550, 90, 100, 20);
		this.nombre1_modificar.disable();
		panel_propietario.add(this.nombre1_modificar);
		
		JLabel etiqueta_nombre2 = new JLabel("Segundo nombre");
		
		etiqueta_nombre2.setBounds(680, 70, 800, 20);
		etiqueta_nombre2.setForeground(Color.white);
		etiqueta_nombre2.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_nombre2);
		
		this.nombre2_modificar = new JTextField();
		this.nombre2_modificar.setBounds(680, 90, 100, 20);
		this.nombre2_modificar.disable();
		panel_propietario.add(this.nombre2_modificar);
		
		JLabel etiqueta_apellido1 = new JLabel("Apellido");
		
		etiqueta_apellido1.setBounds(550, 110, 800, 20);
		etiqueta_apellido1.setForeground(Color.white);
		etiqueta_apellido1.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_apellido1);
		
		this.apellido1_modificar = new JTextField();
		this.apellido1_modificar.setBounds(550, 130, 100, 20);
		this.apellido1_modificar.disable();
		panel_propietario.add(this.apellido1_modificar);
		
		JLabel etiqueta_apellido2 = new JLabel("Segundo Apellido");
		
		etiqueta_apellido2.setBounds(680, 110, 800, 20);
		etiqueta_apellido2.setForeground(Color.white);
		etiqueta_apellido2.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_apellido2);
		
		this.apellido2_modificar = new JTextField();
		this.apellido2_modificar.setBounds(680, 130, 100, 20);
		this.apellido2_modificar.disable();
		panel_propietario.add(this.apellido2_modificar);
		
		
		JLabel etiqueta_telefono = new JLabel("Telefono");
		
		etiqueta_telefono.setBounds(550, 150, 800, 20);
		etiqueta_telefono.setForeground(Color.white);
		etiqueta_telefono.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_telefono);
		
		this.telefono_modificar = new JTextField();
		this.telefono_modificar.setBounds(550, 170, 100, 20);
		this.telefono_modificar.disable();
		panel_propietario.add(this.telefono_modificar);
		
		
		JLabel etiqueta_estado = new JLabel("Estado");
		
		etiqueta_estado.setBounds(680, 150, 800, 20);
		etiqueta_estado.setForeground(Color.white);
		etiqueta_estado.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_estado);
		
		this.estado_modificar = new JTextField();
		this.estado_modificar.setBounds(680, 170,100, 20);
		this.estado_modificar.disable();
		panel_propietario.add(this.estado_modificar);
		
		
		JLabel etiqueta_direccion = new JLabel("Direccion");
		etiqueta_direccion.setBounds(550, 190, 680, 20);
		etiqueta_direccion.setForeground(Color.white);
		etiqueta_direccion.setFont(new Font("arial",1,10));
		panel_propietario.add(etiqueta_direccion);
		
		this.direccion_modificar = new JTextField();
		this.direccion_modificar.setBounds(550, 210, 230, 20);
		this.direccion_modificar.disable();
		panel_propietario.add(this.direccion_modificar);
		
		JLabel etiqueta_cedula = new JLabel("Cedula");
		etiqueta_cedula.setBounds(642, 260, 680, 20);
		etiqueta_cedula.setForeground(Color.white);
		panel_propietario.add(etiqueta_cedula);
		
		this.cedula_modificar = new JTextField();
		this.cedula_modificar.setBounds(605, 280, 125, 20);
		panel_propietario.add(this.cedula_modificar);
		
		this.buscar_boton_modificar = new JButton("Buscar");
		this.buscar_boton_modificar.setBounds(620, 310, 95, 20);
		panel_propietario.add(this.buscar_boton_modificar);
		
		this.modificar_propietario = new JButton("Modificar");
		this.modificar_propietario.setBounds(590, 340, 160, 20);
		this.modificar_propietario.enable(false);
		panel_propietario.add(this.modificar_propietario);
		
		
	}
	
	private void menu_autor() {
		JPanel panel_autor = new JPanel();
		panel_autor.setLayout(null);
		panel_autor.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Autor", panel_autor);
		
		JLabel registro = new JLabel("Registrar");
		registro.setBounds(50, 45, 600, 20);
		registro.setFont(new Font("arial",Font.BOLD,18));
		registro.setForeground(Color.white);
		panel_autor.add(registro);
		
		//etiquetas del menu de autor
		
		JLabel titulo = new JLabel("Menu de Autor",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 800, 20);
		titulo.setFont(new Font("arial",Font.BOLD,20));
		titulo.setForeground(Color.white);
		panel_autor.add(titulo);
		
		//Registro del autor
		
		this.nombre_autor = new JTextField();
		this.nombre_autor.setBounds(20, 90, 150, 20);
		panel_autor.add(this.nombre_autor);
		
		JLabel nombre_autor = new JLabel("Primer Nombre");
		nombre_autor.setBounds(20, 70, 130, 20);
		nombre_autor.setForeground(Color.white);
		panel_autor.add(nombre_autor);
		
		this.nombre2_autor = new JTextField();
		this.nombre2_autor.setBounds(20, 140, 150, 20);
		panel_autor.add(this.nombre2_autor);
		
		JLabel nombre2_autor = new JLabel("Segundo Nombre");
		nombre2_autor.setBounds(20, 120, 130, 20);
		nombre2_autor.setForeground(Color.white);
		panel_autor.add(nombre2_autor);
		
		this.apellido_autor = new JTextField();
		this.apellido_autor.setBounds(20, 190, 150, 20);
		panel_autor.add(this.apellido_autor);
		
		JLabel apellido_autor = new JLabel("Apellido");
		apellido_autor.setBounds(20, 170, 130, 20);
		apellido_autor.setForeground(Color.white);
		panel_autor.add(apellido_autor);
		
		this.apellido2_autor = new JTextField();
		this.apellido2_autor.setBounds(20, 240, 150, 20);
		panel_autor.add(this.apellido2_autor);
		
		JLabel apellido2_autor = new JLabel("Segundo Apellido");
		apellido2_autor.setBounds(20, 220, 130, 20);
		apellido2_autor.setForeground(Color.white);
		panel_autor.add(apellido2_autor);
		
		this.direccion_autor = new JTextField();
		this.direccion_autor.setBounds(20, 290, 150, 20);
		panel_autor.add(this.direccion_autor);
		
		JLabel direccion_autor = new JLabel("Direccion");
		direccion_autor.setBounds(20, 270, 130, 20);
		direccion_autor.setForeground(Color.white);
		panel_autor.add(direccion_autor);
		
		JLabel dia_autor = new JLabel("Dia");
		dia_autor.setBounds(20, 320, 40, 20);
		dia_autor.setForeground(Color.white);
		panel_autor.add(dia_autor);
		
		this.dia_autor = new JTextField();
		this.dia_autor.setBounds(20, 340, 40, 20);
		panel_autor.add(this.dia_autor);
		
		JLabel mes_autor = new JLabel("Mes");
		mes_autor.setBounds(70, 320, 40, 20);
		mes_autor.setForeground(Color.white);
		panel_autor.add(mes_autor);
		
		this.mes_autor = new JTextField();
		this.mes_autor.setBounds(70, 340, 40, 20);
		panel_autor.add(this.mes_autor);
		
		JLabel ano_autor = new JLabel("Ano");
		ano_autor.setBounds(120, 320, 40, 20);
		ano_autor.setForeground(Color.white);
		panel_autor.add(ano_autor);
		
		this.ano_autor = new JTextField();
		this.ano_autor.setBounds(120, 340, 40, 20);
		panel_autor.add(this.ano_autor);
		
		
		this.telefono_autor = new JTextField();
		this.telefono_autor.setBounds(20, 390, 150, 20);
		panel_autor.add(this.telefono_autor);
		
		JLabel telefono_autor = new JLabel("Telefono");
		telefono_autor.setBounds(20, 370, 130, 20);
		telefono_autor.setForeground(Color.white);
		panel_autor.add(telefono_autor);
		
		this.cedula_autor = new JTextField();
		this.cedula_autor.setBounds(20, 440, 150, 20);
		panel_autor.add(this.cedula_autor);
		
		JLabel cedula_autor= new JLabel("Cedula");
		cedula_autor.setBounds(20, 420, 130, 20);
		cedula_autor.setForeground(Color.white);
		panel_autor.add(cedula_autor);
		
		this.registrar_autor = new JButton("Registrar");
		this.registrar_autor.setBounds(40, 490, 100, 20);
		panel_autor.add(registrar_autor);
		
		//Mostrar y modificar autor
		
		JLabel modificar_autor = new JLabel("Modificar",SwingConstants.RIGHT);
		modificar_autor.setBounds(0, 45, 700, 20);
		modificar_autor.setForeground(Color.white);
		modificar_autor.setFont(new Font("arial",Font.BOLD,16));
		panel_autor.add(modificar_autor);
		
		JLabel etiqueta_nombre1 = new JLabel("Nombre");
		
		etiqueta_nombre1.setBounds(550, 70, 800, 20);
		etiqueta_nombre1.setForeground(Color.white);
		etiqueta_nombre1.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_nombre1);
		
		this.nombre1_modificar_autor = new JTextField();
		this.nombre1_modificar_autor .setBounds(550, 90, 100, 20);
		this.nombre1_modificar_autor .disable();
		panel_autor.add(this.nombre1_modificar_autor);
		
		JLabel etiqueta_nombre2 = new JLabel("Segundo nombre");
		
		etiqueta_nombre2.setBounds(680, 70, 800, 20);
		etiqueta_nombre2.setForeground(Color.white);
		etiqueta_nombre2.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_nombre2);
		
		this.nombre2_modificar_autor = new JTextField();
		this.nombre2_modificar_autor.setBounds(680, 90, 100, 20);
		this.nombre2_modificar_autor.disable();
		panel_autor.add(this.nombre2_modificar_autor );
		
		JLabel etiqueta_apellido1 = new JLabel("Apellido");
		
		etiqueta_apellido1.setBounds(550, 110, 800, 20);
		etiqueta_apellido1.setForeground(Color.white);
		etiqueta_apellido1.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_apellido1);
		
		this.apellido1_modificar_autor = new JTextField();
		this.apellido1_modificar_autor.setBounds(550, 130, 100, 20);
		this.apellido1_modificar_autor.disable();
		panel_autor.add(this.apellido1_modificar_autor);
		
		JLabel etiqueta_apellido2 = new JLabel("Segundo Apellido");
		
		etiqueta_apellido2.setBounds(680, 110, 800, 20);
		etiqueta_apellido2.setForeground(Color.white);
		etiqueta_apellido2.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_apellido2);
		
		this.apellido2_modificar_autor = new JTextField();
		this.apellido2_modificar_autor.setBounds(680, 130, 100, 20);
		this.apellido2_modificar_autor.disable();
		panel_autor.add(this.apellido2_modificar_autor);
		
		
		JLabel etiqueta_telefono = new JLabel("Telefono");
		
		etiqueta_telefono.setBounds(550, 150, 800, 20);
		etiqueta_telefono.setForeground(Color.white);
		etiqueta_telefono.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_telefono);
		
		this.telefono_modificar_autor = new JTextField();
		this.telefono_modificar_autor.setBounds(550, 170, 100, 20);
		this.telefono_modificar_autor.disable();
		panel_autor.add(this.telefono_modificar_autor);
		
		JLabel dia_autor_modificar = new JLabel("Dia");
		dia_autor_modificar.setBounds(680, 150, 40, 20);
		dia_autor_modificar.setForeground(Color.white);
		dia_autor_modificar.setFont(new Font("arial",1,10));
		panel_autor.add(dia_autor_modificar);
		
		this.dia_autor_modificar = new JTextField();
		this.dia_autor_modificar.setBounds(680, 170, 25, 20);
		this.dia_autor_modificar.disable();
		panel_autor.add(this.dia_autor_modificar);
		
		JLabel mes_autor_modificar = new JLabel("Mes");
		mes_autor_modificar.setBounds(710, 150, 40, 20);
		mes_autor_modificar.setForeground(Color.white);
		mes_autor_modificar.setFont(new Font("arial",1,10));
		panel_autor.add(mes_autor_modificar);
		
		this.mes_autor_modificar = new JTextField();
		this.mes_autor_modificar.setBounds(710, 170, 25, 20);
		this.mes_autor_modificar.disable();
		panel_autor.add(this.mes_autor_modificar);
		
		JLabel ano_autor_modificar = new JLabel("Ano");
		ano_autor_modificar.setBounds(740, 150, 40, 20);
		ano_autor_modificar.setForeground(Color.white);
		ano_autor_modificar.setFont(new Font("arial",1,10));
		panel_autor.add(ano_autor_modificar);
		
		this.ano_autor_modificar= new JTextField();
		this.ano_autor_modificar.setBounds(740, 170, 40, 20);
		this.ano_autor_modificar.disable();
		panel_autor.add(this.ano_autor_modificar);
		
		
		
		JLabel etiqueta_direccion = new JLabel("Direccion");
		etiqueta_direccion.setBounds(550, 190, 680, 20);
		etiqueta_direccion.setForeground(Color.white);
		etiqueta_direccion.setFont(new Font("arial",1,10));
		panel_autor.add(etiqueta_direccion);
		
		this.direccion_modificar_autor = new JTextField();
		this.direccion_modificar_autor.setBounds(550, 210, 230, 20);
		this.direccion_modificar_autor.disable();
		panel_autor.add(this.direccion_modificar_autor);
		
		JLabel etiqueta_cedula = new JLabel("Cedula");
		etiqueta_cedula.setBounds(642, 260, 680, 20);
		etiqueta_cedula.setForeground(Color.white);
		panel_autor.add(etiqueta_cedula);
		
		this.cedula_modificar_autor = new JTextField();
		this.cedula_modificar_autor.setBounds(605, 280, 125, 20);
		panel_autor.add(this.cedula_modificar_autor);
		
		this.buscar_boton_modificar_autor = new JButton("Buscar");
		this.buscar_boton_modificar_autor.setBounds(620, 310, 95, 20);
		panel_autor.add(this.buscar_boton_modificar_autor);
		
		this.modificar_autor = new JButton("Modificar");
		this.modificar_autor .setBounds(590, 340, 160, 20);
		this.modificar_autor .enable(false);
		panel_autor.add(this.modificar_autor );
		
		
	}
	
	private void menu_editorial() {
		JPanel panel_editorial = new JPanel();
		panel_editorial.setLayout(null);
		panel_editorial.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Editorial", panel_editorial);
		//Etiquetas del menu de editorial
		JLabel titulo = new JLabel("Menu Editorial",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 800, 20);
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("arial",Font.BOLD,20));
		panel_editorial.add(titulo);
		
		//Etiquetas y campos del registro de editorial
		JLabel registro_editorial = new JLabel("Registrar");
		registro_editorial.setOpaque(false);
		registro_editorial.setBounds(100, 50, 580, 22);
		registro_editorial.setFont(new Font("arial",Font.BOLD,18));
		registro_editorial.setForeground(Color.white);
		panel_editorial.add(registro_editorial);
		
		JLabel nombre_editorial = new JLabel("Nombre");
		nombre_editorial.setBounds(80, 80, 130, 20);
		nombre_editorial.setForeground(Color.white);
		panel_editorial.add(nombre_editorial);
		
		this.nombre_editorial = new JTextField();
		this.nombre_editorial.setBounds(80, 100, 130, 20);
		panel_editorial.add(this.nombre_editorial);
		
		JLabel pais_editorial = new JLabel("Pais");
		pais_editorial.setBounds(80, 130, 130, 20);
		pais_editorial.setForeground(Color.white);
		panel_editorial.add(pais_editorial);
		
		this.pais_editorial = new JTextField();
		this.pais_editorial.setBounds(80, 150, 130, 20);
		panel_editorial.add(this.pais_editorial);
		
		JLabel codigo_editorial = new JLabel("Codigo");
		codigo_editorial.setBounds(80, 180, 130, 20);
		codigo_editorial.setForeground(Color.white);
		panel_editorial.add(codigo_editorial);
		
		this.codigo_editorial = new JTextField();
		this.codigo_editorial.setBounds(80, 200, 130, 20);
		panel_editorial.add(this.codigo_editorial);
		
		this.registrar_editorial = new JButton("Registrar");
		this.registrar_editorial.setBounds(95, 230, 100, 20);
		panel_editorial.add(this.registrar_editorial);
		
		//Etiquetas y campos para modificar la editorial
		JLabel modificar_editorial = new JLabel("Modificar",SwingConstants.CENTER);
		modificar_editorial.setBounds(100 ,50, 580, 20);
		modificar_editorial.setFont(new Font("arial",Font.BOLD,18));
		modificar_editorial.setForeground(Color.white);
		panel_editorial.add(modificar_editorial);
		
		JLabel modificar_nombre_editorial = new JLabel("Nombre");
		modificar_nombre_editorial.setBounds(340, 80, 130, 20);
		modificar_nombre_editorial.setForeground(Color.white);
		panel_editorial.add(modificar_nombre_editorial);
		
		this.nombre_editorial_modificar = new JTextField();
		this.nombre_editorial_modificar.setBounds(340, 100, 130, 20);
		this.nombre_editorial_modificar.disable();
		panel_editorial.add(this.nombre_editorial_modificar);
		
		JLabel modificar_pais_editorial = new JLabel("Pais");
		modificar_pais_editorial.setBounds(340, 120, 130, 20);
		modificar_pais_editorial.setForeground(Color.white);
		panel_editorial.add(modificar_pais_editorial);
		
		this.pais_editorial_modificar = new JTextField();
		this.pais_editorial_modificar.setBounds(340, 140, 130, 20);
		this.pais_editorial_modificar.disable();
		panel_editorial.add(this.pais_editorial_modificar);
		
		JLabel modificar_codigo_editorial = new JLabel("Codigo");
		modificar_codigo_editorial.setBounds(330, 170, 130, 20);
		modificar_codigo_editorial.setForeground(Color.white);
		panel_editorial.add(modificar_codigo_editorial);
		
		this.codigo_editorial_modificar = new JTextField();
		this.codigo_editorial_modificar.setBounds(330, 190, 150, 20); 
		panel_editorial.add(this.codigo_editorial_modificar);
		
		this.buscar_editorial = new JButton("Buscar");
		this.buscar_editorial.setBounds(360, 220, 90, 20);
		panel_editorial.add(this.buscar_editorial);
		
		this.modificar_editorial = new JButton("Modificar");
		this.modificar_editorial.setBounds(330, 250, 150, 20);
		panel_editorial.add(this.modificar_editorial);
	}

	private void menu_libro() {
		JPanel panel_libro = new JPanel();
		panel_libro.setLayout(null);
		panel_libro.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Libro", panel_libro);
		
		
		//etiquetas del menu de libro registro
		
		JLabel titulo = new JLabel("Menu de Libro",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 800, 20);
		titulo.setFont(new Font("arial",Font.BOLD,20));
		titulo.setForeground(Color.white);
		panel_libro.add(titulo);
		
		JLabel registro = new JLabel("Registrar");
		registro.setBounds(50, 45, 600, 20);
		registro.setFont(new Font("arial",Font.BOLD,18));
		registro.setForeground(Color.white);
		panel_libro.add(registro);
		
		this.titulo_libro = new JTextField();
		this.titulo_libro.setBounds(20, 90, 150, 20);
		panel_libro.add(this.titulo_libro);
		
		JLabel titulo_libro = new JLabel("Titulo");
		titulo_libro.setBounds(20, 70, 130, 20);
		titulo_libro.setForeground(Color.white);
		panel_libro.add(titulo_libro);
		
		this.ciudad_libro = new JTextField();
		this.ciudad_libro.setBounds(20, 140, 150, 20);
		panel_libro.add(this.ciudad_libro);
		
		JLabel ciudad_libro = new JLabel("Ciudad");
		ciudad_libro.setBounds(20, 120, 130, 20);
		ciudad_libro.setForeground(Color.white);
		panel_libro.add(ciudad_libro);
		
		this.localidad_libro= new JTextField();
		this.localidad_libro.setBounds(20, 190, 150, 20);
		panel_libro.add(this.localidad_libro);
		
		JLabel localidad_libro = new JLabel("Localidad");
		localidad_libro.setBounds(20, 170, 130, 20);
		localidad_libro.setForeground(Color.white);
		panel_libro.add(localidad_libro);
		
		this.ejemplares_libro = new JTextField();
		this.ejemplares_libro.setBounds(20, 240, 150, 20);
		panel_libro.add(this.ejemplares_libro);
		
		JLabel ejemplares_libro = new JLabel("Ejemplares");
		ejemplares_libro.setBounds(20, 220, 130, 20);
		ejemplares_libro.setForeground(Color.white);
		panel_libro.add(ejemplares_libro);
		
		this.monto_libro = new JTextField();
		this.monto_libro.setBounds(20, 290, 150, 20);
		panel_libro.add(this.monto_libro);
		
		JLabel monto_libro = new JLabel("Monto en BsS");
		monto_libro.setBounds(20, 270, 130, 20);
		monto_libro.setForeground(Color.white);
		panel_libro.add(monto_libro);
		
		JLabel dia_libro = new JLabel("Dia");
		dia_libro.setBounds(20, 320, 40, 20);
		dia_libro.setForeground(Color.white);
		panel_libro.add(dia_libro);
		
		this.dia_libro = new JTextField();
		this.dia_libro.setBounds(20, 340, 40, 20);
		panel_libro.add(this.dia_libro);
		
		JLabel mes_libro = new JLabel("Mes");
		mes_libro.setBounds(70, 320, 40, 20);
		mes_libro.setForeground(Color.white);
		panel_libro.add(mes_libro);
		
		this.mes_libro = new JTextField();
		this.mes_libro.setBounds(70, 340, 40, 20);
		panel_libro.add(this.mes_libro);
		
		JLabel ano_libro = new JLabel("Ano");
		ano_libro.setBounds(120, 320, 40, 20);
		ano_libro.setForeground(Color.white);
		panel_libro.add(ano_libro);
		
		this.ano_libro = new JTextField();
		this.ano_libro.setBounds(120, 340, 40, 20);
		panel_libro.add(this.ano_libro);
		
		
		this.codigo_libro = new JTextField();
		this.codigo_libro.setBounds(20, 390, 150, 20);
		panel_libro.add(this.codigo_libro);
		
		JLabel codigo_libro = new JLabel("Codigo Libro");
		codigo_libro.setBounds(20, 370, 130, 20);
		codigo_libro.setForeground(Color.white);
		panel_libro.add(codigo_libro);
		
		this.codigo_editorial_libro = new JTextField();
		this.codigo_editorial_libro.setBounds(20, 440, 150, 20);
		panel_libro.add(this.codigo_editorial_libro);
		
		JLabel codigo_editorial_libro= new JLabel("Codigo Editorial");
		codigo_editorial_libro.setBounds(20, 420, 130, 20);
		codigo_editorial_libro.setForeground(Color.white);
		panel_libro.add(codigo_editorial_libro);
		
		this.registrar_libro = new JButton("Registrar");
		this.registrar_libro.setBounds(40, 490, 100, 20);
		panel_libro.add(this.registrar_libro);
		
		//Modificar Libro y mostrar
		
		JLabel modificar_autor = new JLabel("Modificar",SwingConstants.RIGHT);
		modificar_autor.setBounds(0, 45, 700, 20);
		modificar_autor.setForeground(Color.white);
		modificar_autor.setFont(new Font("arial",Font.BOLD,16));
		panel_libro.add(modificar_autor);
		
		JLabel etiqueta_nombre1 = new JLabel("Titulo");
		
		etiqueta_nombre1.setBounds(550, 70, 800, 20);
		etiqueta_nombre1.setForeground(Color.white);
		etiqueta_nombre1.setFont(new Font("arial",1,10));
		panel_libro.add(etiqueta_nombre1);
		
		this.titulo_libro_modificar = new JTextField();
		this.titulo_libro_modificar.setBounds(550, 90, 100, 20);
		this.titulo_libro_modificar.disable();
		panel_libro.add(this.titulo_libro_modificar);
		
		JLabel etiqueta_nombre2 = new JLabel("Ciudad");
		
		etiqueta_nombre2.setBounds(680, 70, 800, 20);
		etiqueta_nombre2.setForeground(Color.white);
		etiqueta_nombre2.setFont(new Font("arial",1,10));
		panel_libro.add(etiqueta_nombre2);
		
		this.ciudad_libro_modificar = new JTextField();
		this.ciudad_libro_modificar.setBounds(680, 90, 100, 20);
		this.ciudad_libro_modificar.disable();
		panel_libro.add(this.ciudad_libro_modificar);
		
		JLabel etiqueta_apellido1 = new JLabel("Localidad");
		
		etiqueta_apellido1.setBounds(550, 110, 800, 20);
		etiqueta_apellido1.setForeground(Color.white);
		etiqueta_apellido1.setFont(new Font("arial",1,10));
		panel_libro.add(etiqueta_apellido1);
		
		this.localidad_libro_modificar = new JTextField();
		this.localidad_libro_modificar.setBounds(550, 130, 100, 20);
		this.localidad_libro_modificar.disable();
		panel_libro.add(this.localidad_libro_modificar);
		
		JLabel etiqueta_apellido2 = new JLabel("Ejemplares");
		
		etiqueta_apellido2.setBounds(680, 110, 800, 20);
		etiqueta_apellido2.setForeground(Color.white);
		etiqueta_apellido2.setFont(new Font("arial",1,10));
		panel_libro.add(etiqueta_apellido2);
		
		this.ejemplares_libro_modificar = new JTextField();
		this.ejemplares_libro_modificar.setBounds(680, 130, 100, 20);
		this.ejemplares_libro_modificar.disable();
		panel_libro.add(this.ejemplares_libro_modificar);
		
		
		JLabel etiqueta_telefono = new JLabel("Monto");
		
		etiqueta_telefono.setBounds(550, 150, 800, 20);
		etiqueta_telefono.setForeground(Color.white);
		etiqueta_telefono.setFont(new Font("arial",1,10));
		panel_libro.add(etiqueta_telefono);
		
		this.monto_libro_modificar = new JTextField();
		this.monto_libro_modificar.setBounds(550, 170, 100, 20);
		this.monto_libro_modificar.disable();
		panel_libro.add(this.monto_libro_modificar);
		
		JLabel dia_libro_modificar = new JLabel("Dia");
		dia_libro_modificar.setBounds(680, 150, 40, 20);
		dia_libro_modificar.setForeground(Color.white);
		dia_libro_modificar.setFont(new Font("arial",1,10));
		panel_libro.add(dia_libro_modificar);
		
		this.dia_libro_modificar = new JTextField();
		this.dia_libro_modificar.setBounds(680, 170, 25, 20);
		this.dia_libro_modificar.disable();
		panel_libro.add(this.dia_libro_modificar);
		
		JLabel mes_libro_modificar = new JLabel("Mes");
		mes_libro_modificar.setBounds(710, 150, 40, 20);
		mes_libro_modificar.setForeground(Color.white);
		mes_libro_modificar.setFont(new Font("arial",1,10));
		panel_libro.add(mes_libro_modificar);
		
		this.mes_libro_modificar = new JTextField();
		this.mes_libro_modificar.setBounds(710, 170, 25, 20);
		this.mes_libro_modificar.disable();
		panel_libro.add(this.mes_libro_modificar);
		
		JLabel ano_libro_modificar = new JLabel("Ano");
		ano_libro_modificar.setBounds(740, 150, 40, 20);
		ano_libro_modificar.setForeground(Color.white);
		ano_libro_modificar.setFont(new Font("arial",1,10));
		panel_libro.add(ano_libro_modificar);
		
		this.ano_libro_modificar = new JTextField();
		this.ano_libro_modificar.setBounds(740, 170, 40, 20);
		this.ano_libro_modificar.disable();
		panel_libro.add(this.ano_libro_modificar);
		
		
		
		JLabel codigo_libro_editorial_modificar = new JLabel("Codigo Editorial");
		codigo_libro_editorial_modificar.setBounds(550, 190, 680, 20);
		codigo_libro_editorial_modificar.setForeground(Color.white);
		codigo_libro_editorial_modificar.setFont(new Font("arial",1,10));
		panel_libro.add(codigo_libro_editorial_modificar);
		
		this.codigo_libro_editorial_modificar = new JTextField();
		this.codigo_libro_editorial_modificar.setBounds(550, 210, 230, 20);
		this.codigo_libro_editorial_modificar.disable();
		panel_libro.add(this.codigo_libro_editorial_modificar);
		
		JLabel codigo_libro_modificar = new JLabel("Codigo Libro");
		codigo_libro_modificar.setBounds(620, 260, 680, 20);
		codigo_libro_modificar.setForeground(Color.white);
		panel_libro.add(codigo_libro_modificar);
		
		this.codigo_libro_modificar = new JTextField();
		this.codigo_libro_modificar.setBounds(605, 280, 125, 20);
		panel_libro.add(this.codigo_libro_modificar);
		
		this.buscar_libro_modificar = new JButton("Buscar");
		this.buscar_libro_modificar.setBounds(620, 310, 95, 20);
		panel_libro.add(this.buscar_libro_modificar);
		
		this.modificar_libro = new JButton("Modificar");
		this.modificar_libro.setBounds(590, 340, 160, 20);
		this.modificar_libro.enable(false);
		panel_libro.add(this.modificar_libro);
		
		//Eliminar libro
		
		JLabel eliminar_libro = new JLabel("Eliminar Libro",SwingConstants.CENTER);
		eliminar_libro.setBounds(0, 45, 800, 20);
		eliminar_libro.setForeground(Color.white);
		eliminar_libro.setFont(new Font("arial",Font.BOLD,16));
		panel_libro.add(eliminar_libro);
		
		JLabel codigo_eliminar = new JLabel("Codigo");
		codigo_eliminar.setBounds(300, 70, 800, 20);
		codigo_eliminar.setForeground(Color.white);
		panel_libro.add(codigo_eliminar);
		
		this.eliminar_libro = new JTextField();
		this.eliminar_libro.setBounds(300, 90, 165, 20);
		panel_libro.add(this.eliminar_libro);
		
		this.boton_eliminar_libro = new JButton("Eliminar");
		this.boton_eliminar_libro.setBounds(320, 120, 120, 20);
		panel_libro.add(this.boton_eliminar_libro);
		
		//Agregar autor al libro
		
		JLabel agregar_autor = new JLabel("Anadir Autor",SwingConstants.CENTER);
		agregar_autor.setBounds(0, 170, 750, 20);
		agregar_autor.setForeground(Color.white);
		agregar_autor.setFont(new Font("arial",Font.BOLD,16));
		panel_libro.add(agregar_autor);
		
		this.agregar_autor_libro_codigo = new JTextField();
		this.agregar_autor_libro_codigo.setBounds(300, 220, 165, 20);
		panel_libro.add(this.agregar_autor_libro_codigo);
		
		JLabel etiqueta_agregar = new JLabel("Codigo",SwingConstants.LEFT);
		etiqueta_agregar.setBounds(300, 200, 790, 20);
		etiqueta_agregar.setForeground(Color.white);
		panel_libro.add(etiqueta_agregar);
		
		this.agregar_autor_libro_cedula = new JTextField();
		this.agregar_autor_libro_cedula.setBounds(300, 270, 165, 20);
		panel_libro.add(this.agregar_autor_libro_cedula);
		
		JLabel etiqueta_agregar2 = new JLabel("Cedula Autor");
		etiqueta_agregar2.setBounds(300, 250, 790, 20);
		etiqueta_agregar2.setForeground(Color.white);
		panel_libro.add(etiqueta_agregar2);
		
		this.agregar_autor = new JButton("Anadir");
		this.agregar_autor.setBounds(320, 320, 120, 20);
		panel_libro.add(this.agregar_autor);
		
		//mostrar libro
		JLabel mostrar_libro = new JLabel("Mostrar Libro",SwingConstants.CENTER);
		mostrar_libro.setBounds(0, 380, 750, 20);
		mostrar_libro.setForeground(Color.white);
		mostrar_libro.setFont(new Font("arial",Font.BOLD,18));
		panel_libro.add(mostrar_libro);
		
		JLabel codigo_libro1 = new JLabel("Codigo");
		codigo_libro1.setBounds(300, 410, 790, 20);
		codigo_libro1.setForeground(Color.white);
		codigo_libro1.setFont(new Font("arial",Font.BOLD,16));
		panel_libro.add(codigo_libro1);
		
		this.codigo_libro_mostrar = new JTextField();
		this.codigo_libro_mostrar.setBounds(300, 430, 165, 20);
		panel_libro.add(this.codigo_libro_mostrar);
		
		this.mostrar_libro = new JButton("Mostrar");
		this.mostrar_libro.setBounds(320, 460, 120, 20);
		panel_libro.add(this.mostrar_libro);
		
		
	}

	private void menu_libreria() {
		JPanel panel_libreria = new JPanel();
		panel_libreria.setLayout(null);
		panel_libreria.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Libreria", panel_libreria);
		
		//etiquetas del menu de propietario
		
		JLabel titulo = new JLabel("Menu de Libreria",SwingConstants.CENTER);
		titulo.setBounds(0, 10, 800, 20);
		titulo.setFont(new Font("arial",Font.BOLD,20));
		titulo.setForeground(Color.white);
		panel_libreria.add(titulo);
		
		JLabel registro = new JLabel("Registrar");
		registro.setBounds(50, 45, 600, 20);
		registro.setFont(new Font("arial",Font.BOLD,18));
		registro.setForeground(Color.white);
		panel_libreria.add(registro);
		
		//campos de texto y leyendas de los campos de texto Registro del propietario
		this.nombre_libreria = new JTextField();
		this.nombre_libreria.setBounds(20, 90, 150, 20);
		panel_libreria.add(this.nombre_libreria);
		
		JLabel nombre_libreria = new JLabel("Nombre");
		nombre_libreria.setBounds(20, 70, 130, 20);
		nombre_libreria.setForeground(Color.white);
		panel_libreria.add(nombre_libreria);
		
		this.direccion_libreria = new JTextField();
		this.direccion_libreria.setBounds(20, 140, 150, 20);
		panel_libreria.add(this.direccion_libreria);
		
		JLabel direccion_libreria = new JLabel("Direccion");
		direccion_libreria.setBounds(20, 120, 130, 20);
		direccion_libreria.setForeground(Color.white);
		panel_libreria.add(direccion_libreria);
		
		this.estado_libreria = new JTextField();
		this.estado_libreria.setBounds(20, 190, 150, 20);
		panel_libreria.add(this.estado_libreria);
		
		JLabel estado_libreria= new JLabel("Estado");
		estado_libreria.setBounds(20, 170, 130, 20);
		estado_libreria.setForeground(Color.white);
		panel_libreria.add(estado_libreria);
		
		this.localidad_libreria = new JTextField();
		this.localidad_libreria.setBounds(20, 240, 150, 20);
		panel_libreria.add(this.localidad_libreria);
		
		JLabel localidad_libreria = new JLabel("Localidad");
		localidad_libreria.setBounds(20, 220, 130, 20);
		localidad_libreria.setForeground(Color.white);
		panel_libreria.add(localidad_libreria);
		
		this.telefono_libreria = new JTextField();
		this.telefono_libreria.setBounds(20, 290, 150, 20);
		panel_libreria.add(this.telefono_libreria);
		
		JLabel telefono_libreria = new JLabel("Telefono");
		telefono_libreria.setBounds(20, 270, 130, 20);
		telefono_libreria.setForeground(Color.white);
		panel_libreria.add(telefono_libreria);
		
		this.rif_libreria= new JTextField();
		this.rif_libreria.setBounds(20, 340, 150, 20);
		panel_libreria.add(this.rif_libreria);
		
		JLabel rif_libreria = new JLabel("Rif");
		rif_libreria.setBounds(20, 320, 130, 20);
		rif_libreria.setForeground(Color.white);
		panel_libreria.add(rif_libreria);
		
		
		this.registrar_libreria = new JButton("Registrar");
		this.registrar_libreria.setBounds(40, 370, 100, 20);
		panel_libreria.add(this.registrar_libreria);
		
		//Registrar libro para la libreria
		
		
		JLabel anadir_libro = new JLabel("Anadir Libro",SwingConstants.CENTER);
		anadir_libro.setBounds(0, 45, 800, 20);
		anadir_libro.setForeground(Color.white);
		anadir_libro.setFont(new Font("arial",Font.BOLD,16));
		panel_libreria.add(anadir_libro);
		
		JLabel agregar_libro = new JLabel("Codigo Libro");
		agregar_libro.setBounds(300, 70, 800, 20);
		agregar_libro.setForeground(Color.white);
		panel_libreria.add(agregar_libro);
		
		this.agregar_libro_codigo_libreria = new JTextField();
		this.agregar_libro_codigo_libreria.setBounds(300, 90, 165, 20);
		panel_libreria.add(this.agregar_libro_codigo_libreria);
		
		
		JLabel etiqueta_rif = new JLabel("Rif Libreria");
		etiqueta_rif.setBounds(300, 110, 800, 20);
		etiqueta_rif.setForeground(Color.white);
		panel_libreria.add(etiqueta_rif);
		
		this.agregar_libro_rif_libreria = new JTextField();
		this.agregar_libro_rif_libreria.setBounds(300, 130, 165, 20);
		panel_libreria.add(this.agregar_libro_rif_libreria);
		
		JLabel ejemplares = new JLabel("Ejemplares");
		ejemplares.setBounds(300, 150, 800, 20);
		ejemplares.setForeground(Color.white);
		panel_libreria.add(ejemplares);
		
		this.agregar_libro_libreria_ejemplares = new JTextField();
		this.agregar_libro_libreria_ejemplares.setBounds(300, 170, 165, 20);
		panel_libreria.add(this.agregar_libro_libreria_ejemplares);
		
		
		this.agregar_libro_libreria = new JButton("Anadir");
		this.agregar_libro_libreria.setBounds(320, 200, 120, 20);
		panel_libreria.add(this.agregar_libro_libreria);
		
	}

	private void mostrar_datos() {
		
		//Panel extra
		JPanel panel_extra = new JPanel();
		panel_extra.setLayout(null);
		panel_extra.setBackground(Color.decode("#263d42"));
		this.principal.addTab("Extra", panel_extra);
		
		JLabel mostrar_editoriales = new JLabel("Mostrar editoriales");
		mostrar_editoriales.setBounds(30, 60, 500, 20);
		mostrar_editoriales.setForeground(Color.white);
		mostrar_editoriales.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(mostrar_editoriales);
		
		this.mostrar_editoriales = new JButton("Mostrar");
		this.mostrar_editoriales.setBounds(50, 80, 100, 20);
		panel_extra.add(this.mostrar_editoriales);
		
		JLabel mostrar_propietarios = new JLabel("Mostrar Propietarios");
		mostrar_propietarios.setBounds(230, 60, 500, 20);
		mostrar_propietarios.setForeground(Color.white);
		mostrar_propietarios.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(mostrar_propietarios);
		
		this.mostrar_propietarios = new JButton("Mostrar");
		this.mostrar_propietarios.setBounds(265, 80, 100, 20);
		panel_extra.add(this.mostrar_propietarios);
		
		JLabel mostrar_autores = new JLabel("Mostrar Autores");
		mostrar_autores.setBounds(435, 60, 500, 20);
		mostrar_autores.setForeground(Color.white);
		mostrar_autores.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(mostrar_autores);
		
		this.mostrar_autores = new JButton("Mostrar");
		this.mostrar_autores.setBounds(450, 80, 100, 20);
		panel_extra.add(this.mostrar_autores);
		
		JLabel mostrar_libros = new JLabel("Mostrar Libros");
		mostrar_libros.setBounds(40,120, 500, 20);
		mostrar_libros.setForeground(Color.white);
		mostrar_libros.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(mostrar_libros);
		
		this.mostrar_libros = new JButton("Mostrar");
		this.mostrar_libros.setBounds(50, 140, 100, 20);
		panel_extra.add(this.mostrar_libros);
		
		JLabel mostrar_librerias = new JLabel("Mostrar Librerias");
		mostrar_librerias.setBounds(245,120, 500, 20);
		mostrar_librerias.setForeground(Color.white);
		mostrar_librerias.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(mostrar_librerias);
		
		this.mostrar_librerias = new JButton("Mostrar");
		this.mostrar_librerias.setBounds(265, 140, 100, 20);
		panel_extra.add(this.mostrar_librerias);
		
		
		
		JLabel etiqueta_ejemplares = new JLabel("Libros sin ejemplares");
		etiqueta_ejemplares.setBounds(435, 120, 500, 20);
		etiqueta_ejemplares.setForeground(Color.white);
		etiqueta_ejemplares.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(etiqueta_ejemplares);
		
		this.codigo_libro_no_ejemplares = new JTextField();
		this.codigo_libro_no_ejemplares.setBounds(455, 150, 100, 20);
		panel_extra.add(this.codigo_libro_no_ejemplares);
		
		this.mostrar_librerias_no_ejemplares = new JButton("Mostrar");
		this.mostrar_librerias_no_ejemplares.setBounds(465, 180, 80, 20);
		this.mostrar_librerias_no_ejemplares.setFont(new Font("arial",Font.BOLD,10));
		panel_extra.add(this.mostrar_librerias_no_ejemplares);
		
		JLabel libros_sin_asignar = new JLabel("Libros sin Asignar");
		libros_sin_asignar.setBounds(40,180, 500, 20);
		libros_sin_asignar.setForeground(Color.white);
		libros_sin_asignar.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(libros_sin_asignar);
		
		this.mostrar_libros_sin_asignar = new JButton("Mostrar");
		this.mostrar_libros_sin_asignar.setBounds(50, 200, 100, 20);
		panel_extra.add(this.mostrar_libros_sin_asignar);
		
		JLabel cantidades_totalizadas = new JLabel("Cantidades Totalizadas");
		cantidades_totalizadas.setBounds(245,180, 500, 20);
		cantidades_totalizadas.setForeground(Color.white);
		cantidades_totalizadas.setFont(new Font("arial",Font.BOLD,15));
		panel_extra.add(cantidades_totalizadas);
		
		this.mostrar_cantidad_totalizada = new JButton("Mostrar");
		this.mostrar_cantidad_totalizada.setBounds(265,200, 100, 20);
		panel_extra.add(this.mostrar_cantidad_totalizada);
		
		JLabel cantidad_ejemplares = new JLabel("Cantidad ejemplares");
		cantidad_ejemplares.setBounds(265, 250, 500, 20); 
		cantidad_ejemplares.setForeground(Color.white);
		panel_extra.add(cantidad_ejemplares);
		
		this.cantidad_ejemplares = new JTextField();
		this.cantidad_ejemplares.setBounds(265, 270, 150, 20);
		panel_extra.add(this.cantidad_ejemplares);
		
		this.buscar_libro_ejemplares = new JButton("Buscar");
		this.buscar_libro_ejemplares.setBounds(290, 300, 100, 20);
		panel_extra.add(this.buscar_libro_ejemplares);
	}
	
	
	public void crear_tabla_libro_ejemplares() { 
		this.ventana_mostrar_ejemplares = new JFrame(); /*Se crea la ventana donde se mostrara la tabla */
		this.ventana_mostrar_ejemplares.setTitle("Informacion de libros"); /*se le añade el titulo a la ventana de la tabla */
		String[] header = {"Titulo","Codigo","Ejemplares"}; /*Arreglo con el nombre de los encabezados de la tabla */
		this.model_mostrar_ejemplares = new DefaultTableModel(null,header); /*Se crea el modelo default de java para una tabla pasandole null y header con el nombre de los encabezados */
		JTable tabla = new JTable(this.model_mostrar_ejemplares);/* se crea la tabla con el modelo model_mostrar_ejemplares*/
		tabla.setPreferredScrollableViewportSize(new Dimension(500,100)); /*se establece desde que punto se podra hacer scroll en la pestaña */
		JScrollPane scroll = new JScrollPane(tabla); /*Se establece para que se pueda hacer scroll cuando la tabla crezca mucho */
		this.ventana_mostrar_ejemplares.add(scroll); /* se ñade el scroll */
		this.ventana_mostrar_ejemplares.pack(); /* se añade todos los atributos de la tabla, a la ventana principal*/
		this.ventana_mostrar_ejemplares.setVisible(false); /*y se establece la vista en falso, para que solo aparezca cuando se presione el botonde mostrar */
	}
			/* asi seria la creacion y funcionamiento de todas y cada unas de las tablas en el codigo.!*/
	public void crear_tabla_cantidades_totalizadas() {
		this.ventana_mostrar_cantidades = new JFrame();
		this.ventana_mostrar_cantidades.setTitle("Total Bolivares y Total ejemplares");
		//array de String’s con los títulos de las columnas
		String[] header_editorial = {"Titulo","Codigo","Costo","Total Ejemplares","Total Bolivares"};
		//creamos el modelo de tabla con los datos anteriores
		this.model_cantidades_totalizadas = new DefaultTableModel(null, header_editorial);
		//se crea la tabla con el defaultablemodel
		JTable tabla = new JTable(this.model_cantidades_totalizadas);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 100));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.ventana_mostrar_cantidades.add(scrollPane);
		this.ventana_mostrar_cantidades.pack();
		this.ventana_mostrar_cantidades.setVisible(false);
	}
	
	
	public void crear_tabla_mostrar_libro() {
		this.ventana_mostrar_libro = new JFrame();
		this.ventana_mostrar_libro.setTitle("Datos del libro");
		//String datos_libro[] = {"Datos libro y Librerias"};
		this.model_mostrar_libro = new DefaultTableModel();
		JTable tabla = new JTable(this.model_mostrar_libro);
		tabla.setPreferredScrollableViewportSize(new Dimension(800,100));
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.ventana_mostrar_libro.add(scrollPane);
		this.ventana_mostrar_libro.pack();
		this.ventana_mostrar_libro.setVisible(false);
	}
	
	public void crear_tabla_mostrar_libros_sin_asignar() {
		this.ventana_libros_sin_asignar = new JFrame();
		this.ventana_libros_sin_asignar.setTitle("Libros sin asignar");
		String[] header = {"Titulo","Codigo","Ejemplares"};
		this.model_libro_sin_asginar = new DefaultTableModel(null,header);
		JTable tabla = new JTable(this.model_libro_sin_asginar);
		tabla.setPreferredScrollableViewportSize(new Dimension(500,100));
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.ventana_libros_sin_asignar.add(scrollPane);
		ventana_libros_sin_asignar.pack();
		ventana_libros_sin_asignar.setVisible(false);
	}
	public void crear_tabla_libros_no_ejemplares() {
		//Mostrar todas las librerias
		this.ventana_libreras_libros = new JFrame();
		this.ventana_libreras_libros.setTitle("Libros sin ejemplares");
		String[] header_ventana = {"Libreria","Libro","Ejemplares"};
		this.model_librerias_libro = new DefaultTableModel(null,header_ventana);
		JTable tabla_librerias = new JTable(this.model_librerias_libro);
		tabla_librerias.setPreferredScrollableViewportSize(new Dimension(800,100));
		
		JScrollPane scroll5 = new JScrollPane(tabla_librerias);
		this.ventana_libreras_libros.add(scroll5);
		this.ventana_libreras_libros.pack();
		this.ventana_libreras_libros.setVisible(true);
		//this.ventana_librerias.setDefaultCloseOperation();
	}
	public void crear_tabla_librerias() {
		//Mostrar todas las librerias
		this.ventana_librerias = new JFrame();
		this.ventana_librerias.setTitle("Datos Librerias");
		String[] header_librerias = {"Nombre","Direccion","Estado","Localidad","Fecha de Registro","Telefono","Rif","Propietario"};
		this.model_librerias = new DefaultTableModel(null,header_librerias);
		JTable tabla_librerias = new JTable(this.model_librerias);
		tabla_librerias.setPreferredScrollableViewportSize(new Dimension(800,100));
		
		JScrollPane scroll5 = new JScrollPane(tabla_librerias);
		this.ventana_librerias.add(scroll5);
		this.ventana_librerias.pack();
		this.ventana_librerias.setVisible(false);
		//this.ventana_librerias.setDefaultCloseOperation();
	}
	public void crear_tabla_autores() {
		//Mostrar todos los autores
		this.ventana_autores = new JFrame();
		this.ventana_autores.setTitle("Datos Autores");
		String[] header_autor = {"Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Direccion","Primer Libro","Telefono","Cedula"};
		this.model_autores = new DefaultTableModel(null,header_autor);
		JTable tabla_autores = new JTable(this.model_autores);
		tabla_autores.setPreferredScrollableViewportSize(new Dimension(800,100));
		
		JScrollPane scroll3 = new JScrollPane(tabla_autores);
		this.ventana_autores.add(scroll3);
		this.ventana_autores.pack();
		this.ventana_autores.setVisible(false);
	}
	public void crear_tabla_editoriales() {
		ventana = new JFrame();
		ventana.setTitle("Datos Editoriales");
		//array de String’s con los títulos de las columnas
		String[] header_editorial = {"Nombre Editorial","Pais Editorial","Codigo editorial"};
		//creamos el modelo de tabla con los datos anteriores
		this.model_editorial = new DefaultTableModel(null, header_editorial);
		//se crea la tabla con el defaultablemodel
		JTable tabla = new JTable(this.model_editorial);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 100));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		ventana.add(scrollPane);
		ventana.pack();
		ventana.setVisible(true);
	}
	
	public void crear_tabla_propietarios() {
		//Mostrar todos los propietarios
		this.ventana_propietarios = new JFrame();
		this.ventana_propietarios.setTitle("Datos Propietarios");
		String[] header_propietario = {"Primer nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Fecha de registro","Direccion","Estado","Telefono","Cedula"};
		this.model_propietarios = new DefaultTableModel(null,header_propietario);
		JTable tabla_propietarios = new JTable(this.model_propietarios);
		tabla_propietarios.setPreferredScrollableViewportSize(new Dimension(800,100));
		/*String[] datos = {"Jesus","Antonio","Figuera","Yaguare","La Asuncion","Nueva Esparta","04123548627","29660012"};
		this.model_propietarios.addRow(datos);*/
		
		
		JScrollPane scroll2 = new JScrollPane(tabla_propietarios);
		this.ventana_propietarios.add(scroll2);
		this.ventana_propietarios.pack();
		this.ventana_propietarios.setVisible(false);
		//this.ventana_propietarios.setDefaultCloseOperation();
	}
	
	public void crear_tabla_libros() {
		this.ventana_libros = new JFrame();
		this.ventana_libros.setTitle("Datos Libros");
		String[] header_libros = {"Titulo","Ciudad","Localidad","Ejemplares","Costo","Fecha Creacion","Codigo","Editorial","Autor 1","Autor 2","Autor 3","Autor 4","Autor 5"};
		this.model_libros = new DefaultTableModel(null,header_libros);
		JTable tabla_libros = new JTable(this.model_libros);
		tabla_libros.setPreferredScrollableViewportSize(new Dimension(800,100));
		
		JScrollPane scroll4 = new JScrollPane(tabla_libros);
		this.ventana_libros.add(scroll4);
		this.ventana_libros.pack();
		this.ventana_libros.setVisible(false);
	}
	
}
