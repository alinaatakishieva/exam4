package com.company.Dao;

import com.company.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao{
    @Override
    public boolean creatingNewNews(News news) {
        try (PreparedStatement ps = connect().prepareStatement(
                "insert into news (title, news_text, publication_time)" +
                        "values (?, ?, now())")) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getText());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    @Override
    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<>();

        try (ResultSet rs = connect().createStatement().executeQuery(
                "select * from news")) {
            while (rs.next())
                newsList.add(new News(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("news_text"),
                        rs.getDate("publication_time")));

            if (newsList.size() > 0)
                return newsList;
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteNews(int id) {
        try (PreparedStatement ps = connect().prepareStatement(
                "delete from news where id = ?")) {
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean isNews(int id) {
        try (ResultSet rs = connect().createStatement().executeQuery("" +
                "select id from news where id = " + id)) {
            while (rs.next())
                return rs.getInt("id") > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateNews(int id, News news) {
        try (PreparedStatement ps = connect().prepareStatement(
                "update news set title = ?, news_text = ? where id = ?")) {
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getText());
            ps.setInt(3, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
