
package modelo;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import board.*;
import play.GameTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolitarioTriangular {
	
	GameBoard startBoard;
	
	String solucion = "";
	
	int n1;
	int n2;
	
	/**
	 * Inicializa el solitario y comienza a solucionarlo
	 * @param pN1 (Fila de inicio)
	 * @param pN2 (Columna de inicio)
	 * @throws IOException
	 */
	public SolitarioTriangular(int pN1, int pN2) throws IOException {
		
		n1 = pN1;
		n2 = pN2;
		
                    init(n1,n2);
	}
	
	/**
	 * Inicia a la solucion mediante "Backtracking"
	 * @param row (Fila de inicio)
	 * @param col (Columna de inicio)
	 */
	private void init(int row, int col) {
		startBoard = new GameBoard(row, col);
	}
	
	/**
	 * Busca la solucion entre todas las posibles ramas del arbol demdiante un algoritmo DFS (Depth First Search) para busqueda y recorrido de grafos
	 */
	public void DFS() {
		GameTree root = new GameTree(startBoard);
		
		for (GameBoard nextBoard : startBoard.possibleBoards()) {
			GameTree nextNode = new GameTree(nextBoard);
			if (play(nextBoard, nextNode))
				root.addChild(nextNode);
		}
		
                printWinningGame(root);
	}
	
	/**
	 * Imprime la solucion optima del juego
	 * @param parent
	 */
	private void printWinningGame(GameTree parent) {
		System.out.println(parent.getGameBoard());
		solucion += parent.getGameBoard() + "\n" + "\n";
		
		if (parent.numChildren() > 0) {
			GameTree nextNode = parent.getFirstChild();			
			printWinningGame(nextNode);				// recurse
			if (nextNode.numChildren() == 0)	
				parent.removeFirstChild();
		} else {
			System.out.println("===============================================");
		}
	}
	
	
	private boolean play(GameBoard gb, GameTree parent) {
		
		if (gb.finalBoard())	// remember this path was a winning path
			return true;
		
		List<GameBoard> nextBoards = gb.possibleBoards();
			
		boolean found = false;
		
		for (GameBoard nextBoard : nextBoards) {
			GameTree nextNode = new GameTree(nextBoard);
			if (play(nextBoard, nextNode)) {				// recurse
				found = true;
				parent.addChild(nextNode);
			}
		}
		
		return found;
	}


	public String getSolucion() {
		return solucion;
	}


	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}


	public int getN1() {
		return n1;
	}


	public void setN1(int n1) {
		this.n1 = n1;
	}


	public int getN2() {
		return n2;
	}


	public void setN2(int n2) {
		this.n2 = n2;
	}
}
