/*Creacion de tabla LOG*/
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

/* trigger de idiomas*/
CREATE OR REPLACE TRIGGER idioma_log
AFTER INSERT OR UPDATE OR DELETE ON "Idioma"
   REFERENCING OLD AS antiguo NEW AS nuevo
   FOR EACH ROW
   DECLARE
      id_log NUMBER;
      nick_log VARCHAR2(30);
      rol_log VARCHAR2(30);
      sql_log VARCHAR2(250);
BEGIN
     SELECT COUNT(*)+1 INTO id_log FROM LOG;
     SELECT sys_context('USERENV','HOST') INTO nick_log FROM dual;
     SELECT user INTO rol_log FROM dual;
  IF INSERTING THEN
     sql_log:=CONCAT('Insert ',:nuevo."descripcion");
  END IF;
  IF DELETING  THEN
     sql_log:=CONCAT('Eliminado ',:antiguo."descripcion");
  END IF;
  IF UPDATING  THEN
     sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."descripcion"),' a '),:nuevo."descripcion");
  END IF;
  INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Idioma',CURRENT_TIMESTAMP,id_log);
END;

/* trigger de usuarios*/
CREATE OR REPLACE TRIGGER usuario_log
AFTER INSERT OR UPDATE OR DELETE ON "Usuario"
   REFERENCING OLD AS antiguo NEW AS nuevo
   FOR EACH ROW
   DECLARE
      id_log NUMBER;
      nick_log VARCHAR2(30);
      rol_log VARCHAR2(30);
      sql_log VARCHAR2(250);
BEGIN
     SELECT COUNT(*)+1 INTO id_log FROM LOG;
     SELECT sys_context('USERENV','HOST') INTO nick_log FROM dual;
     SELECT user INTO rol_log FROM dual;
  IF INSERTING THEN
     sql_log:=CONCAT('Insert ',:nuevo."Correo_us");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Usuario',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF DELETING  THEN
     sql_log:=CONCAT('Eliminado ',:antiguo."Correo_us");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Usuario',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF UPDATING  THEN
     IF antiguo."Correo_us"!=nuevo."Correo_us" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Correo_us"),' a '),:nuevo."Correo_us");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Usuario',CURRENT_TIMESTAMP,id_log);
     END IF;
     IF antiguo."Nombre_us"!=nuevo."Nombre_us" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Nombre_us"),' a '),:nuevo."Nombre_us");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Usuario',CURRENT_TIMESTAMP,id_log);
     END IF;
     IF antiguo."Contrasena_us"!=nuevo."Contrasena_us" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Contrasena_us"),' a '),:nuevo."Contrasena_us");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Usuario',CURRENT_TIMESTAMP,id_log);
     END IF;
  END IF;
END;

/* trigger de peticiones*/
CREATE OR REPLACE TRIGGER peticion_log
AFTER INSERT OR UPDATE OR DELETE ON "Peticion"
   REFERENCING OLD AS antiguo NEW AS nuevo
   FOR EACH ROW
   DECLARE
      id_log NUMBER;
      nick_log VARCHAR2(30);
      rol_log VARCHAR2(30);
      sql_log VARCHAR2(250);
BEGIN
     SELECT COUNT(*)+1 INTO id_log FROM LOG;
     SELECT sys_context('USERENV','HOST') INTO nick_log FROM dual;
     SELECT user INTO rol_log FROM dual;
  IF INSERTING THEN
     sql_log:=CONCAT('Insert ',:nuevo."Codigo_pe");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Peticion',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF DELETING  THEN
     sql_log:=CONCAT('Eliminado ',:antiguo."Codigo_pe");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Peticion',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF UPDATING  THEN
     IF antiguo."Origen_pe"!=nuevo."Origen_pe" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Origen_pe"),' a '),:nuevo."Origen_pe");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Peticion',CURRENT_TIMESTAMP,id_log);
     END IF;
     IF antiguo."Destino_pe"!=nuevo."Destino_pe" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Destino_pe"),' a '),:nuevo."Destino_pe");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Peticion',CURRENT_TIMESTAMP,id_log);
     END IF;
     IF antiguo."Descripcion_pe"!=nuevo."Descripcion_pe" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Descripcion_pe"),' a '),:nuevo."Descripcion_pe");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Peticion',CURRENT_TIMESTAMP,id_log);
     END IF;
  END IF;
END;

/* trigger de revisores*/
CREATE OR REPLACE TRIGGER revisor_log
AFTER INSERT OR UPDATE OR DELETE ON "Revisor"
   REFERENCING OLD AS antiguo NEW AS nuevo
   FOR EACH ROW
   DECLARE
      id_log NUMBER;
      nick_log VARCHAR2(30);
      rol_log VARCHAR2(30);
      sql_log VARCHAR2(250);
BEGIN
     SELECT COUNT(*)+1 INTO id_log FROM LOG;
     SELECT sys_context('USERENV','HOST') INTO nick_log FROM dual;
     SELECT user INTO rol_log FROM dual;
  IF INSERTING THEN
     sql_log:=CONCAT('Insert ',:nuevo."CorreoElectronico_re");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Revisor',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF DELETING  THEN
     sql_log:=CONCAT('Eliminado ',:antiguo."CorreoElectronico_re");
     INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Revisor',CURRENT_TIMESTAMP,id_log);
  END IF;
  IF UPDATING  THEN
     IF antiguo."CorreoElectronico_re"!=nuevo."CorreoElectronico_re" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."CorreoElectronico_re"),' a '),:nuevo."CorreoElectronico_re");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Revisor',CURRENT_TIMESTAMP,id_log);
     END IF;
     IF antiguo."Nombre_re"!=nuevo."Nombre_re" THEN
        sql_log:=CONCAT(CONCAT(CONCAT('Actualizado ',:antiguo."Nombre_re"),' a '),:nuevo."Nombre_re");
        INSERT INTO LOG ("Nick_log","Rol_log","sql_log","tabla_log","fecha_log","id_log") VALUES (nick_log,rol_log,sql_log,'Revisor',CURRENT_TIMESTAMP,id_log);
     END IF;
  END IF;
END;