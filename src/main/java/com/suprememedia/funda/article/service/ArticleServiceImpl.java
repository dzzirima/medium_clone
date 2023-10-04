package com.suprememedia.funda.article.service;

import com.suprememedia.funda.article.dto.ArticleUpdateDto;
import com.suprememedia.funda.article.model.Article;
import com.suprememedia.funda.article.repository.ArticleRepository;
import com.suprememedia.funda.auth.repository.UserProfileRepository;
import com.suprememedia.funda.utils.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepository articleRepository;
    private final UserProfileRepository userProfileRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserProfileRepository userProfileRepository) {
        this.articleRepository = articleRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article with id [ %s ] not found".formatted(id)
                )
        );
    }

    @Override
    public Article saveArticle(Article article) {



        article.setAuthor(userProfileRepository.findById(1L).get());
        return articleRepository.save(article);
    }

    @Override
    public boolean existsById(Long articleId) {
        return articleRepository.existsById(articleId);
    }

    @Override
    public String updateArticle(ArticleUpdateDto articleUpdateDto) {
        boolean updates = false;


        Article foundArticle = findById(articleUpdateDto.id());

        if (foundArticle.getContent().equals(articleUpdateDto.content())){
            foundArticle.setContent(articleUpdateDto.content());
            updates = true;
        }

        if(updates){
            saveArticle(foundArticle);
            return "article save successfully";
        }else {
            return "No document was update" ;
        }
    }
    @Override
    public String deleteArticleById(Long id) {
        Article foundArticle = findById(id); // make sure there is an article with that id
        articleRepository.deleteById(id);
        return "Article with id [ id] was successfully deleted ";
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
