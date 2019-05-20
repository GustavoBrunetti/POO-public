package ex14;

public class Email {
	private String dEmail;
	
	public Email(String _dEmail) throws Exception {
		this.setdEmail(_dEmail);
	}
	
	public Email() {
		this.isEmailValido("@NoEmail");
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String _dEmail) throws Exception {
		if (isEmailValido(_dEmail)) this.dEmail = _dEmail;
		else {
			throw new Exception ("Email Invalido");
		}
	}
	
	public boolean isEmailValido(String _dEmail) {
		if (_dEmail.contains("@")) return true;
		else return false;
	}
	
	
}

