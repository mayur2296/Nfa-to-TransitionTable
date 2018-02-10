
public class Helper {
	
	public static char input_characters[]= new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
	public static int total_inpu_char=0;
	public static String fname="fname";
	public static int total_nodes=0;
	public static char null_char='$';
	public static int matrixrows=0;
	public static int matrixcols=0;
	public static int alphacounter=0;
	static char alphabets[]=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public static char matrix[][];
	
	public static void printline()
	{
		System.out.println("\n-----------------------------------------------------------");
	}

	public static char  getAlphabet()
	{
		alphacounter=alphacounter+1;
		return alphabets[alphacounter-1];
	}
	
	public static void initialise_matrix()
	{
		matrix=new char[Helper.total_nodes+1][Helper.total_nodes+1];
		for(int i=0;i<Helper.matrixrows;i++)
		{
			for(int j=0;j<Helper.matrixcols;j++)
			{
				matrix[i][j]='-';
				
			}
		}
	}
	
}
