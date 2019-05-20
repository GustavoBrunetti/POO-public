import java.util.Scanner;
public class uso {
	 public static void main(String args[]) {
		  	try {
		  		Aluno x = new Aluno();
		  	double n1Aux, n2Aux,pontosAux;
		  	int limite;
		  	System.out.println("Entre com o nome do aluno:");
		  	x.setNome(new Scanner(System.in).nextLine());
		  	while(true){
		     	   try {
		        	System.out.println("Entre com as duas notas do aluno:");
		        	n1Aux = new Scanner(System.in).nextDouble();
		        	n2Aux = new Scanner(System.in).nextDouble();
		        	System.out.println("Entre com os pontos:");
		        	pontosAux = new Scanner(System.in).nextDouble();
		        	System.out.println("Entre com o limite maximo da nota:");
		        	limite = new Scanner(System.in).nextInt();
		        	x.setLimiteSup(limite);
		        	x.setNotas(n1Aux,n2Aux,pontosAux);
		        	System.out.println(x);
		        	break;
		     	   }
		     	   catch(Exception e) {
		     		   System.out.println("nota inválida, faixa permitida: 0 a "+Aluno.getLimiteSup());
		     	   }
		  	}
	   		}catch (Exception i) {
	   			System.out.println("Erro");
	   		}
	   }
	}
	//fim da 5 n deve ser estatico, pois devese chamar uma determinada nota de um determinado aluno, ou seja um objeto estanciado
