import lejos.utility.Delay;
import java.lang.Math; 

public class VeiculoSmart extends Veiculo {

	float[] caminho = new float[3];
	float auxgraudir,auxgrauesq,a,b,Alfa,C,Beta,CosBeta;
	int passouEsquerda=0;
	//construtor cria o objeto carro e zera o vetor caminho
	public VeiculoSmart(boolean toque, boolean corDir, boolean corEsq, boolean sensoInfra) {
		super(toque, corDir, corEsq, sensoInfra);
		for (int t = 0; t < 3; t++) { caminho[t] = 0;}
	}

	// enquanto os dois sensores estiverem brancos, liga motores ate achar preto em um dos sensores
	public void achaLinha() {
		this.resetTacometro();
		this.abreGarra();
		Delay.msDelay(500);
		this.fechaGarra();
		this.setVelocidadeEsteirasGrau(240);
		this.setEsteirasForward();
		while (!this.isPreto("esquerdo") && !this.isPreto("direito"));
		this.stop();
		caminho[0] = this.mediaTacometro();
		this.resetTacometro();
		this.ev3.beep3();
		this.ajustaLinha();
	}

	public void ajustaLinha() {
		this.ligaSincronizacaoEsteiras();

		// ajusta direito para o preto 
		if (!this.isPreto("direito") && this.isPreto("esquerdo")) {
			this.curvaEsquerda();
			while (!this.isPreto("direito") && this.isPreto("esquerdo") );
			this.stop();
			this.auxgraudir=this.dir.getTacometro();//armazera o grua de acerto para linha em uma variavel aux;
			this.auxgraudir=this.calculaAngulo(0);//chama calcula angulo, q me retorna o calculo do angulo em angulo de esteira
			this.auxgrauesq=180-this.auxgraudir;
			this.resetTacometro();
			this.ligaSincronizacaoEsteiras();
			this.ev3.beep3();
			this.setEsteirasForward();// liga esteira ate achar branco em um dos sensores apos achar gira 90 graus para esquerda ate achar preto preto
			while (this.isPreto("direito") || this.isPreto("esquerdo"));
			this.ev3.beep3();
			this.dir.ligaFrente();
			this.esq.ligaTras();
			while (!this.isPreto("direito"));
			this.resetTacometro();
		}


		// ajusta esquerdo para preto
		else if (this.isPreto("direito") && !this.isPreto("esquerdo")) {
			this.curvaDireita();
			while (!this.isPreto("esquerdo")&& this.isPreto("direito"));
			this.stop();
			this.auxgrauesq=this.esq.getTacometro();//armazera o grua de acerto para linha em uma variavel aux;
			this.auxgrauesq=this.calculaAngulo(1);//chama calcula angulo, q me retorna o calculo do angulo em angulo de esteira
			this.auxgraudir=180-this.auxgrauesq;
			this.resetTacometro();
			this.ev3.beep3();
			this.ligaSincronizacaoEsteiras();
			this.ev3.beep3();
			this.setEsteirasForward();// liga esteira ate achar branco em um dos sensores apos achar gira 90 graus para esquerda ate achar preto preto
			while (this.isPreto("direito") || this.isPreto("esquerdo"));
			this.dir.ligaFrente();
			this.esq.ligaTras();
			while (!this.isPreto("direito"));
			this.resetTacometro();
		}
		else if(this.isPreto("esquerdo") && this.isPreto("direito")) {
			this.auxgraudir=90;
			this.auxgrauesq=90;
		}
		this.stop();
		this.resetTacometro();
		this.ligaSincronizacaoEsteiras();
	}

	public void segueLinha() {
		this.setEsteirasForward();// enquanto os dois sensores estiverem preto, segue linha
		while (this.isPreto("direito") && this.isPreto("esquerdo") && this.getDistancia()>6 );
		//quando um sensor sair ele corrige ate ele voltar pro preto e chama o metodo de novo
		if (!this.isPreto("esquerdo") && this.isPreto("direito")) {
			this.curvaDireita();
			while (!this.isPreto("esquerdo") && this.isPreto("direito"));
			this.segueLinha();
		}
		else if (this.isPreto("esquerdo") && !this.isPreto("direito")) {
			this.curvaEsquerda();
			while (!this.isPreto("direito") && this.isPreto("esquerdo"));
			this.segueLinha();
		}
		//chama o metodo detectabola, caso ele não detecte a bola e os sensores estão no branco ele gira 180 graus armazena o valor do tacometro no vetor e chama o metodo segue linha de novo
		else if(!this.detectaBola() && !this.isPreto("esquerdo") && !this.isPreto("direito")){
			passouEsquerda++;
			caminho[1]=this.mediaTacometro();
			this.stop();
			this.setEsteirasForward();
			Delay.msDelay(500);
			this.stop();
			this.dir.ligaFrente();
			this.esq.ligaTras();
			while (!this.isPreto("direito") || !this.isPreto("esquerdo"));
			this.resetTacometro();
			this.segueLinha();
		}
		//caso ele ache a bola ele armazera o valor do tacometro no vetor chama o metodo calculacaminho , pega bola, e o volta ao ponto de origem
		else if(this.detectaBola()) {
			caminho[2]=this.mediaTacometro();
			b=calculaCaminho();
			this.pegaBola();
			this.voltaAoPontoDeOrigem();
		}
	}

	public boolean detectaBola() {
		if (this.getDistancia() < 6) {
			return true;
		}
		return false;
	}

	public void pegaBola() {
		this.abreGarra();
		this.setVelocidadeEsteirasGrau(200);
		this.setEsteirasForward(1);
		Delay.msDelay(500);
		this.fechaGarra();
	}

	public void resetTacometro() {
		this.dir.resetTacometro();
		this.esq.resetTacometro();
	}

	public float mediaTacometro() {
		return ((this.dir.getTacometro()+this.esq.getTacometro())/2);
	}

	public float calculaCaminho() {
		return (caminho[2]-caminho[1]);
	}
	
	//recebo o angulo de concerto e converte em angulo de esteira 
	public float calculaAngulo(int x) {
		auxgrauesq=(auxgrauesq/10.7f);
		auxgraudir=(auxgraudir/10.7f);
		if(x==0) {return auxgraudir;}
		else{return auxgrauesq;}
	}
	/*metodo calculador a função do triangulo usando lei dos cossenos, usando o valor armazenado no vetor conseguimos a,b
	e com o angulo de entrada conseguimos o alfa, apos isso achamos o C(distancia para voltar), apos isso manipulando a lei dos cossenos
	e isolando o cos de beta(angulo de volta), para ssim convertemos o angulo do triangulo em angulo de esteira de volta, e conseguirmos usar 
	no metodo volta ao ponto de origem
	
	*/
	public void calculaGeral(int verifica) {

		a=caminho[0];

		if(verifica == 0) {
			Alfa=this.auxgrauesq;
		}
		else {
			Alfa=this.auxgraudir;
		}
		Alfa=(float)(Math.cos(Alfa));
		C=(float)(Math.sqrt((a*a)+(b*b)-2*(a*b*Alfa)));
		CosBeta=(-(a*a)+(b*b)+(C*C))/(2*b*C);

		Beta=(float)Math.acos(CosBeta);
		Beta=180-Beta;
		Beta=Beta*10.7f;
		Beta=Beta/240;
		//C=C*10.7f;
		C=C/260;
		System.out.println(C);
	}
	//larga bola
	public void largaBola() {
		this.abreGarra();	
	}
	// apos pegar se passou pela a esquerda ou não entra no if para a situação onde muda a direção 
	//para onde ele vai voltar e o angulo q vai ter q ser pego para voltar
	public void voltaAoPontoDeOrigem() {
		//voltar pela esquerda
		this.setVelocidadeEsteirasGrau(240);
		if(passouEsquerda==0) {
			this.calculaGeral(0);
			this.curvaEsquerda((int)Beta+1);
			System.out.println(C);
			this.stop();
			this.ligaSincronizacaoEsteiras();
			this.setEsteirasForward((int) C );
			this.stop();
			this.ev3.beep2();
			this.largaBola();
		}
		//voltar pela direita
		else if(passouEsquerda==1) {
			this.calculaGeral(1);
			this.curvaDireita((int)Beta+1);
			this.stop();
			System.out.println(C);
			this.ligaSincronizacaoEsteiras();
			this.setEsteirasForward((int)C);
			this.stop();
			this.ev3.beep1();
			this.largaBola();
		}

	}
}
