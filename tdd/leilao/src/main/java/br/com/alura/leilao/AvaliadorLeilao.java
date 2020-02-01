package br.com.alura.leilao;

public class AvaliadorLeilao {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    private double media = 0;

    public void Verificar(final Leilao leilao) {
        this.media = 0;
        double total = 0;
        
        for (final Lance lance : leilao.getLances()) {
            if (lance.getValor() > this.maiorLance) {
                this.maiorLance = lance.getValor();
            }
            if (lance.getValor() < this.menorLance) {
                this.menorLance = lance.getValor();
            }
            total = total + lance.getValor();
        }

        if (total > 0) {
            this.media = total / leilao.getLances().size();
        }
    }

    public double getMedia() {
        return media;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

}