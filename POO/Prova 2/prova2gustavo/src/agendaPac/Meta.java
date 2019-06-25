package agendaPac;

@SuppressWarnings("serial")
public class Meta extends ItemAgenda {

		private int prioridade;

		public Meta() throws Exception {
			super();
		}
		
		public Meta(String titulo, String descricao, Periodo periodo, int prioridade) throws Exception {
			super(titulo, descricao, periodo);
			this.setPrioridade(prioridade);
		}
		
		public void setPrioridade(int prioridade) {
				this.prioridade = prioridade;
			}

		public int getPrioridade() {
			return this.prioridade;
		}
		
		public int compareTo(Meta metaaux) {
			if (this.prioridade > metaaux.prioridade) {return 1;}
			else if (this.prioridade == metaaux.prioridade) {return 0;}
			else{return -1;}
		}
		
		public String toString() {
			StringBuilder meta = new StringBuilder();
			meta.append(super.toString());
			meta.append("\nPrioridade: ");
			meta.append(this.getPrioridade());
			return meta.toString();
		}
		
	
	
}
