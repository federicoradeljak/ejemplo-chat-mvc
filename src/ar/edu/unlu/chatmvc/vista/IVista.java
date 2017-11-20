package ar.edu.unlu.chatmvc.vista;

import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;

public interface IVista {
	public void mostrarListaUsuarios(IUsuario[] usuarios);
	public void mostrarChat(IMensaje[] mensajes);
	public void iniciar();
}
