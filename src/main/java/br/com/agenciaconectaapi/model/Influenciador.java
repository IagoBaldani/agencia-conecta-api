package br.com.agenciaconectaapi.model;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="INFLUENCIADORES")
public class Influenciador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String celular;
    private String cidadeEstado;
    private String email;
    private String endereco;
    private LocalDate dataAssinaturaContrato;
    private LocalDate dataVencimentoContrato;
    private LocalDate dataNascimento;
    private String instagram;
    private String tiktok;
    private String youtube;
    private boolean ativo;

    public Influenciador() {
    }

    public Influenciador(InfluenciadorDto influenciadorDto){
        this.nome = influenciadorDto.getNome();
        this.cpf = influenciadorDto.getCpf();
        this.celular = influenciadorDto.getCelular();
        this.cidadeEstado = influenciadorDto.getCidadeEstado();
        this.email = influenciadorDto.getEmail();
        this.endereco = influenciadorDto.getEndereco();
        this.dataAssinaturaContrato = influenciadorDto.getDataAssinaturaContrato();
        this.dataVencimentoContrato = influenciadorDto.getDataVencimentoContrato();
        this.dataNascimento = influenciadorDto.getDataNascimento();
        this.instagram = influenciadorDto.getInstagram();
        this.tiktok = influenciadorDto.getTiktok();
        this.youtube = influenciadorDto.getYoutube();
        this.ativo = true;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCidadeEstado() {
        return cidadeEstado;
    }
    public void setCidadeEstado(String cidadeEstado) {
        this.cidadeEstado = cidadeEstado;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataAssinaturaContrato() {
        return dataAssinaturaContrato;
    }
    public void setDataAssinaturaContrato(LocalDate dataAssinaturaContrato) {
        this.dataAssinaturaContrato = dataAssinaturaContrato;
    }

    public LocalDate getDataVencimentoContrato() {
        return dataVencimentoContrato;
    }
    public void setDataVencimentoContrato(LocalDate dataVencimentoContrato) {
        this.dataVencimentoContrato = dataVencimentoContrato;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getInstagram() {
        return instagram;
    }
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTiktok() {
        return tiktok;
    }
    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }

    public String getYoutube() {
        return youtube;
    }
    public void setYoutube(String youtube) {
        this.youtube = youtube;
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

        Influenciador that = (Influenciador) o;

        if (ativo != that.ativo) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(cpf, that.cpf)) return false;
        if (!Objects.equals(celular, that.celular)) return false;
        if (!Objects.equals(cidadeEstado, that.cidadeEstado)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(endereco, that.endereco)) return false;
        if (!Objects.equals(dataAssinaturaContrato, that.dataAssinaturaContrato))
            return false;
        if (!Objects.equals(dataVencimentoContrato, that.dataVencimentoContrato))
            return false;
        if (!Objects.equals(dataNascimento, that.dataNascimento))
            return false;
        if (!Objects.equals(instagram, that.instagram)) return false;
        if (!Objects.equals(tiktok, that.tiktok)) return false;
        return Objects.equals(youtube, that.youtube);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (celular != null ? celular.hashCode() : 0);
        result = 31 * result + (cidadeEstado != null ? cidadeEstado.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (dataAssinaturaContrato != null ? dataAssinaturaContrato.hashCode() : 0);
        result = 31 * result + (dataVencimentoContrato != null ? dataVencimentoContrato.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (instagram != null ? instagram.hashCode() : 0);
        result = 31 * result + (tiktok != null ? tiktok.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (ativo ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Influenciador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", cidadeEstado='" + cidadeEstado + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataAssinaturaContrato=" + dataAssinaturaContrato +
                ", dataVencimentoContrato=" + dataVencimentoContrato +
                ", dataNascimento=" + dataNascimento +
                ", instagram='" + instagram + '\'' +
                ", tiktok='" + tiktok + '\'' +
                ", youtube='" + youtube + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
