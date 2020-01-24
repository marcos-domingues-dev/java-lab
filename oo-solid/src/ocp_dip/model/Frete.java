package ocp_dip.model;

public class Frete {

    public double para(final String cidade) {
        if (cidade.equals("São Paulo")) {
            return 20;
        } else {
            return 50;
        }
    }

}
