package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia {
    private Data data;
    private Tempo tempo;

    public DataTempo(Data data, Tempo tempo) {
        data.atualiza(data.getAno(), data.getMes(), data.getDia()); //Garantir que data está atualizada
        tempo.atualiza(tempo.getHora(), tempo.getMinuto()); //Garantir que tempo está atualizado

        this.data = data;
        this.tempo = tempo;
    }

    public Data getData() {
        return data;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public int comoInteiro() {
        int minutos_totais = 0;
        minutos_totais += 24 * 60 * (data.comoInteiro());
        minutos_totais += tempo.comoInteiro();
        return minutos_totais;
    }
}
