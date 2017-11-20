package ar.edu.unlu.chatmvc.modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Chat extends Observable {
	private HashMap<Integer, Usuario> usuarios;
	private ArrayList<Mensaje> mensajes;
	
	public Chat() {
		this.usuarios = new HashMap<>();
		this.mensajes = new ArrayList<>();
	}
	
	public Usuario conectarUsuario(String nombre) {
		Usuario u = new Usuario(nombre);
		this.usuarios.put(u.getId(), u);
		this.notificar(Eventos.CAMBIO_LISTA_USUARIOS);
		this.enviarMensajeDelSistema("Usuario "+nombre+" conectado");
		return u;
	}

	public void desconectarUsuario(int usuarioId) {
		Usuario usuario = this.usuarios.get(usuarioId);
		this.usuarios.remove(usuarioId);
		this.notificar(Eventos.CAMBIO_LISTA_USUARIOS);
		this.enviarMensajeDelSistema("Usuario "+usuario.getNombre()+" desconectado");
	}
	
	public Mensaje[] getMensajes() {
		Mensaje[] mensajes = new Mensaje[this.mensajes.size()];
		return this.mensajes.toArray(mensajes);
	}
	
	public Usuario[] getUsuarios() {
		Usuario[] usuarios = new Usuario[this.usuarios.size()];
		return this.usuarios.values().toArray(usuarios);
	}
	
	public void enviarMensaje(String mensaje, IUsuario usuario) {
		this.mensajes.add(new Mensaje(mensaje, usuario));
		this.notificar(Eventos.NUEVO_MENSAJE);
	}
	
	public void enviarMensajeDelSistema(String mensaje) {
		this.mensajes.add(new Mensaje(mensaje));
		this.notificar(Eventos.NUEVO_MENSAJE);
	}
	
	private void notificar(Eventos evento) {
		this.setChanged();
		this.notifyObservers(evento);
	}
	
	public void cerrar(int usuarioId) {
		this.desconectarUsuario(usuarioId);
	}
}
