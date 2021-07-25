package com.company;

import com.company.Dao.BaseDao;
import com.company.Dao.NewsDao;
import com.company.Dao.NewsDaoImpl;

import java.sql.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class NewsChanging{

    private void addedNews(NewsDao newsDao) {
        News news = new News();

        System.out.print("Введите заголовок новой новости: ");
        news.setTitle(new Scanner(System.in).nextLine());
        System.out.print("Введите текст новой новости: ");
        news.setText(new Scanner(System.in).nextLine());

        if (newsDao.creatingNewNews(news))
            System.out.println("Новость добавлена в базу данных!");
        else
            System.err.println("Новость не добавлена в базу данных!\nПроверьте все ли правильно записано...");
    }

    private void getAllNews(NewsDao newsDao) {
        List<News> newsList = newsDao.getAllNews();

        if (newsList == null)
            System.err.println("Новостей нет в базе данных!");
        else
            System.out.println(newsList);
    }

    private void deleteNews(NewsDao newsDao) {
        System.out.print("Введите id новости, которую нужно удалить: ");

        if (newsDao.deleteNews(new Scanner(System.in).nextInt()))
            System.out.println("Новость удалена!");
        else
            System.err.println("Такой новости не существует!");
    }

    private void updateNews(NewsDao newsDao) {
        News news = new News();

        System.out.print("Введите id новости, которую нужно изменить: ");
        int id = new Scanner(System.in).nextInt();

        if (((NewsDaoImpl) newsDao).isNews(id)) {
            System.out.print("Введите новый заголовок новости: ");
            news.setTitle(new Scanner(System.in).nextLine());
            System.out.print("Введите новый текст новости: ");
            news.setText(new Scanner(System.in).nextLine());

            if (newsDao.updateNews(id, news))
                System.out.println("Новость изменена!");
            else
                System.err.println("Новость не изменена в базе данных!\nПроверьте все ли правильно записано...");
        } else
            System.err.println("Такой новости не существует!");
    }

    public void run() {
        NewsDao news = new NewsDaoImpl();

        boolean f = true;
        while (f) {
            System.out.println("1 - Добавить новость");
            System.out.println("2 - Посмотреть все новости");
            System.out.println("3 - Удалить новость");
            System.out.println("4 - Изменить новость");
            System.out.println("5 - Выход\n");
            System.out.print("Введите действие: ");
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> addedNews(news);
                case 2 -> getAllNews(news);
                case 3 -> deleteNews(news);
                case 4 -> updateNews(news);
                case 5 -> f = false;
            }
        }
    }
}
