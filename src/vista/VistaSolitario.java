package vista;

import java.awt.Color;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;

public class VistaSolitario extends JFrame
{

	private TextArea triangulo;

	private JButton btnTriangulo;

	private JLabel labPosiciones;

	private JLabel labInicioA;
	private JLabel labInicioB;
	private JTextField txtInicioA;
	private JTextField txtInicioB;

	public VistaSolitario(Controlador controlador)
	{

		setTitle("Solitario");
		setSize(700, 680);
		setResizable(false);
		setLocationRelativeTo(null);

		this.getContentPane().setBackground(new Color(132,174,64));
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		String path = "./piramide.png";  
		ImageIcon icon = new ImageIcon(path);
		labPosiciones = new JLabel();
		labPosiciones.setIcon(icon);

		labInicioA = new JLabel("Fila de inicio");
		labInicioB = new JLabel("Columna de inicio");

		txtInicioA = new JTextField();
		txtInicioB = new JTextField();

		triangulo = new TextArea();
		
		btnTriangulo = new JButton("Resolver solitario");
		btnTriangulo.setActionCommand("Resolver solitario");
		btnTriangulo.addActionListener(controlador);

		add(triangulo);
		add(labPosiciones);
		add(labInicioA);
		add(labInicioB);
		add(txtInicioA);
		add(txtInicioB);
		add(btnTriangulo);
		
		layout.putConstraint(SpringLayout.WEST, triangulo, 30, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, triangulo, 340, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, triangulo, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, triangulo, 620, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labPosiciones, 410, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labPosiciones, 630, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labPosiciones, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labPosiciones, 220, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labInicioA, 380, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labInicioA, 530, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labInicioA, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labInicioA, 320, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, txtInicioA, 510, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtInicioA, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtInicioA, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtInicioA, 320, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, labInicioB, 380, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, labInicioB, 530, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labInicioB, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, labInicioB, 380, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, txtInicioB, 510, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, txtInicioB, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txtInicioB, 340, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, txtInicioB, 380, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnTriangulo, 410, SpringLayout.WEST, this);		
		layout.putConstraint(SpringLayout.EAST, btnTriangulo, 610, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnTriangulo, 460, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, btnTriangulo, 500, SpringLayout.NORTH, this);
	}

	public TextArea getTriangulo() {
		return triangulo;
	}

	public void setTriangulo(TextArea triangulo) {
		this.triangulo = triangulo;
	}

	public JTextField getTxtInicioA() {
		return txtInicioA;
	}

	public void setTxtInicioA(JTextField txtInicioA) {
		this.txtInicioA = txtInicioA;
	}

	public JTextField getTxtInicioB() {
		return txtInicioB;
	}

	public void setTxtInicioB(JTextField txtInicioB) {
		this.txtInicioB = txtInicioB;
	}
}
