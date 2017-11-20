package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;

public interface IMensaje {

	LocalDateTime getFecha();

	IUsuario getUsuario();

	String getTexto();

	boolean isMensajeDelSistema();

}