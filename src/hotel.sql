create table consumer
(
    id   varchar(18) not null
        primary key,
    name varchar(10) not null,
    sex  varchar(6)  not null
)
    charset = utf8;

create table list
(
    listno  int unsigned auto_increment
        primary key,
    id      varchar(18)  not null,
    no      int unsigned not null,
    start   datetime     not null,
    days    int          not null,
    isEnded tinyint(1)   not null
)
    charset = utf8;

create table room
(
    no       int unsigned not null
        primary key,
    price    double       not null,
    state    tinyint(1)   not null,
    clean    tinyint(1)   not null,
    money    int          null,
    room_num int          null,
    style    varchar(10)  null,
    num      int unsigned null
)
    charset = utf8;

create table user
(
    id       varchar(20) not null
        primary key,
    password varchar(20) not null
)
    charset = utf8;


