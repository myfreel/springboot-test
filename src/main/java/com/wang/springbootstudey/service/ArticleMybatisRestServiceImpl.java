package com.wang.springbootstudey.service;

import com.wang.springbootstudey.generator.testdb1.Article;
import com.wang.springbootstudey.generator.testdb1.ArticleMapper;
import com.wang.springbootstudey.model.ArticleVO;
import com.wang.springbootstudey.utils.DozerUtils;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService{

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;


    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.insert(articlePO);
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);

    }
}
