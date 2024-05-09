package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.service.ServicoService;
import br.com.agenciaconectaapi.util.Constantes;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servico")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @RequestMapping(value = "/{ativos}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaTodosOsServicos(@PathVariable(name = "ativos") boolean ativos){
        try{
            List<Servico> servicos = servicoService.buscarTodosServicos(ativos);

            return ResponseEntity.status(HttpStatus.OK).body(servicos);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> cadastrarServico(@Valid @RequestBody ServicoDto servicoDto){
        try{
            Servico servico = servicoService.criarServico(servicoDto);
            RetornoDto retornoDto = new RetornoDto(Constantes.SERVICO_CRIADO,servico);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }



    /*
    @RequestMapping(name = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaServicoPorId(@PathVariable(name = "id") Integer id){
        try{
            Servico servico = servicoService.buscaServicoPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(servico);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
    */

}
