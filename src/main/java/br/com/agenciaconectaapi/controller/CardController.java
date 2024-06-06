package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.CardFinancas;
import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static br.com.agenciaconectaapi.util.Constantes.BUSCA_CONCLUIDA;

@RestController
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(value =  "/financa/totais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaCardsFinancas(@RequestParam(name = "mes") Integer mes, @RequestParam(name = "ano") Integer ano){
        try{
            HashMap<String, BigDecimal> map = cardService.buscaInformacaoCardsFinancas(mes, ano);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, map));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value =  "/financa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaCardsFinancasDescricao(@RequestParam(name = "mes") Integer mes, @RequestParam(name = "ano") Integer ano){
        try{
            List<CardFinancas> cardsFinancas = cardService.buscaCardsFinancas(mes, ano);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, cardsFinancas));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/influenciador",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaCardsInformacao(){
        try{
            HashMap<String, String> map = cardService.buscaInformacaoCardsInfluenciador();

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, map));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
}
