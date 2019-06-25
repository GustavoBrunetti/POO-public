package agendaPac;

/**
 * Classe do período, com data de inicio e fim e horário de inicio e fim
 *
 * @author Gustavo Brunetti
 * @version 1.0
 */
public class Periodo {
	
	private Data dataInicial;	
	private Data dataFinal;
	private Horario horarioInicial;
	private Horario horarioFinal;

	/**
	 * construtor para inicializar valores nos campos
	 *
	 * @param dataInicial data do início 
	 * @param horarioInicial horário do início 
	 * @param dataFinal data do fim 
	 * @param horarioFinal horário do fim 
	 * @exception Exception caso a data seja invalida
	 */
	public Periodo(Data dataInicial, Data dataFinal, Horario horarioInicial, Horario horarioFinal) throws Exception {
		if (dataInicial.compareTo(dataFinal) == -1 || (dataInicial.compareTo(dataFinal) == 0 )) {
			this.setdataInicial(dataInicial);
			this.setdataFinal(dataFinal);
			this.sethorarioInicial(horarioInicial);
			this.sethorarioFinal(horarioFinal);
		} else throw new Exception("Data invalida");
	}

	/** 
	 * metodos sets
	 *  */	
	public void setdataInicial(Data dataInicial) {
		this.dataInicial = dataInicial;	}

	public void setdataFinal(Data dataFinal) {
		this.dataFinal = dataFinal;}

	public void sethorarioInicial(Horario horarioInicial) {
		this.horarioInicial = horarioInicial;}

	public void sethorarioFinal(Horario horarioFinal) {
		this.horarioFinal = horarioFinal;}
	
	/**
 	 * pega data inicial
 	 *
 	 * @return data inicial
 	 */
	public Data getdataInicial() {
		return this.dataInicial;
	}
	
	/**
 	 * pega data final
 	 *
 	 * @return data final
 	 */
	public Data getdataFinal() {
		return this.dataFinal;
	}
	
	/**
 	 * pega horario inicial
 	 *
 	 * @return horario inicial
 	 */
	public Horario gethorarioInicial() {
		return this.horarioInicial;
	}
	
	/**
 	 * pega horario final
 	 *
 	 * @return horario final
 	 */
	public Horario gethorarioFinal() {
		return this.horarioFinal;
	}
	
	/**
  	 * Método sobreposto para devolver os campos formatados em uma String
  	 *
  	 * @return retorna String com todos os valores dos campos
  	 */
	public String toString() {
		StringBuilder periodo = new StringBuilder();
		periodo.append("data inicial:  ");
		periodo.append(this.getdataInicial());
		periodo.append(" às ");
		periodo.append(this.gethorarioInicial());
		periodo.append("- data final: ");
		periodo.append(this.getdataFinal());
		periodo.append(" às ");
		periodo.append(this.gethorarioFinal());
		return periodo.toString();
	}
}
