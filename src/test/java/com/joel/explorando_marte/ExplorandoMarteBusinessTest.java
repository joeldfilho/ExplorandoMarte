package com.joel.explorando_marte;

import com.joel.explorando_marte.business.ExplorandoMarteBusiness;
import com.joel.explorando_marte.model.Sonda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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

    /*
    * Dado um plano criado de marte, quando uma Sonda chegar, verificar se a posição da Sonda está dentro da matriz;
    * */

    @Test
    public void verificaSeEstaNaMatriz(){
        int[] pontoSuperiorDireito = {4, 5};
        ExplorandoMarteBusiness explorandoMarteBusiness = new ExplorandoMarteBusiness();
        int[][] matriz = explorandoMarteBusiness.geraMatriz(pontoSuperiorDireito);
        Sonda sonda = new Sonda(1,1,"N");
        assertTrue(explorandoMarteBusiness.sondaEstaDentroDoPlano(sonda, matriz));
    }


    /*
    * Dado uma sonda, na hora de sua criação verifico se ela está dentro do plano
    * */
    @Test
    public void verificaEstaForaDaMatriz(){
        int[] pontoSuperiorDireito = {4, 5};
        ExplorandoMarteBusiness explorandoMarteBusiness = new ExplorandoMarteBusiness();
        int[][] matriz = explorandoMarteBusiness.geraMatriz(pontoSuperiorDireito);
        Sonda sonda = new Sonda(6,6,"N");
        Sonda sonda2 = new Sonda(1,6,"W");
        Sonda sonda3 = new Sonda(6,1,"E");
        Sonda sonda4 = new Sonda(-1,2,"S");
        assertFalse(explorandoMarteBusiness.sondaEstaDentroDoPlano(sonda, matriz));
        assertFalse(explorandoMarteBusiness.sondaEstaDentroDoPlano(sonda2, matriz));
        assertFalse(explorandoMarteBusiness.sondaEstaDentroDoPlano(sonda3, matriz));
        assertFalse(explorandoMarteBusiness.sondaEstaDentroDoPlano(sonda4, matriz));
    }

    /*
    *
    * */

}


