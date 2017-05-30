/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     30/5/2017 9:43:59                            */
/*==============================================================*/


alter table PETICION
   drop constraint FK_PETICION_IDIOMA_DE_IDIOMA;

alter table PETICION
   drop constraint FK_PETICION_IDIOMA_OR_IDIOMA;

alter table SABE
   drop constraint FK_SABE_SABE_IDIOMA;

alter table SABE
   drop constraint FK_SABE_SABE2_USUARIO;

alter table SABE_REVISOR
   drop constraint FK_SABE_REV_SABE_REVI_USUARIO;

alter table SABE_REVISOR
   drop constraint FK_SABE_REV_SABE_REVI_REVISOR;

drop table IDIOMA cascade constraints;

drop index IDIOMA_DESTINO_FK;

drop index IDIOMA_ORIGEN_FK;

drop table PETICION cascade constraints;

drop table REVISOR cascade constraints;

drop index SABE_FK;

drop index SABE2_FK;

drop table SABE cascade constraints;

drop index SABE_REVISOR_FK;

drop index SABE_REVISOR2_FK;

drop table SABE_REVISOR cascade constraints;

drop table USUARIO cascade constraints;

/*==============================================================*/
/* Table: IDIOMA                                                */
/*==============================================================*/
create table IDIOMA 
(
   ABREVIACION_ID       VARCHAR2(10)         not null,
   DESCRIPCION_ID       VARCHAR2(100),
   constraint PK_IDIOMA primary key (ABREVIACION_ID)
);

/*==============================================================*/
/* Table: PETICION                                              */
/*==============================================================*/
create table PETICION 
(
   CODIGO_PE            INTEGER              not null,
   ABREVIACION_ID       VARCHAR2(10),
   IDI_ABREVIACION_ID   VARCHAR2(10),
   DESCRIPCION_PE       CLOB,
   TIPO_PE              VARCHAR2(10),
   FECHA_EMISION_PE     DATE,
   ESTADO_PE            SMALLINT,
   constraint PK_PETICION primary key (CODIGO_PE)
);

/*==============================================================*/
/* Index: IDIOMA_ORIGEN_FK                                      */
/*==============================================================*/
create index IDIOMA_ORIGEN_FK on PETICION (
   ABREVIACION_ID ASC
);

/*==============================================================*/
/* Index: IDIOMA_DESTINO_FK                                     */
/*==============================================================*/
create index IDIOMA_DESTINO_FK on PETICION (
   IDI_ABREVIACION_ID ASC
);

/*==============================================================*/
/* Table: REVISOR                                               */
/*==============================================================*/
create table REVISOR 
(
   CORREO_RE            VARCHAR2(255)        not null,
   NOMBRE_RE            VARCHAR2(100),
   PASSWORD_RE          VARCHAR2(255),
   FECHA_NACIMIENTO_RE  DATE,
   EXPERIENCIA          VARCHAR2(10),
   constraint PK_REVISOR primary key (CORREO_RE)
);

/*==============================================================*/
/* Table: SABE                                                  */
/*==============================================================*/
create table SABE 
(
   CORREO_US            VARCHAR2(255)        not null,
   ABREVIACION_ID       VARCHAR2(10)         not null,
   constraint PK_SABE primary key (CORREO_US, ABREVIACION_ID)
);

/*==============================================================*/
/* Index: SABE2_FK                                              */
/*==============================================================*/
create index SABE2_FK on SABE (
   CORREO_US ASC
);

/*==============================================================*/
/* Index: SABE_FK                                               */
/*==============================================================*/
create index SABE_FK on SABE (
   ABREVIACION_ID ASC
);

/*==============================================================*/
/* Table: SABE_REVISOR                                          */
/*==============================================================*/
create table SABE_REVISOR 
(
   CORREO_RE            VARCHAR2(255)        not null,
   CORREO_US            VARCHAR2(255)        not null,
   constraint PK_SABE_REVISOR primary key (CORREO_RE, CORREO_US)
);

/*==============================================================*/
/* Index: SABE_REVISOR2_FK                                      */
/*==============================================================*/
create index SABE_REVISOR2_FK on SABE_REVISOR (
   CORREO_RE ASC
);

/*==============================================================*/
/* Index: SABE_REVISOR_FK                                       */
/*==============================================================*/
create index SABE_REVISOR_FK on SABE_REVISOR (
   CORREO_US ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   CORREO_US            VARCHAR2(255)        not null,
   NOMBRE_US            VARCHAR2(100),
   PASSWORD_US          VARCHAR2(255),
   FECHA_NACIMIENTO_US  DATE,
   constraint PK_USUARIO primary key (CORREO_US)
);

alter table PETICION
   add constraint FK_PETICION_IDIOMA_DE_IDIOMA foreign key (IDI_ABREVIACION_ID)
      references IDIOMA (ABREVIACION_ID);

alter table PETICION
   add constraint FK_PETICION_IDIOMA_OR_IDIOMA foreign key (ABREVIACION_ID)
      references IDIOMA (ABREVIACION_ID);

alter table SABE
   add constraint FK_SABE_SABE_IDIOMA foreign key (ABREVIACION_ID)
      references IDIOMA (ABREVIACION_ID);

alter table SABE
   add constraint FK_SABE_SABE2_USUARIO foreign key (CORREO_US)
      references USUARIO (CORREO_US);

alter table SABE_REVISOR
   add constraint FK_SABE_REV_SABE_REVI_USUARIO foreign key (CORREO_US)
      references USUARIO (CORREO_US);

alter table SABE_REVISOR
   add constraint FK_SABE_REV_SABE_REVI_REVISOR foreign key (CORREO_RE)
      references REVISOR (CORREO_RE);

