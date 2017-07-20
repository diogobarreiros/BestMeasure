package com.bestmeasure.domain.entity;

/**
 * Classe responsável por armazenar os atributos do menu.
 * @author diogo.barreiros
 *
 */
public class Menu {
    private String idMenu;
    private String nome;
    private String descricao;
    private String imagem;

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
