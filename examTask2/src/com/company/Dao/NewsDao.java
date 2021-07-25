package com.company.Dao;
import com.company.News;
import java.util.List;

public interface NewsDao {

    boolean creatingNewNews(News news);

    List<News> getAllNews();

    boolean deleteNews(int id);

    boolean updateNews(int id, News news);
}
