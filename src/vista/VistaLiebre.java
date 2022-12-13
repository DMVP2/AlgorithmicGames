package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controlador.Controlador;

public class VistaLiebre extends JFrame
{

		private JButton [][] matrizBotones;
		
		int M = 0;
		int N = 0;
		
		private JPanel panelTablero;
		
		private JLabel labInicioA;
		private JLabel labInicioB;
		private JLabel labFinalA;
		private JLabel labFinalB;
			
		private JTextField txtInicioA;
		private JTextField txtInicioB;
		private JTextField txtFinalA;
		private JTextField txtFinalB;
		
		private JButton btnDezplazamiento;
		private JButton btnEjecutarLiebre;

		public VistaLiebre(Controlador controlador)
		{
			
			ingresarTablero();
			setTitle("Movimiento de la liebre");
			setSize(1000, 680);
			setResizable(false);
			setLocationRelativeTo(null);
			
			this.getContentPane().setBackground(new Color(132,174,64));
			
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			
			panelTablero = new JPanel();
			panelTablero.setLayout(new GridLayout(M,N));
			
			matrizBotones = new JButton [M][N];
			inicializarBotones(controlador);
			cargarGrilla();
			inhabilitarTablero();
			
			labInicioA = new JLabel("Fila de inicio");
			labInicioB = new JLabel("Columna de inicio");
			labFinalA = new JLabel("Fila de llegada");
			labFinalB = new JLabel("Columna de llegada");
			
			txtInicioA = new JTextField();
			txtInicioB = new JTextField();
			txtFinalA = new JTextField();
			txtFinalB = new JTextField();
			
			btnDezplazamiento = new JButton("Ingresar movimientos");
			btnDezplazamiento.setActionCommand("Ingresar movimientos");
			btnDezplazamiento.addActionListener(controlador);
			
			btnEjecutarLiebre = new JButton("Ejecutar liebre");
			btnEjecutarLiebre.setActionCommand("Ejecutar liebre");
			btnEjecutarLiebre.addActionListener(controlador);
			btnEjecutarLiebre.setEnabled(false);
			
			
			add(panelTablero);
			add(labInicioA);
			add(labInicioB);
			add(labFinalA);
			add(labFinalB);
			add(txtInicioA);
			add(txtInicioB);
			add(txtFinalA);
			add(txtFinalB);
			add(btnDezplazamiento);
			add(btnEjecutarLiebre);
			
			layout.putConstraint(SpringLayout.WEST, panelTablero, 30, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, panelTablero, 630, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, panelTablero, 20, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, panelTablero, 620, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, labInicioA, 650, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, labInicioA, 790, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, labInicioA, 70, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, labInicioA, 110, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, txtInicioA, 790, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, txtInicioA, 970, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, txtInicioA, 70, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, txtInicioA, 110, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, labInicioB, 650, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, labInicioB, 790, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, labInicioB, 130, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, labInicioB, 170, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, txtInicioB, 790, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, txtInicioB, 970, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, txtInicioB, 130, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, txtInicioB, 170, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, labFinalA, 650, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, labFinalA, 790, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, labFinalA, 250, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, labFinalA, 290, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, txtFinalA, 790, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, txtFinalA, 970, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, txtFinalA, 250, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, txtFinalA, 290, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, labFinalB, 650, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, labFinalB, 790, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, labFinalB, 310, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, labFinalB, 350, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, txtFinalB, 790, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, txtFinalB, 970, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, txtFinalB, 310, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, txtFinalB, 350, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, btnDezplazamiento, 730, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, btnDezplazamiento, 910, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, btnDezplazamiento, 420, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, btnDezplazamiento, 460, SpringLayout.NORTH, this);
			
			layout.putConstraint(SpringLayout.WEST, btnEjecutarLiebre, 730, SpringLayout.WEST, this);		
			layout.putConstraint(SpringLayout.EAST, btnEjecutarLiebre, 910, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, btnEjecutarLiebre, 500, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, btnEjecutarLiebre, 540, SpringLayout.NORTH, this);
			
			setVisible(true);
			
		}
		
		public void ingresarTablero()
		{
			
			M = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas del tablero"));
			N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas del tablero"));
			
		}

		public void inicializarBotones(Controlador controlador)
		{

			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrizBotones[i][j] = new JButton(i + "," + j);
					matrizBotones[i][j].setBackground(new Color(15,214,253));
				}
			}
		}
		
		public void inhabilitarTablero()
		{

			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					matrizBotones [i][j].setEnabled(false);
				}
			}
		}
		
		public void cargarGrilla()
		{

			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					panelTablero.add(matrizBotones[i][j]);
				}
			}

			validate();
		}

		public JButton[][] getMatrizBotones() {
			return matrizBotones;
		}

		public void setMatrizBotones(JButton[][] matrizBotones) {
			this.matrizBotones = matrizBotones;
		}

		public int getM() {
			return M;
		}

		public void setM(int m) {
			M = m;
		}

		public int getN() {
			return N;
		}

		public void setN(int n) {
			N = n;
		}

		public JPanel getPanelTablero() {
			return panelTablero;
		}

		public void setPanelTablero(JPanel panelTablero) {
			this.panelTablero = panelTablero;
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

		public JTextField getTxtFinalA() {
			return txtFinalA;
		}

		public void setTxtFinalA(JTextField txtFinalA) {
			this.txtFinalA = txtFinalA;
		}

		public JTextField getTxtFinalB() {
			return txtFinalB;
		}

		public void setTxtFinalB(JTextField txtFinalB) {
			this.txtFinalB = txtFinalB;
		}

		public JButton getBtnDezplazamiento() {
			return btnDezplazamiento;
		}

		public void setBtnDezplazamiento(JButton btnDezplazamiento) {
			this.btnDezplazamiento = btnDezplazamiento;
		}

		public JButton getBtnEjecutarLiebre() {
			return btnEjecutarLiebre;
		}

		public void setBtnEjecutarLiebre(JButton btnEjecutarLiebre) {
			this.btnEjecutarLiebre = btnEjecutarLiebre;
		}
		
//		public void actualizarPanel(Casilla [][] matriz)
//		{
//			for(int i = 0; i < Triqui.FILAS; i++)
//			{
//				for(int j = 0; j < Triqui.COLUMNAS; j++)
//				{
//					if(matriz [i][j].darTipo() == Casilla.JUGADOR_1)
//					{
//						matrizBotones [i][j].setBackground(new Color(71,253,15));
//					}
//
//					else if(matriz [i][j].darTipo() == Casilla.JUGADOR_2)
//					{
//						matrizBotones [i][j].setBackground(new Color(15,214,253));
//					}
//
//					else
//					{
//						matrizBotones [i][j].setBackground(Color.WHITE);
//					}
//				}
//			}
//		}

}
