package br.edu.insper.desagil.aps5.insee;

public class Tempo extends Referencia {
    private int hora;
    private int minuto;

    public Tempo() {
        this.hora = 0;
        this.minuto = 0;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void atualiza(int hora, int minuto) {
        if (hora < 0) {hora = 0;}
        if (hora > 23) {hora = 23;}

        if (minuto < 0) {minuto = 0;}
        if (minuto > 59) {minuto = 59;}

        this.hora = hora;
        this.minuto = minuto;
    }

    @Override
    public int comoInteiro() {
        int minutos_totais = 0;
        minutos_totais += minuto;
        minutos_totais += hora*60;
        return minutos_totais;
    }
}
