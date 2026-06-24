SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS ItemTransaction;
DROP TABLE IF EXISTS Rating;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Transaction;
DROP TABLE IF EXISTS Sale;
DROP TABLE IF EXISTS UserAccount;
DROP TABLE IF EXISTS Township;
DROP TABLE IF EXISTS City;




/* Create Tables */

CREATE TABLE Category
(
	categoryId int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	PRIMARY KEY (categoryId)
);


CREATE TABLE City
(
	cityId int NOT NULL AUTO_INCREMENT,
	cityName varchar(200) NOT NULL,
	PRIMARY KEY (cityId),
	UNIQUE (cityName)
);


CREATE TABLE ItemTransaction
(
	itemTransactionId int NOT NULL AUTO_INCREMENT,
	productId int NOT NULL,
	saleId int NOT NULL,
	qty int DEFAULT 0 NOT NULL,
	unitPrice int DEFAULT 0 NOT NULL,
	amount int NOT NULL,
	discount int DEFAULT 0 NOT NULL,
	balance int DEFAULT 0 NOT NULL,
	PRIMARY KEY (itemTransactionId)
);


CREATE TABLE Product
(
	productId int NOT NULL AUTO_INCREMENT,
	userAccountId int NOT NULL,
	categoryId int NOT NULL,
	-- 0 is hide, 1 is show for best .
	type int DEFAULT 0 NOT NULL COMMENT '0 is hide, 1 is show for best .',
	photoOne varchar(50),
	photoTwo varchar(50),
	photoThree varchar(50),
	photoFour varchar(50),
	colorOne varchar(50),
	colorTwo varchar(50),
	colorThree varchar(50),
	colorFour varchar(50),
	priceOne int NOT NULL,
	priceTwo int DEFAULT 0 NOT NULL,
	sizeOne int NOT NULL,
	sizeTwo int DEFAULT 0 NOT NULL,
	title varchar(100) NOT NULL,
	detail text,
	code varchar(50) NOT NULL,
	count int DEFAULT 0 NOT NULL,
	discountPriceOne int DEFAULT 0 NOT NULL,
	discountPriceTwo int DEFAULT 0 NOT NULL,
	percent int DEFAULT 0 NOT NULL,
	normalPriceOne int NOT NULL,
	normalPriceTwo int DEFAULT 0 NOT NULL,
	PRIMARY KEY (productId)
);


CREATE TABLE Rating
(
	ratingId int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	productId int NOT NULL,
	rating int DEFAULT 0 NOT NULL,
	date datetime NOT NULL,
	PRIMARY KEY (ratingId),
	UNIQUE (customerId, productId)
);


CREATE TABLE Sale
(
	saleId int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	receivedDate date NOT NULL,
	date datetime NOT NULL,
	name varchar(100) NOT NULL,
	phone varchar(50) NOT NULL,
	address varchar(100) NOT NULL,
	PRIMARY KEY (saleId)
);


CREATE TABLE Township
(
	townshipId int NOT NULL AUTO_INCREMENT,
	cityId int NOT NULL,
	townshipName int NOT NULL,
	PRIMARY KEY (townshipId),
	UNIQUE (townshipName)
);


CREATE TABLE Transaction
(
	transactionId int NOT NULL AUTO_INCREMENT,
	saleId int NOT NULL,
	payment int NOT NULL,
	balance int NOT NULL,
	paymentType varchar(200) NOT NULL,
	date datetime NOT NULL,
	modifiedDate datetime NOT NULL,
	PRIMARY KEY (transactionId)
);


CREATE TABLE UserAccount
(
	userAccountId int NOT NULL AUTO_INCREMENT,
	townshipId int NOT NULL,
	profileName varchar(150) NOT NULL,
	phone varchar(100) NOT NULL,
	address varchar(100) NOT NULL,
	userName varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	date datetime NOT NULL,
	userType enum('CUSTOMER','ADMIN','ACCOUNTANT') NOT NULL,
	PRIMARY KEY (userAccountId),
	UNIQUE (userName)
);



/* Create Foreign Keys */

ALTER TABLE Product
	ADD FOREIGN KEY (categoryId)
	REFERENCES Category (categoryId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Township
	ADD FOREIGN KEY (cityId)
	REFERENCES City (cityId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ItemTransaction
	ADD FOREIGN KEY (productId)
	REFERENCES Product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Rating
	ADD FOREIGN KEY (productId)
	REFERENCES Product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ItemTransaction
	ADD FOREIGN KEY (saleId)
	REFERENCES Sale (saleId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Transaction
	ADD FOREIGN KEY (saleId)
	REFERENCES Sale (saleId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE UserAccount
	ADD FOREIGN KEY (townshipId)
	REFERENCES Township (townshipId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Product
	ADD FOREIGN KEY (userAccountId)
	REFERENCES UserAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Rating
	ADD FOREIGN KEY (customerId)
	REFERENCES UserAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Sale
	ADD FOREIGN KEY (customerId)
	REFERENCES UserAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



