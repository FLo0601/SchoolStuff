USE eGameDarling;

CREATE TABLE T_Premiumgamer (
    seit DATETIME NOT NULL, 
    `status` VARCHAR(10) NOT NULL,
    p_gamer_id CHAR(10) NOT NULL REFERENCES T_Gamer (p_gamer_id),
    CONSTRAINT pk_gamer_id
    PRIMARY KEY (p_gamer_id));

CREATE TABLE T_Konten (
    p_IBAN VARCHAR(22) NOT NULL, 
    BIC VARCHAR(15) NOT NULL, 
    inhaber VARCHAR(25) NOT NULL, 
    einzugsermaechtigung VARCHAR(10),
    f_gamer_id CHAR(10),
    UNIQUE (f_gamer_id),
    PRIMARY KEY (p_IBAN),
    FOREIGN KEY (f_gamer_id) REFERENCES T_Premiumgamer (p_gamer_id));
 
CREATE TABLE T_Zahlungseingaenge (
    p_zbeitrag_id INT NOT NULL, 
    `datetime` DATETIME NOT NULL,
    betrag INT NOT NULL, 
    verwendungszweck VARCHAR(20) NOT NULL,
    f_gamer_id CHAR(10) NOT NULL,
    PRIMARY KEY (p_zbeitrag_id),
    FOREIGN KEY (f_gamer_id) REFERENCES T_Premiumgamer (p_gamer_id));

CREATE TABLE T_Freunde (
    seit DATETIME NOT NULL, 
    freundschaftsgrad INT, 
    `status` VARCHAR(10) NOT NULL,
    f_gamer_id CHAR(10) NOT NULL,
    f_friend_id CHAR(10) NOT NULL,
    FOREIGN KEY (f_gamer_id) REFERENCES T_Gamer (p_gamer_id),
    FOREIGN KEY (f_friend_id) REFERENCES T_Gamer (p_gamer_id));