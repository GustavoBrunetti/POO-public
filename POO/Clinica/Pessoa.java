public class Pessoa {
	private String nome, identidade;
	private Data dtNasc;
	
	public Pessoa(String _nome, String _identidade, Data _dtNasc) {
		this.setNome(_nome);
		this.setIdentidade(_identidade);
		this.setDtNasc(_dtNasc);
	}
	public Pessoa(String _nome, String _identidade, String _dtNascStr) throws Exception {
		this.setNome(_nome);
		this.setIdentidade(_identidade);
		this.setDtNasc(new Data(_dtNascStr));
	}
	public Pessoa(String _nome, String _identidade, int _d, int _m, int _a) throws Exception {
		this.setNome(_nome);
		this.setIdentidade(_identidade);
		this.setDtNasc(new Data(_d,_m,_a));
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public String getIdentidade() {
		return this.identidade;
	}
	public void setIdentidade(String _identidade) {
		this.identidade = _identidade;
	}
	public Data getDtNasc() {
		return this.dtNasc;
	}
	public void setDtNasc(Data _dtNasc) {
		this.dtNasc = _dtNasc;
	}
	public double calculaMaxEmprestimo() {
		return 1000;
	}
	@Override
	public String toString() {
		return "nome=" + this.getNome() 
			   + ", identidade=" + this.getIdentidade()  
			   + ", dtNasc=" + this.getDtNasc();
	}
	
	
	
}
