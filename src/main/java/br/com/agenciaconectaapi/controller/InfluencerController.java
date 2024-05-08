package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.CardInformacao;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.service.InfluenciadorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.agenciaconectaapi.util.Constantes.*;

@RestController
@RequestMapping("influenciador")
public class InfluencerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfluencerController.class);

    @Autowired
    private InfluenciadorService influenciadorService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarInfluenciador(@PathVariable(name = "id") Integer id){
        try {
            Influenciador influenciador = influenciadorService.buscarInfluenciadorPorId(id);

            return ResponseEntity.ok(influenciador);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarTodosInfluenciadores(){
        try {
            List<Influenciador> todosInfluenciadores = influenciadorService.buscaTodosInfluenciadores();

            return ResponseEntity.status(HttpStatus.OK).body(todosInfluenciadores);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> criarInfluenciador(@Valid @RequestBody InfluenciadorDto influenciadorDto){
        try {
            influenciadorService.criarInfluenciador(influenciadorDto);

            return ResponseEntity.status(HttpStatus.OK).body(INFLUENCIADOR_CRIADO);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/lote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> criarInfluenciadoresEmLote(@Valid @RequestBody List<InfluenciadorDto> listInfluenciadorDto){
        try {
            influenciadorService.criarInfluenciadoresEmLote(listInfluenciadorDto);

            return ResponseEntity.status(HttpStatus.OK).body(INFLUENCIADOR_CRIADOS_LOTE);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> excluirInfluenciador(@PathVariable(value = "id") Integer id){
        try {
            influenciadorService.excluirInfluenciador(id);

            return ResponseEntity.status(HttpStatus.OK).body(INFLUENCIADOR_DELETADO);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizarStatusInfluenciador(@PathVariable(value = "id") Integer id){
        try {
            influenciadorService.atualizarStatusInfluenciadorPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(INFLUENCIADOR_COM_STATUS_ALTERADO);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> atualizarInfluenciador(@RequestBody @Valid InfluenciadorDto influenciadorDto, @PathVariable(value = "id") Integer id){
        try {
            influenciadorService.atualizarInfluenciador(influenciadorDto, id);

            return ResponseEntity.status(HttpStatus.OK).body(INFLUENCIADOR_ALTERADO);
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/cards/{cardInformacao}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaCardsInformacao(@PathVariable(name = "cardInformacao") String descricaoCardProcurado){
        try{
            String informacaoBuscada = influenciadorService.buscaInformacaoCards(descricaoCardProcurado);

            return ResponseEntity.status(HttpStatus.OK).body(informacaoBuscada);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
}
