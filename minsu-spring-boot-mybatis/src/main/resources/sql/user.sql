-- kdt db를 사용할 거다고 선언
use kdt;

-- 미리 테이블을 만들어 놔야 함, 안그러면 동작 안함

create table user {
   id bigint not null auto_increment primary key,
   name varchar(255) not null,
   nickname varchar(255) not null,
};

select * from user;

CREATE table board {
    id int not null auto_increment primary key,
    title varchar(20) not null,
    content varchar(100) not null,
    writer varchar(10) not null,
    registered timestamp DEFAULT CURRENT_TIMESTAMP
}

