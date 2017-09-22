CREATE TABLE PAIS(
    PAI_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    PAI_NOME VARCHAR2(255) NOT NULL
);

CREATE SEQUENCE SEQ_PAIS
START WITH 1
INCREMENT BY 1;

CREATE TABLE BANDA(
    BAN_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    BAN_NOME VARCHAR2(255) NOT NULL,
    BAN_DT_CRIACAO DATE NOT NULL,
    BAN_PAIS NUMBER(18) NOT NULL,
    CONSTRAINT FK_BAN_PAIS FOREIGN KEY (BAN_PAIS) REFERENCES PAIS(PAI_CODIGO)
);

CREATE SEQUENCE SEQ_BANDA
START WITH 1
INCREMENT BY 1;

CREATE TABLE GRAVADORA(
    GRA_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    GRA_NOME VARCHAR2(255) NOT NULL,
    GRA_PAIS NUMBER(18) NOT NULL,
    CONSTRAINT FK_GRA_PAIS FOREIGN KEY (GRA_PAIS) REFERENCES PAIS(PAI_CODIGO)
);

CREATE SEQUENCE SEQ_GRAVADORA
START WITH 1
INCREMENT BY 1;

CREATE TABLE ESTILO(
    EST_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    EST_NOME VARCHAR2(255) NOT NULL
);

CREATE SEQUENCE SEQ_ESTILO
START WITH 1
INCREMENT BY 1;

CREATE TABLE MUSICA(
    MUS_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    MUS_NOME VARCHAR2(255) NOT NULL,
    MUS_DURACAO NUMBER(18) NOT NULL
);

CREATE SEQUENCE SEQ_MUSICA
START WITH 1
INCREMENT BY 1;

CREATE TABLE CANTA(
    CAN_CODIGO NUMBER(18) NOT NULL PRIMARY KEY,
    CAN_ANO_GRAVACAO NUMBER(18) NOT NULL,
    CAN_BANDA NUMBER(18) NOT NULL,
    CAN_MUSICA NUMBER(18) NOT NULL,
    CAN_GRAVADORA NUMBER(18) NOT NULL,
    CAN_ESTILO NUMBER(18) NOT NULL,
    CONSTRAINT FK_CAN_BANDA FOREIGN KEY (CAN_BANDA) REFERENCES BANDA(BAN_CODIGO),
    CONSTRAINT FK_CAN_MUSICA FOREIGN KEY (CAN_MUSICA) REFERENCES MUSICA(MUS_CODIGO),
    CONSTRAINT FK_CAN_GRAVADORA FOREIGN KEY (CAN_GRAVADORA) REFERENCES GRAVADORA(GRA_CODIGO),
    CONSTRAINT FK_CAN_ESTILO FOREIGN KEY (CAN_ESTILO) REFERENCES ESTILO(EST_CODIGO)
);

CREATE SEQUENCE SEQ_CANTA
START WITH 1
INCREMENT BY 1;

INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.nextval, 'Brasil');
INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.nextval, 'EUA');
INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.nextval, 'M�xico');
INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.nextval, 'Inglaterra');
INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.nextval, 'Canad�');
COMMIT;

INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Tit�s', TO_DATE('01/01/1982', 'DD/MM/YYYY'), 1);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Raimundos', TO_DATE('01/01/1987', 'DD/MM/YYYY'), 1);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Metallica', TO_DATE('01/01/1981', 'DD/MM/YYYY'), 2);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Legi�o Urbana', TO_DATE('01/03/1982', 'DD/MM/YYYY'), 1);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Iron Maiden', TO_DATE('01/03/1975', 'DD/MM/YYYY'), 4);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Beatles', TO_DATE('01/03/1960', 'DD/MM/YYYY'), 4);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Banda do Chaves', TO_DATE('01/03/1978', 'DD/MM/YYYY'), 3);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Simple Plan', TO_DATE('01/03/1999', 'DD/MM/YYYY'), 5);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Guns N Roses', TO_DATE('01/03/1985', 'DD/MM/YYYY'), 2);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'System of a Down', TO_DATE('01/03/1994', 'DD/MM/YYYY'), 2);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Red Hot Chili Peppers', TO_DATE('01/03/1983', 'DD/MM/YYYY'), 2);
INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, 'Banda dos anos 40', TO_DATE('01/03/1945', 'DD/MM/YYYY'), 1);
COMMIT;

INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Records', 1);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'EMI', 4);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Som Livre', 1);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Sony Music Brasil', 1);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Virgin EMI Records', 4);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Universal Music', 2);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Sony Music', 2);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Warner Music', 2);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'EMI M�xico', 3);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'EMI Music Canada', 5);
INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, 'Sony Music Canada', 5);
COMMIT;

INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, 'Rock');
INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, 'Pop Rock');
INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, 'Pop');
INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, 'Heavy Metal');
INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, 'Punk Rock');
COMMIT;

INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Se voc� � jovem ainda', 180);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Quero ver outra vez seus olhinhos de noite serena', 200);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Que bonita a sua roupa', 220);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Churin Churin Fun Flays', 260);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Quando me dizes', 210);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Boa Noite Vizinhan�a', 230);
INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, 'Os Sapinhos Fazem hum, a, hum', 150);
COMMIT;

INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1982, 1, 1, 1, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1985, 1, 2, 4, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1988, 2, 3, 3, 4);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1990, 2, 4, 3, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1996, 2, 1, 3, 4);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1997, 2, 5, 3, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1983, 3, 5, 6, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1985, 3, 6, 7, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2000, 3, 7, 7, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1988, 4, 7, 4, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1989, 4, 3, 4, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1978, 5, 2, 5, 1);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1990, 5, 4, 5, 1);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1962, 6, 1, 2, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1965, 6, 5, 2, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1980, 7, 3, 9, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1982, 7, 6, 9, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1999, 8, 5, 10, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2001, 8, 7, 11, 3);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1988, 9, 1, 8, 1);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1989, 9, 5, 8, 1);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1995, 10, 2, 6, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2002, 10, 4, 6, 5);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1997, 11, 4, 7, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2003, 11, 7, 7, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 1997, 11, 4, 1, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2003, 11, 7, 1, 2);
INSERT INTO CANTA (CAN_CODIGO, CAN_ANO_GRAVACAO, CAN_BANDA, CAN_MUSICA, CAN_GRAVADORA, CAN_ESTILO)
VALUES (SEQ_CANTA.nextval, 2005, 11, 7, 1, 3);
COMMIT;