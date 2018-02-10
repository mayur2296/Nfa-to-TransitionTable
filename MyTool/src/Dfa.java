import java.util.*;

public class Dfa {

	
	char matrix[][];
	ArrayList<Integer> closure,finalclosure,tempc;
	ArrayList<Integer> tempclosure;
	ArrayList<Integer> findclosure,tempfindclosure;
	PresentLocation pl;
	InputMatrix inputmatrix;
	int intarray[]=new int[20];
	Eclosure eclosure;
	FileManipulation file;
	Queue<ArrayList> queue=new LinkedList <ArrayList>();
	ResultClosure resultclosure;
	public Dfa()
	{
		file= new FileManipulation();
	    matrix=new char[Helper.matrixrows][Helper.matrixcols];
		closure=new ArrayList<Integer>();
		finalclosure=new ArrayList<Integer>();
		tempclosure=new ArrayList<Integer>();
		findclosure=new ArrayList<Integer>();
		tempfindclosure=new ArrayList<Integer>();
		pl=new PresentLocation();
		inputmatrix=new InputMatrix();
		matrix=Helper.matrix;
		eclosure=new Eclosure();
		resultclosure=new ResultClosure();
		
		//remove dublicates
		Set<Integer> s1=new LinkedHashSet<Integer>(closure);
		Set<Integer> s2=new LinkedHashSet<Integer>(finalclosure);
		
	}
	
	
	public void convert_to_dfa()
	{
		file.writetofile("========================SOLUTION TO YOUR PROBLEM===============================");
		file.writetofile();
		file.writetofile();
		closure.addAll(eclosure.getClosure(matrix, 0));
		closure.sort(null);
		queue.add(closure);
		resultclosure.addclosure(closure);
		
		while(!queue.isEmpty())
		{
			tempclosure.removeAll(tempclosure);
			tempclosure.addAll(queue.remove());
			file.writetofile("===============================================================================");
			file.writetofile();
			file.writetofile(""+Helper.getAlphabet()+" = ");
			file.writetofile(tempclosure);
			file.writetofile();
			file.writetofile();
			for(int k=0;k<Helper.total_inpu_char;k++)
			{
				tempfindclosure.removeAll(tempfindclosure);
				tempfindclosure.addAll(pl.present_for_input(tempclosure, Helper.input_characters[k]));
				file.writetofile("For "+Helper.input_characters[k]);
				file.writetofile();
				file.writetofile("E-Closure= "+tempfindclosure);
				file.writetofile();
				for(int a=0;a<tempfindclosure.size();a++)
				{
					closure.removeAll(closure);
					closure.addAll(eclosure.getClosure(matrix,tempfindclosure.get(a)));
					finalclosure.addAll(closure);
				}
				


				finalclosure.sort(null);
				if(resultclosure.already_exist(finalclosure))
				{
					//do_nothing
					file.writetofile(finalclosure+ " Already got same as -> ");
					file.writetofile(""+Helper.alphabets[resultclosure.getindex(finalclosure)]);
					file.writetofile();
					file.writetofile();
				}
				else
				{
					tempc=new ArrayList<Integer>();
					resultclosure.addclosure(finalclosure);
					file.writetofile(finalclosure);
					file.writetofile();
					file.writetofile();
					tempc.addAll(finalclosure);
					queue.add(tempc);
				}
				
				finalclosure.clear();
			}

			
		}

		file.writetofile("===============================================================================");
		file.writetofile();
		file.writetofile("===============================================================================");
		file.writetofile();
		file.writetofile();
		String data="";
		for(int queuetraversal=0;queuetraversal<resultclosure.resultqueue.size();queuetraversal++)
		{
			file.writetofile(Helper.alphabets[queuetraversal]+"->"+resultclosure.getclosure(queuetraversal));
			file.writetofile();
		}
		file.writetofile();
		file.writetofile("===============================================================================");
		file.closefile();
	}
	
	

}
