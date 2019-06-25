package agendaPac;

import java.util.*;

public class Uso {

	private static Scanner leitor;
	
	public static void main(String[] args) {
		try {
			int menu, cadastromenu, OpRelatorio, geral = 0;
			Agenda lista = new Agenda();
			leitor = new Scanner(System.in);	
			do {
				System.out.println("----------------------Agenda----------------------");
				System.out.println("\nDigite \n1- para cadastrar na agenda.\n2- para ver relatorios.\n0- Sair.");
				menu = leitor.nextInt();
				leitor.nextLine();
				if (menu == 1) {
						System.out.print("\nDigite o título: ");
						String titulo = leitor.nextLine();
						System.out.print("\nDigite a descrição: ");
						String descricao = leitor.nextLine();
						System.out.print("\nDigite a data de início: ");
						String dataInicio = leitor.nextLine();
						System.out.print("\nDigite o horário de início: ");
						String horarioInicio = leitor.nextLine();
						System.out.print("\nDigite a data do fim: ");
						String dataFim = leitor.nextLine();
						System.out.print("\nDigite o horário do fim: ");
						String horarioFim = leitor.nextLine();
						System.out.println("\nDigite \n1- para cadastar um evento;\n2-para cadastar um Lembrete;\n3-para cadastar uma Meta.");
					cadastromenu = leitor.nextInt();
					leitor.nextLine();
						if (cadastromenu == 1) {
							System.out.print("Local do evento: ");
							String local = leitor.nextLine();
							Evento evento = new Evento(titulo, descricao, new Periodo(new Data(dataInicio), new Data(dataFim), new Horario(horarioInicio), new Horario(horarioFim)), local);
							lista.insere(evento);}
						if(cadastromenu ==2){
							System.out.print("Quantidade de minutos de antecedencia: ");
							int minAlerta = leitor.nextInt();
							Lembrete lembrete = new Lembrete(titulo, descricao, new Periodo(new Data(dataInicio), new Data(dataFim), new Horario(horarioInicio), new Horario(horarioFim)), minAlerta);
							lista.insere(lembrete);
							}
						if(cadastromenu ==3){
							System.out.print("Prioridade da meta: ");
							int prioridade = leitor.nextInt();
							Meta meta = new Meta(titulo, descricao, new Periodo(new Data(dataInicio), new Data(dataFim), new Horario(horarioInicio), new Horario(horarioFim)), prioridade);
							lista.insere(meta);
						}
				
				}else if(menu == 2) {
						
						System.out.println("\n1)para exibir itens de um itervalo de datas\n2)para ler itens\n3)para ordenar as metas"
								+ "\n4)ordenar lembretes por local para \n5)  para ordenar lembretes por tempo\nO sair");
						OpRelatorio = leitor.nextInt();
						switch (OpRelatorio) {
						case 0: break;
						case 1:
							//Exibe todos os itens agendados e a quantidade de itens em um intervalo de datas
							System.out.println("\nIntervalo de datas");
							System.out.print("Data de inicio: ");
							leitor = new Scanner(System.in);
							String data1 = leitor.nextLine();				
							System.out.print("Data de termino: ");
							leitor = new Scanner(System.in);
							String data2 = leitor.nextLine();
							lista.Intervalodedatas(data1, data2)));
							break;
						case 2:
								System.out.println(lista.toString());
								break;
						case 3:
							lista.ordenaPorPrioridade();//ordena por prioridade
							break;
						case 4:
							lista.ordenaPorLocal();//ordena por local
							break;
						case 5:
							lista.ordenaTempo();//ordena por tempo
							break;
					}
				}
					}while(menu!=0);
			}catch (Exception e) {
				System.out.println(e);
				System.out.println("ERRO");
			}
	}
}