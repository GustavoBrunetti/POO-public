package ex14;

import java.util.Scanner;

public class Uso {

		private static Scanner scanner;

		public static void main (String[] args) {
			int numCadastro,numCelular,a=0,b;
			String nome, endereco, email, tipoCliente;
			double rendaFamiliar;
			
			System.out.println("digite o numero de Clientes que deseja cadastrar:");
			scanner = new Scanner(System.in);
			numCadastro = scanner.nextInt();
			
			//numCadastro=50;
			
			Cliente[] clientes = new Cliente[numCadastro];

			for(a=0;a<numCadastro;a++) {
				b=a+1;
				System.out.println("Nome do Cliente cliente de numero " +b);
				nome = new Scanner(System.in).nextLine();
				
				System.out.println("Renda:");
				rendaFamiliar = new Scanner(System.in).nextDouble();
				
				System.out.println("Email:");
				email = new Scanner(System.in).nextLine();

				System.out.println("numero do celular:");
				numCelular = new Scanner(System.in).nextInt();
				
				System.out.println("Endereco:");
				endereco = new Scanner(System.in).nextLine();
				
				try {clientes[a] = new Cliente(nome, email, numCelular, endereco, rendaFamiliar);}
				catch (Exception e) {
                    System.out.println("Email Invalido");
			}
		}
			for(a=1;a<numCadastro;a++) {
				b=a+1;
				System.out.println("Cliente "+b +":");
				System.out.println(clientes[a]);
				tipoCliente = clientes[a].categoriaCliente(clientes[a].getRendaFamiliar());
				System.out.print("Categoria do Cliente: "+ tipoCliente +"|");
			}
	}
}