/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     29/05/2017 16:36:38                          */
/*==============================================================*/


alter table "Peticion"
   drop constraint FK_PETICION_IDIOMADES_IDIOMA;

alter table "Peticion"
   drop constraint FK_PETICION_IDIOMAORI_IDIOMA;

alter table "Peticion"
   drop constraint FK_PETICION_NECESITA_USUARIO;

alter table "association4"
   drop constraint FK_ASSOCIAT_ASSOCIATI_IDIOMA;

alter table "association4"
   drop constraint FK_ASSOCIAT_ASSOCIATI_REVISOR;

alter table "sabe"
   drop constraint FK_SABE_SABE_IDIOMA;

alter table "sabe"
   drop constraint FK_SABE_SABE_USUARIO;

drop table "Idioma" cascade constraints;

drop table LOG cascade constraints;

drop index IDIOMADESTINO_FK;

drop index IDIOMAORIGEN_FK;

drop table "Peticion" cascade constraints;

drop table "Revisor" cascade constraints;

drop table "Usuario" cascade constraints;

drop index ASSOCIATION4_FK2;

drop index ASSOCIATION4_FK;

drop table "association4" cascade constraints;

drop index SABE_FK2;

drop index SABE_FK;

drop table "sabe" cascade constraints;

/*==============================================================*/
/* Table: "Idioma"                                              */
/*==============================================================*/
create table "Idioma" 
(
   "abreviacion"        CHAR(10)             not null,
   "descripcion"        VARCHAR2(254)        not null,
   constraint PK_IDIOMA primary key ("abreviacion")
);

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
create table LOG 
(
   "Nick_log"           CHAR(200),
   "Rol_log"            CHAR(30),
   "sql_log"            VARCHAR2(250),
   "tabla_log"          VARCHAR2(250),
   "fecha_log"          TIMESTAMP,
   "id_log"             INTEGER              not null,
   constraint PK_LOG primary key ("id_log")
);

/*==============================================================*/
/* Table: "Peticion"                                            */
/*==============================================================*/
create table "Peticion" 
(
   "Codigo_pe"          INTEGER              not null,
   "Correo_us"          CHAR(1)              not null,
   "Origen_pe"          CHAR(10),
   "Destino_pe"         CHAR(10),
   "Descripcion_pe"     CLOB                 not null,
   "extencion"          CHAR(10)             not null,
   constraint PK_PETICION primary key ("Codigo_pe")
);

/*==============================================================*/
/* Index: IDIOMAORIGEN_FK                                       */
/*==============================================================*/
create index IDIOMAORIGEN_FK on "Peticion" (
   "Origen_pe" ASC
);

/*==============================================================*/
/* Index: IDIOMADESTINO_FK                                      */
/*==============================================================*/
create index IDIOMADESTINO_FK on "Peticion" (
   "Destino_pe" ASC
);

/*==============================================================*/
/* Table: "Revisor"                                             */
/*==============================================================*/
create table "Revisor" 
(
   "CorreoElectronico_re" VARCHAR2(254)        not null,
   "Nombre_re"          VARCHAR2(254),
   constraint PK_REVISOR primary key ("CorreoElectronico_re")
);

/*==============================================================*/
/* Table: "Usuario"                                             */
/*==============================================================*/
create table "Usuario" 
(
   "Correo_us"          CHAR(1)              not null,
   "Nombre_us"          CHAR(1)              not null,
   "Contrasena_us"      CHAR(1)              not null,
   constraint PK_USUARIO primary key ("Correo_us")
);

/*==============================================================*/
/* Table: "association4"                                        */
/*==============================================================*/
create table "association4" 
(
   "abreviacion"        CHAR(10)             not null,
   "CorreoElectronico_re" VARCHAR2(254)        not null,
   constraint PK_ASSOCIATION4 primary key ("abreviacion", "CorreoElectronico_re")
);

/*==============================================================*/
/* Index: ASSOCIATION4_FK                                       */
/*==============================================================*/
create index ASSOCIATION4_FK on "association4" (
   "CorreoElectronico_re" ASC
);

/*==============================================================*/
/* Index: ASSOCIATION4_FK2                                      */
/*==============================================================*/
create index ASSOCIATION4_FK2 on "association4" (
   "abreviacion" ASC
);

/*==============================================================*/
/* Table: "sabe"                                                */
/*==============================================================*/
create table "sabe" 
(
   "abreviacion"        CHAR(10)             not null,
   "Correo_us"          CHAR(1)              not null,
   constraint PK_SABE primary key ("abreviacion", "Correo_us")
);

/*==============================================================*/
/* Index: SABE_FK                                               */
/*==============================================================*/
create index SABE_FK on "sabe" (
   "Correo_us" ASC
);

/*==============================================================*/
/* Index: SABE_FK2                                              */
/*==============================================================*/
create index SABE_FK2 on "sabe" (
   "abreviacion" ASC
);

alter table "Peticion"
   add constraint FK_PETICION_IDIOMADES_IDIOMA foreign key ("Destino_pe")
      references "Idioma" ("abreviacion");

alter table "Peticion"
   add constraint FK_PETICION_IDIOMAORI_IDIOMA foreign key ("Origen_pe")
      references "Idioma" ("abreviacion");

alter table "Peticion"
   add constraint FK_PETICION_NECESITA_USUARIO foreign key ("Codigo_pe")
      references "Usuario" ("Codigo_pe");

alter table "association4"
   add constraint FK_ASSOCIAT_ASSOCIATI_IDIOMA foreign key ("abreviacion")
      references "Idioma" ("abreviacion");

alter table "association4"
   add constraint FK_ASSOCIAT_ASSOCIATI_REVISOR foreign key ("CorreoElectronico_re")
      references "Revisor" ("CorreoElectronico_re");

alter table "sabe"
   add constraint FK_SABE_SABE_IDIOMA foreign key ("abreviacion")
      references "Idioma" ("abreviacion");

alter table "sabe"
   add constraint FK_SABE_SABE_USUARIO foreign key ("Correo_us")
      references "Usuario" ("Correo_us");

