create table drivers(
	id serial primary key,
	full_name varchar (50) not null,
	fk_public_transport_id integer references public_transport (id)
);

insert into drivers(full_name, fk_public_transport_id)
values ('��������1', 3),
		('��������2', 1),
		('��������3', 6),
		('��������2', 5),
		('��������1', 2), 
		('��������3', 4);
commit;

select * from drivers;

create table public_transport(
	id serial primary key,
	public_transport_type varchar (20) not null,
	car_number varchar (10) unique not null,
	fk_routes_id integer references routes (id)
);

insert into public_transport (public_transport_type, car_number, fk_routes_id)
values ('���������', 'D111K', 1),
		('�������', 'B343B', 4),
		('���������', 'U565U', 2),
		('�������', 'R787R', 6),
		('�������', 'D989D', 5),
		('���������', 'Ch464B', 3);
commit;

select * from public_transport;

create table routes(
	id serial primary key,
	route_number varchar (10) not null unique,
	start_point varchar (30) not null,
	end_point varchar(30) not null
);

insert into routes (route_number, start_point, end_point)
values ('203', '����', '������'),
		('212', '������� ��������', '12 ����������'),
		('199', '��. ������', '��� ����'),
		('42', '�\� ���-���', '12 ���'),
		('38', '��������-1', '110-� �������'),
		('36', '�\� ��-����', '����');
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

