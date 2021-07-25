create table news(
	id serial primary key,
	title varchar (50) not null,
	news_text text not null,
	publication_time timestamp not null
);

insert into news (title, news_text, publication_time)
values (?, ?, ?);

select * from news;