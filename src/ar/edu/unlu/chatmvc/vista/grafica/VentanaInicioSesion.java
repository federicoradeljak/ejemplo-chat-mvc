package ar.edu.unlu.chatmvc.vista.grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JButton btnIniciar;

	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 109);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		JLabel lblUsuario = new JLabel("Usuario");
		contentPane.add(lblUsuario, "cell 0 0,alignx trailing");
		
		textUsuario = new JTextField();
		contentPane.add(textUsuario, "cell 1 0,growx");
		textUsuario.setColumns(10);
		
		btnIniciar = new JButton("Iniciar");
		contentPane.add(btnIniciar, "cell 1 1,alignx right");
		
		SwingUtilities.getRootPane(btnIniciar).setDefaultButton(btnIniciar);
	}
	
	public void onClickIniciar(ActionListener listener) {
		this.btnIniciar.addActionListener(listener);
	}
	
	public String getGetNombreUsuario() {
		return this.textUsuario.getText();
	}
}
