package ex19;

public class RetanguloEscalavel implements ObjetoGeometrico, Escalavel{
	private Ponto pontEsquerdo,pontoDireito;

	public RetanguloEscalavel(double x1, double y1,double x2, double y2) throws Exception{
		Ponto p1 = new Ponto(x1,y1);
		Ponto p2 = new Ponto(x2,y2);
		this.setRetangulo(p1,p2);
	}
	public RetanguloEscalavel()throws Exception{
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();
		this.setRetangulo(p1,p2);
	}
	public Ponto getPontoesquerdo() {
		return this.pontEsquerdo;
	}
	public Ponto getPontodireito() {
		return this.pontoDireito;
	}
	public void setRetangulo(Ponto _pontEsquerdo,Ponto _pontoDireito) {
		this.pontEsquerdo = _pontEsquerdo;
		this.pontoDireito = _pontoDireito;
	}
	public double ladoX(Ponto pontEsquerdo, Ponto pontoDireito) {
		return (Math.abs(pontEsquerdo.getX() - pontoDireito.getX()));
	}
	public double ladoY(Ponto pontEsquerdo, Ponto pontoDireito) {
		return (Math.abs(pontEsquerdo.getY() - pontoDireito.getY()));
	}
	public double calculaArea() {
		return ((ladoX(this.getPontoesquerdo(),this.getPontodireito()))*ladoY(this.getPontoesquerdo(),this.getPontodireito()));
	}
	public double calculaPerimetro() {
		return ((2*ladoX(this.getPontoesquerdo(),this.getPontodireito()) + (2*ladoY(this.getPontoesquerdo(),this.getPontodireito()))));
	}
	public Ponto centro() throws Exception{
		Ponto pc = new Ponto((this.pontEsquerdo.getX() + this.pontoDireito.getX())/2,(this.pontEsquerdo.getY() + this.pontoDireito.getY())/2);
		return pc;
	}
	public void amplia(double escala) throws Exception{
		this.pontEsquerdo.setY(this.pontEsquerdo.getY()*escala);
		this.pontoDireito.setX(this.pontoDireito.getX()*escala);

	}
	public void espelha() throws Exception{
		this.pontEsquerdo = new Ponto(this.pontEsquerdo.getX()*(-1),this.pontEsquerdo.getY());
		this.pontoDireito = new Ponto(this.pontoDireito.getX()*(-1),this.pontoDireito.getY());
	}
	public ObjetoGeometrico clona() throws Exception{
		RetanguloEscalavel r = new RetanguloEscalavel(this.pontEsquerdo.getX(),this.pontEsquerdo.getY(),this.pontoDireito.getX(),this.pontoDireito.getY());
		return r;
	}
	public String toString() {
		StringBuilder aux = new StringBuilder();
		aux.append("Ponto Esquerdo: ");
		aux.append(this.pontEsquerdo.toString());
		aux.append("Ponto direito: ");
		aux.append(this.pontoDireito.toString());
		return aux.toString();
	}
}