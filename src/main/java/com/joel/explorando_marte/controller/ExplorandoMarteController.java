package com.joel.explorando_marte.controller;

import com.joel.explorando_marte.exception.EntradaInvalidaException;
import com.joel.explorando_marte.exception.ForaDeMarteException;
import com.joel.explorando_marte.model.Marte;
import com.joel.explorando_marte.service.ExplorandoMarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/marte")
public class ExplorandoMarteController {

    @Autowired
    ExplorandoMarteService explorandoMarteService;

    @PostMapping("/explorar_marte")
    public ResponseEntity<String> explorarMarte(@RequestBody String entrada){
        try {
            Marte marte = explorandoMarteService.leEntrada(entrada);
            String retorno = explorandoMarteService.executaComandosDasSondas(marte);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }
        catch(EntradaInvalidaException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (ForaDeMarteException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            return new ResponseEntity<>("Erro inesperado, favor verificar as informações enviadas e tentar novamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
