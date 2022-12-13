package vista;

import java.awt.GridLayout;

import javax.swing.JFrame;

import controlador.Controlador;

public class VentanaPrincipal extends JFrame
{

	private PanelOperaciones panelOperaciones;

	private Controlador controlador;

	public VentanaPrincipal(Controlador controlador)
	{
		setTitle("Proyecto final");
		setSize(760, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridLayout(1,1));

		panelOperaciones = new PanelOperaciones(controlador);
		
		add(panelOperaciones);

		setVisible(true);
	}

	public PanelOperaciones getPanelAcciones() 
	{
		return panelOperaciones;
	}

	public void setPanelAcciones(PanelOperaciones panelAcciones) 
	{
		this.panelOperaciones = panelAcciones;
	}
}
