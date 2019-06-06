package ex24;

import java.io.Serializable;

/**
 * Usada como objeto de teste para compor as classes que encapsulam as coleções
 * LinkedList, TreeSet e HashMap
* <p>
* Implementa a interface Comparable, pois implementa o método
* compareTo que é usado na coleção TreeSet. Também poderia ser usado
* pelo método sort (com um argumento) da classe Collections
* <p>
* Implementa a interface Serializable, para permitir que as suas instâncias possam
* ser usadas numa serialização (por exemplo, gravação em disco)
*/
public class Sorteio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int dia;
	
	private int mes;

	private int ano;
	
	private NumerosSorteados num;
	
	/**
  	 * construtores para inicializar valores nos campos
  	 */

	public Sorteio (int d, int m, int a, int quant, int limInfi, int limSupi) throws Exception {
		this.setData(d,m,a);
		this.setNumSort(quant, limInfi, limSupi);
	}
	
	/**
  	 * construtores com as datas e a arvore   	
  	 */
	
	public Sorteio (int d, int m, int a, NumerosSorteados numeroSort) throws Exception {
		this.setData(d,m,a);
		this.setNumSort(numeroSort);
	}
	
	/**
  	 * construtores com os valores da data apenas 
  	 */
	
	public Sorteio (int d, int m, int a) throws Exception {
		this.setData(d,m,a);
		this.setNumSort();
	}
	
	/**
  	 * construtor com a quantidades de numeros a sortea 
  	 */
	
	public Sorteio (int quant) throws Exception {
		this.setData(1,1,1900);
		this.setNumSort(quant);
	}
	
	/**
  	 * construtor default que vai inicializar com os valores padroes
  	 */
	
	public Sorteio() throws Exception {
		this.setData(1,1,1900);
		this.setNumSort();
	}
	
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAno() {
		return this.ano;
	}
	/**
	 * modifica a data utilizando os valores para dia, mês e ano
	 * @throws Exception para o dia, mês ou ano invalidos
	 */
	public void setData(int d, int m, int a) throws Exception{
		if (Data.isDataValida(d, m, a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("Data invalida");
		}
	}
	
	/**
  	 * Modifica o valor do numero sorteado
  	 */
	
	public void setNumSort(int _quant, int _limIn, int _limSup) {
		this.num = new NumerosSorteados(_quant, _limIn, _limSup);
	}
	
	/**
  	 * Sobrecarregamento do set 
  	 */
	
	public void setNumSort(NumerosSorteados numSort) {
		this.num = numSort;
	}
	
	/**
  	 * Sobrecarregamento do set 
  	 */
	
	public void setNumSort(int quant) {
		this.num = new NumerosSorteados(quant);
	}
	
	/**
  	 * Sobrecarregamento do set 
  	 * 
  	 */
	
	public void setNumSort() {
		this.num = new NumerosSorteados();
	}
	
	/**
	 * Método sobreposto para devolver os campos formatados em uma String
	 * 
	 * retorna String com todos os valores dos campos
	 */
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\nData: ");
		s.append(this.getDia());
		s.append("/");
		s.append(this.getMes());
		s.append("/");
		s.append(this.getAno());
		s.append("\nNumeros Sorteados: ");
		s.append(this.num.getSorteioVal());
		return s.toString();
	}
	
}
