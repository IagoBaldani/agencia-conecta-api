package br.com.agenciaconectaapi.model;

public enum CardInformacao {
    NUMERO_INFLUENCIADORES_ATIVOS("influencers_ativos"),
    INFLUENCIADOR_MAIS_RECENTE("influencer_recente"),
    INFLUENCIADOR_MAIS_ANTIGO("influencer_antigo");

    private final String descricao;

    CardInformacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
