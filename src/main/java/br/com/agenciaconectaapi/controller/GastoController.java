package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.dto.GastoDto;
import br.com.agenciaconectaapi.dto.RetornoDto;
import br.com.agenciaconectaapi.dto.ServicoDto;
import br.com.agenciaconectaapi.exception.ExceptionCatcher;
import br.com.agenciaconectaapi.model.Gasto;
import br.com.agenciaconectaapi.model.Servico;
import br.com.agenciaconectaapi.service.GastoService;
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
@RequestMapping("/api/gasto")
@AllArgsConstructor
public class GastoController {

    private final GastoService gastoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaGastoPorId(@PathVariable(name = "id") Integer id){
        try{
            Gasto gasto = gastoService.buscaGastoPorId(id);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, gasto));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> buscaTodosOsGastosPorMesAno(@RequestParam(name = "mes") Integer mes, @RequestParam(name = "ano") Integer ano){
        try{
            List<Gasto> gastos = gastoService.buscarTodosGastosPorMesAno(mes, ano);

            return ResponseEntity.status(HttpStatus.OK).body(new RetornoDto(BUSCA_CONCLUIDA, gastos));
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> cadastrarGasto(@Valid @RequestBody GastoDto gastoDto){
        try{
            Gasto gasto = gastoService.criarGasto(gastoDto);
            RetornoDto retornoDto = new RetornoDto(GASTO_CRIADO, gasto);

            return ResponseEntity.status(HttpStatus.CREATED).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> atualizarGasto(@PathVariable(value = "id") Integer id, @RequestBody @Valid GastoDto gastoDto){
        try{
            Gasto gasto = gastoService.atualizarGasto(id, gastoDto);

            RetornoDto retornoDto = new RetornoDto(GASTO_ALTERADO, gasto);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornoDto> deletarGasto(@PathVariable(value = "id") Integer id){
        try{
            Gasto gasto = gastoService.deletarGasto(id);

            RetornoDto retornoDto = new RetornoDto(GASTO_DELETADO, gasto);

            return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
        }
        catch (Exception e){
            return ExceptionCatcher.collect(e);
        }
    }
}
