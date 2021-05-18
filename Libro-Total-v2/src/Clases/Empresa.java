package Clases;
import Ventanas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import java.util.Date;



public class Empresa {
	final int max_usuarios = 20; // 20
	final int max_editoriales = 100; //100
	final int max_libros = 1000; // 1000
	final int max_autores = 500; // 5000   /* Constantes tomadas del enunciado para el programa*/
	final int max_librerias = 500; // 500
	final int max_propietario = 500; //500
	
	public Autor autores[];
	public Editorial editoriales[];
	public Libreria librerias[];
	public Libro libros[];
	public Propietario propietarios[];  /* ATRIBUTOS del objeto empresa, el cual esta constituido por arreglos de las demas clases*/
	public Usuario usuarios[];
	public Inicio inicio;
	public Menu menu;
	public Usuario usuario;
	
	public Empresa() {
		this.autores = new Autor[max_autores];
		this.editoriales = new Editorial[max_editoriales];
		this.librerias = new Libreria[max_librerias];
		this.libros = new Libro[max_libros];
		this.propietarios = new Propietario[max_propietario];  /* Inicializar los arreglos con los indices de las constantes indicadas */
		this.usuarios = new Usuario[max_usuarios];
		this.inicio = new Inicio();
		this.menu = new Menu();
		
		
	}
	
	public boolean validar_cadenas(String cadena) { /*metodo para validar los datos que se envian desde la interfaz */
		boolean valido = false;
		for(char c:cadena.toCharArray()) {
			if(Character.isLetter(c)) {
				valido = true;
			}
			else {
				valido=false;
			}
		}
		return valido;
	}
	
	//Metodo que valida si la cadena digitada por el usuario solo contiene numeros
	public boolean validar_cadena_numerica(String cadena) {
		boolean valido = false; 
		for(char c:cadena.toCharArray()) { // se separa en un arreglo la cadena digita por el usuario
			if(Character.isDigit(c)) { // Se verifica indice por indice si el caracter es un digito
				valido = true;
			}
			else {
				valido = false; //Si encuentra una letra o caracter que no sea numerico sale del bucle y retorna false
				break;
			}
		}
		return valido;
	}
	
	
	//Establecer eventos de los botones de la interfaz de usuario
	public void eventos_usuario() {
		ActionListener registrar = new ActionListener() { // Se le asigna una accion al boton de la intefaz
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = inicio.nombre.getText();  /* Aca se toman todos los datos que esten dentro de los campos de la interfaz al momento de presionar el boton */ 
				String apellido = inicio.apellido.getText();
				String usuario = inicio.usuario2.getText();
				String password = String.valueOf(inicio.password2.getPassword());  /* Eventos que se disparan dependiendo del boton seleccionado en la interfaz */
				if(validar_cadena_numerica(inicio.cedula.getText())) { /* SE vaalida que el dato emitido por el usuario sea un dato numerico de lo contrario le enviara un error */
					long cedula = Long.parseLong(inicio.cedula.getText());
					if(validar_cadena_numerica(inicio.telefono.getText())) {  /* SE validan los campos que deben ser numericos antes de convertirse a dato long o numerico. */
						long telefono = Long.parseLong(inicio.telefono.getText());
						registrar_usuario(nombre,apellido,usuario,password,telefono,cedula);
					}
					else {
						JOptionPane.showMessageDialog(null, "El telefono debe ser solo numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "La cedula debe ser solo numeros");
				}
				
			}
		};
		this.inicio.boton2.addActionListener(registrar);  /* Asignando el evento al boton */
		ActionListener ingresar = new ActionListener() { /* Evento para el boton de ingreso a la interfaz de menu principal */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String usuario = inicio.usuario.getText();
				String password = inicio.password.getText();
				ingresar(usuario, password);  /*Los campos que se encuentren dentro al ser enviados se pasan como parametros a el metodo ingresar para ser validados */
				
			}
		};
		inicio.boton1.addActionListener(ingresar); /*Agregando el evento al boton ingresar */
		ActionListener modificar_usuario = new ActionListener() { /*Evento al boton de modificar la contraseña del usuario */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(menu.nueva_contrasena.getText().length() >0) {
					String contrasena = menu.nueva_contrasena.getText();
					int opc = JOptionPane.showConfirmDialog(null, "Esta seguro que desea modificar?"); /*Se le pregunta al usuario mediante una ventana emergente si esta seguro de modificar */
					if(opc == 0) {
						usuarios[buscar_usuario(usuario.getUsuario())].modificar_usuario(contrasena); /* se modifica la contraseña */
					}
					else {
						menu.nueva_contrasena.setText(null); /*Se limpia el campo de texto dentro de la interfaz */
					}
				}
				
			}
		};
		this.menu.cambiar_contrasena.addActionListener(modificar_usuario); /*Añandiendo el evento al boton */
	
		ActionListener cerrar_sesion = new ActionListener() { /*Boton para cerrar sesion */ 
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				usuario = null; /* El objeto usuario que forma parte de la sesion del usuario es borrado  una vez haya cerrado sesion*/
				menu.setVisible(false); /*la ventana del menu principal se cierra */
				inicio.setVisible(true); /* se abre la ventana del menu de inicio */
				
			}
		};
		this.menu.cerrar_sesion.addActionListener(cerrar_sesion); /*ASignando evento al boton*/
	}
	
	//Metodos de usuario
	public int es_vacio_usuario() { /*Metodo es vacio para verificar si hay espacio o no dentro del arreglo de usuarios*/
		int vacio = -1;
		int i=0;
		boolean band = false;
		while(band == false && i<this.usuarios.length) { /*Se itera por todo el arreglo */
			if(this.usuarios[i] == null) { /*Se verifica que el objeto sea nulo, si es nulo, no se ha registrado ningun usuario en esa posicion del arreglo */
				vacio = i;
				band = true;
			}
			else {
				i++; /* caso contrario itera hasta ser mayor que el tamaño del arreglo de usuario */
			}
		}
		return vacio;
	}
	
	public int buscar_usuario(String usuario) { /*Se busca un usuario por su nombre de usuario para saber si esta o no registrado */
		int encontrado = -1;
		boolean band = false;
		int i =0;
		
		while(band == false && i<this.usuarios.length) {
			if(this.usuarios[i] != null) {/* Primer se verifica que la posicion en la que se encuentra no sea nula */
				if(this.usuarios[i].getUsuario().equals(usuario)) {  /* caso de no ser nula verifica si el usuario es igual al digitado por el usuario*/
					band = true;
					encontrado = i;
				}
				i++; /* caso contrario sigue iterando por el arreglo */
			}
			else {
				i++;
			}
		}
		return encontrado;
	}
	
	public int ingresar_usuario(String usuario,String password) { /*AQui se verifica que el usuario se encuentre registrado para ingresarlo al menu principal */
		int encontrado = -1;
		for(int i=0;i<this.usuarios.length;i++) { /* se itera por el arreglo de usuarios*/
			if(this.usuarios[i] != null) { /* verificar si es nula la posicion donde se encuentra el iterado */
				if(this.usuarios[i].getUsuario().equals(usuario) && this.usuarios[i].getPassword().equals(password)) { /* caso de no ser nla compara buscand coincidencias*/
					encontrado = i; /* en caso de coincidir retorna la posicion donde coincidio*/
				}
			}
		}
		return encontrado; /* retorna un dato de tipo entero*/
	}
	
	public int buscar_cedula_usuario(long cedula) {/* Al igual que el metodo de buscar usuario, este hace lo mismo solo que con la cedula para verificar si esta o no registrado */
		int encontrado = -1;
		boolean band = false;
		int i =0;
		
		while(band == false && i<this.usuarios.length) {
			if(this.usuarios[i] != null) {
				if(this.usuarios[i].getCedula() == cedula) {
					band = true;
					encontrado = i;
				}
				i++;
			}
			else {
				i++;
			}
		}
		return encontrado;
	}
	
	public void registrar_usuario(String nombre,String apellido,String usuario,String password,long telefono,long cedula) { /*Metodo para registrar al usuario que recibe como parametro los datos digitados por el usuario en la interfaz*/
		if(es_vacio_usuario() != -1) { /*Primero verifica que haya espacio dentro del arreglo de usuarios, de no haber envia una ventana emergente diciendo que no hay espacio */
			if(buscar_usuario(usuario) == -1 && buscar_cedula_usuario(cedula) == -1) { /*caso de haber espacio verifica que la cedula y el usuario no se encuentren ya registrados */
				this.usuarios[es_vacio_usuario()] = new Usuario(nombre,apellido,usuario,password,telefono,cedula); /* se añade el usuario al arreglo de usuarios en la posicion que retorna es _vacio */
				JOptionPane.showMessageDialog(null, "Registro exitoso");/* ventana emergente indicando que se registro */
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario existente");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
	}
	
	public void ingresar(String usuario,String password) { /*Misma funcion ingresar que la anterior la diferencia es que aqui llama a la anterior para verificar que existe el usuario e ingresarlo */
		if(ingresar_usuario(usuario, password) != -1) {/*validando que el usuario y la contraseña existan dentro de la empresa */
			JOptionPane.showMessageDialog(null, "Iniciaste sesion con exito!"); 
			inicio.setVisible(false); /*Se esconde la ventana de inicio */
			menu.setVisible(true); /*se muestra el menu principal */
			this.usuario = this.usuarios[ingresar_usuario(usuario, password)]; /*Al objeto usuario independiente funciona para la sesion de un usuario especifico y hacer la modificacion mas simple */
			menu.nombre_usuario.setText("Bienvenido "+this.usuario.nombre);/*AQui se le muestra un mensaje de bienvenida al usuario mediante el objeto independiente usuario que forma parte de la sesion del mismo */
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario o la contrasena son incorrectos!");
		}
	}
	
	//Metodos propietario
	
	public void eventos_propietario() { /*Eventos asignados a los botones del panel de propietario */
		ActionListener registro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre1 = menu.nombre_propietario.getText();
				String nombre2 = menu.nombre2_propietario.getText();
				String apellido = menu.apellido_propietario.getText();
				String apellido2 = menu.apellido2_propietario.getText(); /*Se toman todos los datos para el registro del propietario insertados por el usuario en la interfaz */
				String direccion = menu.direccion_propietario.getText();
				String estado = menu.estado_propietario.getText();
				if(validar_cadena_numerica(menu.telefono_propietario.getText())) { /* se validan los datos que deben ser numericos, como el telefono y la cedula */
					long telefono = Long.parseLong(menu.telefono_propietario.getText());
					if(validar_cadena_numerica(menu.cedula_propietario.getText())) {
						long cedula = Long.parseLong(menu.cedula_propietario.getText());
						registrar_propietario(nombre1, nombre2, apellido, apellido2, direccion, estado, telefono, cedula); /* se regisra el propietario */
					}
					else {
						JOptionPane.showMessageDialog(null, "La cedula deben ser solo numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El numero de telefono debe ser solo numeros");
				}
			}
		};
		menu.registrar_propietario.addActionListener(registro); /* asignando evento al boton en la interfaz */
		
		ActionListener buscar = new ActionListener() { /*boton para buscar un propietario en la empresa */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.cedula_modificar.getText())) { /*se valida que la cedula indicada en el campo de texto dentro de la interfaz sea solo numerica */
					long cedula = Long.parseLong(menu.cedula_modificar.getText());
					if(buscar_propietario(cedula) != -1) { /*Seguido se envia esa cedula como parametro al metodo buscar_propietario */
						int indice_propietario = buscar_propietario(cedula);
						String nombre1 = propietarios[indice_propietario].nombre;
						String nombre2 = propietarios[indice_propietario].nombre2;
						String apellido = propietarios[indice_propietario].apellido;
						String apellido2 = propietarios[indice_propietario].apellido2; /* si encuentra nu propietario asignado a esa cedula se toman los datos */
						String direccion = propietarios[indice_propietario].direccion;
						String telefono = String.valueOf(propietarios[indice_propietario].telefono);
						String estado = propietarios[indice_propietario].estado;
						
						menu.estado_modificar.setText(estado);  /*y se muestran los datos en la interfaz para ser modificados */
						menu.nombre1_modificar.setText(nombre1); menu.nombre2_modificar.setText(nombre2);
						menu.apellido1_modificar.setText(apellido); menu.apellido2_modificar.setText(apellido2);
						menu.direccion_modificar.setText(direccion); menu.telefono_modificar.setText(telefono);
						
						menu.estado_modificar.enable(); /* se habilitan los campos de modificacion que previamente estaban deshabilitados*/
						menu.nombre1_modificar.enable(); menu.nombre2_modificar.enable();
						menu.apellido1_modificar.enable(); menu.apellido2_modificar.enable();
						menu.direccion_modificar.enable(); menu.telefono_modificar.enable();
						
						menu.cedula_modificar.disable(); /* se deshabilita el campo dondew se digito la cedula para evitar que pueda ser cambiada durante el proceso de modificacion y evitar errores */
						
					}
					else {
						JOptionPane.showMessageDialog(null, "El propietario no existe");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Coloque solo numeros");
				}
				
			}
		};
		menu.buscar_boton_modificar.addActionListener(buscar); /*Añadiendo evento al boton de buscar en la interfaz para la modifcacion */
		
		ActionListener modificar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre1 = menu.nombre1_modificar.getText();
				String nombre2 = menu.nombre2_modificar.getText();
				String apellido = menu.apellido1_modificar.getText(); /*Se toman todos los digitadps por el usuario en el panel de modifacacion */
				String apellido2 = menu.apellido2_modificar.getText();
				String direccion = menu.direccion_modificar.getText();
				String estado = menu.estado_modificar.getText();
				if(validar_cadena_numerica(menu.telefono_modificar.getText())) { /* se validan los datos que deben ser numeros */
					long telefono = Long.parseLong(menu.telefono_modificar.getText());
					long cedula = Long.parseLong(menu.cedula_modificar.getText());
					propietarios[buscar_propietario(cedula)].modificar_propietario(nombre1, nombre2, apellido, apellido2, direccion, telefono, estado);
					JOptionPane.showMessageDialog(null, "Modificacion exitosa!"); /*se le pasan al metodo de la clase propietario para ser modificados */
					menu.nombre1_modificar.setText(null); menu.nombre1_modificar.disable(); /*se limpian los campos de texto en la interfaz de modificacion */
					menu.nombre2_modificar.setText(null); menu.nombre2_modificar.disable();
					menu.apellido1_modificar.setText(null); menu.apellido1_modificar.disable(); /*y nuevamente se deshabilitan los campos de modifcacion */
					menu.apellido2_modificar.setText(null); menu.apellido2_modificar.disable(); /* a su vez se habilita el campo para digitar una cedula, ya que fue modifcado */
					menu.direccion_modificar.setText(null); menu.direccion_modificar.disable(); 
					menu.estado_modificar.setText(null);	menu.estado_modificar.disable();
					menu.telefono_modificar.setText(null); menu.telefono_modificar.disable();
					menu.cedula_modificar.setText(null);  
					menu.cedula_modificar.enable();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "El Telefono debe contener solo numeros");
				}
				
			}
		};
		menu.modificar_propietario.addActionListener(modificar);
		
		ActionListener eliminar = new ActionListener() { /*creando evento para eliminar un propietario */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.cedula_eliminar.getText())) {
					long cedula = Long.parseLong(menu.cedula_eliminar.getText()); /*ademas se verifica que la cedula digitada en el campo de texto sea numerica */
					if(buscar_propietario(cedula) != -1) { /*se verifica que la cedula este dentro de la empresa */
						eliminar_propietario(cedula); /*una vez verificada se le pasa como parametro al metodo eliminar-propietario para ser elminado de la empresa */
					}
					else {
						JOptionPane.showMessageDialog(null, "La cedula no existe");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "La cedula solo debe contener numeros");
				}
				
			}
		};
		menu.eliminar_propietario.addActionListener(eliminar); /*se le añade el evento al boton de eliminar dentro de la interfaz */
	
		ActionListener anadir_libreria = new ActionListener() { /*Creando evento para añadir una libreria */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.agregar_libreria_cedula.getText())) {
					long cedula = Long.parseLong(menu.agregar_libreria_cedula.getText()); /*se validan que ambos campos tanto el rif de la libreria como la cedula del propietario sean ambos numeros */
					if(validar_cadena_numerica(menu.agregar_libreria_rif.getText())) { /* caso contrario mostrara una ventana emergente*/
						long rif = Long.parseLong(menu.agregar_libreria_rif.getText());
						if(buscar_propietario(cedula) != -1) { /*una vez validado los campos se busca tanto el propietario como el rif, asegurandose que existan*/
							if(buscar_libreria(rif) != -1) {
								propietarios[buscar_propietario(cedula)].anadir_libreria(librerias[buscar_libreria(rif)]); /* seguido de eso se le añade al arreglo de librerias del propietario */
								librerias[buscar_libreria(rif)].anadir_propietario(propietarios[buscar_propietario(cedula)]); /*y se le añade al propietario de la libreria colocada */
							}
							else {
								JOptionPane.showMessageDialog(null, "La libreria no existe");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "El propietario no existe");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Rif invalido");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Cedula Invalida");
				}
				
			}
		};
		menu.agregar_libreria.addActionListener(anadir_libreria); /* se le añade la funcion al boton de agregar libreria */
	}
	
	
	public int es_vacio_propietario() { /*FUncion para verificar que haya espacio dentro del arreglo de propietarios al momento de registrar */
		int es_vacio = -1;
		int i=0;
		boolean band = false;
		while(band == false && i<this.propietarios.length) { /*se itera por el arreglo de propietarios */
			if(this.propietarios[i] == null){ /* se verifica que la posicion actual del iterador sea nula, caso de serlo */
				es_vacio = i; /* retorna la posicion donde encontro nulo */
				band = true;
			}
			else {
				i++; /* caso contrario sigue iterando por todo el arreglo hasta encontrar coincidencia o hasta ser mayor que el tamaño del arreglo */
			}
		}
		return es_vacio;
	}
	
	public int buscar_propietario(long cedula) { /*buscar un propietario por su cedula */
		int encontrado = -1;
		boolean band = false; /* se inicializan las variables para iterar con un ciclo while */
		int i=0;
		while(band == false && i<this.propietarios.length) { /*se itera por todo el arreglo de propietarios */
			if(this.propietarios[i] != null) { /*se verifica que la posicion donde se encuentre no sea nla */
				if(this.propietarios[i].getCedula() == cedula) { /* para poder verificar si la cedula coincide o no */
					band = true; /* en caso de coincidir se devuelve la posicion donde coincidio */
					encontrado = i;
				}
				else {
					i++;
				}
			}
			else {
				i++; /* caso contrario sigue iterando hasta encontrar coincidencia o hasta que sea mayor que el tamaño del arreglo */
			}
		}
		return encontrado; /* retorna la plosicion */
	}
	
	public void registrar_propietario(String nombre,String nombre2,String apellido,String apellido2,
									  String direccion,String estado,long telefono,long cedula) { /*metodo que recibe como parametro los datos emitidos por el usuario en la interfaz ya validados */
		if(es_vacio_propietario() != -1) { /*se verifica que haya espacio dentro del arreglo de propietarios */
			if(buscar_propietario(cedula) == -1) { /*si hay espacio se valida que la cedula no este previamente registrada */
				this.propietarios[es_vacio_propietario()] = new Propietario(nombre,nombre2,apellido,apellido2,direccion,telefono,cedula,direccion);
				JOptionPane.showMessageDialog(null, "Registro exitoso"); /* en caso de no estar registrada se registra junto con un ventana emergente indicando que se registro */
			}
			else {
				JOptionPane.showMessageDialog(null, "Propietario ya registrado");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
	}

	public void eliminar_propietario(long cedula) { /*Metodo de eliminacion del propietario de la empresa,recibe como parametros la cedula emitida por el usuario en la interfaz ya validada */
		this.propietarios[buscar_propietario(cedula)] = null; /*primero se elimina el propietario de la empresa */
		for(int i=0;i<this.librerias.length;i++) { /*seguido se iteran por todas las librerias asegurandose de eliminarlo tanto de la empresa como las librerias a las que se encuentra asignado */
			if(this.librerias[i] != null) { /*se valida que la posicion donde se encuentra el iterador no sea nla */
				if(this.librerias[i].propietario != null) { /* se valida que se encuentre un propietario dentro de la libreria caso contrario no hara nada */
					if(this.librerias[i].propietario.getCedula() == cedula) { /*si no es nulo, y la cedula coincide es eliminado de la libreria */
						this.librerias[i].propietario = null; /*y asi sucesivamente mediante el ciclo for iterando por todas y cada una de las librerias */
						
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Eliminado con exito!");
	}
	//Metodos editorial
	public void eventos_editorial() {
		ActionListener registrar = new ActionListener() { /* al igual que en los eventos anteriores, boton para registrar una editorial*/
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = menu.nombre_editorial.getText();
				String pais = menu.pais_editorial.getText(); /* se toman los datos*/
				if(validar_cadena_numerica(menu.codigo_editorial.getText())) {
					long codigo = Long.parseLong(menu.codigo_editorial.getText()); /* se validan los numericos- */
					registrar_editorial(nombre, pais, codigo); /*y se le envian como parametro al metodo de registro */
				}
				else{
					JOptionPane.showMessageDialog(null, "El codigo deben ser solo numeros");
				}
			}
		};
		menu.registrar_editorial.addActionListener(registrar);
		
		ActionListener buscar = new ActionListener() { /*boton para buscar uan editorial y ser modificada */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.codigo_editorial_modificar.getText())) { /* se valida que el codigo este ingresado correctamente como dato numericos */
					long codigo = Long.parseLong(menu.codigo_editorial_modificar.getText()); /* se convierte de cadena a long */
					if(buscar_editorial(codigo) != -1) { /* se valida que la editorial e encuentre dentro de la empresa */
						String nombre = editoriales[buscar_editorial(codigo)].nombre;
						String pais = editoriales[buscar_editorial(codigo)].pais;
						menu.nombre_editorial_modificar.enable(); menu.nombre_editorial_modificar.setText(nombre); /*y se hace el mismo procedimiento que se hizo con la modificacion del propietario */
						menu.pais_editorial_modificar.enable(); menu.pais_editorial_modificar.setText(pais);
						menu.codigo_editorial_modificar.disable();
					}
					else {
						JOptionPane.showMessageDialog(null, "El codigo no existe");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El codigo solo debe contener numeros");
				}
				
				
			}
		};
		menu.buscar_editorial.addActionListener(buscar);/*se añade el evento */
		
		ActionListener modificar = new ActionListener() { /*creando evento para el boton modificar */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(menu.nombre_editorial_modificar.getText().length() != 0) {
					String nombre = menu.nombre_editorial_modificar.getText();
					String pais = menu.pais_editorial_modificar.getText(); /* se toman los datos ingresados por el usuario en el panel de modificacion */
					long codigo = Long.parseLong(menu.codigo_editorial_modificar.getText()); /* los numericos se convierten de cadena a long */
					editoriales[buscar_editorial(codigo)].modificar_editorial(nombre, pais);/*se modifica la editorial con el codigo emitido por el usuario */
					menu.nombre_editorial_modificar.setText(null); menu.nombre_editorial_modificar.disable();
					menu.pais_editorial_modificar.setText(null); menu.pais_editorial_modificar.disable(); /* y nuevamente se deshabilitan los campos */
					menu.codigo_editorial_modificar.enable();
					JOptionPane.showMessageDialog(null, "Modificada con exito!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe buscar una editorial antes de modificar");
				}
			}
		};
		menu.modificar_editorial.addActionListener(modificar);
	}
	
	
	public int es_vacio_editorial() {
		int es_vacio = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.editoriales.length) { /* Algoritmo de busqueda es vacio, el mismo implementado para el propietario*/
			if(this.editoriales[i] == null) {
				es_vacio = i;
				band = true;
			}
			else {
				i++;
			}
		}
		return es_vacio;
	}
	
	public int buscar_editorial(long codigo) { /*ALgoritmo de busqueda implementado en el propietario, solo que tomando como parametro el codigo de la editorial */
		int encontrado = -1;
		boolean band = false;
		int i =0;
		while(band == false && i<this.editoriales.length) {
			if(this.editoriales[i] != null) {
				if(this.editoriales[i].getCodigo() == codigo) {
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
	
	public void registrar_editorial(String nombre,String pais,long codigo) { /* se registra la editorial pasando como parametros los datos emitidos en la interfaz por el usuario */
		if(es_vacio_editorial() != -1) { /* se verifica que haya espacio en el arreglo */
			if(buscar_editorial(codigo) == -1) { /* se verifica que la editorial no este previamente registrada */
				this.editoriales[es_vacio_editorial()] = new Editorial(nombre,pais,codigo); /* y se registra en el espacio vacio encontrado */
				JOptionPane.showMessageDialog(null, "Registrada con exito!"); /*ventana emergente */
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya se encuentra registrada");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
	}

	//metodos autor
	
	public void eventos_autor() {
		ActionListener registrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre1 = menu.nombre_autor.getText();
				String nombre2 = menu.nombre2_autor.getText();           /* Se toman todos los datos del autor para ser registrado*/
				String apellido1 = menu.apellido_autor.getText();
				String apellido2 = menu.apellido2_autor.getText();
				String direccion = menu.direccion_autor.getText();
				if(validar_cadena_numerica(menu.dia_autor.getText())) {  /*se validan los datos que deben ser de tipo numerico */
					if(validar_cadena_numerica(menu.mes_autor.getText())) {
						if(validar_cadena_numerica(menu.ano_autor.getText())) {
							if(validar_cadena_numerica(menu.telefono_autor.getText())) {
								if(validar_cadena_numerica(menu.cedula_autor.getText())) {
									long telefono = Long.parseLong(menu.telefono_autor.getText()); /*previamente que son validados se convierten a enteros o long */
									long cedula = Long.parseLong(menu.cedula_autor.getText()); /*dependien del tipo de dato necesario con la funcion .parse de java */
									int dia = Integer.parseInt(menu.dia_autor.getText());
									int mes = Integer.parseInt(menu.mes_autor.getText());
									int ano = Integer.parseInt(menu.ano_autor.getText());
									registrar_autor(nombre1, nombre2, apellido1, apellido2, direccion, direccion, telefono, cedula, dia, mes, ano);
								}
								else {
									JOptionPane.showMessageDialog(null, "La cedula solo debe contener numeros");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El telefono solo debe contener numeros");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "El ano solo debe estar en numeros");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El mes solo debe estar en numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El dia solo debe estar en numeros");
				}
				
				
			}
		};
		menu.registrar_autor.addActionListener(registrar);
	
		ActionListener buscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(menu.cedula_modificar_autor.getText() != null) {
					if(validar_cadena_numerica(menu.cedula_modificar_autor.getText())) { /* se validan los datos de tipo numeroc ene ste caso la cedula */
						long cedula = Long.parseLong(menu.cedula_modificar_autor.getText()); /* una vez la cedula sea validada se convierte de cadena a tipo long*/
						if(buscar_autor(cedula) != -1) {
							menu.nombre1_modificar_autor.setText(autores[buscar_autor(cedula)].nombre);
							menu.nombre2_modificar_autor.setText(autores[buscar_autor(cedula)].nombre2);
							menu.apellido1_modificar_autor.setText(autores[buscar_autor(cedula)].apellido);
							menu.apellido2_modificar_autor.setText(autores[buscar_autor(cedula)].apellido2); /*Se le colocan a los campos de texto los datos que posee el autor al momento de ser registrado */
							menu.direccion_modificar_autor.setText(autores[buscar_autor(cedula)].direccion); /* para modificar debe solo cambiar el dato que usted prefiera y darle modificar */
							menu.telefono_modificar_autor.setText(String.valueOf(autores[buscar_autor(cedula)].telefono)); /*EN este caso se convierte de dato numerico a string para poder ser mostrado en la interfaz */
							menu.dia_autor_modificar.setText(String.valueOf(autores[buscar_autor(cedula)].dia));
							menu.mes_autor_modificar.setText(String.valueOf(autores[buscar_autor(cedula)].mes));
							menu.ano_autor_modificar.setText(String.valueOf(autores[buscar_autor(cedula)].ano));
							menu.nombre1_modificar_autor.enable();
							menu.nombre2_modificar_autor.enable();
							menu.apellido1_modificar_autor.enable();
							menu.apellido2_modificar_autor.enable();
							menu.direccion_modificar_autor.enable(); /*Se habilitan todos los campos de texto para la modificacion de los datos del autor */
							menu.telefono_modificar_autor.enable();
							menu.dia_autor_modificar.enable();
							menu.mes_autor_modificar.enable();
							menu.ano_autor_modificar.enable();
							menu.cedula_modificar_autor.disable();
						}
						else {
							JOptionPane.showMessageDialog(null, "La cedula no existe");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "La cedula debe estar compuesta solo por numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Indique una cedula");
				}
				
			}
		};
		menu.buscar_boton_modificar_autor.addActionListener(buscar);
	
		ActionListener modificar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(menu.nombre1_modificar_autor.getText() != null ) {
					String nombre1 = menu.nombre1_modificar_autor.getText();
					String nombre2 = menu.nombre2_modificar_autor.getText();
					String apellido1 = menu.apellido1_modificar_autor.getText();
					String apellido2 = menu.apellido2_modificar_autor.getText(); /*Se toman todos los datos en los campso de texto para modificar */
					String direccion = menu.direccion_modificar_autor.getText();
					if(validar_cadena_numerica(menu.telefono_modificar_autor.getText())) {
						long telefono = Long.parseLong(menu.telefono_modificar_autor.getText());
						if(validar_cadena_numerica(menu.dia_autor_modificar.getText())) {  /* se validan los numericos para ser modificados */
							if(validar_cadena_numerica(menu.mes_autor_modificar.getText())) {
								if(validar_cadena_numerica(menu.ano_autor_modificar.getText())) {
									int dia = Integer.parseInt(menu.dia_autor_modificar.getText()); /* una vez validados se convierten a un dato de tipo entero o long dependiendo del tipo de dato que sea */
									int mes = Integer.parseInt(menu.mes_autor_modificar.getText());
									int ano = Integer.parseInt(menu.ano_autor_modificar.getText());
									long cedula = Long.parseLong(menu.cedula_modificar_autor.getText());
									autores[buscar_autor(cedula)].modificar_autor(nombre1, nombre2, apellido1, apellido2, direccion, telefono, dia, mes, ano);
									JOptionPane.showMessageDialog(null, "Modificado con exito"); /* previamente validados se le mandan al metodo del autor de modificar para ser modificados*/
									
									menu.nombre1_modificar_autor.disable(); menu.nombre1_modificar_autor.setText(null); /* se limpian los campos y se deshabilitan, habilitando solo el de la cedula */
									menu.nombre2_modificar_autor.disable(); menu.nombre2_modificar_autor.setText(null);
									menu.apellido1_modificar_autor.disable(); menu.apellido1_modificar_autor.setText(null);
									menu.apellido2_modificar_autor.disable(); menu.apellido2_modificar_autor.setText(null);
									menu.direccion_modificar_autor.disable(); menu.direccion_modificar_autor.setText(null);
									menu.telefono_modificar_autor.disable(); menu.telefono_modificar_autor.setText(null);
									menu.dia_autor_modificar.disable(); menu.dia_autor_modificar.setText(null);
									menu.mes_autor_modificar.disable(); menu.mes_autor_modificar.setText(null);
									menu.ano_autor_modificar.disable(); menu.ano_autor_modificar.setText(null); 
									menu.cedula_modificar_autor.enable(); menu.cedula_modificar_autor.setText(null);
								}
								else {
									JOptionPane.showMessageDialog(null, "Fecha invalida");
								}
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el telefono");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe buscar un autor antes de modificar");
				}
				
			}
		};
		menu.modificar_autor.addActionListener(modificar);
	}
	
	
	public int es_vacio_autor() {
		int es_vacio = -1;
		boolean band = false; /*El mismo algoritmo de es vacio pero para el arreglo de autor */
		int i=0;
		while(band == false && i<this.autores.length) {
			if(this.autores[i] == null) {
				band = true;
				es_vacio = i;
			}
			else {
				i++;
			}
		}
		return es_vacio;
	}
	
	public int buscar_autor(long cedula) { /*El mismo algoritmo de buscar pero para el arreglo de autor con la cedula de un autor como parametro */
		int encontrado = -1;
		boolean band = false;
		int i=0;
		while(band == false && i<this.autores.length) {
			if(this.autores[i] != null) {
				if(this.autores[i].getCedula() == cedula) {
					band = true;
					encontrado = i;
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
	public void registrar_autor(String nombre,String nombre2,String apellido,String apellido2,
			  					String direccion,String estado,long telefono,long cedula,int dia,int mes,int ano) {
		if(es_vacio_autor() != -1) { /*Metodo para registrar, donde primero se valida que haya espacio para registrarlo */
			if(buscar_autor(cedula) == -1) { /* una vez validado, se verifica que el autor no este previamente registrado */
				this.autores[es_vacio_autor()] = new Autor(nombre, nombre2, apellido, apellido2, direccion, telefono, cedula, dia, mes, ano);
				JOptionPane.showInternalMessageDialog(null, "Registrado con exito"); /* y se mandan todos los datos insertados en la interfaz por el usuario para ser registrado*/
			}
			else {
				JOptionPane.showMessageDialog(null, "La cedula ya existe"); /* mensajes emergentes en caso de no cumplirse la condicion */
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada");
		}
		
	}

	//Metodos Libro
	
	public void eventos_libro() {
		ActionListener registrar = new ActionListener() { /*eventos para el boton de registrar un libro */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.codigo_editorial_libro.getText())) {
					long codigo_editorial = Long.parseLong(menu.codigo_editorial_libro.getText());
					if(buscar_editorial(codigo_editorial) != -1) {
						 int indice_editorial = buscar_editorial(codigo_editorial);
						 Editorial editorial = editoriales[indice_editorial];
						 String titulo = menu.titulo_libro.getText();  /* Se toman todos los datos insertados en la interfaz por el usuario */
						 String ciudad = menu.ciudad_libro.getText();
						 String localidad = menu.localidad_libro.getText();
						 if(validar_cadena_numerica(menu.ejemplares_libro.getText())) { /* se validan los que deben ser numericos */
							 int ejemplares = Integer.parseInt(menu.ejemplares_libro.getText());
							 if(validar_cadena_numerica(menu.monto_libro.getText())) {
								 int monto = Integer.parseInt(menu.monto_libro.getText());
								 if(validar_cadena_numerica(menu.dia_libro.getText())) {
									 if(validar_cadena_numerica(menu.mes_libro.getText())) {
										 if(validar_cadena_numerica(menu.ano_libro.getText())) {
											 if(validar_cadena_numerica(menu.codigo_libro.getText())) {
												 int dia = Integer.parseInt(menu.dia_libro.getText()); /*  una vez validados se convierten a enteros o long dependiendo del tipo de dato que se requiera*/
												 int mes = Integer.parseInt(menu.mes_libro.getText());
												 int ano = Integer.parseInt(menu.ano_libro.getText());
												 long codigo = Long.parseLong(menu.codigo_libro.getText());
												 registrar_libro(titulo, ciudad, localidad, ejemplares, monto, dia, mes, ano, codigo, editorial);
												 /* y son enviados al metodo de registrar libro*/
												 
											 
											 }
											 else {
												 JOptionPane.showMessageDialog(null, "El codigo debe ser solo numeros");
											 }
										 }
										 else {
											 JOptionPane.showMessageDialog(null, "El ano deben ser solo numeros");
										 }
									 }
									 else {
										 JOptionPane.showMessageDialog(null, "El mes deben ser solo numeros");
									 }
								 }
								 else {
									 JOptionPane.showMessageDialog(null, "El dia deben ser solo numeros");
								 }
							 }
							 else {
								 JOptionPane.showMessageDialog(null, "El monto deben ser solo numeros");
							 }
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Los ejemplares deben ser numeros");
						 }
					}
					else {
						JOptionPane.showMessageDialog(null, "Primero registre la Editorial");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Codigo de Editorial Invalido");
				}
				
				
			}
		};
		menu.registrar_libro.addActionListener(registrar);
		
		
		ActionListener buscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.codigo_libro_modificar.getText())) {
					long codigo_libro = Long.parseLong(menu.codigo_libro_modificar.getText());
					if(buscar_libro(codigo_libro) != -1) {
						menu.codigo_libro_modificar.disable();/*funciona de la misma forma que modificar las clases anteriores, se deshabilita el campo de introducir cedula para evitar errores a la hora de modificar */
						menu.titulo_libro_modificar.enable(); menu.titulo_libro_modificar.setText(libros[buscar_libro(codigo_libro)].titulo);/* y se llenan con los datos del libro que se desea modificar*/
						menu.ciudad_libro_modificar.enable(); menu.ciudad_libro_modificar.setText(libros[buscar_libro(codigo_libro)].ciudad);
						menu.localidad_libro_modificar.enable(); menu.localidad_libro_modificar.setText(libros[buscar_libro(codigo_libro)].localidad);
						menu.ejemplares_libro_modificar.enable(); menu.ejemplares_libro_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].ejemplares));
						menu.monto_libro_modificar.enable(); menu.monto_libro_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].monto));
						menu.dia_libro_modificar.enable(); menu.dia_libro_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].dia));
						menu.mes_libro_modificar.enable(); menu.mes_libro_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].mes));
						menu.ano_libro_modificar.enable(); menu.ano_libro_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].ano));
						menu.codigo_libro_editorial_modificar.enable(); menu.codigo_libro_editorial_modificar.setText(String.valueOf(libros[buscar_libro(codigo_libro)].editorial.getCodigo()));
						
						/* los datos que son de tipo numerico, long,int deben ser pasados a string antes de ser mostrados en la interfaz con la funcion de java String.valueof*/
					}
					else {
						JOptionPane.showMessageDialog(null, "El libro no existe");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Codigo invalido");
				}
				
			}
		};
		menu.buscar_libro_modificar.addActionListener(buscar);
	
		ActionListener modificar = new ActionListener() { /*boton para que el metodo de modificacion del libro sea llamado */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String titulo = menu.titulo_libro_modificar.getText();
				String ciudad = menu.ciudad_libro_modificar.getText();
				String localidad = menu.localidad_libro_modificar.getText();
				if(validar_cadena_numerica(menu.ejemplares_libro.getText())) {
					int ejemplares = Integer.parseInt(menu.ejemplares_libro_modificar.getText());
					if(validar_cadena_numerica(menu.monto_libro_modificar.getText())) {
						int monto = Integer.parseInt(menu.monto_libro_modificar.getText());
						if(validar_cadena_numerica(menu.dia_libro_modificar.getText())) { /* se toamn y validan los datos de tipo numericos */
							int dia = Integer.parseInt(menu.dia_libro_modificar.getText());
							if(validar_cadena_numerica(menu.mes_libro_modificar.getText())) {
								int mes = Integer.parseInt(menu.mes_libro_modificar.getText());
								if(validar_cadena_numerica(menu.ano_libro_modificar.getText())) {
									int ano = Integer.parseInt(menu.ano_libro_modificar.getText());
									if(validar_cadena_numerica(menu.codigo_libro_editorial_modificar.getText())) {
										long codigo_editorial = Long.parseLong(menu.codigo_libro_editorial_modificar.getText());
										if(buscar_editorial(codigo_editorial) != -1) {
											Editorial editorial = editoriales[buscar_editorial(codigo_editorial)];
											int codigo_libro = Integer.parseInt(menu.codigo_libro_modificar.getText());
											int indice_libro = buscar_libro(codigo_libro); /* una vez validos se pasan a tipo entero o long */
											if(ejemplares < libros[indice_libro].ejemplares) { /*se le envia como advertencia un mensaje al usuario en caso de que los ejemplares del libro sean menor a los que tenia previamente*/
												JOptionPane.showMessageDialog(null, "La cantidad de ejemplares que coloco es menor a la que habia anteriormente!");;
											}/*  seguido se le envian todos los datos como parametro al metodo de modificar un libro*/
											libros[indice_libro].modificar_libro(titulo, ciudad, localidad, dia, mes, ano, ejemplares, monto, codigo_libro, editorial);
											menu.codigo_libro_modificar.enable();
											menu.titulo_libro_modificar.disable(); menu.titulo_libro_modificar.setText(null);
											menu.ciudad_libro_modificar.disable(); menu.ciudad_libro_modificar.setText(null);
											menu.localidad_libro_modificar.disable(); menu.localidad_libro_modificar.setText(null);
											menu.ejemplares_libro_modificar.disable(); menu.ejemplares_libro_modificar.setText(null);
											menu.monto_libro_modificar.disable(); menu.monto_libro_modificar.setText(null);
											menu.dia_libro_modificar.disable(); menu.dia_libro_modificar.setText(null);
											menu.mes_libro_modificar.disable(); menu.mes_libro_modificar.setText(null);
											menu.ano_libro_modificar.disable(); menu.ano_libro_modificar.setText(null);
											menu.codigo_libro_editorial_modificar.disable(); menu.codigo_libro_editorial_modificar.setText(null);
											JOptionPane.showMessageDialog(null, "Modificado con exito");
										}
										else {
											JOptionPane.showMessageDialog(null, "La editorial no existe");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Codigo de la editorial Invalido. Solo numeros");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Ano invalido. Solo numeros");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Mes invalido. Solo numeros");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Dia invalido. Solo numeros");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El monto deben ser numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Los ejemplares deben ser solo numeros");
				}
				
			}
		};
		menu.modificar_libro.addActionListener(modificar); /* se añade el evento al boton*/
	
		ActionListener eliminar = new ActionListener() { /* Boton para eliminar un libro*/
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.eliminar_libro.getText())) {
					long codigo = Long.parseLong(menu.eliminar_libro.getText());
					if(buscar_libro(codigo) != -1) { /*se valida el codigo del libro insertado por el usuario en la interfaz */
						eliminar_libro(codigo); /*  una vez validado se le pasa el codigo como parametro a la funcion de eliminar un libro*/
						JOptionPane.showMessageDialog(null, "Eliminado exitosamente!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Codigo invalido");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Indique solo numeros en el codigo");
				}
				
			}
		};
		menu.boton_eliminar_libro.addActionListener(eliminar);
	
		ActionListener anadir_autor = new ActionListener() { /* boton para añadir un autor a un libro */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.agregar_autor_libro_codigo.getText())) {
					if(validar_cadena_numerica(menu.agregar_autor_libro_cedula.getText())) { /*se valida el codigo y la cedula del autor */
						long codigo = Long.parseLong(menu.agregar_autor_libro_codigo.getText());
						long cedula = Long.parseLong(menu.agregar_autor_libro_cedula.getText());
						if(buscar_libro(codigo) != -1) { /*se verifica que el libro este registrado */
							if(buscar_autor(cedula) != -1) { /* y se verifica que el autor este registrado */
								libros[buscar_libro(codigo)].anadir_autor(autores[buscar_autor(cedula)]); /* si ambos lo estan se llama el metodo de añadir autor de la clase libro*/
							}
							else {
								JOptionPane.showMessageDialog(null, "El autor no existe");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "El libro no existe");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "La cedula debe ser solo numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El codigo debe ser solo numeros");
				}
				
			}
		};
		menu.agregar_autor.addActionListener(anadir_autor);
	
		ActionListener mostrar_libro = new ActionListener() { /*boton para mostrar un libro */
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.codigo_libro_mostrar.getText())) { /*se valida que el codigo indicado sea un codigo numerico */
					long codigo = Long.parseLong(menu.codigo_libro_mostrar.getText()); /*se convierte des tring a long para ser pasado como parametro al metodo mostrar */
					menu.crear_tabla_mostrar_libro(); /* se crea una nueva ventana con una tabla para mostrar los datos del libro y las librerias en las que se encuentra */
					mostrar_libro(codigo); /*Cabe destacar que la primera fila de la tabla son los datos del libro, seguido de eso, es la informacion de las librerias */
				}
				else {
					JOptionPane.showMessageDialog(null, "Codigo invalido");
				}
				
			}
		};
		this.menu.mostrar_libro.addActionListener(mostrar_libro);
	}
	
	public int es_vacio_libro() { /* Algoritmo es_Vacio de busqueda implementando para el libro*/
		int es_vacio = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.libros.length) {
			if(this.libros[i] == null) {
				band = true;
				es_vacio = i;
			}
			else {
				i++;
			}
		}
		return es_vacio;
	}
	
	public int buscar_libro(long codigo) { /* algoritmo de busqueda para saber si existe o no un libro dentro del arreglo de libros*/
		int encontrado = -1;
		boolean band = false;
		int i=0;
		while(band == false && i<this.libros.length) {
			if(this.libros[i] != null) {
				if(this.libros[i].getCodigo() == codigo) {
					band = true;
					encontrado = i;
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

	public void registrar_libro(String titulo,String ciudad,String localidad,int ejemplares,int monto,int dia,int mes,int ano,long codigo,Editorial editorial) {
		if(es_vacio_libro() != -1) { /*se verifica que haya espacio dento del arreglo de libros */
			if(buscar_libro(codigo) == -1) { /*una vez verificado se verifica que el libro no este previamente registrado */
				this.libros[es_vacio_libro()] = new Libro(titulo,ciudad,localidad,dia,mes,ano,ejemplares,monto,codigo,editorial);
				JOptionPane.showMessageDialog(null, "Registrado con exito"); /*Una vez verificado los datos, se registra el libro en la posicion que retorna es vacio */
			}
			else {
				JOptionPane.showMessageDialog(null, "El libro ya fue registrado");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima alcanzada"); /*en caso de no cumplirse las condiciones se envia una ventana emegernte indicando porque */
		}
	}

	public void eliminar_libro(long codigo) {
		this.libros[buscar_libro(codigo)] = null; /*Recibe como parametro el codigo del libro a eliminar */
		for(int i=0;i<this.librerias.length;i++) { /* FUncion para eliminar un libro */ /*primero se elimina el libro de la empresa */
			if(this.librerias[i] != null) { /* se itera por todas las librerias y su inventario, buscando coincidencia con el codigo */
				for(int j=0;j<this.librerias[i].inventario.length;j++) { /* de encontrar una coincidencia se elimina el libro que tenga el mismo codigo que se envio por parametro */
					if(this.librerias[i].inventario[j] != null) {
						if(this.librerias[i].inventario[j].getCodigo() == codigo) {
							this.librerias[i].inventario[j] = null;
						}
					}
				}
			}
		}
		
	}
	//Metodos Libreria
	
	public void eventos_libreria() { 
		ActionListener registrar = new ActionListener() { /* */ 
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = menu.nombre_libreria.getText(); /*Se toman los datos insertados por el usuario dentro de la interfaz, una vez presionado el boton de reigstro */
				String direccion = menu.direccion_libreria.getText();
				String estado = menu.estado_libreria.getText();
				String localidad = menu.localidad_libreria.getText();
				if(validar_cadena_numerica(menu.telefono_libreria.getText())) { /*se validan los datos de tipo numerico */ 
					long telefono = Long.parseLong(menu.telefono_libreria.getText());
					if(validar_cadena_numerica(menu.rif_libreria.getText())) { /*una vez validados se pasan a long o int dependien de lo necesitado */
						long rif  = Long.parseLong(menu.rif_libreria.getText());
						if(buscar_libreria(rif) == -1) {  /*se verifica que la libreria no se encuentre registrada para ejecutar el metodo registrar_libreria */
							registrar_libreria(nombre, direccion, estado, localidad, telefono, rif);
						}
						else {
							JOptionPane.showMessageDialog(null, "Ya se encuentre registrada");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El rif debe contener solo numeros");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "El telefono solo debe contener numeros");
				}
				
			}
		};
		menu.registrar_libreria.addActionListener(registrar);
	
		ActionListener anadir_libro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.agregar_libro_codigo_libreria.getText())) {
					long codigo = Long.parseLong(menu.agregar_libro_codigo_libreria.getText());
					if(validar_cadena_numerica(menu.agregar_libro_rif_libreria.getText())) { /* Se toman los datos insertados por el usuario*/
						long rif = Long.parseLong(menu.agregar_libro_rif_libreria.getText());
						if(validar_cadena_numerica(menu.agregar_libro_libreria_ejemplares.getText())) { /* se validan los necasrios y se convierten a numero con la funcion .parse*/
							int ejemplares  = Integer.parseInt(menu.agregar_libro_libreria_ejemplares.getText());
							if(buscar_libro(codigo) != -1) {
								int indice_libro = buscar_libro(codigo);
								if(buscar_libreria(rif) != -1) {
									int indice_libreria = buscar_libreria(rif);
									if(ejemplares >= 0 && ejemplares <= libros[indice_libro].ejemplares) { /* se valida que la cantidad de libros a insertar dentro de la libreria sea mayor que 0 o menor a la cantidad de ejemplares en la empresa */
										if(librerias[indice_libreria].buscar_libro_inventario(codigo) == -1) {
											libros[indice_libro].ejemplares-= ejemplares; /*se le restan los ejemplares al libro de la empresa, que fueron añadidos a la libreria */
											librerias[indice_libreria].anadir_libro(libros[indice_libro],ejemplares);
										}
										else {
											JOptionPane.showMessageDialog(null, "El libro ya esta registrado");
										}
										
									}
									else {
										JOptionPane.showMessageDialog(null, "La cantidad de ejemplares debe ser 0 o menor que la cantidad en la empresa");
									}
								
								}
								else {
									JOptionPane.showMessageDialog(null, "La libreria no existe");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El libro no existe");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Los ejemplares deben ser solo numeros");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Rif invalido");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Codigo invalido");
				}
				
			}
		};
		menu.agregar_libro_libreria.addActionListener(anadir_libro);
	}
	
	public int es_vacio_libreria() {/* ALgoritmo de busqueda es vacio para la libreria*/
		int es_vacio = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.librerias.length) {
			if(this.librerias[i] == null) {
				band = true;
				es_vacio = i;
			}
			else {
				i++;
			}
		}
		
		return es_vacio;
	}
	
	
	public int buscar_libreria(long rif) {  /* ALgoritmo de busqueda es vacio para la libreria*/
		int encontrado = -1;
		boolean band = false;
		int i = 0;
		while(band == false && i<this.librerias.length) {
			if(this.librerias[i] != null) {
				if(this.librerias[i].getRif() == rif) {
					band = true;
					encontrado = i;
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

	public void registrar_libreria(String nombre,String direccion,String estado,String localidad,long telefono,long rif) {
		if(es_vacio_libreria() != -1) { /*  se valida que exista espacio en el arreglo de las librerias*/
			if(buscar_libreria(rif) == -1) { /* se valida que la libreria no este previamente registrada para ser registrada en la empresa*/
				this.librerias[es_vacio_libreria()] = new Libreria(nombre,direccion,estado,localidad,telefono,rif);
				JOptionPane.showMessageDialog(null, "Registrado con exito");
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya se encuentra registrada");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Capacidad maxima");
		}
	}


	//Metodos para mostrar los datos solicitados
	
	public boolean libro_asignado(long codigo) { /*Se verifica que un libro especifico perteneza o no a una libreria para luego ser mostrado */
		boolean existe = false;
		for(int i=0;i<this.librerias.length;i++) {
			if(this.librerias[i] != null) {
				for(int j=0;j<this.librerias[i].inventario.length;j++) {
					if(this.librerias[i].inventario[j] != null) {
						if(this.librerias[i].inventario[j].getCodigo() == codigo) {
							existe = true;
							break;
						}
					}
				}
			}
		}
		return existe;
	}

	public void eventos_panel_extra() {
		ActionListener mostrar_editoriales = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_editoriales(); /* SE crea una tabla que muestra informacion sobre todas las editorial en la empresa */
				mostrar_editoriales();
				
			}
		};
		menu.mostrar_editoriales.addActionListener(mostrar_editoriales);                  /*SE MUESTRAN TABLAS CON LOS DATOS DE PROPIETARIOS,AUTORES,LIBROS,LIBRERIAS Y EDITORIALES DE LA EMPRESA  */
	
	
		ActionListener mostrar_propietarios = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_propietarios(); /* se muestran  */
				mostrar_propietarios();
				
			}
		};
		menu.mostrar_propietarios.addActionListener(mostrar_propietarios);
	
		ActionListener mostrar_autores = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_autores();
				mostrar_autores();
				
			}
		};
		menu.mostrar_autores.addActionListener(mostrar_autores);
	
		ActionListener mostrar_libros = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_libros();
				mostrar_libros();
				
			}
		};
		menu.mostrar_libros.addActionListener(mostrar_libros);
	
		ActionListener mostrar_librerias = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_librerias();
				mostrar_librerias();
				
			}
		};
		this.menu.mostrar_librerias.addActionListener(mostrar_librerias);
	
		ActionListener mostrar_libro_no_ejemplares = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.codigo_libro_no_ejemplares.getText())) {
					long codigo = Long.parseLong(menu.codigo_libro_no_ejemplares.getText());
					menu.crear_tabla_libros_no_ejemplares();
					mostrar_librerias_no_ejemplares(codigo);
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe ingresar solo numeros");
				}
				
			}
		};
		this.menu.mostrar_librerias_no_ejemplares.addActionListener(mostrar_libro_no_ejemplares);
	
		ActionListener mostrar_libros_sin_asignar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_mostrar_libros_sin_asignar();
				mostrar_libros_sin_asignar();
				
			}
		};
		this.menu.mostrar_libros_sin_asignar.addActionListener(mostrar_libros_sin_asignar);
	
		
		ActionListener mostrar_cantidades_totalizadas = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.crear_tabla_cantidades_totalizadas();
				mostrar_cantidades_totalizadas();
				
			}
		};
		this.menu.mostrar_cantidad_totalizada.addActionListener(mostrar_cantidades_totalizadas);
		ActionListener mostrar_ejemplares = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validar_cadena_numerica(menu.cantidad_ejemplares.getText())) {
					int ejemplares = Integer.parseInt(menu.cantidad_ejemplares.getText());
					menu.crear_tabla_libro_ejemplares();
					mostrar_ejemplares(ejemplares);
				}
				else {
					JOptionPane.showMessageDialog(null, "Solo introduzca numeros");
				}
				
			}
		};
		this.menu.buscar_libro_ejemplares.addActionListener(mostrar_ejemplares);
	}
	
	public void mostrar_editoriales() {
		for(int i=0;i<this.editoriales.length;i++) {
			if(this.editoriales[i] != null) {
				this.menu.datos_editorial[0] = this.editoriales[i].nombre;
				this.menu.datos_editorial[1] = this.editoriales[i].pais;
				this.menu.datos_editorial[2] = String.valueOf(this.editoriales[i].getCodigo()); /*Se le pasan los datos a la tabla que va a mostrar los datos */
				this.menu.model_editorial.addRow(this.menu.datos_editorial); /* se le añade una fila a la tabla con los datos especificados */
				
			}
		}
		this.menu.ventana.setVisible(true);
		this.menu.model_editorial = null;
	}

	public void mostrar_propietarios() {
		for(int i=0;i<this.propietarios.length;i++) {
			if(this.propietarios[i] != null) {
				Date date = new Date();
				this.menu.datos_propietarios[0] = this.propietarios[i].nombre;
				this.menu.datos_propietarios[1] = this.propietarios[i].nombre2;
				this.menu.datos_propietarios[2] = this.propietarios[i].apellido; 
				this.menu.datos_propietarios[3] = this.propietarios[i].apellido2;
				this.menu.datos_propietarios[4] = this.propietarios[i].f_registro.format(date);
				this.menu.datos_propietarios[5] = this.propietarios[i].direccion;
				this.menu.datos_propietarios[6] = this.propietarios[i].estado;
				this.menu.datos_propietarios[7] = String.valueOf(this.propietarios[i].telefono);
				this.menu.datos_propietarios[8] = String.valueOf(this.propietarios[i].getCedula());
				this.menu.model_propietarios.addRow(this.menu.datos_propietarios);/* se le añade una fila a la tabla con los datos especificados */
			}
		}
		this.menu.ventana_propietarios.setVisible(true);
		this.menu.model_propietarios = null;
	}

	public void mostrar_autores() {
		for(int i=0;i<this.autores.length;i++) {
			if(this.autores[i] != null) {
				this.menu.datos_autores[0] = this.autores[i].nombre;
				this.menu.datos_autores[1] = this.autores[i].nombre2;
				this.menu.datos_autores[2] = this.autores[i].apellido;
				this.menu.datos_autores[3] = this.autores[i].apellido2;
				this.menu.datos_autores[4] = this.autores[i].direccion;
				this.menu.datos_autores[5] = String.valueOf(this.autores[i].dia+"/"+this.autores[i].mes+"/"+this.autores[i].ano);
				this.menu.datos_autores[6] = String.valueOf(this.autores[i].telefono);
				this.menu.datos_autores[7] = String.valueOf(this.autores[i].getCedula());
				this.menu.model_autores.addRow(this.menu.datos_autores);/* se le añade una fila a la tabla con los datos especificados */
			}
		}
		this.menu.ventana_autores.setVisible(true);
		this.menu.model_autores = null;
	}

	public void mostrar_libros() {
		for(int i=0;i<this.libros.length;i++) {
			if(this.libros[i] != null) {
				this.menu.datos_libros[0] = this.libros[i].titulo;
				this.menu.datos_libros[1] = this.libros[i].ciudad;
				this.menu.datos_libros[2] = this.libros[i].localidad;
				this.menu.datos_libros[3] = String.valueOf(this.libros[i].ejemplares);
				this.menu.datos_libros[4] = String.valueOf(this.libros[i].monto);
				this.menu.datos_libros[5] = String.valueOf(this.libros[i].dia+"/"+this.libros[i].mes+"/"+this.libros[i].ano);
				this.menu.datos_libros[6] = String.valueOf(this.libros[i].getCodigo());
				this.menu.datos_libros[7] = this.libros[i].editorial.nombre;
				if(this.libros[i].autores[0] != null) {
					this.menu.datos_libros[8] = this.libros[i].autores[0].nombre;
				}
				else {
					this.menu.datos_libros[8] = "false";   /*Se verifica si el libro contiene o no autores */
				} 											/* en caso de no contener solo mostrara null, si lo contiene mostrara el nombre del autor*/
				if(this.libros[i].autores[1] != null) {
					this.menu.datos_libros[9] = this.libros[i].autores[1].nombre;
				}
				else {
					this.menu.datos_libros[9] = "false";
				}
				if(this.libros[i].autores[2] != null) {
					this.menu.datos_libros[10] = this.libros[i].autores[2].nombre;
				}
				else {
					this.menu.datos_libros[10] = "false";
				}
				if(this.libros[i].autores[3] != null) {
					this.menu.datos_libros[11] = this.libros[i].autores[3].nombre;
				}
				else {
					this.menu.datos_libros[11] = "false";
				}
				if(this.libros[i].autores[4] != null) {
					this.menu.datos_libros[12] = this.libros[i].autores[4].nombre;
				}
				else {
					this.menu.datos_libros[12] = "false";
				}
				this.menu.model_libros.addRow(this.menu.datos_libros); /* se le añade una fila a la tabla con los datos especificados */
			}
		}
		this.menu.ventana_libros.setVisible(true);
		this.menu.model_libros = null;
	}

	public void mostrar_librerias() {
		for(int i=0;i<this.librerias.length;i++) {
			if(this.librerias[i] != null) {
				Date date = new Date();
				this.menu.datos_librerias[0] = this.librerias[i].nombre;
				this.menu.datos_librerias[1] = this.librerias[i].direccion;
				this.menu.datos_librerias[2] = this.librerias[i].estado;
				this.menu.datos_librerias[3] = this.librerias[i].localidad;
				this.menu.datos_librerias[4] = this.librerias[i].f_registro.format(date);
				this.menu.datos_librerias[5] = String.valueOf(this.librerias[i].telefono);
				this.menu.datos_librerias[6] = String.valueOf(this.librerias[i].getRif());
				if(this.librerias[i].propietario != null) { /*Si es null muestra null, si no, muestra el nombre del propietario de la libreria */
					this.menu.datos_librerias[7] = this.librerias[i].propietario.nombre; /* se le añade una fila a la tabla con los datos especificados */
				}
				else {
					this.menu.datos_librerias[7] = "null";
				}
				this.menu.model_librerias.addRow(this.menu.datos_librerias);
			}
		}
		this.menu.ventana_librerias.setVisible(true);
		this.menu.model_librerias = null;
	}

	public void mostrar_librerias_no_ejemplares(long codigo) {
		for(int i=0;i<this.librerias.length;i++) { /*Se muestran las librerias cuyos libros no contienen ejemplares dentro de ellas */
			if(this.librerias[i] != null) {
				for(int j=0;j<this.librerias[i].inventario.length;j++) {
					if(this.librerias[i].inventario[j] != null) {
						if(this.librerias[i].inventario[j].getCodigo() == codigo){
							if(this.librerias[i].inventario[j].ejemplares == 0) {
								this.menu.datos_libro_libreria[0] = this.librerias[i].nombre;
								this.menu.datos_libro_libreria[1] = this.librerias[i].inventario[j].titulo;
								this.menu.datos_libro_libreria[2] = String.valueOf(this.librerias[i].inventario[j].ejemplares);
								this.menu.model_librerias_libro.addRow(this.menu.datos_libro_libreria);/* se le añade una fila a la tabla con los datos especificados */
							}
						}
					}
				}
			}
		}
		this.menu.ventana_libreras_libros.setVisible(true); /* se muestra la tabla */
		this.menu.model_librerias_libro = null; /* y se borra el objeto de la tabla, para que se cree denuevo al presionar el boton */
	}

	public void mostrar_libros_sin_asignar() {
		for(int i=0;i<this.libros.length;i++) { /*Se muestran los libros que no han sido asignados a ninguna libreria */
			if(this.libros[i] != null) {
				if(!libro_asignado(this.libros[i].getCodigo())) { /*se utiliza la funcion de libro asignado, donde si retorna true el libro esta asignado caso contrario no lo esta */ 
					this.menu.datos_libro_sin_asignar[0] = this.libros[i].titulo; /* previamente si no esta asignado se muestra en la tabla, si lo esta, no se mucestra */
					this.menu.datos_libro_sin_asignar[1] = String.valueOf(this.libros[i].getCodigo());
					this.menu.datos_libro_sin_asignar[2] = String.valueOf(this.libros[i].ejemplares);
					this.menu.model_libro_sin_asginar.addRow(this.menu.datos_libro_sin_asignar); 
				}
			}
		}
		this.menu.ventana_libros_sin_asignar.setVisible(true);
		this.menu.model_libro_sin_asginar = null;
	}

	public void mostrar_libro(long codigo) {
		if(buscar_libro(codigo) != -1) {
			int indice_libro = buscar_libro(codigo); /* se muestra un libro con sus autores y el nombre de las librerias a las cuales se encuentra asignado */
			this.menu.datos_libro[0] = this.libros[indice_libro].titulo;
			this.menu.datos_libro[1] = this.libros[indice_libro].ciudad;
			this.menu.datos_libro[2] = this.libros[indice_libro].localidad;
			this.menu.datos_libro[3] = String.valueOf(this.libros[indice_libro].ejemplares);
			this.menu.datos_libro[4] = String.valueOf(this.libros[indice_libro].monto);
			this.menu.datos_libro[5] = String.valueOf(this.libros[indice_libro].dia+"/"+this.libros[indice_libro].mes+"/"+this.libros[indice_libro].ano);
			this.menu.datos_libro[6] = String.valueOf(this.libros[buscar_libro(codigo)].getCodigo());
			this.menu.datos_libro[7] = this.libros[buscar_libro(codigo)].editorial.nombre;
			if(this.libros[indice_libro].autores[0] != null) {
				this.menu.datos_libro[8] = this.libros[buscar_libro(codigo)].autores[0].nombre;
			}
			else {
				this.menu.datos_libro[8] = "null"; /* se muestra null en el caso de que el libro no posea un autor */
			}
			if(this.libros[indice_libro].autores[1] != null) {
				this.menu.datos_libro[9] = this.libros[buscar_libro(codigo)].autores[1].nombre;
			}
			else {
				this.menu.datos_libro[9] = "null";
			}
			if(this.libros[indice_libro].autores[2] != null) {
				this.menu.datos_libro[10] = this.libros[buscar_libro(codigo)].autores[2].nombre;
			}
			else {
				this.menu.datos_libro[10] = "null";
			}
			if(this.libros[indice_libro].autores[3] != null) {
				this.menu.datos_libro[11] = this.libros[buscar_libro(codigo)].autores[3].nombre;
			}
			else {
				this.menu.datos_libro[11] = "null";
			}
			if(this.libros[indice_libro].autores[4] != null) {
				this.menu.datos_libro[12] = this.libros[buscar_libro(codigo)].autores[4].nombre;
			}
			else {
				this.menu.datos_libro[12] = "null";
			}
			for(int i=0;i<this.menu.datos_libro.length;i++) {
				this.menu.model_mostrar_libro.addColumn(this.menu.datos_libro[i]);
			}
			for(int i = 0;i<this.librerias.length;i++) {
				if(this.librerias[i]!= null) {
					for(int j=0;j<this.librerias[i].inventario.length;j++) {
						if(this.librerias[i].inventario[j] != null) {
							if(this.librerias[i].inventario[j].getCodigo() == this.libros[indice_libro].getCodigo()) {
								this.menu.datos_libreria_mostrar_libro[0] = this.librerias[i].nombre;
								this.menu.datos_libreria_mostrar_libro[1] = String.valueOf(this.librerias[i].getRif());
								if(this.librerias[i].propietario != null) {
									this.menu.datos_libreria_mostrar_libro[2] = this.librerias[i].propietario.nombre;
								}
								else {
									this.menu.datos_libreria_mostrar_libro[2] = "null";
								}
								this.menu.model_mostrar_libro.addRow(this.menu.datos_libreria_mostrar_libro);
							}
						}
					}
				}
			}
			this.menu.ventana_mostrar_libro.setVisible(true);
			this.menu.model_mostrar_libro = null;
		}
		else {
			JOptionPane.showMessageDialog(null, "El libro no existe");
		}
	}

	
	public int total_ejemplares_librerias(long codigo) { /*Retorna un valor entero con la cantidad de ejemplares de un libro especifico en las librerias */
		int ejemplares = 0;
		for(int i=0;i<this.librerias.length;i++) {
			if(this.librerias[i]!= null) {
				for(int j=0;j<this.librerias[i].inventario.length;j++) {
					if(this.librerias[i].inventario[j] != null) {
						if(this.librerias[i].inventario[j].getCodigo() == codigo) {
							ejemplares += this.librerias[i].inventario[j].ejemplares;
						}
					}
				}
			}
		}
		return ejemplares;
	}
	
	public void mostrar_cantidades_totalizadas() { /*Se muestran las cantidades totalizadas de, tanto ejemplares, como monto en bolivares de un libro */
		int total_ejemplares = 0;
		int total_bolivares = 0;
		for(int i = 0;i<this.libros.length;i++) {
			if(this.libros[i] != null) {
				total_ejemplares += this.libros[i].ejemplares; /* se iteran por todos los libros de la empresa, añadiendole la cantidad en la emprea a total ejemplares*/
				total_ejemplares+=total_ejemplares_librerias(this.libros[i].getCodigo());/*luego se hace uso de la funcion total_ejempla_libreria, para obtener los ejemplares esparcidos por todas las libreras de esel ibro*/
				String[] datos = new String[5];
				datos[0] = this.libros[i].titulo;
				datos[1] = String.valueOf(this.libros[i].getCodigo());
				datos[2] = String.valueOf(this.libros[i].monto);
				datos[3] = String.valueOf(total_ejemplares);
				total_bolivares = this.libros[i].monto*total_ejemplares;
				datos[4] = String.valueOf(total_bolivares);
				this.menu.model_cantidades_totalizadas.addRow(datos);
				total_ejemplares = 0;
				total_bolivares = 0;
			}
		}
		this.menu.ventana_mostrar_cantidades.setVisible(true);
		this.menu.model_cantidades_totalizadas = null;
	}
	
	public void mostrar_ejemplares(int ejemplares) { /*se muestra los libros con la cantidad de ejemplares en un rango digitado por el usuario */
		for(int i=0;i<this.libros.length;i++) {
			if(this.libros[i] != null) {
				if(this.libros[i].ejemplares >= ejemplares) {
					String[] datos = new String[3];
					datos[0] = this.libros[i].titulo;
					datos[1] = String.valueOf(this.libros[i].getCodigo());
					datos[2] = String.valueOf(this.libros[i].ejemplares);
					this.menu.model_mostrar_ejemplares.addRow(datos);
				}
			}
		}
		this.menu.ventana_mostrar_ejemplares.setVisible(true);
		this.menu.model_mostrar_ejemplares = null;
	}
}
