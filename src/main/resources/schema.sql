

 drop table if exists book_entity CASCADE ;
  drop table if exists product CASCADE ;
  drop table if exists product_group CASCADE ;
   drop table if exists security_role CASCADE;
   drop table if exists security_user CASCADE ;
   drop table if exists tbl_employees CASCADE ;

   drop table if exists user_role CASCADE ;

   create table book_entity (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

     create table product_group (
       id bigint not null,
        version integer,
        active boolean not null,
        code bigint not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table product (
       id bigint not null,
        version integer,
        active boolean not null,
        code bigint not null,
        name varchar(255) not null,
        product_type integer,
        product_group_id bigint not null,
        primary key (id)
    );


 create table security_role (
       id bigint generated by default as identity,
        description varchar(255),
        role_name varchar(255),
        primary key (id)
    );

     create table security_user (
       id bigint generated by default as identity,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

     create table user_role (
       user_id bigint not null,
        role_id bigint not null
    );

    alter table product
       add constraint FKd1puiblqvkggoc63q7c3ux5x6
       foreign key (product_group_id)
       references product_group;


    alter table user_role
       add constraint FKaovu9xgrvfngaab129ho0e6s1
       foreign key (role_id)
       references security_role;


    alter table user_role
       add constraint FKag2tat8o2o7yvedewuh0tosbq
       foreign key (user_id)
       references security_user;


    create table tbl_employees (
       id bigint generated by default as identity,
        email varchar(200) not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    );



     CREATE SEQUENCE HIBERNATE_SEQUENCE
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

/*CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);*/


/*CREATE TABLE security_role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  description varchar(100) DEFAULT NULL,
  role_name varchar(100) DEFAULT NULL
);


CREATE TABLE security_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL
);


CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT FK_SECURITY_USER_ID FOREIGN KEY (user_id) REFERENCES security_user (id),
  CONSTRAINT FK_SECURITY_ROLE_ID FOREIGN KEY (role_id) REFERENCES security_role (id)
);

 create table book_entity (
       id bigint not null,
        name varchar(255),
        primary key (id)
    )


    create table product (
       id bigint not null,
        version integer,
        active boolean not null,
        code bigint not null,
        name varchar(255) not null,
        product_type integer,
        product_group_id bigint not null,
        primary key (id)
    )


    create table product_group (
       id bigint not null,
        version integer,
        active boolean not null,
        code bigint not null,
        name varchar(255) not null,
        primary key (id)
    )



    alter table product
       add constraint FK9rsff72epdcjawks7p49xih20
       foreign key (product_group_id)
               product_group;*/

