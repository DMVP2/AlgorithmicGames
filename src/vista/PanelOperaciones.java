package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;

public class PanelOperaciones extends JPanel
{

	private JLabel labUniversidad;
	private JLabel labPrograma;
	private JLabel labCurso;
	private JLabel labSebastian;
	private JLabel labDavid;
	private JLabel labMauricio;
	private JLabel labImagen;
	
	private JButton btnSolitario;
	private JButton btnLiebre;
	private JButton btnVarilla;
	
	private Controlador controlador;
	
	public PanelOperaciones(Controlador controlador)
	{
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		this.setBackground(new Color(132,174,64));
		Font font = new Font("Courier", Font.BOLD,14);
		
		labUniversidad = new JLabel("Universidad el Bosque");
		labUniversidad.setFont(font);
		labPrograma = new JLabel("Ingeniería de Sistemas");
		labPrograma.setFont(font);
		labCurso = new JLabel("Complejidad algorítmica");
		labCurso.setFont(font);
		labSebastian = new JLabel("Juan Sebastián Rodríguez Obregón");
		labSebastian.setFont(font);
		labMauricio = new JLabel("David Mauricio Valoyes Porras");
		labMauricio.setFont(font);
		labDavid = new JLabel("David Steven Salamanca Sanchez");
		labDavid.setFont(font);
		
		
		String path = "./ubosque.png";  
		ImageIcon icon = new ImageIcon(path);
		labImagen = new JLabel();
		labImagen.setIcon(icon);
		
		btnSolitario = new JButton("Juego de solitario");
		btnSolitario.setActionCommand("Juego de solitario");
		btnSolitario.addActionListener(controlador);
		
		btnLiebre = new JButton("Movimiento de la liebre");
		btnLiebre.setActionCommand("Movimiento de la liebre");
		btnLiebre.addActionListener(controlador);
		
		btnVarilla = new JButton("Corte de la varilla");
		btnVarilla.setActionCommand("Corte de la varilla");
		btnVarilla.addActionListener(controlador);
		
		add(labImagen);
		add(labUniversidad);
		add(labPrograma);
		add(labCurso);
		add(labSebastian);
		add(labMauricio);
		add(labDavid);
		add(btnSolitario);
		add(btnLiebre);
		add(btnVarilla);
		
		layout.putConstraint(SpringLayout.WEST, labImagen, 0, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labImagen, 350, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labImagen, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labImagen, 240, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labUniversidad, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labUniversidad, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labUniversidad, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labUniversidad, 290, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labPrograma, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labPrograma, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labPrograma, 300, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labPrograma, 320, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labCurso, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labCurso, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labCurso, 330, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labCurso, 350, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labSebastian, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labSebastian, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labSebastian, 430, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labSebastian, 450, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labMauricio, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labMauricio, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labMauricio, 460, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labMauricio, 480, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labDavid, 50, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labDavid, 400, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labDavid, 490, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labDavid, 510, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnSolitario, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnSolitario, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnSolitario, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnSolitario, 250, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnLiebre, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnLiebre, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnLiebre, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnLiebre, 320, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnVarilla, 430, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnVarilla, 670, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnVarilla, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnVarilla, 390, SpringLayout.NORTH, this);

	}

	public Controlador getControlador() 
	{
		return controlador;
	}

	public void setControlador(Controlador controlador) 
	{
		this.controlador = controlador;
	}
}