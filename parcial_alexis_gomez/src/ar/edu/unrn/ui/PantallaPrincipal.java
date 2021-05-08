package ar.edu.unrn.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unrn.modelo.PersistenciaApi;

import ar.edu.unrn.persistencia.EnDiscoRegistrarVenta;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;

	public PantallaPrincipal(PersistenciaApi api) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarCombustible = new JButton("Cargar Combustible");
		btnCargarCombustible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCargarCombustible cargarCombustible= new PantallaCargarCombustible(api);
				cargarCombustible.setVisible(true);
				
			}
		});
		btnCargarCombustible.setBounds(104, 97, 230, 23);
		contentPane.add(btnCargarCombustible);
		
		JButton btnHistorialVentas = new JButton("Historial Ventas");
		btnHistorialVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaHistorialVentas ventas= new PantallaHistorialVentas(api);
				ventas.setVisible(true);
			}
		});
		btnHistorialVentas.setBounds(104, 146, 230, 23);
		contentPane.add(btnHistorialVentas);
		
		
		
		
	}
}
