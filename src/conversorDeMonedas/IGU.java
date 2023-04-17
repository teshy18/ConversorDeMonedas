package conversorDeMonedas;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import javax.swing.SwingConstants;

import javax.swing.JOptionPane;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;


public class IGU extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField cantidadInicial;
	private JTextField resultado;



	private int ejeX , ejeY; 
	/**
	 * Create the frame.
	 */
	public IGU() {
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel background = new JPanel();
		background.setBackground(Color.LIGHT_GRAY);
		background.setBounds(0, 0, 672, 330);
		contentPane.add(background);
		background.setLayout(null);


		JPanel header = new JPanel();

		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x  = e.getXOnScreen();
				int y = e.getYOnScreen();

				setLocation( x - ejeX , y - ejeY );

			}


		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				ejeX = e.getX();
				ejeY = e.getY();

			}
		});
		header.setBorder(null);
		header.setBackground(new Color(21, 21, 21));
		header.setBounds(0, 0, 672, 73);
		background.add(header);
		header.setLayout(null);

		JLabel lblNewLabel = new JLabel("Conversor de Monedas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 423, 43);
		header.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(0, 0, 600, 54);
		header.add(panel_2);
		panel_2.setLayout(null);

		JPanel exitButton = new JPanel();
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBackground(new Color(255,65,65));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(Color.red);
			}
		});
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButton.setBackground(Color.RED);
		exitButton.setBounds(560, 11, 30, 32);
		panel_2.add(exitButton);

		JLabel exitButtonLabel = new JLabel("X");
		exitButtonLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitButtonLabel.setBackground(Color.RED);
		exitButtonLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		exitButtonLabel.setForeground(Color.WHITE);
		exitButton.add(exitButtonLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(IGU.class.getResource("/conversorDeMonedas/Images/img3.jpg")));
		lblNewLabel_1.setBounds(0, 72, 176, 258);
		background.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(176, 72, 423, 258);
		background.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Moneda deseada:  ");
		lblNewLabel_3.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(0, 128, 64));
		lblNewLabel_3.setBounds(10, 108, 142, 19);
		panel.add(lblNewLabel_3);

		JComboBox monedaInicial = new JComboBox();
		monedaInicial.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		monedaInicial.setModel(new DefaultComboBoxModel(new String[] {"Pesos Argentinos", "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won Surcoreano"}));
		monedaInicial.setBounds(162, 34, 220, 19);
		panel.add(monedaInicial);

		JComboBox monedaFinal = new JComboBox();
		monedaFinal.setModel(new DefaultComboBoxModel(new String[] {"Pesos Argentinos", "Dólar", "Euro", "Libras Esterlinas", "Yen Japonés", "Won Surcoreano"}));
		monedaFinal.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		monedaFinal.setBounds(162, 109, 220, 19);
		panel.add(monedaFinal);

		cantidadInicial = new JTextField();
		cantidadInicial.setText("1");
		cantidadInicial.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {

				validateInput();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validateInput();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validateInput();
			}

			private void validateInput() {
				String input = cantidadInicial.getText();

				if (input != "") {

					try {
						Double.parseDouble(input);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Solo se permiten valores numéricos y  un punto (.) para indicar los decimales", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		});

		cantidadInicial.setBounds(66, 228, 220, 19);
		panel.add(cantidadInicial);
		cantidadInicial.setColumns(10);

		resultado = new JTextField();
		resultado.setBounds(162, 139, 220, 19);
		panel.add(resultado);
		resultado.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Moneda deseada:  ");
		lblNewLabel_3_1.setForeground(new Color(0, 128, 64));
		lblNewLabel_3_1.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 33, 142, 19);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Cantidad:   ");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_2.setForeground(new Color(0, 128, 64));
		lblNewLabel_3_2.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(10, 64, 142, 19);
		panel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Resultado:   ");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_3.setForeground(new Color(0, 128, 64));
		lblNewLabel_3_3.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(10, 138, 142, 19);
		panel.add(lblNewLabel_3_3);

		JPanel convertirBtn = new JPanel();
		convertirBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		convertirBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				convertirBtn.setBackground(new Color(0, 148, 74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				convertirBtn.setBackground(new Color(0, 128, 64));
			}
			@Override
			public void mouseClicked(MouseEvent e) {



				double cantidadX = 1;

				if (cantidadInicial.getText()!= "") {
					cantidadX = Double.parseDouble(cantidadInicial.getText());					
				}

				String MI = (String) monedaInicial.getSelectedItem();
				String MF = (String) monedaFinal.getSelectedItem();

				Calculadora calculadora = new Calculadora();

				System.out.println( cantidadX + " " + MI + "a " + MF + "es ");


			}
		});
		convertirBtn.setBackground(new Color(0, 128, 64));
		convertirBtn.setBounds(162, 188, 220, 27);
		panel.add(convertirBtn);
		convertirBtn.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Convertir");
		lblNewLabel_2.setBounds(67, 0, 83, 27);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		convertirBtn.add(lblNewLabel_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1.0, 0.0, 2.147483647E9, 10.0));
		spinner.setBounds(162, 64, 220, 19);
		panel.add(spinner);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 94, 326, 3);
		panel.add(separator);
	}
}
