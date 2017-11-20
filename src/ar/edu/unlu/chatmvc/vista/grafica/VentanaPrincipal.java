package ar.edu.unlu.chatmvc.vista.grafica;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textMensaje;
	private JButton btnEnviar;
	private JTextPane textChat;
	private JList listUsuarios;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][50px][::80px]", "[grow][]"));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 0 0,grow");
		
		textChat = new JTextPane();
		textChat.setEditable(false);
		scrollPane_1.setViewportView(textChat);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 0 2 1,grow");
		
		listUsuarios = new JList();
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listUsuarios);
		
		textMensaje = new JTextField();
		contentPane.add(textMensaje, "cell 0 1 2 1,growx");
		textMensaje.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		contentPane.add(btnEnviar, "cell 2 1,growx");
		
		SwingUtilities.getRootPane(btnEnviar).setDefaultButton(btnEnviar);
		addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		    	textMensaje.requestFocusInWindow();
		    }
		}); 
	}
	
	public void onClickEnviar(ActionListener listener) {
		this.btnEnviar.addActionListener(listener);
	}
	
	public void actualizarChat(IMensaje[] mensajes) {
		String texto = "";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY  HH:MM ");
		for (IMensaje m: mensajes) {
			if (m.isMensajeDelSistema()) {
				texto += m.getFecha().format(format)+" AVISO: "+m.getTexto()+"\r\n";
			} else {
				texto += m.getFecha().format(format)+" "+m.getUsuario().getNombre()+": "+m.getTexto()+"\r\n";
			}
		}
		this.textChat.setText(texto);
	}
	
	public void actualizarListaUsuarios(IUsuario[] usuarios) {
		this.listUsuarios.setModel(new AbstractListModel() {
			@Override
			public Object getElementAt(int arg0) {
				return usuarios[arg0].getNombre();
			}
			@Override
			public int getSize() {
				return usuarios.length;
			}
		});
	}
	
	public String getTextoMensaje() {
		return this.textMensaje.getText();
	}

	public void setTextoMensaje(String texto) {
		this.textMensaje.setText(texto);
	}
}
