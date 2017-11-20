package ar.edu.unlu.chatmvc.modelo;

public class Usuario implements IUsuario {
	private static int ID = 0;
	private String nombre;
	private int id;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.id = Usuario.ID++;
	}
	
	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IUsuario#getNombre()
	 */
	@Override
	public String getNombre() {
		return this.nombre;
	}

	/* (non-Javadoc)
	 * @see ar.edu.unlu.chatmvc.modelo.IUsuario#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
}
