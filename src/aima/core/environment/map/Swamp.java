package aima.core.environment.map;

public class Swamp {
	private short[][] swamp;
	
	private static boolean[][] staticswamp =
	{ {true, true, false,false,true, true, false},
	  {true, false,false,false,true, false,true },
	  {false,false,false,false,false,false,true },
	  {false,false,false,false,false,true, false},
	  {true, true, true, true, true, true, false}};
	
	public Swamp(int rows, int cols, double probLand, double probMud)
	{
		swamp = new short[rows][cols];
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++) {
				swamp[r][c] = ( Math.random() > probLand) ? (short)0 : (short) 1;
				if (swamp[r][c] == 1) {
					swamp[r][c] = ( Math.random() > probMud) ? (short) 1: (short) 2;
				}
			}
		}
	}
	
	public int getCols()
	{
		return swamp[0].length;
	}
	
	public int getRows()
	{
		return swamp.length;
	}
	
	public boolean land(int r, int c)
	{
		return (r >= 0) && (r < swamp.length) && (c >= 0) && (c < swamp[0].length) && (swamp[r][c] != 0);
	}
	
	public boolean mud(int r, int c) {
		return swamp[r][c] == 2 ? true : false;
	}
	
	public String toString()
	{
		String ris = "Swamp:\n";
		
		for (int r = 0; r < swamp.length; r++)
		{
			ris += "    ";
			
			for (int c = 0; c < swamp[0].length; c++) ris += (swamp[r][c] != 0 ? "* " : "o ");
			
			ris += "\n";
		}
		
		return ris;
	}
}
