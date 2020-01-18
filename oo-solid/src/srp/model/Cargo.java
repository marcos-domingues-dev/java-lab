package srp.model;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA (new QuinzeOuVinteCincoPorCento()),
    TESTER(new QuinzeOuVinteCincoPorCento());
	
	private RegraParaCalcularSalario regraSalario;

	Cargo(RegraParaCalcularSalario regra) {
		this.regraSalario = regra;
	}
	
	public RegraParaCalcularSalario getRegraSalario() {
		return regraSalario;
	}
}
