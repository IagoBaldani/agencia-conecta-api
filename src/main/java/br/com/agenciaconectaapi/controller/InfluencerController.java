package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.service.InfluenciadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static br.com.agenciaconectaapi.util.Constantes.*;

@RestController
@RequestMapping("influenciador")
public class InfluencerController {

    private final InfluenciadorService influenciadorService;

    public InfluencerController(InfluenciadorService influenciadorService) {
        this.influenciadorService = influenciadorService;
    }

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
    public ResponseEntity<RetornoDto> criarInfluenciador(@Valid @RequestBody InfluenciadorDto influenciadorDto){
        try {
            Influenciador influenciador = influenciadorService.criarInfluenciador(influenciadorDto);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(INFLUENCIADOR_CRIADO,influenciador));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/lote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> criarInfluenciadoresEmLote(@Valid @RequestBody List<InfluenciadorDto> listInfluenciadorDto){
        try {
            List<Influenciador> influenciadores = influenciadorService.criarInfluenciadoresEmLote(listInfluenciadorDto);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(INFLUENCIADOR_CRIADOS_LOTE, influenciadores));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RetornoDto> excluirInfluenciador(@PathVariable(value = "id") Integer id){
        try {
            Influenciador influenciador = influenciadorService.excluirInfluenciador(id);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(INFLUENCIADOR_DELETADO, influenciador));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RetornoDto> atualizarStatusInfluenciador(@PathVariable(value = "id") Integer id){
        try {
            Influenciador influenciador = influenciadorService.atualizarStatusInfluenciadorPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(INFLUENCIADOR_COM_STATUS_ALTERADO, influenciador));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> atualizarInfluenciador(@RequestBody @Valid InfluenciadorDto influenciadorDto, @PathVariable(value = "id") Integer id){
        try {
            Influenciador influenciador = influenciadorService.atualizarInfluenciador(influenciadorDto, id);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(INFLUENCIADOR_ALTERADO, influenciador));
        }
        catch (Exception e) {
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/cards",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaCardsInformacao(@RequestParam(value = "informacao") String descricaoCardProcurado){
        try{
            HashMap<String, String> map = influenciadorService.buscaInformacaoCards(descricaoCardProcurado);

            return ResponseEntity.status(HttpStatus.OK).body(map);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
}
