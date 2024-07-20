package br.com.agenciaconectaapi.model;

import br.com.agenciaconectaapi.dto.ServicoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "SERVICOS")
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

    public Servico() {
    }

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

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void mudarStatus(){
        this.ativo = !this.ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        if (usoImagem != servico.usoImagem) return false;
        if (impulsionamento != servico.impulsionamento) return false;
        if (exclusividade != servico.exclusividade) return false;
        if (ativo != servico.ativo) return false;
        if (declaravel != servico.declaravel) return false;
        if (!Objects.equals(id, servico.id)) return false;
        if (!Objects.equals(nomeContratante, servico.nomeContratante))
            return false;
        if (!Objects.equals(influenciador, servico.influenciador))
            return false;
        if (!Objects.equals(celularContratante, servico.celularContratante))
            return false;
        if (!Objects.equals(emailContratante, servico.emailContratante))
            return false;
        if (!Objects.equals(proposta, servico.proposta)) return false;
        if (!Objects.equals(dataInicio, servico.dataInicio)) return false;
        if (!Objects.equals(dataFim, servico.dataFim)) return false;
        if (!Objects.equals(porcentagem, servico.porcentagem)) return false;
        if (!Objects.equals(valor, servico.valor)) return false;
        return Objects.equals(descricaoTipoPagamento, servico.descricaoTipoPagamento);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nomeContratante != null ? nomeContratante.hashCode() : 0);
        result = 31 * result + (influenciador != null ? influenciador.hashCode() : 0);
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
        result = 31 * result + (ativo ? 1 : 0);
        result = 31 * result + (declaravel ? 1 : 0);
        return result;
    }
}
