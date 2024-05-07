package br.com.agenciaconectaapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Servicos")
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
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Integer porcentagem;
    private BigDecimal valor;
    private String descricaoTipoPagamento;
    private boolean usoImagem;
    private boolean impulsionamento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        if (usoImagem != servico.usoImagem) return false;
        if (impulsionamento != servico.impulsionamento) return false;
        if (exclusividade != servico.exclusividade) return false;
        if (!id.equals(servico.id)) return false;
        if (!nomeContratante.equals(servico.nomeContratante)) return false;
        if (!influenciador.equals(servico.influenciador)) return false;
        if (!celularContratante.equals(servico.celularContratante)) return false;
        if (!Objects.equals(emailContratante, servico.emailContratante))
            return false;
        if (!proposta.equals(servico.proposta)) return false;
        if (!dataInicio.equals(servico.dataInicio)) return false;
        if (!dataFim.equals(servico.dataFim)) return false;
        if (!porcentagem.equals(servico.porcentagem)) return false;
        if (!valor.equals(servico.valor)) return false;
        return descricaoTipoPagamento.equals(servico.descricaoTipoPagamento);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nomeContratante.hashCode();
        result = 31 * result + influenciador.hashCode();
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
}
