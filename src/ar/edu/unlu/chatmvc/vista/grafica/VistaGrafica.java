package ar.edu.unlu.chatmvc.vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.edu.unlu.chatmvc.controlador.Controlador;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.vista.IVista;

public class VistaGrafica implements IVista {
	private VentanaInicioSesion vInicioSesion;
	private VentanaPrincipal vPrincipal;
	private Controlador controlador;

	public VistaGrafica(Controlador controlador) {
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		this.controlador = controlador;
		this.controlador.setVista(this);
		
		this.vPrincipal.onClickEnviar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.enviarMensaje(vPrincipal.getTextoMensaje());
				vPrincipal.setTextoMensaje("");
			}
		});
		this.vPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controlador.cerrarApp();
			}			
		});
		this.vInicioSesion.onClickIniciar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.conectarUsuario(vInicioSesion.getGetNombreUsuario());
				mostrarChat();
			}
		});
	}
	
	@Override
	public void mostrarListaUsuarios(IUsuario[] usuarios) {
		this.vPrincipal.actualizarListaUsuarios(usuarios);
	}

	@Override
	public void mostrarChat(IMensaje[] mensajes) {
		this.vPrincipal.actualizarChat(mensajes);
	}
	
	public void iniciar() {
		this.mostrarInicioSesion();
	}
	
	private void mostrarInicioSesion() {
		this.vInicioSesion.setVisible(true);
		this.vPrincipal.setVisible(false);
	}
	
	private void mostrarChat() {
		this.vInicioSesion.setVisible(false);
		this.vPrincipal.setVisible(true);
	}

}
