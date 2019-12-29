package modelo;

public class Cnpj implements Documento {

	private String valor;

	public Cnpj(String valor) {
		this.valor = valor;
	}

	public boolean ehValido() {
		return primeiroDigitoVerificadorDoCnpj() == primeiroDigitoCorretoParaCnpj()
				&& segundoDigitoVerificadorDoCnpj() == segundoDigitoCorretoParaCnpj();
	}
	
	@Override
	public String toString() {
		return this.valor;
	}

	public String getValor() {
		return this.valor;
	}

	private int primeiroDigitoCorretoParaCnpj() {
		// Calcula o primeiro dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int primeiroDigitoVerificadorDoCnpj() {
		// Extrai o primeiro dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	private int segundoDigitoCorretoParaCnpj() {
		// Calcula o segundo dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int segundoDigitoVerificadorDoCnpj() {
		// Extrai o segundo dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (!(o instanceof Cnpj)) {
//			return false;
//		}
//		Cnpj outro = (Cnpj) o;		
//		return this.valor.equals(outro.getValor());
//	}
//	
//	@Override
//	public int hashCode() {
//		return this.valor.hashCode();
//	}
	
	// -- Auto generate com "Ctrl + 3" > ghcae
	// -- Generate hashCode() and equals()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cnpj other = (Cnpj) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
