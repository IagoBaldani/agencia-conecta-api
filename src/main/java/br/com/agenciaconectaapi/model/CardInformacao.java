package br.com.agenciaconectaapi.model;

public enum CardInformacao {
    NUMERO_INFLUENCIADORES_ATIVOS("ativos"),
    INFLUENCIADOR_MAIS_RECENTE("mais_recente"),
    INFLUENCIADOR_MAIS_ANTIGO("mais_antigo");

    private final String descricao;

    CardInformacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
