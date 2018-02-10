import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ResultClosure {

	//Queue<ArrayList> resultqueue;
	List<ArrayList> resultqueue;
	ArrayList<Integer> closure;
	public ResultClosure() {
		// TODO Auto-generated constructor stub
		resultqueue=new ArrayList<ArrayList>();
	}
	
	public void addclosure(ArrayList<Integer> rclosure)
	{
	
		closure=new ArrayList<Integer>();
		closure.addAll(rclosure);
		resultqueue.add(closure);
	}
	
	public void printfinalclosure()
	{
		System.out.println("=-="+resultqueue);
	}
	
	public boolean already_exist(ArrayList<Integer> rclosure)
	{
		if(resultqueue.contains(rclosure))
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public ArrayList<Integer> getclosure(int index)
	{
		
		return resultqueue.get(index);
	}
	
	public int getindex(ArrayList<Integer> rclosure)
	{
		
		return resultqueue.indexOf(rclosure);
	}
}
