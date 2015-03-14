package net.erickpineda.javaswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDireccion;
	private List<String> listaURL;
	private JLabel textLabelNumero;
	private JLabel textLabelTotal;
	private int indice = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setType(Type.UTILITY);
		setTitle("Sistema de entrada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 546, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();

		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][][grow][][][][]", "[][]"));

		JLabel lblTotal = new JLabel("Total");
		panel.add(lblTotal, "cell 2 1,alignx right");

		textLabelTotal = new JLabel();
		textLabelTotal.setText(totalDirecciones());

		// Crea una lista de String con las URL's del fichero
		listaURL = (List<String>) Accion.getLista();

		panel.add(textLabelTotal, "cell 3 1 2 1,alignx center");

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btnSalir, "cell 6 1");
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		layeredPane.setLayout(new MigLayout("",
				"[43px][][grow][][][][][][][grow]", "[14px][][][][][]"));

		JLabel lblEscribirURL = new JLabel("Escribe una URL");
		layeredPane.add(lblEscribirURL, "cell 4 1");

		JLabel lblDireccion = new JLabel("Dirección");
		layeredPane.add(lblDireccion, "cell 0 3,alignx left,aligny top");

		textFieldDireccion = new JTextField();
		layeredPane.add(textFieldDireccion, "cell 2 3 8 1,growx");
		textFieldDireccion.setColumns(10);
		// textFieldDireccion.setText(listaURL.get(indice));

		JLabel lblNumero = new JLabel("Posición");
		layeredPane.add(lblNumero, "cell 0 5");

		textLabelNumero = new JLabel();
		textLabelNumero.setText("0");
		layeredPane.add(textLabelNumero, "cell 2 5,growx");

		JButton btnNuevaDireccion = new JButton("Agregar");
		btnNuevaDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarURL();
				textLabelTotal.setText(totalDirecciones());
			}
		});
		layeredPane.add(btnNuevaDireccion, "cell 4 5,alignx center");

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonAnterior();
				textLabelNumero.setText(Integer.toString(indice));

				if (listaURL.size() > 0) {
					textFieldDireccion.setText(listaURL.get(indice));
				}
			}
		});
		layeredPane.add(btnAnterior, "cell 8 5,alignx right");

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botonSiguiente();
				textLabelNumero.setText(Integer.toString(indice));

				if (listaURL.size() > 0) {
					textFieldDireccion.setText(listaURL.get(indice));
				}
			}
		});
		layeredPane.add(btnSiguiente, "cell 9 5,alignx right");

		contentPane.add(layeredPane);
		contentPane.add(panel);
		setResizable(false);
	}

	/**
	 * Método que agrega las URL al fichero cuando se hace click en el boton
	 * agregar.
	 */
	public void agregarURL() {

		if (textFieldDireccion.getText().length() > 0) {

			if (Accion.comprobarURL(textFieldDireccion.getText()) == true) {
				Accion.escribirFichero(textFieldDireccion.getText());

				JOptionPane.showMessageDialog(null,
						textFieldDireccion.getText(), "URL Correcto",
						JOptionPane.PLAIN_MESSAGE);

				textFieldDireccion.setText("http://");

			} else {
				JOptionPane.showMessageDialog(null,
						textFieldDireccion.getText(), "URL Incorrecta",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Escribe una URL", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 * @return Retorna la cantidad de URL en el fichero, convertido a String.
	 */
	public String totalDirecciones() {
		return Integer.toString(Accion.totalLineas());
	}

	/**
	 * 
	 */
	public void botonSiguiente() {
		if (indice < listaURL.size() - 1) {
			++indice;
		}
	}

	public void botonAnterior() {
		if (indice > 0) {
			indice--;
		}
	}
}
