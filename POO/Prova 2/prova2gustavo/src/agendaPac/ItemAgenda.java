package agendaPac;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class ItemAgenda implements Serializable {

	
	private String titulo;
	private String descricao;
	private Periodo periodo;

	public ItemAgenda() throws Exception {
		throw new Exception("parametro vazio");
	}
	
	public ItemAgenda(String titulo, String descricao, Periodo periodo) throws Exception {
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setPeriodo(periodo);
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public String toString() {
		StringBuilder item = new StringBuilder();

		item.append("\ntitulo: ");
		item.append(this.getTitulo());
		item.append("\ndescricao: ");
		item.append(this.getDescricao());
		item.append("\nperiodo: ");
		item.append(this.getPeriodo().toString());
		item.append(".");
		return item.toString();
	}
}
