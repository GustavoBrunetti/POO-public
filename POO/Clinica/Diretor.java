public class Diretor extends Chefe {
	private Data dtPromocao;

	public Diretor(String _nome, String _identidade, Data _dtNasc, Data _dtAdmissao, double _salario, String _depto, Data _dtPromocao) {
		super(_nome, _identidade, _dtNasc, _dtAdmissao, _salario, _depto);
		this.setDtPromocao(_dtPromocao);
	}
	public Diretor(String _nome, String _identidade, String _dtNascStr, String _dtAdmStr, double _salario, String _depto, String _dtPromoStr) throws Exception {
		super(_nome, _identidade, _dtNascStr, _dtAdmStr, _salario, _depto);
		this.setDtPromocao(new Data(_dtPromoStr));
	}
	public Diretor(String _nome, String _identidade, int _diaNasc, int _mesNasc, int _anoNasc, int _diaAdm, int _mesAdm, int _anoAdm, double _salario, String _depto, int _diaPromo, int _mesPromo, int _anoPromo) throws Exception {
		super(_nome, _identidade, _diaNasc, _mesNasc, _anoNasc, _diaAdm, _mesAdm, _anoAdm, _salario, _depto);
		this.dtPromocao = new Data(_diaPromo, _mesPromo, _anoPromo);
	}
	public Data getDtPromocao() {
		return this.dtPromocao;
	}
	public void setDtPromocao(Data _dtPromocao) {
		this.dtPromocao = _dtPromocao;
	}
	public double calculaMaxEmprestimo() {
		return super.calculaMaxEmprestimo()*1.5;
	}
	@Override
	public String toString() {
		return super.toString() + ", promocao=" + this.getDtPromocao();
	}
}
