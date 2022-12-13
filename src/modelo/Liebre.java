package modelo;

import java.util.ArrayList;

public class Liebre
{

	static ArrayList<int [][]> soluciones;

	public int N;
	public int M;

	int inicioA;
	int inicioB;
	
	int finalA;
	int finalB;

	public int row[];
	public int col[];	
	
	int [][] mejor;
	
	/**
	 * Metodo constructor de la clase liebre
	 * @param pM (Cantidad de filas del tablero)
	 * @param pN (Cantidad de columnas del tablero)
	 * @param pInicioA (Fila de inicio de la liebre)
	 * @param pInicioB (Columna de inicio la liebre)
	 * @param pFinalA (Fila de llegada de la liebre)
	 * @param pFinalB (Columna de llegada de la liebre)
	 */
	public Liebre(int pM, int pN, int pInicioA, int pInicioB, int pFinalA, int pFinalB)
	{
		
		M = pM;
		N = pN;
		
		inicioA = pInicioA;
		inicioB = pInicioB;
		
		finalA = pFinalA;
		finalB = pFinalB;		
		
		row = new int [8];
		col = new int [8];
	}
	
	/**
	 * Ejecuta la busqueda de todas las posible soluciones
	 */
	public void ejecutar()
	{
		
		int visited[][] = new int[N][M];
		int pos = 1;

		soluciones = new ArrayList<int[][]>();

		knightTour(visited, inicioA, inicioB, pos);

		if(soluciones.size() == 0)
		{
			System.out.println("No hay solucion");
		}
		if(soluciones.size() != 0)
		{

			int [][] mejorSolucion = encontrarMejorCamino(finalA,finalB);

			System.out.println("Mejor solucion");
			print(mejorSolucion);
		}
	}

	/**
	 * Identifica si un movimiento es valido
	 * @param x (Posicion en X)
	 * @param y (Posicion en Y)
	 * @return (La posibilidad de movimiento)
	 */
	private boolean isValid(int x, int y)
	{
		if (x < 0 || y < 0 || x >= N || y >= M)
			return false;

		return true;
	}

	/**
	 * Imprime las soluciones
	 * @param visited (Camino/Solucion a imprimir)
	 */
	private void print(int[][] visited)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Busca todos los posibles caminos
	 * @param visited (Camino visitado)
	 * @param x (Posicion en X)
	 * @param y (Posicion en Y)
	 * @param pos (Posicion)
	 */
	public void knightTour(int visited[][], int x, int y, int pos)
	{

		visited[x][y] = pos;

		if (x == finalA && y == finalB)
		{

			int [][] a = new int [N][M];
			for (int i = 0; i < a.length; i++) 
			{
				for (int j = 0; j < a[0].length; j++) 
				{
					a [i][j] = visited [i][j];
				} 
			}
			soluciones.add(a);
			print(visited);
			
				visited[x][y] = 0;

				return;
		}

//		if(soluciones.size() == 0)
//		{
		for (int k = 0; k < 8; k++)
		{

			int newX = x + row[k];
			int newY = y + col[k];

			if (isValid(newX, newY) && visited[newX][newY] == 0)
				knightTour(visited, newX, newY, pos + 1);
		}
//		}

		visited[x][y] = 0;
	}
	
	/**
	 * Busca la ruta o solucion mas optima, es decir que "Poda las ramas"
	 * @param x (Fila de llegada)
	 * @param y (Columna de llegada)
	 * @return (Camino mas optimo)
	 */
	public int [][] encontrarMejorCamino(int x, int y)
	{
		int actual = soluciones.get(0) [x][y];
		int [][] a = soluciones.get(0);

		for (int i = 0; i < soluciones.size(); i++) 
		{

			int [][] solucionActual = soluciones.get(i);

			if(solucionActual [x][y] <= actual)
			{
				actual = solucionActual [x][y];
				a = solucionActual;
			}
		}

		mejor = a;
		return a;
	}
	
	/**
	 * Organiza los posibles movimientos de la liebre
	 * @param a (Movimiento A)
	 * @param b (Movimiento B)
	 */
	public void generarMovimientos(int a, int b)
	{
		
		row [0] = a;
		col [0] = b;
		
		row [1] = b;
		col [1] = a;
		
		row [2] = b * -1;
		col [2] = a;
		
		row [3] = a * -1;
		col [3] = b;
		
		row [4] = a * -1;
		col [4] = b * -1;
		
		row [5] = b * -1;
		col [5] = a * -1;
		
		row [6] = b;
		col [6] = a * -1;
		
		row [7] = a;
		col [7] = b;
	}

	public int[][] getMejor() {
		return mejor;
	}

	public void setMejor(int[][] mejor) {
		this.mejor = mejor;
	}
}