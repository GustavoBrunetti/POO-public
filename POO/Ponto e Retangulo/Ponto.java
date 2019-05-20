package ex9e10;

public class Ponto {
	
	public final static double LIMITEINFERIORDEFAULT=0,LIMITESUPERIORDEFAULT=500;
	private static double limiteInf=Ponto.LIMITEINFERIORDEFAULT;
	private static double limiteSup=Ponto.LIMITESUPERIORDEFAULT;
	private double x,y;
	
	public Ponto (String _xy)throws Exception {
		this.setX(_xy);
		this.setY(_xy);
	}
	
	public Ponto(double _x, double _y) throws Exception{
		this.setX(_x);
		this.setY(_y);
	}
	
	public Ponto()throws Exception {
		this.setX(0);
		this.setY(0);
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	public void setX(double _x)throws Exception{
		if(_x>=Ponto.limiteInf && _x<=Ponto.limiteSup)
			this.x=_x;
		else
			throw new Exception ("Fora do limite");
	}
	
	public void setY(double _y)throws Exception{
		if(_y>=Ponto.limiteInf && _y<=Ponto.limiteSup)
			this.y=_y;
		else
			throw new Exception ("Fora do limite");
	}
	
	public void setX(String _xy)throws Exception{
		int i=_xy.indexOf(",");
		double aux;
		aux=Double.parseDouble(_xy.substring(0,i));
		this.x=aux;
	}
	
	public void setY(String _xy)throws Exception{
		int i=_xy.indexOf(",");
		double aux;
		aux=Double.parseDouble(_xy.substring(i+1));
		this.y=aux;
	}
	
	public boolean equals(Ponto _xy) {
		if (this.x==_xy.getX() && this.y==_xy.getY())
			return true;
		else 
			return false;
	}
	public Ponto clona() throws Exception{
		Ponto clone= new Ponto(this.x,this.y);
		return clone;
	}
	public Ponto criaSwap()throws Exception{
		Ponto swap= new Ponto(this.y,this.x);
		return swap;
	}
	//verifica se a coordenada y e/ou x de um objeto chamado no metodo é igual a coordenada y e/ou x de outro objeto passado como argumento
	public boolean temEixoComum(Ponto _xy){
		if (this.x==_xy.getX() || this.y==_xy.getY())
			return true;
		else
			return false;
	}
	//calcula a distancia euclidiana ente um Ponto usado na chamada do metodo e outro passado como objeto
	public double distancia(Ponto _xy) {
		double d= Math.sqrt((this.x-_xy.getX())*(this.x-_xy.getX())+(this.y-_xy.getY())*(this.y-_xy.getY()));
		return d;
	}
	public double distancia(double _x , double _y) {
		double d= Math.sqrt((this.x-_x)*(this.x-_x)+(this.y-_y)*(this.y-_y));
		return d;
	}
	public static double distancia(double _x1 , double _y1 , double _x2 , double _y2) {
		double d= Math.sqrt((_x1-_x2)*(_x1-_x2)+(_y1-_y2)*(_y1-_y2));
		return d;
	}
	public static double distancia(Ponto _xy1 , Ponto _xy2) {
		double d= Math.sqrt((_xy1.getX()-_xy2.getX())*(_xy1.getX()-_xy2.getX())+(_xy1.getY()-_xy2.getY())*(_xy1.getY()-_xy2.getY()));
		return d;
	}
	public double distanciaDaOrigem() {
		return this.distancia(0,0);
	}
	
	public int compareTo(Ponto _xy) {
		if(this.distanciaDaOrigem()>_xy.distanciaDaOrigem())
			return 1;
		else if(this.distanciaDaOrigem()<_xy.distanciaDaOrigem())
			return -1;
		else
			return 0;
	}
	
	public String toString() {
		StringBuilder dados=new StringBuilder();
		dados.append("(");
		dados.append(this.getX());
		dados.append(",");
		dados.append(this.getY());
		dados.append(")");
		return dados.toString();
	}
}
