package agendaPac;

@SuppressWarnings("serial")
public class Evento extends ItemAgenda{
	
	private String local;
	
	public Evento() throws Exception {
		super();
	}
	
	public Evento(String titulo, String descricao, Periodo periodo, String local) throws Exception{
		super(titulo, descricao, periodo);
		this.setLocal(local);
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getLocal() {
		return this.local;
	}
	
	public int compareTo(Evento eventoaxu) {
		return (this.getLocal().compareToIgnoreCase(eventoaxu.getLocal()));
	}
	
	public String toString() {
		StringBuilder evento = new StringBuilder();
		evento.append(super.toString());
		evento.append("\nLocal: ");
		evento.append(this.getLocal());	
		return evento.toString();
	}
}
