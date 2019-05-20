package ex9e10;

//ponto faz parte do retangulo, portanto eh uma relação de agregassão
public class Retangulo {
	//campos
	private Ponto p1,p2;
	
	//construtores
	public Retangulo(Ponto _p1, Ponto _p2)throws Exception {
		this.setP1(_p1);
		this.setP2(_p2);
	}
	public Retangulo(double x1, double y1, double x2, double y2) throws Exception{
		this.setP1(x1,y1);
		this.setP2(x2,y2);
	}
	public Retangulo()throws Exception {
		this (0,0,0,0);
	}
	
	//metodos interface get
	
	public Ponto getP1() {
		return this.p1;
	}
	public Ponto getP2() {
		return this.p2;
	}
	
	//metodos interface set
	
	//modifica a classe Ponto passada como argumento
	public void setP1(Ponto _p1) throws Exception{
		this.p1=_p1;
	}
	
	public void setP2(Ponto _p2) throws Exception{
		this.p2=_p2;
	}
	
	//cria novos Pontos a partir de coordenadas
	public void setP1(double x1, double y1) throws Exception{
		Ponto _p1=new Ponto(x1,y1);
		this.setP1(_p1);
	}
	public void setP2(double x2, double y2) throws Exception{
		Ponto _p2=new Ponto(x2,y2);
		this.setP2(_p2);
	}
	
	//calculo de valores geometricos
	
	//calcula largura, lado x
	public double larguraX() {
		double comp;
		comp= this.p2.getX()-this.p1.getX();
		return comp;
	}
	//calcula altura, lado y
	public double aulturaY() {
		double comp;
		comp= this.p1.getY()-this.p2.getY();
		return comp;
	}
	//calcula area do retangulo
	public double area() {
		double area;
		area=this.aulturaY() * this.larguraX();
		return area;
	}
	//calcula perimetro do retangulo
	public double perimetro() {
		double peri;
		peri=this.aulturaY()*2 + this.larguraX()*2;
		return peri;
	}
	
	//comparacoes entre 2 retangulos
	
	//verifica se dois retangulos possuem as mesmas coordenadas
	public boolean equals(Retangulo _r) {
		if(this.p1.equals(_r.getP1()) && this.p2.equals(_r.getP2()))
			return true;
		else 
			return false;
	}
	//verifica se dois retangulos possuem o msm valor de area
	public boolean equalsArea(Retangulo _r) {
		if(this.area()==_r.area())
			return true;
		else 
			return false;
	}
	//verifica se o retangulo da chamada é maior ou menor que o retornando passado como argumento, retorna 1 se for maior, -1 se for menor e 0 se forem iguais
	public int compareTo(Retangulo _r) {
		if(this.area()>_r.area())
			return 1;
		else if(this.area()>_r.area())
			return -1;
		else return 0;
	}
	 
	
	
	
	
	//usa o toString  da clase Ponto, printa "(x1,y1)-(x2,y2)"

	public String toString() {
		StringBuilder dados =new StringBuilder();
		dados.append(this.getP1());
		dados.append("-");
		dados.append(this.getP2());
	  	return dados.toString();
	   }


}