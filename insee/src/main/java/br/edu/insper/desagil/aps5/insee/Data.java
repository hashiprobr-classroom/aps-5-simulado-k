package br.edu.insper.desagil.aps5.insee;

import java.util.HashMap;
import java.util.Map;

public class Data extends Referencia{
    private int ano;
    private int mes;
    private int dia;
    private Map<Integer, Integer> limites;

    public Data() {
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        limites = new HashMap<>();

        limites.put(1, 31);
        limites.put(2, 28);
        limites.put(3, 31);
        limites.put(4, 30);
        limites.put(5, 31);
        limites.put(6, 30);
        limites.put(7, 31);
        limites.put(8, 31);
        limites.put(9, 30);
        limites.put(10, 31);
        limites.put(11, 30);
        limites.put(12, 31);
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public void atualiza(int a, int m, int d) {
        this.ano = a;
        this.mes = m;
        this.dia = d;

        if (ano < 1970) {
            this.ano = 1970;
        }
        if (mes < 1) {
            this.mes = 1;
        }
        if (mes > 12) {
            this.mes = 12;
        }
        if (dia < 1) {
            this.dia = 1;
        }
        for (int mes_atual : limites.keySet()) {
            if (mes == mes_atual) {
                int dias_atual = limites.get(mes_atual);
                if (dia > dias_atual) {
                    this.dia = dias_atual;
                }
            }
        }
    }

    @Override
    public int comoInteiro() {
        int dias_passados = 0;
        for (int m: limites.keySet()) {
            if (mes == m) {
                dias_passados += dia - 1;
            }
            else if (mes > m) {
                dias_passados += limites.get(m);
            }
        }
        if (ano != 1970) {
            dias_passados += (ano - 1970)*365;
        }
        return dias_passados;
    }
}
