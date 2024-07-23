package br.com.agenciaconectaapi.model;

import br.com.agenciaconectaapi.dto.GastoDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GASTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private Boolean fixo;

    public Gasto(GastoDto gastoDto){
        this.descricao = gastoDto.descricao();
        this.fixo = gastoDto.fixo();
        this.data = gastoDto.data();
        this.valor = gastoDto.valor();
    }

}
