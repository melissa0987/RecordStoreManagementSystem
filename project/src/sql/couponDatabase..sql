DROP TABLE coupons CASCADE CONSTRAINTS;
CREATE TABLE coupons(
    type VARCHAR2(15),
    code VARCHAR2(15) PRIMARY KEY,
    discount NUMBER(5, 2)
);

INSERT INTO coupons VALUES('Percentage', 'RFBOA133P', 25);
INSERT INTO coupons VALUES('Percentage', 'KDBIE72P', 10);
INSERT INTO coupons VALUES('Percentage', 'PDBII112P', 5);
INSERT INTO coupons VALUES('Percentage', 'TCBEO151P', 50);
INSERT INTO coupons VALUES('Percentage', 'WCBEU171P', 25);
INSERT INTO coupons VALUES('Dollar', 'BCCEA01D', 50);
INSERT INTO coupons VALUES('Dollar', 'PGCUE114D', 5);
INSERT INTO coupons VALUES('Dollar', 'WBCAI170D', 5);
INSERT INTO coupons VALUES('Dollar', 'RCCEO131D', 10);
INSERT INTO coupons VALUES('Dollar', 'XBCAU180D', 50);
commit;
--CREATE OR REPLACE VIEW couponsDb AS 
    SELECT * FROM coupons;
