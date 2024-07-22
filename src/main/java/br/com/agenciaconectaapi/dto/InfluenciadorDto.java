package br.com.agenciaconectaapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
}
