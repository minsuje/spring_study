use kdt;


CREATE table board {
    id int not null auto_increment primary key,
    title varchar(20) not null,
    content varchar(100) not null,
    writer varchar(10) not null,
    registered datetime DEFAULT CURRENT_TIMESTAMP
}