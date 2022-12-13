
package board;

import java.util.List;
import java.util.ArrayList;


public class GameBoard {
	
	
	static int N = 5;
	
	// board consists of pegs and holes in a 5 x 5, but only uses triangular pyramid
	boolean[][] pins = new boolean[N][N];

	
	public GameBoard(int row, int col) {
		for (int i = 0; i < N; ++i)
			for (int j = 0; j <= i; ++j)
				pins[i][j] = true;
		pins[row][col] = false;
	}
	

	public GameBoard(int board) {
		for (int i = N-1; i >= 0; --i)
			for (int j = i; j >= 0; --j) {
				if ((board & 1 ) == 1) 
					pins[i][j] = true;
				else
					pins[i][j] = false;
				board /= 2;
			}

	}

	
	// copy constructor
	public GameBoard(GameBoard that) {
		for (int i = 0; i < N; ++i)
			for (int j = 0; j <= i; ++j)
				pins[i][j] = that.pins[i][j];
	}


	public List<GameBoard> possibleBoards() {
		List<GameBoard> boards = new ArrayList<GameBoard>();
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j <= i; ++j) {
				Position start = new Position(i,j);
				List<Move> possibleMoves = Moves.getMoves(start);
				for (Move move : possibleMoves) {
					if (validMove(move))
						boards.add(jump(move));
				}
			}
		
		return boards;
	}
	
	
	public boolean validMove(Move move) {
		if (!pins[move.getStart().getRow()][move.getStart().getCol()])	// empty start
			return false;
		if (!pins[move.getJump().getRow()][move.getJump().getCol()])	// empty jump over
			return false;
		if (pins[move.getEnd().getRow()][move.getEnd().getCol()])		// filled in end
			return false;
		
		return true;
	}
	
	
	public GameBoard jump(Move move) {
		GameBoard gb = new GameBoard(this);
		
		gb.pins[move.getStart().getRow()][move.getStart().getCol()] = false;
		gb.pins[move.getJump().getRow()][move.getJump().getCol()] = false;
		gb.pins[move.getEnd().getRow()][move.getEnd().getCol()] = true;
		
		return gb;
	}
	
	
	public boolean finalBoard() {
		int remainingPins = 0;

		for (int i = 0; i < N; ++i)
			for (int j = 0; j <= i; ++j) 
				if (pins[i][j]) {
					remainingPins++;
					if (remainingPins > 1)	// optimize, early out, more than 1 pin is not final board
						return false;
				}
		
	    return remainingPins == 1;
	}	

	
	public int toInt() {
		int ret = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j <= i; ++j) {
				ret *= 2;
				if (pins[i][j]) {
					ret |= 1;
				}
			}

		return ret;
	}
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; ++i) {
			for (int s = 4-i; s > 0; --s)
				sb.append(" ");
			for (int j = 0; j <= i; ++j) {
				sb.append(pins[i][j] ? 'X' : 'O').append(" ");
			}
			sb.append("\n");
		}
//		sb.append(toInt()+ "\n");
		
		return sb.toString();
	}
}
