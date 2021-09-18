package com.joel.explorando_marte;

import com.joel.explorando_marte.business.ExplorandoMarteBusiness;
import com.joel.explorando_marte.model.Sonda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExplorandoMarteBusinessTest {

    /*
    * Dado um ponto (x,y) criar uma matriz que vai de (0,0) a (x,y)
    * */
    @Test
    public void criaPlanoMarteTest() {
        int[] pontoSuperiorDireito = {4, 5};
        ExplorandoMarteBusiness explorandoMarteBusiness = new ExplorandoMarteBusiness();
        int[][] matriz = explorandoMarteBusiness.geraMatriz(pontoSuperiorDireito);
    }


}


