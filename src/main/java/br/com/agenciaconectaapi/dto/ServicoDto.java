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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServicoDto that = (ServicoDto) o;

        if (usoImagem != that.usoImagem) return false;
        if (impulsionamento != that.impulsionamento) return false;
        if (exclusividade != that.exclusividade) return false;
        if (!nomeContratante.equals(that.nomeContratante)) return false;
        if (!influenciadorId.equals(that.influenciadorId)) return false;
        if (!celularContratante.equals(that.celularContratante)) return false;
        if (!Objects.equals(emailContratante, that.emailContratante))
            return false;
        if (!proposta.equals(that.proposta)) return false;
        if (!dataInicio.equals(that.dataInicio)) return false;
        if (!dataFim.equals(that.dataFim)) return false;
        if (!porcentagem.equals(that.porcentagem)) return false;
        if (!valor.equals(that.valor)) return false;
        return descricaoTipoPagamento.equals(that.descricaoTipoPagamento);
    }

    @Override
    public int hashCode() {
        int result = nomeContratante.hashCode();
        result = 31 * result + influenciadorId.hashCode();
        result = 31 * result + celularContratante.hashCode();
        result = 31 * result + (emailContratante != null ? emailContratante.hashCode() : 0);
        result = 31 * result + proposta.hashCode();
        result = 31 * result + dataInicio.hashCode();
        result = 31 * result + dataFim.hashCode();
        result = 31 * result + porcentagem.hashCode();
        result = 31 * result + valor.hashCode();
        result = 31 * result + descricaoTipoPagamento.hashCode();
        result = 31 * result + (usoImagem ? 1 : 0);
        result = 31 * result + (impulsionamento ? 1 : 0);
        result = 31 * result + (exclusividade ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServicoDto{" +
                "nomeContratante='" + nomeContratante + '\'' +
                ", influenciadorId=" + influenciadorId +
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
