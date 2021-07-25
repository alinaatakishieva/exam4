create table drivers(
	id serial primary key,
	full_name varchar (50) not null,
	fk_public_transport_id integer references public_transport (id)
);

insert into drivers(full_name, fk_public_transport_id)
values ('Водитель1', 3),
		('Водитель2', 1),
		('Водитель3', 6),
		('Водитель2', 5),
		('Водитель1', 2), 
		('Водитель3', 4);
commit;

select * from drivers;

create table public_transport(
	id serial primary key,
	public_transport_type varchar (20) not null,
	car_number varchar (10) unique not null,
	fk_routes_id integer references routes (id)
);

insert into public_transport (public_transport_type, car_number, fk_routes_id)
values ('маршрутка', 'D111K', 1),
		('автобус', 'B343B', 4),
		('маршрутка', 'U565U', 2),
		('автобус', 'R787R', 6),
		('автобус', 'D989D', 5),
		('маршрутка', 'Ch464B', 3);
commit;

select * from public_transport;

create table routes(
	id serial primary key,
	route_number varchar (10) not null unique,
	start_point varchar (30) not null,
	end_point varchar(30) not null
);

insert into routes (route_number, start_point, end_point)
values ('203', 'Айни', 'Дордой'),
		('212', 'Военный институт', '12 микрорайон'),
		('199', 'ул. Гоголя', 'Кок Джар'),
		('42', 'ж\м Ала-Тоо', '12 мкр'),
		('38', 'Аламедин-1', '110-й квартал'),
		('36', 'ж\м Ак-Ордо', 'Шоро');
commit;

select * from routes;

create table journal(
	id serial primary key,
	fk_driver_id integer references drivers (id),
	driving_time timestamp not null
);

insert into journal (fk_driver_id, driving_time)
values (2, now()),
		(5, now() + '12:00'),
		(1, now()+ '24:00');
commit;

select * from journal;

select d.full_name, r.route_number, j.driving_time 
from drivers d 
join public_transport pt on d.fk_public_transport_id = pt.id 
join routes r on pt.fk_routes_id  = r.id 
join journal j on j.fk_driver_id = d.id;

