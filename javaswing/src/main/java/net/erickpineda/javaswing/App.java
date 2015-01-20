package net.erickpineda.javaswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 546, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();

		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][][grow][][][][]", "[][]"));

		JLabel lblTotal = new JLabel("Total");
		panel.add(lblTotal, "cell 2 1,alignx right");

		textField_2 = new JTextField();
		panel.add(textField_2, "cell 3 1,alignx left");
		textField_2.setColumns(10);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

		textField = new JTextField();
		layeredPane.add(textField, "cell 2 3 8 1,growx");
		textField.setColumns(10);

		JLabel lblNumero = new JLabel("Número");
		layeredPane.add(lblNumero, "cell 0 5");

		textField_1 = new JTextField();
		layeredPane.add(textField_1, "cell 2 5,growx");
		textField_1.setColumns(10);

		JButton btnNuevaDireccion = new JButton("Agregar");
		btnNuevaDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Pilla el valor del input (getText()) y lo envio al fichero
				// creado.
			}
		});
		layeredPane.add(btnNuevaDireccion, "cell 4 5,alignx center");

		JButton btnAnterior = new JButton("Anterior");
		layeredPane.add(btnAnterior, "cell 8 5,alignx right");

		JButton btnSiguiente = new JButton("Siguiente");
		layeredPane.add(btnSiguiente, "cell 9 5,alignx right");
		contentPane.add(layeredPane);
		contentPane.add(panel);
		setResizable(false);
	}
}
