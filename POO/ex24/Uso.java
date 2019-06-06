package ex24;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;





/**
 * Exemplo de:
 * 1. Uso da calsse ConjuntoSorteio. Que vai gerar, a partir de um sorteio, uma certa quantidade de valores (definido pelo usuario)
 * e vai gerar tambem uma certa quantidade de sorteios (tambem definido pelo usuario), com uma respectiva data para cada sorteio.
 * 2. Serialização de objetos
 *
 *<p>
 *Vale ressaltar que foram utilizados as colecoes:
 *        LinkedList para agrupar todo o conjunto de sorteio
 *        e uma TreeSet para organizar os numeros sorteados.
 *<p>
 *As classes foram encapsuladas afim de melhorar a legilibidade e manutencao do codigo
 *<p>
 *O resultado eh depois gravado em um arquivo de texto no disco atraves da serializacao
 *
 *
 */

public class Uso {

	public static void main(String[] args) throws Exception{

		try {

			ConjuntoSorteio sorteia_1 = new ConjuntoSorteio();

			sorteia_1.insere(18,03,1997,8,5,40,6);

			System.out.println(sorteia_1);

			Arquivo.grava("arquivo", sorteia_1);
		
			
			ConjuntoSorteio sorteia_2;

			sorteia_2 = (ConjuntoSorteio) Arquivo.le("arquivo");

			System.out.println("Dados lidos do arquivo:\n"+ sorteia_2.toString());


			BufferedWriter arqSaida;

			arqSaida = new BufferedWriter(new FileWriter("arquivo_de_saida.txt"));

			arqSaida.write(sorteia_2.toString()+"\r\n");

			arqSaida.close();


		} catch(FileNotFoundException e) {

			System.out.println("Arquivo nao encontrado");
		}
		catch(IOException e) {
			System.out.println("Problemas na leitura ou gravacao do arquivo");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Classe inexistente usada na conversao");
		}
	}
}
