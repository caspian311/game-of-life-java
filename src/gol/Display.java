package gol;

import java.io.PrintStream;

public class Display implements IDisplay {
	private PrintStream out;

	public Display(PrintStream out) {
		this.out = out;
	}
	
	@Override
	public void showBoard(Board board) {
		for (int i=0; i<board.getGrid().length; i++) {
			out.print("|");
			for (int t=0; t<board.getGrid()[i].length; t++) {
				out.print(board.getGrid()[i][t] ? "*" : " ");
			}	
			out.println("|");
		}
		out.println();
	}
}
