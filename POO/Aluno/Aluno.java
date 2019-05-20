public class Aluno {
  	private String nome;
  	private double nota1, nota2, media, pontos;
  	private final static int LIMITESUP=10;
  	private static int limiteSup=Aluno.LIMITESUP;

  	public Aluno(String _nome,double _nota1,double _nota2,double _pontos) throws Exception {
        	this.setNome(_nome);
        	this.setNotas(_nota1, _nota2, _pontos);
  	}
  	public Aluno(double _nota1, double _nota2, double _pontos) throws Exception {
        	this("sem nome", _nota1, _nota2, _pontos);
  	}
  	public Aluno(double _nota1, double _nota2) throws Exception {
        	this(_nota1, _nota2, 0.0);
  	}
  	public Aluno() throws Exception {
        	this(0.0,0.0);
  	}
 
  	public String getNome() {      	
        	return this.nome;  	
  	}
 	public double getNota1() {
    	return this.nota1; 	
	}
	public double getNota2() {
    	return this.nota2; 	
	}
	public double getMedia() {
    	return this.media; 	
	}

  	public void setNome(String _nome) {
        	this.nome = _nome; 	
  	}
 
  	public double getPontos()  {
        	return this.pontos;	
  	}
  	public void setPontos(double _pontos)throws Exception {
        	this.pontos = _pontos;
        	this.calculaMedia(Aluno.getLimiteSup());
  	}
 
  	public void setNotas(double _nota1, double _nota2,double _pontos)throws Exception {
        	this.pontos = _pontos;
        	if(_nota1>=0  && _nota2>=0 && !Aluno.ultrapassaNota(_nota1,_nota2) ) {
              	this.nota1 = _nota1;
              	this.nota2 = _nota2;
              	this.calculaMedia(Aluno.getLimiteSup());
        	}
        	else
              	throw new Exception("nota invalida");
         	}
  	
  	public void setNotas(double _nota1, double _nota2)throws Exception {
        	this.setNotas(_nota1, _nota2, 0);
  	}
 

  	private double calculaMedia() {
        	this.media = (this.getNota1() + this.getNota2() + this.getPontos())/2;
        	return this.media;
  	}
  	
  	public void setLimiteSup(int _limite)throws Exception {
  		Aluno.limiteSup=_limite;
  	}
  	
  	public static int getLimiteSup() {
  		return Aluno.limiteSup;
  	}
  	
	public static boolean ultrapassaNota(double _nota1,double _nota2) {
  		if (_nota1>Aluno.getLimiteSup() ||_nota2>Aluno.getLimiteSup())
  			return true;
  		else
  			return false;
  	}
  	
  	private double calculaMedia(int _limite)throws Exception {
        	this.calculaMedia();
        	if(this.media > Aluno.getLimiteSup())
              	this.media = Aluno.getLimiteSup();
        	return this.media;
  	}
  	
  
  	
  	public boolean equals(Object objeto) {
    	Aluno aux = (Aluno)objeto;
    	if (this.getNome().equals(aux.getNome()) &&
                	this.getNota1() == aux.getNota1() &&
                	this.getNota2() == aux.getNota2() &&
                	this.getPontos() == aux.getPontos())
          	return true;
    	return false;
	} 

 
  	public String toString(){
        StringBuilder dados = new StringBuilder();
        dados.append("Nome: ");
    	dados.append(this.getNome());
        dados.append("  ");
        dados.append("Nota1: ");
    	dados.append(this.getNota1());
    	dados.append("  ");
    	dados.append("Nota2: ");
    	dados.append(this.getNota2());
    	dados.append("  ");
    	dados.append("Pontos: ");
    	dados.append(this.getPontos());
    	dados.append("  ");
    	dados.append("Media: ");
    	dados.append(this.getMedia());
    	return dados.toString();
     }  

}
