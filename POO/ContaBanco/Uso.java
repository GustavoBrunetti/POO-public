import java.util.Scanner;

public class Uso {
	private static Scanner scan;

	public static void main(String args[]) {
		try {
			System.out.println("primera conta");
			Conta ct1=new Conta();
			System.out.println("segunda conta");
			Conta ct2=new Conta();
			System.out.println("Digite |1| para corregir a primeira conta ou |2| para corregir a segunda conta:");
			scan = new Scanner(System.in);
			int operacao= scan.nextInt();
			if(operacao==1)
				ct1.corrige();
				
			else 
				ct2.corrige();
			System.out.println(ct1);
			System.out.println(ct2);				
		}catch(Exception e) {
			System.out.println("erro");
		}
	}
}
