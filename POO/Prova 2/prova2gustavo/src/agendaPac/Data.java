package agendaPac;

public class Data {
	private int dia, mes, ano;

	public Data(int d, int m, int a)throws Exception{
		this.setData (d,m,a);
	}
	public Data(int d, String m, int a)throws Exception{
		this.setData(d, m, a);
	}
	public Data(String s)throws Exception {
		this.setData(s);
	}
	public Data()throws Exception {
		this.setData(1,1,1990);
	}
	
	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAno(){
		return this.ano;
	}	 
	
	public void setData(int d, int m, int a) throws Exception{
		if(isDataValida(d,m,a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new Exception("ERRO");
		}
	}
	
	public void setData(String s)throws Exception{
	       int d, m, a;
	       int tam = s.length();
	       int index1 = s.indexOf("/");
	       int index2 = s.lastIndexOf("/");
	       d= Integer.parseInt(s.substring(0,index1));
	       m = Integer.parseInt(s.substring(index1+1,index2));
	       a = Integer.parseInt(s.substring(index2+1,tam));
	       this.setData(d,m,a);
	   }
	
	public void setData(int dia,String s,int ano)throws Exception {
		int m=0;
		if 		(s.equals("janeiro"))   m=1;		
		else if (s.equals("Fevereiro")) m=2;
		else if (s.equals("Marco")) 	m=3;
		else if (s.equals("Abril")) 	m=4;
		else if (s.equals("Maio"))    	m=5;
		else if (s.equals("Junho"))     m=6;
		else if (s.equals("Julho"))		m=7;
		else if (s.equals("Agosto")) 	m=8;
		else if (s.equals("Setembro"))  m=9;
		else if (s.equals("Outubro")) 	m=10;	
		else if (s.equals("Novembro"))  m=11;
		else if (s.equals("Dezembro")) 	m=12;
		else m=0;
		this.setData(dia,m,ano);
	}
	
	//static, pois nao precisa de um objeto criado
	public static boolean isBisexto(int a) {
		if (a%400==0 || a%4==0 && a%100!=0)
			return true;
		else {return false;}
	}
	
	public void incrementa() throws Exception {
		try {
			this.setData(getDia()+1,getMes(),getAno());
		}
		catch(Exception dia){
			try {
				this.setData(1,getMes()+1,getAno());
			}
			catch(Exception mes) {
				try {
					this.setData(1,1,getAno()+1);
				}
				catch(Exception ano) {
					this.setData(getDia(),getMes(),getAno());
				}
			}
		}
	}
	
	public void incrementa(int dias) throws Exception {
		int j=0;
		while(j!=dias) {
			try {
				this.setData(getDia()+1,getMes(),getAno());
			}
			catch(Exception dia){
				try {
					this.setData(1,getMes()+1,getAno());
				}
				catch(Exception mes) {
					try {
						this.setData(1,1,getAno()+1);
					}
					catch(Exception ano) {
						this.setData(getDia(),getMes(),getAno());
					}
				}
			}
		j++;	
		}
	}
	
	//static, pois nao precisa de um objeto criado
	public static boolean isDataValida(int dia,int mes,int ano) {
		if(dia <= 0 || dia > 31 || mes <= 0 || mes>12 || ano<= 1582)return false;
		else {
			if((mes == 4 || mes == 6 || mes == 9 || mes == 11)&& (dia>=1) && (dia <= 30)) {
				return true;
			}
			if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia>=1) && (dia <= 31)) {
				return true;
			}
			if(mes == 2 )  {
				if(dia == 29) {
					if(Data.isBisexto(ano)) 
						return true;

					else 
						return false;
				}
				if((dia>=1) && (dia <=28)) 
					return true;

				else return false;

			}
		}	
		return true;
	}

	//não e statico pois recebe uma informação de um objeto como argumento/ para tornalo estatico o a informação deveria ser igual para todos os objetos
	public int compareTo(Data dt) {
		if(this.ano>dt.ano) return 1;
		else if(this.ano<dt.ano) return -1;
		else if(this.ano==dt.ano && this.mes>dt.mes)return 1;
		else if(this.ano==dt.ano && this.mes<dt.mes)return -1;
		else if(this.ano==dt.ano && this.mes==dt.mes && this.dia>dt.dia)return 1;
		else if(this.ano==dt.ano && this.mes==dt.mes && this.dia<dt.dia)return -1;
		else return 0;
	}
	
	//Imprime 2 datas ordenadas de formas crescente
		public static void imprimeMenorMaior(Data dt1,Data dt2) {
			if (dt1.compareTo(dt2)==1)
				System.out.println(dt2+" "+dt1);
			else
				System.out.println(dt1+" "+dt2);
		}
	
	public String toString() {
		StringBuilder data = new StringBuilder ();
		data.append(this.getDia());
		data.append("/");
		data.append(this.getMes());
		data.append("/");
		data.append(this.getAno());
		data.append("/");
		return data.toString();	
	}

	public boolean equals (Object objeto) {
		Data aux = (Data) objeto;
		if(aux.getDia() == this.getDia() && aux.getMes() == this.getMes() && aux.getAno() == this.getAno()) {
			return true; } 
	else { return false;}
	}
	
	
}

