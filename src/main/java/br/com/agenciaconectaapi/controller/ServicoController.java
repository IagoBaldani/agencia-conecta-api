package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.service.ServicoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.agenciaconectaapi.util.Constantes.*;

@RestController
@RequestMapping("/api/servico")
@AllArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaServicoPorId(@PathVariable(name = "id") Integer id){
        try{
            Servico servico = servicoService.buscaServicoPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, servico));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaTodosOsServicos(@RequestParam(name = "ativos", required = false) String ativos, @RequestParam(name = "idInfluenciador", required = false) Integer idInfluenciador){
        try{
            List<Servico> servicos = servicoService.buscarTodosServicos(ativos, idInfluenciador);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, servicos));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> cadastrarServico(@Valid @RequestBody ServicoDto servicoDto){
        try{
            Servico servico = servicoService.criarServico(servicoDto);
            RetornoDto retornoDto = new RetornoDto(SERVICO_CRIADO,servico);

            return ResponseEntity.status(HttpStatus.CREATED).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> atualizarStatusServico(@PathVariable(value = "id") Integer id){
        try{
            Servico servico = servicoService.atualizarStatus(id);

            RetornoDto retornoDto = new RetornoDto(SERVICO_COM_STATUS_ALTERADO,servico);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> atualizarServico(@PathVariable(value = "id") Integer id, @RequestBody @Valid ServicoDto servicoDto){
        try{
            Servico servico = servicoService.atualizarServico(id, servicoDto);

            RetornoDto retornoDto = new RetornoDto(SERVICO_ALTERADO,servico);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> deletarServico(@PathVariable(value = "id") Integer id){
        try{
            Servico servico = servicoService.deletarServico(id);

            RetornoDto retornoDto = new RetornoDto(SERVICO_DELETADO,servico);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
}
