package br.com.agenciaconectaapi.service;

import br.com.agenciaconectaapi.dto.GastoDto;
import br.com.agenciaconectaapi.exception.RecursoNaoEncontradoException;
import br.com.agenciaconectaapi.model.Gasto;
import br.com.agenciaconectaapi.repository.GastoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.agenciaconectaapi.util.Constantes.NENHUM_GASTO_ENCONTRADO;

@Service
@AllArgsConstructor
public class GastoService {

    private final GastoRepository repository;

    public Gasto buscaGastoPorId(Integer id){
        Optional<Gasto> optionalServico = repository.findById(id);

        return optionalServico.orElseThrow(() ->  new RecursoNaoEncontradoException(NENHUM_GASTO_ENCONTRADO));
    }

    public List<Gasto> buscarTodosGastosPorMesAno(Integer mes, Integer ano){
        List<Gasto> gastosPorMesAno = repository.findGastosPorMesAno(mes, ano);

        if(gastosPorMesAno.isEmpty()){
            throw new RecursoNaoEncontradoException(NENHUM_GASTO_ENCONTRADO);
        }

        return gastosPorMesAno;
    }

    public List<Gasto> buscarTodosGastosFixos(){
        List<Gasto> gastosFixos = repository.findAllFixos();

        if(gastosFixos.isEmpty()){
            throw new RecursoNaoEncontradoException(NENHUM_GASTO_ENCONTRADO);
        }

        return gastosFixos;
    }

    public Gasto criarGasto(GastoDto gastoDto){
        Gasto gasto = new Gasto(gastoDto);

        return repository.save(gasto);
    }

    public Gasto atualizarGasto(Integer id, GastoDto gastoDto){
        Optional<Gasto> optionalGasto = repository.findById(id);

        optionalGasto.orElseThrow(() -> new RecursoNaoEncontradoException(NENHUM_GASTO_ENCONTRADO));

        Gasto gasto = new Gasto(gastoDto);
        gasto.setId(id);

        return repository.save(gasto);
    }

    public Gasto deletarGasto(Integer id){
        Optional<Gasto> optionalGasto = repository.findById(id);

        Gasto gasto = optionalGasto.orElseThrow(() -> new RecursoNaoEncontradoException(NENHUM_GASTO_ENCONTRADO));

        repository.delete(gasto);

        return gasto;
    }
}
