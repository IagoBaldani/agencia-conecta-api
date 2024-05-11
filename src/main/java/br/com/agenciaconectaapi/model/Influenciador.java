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
    private LocalDate dataContrato;
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
        this.dataContrato = influenciadorDto.getDataContrato();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Influenciador that = (Influenciador) o;

        if (ativo != that.ativo) return false;
        if (!id.equals(that.id)) return false;
        if (!nome.equals(that.nome)) return false;
        if (!cpf.equals(that.cpf)) return false;
        if (!celular.equals(that.celular)) return false;
        if (!cidadeEstado.equals(that.cidadeEstado)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(endereco, that.endereco)) return false;
        if (!dataContrato.equals(that.dataContrato)) return false;
        if (!dataNascimento.equals(that.dataNascimento)) return false;
        if (!instagram.equals(that.instagram)) return false;
        if (!Objects.equals(tiktok, that.tiktok)) return false;
        return Objects.equals(youtube, that.youtube);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + celular.hashCode();
        result = 31 * result + cidadeEstado.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + dataContrato.hashCode();
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + instagram.hashCode();
        result = 31 * result + (tiktok != null ? tiktok.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (ativo ? 1 : 0);
        return result;
    }
}
