--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: products; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE products WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE products OWNER TO postgres;

\connect products

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image (
    productid integer NOT NULL,
    uri character varying(200) NOT NULL
);


ALTER TABLE public.image OWNER TO postgres;

--
-- Name: image_productid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_productid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_productid_seq OWNER TO postgres;

--
-- Name: image_productid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.image_productid_seq OWNED BY public.image.productid;


--
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    productid integer NOT NULL,
    sizename character varying(200) NOT NULL,
    discountedprice real,
    currentprice real
);


ALTER TABLE public.price OWNER TO postgres;

--
-- Name: price_productid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.price_productid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.price_productid_seq OWNER TO postgres;

--
-- Name: price_productid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.price_productid_seq OWNED BY public.price.productid;


--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    productid integer NOT NULL,
    title character varying(100),
    description character varying(500),
    category character varying(500),
    colors character varying(100)
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: size; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.size (
    productid integer NOT NULL,
    sizename character varying(200) NOT NULL,
    onsale boolean,
    instock boolean
);


ALTER TABLE public.size OWNER TO postgres;

--
-- Name: size_productid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.size_productid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.size_productid_seq OWNER TO postgres;

--
-- Name: size_productid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.size_productid_seq OWNED BY public.size.productid;


--
-- Name: image productid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image ALTER COLUMN productid SET DEFAULT nextval('public.image_productid_seq'::regclass);


--
-- Name: price productid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price ALTER COLUMN productid SET DEFAULT nextval('public.price_productid_seq'::regclass);


--
-- Name: size productid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.size ALTER COLUMN productid SET DEFAULT nextval('public.size_productid_seq'::regclass);


--
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image (productid, uri) FROM stdin;
1	https://eu.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dwa52a5206/images/hi-res/83061_BLK.jpg?sw=750&sh=750&sm=fit&sfrm=png
2	https://de9luwq5d40h2.cloudfront.net/catalog/product/large_image/69_41435100029.jpg
3	https://cdn-ssl.s7.disneystore.com/is/image/DisneyShopping/5623058254142?$pdpXL$&fmt=webp&qlt=70
4	https://assets.adidas.com/images/w_840,h_840,f_auto,q_auto:sensitive,fl_lossy/60253d533588470aa0f8aac6011ac00a_9366/Hoodie_Pink_FM5688_01_laydown.jpg
5	https://d15udtvdbbfasl.cloudfront.net/catalog/product/large_image/68_421379.jpg
\.


--
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.price (productid, sizename, discountedprice, currentprice) FROM stdin;
1	S	80	100
1	L	75	100
2	L	30	60
3	M	100	140
3	XL	130	140
4	M	180	200
5	XXL	45	50
1	M	\N	100
1	XL	\N	100
2	S	\N	60
2	M	\N	60
3	L	\N	140
3	XXL	\N	140
4	S	\N	200
4	L	\N	200
5	X	\N	50
5	XXXL	\N	50
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (productid, title, description, category, colors) FROM stdin;
2	shirt	describing shirt	woman/shirts	red
3	skirt	describing skirt	woman/skirts	black
4	hoodie	describing hoodie	men/hoodies	white
5	jean	describing jean	men/jeans	blue
1	pants	describing pants	men/pants	black,grey
\.


--
-- Data for Name: size; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.size (productid, sizename, onsale, instock) FROM stdin;
\.


--
-- Name: image_productid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_productid_seq', 1, false);


--
-- Name: price_productid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.price_productid_seq', 1, false);


--
-- Name: size_productid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.size_productid_seq', 1, false);


--
-- Name: image image_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pk PRIMARY KEY (productid, uri);


--
-- Name: price price_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT price_pk PRIMARY KEY (productid, sizename);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (productid);


--
-- Name: size size_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.size
    ADD CONSTRAINT size_pk PRIMARY KEY (productid, sizename);


--
-- Name: image image_productid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: price price_productid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT price_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- Name: size size_productid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.size
    ADD CONSTRAINT size_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(productid);


--
-- PostgreSQL database dump complete
--

