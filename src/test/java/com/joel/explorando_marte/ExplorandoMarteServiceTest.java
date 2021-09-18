package com.joel.explorando_marte;

import com.joel.explorando_marte.model.Sonda;
import com.joel.explorando_marte.service.ExplorandoMarteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExplorandoMarteServiceTest {

    String entrada = "1 2 N";
    int posicaoXinicial = 1;
    int posicaoYinicial = 2;
    String direcaoInicial = "N";

    @Before
    public void setup() {
    }

    /*
     * Dada uma linha de entrada com dois inteiros e uma letra, criar uma sonda com essa posição inicial e apontando para a direção.
     * Exemplo de entrada: 1 2 N
     * */

    @Test
    public void criaSondaTest() {

        ExplorandoMarteService explorandoMarteService = new ExplorandoMarteService();
        Sonda sonda = explorandoMarteService.criaSonda(entrada);

        assertEquals(posicaoXinicial, sonda.getPosicaoX());
        assertEquals(posicaoYinicial, sonda.getPosicaoY());
        assertEquals(direcaoInicial, sonda.getDirecao());

    }
}
