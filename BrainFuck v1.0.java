public class BrainFuck{

	static int[] stack = new int[16];
	static int sIndex = 0;
	static int charIndex = 0;
	static String code;
	static int length;

	public static void main(String[] args) {
		
		for (int i = 0; i < 16; i++ ) {
			stack[i] = 0;
		}
		//System.out.println(stack[0]);
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("Code:");
		code = s.next();
		length = code.length();
		//System.out.println(code);

		while (charIndex < length){
			charIndex = BrainFuck.operation(charIndex);
			charIndex++;
		}
			
			

	}


	
	public static int operation(int cIndex){
		switch(code.charAt(cIndex)){

			case '<':
				if (cIndex < 1) {
					break;
				}else{
					sIndex = sIndex - 1;
					break;
				}

			case '>':
				if (cIndex > length) {
					break;
				}else{
					sIndex = sIndex + 1;
					//System.out.println(sIndex);
					break;
				}

			case '+':
				stack[sIndex]++;
				//System.out.println(stack[0]);
				break;

			case '-':
				stack[sIndex]--;
				//System.out.println(stack[0]);
				break;

			case ',':
				java.util.Scanner s = new java.util.Scanner(System.in);
				System.out.print("Input:");
				stack[sIndex] = s.nextInt();
				//System.out.println(stack[0]);
				break;

			case '.':
				//System.out.println((char) stack[sIndex]);
				System.out.print((char)stack[sIndex]);
				break;

			case '[':
				while (stack[sIndex] == 0){
					if (code.charAt(cIndex) != ']') {
						cIndex++;
					}else{
						break;
					}
				}
				break;

			case ']':
				while (stack[sIndex] != 0){
					if (code.charAt(cIndex) != '[') {
						cIndex--;
					}else {
						break;
					}
				}

			default:
				break;

		}
		return cIndex;

	}

}