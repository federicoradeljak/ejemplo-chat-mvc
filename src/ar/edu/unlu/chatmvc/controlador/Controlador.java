package ar.edu.unlu.chatmvc.controlador;

import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.Eventos;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.vista.IVista;

public class Controlador implements Observer {
	
	private Chat modelo;
	private IVista vista;
	private IUsuario usuario;

	public Controlador(Chat modelo) {
		this.setModelo(modelo);
	}
	
	public Controlador() {
		
	}
	
	public void setModelo(Chat modelo) {
		this.modelo = modelo;
		this.modelo.addObserver(this);
	}
	
	public void setVista(IVista vista) {
		this.vista = vista;
	}
	
	public void enviarMensaje(String mensaje) {
		this.modelo.enviarMensaje(mensaje, this.usuario);
	}
	
	public void enviarMensajeDelSistema(String mensaje) {
		this.modelo.enviarMensajeDelSistema(mensaje);
	}
	
	public IMensaje[] getMensajes() {
		return this.modelo.getMensajes();
	}
	
	public void conectarUsuario(String nombre) {
		this.usuario = (IUsuario) this.modelo.conectarUsuario(nombre);
	}
	
	public void desconectarUsuario(int usuarioId) {
		this.modelo.desconectarUsuario(usuarioId);
	}
	
	public void cerrarApp() {
		this.modelo.cerrar(this.usuario.getId());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof Eventos) {
			switch ((Eventos) arg1) {
			case CAMBIO_LISTA_USUARIOS:
				this.vista.mostrarListaUsuarios((IUsuario[]) this.modelo.getUsuarios());
				break;
			case NUEVO_MENSAJE:
				this.vista.mostrarChat((IMensaje[]) this.modelo.getMensajes());
				break;
			default:
				break;
			
			}
		}
	}
}
