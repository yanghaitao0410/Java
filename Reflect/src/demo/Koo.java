package demo;

public class Koo {

	public int a;
	public String b;
	
	public Koo() {
		
	}
	
	public String sayHello(String I,String you){
		return I +" love " +you; 
	}
	
	public Koo(int a,String b){
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "Koo [a=" + a + ", b=" + b + "]";
	}
	
}
