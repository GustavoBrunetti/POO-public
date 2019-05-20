public class Funcionario extends Pessoa {
	private Data dtAdmissao;
	private double salario;
	
	public Funcionario(String _nome, String _identidade, Data _dtNasc, Data _dtAdmissao, double _salario) {
		super(_nome, _identidade, _dtNasc);
		this.setDtAdmissao(_dtAdmissao);
		this.setSalario(_salario);
	}
	public Funcionario(String _nome, String _identidade, String _dtNascStr, String _dtAdmStr, double _salario) throws Exception {
		super(_nome, _identidade, _dtNascStr);
		this.setDtAdmissao(new Data(_dtAdmStr));
		this.setSalario(_salario);
	}
	public Funcionario(String _nome, String _identidade, int _diaNasc, int _mesNasc, int _anoNasc, int _diaAdm, int _mesAdm, int _anoAdm, double _salario) throws Exception {
		super(_nome, _identidade, _diaNasc, _mesNasc, _anoNasc);
		this.setDtAdmissao(new Data(_diaAdm, _mesAdm, _anoAdm));
		this.setSalario(_salario);
	}
	public Data getDtAdmissao() {
		return this.dtAdmissao;
	}
	public void setDtAdmissao(Data _dtAdmissao) {
		this.dtAdmissao = _dtAdmissao;
	}
	public double getSalario() {
		return this.salario;
	}
	public void setSalario(double _salario) {
		this.salario = _salario;
	}
	public void reajusta(double taxa) {
		this.salario += this.salario * taxa;
	}
	public double calculaMaxEmprestimo() {
		return this.getSalario();
	}
	@Override
	public String toString() {
		return super.toString()
		+ ", dtAdmissao=" + this.getDtAdmissao() 
		+ ", salario=" + this.getSalario();
	}	
}
