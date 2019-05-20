public class Chefe extends Funcionario {
	private String depto;

	public Chefe(String _nome, String _identidade, Data _dtNasc, Data _dtAdmissao, double _salario, String _depto) {
		super(_nome, _identidade, _dtNasc, _dtAdmissao, _salario);
		this.setDepto(_depto);
	}
	public Chefe(String _nome, String _identidade, String _dtNascStr, String _dtAdmStr, double _salario, String _depto) throws Exception {
		super(_nome, _identidade, _dtNascStr, _dtAdmStr, _salario);
		this.setDepto(_depto);
	}
	public Chefe(String _nome, String _identidade, int _diaNasc, int _mesNasc, int _anoNasc, int _diaAdm, int _mesAdm, int _anoAdm, double _salario, String _depto) throws Exception {
		super(_nome, _identidade, _diaNasc, _mesNasc, _anoNasc, _diaAdm, _mesAdm, _anoAdm, _salario);
		this.setDepto(_depto);
	}
	public String getDepto() {
		return this.depto;
	}
	public void setDepto(String _depto) {
		this.depto = _depto;
	}
	public double calculaMaxEmprestimo() {
		return super.calculaMaxEmprestimo()*2;
	}
	@Override
	public String toString() {
		return super.toString()	+ ", depto=" + this.getDepto();
	}


}
