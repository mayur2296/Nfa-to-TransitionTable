import java.util.ArrayList;
import java.util.Stack;

public class Eclosure {
	Stack<Integer> stack;
	Stack<Integer> tempstack;
	
	
	
	public Eclosure()
	{
		
	
	}
	
	public ArrayList<Integer> getClosure(char matrix[][],int node)
	{
		int j=0;
		int temp=0;
		ArrayList<Integer> closuree=new ArrayList<Integer>();
		stack=new Stack<Integer>();
		tempstack=new Stack<Integer>();
		stack.push(node);
		addTempstack(getTempstack(),node);
		
		while(!stack.empty())
		{
			temp=stack.pop();
			closuree.add(temp);
			for(j=0;j<Helper.matrixcols;j++)
			{
				if(matrix[temp][j]=='$')
				{
					//check if element already entered in stack or not
					if(!is_element_entered(j) && stack.search(j)==-1)
					{
						addTempstack(getTempstack(),j);
						stack.push(j);
					}
					else
					{
						;
					}
					
				}
			}
		}
		
		return closuree;
	}
	
	public boolean is_element_entered(int element)
	{
		Stack<Integer> stack1=new Stack<Integer>();
		stack1=this.getTempstack();
		if(stack1.search(element)==-1)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	public Stack<Integer> getTempstack() {
		return tempstack;
	}

	public void setTempstack(Stack<Integer> tempstack) {
		this.tempstack = tempstack;
	}
	
	public void addTempstack(Stack<Integer> tempstack,int ele) {
		tempstack.push(ele);
		this.tempstack = tempstack;
	}
	
}
