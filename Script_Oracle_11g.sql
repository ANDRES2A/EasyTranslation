/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     27/05/2017 12:03:08                          */
/*==============================================================*/


alter table "Comentario"
   drop constraint FK_COMENTAR_POSEE_1_INTERPRE;

alter table "Comentario"
   drop constraint FK_COMENTAR_POSEE_2_TRADUCCI;

alter table "Fiabilidad"
   drop constraint FK_FIABILID_TIENE_USUARIO;

alter table "Interpretacion"
   drop constraint FK_INTERPRE_CONTIENE__PETICION;

alter table "Pago"
   drop constraint FK_PAGO_ASSOCIATI_INTERPRE;

alter table "Pago"
   drop constraint FK_PAGO_PRODUCE_2_TRADUCCI;

alter table "Peticion"
   drop constraint FK_PETICION_DESTINO_IDIOMA;

alter table "Peticion"
   drop constraint FK_PETICION_ORIGEN_IDIOMA;

alter table "Revisor"
   drop constraint FK_REVISOR_SABE_IDIOMA;

alter table "Subasta"
   drop constraint FK_SUBASTA_RECIBE_PETICION;

alter table "Traduccion"
   drop constraint FK_TRADUCCI_CONTIENE__PETICION;

alter table "Usuario"
   drop constraint FK_USUARIO_NECESITA_PETICION;

alter table "revisa"
   drop constraint FK_REVISA_REVISA_REVISOR;

alter table "sabe"
   drop constraint FK_SABE_SABE_IDIOMA;

alter table "sabe"
   drop constraint FK_SABE_SABE_USUARIO;

drop index POSEE_1_FK;

drop index POSEE_2_FK;

drop table "Comentario" cascade constraints;

drop index TIENE_FK;

drop table "Fiabilidad" cascade constraints;

drop table "Idioma" cascade constraints;

drop index CONTIENE_1_FK;

drop table "Interpretacion" cascade constraints;

drop table LOG cascade constraints;

drop index ASSOCIATION_13_FK;

drop index PRODUCE_2_FK;

drop table "Pago" cascade constraints;

drop index DESTINO_FK;

drop table "Peticion" cascade constraints;

drop index SABE_FK;

drop table "Revisor" cascade constraints;

drop index RECIBE_FK;

drop table "Subasta" cascade constraints;

drop index CONTIENE_2_FK;

drop table "Traduccion" cascade constraints;

drop index NECESITA_FK;

drop table "Usuario" cascade constraints;

drop table "revisa" cascade constraints;

drop index SABE_FK3;

drop index SABE_FK2;

drop table "sabe" cascade constraints;

/*==============================================================*/
/* Table: "Comentario"                                          */
/*==============================================================*/
create table "Comentario" 
(
   "codigo_tr"          INTEGER,
   "codigo_in"          INTEGER
);

/*==============================================================*/
/* Index: POSEE_2_FK                                            */
/*==============================================================*/
create index POSEE_2_FK on "Comentario" (
   "codigo_tr" ASC
);

/*==============================================================*/
/* Index: POSEE_1_FK                                            */
/*==============================================================*/
create index POSEE_1_FK on "Comentario" (
   "codigo_in" ASC
);

/*==============================================================*/
/* Table: "Fiabilidad"                                          */
/*==============================================================*/
create table "Fiabilidad" 
(
   "correo_us"          CHAR(100),
   "calificacion_fi"    INTEGER
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create index TIENE_FK on "Fiabilidad" (
   "correo_us" ASC
);

/*==============================================================*/
/* Table: "Idioma"                                              */
/*==============================================================*/
create table "Idioma" 
(
   "abreviacion_id"     CHAR(10)             not null,
   "descripcion_id"     VARCHAR2(100),
   constraint PK_IDIOMA primary key ("abreviacion_id")
);

/*==============================================================*/
/* Table: "Interpretacion"                                      */
/*==============================================================*/
create table "Interpretacion" 
(
   "codigo_in"          INTEGER              not null,
   "codigo_pe"          INTEGER,
   "texto_in"           CLOB,
   "fecha_in"           TIMESTAMP,
   constraint PK_INTERPRETACION primary key ("codigo_in")
);

/*==============================================================*/
/* Index: CONTIENE_1_FK                                         */
/*==============================================================*/
create index CONTIENE_1_FK on "Interpretacion" (
   "codigo_pe" ASC
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
   "fecha_log"          TIMESTAMP
);

/*==============================================================*/
/* Table: "Pago"                                                */
/*==============================================================*/
create table "Pago" 
(
   "codigo_tr"          INTEGER,
   "codigo_in"          INTEGER,
   "valor_pa"           NUMBER(18,2)
);

/*==============================================================*/
/* Index: PRODUCE_2_FK                                          */
/*==============================================================*/
create index PRODUCE_2_FK on "Pago" (
   "codigo_tr" ASC
);

/*==============================================================*/
/* Index: ASSOCIATION_13_FK                                     */
/*==============================================================*/
create index ASSOCIATION_13_FK on "Pago" (
   "codigo_in" ASC
);

/*==============================================================*/
/* Table: "Peticion"                                            */
/*==============================================================*/
create table "Peticion" 
(
   "codigo_pe"          INTEGER              not null,
   "destino_pe"         CHAR(10),
   "Idi_abreviacion_id" CHAR(10),
   "descripcion_pe"     VARCHAR2(200),
   "extencion_pe"       CHAR(20),
   constraint PK_PETICION primary key ("codigo_pe")
);

/*==============================================================*/
/* Index: DESTINO_FK                                            */
/*==============================================================*/
create index DESTINO_FK on "Peticion" (
   "destino_pe" ASC
);

/*==============================================================*/
/* Table: "Revisor"                                             */
/*==============================================================*/
create table "Revisor" 
(
   "correoelectronico_re" VARCHAR2(254)        not null,
   "abreviacion_id"     CHAR(10),
   "nombre_re"          VARCHAR2(254),
   constraint PK_REVISOR primary key ("correoelectronico_re")
);

/*==============================================================*/
/* Index: SABE_FK                                               */
/*==============================================================*/
create index SABE_FK on "Revisor" (
   "abreviacion_id" ASC
);

/*==============================================================*/
/* Table: "Subasta"                                             */
/*==============================================================*/
create table "Subasta" 
(
   "codigo_pe"          INTEGER,
   "Valor"              FLOAT
);

/*==============================================================*/
/* Index: RECIBE_FK                                             */
/*==============================================================*/
create index RECIBE_FK on "Subasta" (
   "codigo_pe" ASC
);

/*==============================================================*/
/* Table: "Traduccion"                                          */
/*==============================================================*/
create table "Traduccion" 
(
   "codigo_tr"          INTEGER              not null,
   "codigo_pe"          INTEGER,
   "texto_tr"           CLOB,
   "fecha_tr"           TIMESTAMP,
   constraint PK_TRADUCCION primary key ("codigo_tr")
);

/*==============================================================*/
/* Index: CONTIENE_2_FK                                         */
/*==============================================================*/
create index CONTIENE_2_FK on "Traduccion" (
   "codigo_pe" ASC
);

/*==============================================================*/
/* Table: "Usuario"                                             */
/*==============================================================*/
create table "Usuario" 
(
   "correo_us"          CHAR(100)            not null,
   "codigo_pe"          INTEGER,
   "nombre_us"          CHAR(200),
   "contrasena_us"      CHAR(40),
   constraint PK_USUARIO primary key ("correo_us")
);

/*==============================================================*/
/* Index: NECESITA_FK                                           */
/*==============================================================*/
create index NECESITA_FK on "Usuario" (
   "codigo_pe" ASC
);

/*==============================================================*/
/* Table: "revisa"                                              */
/*==============================================================*/
create table "revisa" 
(
   "correoelectronico_re" VARCHAR2(254)        not null,
   "texto_re"           CLOB                 not null,
   "fecha_re"           TIMESTAMP,
   constraint PK_REVISA primary key ("correoelectronico_re")
);

/*==============================================================*/
/* Table: "sabe"                                                */
/*==============================================================*/
create table "sabe" 
(
   "abreviacion_id"     CHAR(10)             not null,
   "correo_us"          CHAR(100)            not null,
   constraint PK_SABE primary key ("abreviacion_id", "correo_us")
);

/*==============================================================*/
/* Index: SABE_FK2                                              */
/*==============================================================*/
create index SABE_FK2 on "sabe" (
   "abreviacion_id" ASC
);

/*==============================================================*/
/* Index: SABE_FK3                                              */
/*==============================================================*/
create index SABE_FK3 on "sabe" (
   "correo_us" ASC
);

alter table "Comentario"
   add constraint FK_COMENTAR_POSEE_1_INTERPRE foreign key ("codigo_in")
      references "Interpretacion" ("codigo_in");

alter table "Comentario"
   add constraint FK_COMENTAR_POSEE_2_TRADUCCI foreign key ("codigo_tr")
      references "Traduccion" ("codigo_tr");

alter table "Fiabilidad"
   add constraint FK_FIABILID_TIENE_USUARIO foreign key ("correo_us")
      references "Usuario" ("correo_us");

alter table "Interpretacion"
   add constraint FK_INTERPRE_CONTIENE__PETICION foreign key ("codigo_pe")
      references "Peticion" ("codigo_pe");

alter table "Pago"
   add constraint FK_PAGO_ASSOCIATI_INTERPRE foreign key ("codigo_in")
      references "Interpretacion" ("codigo_in");

alter table "Pago"
   add constraint FK_PAGO_PRODUCE_2_TRADUCCI foreign key ("codigo_tr")
      references "Traduccion" ("codigo_tr");

alter table "Peticion"
   add constraint FK_PETICION_DESTINO_IDIOMA foreign key ("destino_pe")
      references "Idioma" ("abreviacion_id");

alter table "Peticion"
   add constraint FK_PETICION_ORIGEN_IDIOMA foreign key ("Idi_abreviacion_id")
      references "Idioma" ("abreviacion_id");

alter table "Revisor"
   add constraint FK_REVISOR_SABE_IDIOMA foreign key ("abreviacion_id")
      references "Idioma" ("abreviacion_id");

alter table "Subasta"
   add constraint FK_SUBASTA_RECIBE_PETICION foreign key ("codigo_pe")
      references "Peticion" ("codigo_pe");

alter table "Traduccion"
   add constraint FK_TRADUCCI_CONTIENE__PETICION foreign key ("codigo_pe")
      references "Peticion" ("codigo_pe");

alter table "Usuario"
   add constraint FK_USUARIO_NECESITA_PETICION foreign key ("codigo_pe")
      references "Peticion" ("codigo_pe");

alter table "revisa"
   add constraint FK_REVISA_REVISA_REVISOR foreign key ("correoelectronico_re")
      references "Revisor" ("correoelectronico_re");

alter table "sabe"
   add constraint FK_SABE_SABE_IDIOMA foreign key ("abreviacion_id")
      references "Idioma" ("abreviacion_id");

alter table "sabe"
   add constraint FK_SABE_SABE_USUARIO foreign key ("correo_us")
      references "Usuario" ("correo_us");

