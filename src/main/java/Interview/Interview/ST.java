package Interview.Interview;

public class ST {

	public static void main(String[] args) {
		String s1= "java";
		String s2 = s1.concat("world");
		
		System.out.println(s1 + "  " + s2);
		
		StringBuffer b1= new StringBuffer("java");
		StringBuffer b2= new StringBuffer("java");
		
		System.out.println(b1.equals(b2));
		System.out.println(s1.equals(b1));
		
		
	}

}
