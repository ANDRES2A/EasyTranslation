/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     30/05/2017 9:36:06                           */
/*==============================================================*/


alter table "peticion"
   drop constraint fk_peticion_idiomades_idioma;

alter table "peticion"
   drop constraint fk_peticion_idiomaori_idioma;

alter table "peticion"
   drop constraint fk_peticion_necesita_usuario;

alter table "association4"
   drop constraint fk_associat_associati_idioma;

alter table "association4"
   drop constraint fk_associat_associati_revisor;

alter table "sabe"
   drop constraint fk_sabe_sabe_idioma;

alter table "sabe"
   drop constraint fk_sabe_sabe_usuario;

drop table "idioma" cascade constraints;

drop table log cascade constraints;

drop index idiomadestino_fk;

drop index idiomaorigen_fk;

drop table "peticion" cascade constraints;

drop table "revisor" cascade constraints;

drop table "usuario" cascade constraints;

drop index association4_fk2;

drop index association4_fk;

drop table "association4" cascade constraints;

drop index sabe_fk2;

drop index sabe_fk;

drop table "sabe" cascade constraints;

/*==============================================================*/
/* Table: "idioma"                                              */
/*==============================================================*/
create table "idioma" 
(
   "abreviacion"        char(10)             not null,
   "descripcion"        varchar2(254)        not null,
   constraint pk_idioma primary key ("abreviacion")
);

/*==============================================================*/
/* Table: log                                                   */
/*==============================================================*/
create table log 
(
   "nick_log"           char(200),
   "rol_log"            char(30),
   "sql_log"            varchar2(250),
   "tabla_log"          varchar2(250),
   "fecha_log"          timestamp,
   "id_log"             integer              not null,
   constraint pk_log primary key ("id_log")
);

/*==============================================================*/
/* Table: "peticion"                                            */
/*==============================================================*/
create table "peticion" 
(
   "codigo_pe"          integer              not null,
   "correo_us"          char(1)              not null,
   "origen_pe"          char(10),
   "destino_pe"         char(10),
   "descripcion_pe"     clob                 not null,
   "tipo_pe"            char(10)             not null,
   "estado_pe"          smallint,
   constraint pk_peticion primary key ("codigo_pe")
);

/*==============================================================*/
/* Index: idiomaorigen_fk                                       */
/*==============================================================*/
create index idiomaorigen_fk on "peticion" (
   "origen_pe" asc
);

/*==============================================================*/
/* Index: idiomadestino_fk                                      */
/*==============================================================*/
create index idiomadestino_fk on "peticion" (
   "destino_pe" asc
);

/*==============================================================*/
/* Table: "revisor"                                             */
/*==============================================================*/
create table "revisor" 
(
   "correoelectronico_re" varchar2(254)        not null,
   "nombre_re"          varchar2(254),
   constraint pk_revisor primary key ("correoelectronico_re")
);

/*==============================================================*/
/* Table: "usuario"                                             */
/*==============================================================*/
create table "usuario" 
(
   "correo_us"          char(1)              not null,
   "nombre_us"          char(1)              not null,
   "contrasena_us"      char(1)              not null,
   constraint pk_usuario primary key ("correo_us")
);

/*==============================================================*/
/* Table: "association4"                                        */
/*==============================================================*/
create table "association4" 
(
   "abreviacion"        char(10)             not null,
   "correoelectronico_re" varchar2(254)        not null,
   constraint pk_association4 primary key ("abreviacion", "correoelectronico_re")
);

/*==============================================================*/
/* Index: association4_fk                                       */
/*==============================================================*/
create index association4_fk on "association4" (
   "correoelectronico_re" asc
);

/*==============================================================*/
/* Index: association4_fk2                                      */
/*==============================================================*/
create index association4_fk2 on "association4" (
   "abreviacion" asc
);

/*==============================================================*/
/* Table: "sabe"                                                */
/*==============================================================*/
create table "sabe" 
(
   "abreviacion"        char(10)             not null,
   "correo_us"          char(1)              not null,
   constraint pk_sabe primary key ("abreviacion", "correo_us")
);

/*==============================================================*/
/* Index: sabe_fk                                               */
/*==============================================================*/
create index sabe_fk on "sabe" (
   "correo_us" asc
);

/*==============================================================*/
/* Index: sabe_fk2                                              */
/*==============================================================*/
create index sabe_fk2 on "sabe" (
   "abreviacion" asc
);

alter table "peticion"
   add constraint fk_peticion_idiomades_idioma foreign key ("destino_pe")
      references "idioma" ("abreviacion");

alter table "peticion"
   add constraint fk_peticion_idiomaori_idioma foreign key ("origen_pe")
      references "idioma" ("abreviacion");

alter table "peticion"
   add constraint fk_peticion_necesita_usuario foreign key ("codigo_pe")
      references "usuario" ("codigo_pe");

alter table "association4"
   add constraint fk_associat_associati_idioma foreign key ("abreviacion")
      references "idioma" ("abreviacion");

alter table "association4"
   add constraint fk_associat_associati_revisor foreign key ("correoelectronico_re")
      references "revisor" ("correoelectronico_re");

alter table "sabe"
   add constraint fk_sabe_sabe_idioma foreign key ("abreviacion")
      references "idioma" ("abreviacion");

alter table "sabe"
   add constraint fk_sabe_sabe_usuario foreign key ("correo_us")
      references "usuario" ("correo_us");

