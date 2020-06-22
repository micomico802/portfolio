CREATE SEQUENCE user_id_seq;

CREATE TABLE users_master(
user_id bigint not null primary key DEFAULT nextval('user_id_seq'),
login_address varchar not null,
login_password varchar not null,
user_name varchar not null,
created_at timestamp default current_timestamp,
deleted_at timestamp default null
);

Insert into users_master(login_address, login_password, user_name)
	select 
		format('login%s@gmail.com',i),
		format('password%s',i),
		format('ÉÜÅ[ÉUÅ[%s',i)
	from
		generate_series(1, 100) as i;
