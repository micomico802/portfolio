create sequence item_id_seq;

create table items_master(
item_id bigint not null primary key DEFAULT nextval('item_id_seq'),
item_name varchar not null,
maker_id bigint,
list_price integer default 0,
current_stock integer,
quantity_sold integer default 0,
created_at timestamp DEFAULT CURRENT_TIMESTAMP,
deleted_at timestamp DEFAULT null);

insert into items_master(item_name, maker_id, list_price, current_stock, quantity_sold)
SELECT 
     format('アイテム名%s', i),
     i * floor(random()*10),
     floor(random()*1000),
     i * 50,
     i * 30
     
 FROM
     generate_series(1,1000) as i;
