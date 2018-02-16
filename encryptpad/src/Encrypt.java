
public class Encrypt {
	// add string switcher
	private final int[] encryptChain = {1993,123456,34252341,1543661,13413,13413,5425,2346,11243,132413,90390483,134134,45432};
	public String EncrpytString(String str){
		String result = "";
		RearangeString mixer = new RearangeString();
		char ch;
		int chainCounter = 0;
		for(int i = 0; i < str.length(); i++){
			if(chainCounter < encryptChain.length){
				chainCounter = 0;
			}
			ch = str.charAt(i);
			ch += encryptChain[chainCounter];
			result  += ch;
			chainCounter++;			
		}
		result = mixer.MixString(result);
		return result;
	}
	public String DecryptString(String str){
		String result = "";
		RearangeString mixer = new RearangeString();
		char ch;
		int chainCounter = 0;
		for(int i = 0; i <str.length(); i++){
			chainCounter = 0;
			ch = str.charAt(i);
			ch -= encryptChain[chainCounter];
			result += ch;
			chainCounter++;
		}
		result = mixer.UnMixString(result);
		return result;
		
	}

}
