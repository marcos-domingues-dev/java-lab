package ocp_dip.model;

public class TabelaDePrecoPadrao implements TabelaDePreco {

    public double descontoPara(final double valor) {
        if (valor >= 200) {
            return 0.05; 
        } else {
            return 0.1;
        }
    }
}
