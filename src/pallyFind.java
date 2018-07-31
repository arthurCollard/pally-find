
public class pallyFind {
	public static void main(String [] args) {
		String[] s = new String[1000];
		s = findAllPalindromes("ghjghjggjgj");
		for (int i =0; i < s.length ; i++) {
			System.out.println(s[i]);
		}
	}	
	
	public static String[] findAllPalindromes(String s) {
		String[] a = new String[12];
		int addr = 0;
		for (int i= s.length(); i > 0; i--) {
			for (int j=0; j < (s.length() - i) ; j++) {
				if (findPalindrome(s.substring(j,j+i))) {
					a[addr] = s.substring(j,j+i);
					addr++;
				}
			}
		}
		return a;
	}
	public static boolean findPalindrome(String s) {
		if ((s.length() % 2) == 0) { 				//String is of even length
			String s1 = s.substring(0, s.length()/2);
			String s2 = s.substring(s.length()/2, s.length());
			StringBuilder stringBuilder = new StringBuilder(s2);
			s2 = stringBuilder.reverse().toString();
			boolean isPal = true;
			for(int i=0; i < s1.length(); i++) {
				if ( s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
			}
			return isPal;
		} else {
			String s1 = s.substring(0, (s.length()/2));
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
