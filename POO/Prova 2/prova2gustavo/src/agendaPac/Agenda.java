package agendaPac;

	import java.util.*;
	import java.io.*;
	
	@SuppressWarnings("serial")
	public class Agenda implements Serializable {

		private List <ItemAgenda>
		agenda = new LinkedList<ItemAgenda>();
			
		//construtores 
		
		public void insere(Evento evento) throws Exception {
			agenda.add(evento);}
		
		public void insere(Lembrete lembrete) throws Exception  {
			agenda.add(lembrete);}
	
		public void insere(Meta meta) throws Exception  {
			agenda.add(meta);}

		public List <ItemAgenda> getAgenda() {
			return this.agenda;
		}
		
		//metodos para ordenar
		
		// ordena pela prioridade
		public void ordenaPorPrioridade() {
			StringBuilder m = new StringBuilder();
			Collections.sort(this.agenda, new ComparaPrioridade());
			
			for (int i = 0; i < this.getAgenda().size(); i++) {
				if (this.getAgenda().get(i).getClass() == Meta.class) {
					m.append(this.getAgenda().get(i));
				}
			}
			System.out.println(m.toString());
		}
		
		// ordena pelo tempo
		public void ordenaTempo() {
			StringBuilder l = new StringBuilder();
			Collections.sort(this.agenda, new ComparaminAlerta());
			
			for (int i = 0; i < this.getAgenda().size(); i++) {
				if (this.getAgenda().get(i).getClass() == Lembrete.class) {
					l.append(this.getAgenda().get(i));
				}
			}
			System.out.println(l.toString());
		}
		
		 // ordena pelo local do evento e imprime
		public void ordenaPorLocal() {
			StringBuilder evento = new StringBuilder();
			Collections.sort(this.agenda, new ComparaLocal());
			
			for (int i = 0; i < this.getAgenda().size(); i++) {
				if (this.getAgenda().get(i).getClass() == Evento.class) {
					evento.append(this.getAgenda().get(i));
				}
			}
			System.out.println(evento.toString());
		}
		
		//Metodo exibido em um intervalo de datas
		public String Intervalodedatas(Data data1, Data data2) throws Exception {
			if (data1.compareTo(data2) <= 0) {
				StringBuilder intervalo = new StringBuilder();
				for (int i = 0; i < this.agenda.size(); i++) {
					if ((agenda.get(i).getPeriodo().getdataInicial().compareTo(data1) >= 0) && (agenda.get(i).getPeriodo().getdataInicial().compareTo(data2)) <= 0) {
						intervalo.append(agenda.get(i));
					}
				}
				return intervalo.toString();
			}
			else {
				throw new Exception("Intervalo invalido!");
			}
		}
		
		//grava a agenda em arquivo
		public static void gravaAgenda(String nomeArquivo, Object agenda) throws FileNotFoundException, IOException {
			ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			arquivo.writeObject(agenda);
			arquivo.flush();
			arquivo.close();}

		//le o arquivo gravado
		public static Agenda leAgenda(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
			ObjectInputStream arquivo = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Agenda agenda = (Agenda) arquivo.readObject();
			arquivo.close();
			return agenda;}
		
		//metodo toString para retornar todos os valores
		public String toString() {
			StringBuilder List = new StringBuilder();
			for (int i = 0; i < this.agenda.size(); i++)
				List.append(this.agenda.get(i) + " ");
			return List.toString();
		}

	}
		
	class ComparaLocal implements Comparator<ItemAgenda> {
		public int compare(ItemAgenda compaux1, ItemAgenda compaux2) {
			Evento evento1 = (Evento) compaux1;
			Evento evento2 = (Evento) compaux2;
			return evento1.getLocal().compareToIgnoreCase(evento2.getLocal());
		}
	}
		
		class ComparaminAlerta implements Comparator<ItemAgenda> {
			public int compare(ItemAgenda lembreteaux1, ItemAgenda lembreteaux2) {
				Lembrete lembrete1 = (Lembrete) lembreteaux1;
				Lembrete lembrete2 = (Lembrete) lembreteaux2;
				return lembrete1.compareTo(lembrete2);
			}
		}

		class ComparaPrioridade implements Comparator<ItemAgenda> {
			public int compare(ItemAgenda aux1, ItemAgenda aux2) {
				Meta meta1 = (Meta) aux1;
				Meta meta2 = (Meta) aux2;
				return meta1.compareTo(meta2);
		}
		
	
	}
	