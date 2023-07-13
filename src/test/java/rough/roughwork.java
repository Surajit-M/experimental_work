package rough;

public class roughwork {
	
	public static void main(String[] args) {
		String input_str = "hello world";
		String output_str = "";
		String[] input_str_arr = input_str.split(" ");
		for(String word : input_str_arr) {
			String[] word_arr = word.split("");
			for(int i = word_arr.length - 1; i >= 0; i--) {
				output_str = output_str + word_arr[i];
			}
			output_str = output_str + " ";
		}
		output_str = output_str.trim();
		System.out.println(output_str);
	}
		

}
