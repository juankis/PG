/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     9/14/2014 5:08:45 PM                         */
/*==============================================================*/


drop index RELATIONSHIP_7_FK;

drop index RELATIONSHIP_6_FK;

drop index COLCHON_PK;

drop table COLCHON;

drop index DEPOSITO_PK;

drop table DEPOSITO;

drop index RELATIONSHIP_4_FK;

drop index RELATIONSHIP_3_FK;

drop index ENTRADA_PK;

drop table ENTRADA;

drop index ESPONJA_PK;

drop table ESPONJA;

drop index MEDIDAS_PK;

drop table MEDIDAS;

drop index RELATIONSHIP_2_FK;

drop index RELATIONSHIP_1_FK;

drop index RELACIONENTRADASALIDA_PK;

drop table RELACIONENTRADASALIDA;

drop index RELATIONSHIP_5_FK;

drop index SALIDA_PK;

drop table SALIDA;

/*==============================================================*/
/* Table: COLCHON                                               */
/*==============================================================*/
create table COLCHON (
   IDCOLCHON            SERIAL               not null,
   IDESPONJA            INT4                 null,
   IDMEDIDAS            INT4                 null,
   COLORCOLCHON         CHAR(256)            null,
   TELA                 CHAR(256)            null,
   NOMBRECOLCHON        CHAR(256)            null,
   TIPOCOLCHON          CHAR(256)            null,
   STOCKACTUAL          DECIMAL(256)         null,
   constraint PK_COLCHON primary key (IDCOLCHON)
);

/*==============================================================*/
/* Index: COLCHON_PK                                            */
/*==============================================================*/
create unique index COLCHON_PK on COLCHON (
IDCOLCHON
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on COLCHON (
IDESPONJA
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on COLCHON (
IDMEDIDAS
);

/*==============================================================*/
/* Table: DEPOSITO                                              */
/*==============================================================*/
create table DEPOSITO (
   IDDEPOSITO           SERIAL               not null,
   NOMBREDEPOSITO       CHAR(256)            null,
   DIRECCION            CHAR(256)            null,
   DETALLEDEPOSITO      CHAR(256)            null,
   constraint PK_DEPOSITO primary key (IDDEPOSITO)
);

/*==============================================================*/
/* Index: DEPOSITO_PK                                           */
/*==============================================================*/
create unique index DEPOSITO_PK on DEPOSITO (
IDDEPOSITO
);

/*==============================================================*/
/* Table: ENTRADA                                               */
/*==============================================================*/
create table ENTRADA (
   IDENTRADA            SERIAL               not null,
   IDDEPOSITO           INT4                 null,
   IDCOLCHON            INT4                 null,
   CODIGOENTRADA        CHAR(256)            null,
   COSTOUNITARIO        DECIMAL              null,
   PRECIOUNITARIO       DECIMAL              null,
   TOTALCOSTO           DECIMAL              null,
   TOTALMAYOR           DECIMAL              null,
   STOCKENTRADA         DECIMAL              null,
   CANTIDADENTRADA      DECIMAL              null,
   FECHAENTRADA         DATE                 null,
   DETALLEENTRADA       CHAR(256)            null,
   constraint PK_ENTRADA primary key (IDENTRADA)
);

/*==============================================================*/
/* Index: ENTRADA_PK                                            */
/*==============================================================*/
create unique index ENTRADA_PK on ENTRADA (
IDENTRADA
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on ENTRADA (
IDDEPOSITO
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on ENTRADA (
IDCOLCHON
);

/*==============================================================*/
/* Table: ESPONJA                                               */
/*==============================================================*/
create table ESPONJA (
   IDESPONJA            SERIAL               not null,
   MATERIAL             CHAR(256)            null,
   COLORESPONJA         CHAR(256)            null,
   CODIGOESPONJA        CHAR(256)            null,
   constraint PK_ESPONJA primary key (IDESPONJA)
);

/*==============================================================*/
/* Index: ESPONJA_PK                                            */
/*==============================================================*/
create unique index ESPONJA_PK on ESPONJA (
IDESPONJA
);

/*==============================================================*/
/* Table: MEDIDAS                                               */
/*==============================================================*/
create table MEDIDAS (
   IDMEDIDAS            SERIAL               not null,
   ANCHO                CHAR(256)            null,
   LARGO                CHAR(256)            null,
   GROSOR               CHAR(256)            null,
   PLAZAS               CHAR(256)            null,
   CODIGOMEDIDAS        CHAR(256)            null,
   constraint PK_MEDIDAS primary key (IDMEDIDAS)
);

/*==============================================================*/
/* Index: MEDIDAS_PK                                            */
/*==============================================================*/
create unique index MEDIDAS_PK on MEDIDAS (
IDMEDIDAS
);

/*==============================================================*/
/* Table: RELACIONENTRADASALIDA                                 */
/*==============================================================*/
create table RELACIONENTRADASALIDA (
   IDRELACIONENTRADASALIDA SERIAL               not null,
   IDSALIDA             INT4                 null,
   IDENTRADA            INT4                 null,
   CANTIDADRELENTRSAL   DECIMAL              null,
   constraint PK_RELACIONENTRADASALIDA primary key (IDRELACIONENTRADASALIDA)
);

/*==============================================================*/
/* Index: RELACIONENTRADASALIDA_PK                              */
/*==============================================================*/
create unique index RELACIONENTRADASALIDA_PK on RELACIONENTRADASALIDA (
IDRELACIONENTRADASALIDA
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on RELACIONENTRADASALIDA (
IDENTRADA
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on RELACIONENTRADASALIDA (
IDSALIDA
);

/*==============================================================*/
/* Table: SALIDA                                                */
/*==============================================================*/
create table SALIDA (
   IDSALIDA             SERIAL               not null,
   IDCOLCHON            INT4                 null,
   FECHASALIDA          DATE                 null,
   CANTIDADSALIDA       DECIMAL              null,
   DETALLESALIDA        CHAR(256)            null,
   constraint PK_SALIDA primary key (IDSALIDA)
);

/*==============================================================*/
/* Index: SALIDA_PK                                             */
/*==============================================================*/
create unique index SALIDA_PK on SALIDA (
IDSALIDA
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on SALIDA (
IDCOLCHON
);

alter table COLCHON
   add constraint FK_COLCHON_RELATIONS_ESPONJA foreign key (IDESPONJA)
      references ESPONJA (IDESPONJA)
      on delete restrict on update restrict;

alter table COLCHON
   add constraint FK_COLCHON_RELATIONS_MEDIDAS foreign key (IDMEDIDAS)
      references MEDIDAS (IDMEDIDAS)
      on delete restrict on update restrict;

alter table ENTRADA
   add constraint FK_ENTRADA_RELATIONS_DEPOSITO foreign key (IDDEPOSITO)
      references DEPOSITO (IDDEPOSITO)
      on delete restrict on update restrict;

alter table ENTRADA
   add constraint FK_ENTRADA_RELATIONS_COLCHON foreign key (IDCOLCHON)
      references COLCHON (IDCOLCHON)
      on delete restrict on update restrict;

alter table RELACIONENTRADASALIDA
   add constraint FK_RELACION_RELATIONS_ENTRADA foreign key (IDENTRADA)
      references ENTRADA (IDENTRADA)
      on delete restrict on update restrict;

alter table RELACIONENTRADASALIDA
   add constraint FK_RELACION_RELATIONS_SALIDA foreign key (IDSALIDA)
      references SALIDA (IDSALIDA)
      on delete restrict on update restrict;

alter table SALIDA
   add constraint FK_SALIDA_RELATIONS_COLCHON foreign key (IDCOLCHON)
      references COLCHON (IDCOLCHON)
      on delete restrict on update restrict;

