package agendaPac;

public class Horario {

	private int hora, minuto;
	
	public Horario() throws Exception{
		this(0, 0);
		}
		
	public Horario(String horario) throws Exception {
		this.setHorario( horario);
	}
	
	public Horario(int hora, int minuto) throws Exception{
		this.setHora(hora);
		this.setMinuto(minuto);	
		}
		
	//construtores acima
	
	public void setHora(int hora)throws Exception{
		if (hora < 24 && hora >= 0) {
			this.hora = hora;
		}
		else {
			throw new Exception("horario invalido");
		}
	}
	public void setMinuto(int minuto)throws Exception{
		if (minuto < 60 && minuto >= 0) {
			this.minuto = minuto;
		}
		else {
			throw new Exception("minuto invalido");
		}
	}
	
	public void setHorario(String horario) throws Exception {
		if(horario.contains(":")) {
		   int h, m;
	       int tamanho = horario.length();
	       int index1 = horario.indexOf(":");
	       h= Integer.parseInt(horario.substring(0,index1));
	       m = Integer.parseInt(horario.substring(index1+1,tamanho));
	       this.setHora(h);
	       this.setMinuto(m);
	}
		else {
		throw new Exception("horario invalido");
    	 }
	}
	
	public int getHora() {
		return this.hora;
	}
	
	public int getMinuto() {
		return this.minuto;
	}
	//metodos gets e sets acima
	
	public String toString() {
		StringBuilder horario = new StringBuilder();
		horario.append(this.getHora());
		horario.append(":");
		horario.append(this.getMinuto());
		return horario.toString();
	}
	//toString acima
	
public int compareTo(Horario horario) {
	if (this.getHora() > horario.getHora()) return 1;
	else if (this.getHora() < horario.getHora()) return -1;		
	else if (this.getMinuto() > horario.getMinuto()) return 1;		
	else if (this.getMinuto() < horario.getMinuto()) return -1;		
	else return 0;
	}
}
//compare to
