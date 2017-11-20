package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;

public class Mensaje implements IMensaje {
	private LocalDateTime fecha;
	private IUsuario usuario;
	private String texto;
	
	public Mensaje(String texto, IUsuario usuario) {
		super();
		this.fecha = LocalDateTime.now();
		this.usuario = usuario;
		this.texto = texto;
	}
	public Mensaje(String texto) {
		this(texto, null);
	}
	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IMensaje#getFecha()
	 */
	@Override
	public LocalDateTime getFecha() {
		return fecha;
	}
	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IMensaje#getUsuario()
	 */
	@Override
	public IUsuario getUsuario() {
		return usuario;
	}
	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IMensaje#getTexto()
	 */
	@Override
	public String getTexto() {
		return texto;
	}
	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IMensaje#isMensajeDelSistema()
	 */
	@Override
	public boolean isMensajeDelSistema() {
		return this.usuario == null;
	}
}
