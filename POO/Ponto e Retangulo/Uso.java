package ex9e10;
public class Uso {
	public static void main(String args[]) {
		try {
			Retangulo r=new Retangulo(4,3,5,2);
			Retangulo r2=new Retangulo(4,3,5,2);
			System.out.println(r);
			System.out.println("perimetro: "+r.perimetro());
			System.out.println("area: "+r.area());
			System.out.println(""+r.equals(r2));
			System.out.println(""+r.equalsArea(r2));
			System.out.println(""+r.compareTo(r2));
		}catch(Exception e){
			System.out.println("erroh");
		}
	}
}