
public class RearangeString {
	public String MixString(String str){
		String[] data = str.split("");
		StringStack stack = new StringStack();
		String result = "";
		for(int i = 1; i < data.length; i++){
			stack.push(data[i]);
		}
		while(! stack.isEmpty()){
			result += stack.pop();
		}
		return result;
	}
	public String UnMixString(String str){
		String[] data = str.split("");
		StringStack stack = new StringStack();
		String result = "";
		for(int i = 1; i < data.length; i++){
			stack.push(data[i]);
		}
		while(! stack.isEmpty()){
			result += stack.pop();
		}
		return result;
		
	}

}
