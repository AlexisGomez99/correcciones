package ar.edu.unrn.ui;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.unrn.modelo.Combustible;
import ar.edu.unrn.modelo.PersistenciaApi;

import ar.edu.unrn.modelo.Venta;
import ar.edu.unrn.modeloexceptions.DataEmptyException;
import ar.edu.unrn.modeloexceptions.NotNullException;
import ar.edu.unrn.modeloexceptions.NotNumbreException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PantallaCargarCombustible extends JFrame {

	private JPanel contentPane;
	private JTextField textCantidadLitros;
	private JComboBox comboBox;
	private float total=0;
	private JButton btnCargar;
	private JLabel lblLitros;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public PantallaCargarCombustible(PersistenciaApi api) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLitros = new JLabel("Litros:");
		lblLitros.setBounds(10, 38, 46, 14);
		contentPane.add(lblLitros);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 227, 147, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCalcular = new JButton("Calcular total");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Combustible combustible_api = new Combustible(comboBox.getSelectedItem().toString());
					Venta venta= new Venta(combustible_api,textCantidadLitros.getText(),total, LocalDate.now());
					venta.calcularTotal();
					String resumenEnDisco= ""+venta.fecha().toString()+"|"+venta.combustible().tipoCombustible()+"|"+venta.cantidadDeLitros()+"| $"+venta.total()+"\n";
					api.registrarResumen(resumenEnDisco);
					JOptionPane.showMessageDialog(null,"El total de su compra es: $"+venta.total()+", se le realizara un descuento del: %"+ venta.descuento());
				} catch (RuntimeException | NotNullException | DataEmptyException | NotNumbreException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCalcular.setBounds(10, 195, 147, 23);
		contentPane.add(btnCalcular);
		
		textCantidadLitros = new JTextField();
		textCantidadLitros.setBounds(10, 65, 232, 20);
		contentPane.add(textCantidadLitros);
		textCantidadLitros.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 133, 232, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Comun");
		comboBox.addItem("Super");
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					api.agregarVenta(comboBox.getSelectedItem().toString(), textCantidadLitros.getText(), 0, LocalDate.now());
					JOptionPane.showMessageDialog(null,"Se registro una venta.");
				} catch (RuntimeException | DataEmptyException | NotNumbreException | NotNullException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargar.setBounds(298, 227, 136, 23);
		contentPane.add(btnCargar);
		
	
		
		
		
	}
}
