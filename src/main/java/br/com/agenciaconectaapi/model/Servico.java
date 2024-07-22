package br.com.agenciaconectaapi.model;

import br.com.agenciaconectaapi.dto.ServicoDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SERVICOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeContratante;
    @ManyToOne
    @JoinColumn(name = "influenciador_id", nullable = false)
    private Influenciador influenciador;
    private String celularContratante;
    private String emailContratante;
    private String proposta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal porcentagem;
    private BigDecimal valor;
    private String descricaoTipoPagamento;
    private boolean usoImagem;
    private boolean impulsionamento;
    private boolean exclusividade;
    private boolean ativo;
    private boolean declaravel;

    public Servico(ServicoDto servicoDto) {
        this.nomeContratante = servicoDto.getNomeContratante();
        this.celularContratante = servicoDto.getCelularContratante();
        this.emailContratante = servicoDto.getEmailContratante();
        this.proposta = servicoDto.getProposta();
        this.dataInicio = servicoDto.getDataInicio();
        this.dataFim = servicoDto.getDataFim();
        this.porcentagem = servicoDto.getPorcentagem();
        this.valor = servicoDto.getValor();
        this.descricaoTipoPagamento = servicoDto.getDescricaoTipoPagamento();
        this.usoImagem = servicoDto.isUsoImagem();
        this.impulsionamento = servicoDto.isImpulsionamento();
        this.exclusividade = servicoDto.isExclusividade();
        this.declaravel = servicoDto.isDeclaravel();
        this.ativo = true;
    }

    public void mudarStatus(){
        this.ativo = !this.ativo;
    }
}
