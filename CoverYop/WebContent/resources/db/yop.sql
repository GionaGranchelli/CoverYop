--------------------------------------------------------
--  File creato - martedì-aprile-21-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ALBUMFOTOGRAFICO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."ALBUMFOTOGRAFICO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence ALBUM_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."ALBUM_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CANZONE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."CANZONE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence COMPONENTE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."COMPONENTE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CONVERSATION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."CONVERSATION_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EVENTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."EVENTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence FOTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."FOTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GENERE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."GENERE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GRUPPODIRIFERIMENTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."GRUPPODIRIFERIMENTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence GRUPPO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."GRUPPO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOCALE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."LOCALE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MESSAGE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."MESSAGE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence RUOLO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."RUOLO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SCALETTA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."SCALETTA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence STRUMENTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."STRUMENTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TIPOLOGIAEVENTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."TIPOLOGIAEVENTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TOUR_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."TOUR_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence UTENTE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."UTENTE_SEQ"  MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence VIDEO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "YOP"."VIDEO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ALBUM
--------------------------------------------------------

  CREATE TABLE "YOP"."ALBUM" 
   (	"ID" NUMBER(10,0), 
	"ANNO" NUMBER(10,0), 
	"DURATA" NUMBER(19,4), 
	"NOME" VARCHAR2(255 BYTE), 
	"GRUPPO_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ALBUMFOTOGRAFICO
--------------------------------------------------------

  CREATE TABLE "YOP"."ALBUMFOTOGRAFICO" 
   (	"ID" NUMBER(10,0), 
	"DATA" DATE, 
	"LUOGO" VARCHAR2(255 BYTE), 
	"TAG" VARCHAR2(255 BYTE), 
	"TITOLO" VARCHAR2(255 BYTE), 
	"UTENTE_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CANZONE
--------------------------------------------------------

  CREATE TABLE "YOP"."CANZONE" 
   (	"ID" NUMBER(10,0), 
	"DURATA" NUMBER(19,4), 
	"TITOLO" VARCHAR2(255 BYTE), 
	"URL" VARCHAR2(255 BYTE), 
	"ALBUM_ID" NUMBER(10,0), 
	"SCALETTA_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table COMPONENTE
--------------------------------------------------------

  CREATE TABLE "YOP"."COMPONENTE" 
   (	"ID" NUMBER(10,0), 
	"BIO" VARCHAR2(255 BYTE), 
	"COGNOME" VARCHAR2(255 BYTE), 
	"NASCITA" DATE, 
	"NICKNAME" VARCHAR2(255 BYTE), 
	"NOME" VARCHAR2(255 BYTE), 
	"GRUPPO_USER_ID" NUMBER(10,0), 
	"STRUMENTO_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CONVERSATION
--------------------------------------------------------

  CREATE TABLE "YOP"."CONVERSATION" 
   (	"ID" NUMBER(10,0), 
	"DATA" TIMESTAMP (6), 
	"STATUS" NUMBER(10,0), 
	"TITOLO" VARCHAR2(255 BYTE), 
	"DESTINATARIO_ID" NUMBER(10,0), 
	"MITTENTE_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EVENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."EVENTO" 
   (	"ID" NUMBER(10,0), 
	"DATA" VARCHAR2(255 BYTE), 
	"DESCRIZIONE" VARCHAR2(255 BYTE), 
	"LOCANDINA" VARCHAR2(255 BYTE), 
	"LUOGO" VARCHAR2(255 BYTE), 
	"NOME" VARCHAR2(255 BYTE), 
	"ORARIOFINE" VARCHAR2(255 BYTE), 
	"ORARIOINIZIO" VARCHAR2(255 BYTE), 
	"PREZZO" NUMBER(19,4), 
	"LOCALE_USER_ID" NUMBER(10,0), 
	"TOUR_ID" NUMBER(10,0), 
	"TIPOLOGIA_EVENTI_ID" NUMBER(10,0), 
	"STATUS" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FOTO
--------------------------------------------------------

  CREATE TABLE "YOP"."FOTO" 
   (	"ID" NUMBER(10,0), 
	"URL" VARCHAR2(255 BYTE), 
	"ALBUMFOTOGRAFICOID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GENERE
--------------------------------------------------------

  CREATE TABLE "YOP"."GENERE" 
   (	"ID" NUMBER(10,0), 
	"GENERE" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GRUPPO
--------------------------------------------------------

  CREATE TABLE "YOP"."GRUPPO" 
   (	"GRUPPO_ID" NUMBER(10,0), 
	"BIOGRAFIA" VARCHAR2(2550 BYTE), 
	"COVER_BAND" NUMBER(10,0), 
	"DATA" DATE, 
	"NOMEGRUPPO" VARCHAR2(255 BYTE), 
	"CONSUMAZIONI" NUMBER(10,0), 
	"PREZZO" NUMBER(19,4), 
	"RIMBORSOSPESE" NUMBER(10,0), 
	"AMPLIFICATORE" NUMBER(1,0) DEFAULT 0, 
	"BATTERIA" NUMBER(1,0) DEFAULT 0, 
	"CASSE" NUMBER(19,4), 
	"LUCI" NUMBER(1,0) DEFAULT 0, 
	"MICROFONO" NUMBER(1,0) DEFAULT 0, 
	"MIXER" NUMBER(10,0), 
	"PALCO" NUMBER(1,0) DEFAULT 0, 
	"SCALETTA_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GRUPPODIRIFERIMENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."GRUPPODIRIFERIMENTO" 
   (	"ID" NUMBER(10,0), 
	"NOME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GRUPPO_EVENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."GRUPPO_EVENTO" 
   (	"EVENTI_ID" NUMBER(10,0), 
	"GRUPPO_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GRUPPO_GENERE
--------------------------------------------------------

  CREATE TABLE "YOP"."GRUPPO_GENERE" 
   (	"GENERI_ID" NUMBER(10,0), 
	"GRUPPO_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table GRUPPO_GRUPPODIRIFERIMENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" 
   (	"GRUPPO_USER_ID" NUMBER(10,0), 
	"GRUPPI_RIF_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LOCALE
--------------------------------------------------------

  CREATE TABLE "YOP"."LOCALE" 
   (	"LOCALE_ID" NUMBER(10,0), 
	"CONTATTI" BLOB, 
	"DESCRIZIONE" VARCHAR2(255 BYTE), 
	"NOMELOCALE" VARCHAR2(255 BYTE), 
	"ORARIOAPERTURA" VARCHAR2(255 BYTE), 
	"ORARIOCHIUSURA" VARCHAR2(255 BYTE), 
	"NOMECAT" VARCHAR2(255 BYTE), 
	"AMPLIFICATORE" NUMBER(1,0) DEFAULT 0, 
	"BATTERIA" NUMBER(1,0) DEFAULT 0, 
	"CASSE" NUMBER(19,4), 
	"LUCI" NUMBER(1,0) DEFAULT 0, 
	"MICROFONO" NUMBER(1,0) DEFAULT 0, 
	"MIXER" NUMBER(10,0), 
	"PALCO" NUMBER(1,0) DEFAULT 0, 
	"DESCRIZIONECAT" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("CONTATTI") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table MESSAGE
--------------------------------------------------------

  CREATE TABLE "YOP"."MESSAGE" 
   (	"ID" NUMBER(10,0), 
	"DATA" TIMESTAMP (6), 
	"STATUS" NUMBER(10,0), 
	"TEXT" VARCHAR2(255 BYTE), 
	"AUTORE_ID" NUMBER(10,0), 
	"CONVERSATION_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RUOLO
--------------------------------------------------------

  CREATE TABLE "YOP"."RUOLO" 
   (	"ID" NUMBER(10,0), 
	"DESCRIZIONE" VARCHAR2(255 BYTE), 
	"NOME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SCALETTA
--------------------------------------------------------

  CREATE TABLE "YOP"."SCALETTA" 
   (	"ID" NUMBER(10,0), 
	"DURATA" NUMBER(19,4), 
	"GRUPPO_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SEQUENCE
--------------------------------------------------------

  CREATE TABLE "YOP"."SEQUENCE" 
   (	"SEQ_NAME" VARCHAR2(50 BYTE), 
	"SEQ_COUNT" NUMBER(38,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STRUMENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."STRUMENTO" 
   (	"ID" NUMBER(10,0), 
	"NOME" VARCHAR2(255 BYTE), 
	"TIPOLOGIA" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOLOGIAEVENTO
--------------------------------------------------------

  CREATE TABLE "YOP"."TIPOLOGIAEVENTO" 
   (	"ID" NUMBER(10,0), 
	"DESCRIZIONE" VARCHAR2(255 BYTE), 
	"NOME" VARCHAR2(255 BYTE), 
	"EVENTO_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TOUR
--------------------------------------------------------

  CREATE TABLE "YOP"."TOUR" 
   (	"ID" NUMBER(10,0), 
	"DURATA" NUMBER(10,0), 
	"NOME" VARCHAR2(255 BYTE), 
	"GRUPPO_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table UTENTE
--------------------------------------------------------

  CREATE TABLE "YOP"."UTENTE" 
   (	"USER_ID" NUMBER(10,0), 
	"TIPO" VARCHAR2(31 BYTE), 
	"CITTA" VARCHAR2(255 BYTE), 
	"COGNOME" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"INDIRIZZO" VARCHAR2(255 BYTE), 
	"LAT" NUMBER(19,4), 
	"LNG" NUMBER(19,4), 
	"NOME" VARCHAR2(255 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"TELEFONO" VARCHAR2(255 BYTE), 
	"USERNAME" VARCHAR2(255 BYTE), 
	"FACEBOOK" VARCHAR2(255 BYTE), 
	"GOOGLEPLUS" VARCHAR2(255 BYTE), 
	"INSTAGRAM" VARCHAR2(255 BYTE), 
	"SOUNDCLOUD" VARCHAR2(255 BYTE), 
	"TWITTER" VARCHAR2(255 BYTE), 
	"YOUTUBE" VARCHAR2(255 BYTE), 
	"RUOLO_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table VIDEO
--------------------------------------------------------

  CREATE TABLE "YOP"."VIDEO" 
   (	"ID" NUMBER(10,0), 
	"DATA" DATE, 
	"TAG" VARCHAR2(255 BYTE), 
	"TITOLO" VARCHAR2(255 BYTE), 
	"URL" VARCHAR2(2550 BYTE), 
	"UTENTE_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into YOP.ALBUM
SET DEFINE OFF;
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('1','2007','55','Valanghe di Cemento','1');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('2','2010','55','Il Veleno è Medicina','1');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('1702','2015','0','Casso','1');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('1952','2015','0','Singolo','5');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('2401','2015','0','Singolo','63');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4301','2015','0','Singolo','467');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4351','2015','0','Singolo','467');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4401','2015','0','East dub sound','467');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4855','2015','0','La finestra','365');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4553','2015','0','Album 2','5');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4654','2015','0','Available for Propaganda','63');
Insert into YOP.ALBUM (ID,ANNO,DURATA,NOME,GRUPPO_USER_ID) values ('4801','2015','0','Singolo','365');
REM INSERTING into YOP.ALBUMFOTOGRAFICO
SET DEFINE OFF;
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('1',null,'Pescara','profile','Immagini Profilo','1');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('2',null,'Marina','slideshow1','SlideShow','2');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3',to_date('04-FEB-15','DD-MON-RR'),'Montesilvano Beach','slideshow','Immagini Profilo','5');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4',null,'Trasacco','slideshow2',null,'1');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('5',null,null,'profile','Immagini Profilo','2');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4601',to_date('13-FEB-15','DD-MON-RR'),'Castilenti','slider','Album 356','63');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('618',to_date('10-FEB-15','DD-MON-RR'),'Montesilvano Colli','slideshow','Nuovo Album','5');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('14',to_date('11-FEB-15','DD-MON-RR'),'Roma','profile','Nuovo Album','723');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('980',to_date('12-FEB-15','DD-MON-RR'),null,'profile','Nuovo Albummmm',null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3701',null,'Silvi','slideshow',null,'805');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3801',to_date('12-FEB-15','DD-MON-RR'),'Castilenti','slideshow','album 1','63');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('2801',null,'L''aquila',null,null,null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('2851',null,'L''aquila',null,null,null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3901',to_date('12-FEB-15','DD-MON-RR'),'Castilenti','profile','Immagini del Profilo','63');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('2951',null,'L''aquila',null,null,null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3001',null,'L''aquila',null,null,null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3151',null,'Castilenti','slideshow','dsfvbfgbfg','63');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3101',to_date('14-FEB-15','DD-MON-RR'),'Montesilvano','slideshow','vdfvdf','889');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3201',null,'Castilenti',null,null,null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('550',to_date('12-FEB-15','DD-MON-RR'),null,'profile','Nuovo Album',null);
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('3751',to_date('12-FEB-15','DD-MON-RR'),'Silvi','profile','aa','805');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4151',to_date('13-FEB-15','DD-MON-RR'),'Città Sant''Angelo','profile','Immagini del Profilo Locale','617');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4051',to_date('12-FEB-15','DD-MON-RR'),'Trasacco','profile','Immagini del Profilo','467');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4201',to_date('13-FEB-15','DD-MON-RR'),'Montesilvano','profile','Immagini del Profilo Locale','889');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4701',to_date('13-FEB-15','DD-MON-RR'),'Montesilvano','profile','Immagini del Profilo','365');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('4751',to_date('13-FEB-15','DD-MON-RR'),'Montesilvano','slider','Album 798','365');
Insert into YOP.ALBUMFOTOGRAFICO (ID,DATA,LUOGO,TAG,TITOLO,UTENTE_USER_ID) values ('5051',to_date('18-FEB-15','DD-MON-RR'),'Montesilvano','profile','Immagini del Profilo','5');
REM INSERTING into YOP.CANZONE
SET DEFINE OFF;
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('2','300','Alla ricerca della Bellezza','placeholders/mp3/adg3com_cloudlessdays.mp3','1',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4','215','Perso nel Personale','placeholders/mp3/adg3com_coreissues.mp3','1',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('5','230','Cani e Porci','placeholders/mp3/adg3com_electrofreak.mp3','1',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('8','200','Sto Nero','placeholders/mp3/adg3com_bustedchump.mp3','2',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('10','300','Vento Clado','placeholders/mp3/adg3com_electrofreak.mp3','2',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('1951','0','Thodoris Triantafillou, Cj Jeff - Verona (Dario D''Attis Dubstrip Mix) Lapsus Music.mp3','placeholders/mp3/Thodoris Triantafillou, Cj Jeff - Verona (Dario D''Attis Dubstrip Mix) Lapsus Music.mp3','1952',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4651','0','Okabi -Hippie Nation (Original Mix).mp3','placeholders/mp3/Okabi -Hippie Nation (Original Mix).mp3','4654',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4552','0','Crocodile Soup - Sublime Passion (Original Mix) BAILE MUSIK 039.mp3','placeholders/mp3/Crocodile Soup - Sublime Passion (Original Mix) BAILE MUSIK 039.mp3','4553',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4551','0','East End Dubs - Argo.mp3','placeholders/mp3/East End Dubs - Argo.mp3','4553',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4653','0','Pleasurekraft - Anubis (Mike Vale Remix).mp3','placeholders/mp3/Pleasurekraft - Anubis (Mike Vale Remix).mp3','4654',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4652','0','UMEK &amp; Siwell - You Get Used To All The Madness (Original Mix) [1605-119].mp3','placeholders/mp3/UMEK &amp; Siwell - You Get Used To All The Madness (Original Mix) [1605-119].mp3','4654',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4802','0','Bontan - Move On Out.mp3','placeholders/mp3/Bontan - Move On Out.mp3','4801',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4854','0','It''s all in the light (Nacho XXX Mashup Remix).mp3','placeholders/mp3/It''s all in the light (Nacho XXX Mashup Remix).mp3','4855',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4856','0','Kolombo, Sammy W &amp; Alex E - Play ur Chick (Original Mix).mp3','placeholders/mp3/Kolombo, Sammy W &amp; Alex E - Play ur Chick (Original Mix).mp3','4855',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4852','0','Homework - The Way I See It feat. Bea Anubis _ TSTLM.mp3','placeholders/mp3/Homework - The Way I See It feat. Bea Anubis _ TSTLM.mp3','4855',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4851','0','Kreature - Pluvial (Original Mix).mp3','placeholders/mp3/Kreature - Pluvial (Original Mix).mp3','4855',null);
Insert into YOP.CANZONE (ID,DURATA,TITOLO,URL,ALBUM_ID,SCALETTA_ID) values ('4853','0','DJ Wady  &amp; Juanmy.R - Umbria (Original Mix).mp3','placeholders/mp3/DJ Wady  &amp; Juanmy.R - Umbria (Original Mix).mp3','4855',null);
REM INSERTING into YOP.COMPONENTE
SET DEFINE OFF;
Insert into YOP.COMPONENTE (ID,BIO,COGNOME,NASCITA,NICKNAME,NOME,GRUPPO_USER_ID,STRUMENTO_ID) values ('1','Alessio Guardiani un rapper di Pescara nato nell'' 89 con tanta voglia di spaccare i culi','Guardiani',null,'Stabber','Alessio','1','4');
Insert into YOP.COMPONENTE (ID,BIO,COGNOME,NASCITA,NICKNAME,NOME,GRUPPO_USER_ID,STRUMENTO_ID) values ('2','Er Dase Sulla traccia','Di Nardo',null,'Er Dase','Claudio','1','4');
REM INSERTING into YOP.CONVERSATION
SET DEFINE OFF;
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('1',to_timestamp('05-FEB-15 10:31:27,699000000','DD-MON-RR HH24:MI:SSXFF'),'1','ciao','2','1');
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('2',to_timestamp('05-FEB-15 10:31:45,880000000','DD-MON-RR HH24:MI:SSXFF'),'1','helow','2','1');
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('582',to_timestamp('10-FEB-15 18:12:38,970000000','DD-MON-RR HH24:MI:SSXFF'),'0','ciao','617','5');
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('296',to_timestamp('13-FEB-15 10:05:34,209000000','DD-MON-RR HH24:MI:SSXFF'),'0','Ciao','2','1');
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('827',to_timestamp('18-FEB-15 10:43:11,134000000','DD-MON-RR HH24:MI:SSXFF'),'0','Invito a suonare','1','2');
Insert into YOP.CONVERSATION (ID,DATA,STATUS,TITOLO,DESTINATARIO_ID,MITTENTE_ID) values ('823',to_timestamp('18-FEB-15 11:08:10,568000000','DD-MON-RR HH24:MI:SSXFF'),'10','Proposta Evento','1','2');
REM INSERTING into YOP.EVENTO
SET DEFINE OFF;
Insert into YOP.EVENTO (ID,DATA,DESCRIZIONE,LOCANDINA,LUOGO,NOME,ORARIOFINE,ORARIOINIZIO,PREZZO,LOCALE_USER_ID,TOUR_ID,TIPOLOGIA_EVENTI_ID,STATUS) values ('1','2015/03/01','Eventissimo','esplosive.jpg','Città Sant''Angelo','Concerto CE @LD','01:00','22:00','5','2',null,'1','11');
Insert into YOP.EVENTO (ID,DATA,DESCRIZIONE,LOCANDINA,LUOGO,NOME,ORARIOFINE,ORARIOINIZIO,PREZZO,LOCALE_USER_ID,TOUR_ID,TIPOLOGIA_EVENTI_ID,STATUS) values ('2','2015/02/14','Pazzesco','ciufillo.jpg','Pescara','Back to ibiza','04:00','01:00','10','2',null,'2',null);
Insert into YOP.EVENTO (ID,DATA,DESCRIZIONE,LOCANDINA,LUOGO,NOME,ORARIOFINE,ORARIOINIZIO,PREZZO,LOCALE_USER_ID,TOUR_ID,TIPOLOGIA_EVENTI_ID,STATUS) values ('5001','02/02/2015','Evento spettacolare da pazzi','C:\eclipse\5\event\evento.jpg','Città Sant''Angelo','Bellissimo','21:35','07:35','10','2',null,'2','11');
Insert into YOP.EVENTO (ID,DATA,DESCRIZIONE,LOCANDINA,LUOGO,NOME,ORARIOFINE,ORARIOINIZIO,PREZZO,LOCALE_USER_ID,TOUR_ID,TIPOLOGIA_EVENTI_ID,STATUS) values ('5251','02/28/2015','Sabato 28 Febbraio avremo l''onore di ospitare il gruppo Rap/Hardcore che sta spopolando sulla costiera adriatica e non solo.
Carichi per cariche esplosive!!!!',null,'Città Sant''Angelo','Concerto Cariche Esplosive','02:05','21:05','5','2',null,'1','10');
REM INSERTING into YOP.FOTO
SET DEFINE OFF;
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('1','resources/img/profile/1/cariche.jpg','1');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('2','resources/img/profile/33/image01.jpg','4');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('3','resources/img/profile/2/profile.jpg','2');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('741','resources/img/profile/5/matteo2.jpg','5051');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('5151',null,null);
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('356','resources/img/profile/63/vecchie.jpg','4601');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('7','resources/img/profile/2/profile1.jpg','5');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('2051','resources/img/profile/34/litfiba.jpg','14');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('2201','resources/img/profile/889/sliderbar1.jpg','3101');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('2151','resources/img/profile/889/sliderbar.jpg','3101');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('633','resources/img/profile/805/adriano.jpg','3751');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('144','resources/img/profile/805/adriano.jpg','3701');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('280','resources/img/profile/63/1.jpg','2801');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('939','resources/img/profile/63/adriano.jpg','3801');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('29','resources/img/profile/617/bar.jpg','4151');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('293','resources/img/profile/63/manuale.jpg','3901');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('155','resources/img/profile/63/aaaaaa.jpg','2851');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('3951','resources/img/profile/412/matteo.jpg','550');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('133','resources/img/profile/63/1.jpg','2951');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('773','resources/img/profile/63/1.jpg','3001');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('715','resources/img/profile/63/aaaaaaa.jpg','3201');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('489','resources/img/profile/467/profile.jpg','4051');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('744','resources/img/profile/889/km0.jpg','4201');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('357','resources/img/profile/63/villalobos.jpg','4601');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('317','resources/img/profile/365/manduria.jpg','4701');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('798','resources/img/profile/365/11.jpg','4751');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('799','resources/img/profile/365/12.jpg','4751');
Insert into YOP.FOTO (ID,URL,ALBUMFOTOGRAFICOID) values ('4951','C:\eclipse\5\event\evento.jpg',null);
REM INSERTING into YOP.GENERE
SET DEFINE OFF;
Insert into YOP.GENERE (ID,GENERE) values ('1','Rap');
Insert into YOP.GENERE (ID,GENERE) values ('2','Rock');
Insert into YOP.GENERE (ID,GENERE) values ('3','Metal');
Insert into YOP.GENERE (ID,GENERE) values ('4','Neo Melodico');
Insert into YOP.GENERE (ID,GENERE) values ('6','Rap Militante');
Insert into YOP.GENERE (ID,GENERE) values ('5','Rock''n''Roll');
Insert into YOP.GENERE (ID,GENERE) values ('7','DeepHouse');
REM INSERTING into YOP.GRUPPO
SET DEFINE OFF;
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('1','Cariche Esplosive è uno dei principali gruppi rap nell''''underground abruzzese, dall''''attitudine hardcore e dallo stile conscious. Nasce nel 2006 dall''''incontro di Dase e Stabber M.C.
Motivati agli albori dalle produzioni di Eko (writer e componente di Costa Nostra, colonna portante del rap italiano) intrapresero la scalata nella crescita musicale, facendo girare tracce non ufficiali dal grande impatto emotivo e stilistico. Nel 2010, con la cura musicale del Dottor Nove, vede la luce il primo disco autoprodotto: "Valanghe di Cemento" con beat sperimentali dalle sonorità elettroniche e dalle liriche cruente, dove nasce anche la collaborazione con C.U.B.A. Cabbal (rapper militante internazionale della costa) sensei indiscusso per Cariche Esplosive.','0',null,'Cariche Esplosive','1','300','1','0','0','0','0','2','1','0','1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('5','Ciufillo è un DJ famosissimo grazie alle sue abilità mostruose..
Si imbatte nella notte con la sua musica tenebrosa e rinascimentale dando un tocco dark all''esperienza uditiva','0',to_date('07-LUG-90','DD-MON-RR'),'Ciufillo DJ','1','200','1','1','0','1','1','1','1','0','1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('723','Ciao i litfiba sono molto forti per avr fatto rock molto anni 90 ','0',to_date('07-MAG-01','DD-MON-RR'),'Litfiba',null,null,null,null,null,null,null,null,null,null,'1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('805','Organetto da orbi','0',to_date('07-MAG-01','DD-MON-RR'),'Loris e Lasua Band',null,null,null,null,null,null,null,null,null,null,'1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('63','sono il top','0',to_date('07-MAG-01','DD-MON-RR'),'Manuale civile',null,null,null,null,null,null,null,null,null,null,'1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('467','cia mo sei arrivato','0',to_date('07-MAG-01','DD-MON-RR'),'Blasebian',null,null,null,null,null,null,null,null,null,null,'1');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('365','I Negramaro sono un gruppo pop rock italiano che trae il nome dal Negroamaro, un vitigno della terra d''origine della band, nella zona del Salento, in Puglia[7].

La band è formata da sei componenti: Giuliano Sangiorgi (voce, chitarra, piano), Emanuele Spedicato (chitarra), Ermanno Carlà (basso), Danilo Tasco (batteria), Andrea Mariano (piano, tastiera e sintetizzatore), Andrea De Rocco (campionatore).','0',to_date('07-MAG-01','DD-MON-RR'),'Negroamaro',null,null,null,null,null,null,null,null,null,null,'4857');
Insert into YOP.GRUPPO (GRUPPO_ID,BIOGRAFIA,COVER_BAND,DATA,NOMEGRUPPO,CONSUMAZIONI,PREZZO,RIMBORSOSPESE,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,SCALETTA_ID) values ('6','ciao','0',to_date('07-MAG-01','DD-MON-RR'),'I ludovichi',null,null,null,null,null,null,null,null,null,null,null);
REM INSERTING into YOP.GRUPPODIRIFERIMENTO
SET DEFINE OFF;
Insert into YOP.GRUPPODIRIFERIMENTO (ID,NOME) values ('1','Led Zeppelin');
Insert into YOP.GRUPPODIRIFERIMENTO (ID,NOME) values ('2','Black Sabbath');
Insert into YOP.GRUPPODIRIFERIMENTO (ID,NOME) values ('3','Deep Purple');
Insert into YOP.GRUPPODIRIFERIMENTO (ID,NOME) values ('4','Krs One');
Insert into YOP.GRUPPODIRIFERIMENTO (ID,NOME) values ('5','Tu Pac');
REM INSERTING into YOP.GRUPPO_EVENTO
SET DEFINE OFF;
Insert into YOP.GRUPPO_EVENTO (EVENTI_ID,GRUPPO_USER_ID) values ('1','1');
Insert into YOP.GRUPPO_EVENTO (EVENTI_ID,GRUPPO_USER_ID) values ('1','5');
Insert into YOP.GRUPPO_EVENTO (EVENTI_ID,GRUPPO_USER_ID) values ('2','5');
Insert into YOP.GRUPPO_EVENTO (EVENTI_ID,GRUPPO_USER_ID) values ('5001','5');
Insert into YOP.GRUPPO_EVENTO (EVENTI_ID,GRUPPO_USER_ID) values ('5251','1');
REM INSERTING into YOP.GRUPPO_GENERE
SET DEFINE OFF;
Insert into YOP.GRUPPO_GENERE (GENERI_ID,GRUPPO_USER_ID) values ('6','1');
Insert into YOP.GRUPPO_GENERE (GENERI_ID,GRUPPO_USER_ID) values ('7','5');
REM INSERTING into YOP.GRUPPO_GRUPPODIRIFERIMENTO
SET DEFINE OFF;
REM INSERTING into YOP.LOCALE
SET DEFINE OFF;
Insert into YOP.LOCALE (LOCALE_ID,DESCRIZIONE,NOMELOCALE,ORARIOAPERTURA,ORARIOCHIUSURA,NOMECAT,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,DESCRIZIONECAT) values ('2','LLost Dogs è un Bar, TOP','Lost Dogs','09:00','02:00','DavideLD','0','0','0','1','0','2','0',null);
Insert into YOP.LOCALE (LOCALE_ID,DESCRIZIONE,NOMELOCALE,ORARIOAPERTURA,ORARIOCHIUSURA,NOMECAT,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,DESCRIZIONECAT) values ('617','E'' il bar più loffio di madonna della Pace nonchè unico.
Puoi trovare haschis,cocaina e tanti bicchieri per allegrare  il tuo preserata.','Caffè del Conte','21   ','24','Bar','1','0','1','0','0','1','0','Ti spassi tanto');
Insert into YOP.LOCALE (LOCALE_ID,DESCRIZIONE,NOMELOCALE,ORARIOAPERTURA,ORARIOCHIUSURA,NOMECAT,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,DESCRIZIONECAT) values ('889','Bar Top di montesilvano','KM0','21 ','24','Bar','0','0','0','0','0','0','0',null);
Insert into YOP.LOCALE (LOCALE_ID,DESCRIZIONE,NOMELOCALE,ORARIOAPERTURA,ORARIOCHIUSURA,NOMECAT,AMPLIFICATORE,BATTERIA,CASSE,LUCI,MICROFONO,MIXER,PALCO,DESCRIZIONECAT) values ('3','E'' un bar bellissimo','Bar Teti','21','24',null,null,null,null,null,null,null,null,null);
REM INSERTING into YOP.MESSAGE
SET DEFINE OFF;
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('1',to_timestamp('13-FEB-15 10:32:26,021000000','DD-MON-RR HH24:MI:SSXFF'),'1','o ciao','1','1');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('2',to_timestamp('06-FEB-15 10:32:52,021000000','DD-MON-RR HH24:MI:SSXFF'),'2','sdfdadfsdf','1','2');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('3',to_timestamp('14-FEB-15 16:16:52,201000000','DD-MON-RR HH24:MI:SSXFF'),'1',' mò sei arrivato?','2','1');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('4',to_timestamp('15-FEB-15 16:17:53,893000000','DD-MON-RR HH24:MI:SSXFF'),'1','no è già da un pezzo','1','1');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('2001',to_timestamp('10-FEB-15 18:12:38,970000000','DD-MON-RR HH24:MI:SSXFF'),'1','Ciao lorenzo vorrei sapere se posso venire a suonare da te ','5','582');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('848',to_timestamp('10-FEB-15 18:15:02,480000000','DD-MON-RR HH24:MI:SSXFF'),'1','Certo Matteo. Sei il benvenuto','617','582');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('4451',to_timestamp('13-FEB-15 10:05:34,209000000','DD-MON-RR HH24:MI:SSXFF'),'1','Ciao Davide possimo venire a suonare da te?','1','296');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('837',to_timestamp('13-FEB-15 10:06:25,664000000','DD-MON-RR HH24:MI:SSXFF'),'1','Va bo.... quanto vi prenderte?','2','296');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('5101',to_timestamp('18-FEB-15 10:43:11,134000000','DD-MON-RR HH24:MI:SSXFF'),'1','Ciao Cariche Eslosive.....sto Organizzando Una serata nel mio lcale il 28 marzo.VOlete venire a cantare insieme a ciufillo DJ?','2','827');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('82',to_timestamp('18-FEB-15 10:45:52,977000000','DD-MON-RR HH24:MI:SSXFF'),'1','carto Caro davide....siamo leti di essere invitati da un locale come il tuo...OK RAGA','1','827');
Insert into YOP.MESSAGE (ID,DATA,STATUS,TEXT,AUTORE_ID,CONVERSATION_ID) values ('5201',to_timestamp('18-FEB-15 11:08:10,568000000','DD-MON-RR HH24:MI:SSXFF'),'1','Ciao Voglio Proporti un Evento ChiamatoConcerto Cariche Esplosive','2','823');
REM INSERTING into YOP.RUOLO
SET DEFINE OFF;
Insert into YOP.RUOLO (ID,DESCRIZIONE,NOME) values ('1','qualcosa','group');
Insert into YOP.RUOLO (ID,DESCRIZIONE,NOME) values ('2','Qualcos''altro','local');
REM INSERTING into YOP.SCALETTA
SET DEFINE OFF;
Insert into YOP.SCALETTA (ID,DURATA,GRUPPO_USER_ID) values ('1',null,'1');
Insert into YOP.SCALETTA (ID,DURATA,GRUPPO_USER_ID) values ('4803','100',null);
Insert into YOP.SCALETTA (ID,DURATA,GRUPPO_USER_ID) values ('4857','100',null);
REM INSERTING into YOP.SEQUENCE
SET DEFINE OFF;
Insert into YOP.SEQUENCE (SEQ_NAME,SEQ_COUNT) values ('SEQ_GEN','5300');
REM INSERTING into YOP.STRUMENTO
SET DEFINE OFF;
Insert into YOP.STRUMENTO (ID,NOME,TIPOLOGIA) values ('1','Chitarra',null);
Insert into YOP.STRUMENTO (ID,NOME,TIPOLOGIA) values ('2','Cantante',null);
Insert into YOP.STRUMENTO (ID,NOME,TIPOLOGIA) values ('3','Bassista',null);
Insert into YOP.STRUMENTO (ID,NOME,TIPOLOGIA) values ('4','Rapper',null);
REM INSERTING into YOP.TIPOLOGIAEVENTO
SET DEFINE OFF;
Insert into YOP.TIPOLOGIAEVENTO (ID,DESCRIZIONE,NOME,EVENTO_ID) values ('1','Concerto','Concerto','1');
Insert into YOP.TIPOLOGIAEVENTO (ID,DESCRIZIONE,NOME,EVENTO_ID) values ('2','Dj Set','DjSet','2');
REM INSERTING into YOP.TOUR
SET DEFINE OFF;
REM INSERTING into YOP.UTENTE
SET DEFINE OFF;
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('1','group','Pescara','Stabber',null,'Viale Mazzini','42,4797','14,19','Alessio','alessio','1233312312231','cariche','https://www.facebook.com/CaricheEsplosive','https://plus.google.com/105557536194909750161/posts',null,'https://soundcloud.com/cariche-esplosive','http://www.twitter.com','https://www.youtube.com/user/CaricheEsplosive','1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('2','local','Città Sant''Angelo','D''Angelo','davide.dd@libero.it','Viale Matrino, 1','42,5243','14,1406','Davide','davide','3698521470','lostdog','https://www.facebook.com/pages/Lost-Dogs-Caf%C3%A8/234690559919861',null,null,null,null,null,'2');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('5','group','Montesilvano','Comignani','matteo.comignani@gmail.com','Viale Europa, 1','42,5126','14,1552','Matteo','ciufillo','08595405','ciufillo','https://www.facebook.com/matteo.comignani','https://plus.google.com/+matteocomignani/posts',null,'https://soundcloud.com/ciufillo','https://twitter.com/MatteoComignani','https://www.youtube.com/user/CIUFILLO','1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('617','local','Città Sant''Angelo','Del Conte','lorenzo.delconte@gmail.com','via madonna della pace 1','42,7401','12,6703','Lorenzo','lorenzo','08596787','lorenzo','https://www.facebook.com/caffe.delconte',null,null,null,null,null,'2');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('723','group','Roma','Terrenzio','ivan.terrenzio@gmail.com','via Italia 1','41,8984','12,4278','Ivan','ivan','123455','ivan',null,null,null,null,null,null,'1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('805','group','Silvi','Piovano','loris.piovano@gmail.com','via Roma 1','42,5449','14,1213','Loris','loris','999999999','loris',null,null,null,null,null,null,'1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('63','group','Castilenti','d''alonzo','federico@d''alonzo@gmail.it','via roma 1','42,5333','13,9178','Federico','federico','666666666','federico',null,null,null,null,null,null,'1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('467','group','Trasacco','Blasetti','matteo.blasetti@gmail.com','via roma3','41,9586','13,5353','Matteo','blasetti','867876879','blasetti',null,null,null,null,null,null,'1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('889','local','Montesilvano','Terrenzio','fabio','via vestina 2','42,5161','14,1496','Fabio','fabio','755778808','fabio',null,null,null,null,null,null,'2');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('365','group','Montesilvano','Di Francesco','daniele.difrancesco@gmail.com','viale Europa 1','42,5126','14,1552','Daniele ','daniele','0853456876','daniele',null,null,null,null,null,null,'1');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('3','local','Montesilvano','Teti','marzia.teti@gmail.com','via vestina 433','42,498','14,1298','Marzia','marzia','0987654','marzia',null,null,null,null,null,null,'2');
Insert into YOP.UTENTE (USER_ID,TIPO,CITTA,COGNOME,EMAIL,INDIRIZZO,LAT,LNG,NOME,PASSWORD,TELEFONO,USERNAME,FACEBOOK,GOOGLEPLUS,INSTAGRAM,SOUNDCLOUD,TWITTER,YOUTUBE,RUOLO_ID) values ('6','group','Montesilvano','Iovine','ludovico.iovine@gmail.com','via vestina 433','42,498','14,1298','Ludovico','ludovico','555555','ludovico',null,null,null,null,null,null,'1');
REM INSERTING into YOP.VIDEO
SET DEFINE OFF;
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('1',null,'video','Gratta Gratta e Vinci','<iframe width=''100%'' height=''450'' scrolling=''no'' frameborder=''no'' src=''https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/158692575&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true''></iframe>','1');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('2',null,'video','Com''eÌ€ che ridi ancora','<iframe width=''100%'' height=''166'' scrolling=''no'' frameborder=''no'' src=''https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/104689001&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false''></iframe>','1');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('3',null,'video','Com''eÌ€ che ridi ancora','<iframe width=''100%'' height=''166'' scrolling=''no'' frameborder=''no'' src=''https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/35343336&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false''></iframe>','1');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('1901',to_date('04-FEB-15','DD-MON-RR'),null,'Un giorno disumano','<iframe width="420" height="315" src="https://www.youtube.com/embed/Q9mKZehiDKY" frameborder="0" allowfullscreen></iframe>','5');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('13',to_date('10-FEB-15','DD-MON-RR'),'video','Bar','<iframe width="420" height="315" src="https://www.youtube.com/embed/3uwP3diz2Og" frameborder="0" allowfullscreen></iframe>','617');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('12',to_date('10-FEB-15','DD-MON-RR'),'video','Bar','<iframe width="560" height="315" src="https://www.youtube.com/embed/DBI_tNhEpU0" frameborder="0" allowfullscreen></iframe>','617');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('14',to_date('11-FEB-15','DD-MON-RR'),'video','Bar','<iframe width="420" height="315" src="https://www.youtube.com/embed/jK_tooAZb-s" frameborder="0" allowfullscreen></iframe>','2');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('2351',to_date('12-FEB-15','DD-MON-RR'),null,'ciao','<iframe width="560" height="315" src="https://www.youtube.com/embed/w0-jsUtl2wc" frameborder="0" allowfullscreen></iframe>','63');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('2751',to_date('12-FEB-15','DD-MON-RR'),null,'bella','<iframe width="420" height="315" src="https://www.youtube.com/embed/HqCAidGMTqE" frameborder="0" allowfullscreen></iframe>','63');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('4101',to_date('13-FEB-15','DD-MON-RR'),null,'Giona','<iframe width="560" height="315" src="https://www.youtube.com/embed/0b6cFWG45kA" frameborder="0" allowfullscreen></iframe>','617');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('4251',to_date('13-FEB-15','DD-MON-RR'),null,'VIdeo di presentazione','<iframe width="560" height="315" src="https://www.youtube.com/embed/DBI_tNhEpU0" frameborder="0" allowfullscreen></iframe>','889');
Insert into YOP.VIDEO (ID,DATA,TAG,TITOLO,URL,UTENTE_USER_ID) values ('4901',to_date('13-FEB-15','DD-MON-RR'),null,'La fnestra','<iframe width="420" height="315" src="https://www.youtube.com/embed/yMq3WPh1ey8" frameborder="0" allowfullscreen></iframe>','365');
--------------------------------------------------------
--  Constraints for Table CANZONE
--------------------------------------------------------

  ALTER TABLE "YOP"."CANZONE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."CANZONE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TOUR
--------------------------------------------------------

  ALTER TABLE "YOP"."TOUR" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."TOUR" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."EVENTO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."EVENTO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPPO_GENERE
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_GENERE" ADD PRIMARY KEY ("GENERI_ID", "GRUPPO_USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GRUPPO_GENERE" MODIFY ("GRUPPO_USER_ID" NOT NULL ENABLE);
  ALTER TABLE "YOP"."GRUPPO_GENERE" MODIFY ("GENERI_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table VIDEO
--------------------------------------------------------

  ALTER TABLE "YOP"."VIDEO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."VIDEO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPPODIRIFERIMENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPODIRIFERIMENTO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GRUPPODIRIFERIMENTO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CONVERSATION
--------------------------------------------------------

  ALTER TABLE "YOP"."CONVERSATION" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "YOP"."CONVERSATION" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SCALETTA
--------------------------------------------------------

  ALTER TABLE "YOP"."SCALETTA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."SCALETTA" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table UTENTE
--------------------------------------------------------

  ALTER TABLE "YOP"."UTENTE" ADD PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."UTENTE" MODIFY ("USER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPOLOGIAEVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."TIPOLOGIAEVENTO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."TIPOLOGIAEVENTO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ALBUM
--------------------------------------------------------

  ALTER TABLE "YOP"."ALBUM" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."ALBUM" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SEQUENCE
--------------------------------------------------------

  ALTER TABLE "YOP"."SEQUENCE" ADD PRIMARY KEY ("SEQ_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."SEQUENCE" MODIFY ("SEQ_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPPO_EVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_EVENTO" ADD PRIMARY KEY ("EVENTI_ID", "GRUPPO_USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GRUPPO_EVENTO" MODIFY ("GRUPPO_USER_ID" NOT NULL ENABLE);
  ALTER TABLE "YOP"."GRUPPO_EVENTO" MODIFY ("EVENTI_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOCALE
--------------------------------------------------------

  ALTER TABLE "YOP"."LOCALE" ADD PRIMARY KEY ("LOCALE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."LOCALE" MODIFY ("LOCALE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPPO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO" ADD PRIMARY KEY ("GRUPPO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GRUPPO" MODIFY ("GRUPPO_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FOTO
--------------------------------------------------------

  ALTER TABLE "YOP"."FOTO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."FOTO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STRUMENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."STRUMENTO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."STRUMENTO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RUOLO
--------------------------------------------------------

  ALTER TABLE "YOP"."RUOLO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."RUOLO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MESSAGE
--------------------------------------------------------

  ALTER TABLE "YOP"."MESSAGE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "YOP"."MESSAGE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GENERE
--------------------------------------------------------

  ALTER TABLE "YOP"."GENERE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GENERE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMPONENTE
--------------------------------------------------------

  ALTER TABLE "YOP"."COMPONENTE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."COMPONENTE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ALBUMFOTOGRAFICO
--------------------------------------------------------

  ALTER TABLE "YOP"."ALBUMFOTOGRAFICO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."ALBUMFOTOGRAFICO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table GRUPPO_GRUPPODIRIFERIMENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" ADD PRIMARY KEY ("GRUPPO_USER_ID", "GRUPPI_RIF_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" MODIFY ("GRUPPI_RIF_ID" NOT NULL ENABLE);
  ALTER TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" MODIFY ("GRUPPO_USER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ALBUM
--------------------------------------------------------

  ALTER TABLE "YOP"."ALBUM" ADD CONSTRAINT "FK_ALBUM_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ALBUMFOTOGRAFICO
--------------------------------------------------------

  ALTER TABLE "YOP"."ALBUMFOTOGRAFICO" ADD CONSTRAINT "ALBUMFOTOGRAFICOUTENTE_USER_ID" FOREIGN KEY ("UTENTE_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CANZONE
--------------------------------------------------------

  ALTER TABLE "YOP"."CANZONE" ADD CONSTRAINT "FK_CANZONE_ALBUM_ID" FOREIGN KEY ("ALBUM_ID")
	  REFERENCES "YOP"."ALBUM" ("ID") ENABLE;
  ALTER TABLE "YOP"."CANZONE" ADD CONSTRAINT "FK_CANZONE_SCALETTA_ID" FOREIGN KEY ("SCALETTA_ID")
	  REFERENCES "YOP"."SCALETTA" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMPONENTE
--------------------------------------------------------

  ALTER TABLE "YOP"."COMPONENTE" ADD CONSTRAINT "FK_COMPONENTE_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
  ALTER TABLE "YOP"."COMPONENTE" ADD CONSTRAINT "FK_COMPONENTE_STRUMENTO_ID" FOREIGN KEY ("STRUMENTO_ID")
	  REFERENCES "YOP"."STRUMENTO" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."EVENTO" ADD CONSTRAINT "FK_EVENTO_LOCALE_USER_ID" FOREIGN KEY ("LOCALE_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
  ALTER TABLE "YOP"."EVENTO" ADD CONSTRAINT "FK_EVENTO_TIPOLOGIA_EVENTI_ID" FOREIGN KEY ("TIPOLOGIA_EVENTI_ID")
	  REFERENCES "YOP"."TIPOLOGIAEVENTO" ("ID") ENABLE;
  ALTER TABLE "YOP"."EVENTO" ADD CONSTRAINT "FK_EVENTO_TOUR_ID" FOREIGN KEY ("TOUR_ID")
	  REFERENCES "YOP"."TOUR" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FOTO
--------------------------------------------------------

  ALTER TABLE "YOP"."FOTO" ADD CONSTRAINT "FK_FOTO_ALBUMFOTOGRAFICOID" FOREIGN KEY ("ALBUMFOTOGRAFICOID")
	  REFERENCES "YOP"."ALBUMFOTOGRAFICO" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPPO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO" ADD CONSTRAINT "FK_GRUPPO_GRUPPO_ID" FOREIGN KEY ("GRUPPO_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
  ALTER TABLE "YOP"."GRUPPO" ADD CONSTRAINT "FK_GRUPPO_SCALETTA_ID" FOREIGN KEY ("SCALETTA_ID")
	  REFERENCES "YOP"."SCALETTA" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPPO_EVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_EVENTO" ADD CONSTRAINT "FK_GRUPPO_EVENTO_EVENTI_ID" FOREIGN KEY ("EVENTI_ID")
	  REFERENCES "YOP"."EVENTO" ("ID") ENABLE;
  ALTER TABLE "YOP"."GRUPPO_EVENTO" ADD CONSTRAINT "GRUPPO_EVENTO_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPPO_GENERE
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_GENERE" ADD CONSTRAINT "FK_GRUPPO_GENERE_GENERI_ID" FOREIGN KEY ("GENERI_ID")
	  REFERENCES "YOP"."GENERE" ("ID") ENABLE;
  ALTER TABLE "YOP"."GRUPPO_GENERE" ADD CONSTRAINT "GRUPPO_GENERE_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPPO_GRUPPODIRIFERIMENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" ADD CONSTRAINT "GRPPGRPPODIRIFERIMENTOGRPPRFID" FOREIGN KEY ("GRUPPI_RIF_ID")
	  REFERENCES "YOP"."GRUPPODIRIFERIMENTO" ("ID") ENABLE;
  ALTER TABLE "YOP"."GRUPPO_GRUPPODIRIFERIMENTO" ADD CONSTRAINT "GRPPGRPPODIRIFERIMENTOGRPPSRID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOCALE
--------------------------------------------------------

  ALTER TABLE "YOP"."LOCALE" ADD CONSTRAINT "FK_LOCALE_LOCALE_ID" FOREIGN KEY ("LOCALE_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MESSAGE
--------------------------------------------------------

  ALTER TABLE "YOP"."MESSAGE" ADD CONSTRAINT "FK_MESSAGE_CONVERSATION_ID" FOREIGN KEY ("CONVERSATION_ID")
	  REFERENCES "YOP"."CONVERSATION" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SCALETTA
--------------------------------------------------------

  ALTER TABLE "YOP"."SCALETTA" ADD CONSTRAINT "FK_SCALETTA_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TIPOLOGIAEVENTO
--------------------------------------------------------

  ALTER TABLE "YOP"."TIPOLOGIAEVENTO" ADD CONSTRAINT "FK_TIPOLOGIAEVENTO_EVENTO_ID" FOREIGN KEY ("EVENTO_ID")
	  REFERENCES "YOP"."EVENTO" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TOUR
--------------------------------------------------------

  ALTER TABLE "YOP"."TOUR" ADD CONSTRAINT "FK_TOUR_GRUPPO_USER_ID" FOREIGN KEY ("GRUPPO_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table UTENTE
--------------------------------------------------------

  ALTER TABLE "YOP"."UTENTE" ADD CONSTRAINT "FK_UTENTE_RUOLO_ID" FOREIGN KEY ("RUOLO_ID")
	  REFERENCES "YOP"."RUOLO" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table VIDEO
--------------------------------------------------------

  ALTER TABLE "YOP"."VIDEO" ADD CONSTRAINT "FK_VIDEO_UTENTE_USER_ID" FOREIGN KEY ("UTENTE_USER_ID")
	  REFERENCES "YOP"."UTENTE" ("USER_ID") ENABLE;
