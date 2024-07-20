package br.com.agenciaconectaapi.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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

    public ServicoDto() {
    }

    public String getNomeContratante() {
        return nomeContratante;
    }
    public void setNomeContratante(String nomeContratante) {
        this.nomeContratante = nomeContratante;
    }

    public Integer getInfluenciadorId() {
        return influenciadorId;
    }
    public void setInfluenciadorId(Integer influenciadorId) {
        this.influenciadorId = influenciadorId;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }
    public void setPorcentagem(BigDecimal porcentagem) {
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

    public boolean isDeclaravel() {
        return declaravel;
    }
    public void setDeclaravel(boolean declaravel) {
        this.declaravel = declaravel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServicoDto that = (ServicoDto) o;

        if (usoImagem != that.usoImagem) return false;
        if (impulsionamento != that.impulsionamento) return false;
        if (exclusividade != that.exclusividade) return false;
        if (declaravel != that.declaravel) return false;
        if (!Objects.equals(nomeContratante, that.nomeContratante))
            return false;
        if (!Objects.equals(influenciadorId, that.influenciadorId))
            return false;
        if (!Objects.equals(celularContratante, that.celularContratante))
            return false;
        if (!Objects.equals(emailContratante, that.emailContratante))
            return false;
        if (!Objects.equals(proposta, that.proposta)) return false;
        if (!Objects.equals(dataInicio, that.dataInicio)) return false;
        if (!Objects.equals(dataFim, that.dataFim)) return false;
        if (!Objects.equals(porcentagem, that.porcentagem)) return false;
        if (!Objects.equals(valor, that.valor)) return false;
        return Objects.equals(descricaoTipoPagamento, that.descricaoTipoPagamento);
    }

    @Override
    public int hashCode() {
        int result = nomeContratante != null ? nomeContratante.hashCode() : 0;
        result = 31 * result + (influenciadorId != null ? influenciadorId.hashCode() : 0);
        result = 31 * result + (celularContratante != null ? celularContratante.hashCode() : 0);
        result = 31 * result + (emailContratante != null ? emailContratante.hashCode() : 0);
        result = 31 * result + (proposta != null ? proposta.hashCode() : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        result = 31 * result + (porcentagem != null ? porcentagem.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (descricaoTipoPagamento != null ? descricaoTipoPagamento.hashCode() : 0);
        result = 31 * result + (usoImagem ? 1 : 0);
        result = 31 * result + (impulsionamento ? 1 : 0);
        result = 31 * result + (exclusividade ? 1 : 0);
        result = 31 * result + (declaravel ? 1 : 0);
        return result;
    }
}
