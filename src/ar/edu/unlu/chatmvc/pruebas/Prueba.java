package ar.edu.unlu.chatmvc.pruebas;

import ar.edu.unlu.chatmvc.controlador.Controlador;
import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.vista.IVista;
import ar.edu.unlu.chatmvc.vista.grafica.VistaGrafica;

public class Prueba {

	public static void main(String[] args) {
		Chat modelo = new Chat();
		Controlador controlador1 = new Controlador(modelo);
		IVista vista1 = new VistaGrafica(controlador1);
		vista1.iniciar();
		
		Controlador controlador2 = new Controlador(modelo);
		IVista vista2 = new VistaGrafica(controlador2);
		vista2.iniciar();
	}

}
