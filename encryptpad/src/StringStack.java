import java.util.ArrayList;


public class StringStack {
	private ArrayList<String> stack = new ArrayList<String>();
	private int index = 0;
	public void push(String item){
		stack.add(item);
		index++;
	}
	public String pop(){
		String returnText = stack.get(index - 1);
		index--;
		return returnText;
	}
	public String peek(){
		return stack.get(index);
	}
	public boolean isEmpty(){
		return (index == 0);
	}

}
