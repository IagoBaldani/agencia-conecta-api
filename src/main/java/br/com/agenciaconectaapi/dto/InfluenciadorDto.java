package br.com.agenciaconectaapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class InfluenciadorDto {

    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String celular;
    @NotNull
    private String cidadeEstado;
    @Email
    private String email;
    private String endereco;
    @NotNull
    private LocalDate dataAssinaturaContrato;
    @NotNull
    private LocalDate dataVencimentoContrato;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String instagram;
    private String tiktok;
    private String youtube;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfluenciadorDto that = (InfluenciadorDto) o;

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
        int result = nome != null ? nome.hashCode() : 0;
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
        return result;
    }

    @Override
    public String toString() {
        return "InfluenciadorDto{" +
                "nome='" + nome + '\'' +
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
                '}';
    }
}
