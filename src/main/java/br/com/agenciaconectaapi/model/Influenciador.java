package br.com.agenciaconectaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="influenciadores")
public class Influenciador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String celular;
    @NotNull
    private String cidadeEstado;
    private String email;
    private String endereco;
    @NotNull
    private LocalDateTime dataContrato;
    @NotNull
    private LocalDateTime dataNascimento;
    @NotNull
    private String instagram;
    private String tiktok;
    private String youtube;
    private boolean ativo;

    public Influenciador() {
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

    public LocalDateTime getDataContrato() {
        return dataContrato;
    }
    public void setDataContrato(LocalDateTime dataContrato) {
        this.dataContrato = dataContrato;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDateTime dataNascimento) {
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
                ", dataContrato=" + dataContrato +
                ", dataNascimento=" + dataNascimento +
                ", instagram='" + instagram + '\'' +
                ", tiktok='" + tiktok + '\'' +
                ", youtube='" + youtube + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
