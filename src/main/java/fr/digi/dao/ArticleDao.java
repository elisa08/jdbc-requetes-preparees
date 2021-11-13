package fr.digi.dao;

import fr.digi.entites.Articles;

import java.util.List;

public interface ArticleDao {

    List<Articles> extraire();
    void insert(Articles articles);
    void update(Articles articles);
    boolean delete();
    void caculMoyennePrix();
}
