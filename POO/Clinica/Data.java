// codigo fonte da classe Data cedido pelo aluno Yuri
public class Data {
	private int dia, mes, ano;
	
	public Data(int _dia, int _mes, int _ano) throws Exception {
		this.setData(_dia, _mes, _ano);
	}
	public Data(int _dia, String _mesStr, int _ano) throws Exception {
		this.setData(_dia, _mesStr, _ano);
	}
	public Data(String _dtStr) throws Exception {
		this.setData(_dtStr);
	}
	public Data() throws Exception {
		this(1,1,1900);
	}	
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}
	public void setData(int _dia, int _mes, int _ano) throws Exception {
		if(Data.isDataValida(_dia,_mes,_ano)) {
			this.dia = _dia;
			this.mes = _mes;
			this.ano = _ano;
		}else {
			throw new Exception("Data invalida.");
		}
	}
	public void setData(int _dia, String _mesStr, int _ano) throws Exception {
		int mes_int = 0;
		if(_mesStr.equals("janeiro")) _mesStr = "1" ;
		if(_mesStr.contentEquals("fevereiro")) _mesStr = "2" ;
		if(_mesStr.contentEquals("março")) _mesStr = "3";
		if(_mesStr.contentEquals("abril")) _mesStr = "4";
		if(_mesStr.contentEquals("maio")) _mesStr = "5";
		if(_mesStr.contentEquals("junho")) _mesStr = "6";
		if(_mesStr.contentEquals("julho")) _mesStr = "7";
		if(_mesStr.contentEquals("agosto")) _mesStr = "8";
		if(_mesStr.contentEquals("setembro")) _mesStr = "9";
		if(_mesStr.contentEquals("outubro")) _mesStr = "10";
		if(_mesStr.contentEquals("novembro")) _mesStr = "11";
		if(_mesStr.contentEquals("dezembro")) _mesStr = "12";
		mes_int = Integer.parseInt(_mesStr);
		this.setData(_dia, mes_int, _ano);
	}
	public void setData(int _mes, int _ano) throws Exception {
		this.setData(1, _mes, _ano);
	}
	// de uma data completa  no formato String “dd/mm/aaaa”, sendo possível dia e mês com dois ou apenas 1 caractere.  Veja as dicas sobre a classe string a seguir.
	// ERRO: não acusa erro "Data invalida" qdo ano possui dois digitos
	public void setData(String dtStr) throws Exception {
		int _dia;
		int _mes;
		int _ano;
		int cont;
		cont = dtStr.indexOf("/");
		// Formato: "dd	"
		if(cont == 2) {
			_dia = Integer.parseInt(dtStr.substring(0,2));
			cont = dtStr.indexOf("/",3);	
			// Formato: "dd/m/aaaa"
			if(cont == 4) {
				_mes = Integer.parseInt(dtStr.substring(3,4));
				_ano = Integer.parseInt(dtStr.substring(5,9));
			}else {		// Formato: "dd/mm/aaaa"
				_mes = Integer.parseInt(dtStr.substring(3,5));
				_ano = Integer.parseInt(dtStr.substring(6,10));
			}
		// Formato: "d"
		}else {
			_dia = Integer.parseInt(dtStr.substring(0,1));
			cont = dtStr.indexOf("/",2);
			// Formato: "d/m/aaaa"
			if(cont == 3) {
				_mes = Integer.parseInt(dtStr.substring(2,3));
				_ano = Integer.parseInt(dtStr.substring(4,8));
			}else {		// Formato: "d/mm/aaaa"
				_mes = Integer.parseInt(dtStr.substring(2,4));
				_ano = Integer.parseInt(dtStr.substring(5,9));
			}
		}	
		this.setData(_dia,_mes,_ano);
	}
	public boolean equals(Object objeto) {
		Data aux = (Data)objeto;
		if( this.getDia() == (aux.getDia()) &&
				this.getMes() == (aux.getMes()) &&
				this.getAno() == (aux.getAno()) ) {
			return true;
		}
		return false;
	}
	public int compareTo(Data date2) throws Exception {
		if( this.getAno() > date2.getAno() ) {
			return 1;
		}
		if( this.getAno() < date2.getAno() ) {
			return -1;
		}
		else {
			if( this.getMes() > date2.getMes() ) {
				return 1;
			}
			if( this.getMes() < date2.getMes() ) {
				return -1;
			}
			else {
				if(this.getDia() > date2.getDia()) {
					return 1;
				}
				if(this.getDia() < date2.getDia()) {
					return -1;
				}
			}
		}
		return 0;
	}
	public static boolean isDataValida(int d, int m, int a) {
		if(d<1 || d>31) return false;
		
		if(m<1 || m>12) return false;
			
		if(a < 1582) return false;
		
		if((m==4 || m==6 || m==9 || m==11) && (d>30)) return false;
		
		if(m==2 && d>=29) {
			if(d>29) return false;
			if( Data.isBissexto(a) == false ) return false;
		}
		return true;
	}	
	public static boolean isBissexto(int a) {
		if(a%4==0) {
			if(a%100!=0) return true;
			else {
				if(a%400==0) return true;
			}
		}
		return false;
	}
	public boolean isBissexto() {
		if(this.getAno()%4==0) {
			if(this.getAno()%100!=0) return true;
			else {
				if(this.getAno()%400==0) return true;
			}
		}
		return false;
	}
	public void incrementa() {	
		try{
			this.setData(getDia()+1,getMes(),getAno());
		}
		catch(Exception dia){
			try{
				this.setData(1,getMes()+1,getAno());
			}
			catch(Exception mes){
				try {
					this.setData(1,1,getAno()+1);
				}
				catch(Exception ano) {
				}
			}
		}
		return;
	}
	
	// faltou o método:
	// public void incrementa(int n){ ... }	
	
	public static Data verificaECriaData(int d, int m, int a) throws Exception {
		Data data;
		try{
			data = new Data(d,m,a);
		}
		catch(Exception e){
			return null;
		}
		return data;
	}
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getDia());
		dados.append("/");
		dados.append(this.getMes());
		dados.append("/");
		dados.append(this.getAno());
		return dados.toString();
	}	
}