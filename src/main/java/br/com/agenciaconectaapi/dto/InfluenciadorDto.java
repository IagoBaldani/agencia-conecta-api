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
    private LocalDate dataContrato;
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

    public LocalDate getDataContrato() {
        return dataContrato;
    }
    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
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

        if (!nome.equals(that.nome)) return false;
        if (!cpf.equals(that.cpf)) return false;
        if (!celular.equals(that.celular)) return false;
        if (!cidadeEstado.equals(that.cidadeEstado)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(endereco, that.endereco)) return false;
        if (!dataContrato.equals(that.dataContrato)) return false;
        if (!dataNascimento.equals(that.dataNascimento)) return false;
        if (!instagram.equals(that.instagram)) return false;
        if (!tiktok.equals(that.tiktok)) return false;
        return youtube.equals(that.youtube);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + celular.hashCode();
        result = 31 * result + cidadeEstado.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + dataContrato.hashCode();
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + instagram.hashCode();
        result = 31 * result + tiktok.hashCode();
        result = 31 * result + youtube.hashCode();
        return result;
    }
}
