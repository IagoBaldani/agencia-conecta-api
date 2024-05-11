package br.com.agenciaconectaapi.dto;

import java.math.BigDecimal;

public record CardFinancas(String nomeInfluenciador, BigDecimal valorAcessor, BigDecimal valorInfluenciador, Integer qtdServicos) {
}
