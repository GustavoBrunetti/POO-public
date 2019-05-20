package exer2;

import java.util.Scanner;

public class Uso {
	
	private static Scanner ler = new Scanner(System.in);
	
	
	public static void main (String args[] )throws Exception {	
		
		Data data1 = null,data2;
		String str1 ="", str2="";
		int i=0,incre=0;
		
		while(i!=3) {
			try {
				System.out.println("Entre com a primeira data: ");
				str1 = ler.nextLine();
				System.out.println("Entre com a Segunda data: ");
		        str2 = ler.nextLine();
		        System.out.println(i); 
		        
		        
	
		        data1 = new Data(str1);
				data2 = new Data(str2);
		       
				System.out.println("\nData1: "+data1);
				System.out.println("\nData2: "+data2);
				System.out.println("\nAs datas sao iguais? "+data1.equals(data2));
				 break;
			}
			catch(Exception e) {
			    	i++;
				    System.out.println(e);
			}
	    }
	
	if(i==3) {
	Data data = new Data(1,1,1990);
	System.out.println("Data padrão:"+data);
	}
	
	data1.incrementa();
	System.out.println("Entre com os dias a incrementar: ");
	incre = ler.nextInt();
	System.out.println(data1);
	data1.incrementa(incre);
	System.out.println(data1);

	
	}
}
