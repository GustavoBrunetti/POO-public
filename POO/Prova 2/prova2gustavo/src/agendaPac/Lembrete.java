package agendaPac;

@SuppressWarnings("serial")
public class Lembrete extends ItemAgenda {
	
	private int minAlerta;
	
	public Lembrete() throws Exception {
		super();
	}
	
	public Lembrete(String titulo, String descricao, Periodo periodo, int minAlerta) throws Exception{
		super(titulo, descricao, periodo);
		this.setminAlerta(minAlerta);
	}
	
	public void setminAlerta(int minAlerta) throws Exception {
		if (minAlerta >= 0) {
			this.minAlerta = minAlerta;
		}
		else 
			throw new Exception("minAlerta Errado.");
	}
	public int getminAlerta() {
		return this.minAlerta;
	}
	
	public int compareTo(Lembrete lembreteaux) {
		if(this.getminAlerta() > lembreteaux.getminAlerta())
			return 1;
		else if(this.getminAlerta() == lembreteaux.getminAlerta())
			return 0;
		return -1;
	}
	
	public String toString() {
		StringBuilder lembrete = new StringBuilder();
		lembrete.append(super.toString());
		lembrete.append("\nMinutos para Alerta: ");
		lembrete.append(this.getminAlerta());
		return lembrete.toString();
	}
}
