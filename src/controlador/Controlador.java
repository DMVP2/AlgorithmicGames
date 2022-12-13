package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import modelo.Liebre;
import modelo.SolitarioTriangular;
import modelo.Varilla;
import vista.VentanaPrincipal;
import vista.VistaLiebre;
import vista.VistaSolitario;
import vista.VistaVarilla;

public class Controlador implements ActionListener
{

	private VentanaPrincipal vista;
	private VistaLiebre liebre;
	private VistaSolitario solitario;
	private VistaVarilla varilla;
	
	private Liebre modeloLiebre;
	private SolitarioTriangular modeloSolitario;
	private Varilla modeloVarilla;
	
	int A = 0;
	int B = 0;
	
	int M = 0;
	int N = 0;
	
	int N1 = 0;
	int N2 = 0;
	
	int tamañoVarilla;
	
	/**
	 * Metodo contructor del controlador
	 * Inicializa la interfaz grafica
	 */
	public Controlador()
	{
//		try 
//		{
//			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
//			{
//				if ("Nimbus".equals(info.getName()))
//				{
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (Exception exception) 
//		{
//			
//		}
		vista = new VentanaPrincipal(this);
	}
	
	/**
	 * Recibe el movimiento vertical y el movimiento horizontal de la liebre
	 */
	public void ingresarMovimientos()
	{
		
		A = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de casillas de desplazamiento vertical"));
		B = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de casillas de desplazamiento horizontal"));
		
		liebre.getBtnEjecutarLiebre().setEnabled(true);
	}
	
	/**
	 * Busca todos los posibles caminos que se tienen del punto A al punto B mediante "Backtracking", es decir genera todas las "Ramas"
	 */
	public void liebre()
	{
		int inicioA = Integer.parseInt(liebre.getTxtInicioA().getText());
		int inicioB = Integer.parseInt(liebre.getTxtInicioB().getText());
		int finalA = Integer.parseInt(liebre.getTxtFinalA().getText());
		int finalB = Integer.parseInt(liebre.getTxtFinalB().getText());
		
		M = liebre.getM();
		N = liebre.getN();

		modeloLiebre = new Liebre(M, N, inicioA, inicioB, finalA, finalB);
		
		modeloLiebre.generarMovimientos(A, B);
		
		modeloLiebre.ejecutar();
	}
	
	/**
	 * Muestra la ruta mas optima del punto A al punto B aplicando la parte de "Podar" en la tecnica de "Rama y poda"
	 */
	public void mostrarRuta()	
	{
		
		int [][] mejorRuta = modeloLiebre.getMejor();
		
		for (int i = 0; i < M; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				liebre.getMatrizBotones()[i][j].setText(Integer.toString(mejorRuta[i][j]));
				if(mejorRuta[i][j] != 0)
				{
					liebre.getMatrizBotones()[i][j].setBackground(new Color(71,253,15));
				}
				if(mejorRuta[i][j] == 0)
				{
					liebre.getMatrizBotones()[i][j].setBackground(new Color(15,214,253));
				}
			}
		}
	}
	
	/**
	 * Recibe el punto de inicio para el solitario triangular
	 */
	public void datosSolitario()
	{
		N1 = Integer.parseInt(solitario.getTxtInicioA().getText());
		N2 = Integer.parseInt(solitario.getTxtInicioB().getText());
	}
	
	/**
	 * Resuelve el solitario triangular teniendo como punto de inicio el punto indicado
	 */
	public void resolverTrinagulito()
	{
		String solucionSolitario = modeloSolitario.getSolucion();
		solitario.getTriangulo().setText(solucionSolitario);
	}
	
	/**
	 * Metodo que recibe los precios de cada corte de la varilla y los organiza en la matriz correspondiente en la interfaz grafica
	 */
	public void ingresarPrecios()
	{

		String varillas[][];
		
		tamañoVarilla = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la varilla"));

		varilla.crearTabla(0, 2);

		varillas = new String[tamañoVarilla][2];

		Object [] object = new Object [2];

		object [0] = "Tamaño de corte";
		object [1] = "Precio del corte";

		varilla.getModelo1().addRow(object);

		for (int i = 0; i < varillas.length; i++) 
		{

			String nombreCorte = "Tamaño " + (i + 1);
			String valorCorte = JOptionPane.showInputDialog("Ingrese el precio del corte " + "\"" + nombreCorte + "\"");

			varillas [i][0] = nombreCorte;
			varillas [i][1] = valorCorte;

			object [0] = varillas[i][0];
			object [1] = varillas[i][1];

			varilla.getModelo1().addRow(object);
		}

		varilla.getCalcularCorte().setEnabled(true);
	}
	
	/**
	 * 
	 * @param i (Tamaño de la varrilla)
	 * @param tblMatriz (Matriz donde se ingresa y visualizan los precios de los diferentes tamaños de la varilla)
	 * @return (Arreglo con los precios segun el tamaño de corte)
	 */
	public int [] leerPrecios(int i, JTable tblMatriz)
	{

		int [] a = new int [i];

		for (int k = 0; k < i; k++) 
		{
			a [k] = Integer.parseInt((tblMatriz.getValueAt(k + 1, 1)).toString());
		}


		return a;
	}
	
    /**
     * Calcula el corte de la varilla y el mayor beneficio de este
     */
    public void calcularCorte()
    { 
    	modeloVarilla = new Varilla();
        int arr[] = leerPrecios(tamañoVarilla, varilla.getTblMatriz1()) ;
        int size = arr.length; 
        int solucion = modeloVarilla.cutRod(arr, size); 
        JOptionPane.showMessageDialog(null, "El mayor beneficio que se puede obtener de la varilla es: " + solucion);
    } 

    /**
     * Metodo que ejecuta las acciones del usuario por medio de la recepcion de los eventos realizados en la interfaz grafica
     */
	public void actionPerformed(ActionEvent evento) 
	{
		
		String comando = evento.getActionCommand();
		
		if(comando.equals("Movimiento de la liebre"))
		{
			try 
			{
				liebre = new VistaLiebre(this);
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos correctamente");
			}
		}
		if(comando.equals("Ingresar movimientos"))
		{
			try 
			{
				ingresarMovimientos();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos correctamente");
			}
		}
		if(comando.equals("Ejecutar liebre"))
		{
			try 
			{
				liebre();
				mostrarRuta();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "No hay solucion o se ingresaron los datos incorrectamente");
			}
		}
		if(comando.equals("Juego de solitario"))
		{
			solitario = new VistaSolitario(this);
			solitario.setVisible(true);
		}
		if(comando.equals("Resolver solitario"))
		{
			datosSolitario();
			try 
			{
				modeloSolitario = new SolitarioTriangular(N1, N2);
				modeloSolitario.DFS();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		
			try 
			{
				resolverTrinagulito();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos correctamente");
			}
			
		}
		if(comando.equals("Corte de la varilla"))
		{
			varilla = new VistaVarilla(this);
		}
		if(comando.equals("Ingresar precios de los cortes"))
		{
			try 
			{
				ingresarPrecios();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos correctamente");
			}
		}
		if(comando.equals("Calcular beneficio de corte"))
		{
			try 
			{
				calcularCorte();
			} catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos requeridos correctamente");
			}
		}
	}
}
