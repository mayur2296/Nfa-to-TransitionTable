import java.util.ArrayList;

public class TransitionList {
	
	
	ArrayList<ArrayList> list=new ArrayList<ArrayList>();

	public TransitionList()
	{
		
	}
	

	public ArrayList<ArrayList> getList() {
		return list;
	}
	public void setList(ArrayList<ArrayList> list) {
		this.list = list;
	}
	
	public void addList(ArrayList<ArrayList> list,ArrayList<Integer> closure) {
		list.add(closure);
		this.list = list;
	}
	
	public void addList(ArrayList<Integer> closure) {
		this.list.add(closure);
	}
}
