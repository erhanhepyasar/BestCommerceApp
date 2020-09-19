-- Test data initialization

DROP TABLE IF EXISTS USERS;

CREATE TABLE USER (ID LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      TYPE VARCHAR(30) NOT NULL,
                      NAME VARCHAR(30) NOT NULL,
                      OWNERNAME VARCHAR(30) NOT NULL,
                      ADDRESS VARCHAR(100) NOT NULL,
                      PHONE VARCHAR(15) NOT NULL,
                      EMAIL VARCHAR(50) NOT NULL,
                      PASSWORD VARCHAR(10) NOT NULL);

CREATE UNIQUE INDEX idx_cus on USER(ID,NAME);

INSERT INTO USER (TYPE, NAME, OWNERNAME, ADDRESS, PHONE, EMAIL, PASSWORD) VALUES ('TYPE1', 'USER1', 'OWNER1', 'SANFRANCISCO', 'PHONE1', 'user1@bestcommerce.com', 'Sf7777');
INSERT INTO USER (TYPE, NAME, OWNERNAME, ADDRESS, PHONE, EMAIL, PASSWORD) VALUES ('TYPE2', 'USER2', 'OWNER2', 'CHICAGO', 'PHONE2', 'user2@bestcommerce.com', 'Sf8888');
INSERT INTO USER (TYPE, NAME, OWNERNAME, ADDRESS, PHONE, EMAIL, PASSWORD) VALUES ('TYPE3', 'USER3', 'OWNER3', 'WILMINGTON', 'PHONE3', 'user3@bestcommerce.com', 'Sf9999');