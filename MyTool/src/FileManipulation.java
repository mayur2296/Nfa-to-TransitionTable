import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Queue;

public class FileManipulation {


	PrintWriter writer = null;
	public FileManipulation() {
		// TODO Auto-generated constructor stub
		try {
			writer = new PrintWriter(Helper.fname,"UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writetofile(String str)
	{
		writer.print(str);
	}
	
	
	public void writetofile(ArrayList<Integer> str)
	{
		writer.print(str);
	}
	
	public void writetofile()
	{
		writer.println();
	}
	public void closefile()
	{
		writer.close();
	}

	public void writetofile(Queue<ArrayList> str) {
		// TODO Auto-generated method stub
		writer.print(str);
		
	}
}
