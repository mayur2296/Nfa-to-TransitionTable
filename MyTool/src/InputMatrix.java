
public class InputMatrix {
	
	public  char matrix[][];
	
	public InputMatrix()
	{
		matrix=new char[Helper.total_nodes+1][Helper.total_nodes+1];
	}

	public char[][] getMatrix()
	{
		matrix=Helper.matrix;
		
		/*matrix[0][1]='$';
		matrix[0][7]='$';
		matrix[1][2]='$';
		matrix[1][4]='$';
		matrix[2][3]='a';
		matrix[4][5]='b';
		matrix[3][6]='$';
		matrix[5][6]='$';
		matrix[6][1]='$';
		matrix[6][7]='$';
		matrix[7][8]='a';
		matrix[8][9]='b';
		matrix[9][10]='b';*/
		return matrix;
	}
}
