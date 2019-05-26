package ex19;

public class Paralelepipedo implements ObjetoTridimensional{
	private Ponto3D pontEsquerdo,pontDireito;
	
	public Paralelepipedo(double x1, double y1,double z1,double x2, double y2,double z2) throws Exception{
		this.pontEsquerdo = new Ponto3D(x1,y1,z1);
		this.pontDireito = new Ponto3D(x2,y2,z2);
		this.setParalelepipedo(pontEsquerdo,pontDireito);
	}
	public Ponto3D getPontoesquerdo() {
		return this.pontEsquerdo;
	}
	public Ponto3D getPontodireito() {
		return this.pontDireito;
	}
	public void setParalelepipedo(Ponto3D p1,Ponto3D p2) {
		this.pontEsquerdo = p1;
		this.pontDireito = p2;
	}
	public double ladoA() {
		return (Math.abs(this.pontEsquerdo.getX() - this.pontDireito.getX()));
	}
	public double ladoB() {
		return (Math.abs(this.pontEsquerdo.getY() - this.pontDireito.getY()));
	}
	public double ladoC() {
		return (Math.abs(this.pontEsquerdo.getZ() - this.pontDireito.getZ()));
	}
	public Ponto3D centro() throws Exception{
		Ponto3D c = new Ponto3D(this.ladoA()/2,this.ladoB()/2,this.ladoC()/2);
		return c;
	}
	public double calculaSuperficie(){
		return (2*(this.ladoA()*this.ladoB() + this.ladoC()*this.ladoB() + this.ladoA()*this.ladoC()));
	}
	public double calculaVolume() {
		return (this.ladoA()*this.ladoB()*this.ladoC());
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.pontEsquerdo.toString());
		s.append(" - ");
		s.append(this.pontDireito.toString());
		s.append(" - ");
		s.append("Lado A: ");
		s.append(this.ladoA());
		s.append("Lado B: ");
		s.append(this.ladoB());
		s.append("Lado C: ");
		s.append(this.ladoC());
		return s.toString();
	}
}