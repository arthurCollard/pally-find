import java.util.Scanner;

public class pallyFind {
	public static void main(String [] args) {
		System.out.println("Please enter string to check for palindromes:");
		Scanner in = new Scanner(System.in);
		String check = in.next();
		String[] s = new String[check.length() * check.length()];
		s = findAllPalindromes(check);
		for (int i =0; i < s.length ; i++) {
			if (s[i] != null) {
				System.out.println(s[i]);				
			}
		}
		in.close();
	}	
	
	public static String[] findAllPalindromes(String s) {
		String[] a = new String[s.length()*s.length()];		//Just made an array that should fit all posiblities should be optimized
		int addr = 0;
		for (int i= s.length(); i > 0; i--) {
			for (int j=0; j <= (s.length() - i) ; j++) {
				if (findPalindrome(s.substring(j,j+i))) {
					a[addr] = s.substring(j,j+i);
					addr++;
				}
			}
		}
		return a;
	}
	public static boolean findPalindrome(String s) {
		if ((s.length() % 2) == 0) { 				//Check for palindromes where substring is of even length
			String s1 = s.substring(0, s.length()/2);
			String s2 = s.substring(s.length()/2, s.length());	//splits the string into two halves
			StringBuilder stringBuilder = new StringBuilder(s2);
			s2 = stringBuilder.reverse().toString();			//reverse one string
			boolean isPal = true;
			for(int i=0; i < s1.length(); i++) {
				if ( s1.charAt(i) != s2.charAt(i)) {			//then checks if they are the same
					return false;
				}
			}
			return isPal;
		} else {									//Check for palindromes in substrings of odd length
			String s1 = s.substring(0, (s.length()/2));			//implementation is basically the same, except leaves out the middle char
			String s2 = s.substring((s.length()/2)+1, s.length());
			StringBuilder stringBuilder = new StringBuilder(s2);
			s2 = stringBuilder.reverse().toString();
			boolean isPal = true;
			for(int i=0; i < s1.length(); i++) {
				if ( s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
			}
			return isPal;
		}
	}
}
