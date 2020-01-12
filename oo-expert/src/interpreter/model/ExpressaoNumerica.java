package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

public interface ExpressaoNumerica {

	int avaliar();

	void aceitarVisitante(ExpressaoNumericaVisitor impressora);
}
