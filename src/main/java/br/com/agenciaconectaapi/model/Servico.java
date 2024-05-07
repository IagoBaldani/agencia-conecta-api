package br.com.agenciaconectaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nomeContratante;
    @ManyToOne
    @JoinColumn(name = "influenciador_id", nullable = false)
    private Influenciador influenciador;
    @NotNull
    private String celularContratante;
    private String emailContratante;
    @NotNull
    private String proposta;
    @NotNull
    private LocalDateTime dataInicio;
    @NotNull
    private LocalDateTime dataFim;
    @NotNull
    private Integer porcentagem;
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

    public Servico() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeContratante() {
        return nomeContratante;
    }
    public void setNomeContratante(String nomeContratante) {
        this.nomeContratante = nomeContratante;
    }

    public Influenciador getInfluenciador() {
        return influenciador;
    }
    public void setInfluenciador(Influenciador influenciador) {
        this.influenciador = influenciador;
    }

    public String getCelularContratante() {
        return celularContratante;
    }
    public void setCelularContratante(String celularContratante) {
        this.celularContratante = celularContratante;
    }

    public String getEmailContratante() {
        return emailContratante;
    }
    public void setEmailContratante(String emailContratante) {
        this.emailContratante = emailContratante;
    }

    public String getProposta() {
        return proposta;
    }
    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Integer getPorcentagem() {
        return porcentagem;
    }
    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricaoTipoPagamento() {
        return descricaoTipoPagamento;
    }
    public void setDescricaoTipoPagamento(String descricaoTipoPagamento) {
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }

    public boolean isUsoImagem() {
        return usoImagem;
    }
    public void setUsoImagem(boolean usoImagem) {
        this.usoImagem = usoImagem;
    }

    public boolean isImpulsionamento() {
        return impulsionamento;
    }
    public void setImpulsionamento(boolean impulsionamento) {
        this.impulsionamento = impulsionamento;
    }

    public boolean isExclusividade() {
        return exclusividade;
    }
    public void setExclusividade(boolean exclusividade) {
        this.exclusividade = exclusividade;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", nomeContratante='" + nomeContratante + '\'' +
                ", influenciador=" + influenciador +
                ", celularContratante='" + celularContratante + '\'' +
                ", emailContratante='" + emailContratante + '\'' +
                ", proposta='" + proposta + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", porcentagem=" + porcentagem +
                ", valor=" + valor +
                ", descricaoTipoPagamento='" + descricaoTipoPagamento + '\'' +
                ", usoImagem=" + usoImagem +
                ", impulsionamento=" + impulsionamento +
                ", exclusividade=" + exclusividade +
                '}';
    }
}
