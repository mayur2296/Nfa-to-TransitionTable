import java.util.ArrayList;
import java.util.Stack;

public class PresentLocation {

	ArrayList<Integer> list;
	char matrix[][];
	InputMatrix inputmatrix;
	public PresentLocation()
	{
		
		
	}
	
	
	public ArrayList<Integer> present_for_input(ArrayList<Integer> inputlist,char input)
	{
		list=new ArrayList<Integer>();
		matrix=new char[11][11];
		inputmatrix=new InputMatrix();
		matrix=inputmatrix.getMatrix();
		for(int i=0;i<inputlist.size();i++)
		{
			for(int j=0;j<Helper.matrixcols;j++)
			{
				if(matrix[inputlist.get(i)][j]==input)
				{
					list.add(j);
				}
				
			}
		}

		return list;
	}
}
