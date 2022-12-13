package vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class VistaVarilla extends JFrame
{

	private JButton ingresarDinero;
	private JButton calcularCorte;
	
	private JTable tblMatriz1; 
	
	private DefaultTableModel modelo1;
	
	SpringLayout layout;
	
	public VistaVarilla(Controlador controlador)
	{
		
		setSize(800, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		layout = new SpringLayout();
		setLayout(layout);
		
		ingresarDinero = new JButton("Ingresar precios de los cortes");
		ingresarDinero.setActionCommand("Ingresar precios de los cortes");
		ingresarDinero.addActionListener(controlador);
		
		this.getContentPane().setBackground(new Color(132,174,64));
		
		calcularCorte = new JButton("Calcular beneficio de corte");
		calcularCorte.setActionCommand("Calcular beneficio de corte");
		calcularCorte.addActionListener(controlador);
		calcularCorte.setEnabled(false);
		
		add(ingresarDinero);
		add(calcularCorte);
		
		layout.putConstraint(SpringLayout.WEST, ingresarDinero, 250, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, ingresarDinero, 550, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ingresarDinero, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, ingresarDinero, 70, SpringLayout.NORTH, this);
		
//		crearTabla();
		
		layout.putConstraint(SpringLayout.WEST, calcularCorte, 300, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, calcularCorte, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, calcularCorte, 410, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, calcularCorte, 450, SpringLayout.NORTH, this);
	}
	
	public void crearTabla(int filas, int columnas)
	{
		
		modelo1 = new DefaultTableModel(filas, columnas);	 
		
		tblMatriz1 = new JTable(modelo1);

		add(tblMatriz1);
		
		layout.putConstraint(SpringLayout.WEST, tblMatriz1, 230, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, tblMatriz1, 570, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, tblMatriz1, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, tblMatriz1, 360, SpringLayout.NORTH, this);
	}

	public JButton getIngresarDinero() {
		return ingresarDinero;
	}

	public void setIngresarDinero(JButton ingresarDinero) {
		this.ingresarDinero = ingresarDinero;
	}

	public JButton getCalcularCorte() {
		return calcularCorte;
	}

	public void setCalcularCorte(JButton calcularCorte) {
		this.calcularCorte = calcularCorte;
	}

	public JTable getTblMatriz1() {
		return tblMatriz1;
	}

	public void setTblMatriz1(JTable tblMatriz1) {
		this.tblMatriz1 = tblMatriz1;
	}

	public DefaultTableModel getModelo1() {
		return modelo1;
	}

	public void setModelo1(DefaultTableModel modelo1) {
		this.modelo1 = modelo1;
	}
}
