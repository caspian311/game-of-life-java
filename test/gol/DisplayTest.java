package gol;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class DisplayTest {
	private IDisplay testObject;
	private ByteArrayOutputStream out;
	
	private static final String LINE_ENDING = System.getProperty("line.separator");
	
	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		testObject = new Display(new PrintStream(out));
	}

	private String getWrittenOutput() {
		return new String(out.toByteArray());
	}
	
	@Test
	public void simpleEmptyBoardShowsUpEmpty() {
		Board emptyBoard = new Board(new boolean[1][1]);
		testObject.showBoard(emptyBoard);
		
		assertEquals("| |" + LINE_ENDING + LINE_ENDING, getWrittenOutput());
	}

	@Test
	public void simpleFullBoardShowsUpEmpty() {
		Board emptyBoard = new Board(new boolean[][] {{true}});
		testObject.showBoard(emptyBoard);
		
		assertEquals("|*|" + LINE_ENDING + LINE_ENDING, getWrittenOutput());
	}
	
	@Test
	public void emptyBiggerBoardShowsUpEmpty() {
		Board empty3x3Board = new Board(new boolean[3][3]);
		testObject.showBoard(empty3x3Board);
		
		assertEquals("|   |" + LINE_ENDING + "|   |" + LINE_ENDING + "|   |" + LINE_ENDING + LINE_ENDING, getWrittenOutput());
	}
	
	@Test
	public void fullBiggerBoardShowsCorrectly() {
		boolean[][] full = new boolean[3][3];
		full[0][0] = true;
		full[0][1] = false;
		full[0][2] = false;
		full[1][0] = false;
		full[1][1] = true;
		full[1][2] = false;
		full[2][0] = false;
		full[2][1] = false;
		full[2][2] = true;
		Board empty3x3Board = new Board(full);
		testObject.showBoard(empty3x3Board);
		
		assertEquals("|*  |" + LINE_ENDING + "| * |" + LINE_ENDING + "|  *|" + LINE_ENDING + LINE_ENDING, getWrittenOutput());
	}
}
