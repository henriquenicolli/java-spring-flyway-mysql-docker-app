
CREATE TABLE tb_boleto (
    boleto_id int,
    valor varchar(255),
    PRIMARY KEY (boleto_id)
);

CREATE TABLE tb_lote (
    lote_id int,
    valor varchar(255),
    PRIMARY KEY (lote_id)
);

CREATE TABLE tb_lote_boleto (
    lote_id int,
    boleto_id int,
    FOREIGN KEY (lote_id) REFERENCES tb_lote(lote_id),
    FOREIGN KEY (boleto_id) REFERENCES tb_boleto(boleto_id)
);