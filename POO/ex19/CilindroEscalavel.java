package ex19;

public class CilindroEscalavel implements Escalavel,ObjetoTridimensional{
	private Ponto3D ponto;
	private double raio;
	
	public CilindroEscalavel(double x, double y, double z,double r) throws Exception{
		this.ponto = new Ponto3D(x,y,z);
		this.setRaio(r);
	}
	public double getRaio() {
		return this.raio;
	}
	public Ponto3D getPonto() {
		return this.ponto;
	}
	public void setRaio(double r) {
		this.raio = r;
	}
	public double altura() {
		return this.ponto.getZ();
	}
	public Ponto3D centro() throws Exception{
		Ponto3D p = new Ponto3D(this.ponto.getX(),this.ponto.getY(),(this.ponto.getZ())/2);
		return p;
	}
	public double calculaSuperficie() {
		return 2*Math.PI*this.getRaio()*this.ponto.getZ();
	}
	public double calculaVolume() {
		return Math.PI*Math.pow(this.getRaio(),2)*this.ponto.getZ();
	}
	public void amplia(double escala) throws Exception{
		this.setRaio(this.raio*escala);
		this.ponto.setZ(this.ponto.getZ()*escala);
	}
	public void espelha() throws Exception{
		this.ponto.setZ(this.ponto.getZ()*(-1));
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.ponto.toString());
		s.append(" - Raio: ");
		s.append(this.getRaio());
		s.append(" - Altura: ");
		s.append(this.ponto.getZ());
		return s.toString();
	}
}
