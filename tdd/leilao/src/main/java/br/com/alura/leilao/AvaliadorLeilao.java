package br.com.alura.leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvaliadorLeilao {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    private double media = 0;
    private List<Lance> tresMaiores;

    public void Verificar(final Leilao leilao) {
        this.media = 0;
        double total = 0;
        
        for (final Lance lance : leilao.getLances()) {
            if (lance.getValor() > this.maiorLance) this.maiorLance = lance.getValor();
            if (lance.getValor() < this.menorLance) this.menorLance = lance.getValor();
            total = total + lance.getValor();
        }

        if (total > 0) this.media = total / leilao.getLances().size();
        
        pegarOsTresMaiores(leilao);
    }

    private void pegarOsTresMaiores(final Leilao leilao) {
        this.tresMaiores = new ArrayList<Lance>(leilao.getLances());
        this.tresMaiores.sort((d1, d2) -> Double.compare(d2.getValor(), d1.getValor()));
        this.tresMaiores = this.tresMaiores.subList(0, this.tresMaiores.size() > 3 ? 3 : this.tresMaiores.size());
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

    public List<Lance> getTresMaiores() {
        return Collections.unmodifiableList(tresMaiores);
    }

}