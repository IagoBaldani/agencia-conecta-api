package br.com.agenciaconectaapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GastoDto(String descricao, BigDecimal valor, boolean fixo, LocalDate data) {
}
