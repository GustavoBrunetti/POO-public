import java.util.Scanner;

public class Conta {
	private String nome;
	private double saldo;
	private final static double taxaInicial=0.3;
	private static double taxa= Conta.taxaInicial;
	private Scanner scanner2;
	private Scanner scanner;
	
	//construtores
	public Conta(String _nome,double _saldo) throws Exception{
		this.setNome(_nome);
		this.setSaldo(_saldo);
	}
	public Conta() throws Exception{
		this.setDigita();
	}
	
	//metodos interface get
	public String getNome() {
		return this.nome;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public double getTaxa() {
		return Conta.taxa;
	}
	
	//metodos interface set
	public void setNome(String _nome) {
		this.nome=_nome;
	}
	public void setSaldo(double _saldo)throws Exception{
		if(_saldo>0)
			this.saldo=_saldo;
		else
			throw new Exception ("Saldo invalido");
	}
	public static void setTaxa(double _taxa) {
		Conta.taxa=_taxa;
	}
	
	//set usuario digita
	public void setDigita() throws Exception{
		
		System.out.println("Digite o nome:");
		scanner = new Scanner(System.in);
		String _nome = scanner.nextLine();
		System.out.println("Digite o saldo:");
		scanner2 = new Scanner(System.in);
		double _saldo = scanner2.nextDouble();	
		this.setNome(_nome);
		this.setSaldo(_saldo);
	}
	
	// compara >, <, ==
	public int compareTo(Conta cont) {
		if(this.saldo>cont.getSaldo())
			return 1;
		else if (this.saldo<cont.getSaldo()) 
			return -1;
		return 0;
	}
	public boolean equals (Object objeto) {
		Conta aux=(Conta)objeto;
		if(this.getSaldo()==aux.getSaldo()&&this.getNome().equals(aux.getNome()))
			return true;
		return false;
	}
	
	//correcao de saldo a partir da taxa de juros
	public void corrige()throws Exception {
		double saldoCorrigido;
		saldoCorrigido=this.getSaldo()-(this.getSaldo()*Conta.taxa);
		this.setSaldo(saldoCorrigido);
	}
	
	
	
	
	public String toString() {
		StringBuilder dados=new StringBuilder();
		dados.append(this.getNome());
		dados.append(": ");
		dados.append(this.getSaldo());
		return dados.toString();
	}
	
}