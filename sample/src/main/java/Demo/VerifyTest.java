package Demo;

public class VerifyTest {
	
	int a;
	int b;
	
	public void add(int ab, int bc) {
		
		this.a=ab;
		this.b=bc;
		System.out.println(a+" "+b);
	}

	public static void main(String[] args) {
		VerifyTest vt=new VerifyTest();
		vt.add(15, 25);

	}

}
