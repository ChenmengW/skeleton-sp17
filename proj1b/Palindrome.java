public class Palindrome {
	public static Deque<Character> wordToDeque(String word){
		ArrayDequeSolution<Character> array = new ArrayDequeSolution();
		char[] a = word.toCharArray();
		for (char c: a){
			array.add(c);
		}
		return array;
	}

	public static boolean isPalindrome(String word){
		if (word.length() == 0 || word.length() == 1){
			return true;
		}
		else {
			char [] a = word.toCharArray();
			int len;
			len = a.length;
			for (int i = 0; i <= len/2; i++){
				if (a[i] == a[a.length-i-1]){
				}
				else {
					return false;
				}
				i += 1;
			}
			return true;
		}
	}

	public static void main(String[] args){
		Deque<Character> a = wordToDeque("Hello");
		boolean k = isPalindrome("Hello");
	}



}