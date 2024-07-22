package br.com.agenciaconectaapi.model;

import br.com.agenciaconectaapi.dto.InfluenciadorDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="INFLUENCIADORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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

    public void mudarStatus(){
        this.ativo = !this.ativo;
    }
}
