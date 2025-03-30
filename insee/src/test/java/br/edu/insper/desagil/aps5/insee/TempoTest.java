package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempoTest {
    private Tempo tempo;

    @BeforeEach
    void setUp() {
        tempo = new Tempo();
    }

    @Test
    void constroi() {
        assertEquals(0, tempo.getMinuto());
        assertEquals(0, tempo.getHora());
    }

    @Test
    void naoAtualizaMenor() {
        tempo.atualiza(-1, -1);
        assertEquals(0, tempo.getHora());
        assertEquals(0, tempo.getMinuto());
    }

    @Test
    void atualizaMaior() {
        tempo.atualiza(24, 60);
        assertEquals(23, tempo.getHora());
        assertEquals(59, tempo.getMinuto());
    }

    @Test
    void comoAgora() {
        tempo.atualiza(15, 30);
        assertEquals(930, tempo.comoInteiro());
    }
}
