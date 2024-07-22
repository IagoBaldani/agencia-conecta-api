package br.com.agenciaconectaapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ServicoDto {

    @NotNull
    private String nomeContratante;
    @NotNull
    private Integer influenciadorId;
    @NotNull
    private String celularContratante;
    private String emailContratante;
    @NotNull
    private String proposta;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataFim;
    @NotNull
    private BigDecimal porcentagem;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private String descricaoTipoPagamento;
    @NotNull
    private boolean usoImagem;
    @NotNull
    private boolean impulsionamento;
    @NotNull
    private boolean exclusividade;
    @NotNull
    private boolean declaravel;
}
