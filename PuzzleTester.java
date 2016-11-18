import java.util.Scanner;

public class PuzzleTester
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PuzzleFactory pf = new PuzzleFactory();
		Puzzle puzzle = pf.getPuzzles().get("PUZ006");
		puzzle.encounterPuzzle();
		Player player = new Player("0", 10, 5, 5, "1");
		Scanner input = new Scanner(System.in);
		
		while(!puzzle.getSolved())
		{
			String userInput = input.nextLine();
			puzzle.solvePuzzle(player, userInput);
			if(puzzle.getSolved())
			{
				//Advance the player to the next room here.
			}
		}
	}
}
