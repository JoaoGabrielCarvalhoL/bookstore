-- public.tb_author definition

-- Drop table

-- DROP TABLE public.tb_author;

CREATE TABLE public.tb_author (
	id uuid NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT tb_author_pkey PRIMARY KEY (id)
);


-- public.tb_category definition

-- Drop table

-- DROP TABLE public.tb_category;

CREATE TABLE public.tb_category (
	id uuid NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT tb_category_name_key UNIQUE (name),
	CONSTRAINT tb_category_pkey PRIMARY KEY (id)
);


-- public.tb_user_informations definition

-- Drop table

-- DROP TABLE public.tb_user_informations;

CREATE TABLE public.tb_user_informations (
	id uuid NOT NULL,
	internetprotocol varchar(255) NOT NULL,
	locale varchar(255) NOT NULL,
	useragent varchar(255) NOT NULL,
	CONSTRAINT tb_user_informations_pkey PRIMARY KEY (id)
);


-- public.tb_book definition

-- Drop table

-- DROP TABLE public.tb_book;

CREATE TABLE public.tb_book (
	price numeric(10, 2) NOT NULL,
	publishedin date NULL,
	savedin timestamp(6) NULL,
	updatedin timestamp(6) NULL,
	author_id uuid NULL,
	category_id uuid NULL,
	id uuid NOT NULL,
	isbn varchar(255) NOT NULL,
	title varchar(255) NOT NULL,
	description oid NOT NULL,
	image bytea NOT NULL,
	CONSTRAINT tb_book_pkey PRIMARY KEY (id),
	CONSTRAINT tb_book_title_key UNIQUE (title),
	CONSTRAINT fkc27yltypnyytr71q1a0vdg8w9 FOREIGN KEY (author_id) REFERENCES public.tb_author(id),
	CONSTRAINT fkciuinldyblgvrg7ef6sksof8b FOREIGN KEY (category_id) REFERENCES public.tb_category(id)
);


-- public.tb_user definition

-- Drop table

-- DROP TABLE public.tb_user;

CREATE TABLE public.tb_user (
	isactive bool NULL,
	createdat timestamp(6) NULL,
	id uuid NOT NULL,
	userinformations_id uuid NULL,
	email varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	"name" varchar(100) NOT NULL,
	cellphone varchar(255) NOT NULL,
	hashpassword varchar(255) NOT NULL,
	"role" varchar(255) NULL,
	CONSTRAINT tb_user_email_key UNIQUE (email),
	CONSTRAINT tb_user_pkey PRIMARY KEY (id),
	CONSTRAINT tb_user_role_check CHECK (((role)::text = ANY ((ARRAY['ROLE_USER'::character varying, 'ROLE_CUSTOMER'::character varying, 'ROLE_ADMIN'::character varying])::text[]))),
	CONSTRAINT tb_user_userinformations_id_key UNIQUE (userinformations_id),
	CONSTRAINT tb_user_username_key UNIQUE (username),
	CONSTRAINT fkbch88l5kmeqj9iuthly812nbj FOREIGN KEY (userinformations_id) REFERENCES public.tb_user_informations(id)
);


-- public.user_adresses definition

-- Drop table

-- DROP TABLE public.user_adresses;

CREATE TABLE public.user_adresses (
	user_id uuid NOT NULL,
	"type" varchar(255) NULL,
	CONSTRAINT user_adresses_type_check CHECK (((type)::text = ANY ((ARRAY['COMMERCIAL'::character varying, 'RESIDENTIAL'::character varying, 'OTHER'::character varying])::text[]))),
	CONSTRAINT fk3r5c8vkuagmyjwbulfewaq0vx FOREIGN KEY (user_id) REFERENCES public.tb_user(id)
);


-- public.tb_customer definition

-- Drop table

-- DROP TABLE public.tb_customer;

CREATE TABLE public.tb_customer (
	register timestamp(6) NULL,
	id uuid NOT NULL,
	user_id uuid NULL,
	CONSTRAINT tb_customer_pkey PRIMARY KEY (id),
	CONSTRAINT tb_customer_user_id_key UNIQUE (user_id),
	CONSTRAINT fkdy87mhcdditpr8fmi41ae3nmu FOREIGN KEY (user_id) REFERENCES public.tb_user(id)
);


-- public.tb_order definition

-- Drop table

-- DROP TABLE public.tb_order;

CREATE TABLE public.tb_order (
	"date" date NULL,
	total numeric(10, 2) NOT NULL,
	customer_id uuid NULL,
	id uuid NOT NULL,
	status varchar(255) NULL,
	"type" varchar(255) NULL,
	CONSTRAINT tb_order_pkey PRIMARY KEY (id),
	CONSTRAINT tb_order_status_check CHECK (((status)::text = ANY ((ARRAY['CONCLUDED'::character varying, 'PENDING'::character varying, 'CANCELED'::character varying])::text[]))),
	CONSTRAINT tb_order_type_check CHECK (((type)::text = ANY ((ARRAY['CREDIT_CARD'::character varying, 'TICKET'::character varying, 'PIX'::character varying])::text[]))),
	CONSTRAINT fkqcp43jdylvf2riad5s1x1i2dn FOREIGN KEY (customer_id) REFERENCES public.tb_customer(id)
);


-- public.tb_order_detail definition

-- Drop table

-- DROP TABLE public.tb_order_detail;

CREATE TABLE public.tb_order_detail (
	quantity int4 NOT NULL,
	subtotal numeric(10, 2) NOT NULL,
	book_id uuid NULL,
	id uuid NOT NULL,
	order_id uuid NULL,
	CONSTRAINT tb_order_detail_order_id_key UNIQUE (order_id),
	CONSTRAINT tb_order_detail_pkey PRIMARY KEY (id),
	CONSTRAINT fkkawh49moll3ceer1k1m7jtqdj FOREIGN KEY (book_id) REFERENCES public.tb_book(id),
	CONSTRAINT fksc2q1rjpjtmhtq5e8b8nrte8b FOREIGN KEY (order_id) REFERENCES public.tb_order(id)
);


-- public.tb_review definition

-- Drop table

-- DROP TABLE public.tb_review;

CREATE TABLE public.tb_review (
	rating int4 NOT NULL,
	occurredin timestamp(6) NULL,
	book_id uuid NULL,
	customer_id uuid NULL,
	id uuid NOT NULL,
	title varchar(100) NOT NULL,
	"comment" varchar(255) NOT NULL,
	CONSTRAINT tb_review_pkey PRIMARY KEY (id),
	CONSTRAINT fkeg87futlmwoqclx4ewgvyxnjk FOREIGN KEY (customer_id) REFERENCES public.tb_customer(id),
	CONSTRAINT fkp5tb2jvweeb394ipb13b1my8v FOREIGN KEY (book_id) REFERENCES public.tb_book(id)
);