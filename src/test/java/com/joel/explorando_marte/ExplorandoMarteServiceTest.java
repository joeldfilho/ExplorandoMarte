package com.joel.explorando_marte;

import com.joel.explorando_marte.business.ExplorandoMarteBusiness;
import com.joel.explorando_marte.model.Marte;
import com.joel.explorando_marte.model.Sonda;
import com.joel.explorando_marte.service.ExplorandoMarteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExplorandoMarteServiceTest {

    String entrada = "1 2 N";
    int posicaoXinicial = 1;
    int posicaoYinicial = 2;
    String direcaoInicial = "N";

    @Mock
    ExplorandoMarteBusiness explorandoMarteBusiness;

    @InjectMocks
    ExplorandoMarteService explorandoMarteService;

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


    /*
     * Dada uma direção para virar e uma sonda, a direção final deve ser alterada segundo a direção informada para virar
     */
    @Test
    public void alteraDirecaoTest(){
        ExplorandoMarteService explorandoMarteService = new ExplorandoMarteService();

        Sonda sonda = explorandoMarteService.criaSonda(entrada);
        String comando = "L";
        explorandoMarteService.mudaDirecao(comando, sonda);
        assertEquals("W", sonda.getDirecao());
    }

    /*
    * Dado um comando de mover, devo alterar a posição da sonda.
    * */

    @Test
    public void moveSondaTest(){
        ExplorandoMarteService explorandoMarteService = new ExplorandoMarteService();

        Sonda sonda = explorandoMarteService.criaSonda(entrada);
        explorandoMarteService.moveSonda(sonda);
        assertEquals(posicaoYinicial + 1, sonda.getPosicaoY());
    }

    /*
    * Dada a entrada, devo ler e gerar as sondas nas suas posições iniciais e o terreno
    * */

    @Test
    public void geraObjetos(){
        String entrada = "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM";

        when(explorandoMarteBusiness.geraMatriz(any())).thenCallRealMethod();
        Marte marte = explorandoMarteService.leEntrada(entrada);
    }

}
