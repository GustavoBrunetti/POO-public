package ex24;

import java.io.Serializable;
import java.util.*;

/**
 * Encapsula a classe LinkedList facilitando o seu uso e tipificando os objetos
 * para inclusão como instâncias da classe Sorteio
 *
 */

public class ConjuntoSorteio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Sorteio> valores;
	private Sorteio aux;
	
	public ConjuntoSorteio() {
		valores = new LinkedList<Sorteio>();
	}
	
	
	public void insere(Sorteio sorteio, int num_sort) throws Exception {
		this.valores.add(sorteio);
		for (int i = 1;i<num_sort;i++) {
			if (Data.isDataValida(sorteio.getDia()+1, sorteio.getMes(), sorteio.getAno())) {
				this.valores.add(new Sorteio(sorteio.getDia()+1,sorteio.getMes(), sorteio.getAno()));
				sorteio = new Sorteio(sorteio.getDia()+1, sorteio.getMes(), sorteio.getAno());
			}
			else if (Data.isDataValida(1, sorteio.getMes()+1, sorteio.getAno())) {
				this.valores.add(new Sorteio(1, sorteio.getMes()+1,sorteio.getAno()));
				sorteio = new Sorteio(1, sorteio.getMes()+1,sorteio.getAno());
			}
			else if (Data.isDataValida(1, 1, sorteio.getAno()+1)) {
				this.valores.add(new Sorteio(1, 1, sorteio.getAno() + 1));
				sorteio = new Sorteio(1, 1, sorteio.getAno()+1);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Insere uma instância da classe Sorteio por intermédio dos seus campos
	  */
	
	public void insere(int d, int m, int a, NumerosSorteados sorteio_v, int num_sort) throws Exception {
		this.valores.add(new Sorteio(d,m,a,sorteio_v));
		aux = new Sorteio(d,m,a,sorteio_v);
		for (int i = 1;i<num_sort;i++) {
			if (Data.isDataValida(aux.getDia()+1, aux.getMes(), aux.getAno())) {
				this.valores.add(new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno()));
				aux = new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno());
			}
			else if (Data.isDataValida(1, aux.getMes()+1, aux.getAno())) {
				this.valores.add(new Sorteio(1, aux.getMes()+1,aux.getAno()));
				aux = new Sorteio(1, aux.getMes()+1, aux.getAno());
			}
			else if (Data.isDataValida(1, 1, aux.getAno()+1)) {
				this.valores.add(new Sorteio(1, 1, aux.getAno() + 1));
				aux = new Sorteio(1, 1,aux.getAno()+1);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Insere uma instância da classe Sorteio por intermédio dos seus campos
	 */
	
	public void insere(int d, int m, int a, int quant, int limInf, int limSup, int num_sort) throws Exception {
		aux = new Sorteio(d,m,a,quant,limInf,limSup);
		this.valores.add(aux);
		for (int i = 1;i<num_sort;i++) {
			if (Data.isDataValida(aux.getDia()+1, aux.getMes(), aux.getAno())) {
				aux = new Sorteio(aux.getDia()+1, aux.getMes(), aux.getAno(),quant,limInf,limSup);
				this.valores.add(aux);
			}
			else if (Data.isDataValida(1, aux.getMes()+1, aux.getAno())) {
				aux = new Sorteio(1, aux.getMes()+1, aux.getAno(),quant,limInf,limSup);
				this.valores.add(aux);
			}
			else if (Data.isDataValida(1, 1, aux.getAno()+1)) {
				aux = new Sorteio(1, 1, aux.getAno()+1,quant,limInf,limSup);
				this.valores.add(aux);
			}
			else {
				throw new Exception("Data invalida");
			}
		}
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da coleção
	 */
	
	public String toString() {
		StringBuilder info = new StringBuilder();
		for (int i = 0; i < this.valores.size();i++) {
			info.append(this.valores.get(i) + "\n\r");
		}
		return info.toString();
	}
}
