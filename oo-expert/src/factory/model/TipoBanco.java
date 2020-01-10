package factory.model;

public enum TipoBanco {
	MYSQL, POSTGRES, ORACLE;

	public static TipoBanco fromString(String tipoBanco) {
		
		if (tipoBanco == null || tipoBanco.isEmpty() || tipoBanco.toUpperCase().equals("MYSQL")) {
			return MYSQL;
		} else if (tipoBanco.toUpperCase().equals("POSTGRES")) {
			return POSTGRES;
		} else if (tipoBanco.toUpperCase().equals("POSTGRES")) {
			return ORACLE;
		} else {
			return MYSQL;
		}
	}
}
