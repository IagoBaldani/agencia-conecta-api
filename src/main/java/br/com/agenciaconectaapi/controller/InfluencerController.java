package br.com.agenciaconectaapi.controller;

import br.com.agenciaconectaapi.model.Influenciador;
import br.com.agenciaconectaapi.service.InfluenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("influenciador")
public class InfluencerController {

    @Autowired
    private InfluenciadorService influenciadorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarInfluenciadorPorId(@PathVariable(name = "id") Integer id){
        try {
            Influenciador influenciador = influenciadorService.buscarInfluenciadorPorId(id);

            return ResponseEntity.ok(influenciador);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosInfluenciadores(){
        try {
            List<Influenciador> todosInfluenciadores = influenciadorService.buscaTodosInfluenciadores();

            return ResponseEntity.status(HttpStatus.OK).body(todosInfluenciadores);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
