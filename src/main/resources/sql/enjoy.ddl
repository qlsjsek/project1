DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		user_id                       		VARCHAR2(1000)		 NOT NULL,
		user_pw                       		VARCHAR2(1000)		 NULL ,
		user_name                     		VARCHAR2(1000)		 NULL ,
		user_phone                    		VARCHAR2(1000)		 NULL ,
		user_address                  		VARCHAR2(1000)		 NULL ,
		user_identity_no              		VARCHAR2(1000)		 NULL ,
		user_email                    		VARCHAR2(1000)		 NULL 
);

COMMENT ON TABLE userinfo is 'userinfo';
COMMENT ON COLUMN userinfo.user_id is 'user_id';
COMMENT ON COLUMN userinfo.user_pw is 'user_pw';
COMMENT ON COLUMN userinfo.user_name is 'user_name';
COMMENT ON COLUMN userinfo.user_phone is 'user_phone';
COMMENT ON COLUMN userinfo.user_address is 'user_address';
COMMENT ON COLUMN userinfo.user_identity_no is 'user_identity_no';
COMMENT ON COLUMN userinfo.user_email is 'user_email';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		product_no                    		NUMBER(10)		 NOT NULL,
		product_name                  		VARCHAR2(1000)		 NULL ,
		product_content               		VARCHAR2(4000)		 NULL ,
		product_qty                   		NUMBER(10)		 NULL ,
		product_image                 		VARCHAR2(1000)		 NULL 
);

DROP SEQUENCE product_product_no_SEQ;

CREATE SEQUENCE product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.product_no is 'product_no';
COMMENT ON COLUMN product.product_name is 'product_name';
COMMENT ON COLUMN product.product_content is 'product_content';
COMMENT ON COLUMN product.product_qty is 'product_qty';
COMMENT ON COLUMN product.product_image is 'product_image';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_id                       		NUMBER(10)		 NOT NULL,
		cart_qty                      		NUMBER(10)		 NULL ,
		cart_total_price              		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(1000)		 NULL ,
		product_no                    		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_cart_id_SEQ;

CREATE SEQUENCE cart_cart_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_id is 'cart_id';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN cart.cart_total_price is 'cart_total_price';
COMMENT ON COLUMN cart.user_id is 'user_id';
COMMENT ON COLUMN cart.product_no is 'product_no';


/**********************************/
/* Table Name: orders */
/**********************************/
CREATE TABLE orders(
		order_id                      		NUMBER(10)		 NOT NULL,
		order_qty                     		NUMBER(10)		 NULL ,
		order_price                   		NUMBER(10)		 NULL ,
		order_date                    		DATE		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		user_id                       		VARCHAR2(1000)		 NULL 
);

DROP SEQUENCE orders_order_id_SEQ;

CREATE SEQUENCE orders_order_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



COMMENT ON TABLE orders is 'orders';
COMMENT ON COLUMN orders.order_id is 'order_id';
COMMENT ON COLUMN orders.order_qty is 'order_qty';
COMMENT ON COLUMN orders.order_price is 'order_price';
COMMENT ON COLUMN orders.order_date is 'order_date';
COMMENT ON COLUMN orders.product_no is 'product_no';
COMMENT ON COLUMN orders.user_id is 'user_id';



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_id);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (product_no) REFERENCES product (product_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (order_id);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK1 FOREIGN KEY (user_id) REFERENCES userinfo (user_id);

