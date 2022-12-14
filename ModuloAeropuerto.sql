PGDMP                         z            ModuloAeropuerto    11.5    11.5 ?    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?           1262    24809    ModuloAeropuerto    DATABASE     ?   CREATE DATABASE "ModuloAeropuerto" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
 "   DROP DATABASE "ModuloAeropuerto";
             postgres    false            ?            1259    24810    accion    TABLE     z   CREATE TABLE public.accion (
    idaccion character varying(2) NOT NULL,
    descaccion character varying(10) NOT NULL
);
    DROP TABLE public.accion;
       public         postgres    false            ?            1259    24816    avion    TABLE     ?   CREATE TABLE public.avion (
    codlinea character varying(3) NOT NULL,
    placaavion character varying(6) NOT NULL,
    idmodelo character varying(3) NOT NULL
);
    DROP TABLE public.avion;
       public         postgres    false            ?            1259    24824    dia    TABLE     p   CREATE TABLE public.dia (
    iddia character varying(1) NOT NULL,
    nomdia character varying(12) NOT NULL
);
    DROP TABLE public.dia;
       public         postgres    false            ?            1259    24830    diaprogramavuelo    TABLE     ?   CREATE TABLE public.diaprogramavuelo (
    iddia character varying(1) NOT NULL,
    codlinea character varying(3) NOT NULL,
    idprograma numeric(5,0) NOT NULL
);
 $   DROP TABLE public.diaprogramavuelo;
       public         postgres    false            ?            1259    24838    escala    TABLE     ?   CREATE TABLE public.escala (
    codlinea character varying(3) NOT NULL,
    idprograma numeric(5,0) NOT NULL,
    consec numeric(2,0) NOT NULL,
    idlugar character varying(5) NOT NULL,
    idtipoescala character varying(3) NOT NULL
);
    DROP TABLE public.escala;
       public         postgres    false            ?            1259    24847    evento_pista    TABLE     ?  CREATE TABLE public.evento_pista (
    consecevento numeric(4,0) NOT NULL,
    idlugar character varying(5) NOT NULL,
    pis_idlugar character varying(5) NOT NULL,
    numpista numeric(2,0) NOT NULL,
    idtipoevento character varying(1) NOT NULL,
    codlinea character varying(3),
    idprograma numeric(5,0),
    idvuelo character varying(6) NOT NULL,
    fechaevento date NOT NULL,
    horaevento time without time zone NOT NULL
);
     DROP TABLE public.evento_pista;
       public         postgres    false            ?            1259    24858    hora    TABLE     `   CREATE TABLE public.hora (
    idhora character(10) NOT NULL,
    hora character varying(10)
);
    DROP TABLE public.hora;
       public         postgres    false            ?            1259    24864    horaprogramavuelo    TABLE     ?   CREATE TABLE public.horaprogramavuelo (
    codlinea character varying(3) NOT NULL,
    idprograma numeric(5,0) NOT NULL,
    idhora character(10) NOT NULL
);
 %   DROP TABLE public.horaprogramavuelo;
       public         postgres    false            ?            1259    24872 
   lineaaerea    TABLE     |   CREATE TABLE public.lineaaerea (
    codlinea character varying(3) NOT NULL,
    nomlinea character varying(30) NOT NULL
);
    DROP TABLE public.lineaaerea;
       public         postgres    false            ?            1259    24878    lugar    TABLE     ?   CREATE TABLE public.lugar (
    idlugar character varying(5) NOT NULL,
    idtipolugar character varying(3) NOT NULL,
    nomlugar character varying(100) NOT NULL
);
    DROP TABLE public.lugar;
       public         postgres    false            ?            1259    24886    modelo_avion    TABLE     ?   CREATE TABLE public.modelo_avion (
    idmodelo character varying(3) NOT NULL,
    capacidad numeric(5,0) NOT NULL,
    nombremodelo character varying(20)
);
     DROP TABLE public.modelo_avion;
       public         postgres    false            ?            1259    24892 	   ocupacion    TABLE     ?  CREATE TABLE public.ocupacion (
    consecocupa numeric(5,0) NOT NULL,
    ndocumento character varying(15) NOT NULL,
    idaccion character varying(2) NOT NULL,
    esc_codlinea character varying(3) NOT NULL,
    idprograma numeric(5,0) NOT NULL,
    consec numeric(2,0) NOT NULL,
    codlinea character varying(3) NOT NULL,
    placaavion character varying(6) NOT NULL,
    idsilla character varying(4) NOT NULL
);
    DROP TABLE public.ocupacion;
       public         postgres    false            ?            1259    24902    pasajero    TABLE     ?   CREATE TABLE public.pasajero (
    ndocumento character varying(15) NOT NULL,
    idlugar character varying(5) NOT NULL,
    nombre character varying(20) NOT NULL,
    apellido character varying(20) NOT NULL,
    fechanacimiento date NOT NULL
);
    DROP TABLE public.pasajero;
       public         postgres    false            ?            1259    24909    pista    TABLE     m   CREATE TABLE public.pista (
    idlugar character varying(5) NOT NULL,
    numpista numeric(2,0) NOT NULL
);
    DROP TABLE public.pista;
       public         postgres    false            ?            1259    24916    programa_vuelo    TABLE     ?   CREATE TABLE public.programa_vuelo (
    codlinea character varying(3) NOT NULL,
    idprograma numeric(5,0) NOT NULL,
    idlugar character varying(5) NOT NULL,
    fechacrea date NOT NULL
);
 "   DROP TABLE public.programa_vuelo;
       public         postgres    false            ?            1259    24924    silla    TABLE     ?   CREATE TABLE public.silla (
    codlinea character varying(3) NOT NULL,
    placaavion character varying(6) NOT NULL,
    idsilla character varying(4) NOT NULL
);
    DROP TABLE public.silla;
       public         postgres    false            ?            1259    24937    tipo_evento    TABLE     ?   CREATE TABLE public.tipo_evento (
    idtipoevento character varying(1) NOT NULL,
    desctipoevento character varying(10) NOT NULL
);
    DROP TABLE public.tipo_evento;
       public         postgres    false            ?            1259    24943 
   tipo_lugar    TABLE     ?   CREATE TABLE public.tipo_lugar (
    idtipolugar character varying(3) NOT NULL,
    desctipolugar character varying(30) NOT NULL
);
    DROP TABLE public.tipo_lugar;
       public         postgres    false            ?            1259    24931 
   tipoescala    TABLE     ?   CREATE TABLE public.tipoescala (
    idtipoescala character varying(3) NOT NULL,
    desctipoescala character varying(20) NOT NULL
);
    DROP TABLE public.tipoescala;
       public         postgres    false            ?            1259    24949    vuelo    TABLE       CREATE TABLE public.vuelo (
    idvuelo character varying(6) NOT NULL,
    idprograma numeric(5,0),
    codlinea character varying(3) NOT NULL,
    placaavion character varying(6) NOT NULL,
    fecha date NOT NULL,
    plazasvacias numeric(3,0) NOT NULL
);
    DROP TABLE public.vuelo;
       public         postgres    false            ?          0    24810    accion 
   TABLE DATA               6   COPY public.accion (idaccion, descaccion) FROM stdin;
    public       postgres    false    196   d?       ?          0    24816    avion 
   TABLE DATA               ?   COPY public.avion (codlinea, placaavion, idmodelo) FROM stdin;
    public       postgres    false    197   ??       ?          0    24824    dia 
   TABLE DATA               ,   COPY public.dia (iddia, nomdia) FROM stdin;
    public       postgres    false    198   ??       ?          0    24830    diaprogramavuelo 
   TABLE DATA               G   COPY public.diaprogramavuelo (iddia, codlinea, idprograma) FROM stdin;
    public       postgres    false    199   ??       ?          0    24838    escala 
   TABLE DATA               U   COPY public.escala (codlinea, idprograma, consec, idlugar, idtipoescala) FROM stdin;
    public       postgres    false    200   ?       ?          0    24847    evento_pista 
   TABLE DATA               ?   COPY public.evento_pista (consecevento, idlugar, pis_idlugar, numpista, idtipoevento, codlinea, idprograma, idvuelo, fechaevento, horaevento) FROM stdin;
    public       postgres    false    201   1?       ?          0    24858    hora 
   TABLE DATA               ,   COPY public.hora (idhora, hora) FROM stdin;
    public       postgres    false    202   N?       ?          0    24864    horaprogramavuelo 
   TABLE DATA               I   COPY public.horaprogramavuelo (codlinea, idprograma, idhora) FROM stdin;
    public       postgres    false    203   ??       ?          0    24872 
   lineaaerea 
   TABLE DATA               8   COPY public.lineaaerea (codlinea, nomlinea) FROM stdin;
    public       postgres    false    204   ?       ?          0    24878    lugar 
   TABLE DATA               ?   COPY public.lugar (idlugar, idtipolugar, nomlugar) FROM stdin;
    public       postgres    false    205   P?       ?          0    24886    modelo_avion 
   TABLE DATA               I   COPY public.modelo_avion (idmodelo, capacidad, nombremodelo) FROM stdin;
    public       postgres    false    206   ??       ?          0    24892 	   ocupacion 
   TABLE DATA               ?   COPY public.ocupacion (consecocupa, ndocumento, idaccion, esc_codlinea, idprograma, consec, codlinea, placaavion, idsilla) FROM stdin;
    public       postgres    false    207   ??       ?          0    24902    pasajero 
   TABLE DATA               Z   COPY public.pasajero (ndocumento, idlugar, nombre, apellido, fechanacimiento) FROM stdin;
    public       postgres    false    208   ?       ?          0    24909    pista 
   TABLE DATA               2   COPY public.pista (idlugar, numpista) FROM stdin;
    public       postgres    false    209   0?       ?          0    24916    programa_vuelo 
   TABLE DATA               R   COPY public.programa_vuelo (codlinea, idprograma, idlugar, fechacrea) FROM stdin;
    public       postgres    false    210   M?       ?          0    24924    silla 
   TABLE DATA               >   COPY public.silla (codlinea, placaavion, idsilla) FROM stdin;
    public       postgres    false    211   j?       ?          0    24937    tipo_evento 
   TABLE DATA               C   COPY public.tipo_evento (idtipoevento, desctipoevento) FROM stdin;
    public       postgres    false    213   ??       ?          0    24943 
   tipo_lugar 
   TABLE DATA               @   COPY public.tipo_lugar (idtipolugar, desctipolugar) FROM stdin;
    public       postgres    false    214   ??       ?          0    24931 
   tipoescala 
   TABLE DATA               B   COPY public.tipoescala (idtipoescala, desctipoescala) FROM stdin;
    public       postgres    false    212   ?       ?          0    24949    vuelo 
   TABLE DATA               _   COPY public.vuelo (idvuelo, idprograma, codlinea, placaavion, fecha, plazasvacias) FROM stdin;
    public       postgres    false    215   *?       ?
           2606    24814    accion pk_accion 
   CONSTRAINT     T   ALTER TABLE ONLY public.accion
    ADD CONSTRAINT pk_accion PRIMARY KEY (idaccion);
 :   ALTER TABLE ONLY public.accion DROP CONSTRAINT pk_accion;
       public         postgres    false    196            ?
           2606    24820    avion pk_avion 
   CONSTRAINT     ^   ALTER TABLE ONLY public.avion
    ADD CONSTRAINT pk_avion PRIMARY KEY (codlinea, placaavion);
 8   ALTER TABLE ONLY public.avion DROP CONSTRAINT pk_avion;
       public         postgres    false    197    197            ?
           2606    24828 
   dia pk_dia 
   CONSTRAINT     K   ALTER TABLE ONLY public.dia
    ADD CONSTRAINT pk_dia PRIMARY KEY (iddia);
 4   ALTER TABLE ONLY public.dia DROP CONSTRAINT pk_dia;
       public         postgres    false    198            ?
           2606    24834 $   diaprogramavuelo pk_diaprogramavuelo 
   CONSTRAINT     {   ALTER TABLE ONLY public.diaprogramavuelo
    ADD CONSTRAINT pk_diaprogramavuelo PRIMARY KEY (iddia, codlinea, idprograma);
 N   ALTER TABLE ONLY public.diaprogramavuelo DROP CONSTRAINT pk_diaprogramavuelo;
       public         postgres    false    199    199    199            ?
           2606    24842    escala pk_escala 
   CONSTRAINT     h   ALTER TABLE ONLY public.escala
    ADD CONSTRAINT pk_escala PRIMARY KEY (codlinea, idprograma, consec);
 :   ALTER TABLE ONLY public.escala DROP CONSTRAINT pk_escala;
       public         postgres    false    200    200    200            ?
           2606    24851    evento_pista pk_evento_pista 
   CONSTRAINT     d   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT pk_evento_pista PRIMARY KEY (consecevento);
 F   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT pk_evento_pista;
       public         postgres    false    201            ?
           2606    24862    hora pk_hora 
   CONSTRAINT     N   ALTER TABLE ONLY public.hora
    ADD CONSTRAINT pk_hora PRIMARY KEY (idhora);
 6   ALTER TABLE ONLY public.hora DROP CONSTRAINT pk_hora;
       public         postgres    false    202            ?
           2606    24868 &   horaprogramavuelo pk_horaprogramavuelo 
   CONSTRAINT     ~   ALTER TABLE ONLY public.horaprogramavuelo
    ADD CONSTRAINT pk_horaprogramavuelo PRIMARY KEY (codlinea, idprograma, idhora);
 P   ALTER TABLE ONLY public.horaprogramavuelo DROP CONSTRAINT pk_horaprogramavuelo;
       public         postgres    false    203    203    203            ?
           2606    24876    lineaaerea pk_lineaaerea 
   CONSTRAINT     \   ALTER TABLE ONLY public.lineaaerea
    ADD CONSTRAINT pk_lineaaerea PRIMARY KEY (codlinea);
 B   ALTER TABLE ONLY public.lineaaerea DROP CONSTRAINT pk_lineaaerea;
       public         postgres    false    204            ?
           2606    24882    lugar pk_lugar 
   CONSTRAINT     Q   ALTER TABLE ONLY public.lugar
    ADD CONSTRAINT pk_lugar PRIMARY KEY (idlugar);
 8   ALTER TABLE ONLY public.lugar DROP CONSTRAINT pk_lugar;
       public         postgres    false    205            ?
           2606    24890    modelo_avion pk_modelo_avion 
   CONSTRAINT     `   ALTER TABLE ONLY public.modelo_avion
    ADD CONSTRAINT pk_modelo_avion PRIMARY KEY (idmodelo);
 F   ALTER TABLE ONLY public.modelo_avion DROP CONSTRAINT pk_modelo_avion;
       public         postgres    false    206            ?
           2606    24896    ocupacion pk_ocupacion 
   CONSTRAINT     ]   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT pk_ocupacion PRIMARY KEY (consecocupa);
 @   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT pk_ocupacion;
       public         postgres    false    207                        2606    24906    pasajero pk_pasajero 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pasajero
    ADD CONSTRAINT pk_pasajero PRIMARY KEY (ndocumento);
 >   ALTER TABLE ONLY public.pasajero DROP CONSTRAINT pk_pasajero;
       public         postgres    false    208                       2606    24913    pista pk_pista 
   CONSTRAINT     [   ALTER TABLE ONLY public.pista
    ADD CONSTRAINT pk_pista PRIMARY KEY (idlugar, numpista);
 8   ALTER TABLE ONLY public.pista DROP CONSTRAINT pk_pista;
       public         postgres    false    209    209                       2606    24920     programa_vuelo pk_programa_vuelo 
   CONSTRAINT     p   ALTER TABLE ONLY public.programa_vuelo
    ADD CONSTRAINT pk_programa_vuelo PRIMARY KEY (codlinea, idprograma);
 J   ALTER TABLE ONLY public.programa_vuelo DROP CONSTRAINT pk_programa_vuelo;
       public         postgres    false    210    210                       2606    24928    silla pk_silla 
   CONSTRAINT     g   ALTER TABLE ONLY public.silla
    ADD CONSTRAINT pk_silla PRIMARY KEY (codlinea, placaavion, idsilla);
 8   ALTER TABLE ONLY public.silla DROP CONSTRAINT pk_silla;
       public         postgres    false    211    211    211                       2606    24941    tipo_evento pk_tipo_evento 
   CONSTRAINT     b   ALTER TABLE ONLY public.tipo_evento
    ADD CONSTRAINT pk_tipo_evento PRIMARY KEY (idtipoevento);
 D   ALTER TABLE ONLY public.tipo_evento DROP CONSTRAINT pk_tipo_evento;
       public         postgres    false    213                       2606    24947    tipo_lugar pk_tipo_lugar 
   CONSTRAINT     _   ALTER TABLE ONLY public.tipo_lugar
    ADD CONSTRAINT pk_tipo_lugar PRIMARY KEY (idtipolugar);
 B   ALTER TABLE ONLY public.tipo_lugar DROP CONSTRAINT pk_tipo_lugar;
       public         postgres    false    214                       2606    24935    tipoescala pk_tipoescala 
   CONSTRAINT     `   ALTER TABLE ONLY public.tipoescala
    ADD CONSTRAINT pk_tipoescala PRIMARY KEY (idtipoescala);
 B   ALTER TABLE ONLY public.tipoescala DROP CONSTRAINT pk_tipoescala;
       public         postgres    false    212                       2606    24953    vuelo pk_vuelo 
   CONSTRAINT     Q   ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT pk_vuelo PRIMARY KEY (idvuelo);
 8   ALTER TABLE ONLY public.vuelo DROP CONSTRAINT pk_vuelo;
       public         postgres    false    215            ?
           1259    24815 	   accion_pk    INDEX     G   CREATE UNIQUE INDEX accion_pk ON public.accion USING btree (idaccion);
    DROP INDEX public.accion_pk;
       public         postgres    false    196            ?
           1259    24821    avion_pk    INDEX     Q   CREATE UNIQUE INDEX avion_pk ON public.avion USING btree (codlinea, placaavion);
    DROP INDEX public.avion_pk;
       public         postgres    false    197    197            ?
           1259    24829    dia_pk    INDEX     >   CREATE UNIQUE INDEX dia_pk ON public.dia USING btree (iddia);
    DROP INDEX public.dia_pk;
       public         postgres    false    198            ?
           1259    24843 	   escala_pk    INDEX     [   CREATE UNIQUE INDEX escala_pk ON public.escala USING btree (codlinea, idprograma, consec);
    DROP INDEX public.escala_pk;
       public         postgres    false    200    200    200            ?
           1259    24852    evento_pista_pk    INDEX     W   CREATE UNIQUE INDEX evento_pista_pk ON public.evento_pista USING btree (consecevento);
 #   DROP INDEX public.evento_pista_pk;
       public         postgres    false    201            ?
           1259    24863    hora_pk    INDEX     A   CREATE UNIQUE INDEX hora_pk ON public.hora USING btree (idhora);
    DROP INDEX public.hora_pk;
       public         postgres    false    202            ?
           1259    24877    lineaaerea_pk    INDEX     O   CREATE UNIQUE INDEX lineaaerea_pk ON public.lineaaerea USING btree (codlinea);
 !   DROP INDEX public.lineaaerea_pk;
       public         postgres    false    204            ?
           1259    24883    lugar_pk    INDEX     D   CREATE UNIQUE INDEX lugar_pk ON public.lugar USING btree (idlugar);
    DROP INDEX public.lugar_pk;
       public         postgres    false    205            ?
           1259    24891    modelo_avion_pk    INDEX     S   CREATE UNIQUE INDEX modelo_avion_pk ON public.modelo_avion USING btree (idmodelo);
 #   DROP INDEX public.modelo_avion_pk;
       public         postgres    false    206            ?
           1259    24897    ocupacion_pk    INDEX     P   CREATE UNIQUE INDEX ocupacion_pk ON public.ocupacion USING btree (consecocupa);
     DROP INDEX public.ocupacion_pk;
       public         postgres    false    207            ?
           1259    24907    pasajero_pk    INDEX     M   CREATE UNIQUE INDEX pasajero_pk ON public.pasajero USING btree (ndocumento);
    DROP INDEX public.pasajero_pk;
       public         postgres    false    208                       1259    24914    pista_pk    INDEX     N   CREATE UNIQUE INDEX pista_pk ON public.pista USING btree (idlugar, numpista);
    DROP INDEX public.pista_pk;
       public         postgres    false    209    209                       1259    24921    programa_vuelo_pk    INDEX     c   CREATE UNIQUE INDEX programa_vuelo_pk ON public.programa_vuelo USING btree (codlinea, idprograma);
 %   DROP INDEX public.programa_vuelo_pk;
       public         postgres    false    210    210            ?
           1259    24855    relationship_10_fk    INDEX     S   CREATE INDEX relationship_10_fk ON public.evento_pista USING btree (idtipoevento);
 &   DROP INDEX public.relationship_10_fk;
       public         postgres    false    201                       1259    24915    relationship_11_fk    INDEX     G   CREATE INDEX relationship_11_fk ON public.pista USING btree (idlugar);
 &   DROP INDEX public.relationship_11_fk;
       public         postgres    false    209            ?
           1259    24856    relationship_12_fk    INDEX     [   CREATE INDEX relationship_12_fk ON public.evento_pista USING btree (codlinea, idprograma);
 &   DROP INDEX public.relationship_12_fk;
       public         postgres    false    201    201            ?
           1259    24857    relationship_13_fk    INDEX     N   CREATE INDEX relationship_13_fk ON public.evento_pista USING btree (idvuelo);
 &   DROP INDEX public.relationship_13_fk;
       public         postgres    false    201                       1259    24956    relationship_15_fk    INDEX     T   CREATE INDEX relationship_15_fk ON public.vuelo USING btree (codlinea, placaavion);
 &   DROP INDEX public.relationship_15_fk;
       public         postgres    false    215    215            ?
           1259    24822    relationship_16_fk    INDEX     H   CREATE INDEX relationship_16_fk ON public.avion USING btree (codlinea);
 &   DROP INDEX public.relationship_16_fk;
       public         postgres    false    197            ?
           1259    24844    relationship_17_fk    INDEX     H   CREATE INDEX relationship_17_fk ON public.escala USING btree (idlugar);
 &   DROP INDEX public.relationship_17_fk;
       public         postgres    false    200            ?
           1259    24845    relationship_18_fk    INDEX     M   CREATE INDEX relationship_18_fk ON public.escala USING btree (idtipoescala);
 &   DROP INDEX public.relationship_18_fk;
       public         postgres    false    200            ?
           1259    24846    relationship_19_fk    INDEX     U   CREATE INDEX relationship_19_fk ON public.escala USING btree (codlinea, idprograma);
 &   DROP INDEX public.relationship_19_fk;
       public         postgres    false    200    200            ?
           1259    24823    relationship_20_fk    INDEX     H   CREATE INDEX relationship_20_fk ON public.avion USING btree (idmodelo);
 &   DROP INDEX public.relationship_20_fk;
       public         postgres    false    197                       1259    24930    relationship_21_fk    INDEX     T   CREATE INDEX relationship_21_fk ON public.silla USING btree (codlinea, placaavion);
 &   DROP INDEX public.relationship_21_fk;
       public         postgres    false    211    211                       1259    24908    relationship_22_fk    INDEX     J   CREATE INDEX relationship_22_fk ON public.pasajero USING btree (idlugar);
 &   DROP INDEX public.relationship_22_fk;
       public         postgres    false    208            ?
           1259    24898    relationship_23_fk    INDEX     N   CREATE INDEX relationship_23_fk ON public.ocupacion USING btree (ndocumento);
 &   DROP INDEX public.relationship_23_fk;
       public         postgres    false    207            ?
           1259    24899    relationship_24_fk    INDEX     L   CREATE INDEX relationship_24_fk ON public.ocupacion USING btree (idaccion);
 &   DROP INDEX public.relationship_24_fk;
       public         postgres    false    207            ?
           1259    24900    relationship_25_fk    INDEX     d   CREATE INDEX relationship_25_fk ON public.ocupacion USING btree (esc_codlinea, idprograma, consec);
 &   DROP INDEX public.relationship_25_fk;
       public         postgres    false    207    207    207            ?
           1259    24901    relationship_26_fk    INDEX     a   CREATE INDEX relationship_26_fk ON public.ocupacion USING btree (codlinea, placaavion, idsilla);
 &   DROP INDEX public.relationship_26_fk;
       public         postgres    false    207    207    207            	           1259    24923    relationship_28_fk    INDEX     Q   CREATE INDEX relationship_28_fk ON public.programa_vuelo USING btree (codlinea);
 &   DROP INDEX public.relationship_28_fk;
       public         postgres    false    210            ?
           1259    24836    relationship_29_fk    INDEX     _   CREATE INDEX relationship_29_fk ON public.diaprogramavuelo USING btree (codlinea, idprograma);
 &   DROP INDEX public.relationship_29_fk;
       public         postgres    false    199    199            ?
           1259    24885    relationship_2_fk    INDEX     J   CREATE INDEX relationship_2_fk ON public.lugar USING btree (idtipolugar);
 %   DROP INDEX public.relationship_2_fk;
       public         postgres    false    205            ?
           1259    24870    relationship_30_fk    INDEX     R   CREATE INDEX relationship_30_fk ON public.horaprogramavuelo USING btree (idhora);
 &   DROP INDEX public.relationship_30_fk;
       public         postgres    false    203            
           1259    24922    relationship_5_fk    INDEX     O   CREATE INDEX relationship_5_fk ON public.programa_vuelo USING btree (idlugar);
 %   DROP INDEX public.relationship_5_fk;
       public         postgres    false    210            ?
           1259    24837    relationship_6_fk    INDEX     O   CREATE INDEX relationship_6_fk ON public.diaprogramavuelo USING btree (iddia);
 %   DROP INDEX public.relationship_6_fk;
       public         postgres    false    199            ?
           1259    24835    relationship_6_pk    INDEX     l   CREATE UNIQUE INDEX relationship_6_pk ON public.diaprogramavuelo USING btree (iddia, codlinea, idprograma);
 %   DROP INDEX public.relationship_6_pk;
       public         postgres    false    199    199    199            ?
           1259    24871    relationship_7_fk    INDEX     _   CREATE INDEX relationship_7_fk ON public.horaprogramavuelo USING btree (codlinea, idprograma);
 %   DROP INDEX public.relationship_7_fk;
       public         postgres    false    203    203            ?
           1259    24869    relationship_7_pk    INDEX     n   CREATE UNIQUE INDEX relationship_7_pk ON public.horaprogramavuelo USING btree (codlinea, idprograma, idhora);
 %   DROP INDEX public.relationship_7_pk;
       public         postgres    false    203    203    203            ?
           1259    24853    relationship_8_fk    INDEX     M   CREATE INDEX relationship_8_fk ON public.evento_pista USING btree (idlugar);
 %   DROP INDEX public.relationship_8_fk;
       public         postgres    false    201            ?
           1259    24854    relationship_9_fk    INDEX     [   CREATE INDEX relationship_9_fk ON public.evento_pista USING btree (pis_idlugar, numpista);
 %   DROP INDEX public.relationship_9_fk;
       public         postgres    false    201    201                       1259    24929    silla_pk    INDEX     Z   CREATE UNIQUE INDEX silla_pk ON public.silla USING btree (codlinea, placaavion, idsilla);
    DROP INDEX public.silla_pk;
       public         postgres    false    211    211    211                       1259    24942    tipo_evento_pk    INDEX     U   CREATE UNIQUE INDEX tipo_evento_pk ON public.tipo_evento USING btree (idtipoevento);
 "   DROP INDEX public.tipo_evento_pk;
       public         postgres    false    213                       1259    24948    tipo_lugar_pk    INDEX     R   CREATE UNIQUE INDEX tipo_lugar_pk ON public.tipo_lugar USING btree (idtipolugar);
 !   DROP INDEX public.tipo_lugar_pk;
       public         postgres    false    214                       1259    24936    tipoescala_pk    INDEX     S   CREATE UNIQUE INDEX tipoescala_pk ON public.tipoescala USING btree (idtipoescala);
 !   DROP INDEX public.tipoescala_pk;
       public         postgres    false    212                       1259    24954    vuelo_pk    INDEX     D   CREATE UNIQUE INDEX vuelo_pk ON public.vuelo USING btree (idvuelo);
    DROP INDEX public.vuelo_pk;
       public         postgres    false    215                       2606    24957 !   avion fk_avion_relations_lineaaer    FK CONSTRAINT     ?   ALTER TABLE ONLY public.avion
    ADD CONSTRAINT fk_avion_relations_lineaaer FOREIGN KEY (codlinea) REFERENCES public.lineaaerea(codlinea) ON UPDATE RESTRICT ON DELETE RESTRICT;
 K   ALTER TABLE ONLY public.avion DROP CONSTRAINT fk_avion_relations_lineaaer;
       public       postgres    false    2799    204    197                       2606    24962 !   avion fk_avion_relations_modelo_a    FK CONSTRAINT     ?   ALTER TABLE ONLY public.avion
    ADD CONSTRAINT fk_avion_relations_modelo_a FOREIGN KEY (idmodelo) REFERENCES public.modelo_avion(idmodelo) ON UPDATE RESTRICT ON DELETE RESTRICT;
 K   ALTER TABLE ONLY public.avion DROP CONSTRAINT fk_avion_relations_modelo_a;
       public       postgres    false    206    2806    197                       2606    24972 *   diaprogramavuelo fk_diaprogr_relations_dia    FK CONSTRAINT     ?   ALTER TABLE ONLY public.diaprogramavuelo
    ADD CONSTRAINT fk_diaprogr_relations_dia FOREIGN KEY (iddia) REFERENCES public.dia(iddia) ON UPDATE RESTRICT ON DELETE RESTRICT;
 T   ALTER TABLE ONLY public.diaprogramavuelo DROP CONSTRAINT fk_diaprogr_relations_dia;
       public       postgres    false    199    198    2769                       2606    24967 /   diaprogramavuelo fk_diaprogr_relations_programa    FK CONSTRAINT     ?   ALTER TABLE ONLY public.diaprogramavuelo
    ADD CONSTRAINT fk_diaprogr_relations_programa FOREIGN KEY (codlinea, idprograma) REFERENCES public.programa_vuelo(codlinea, idprograma) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Y   ALTER TABLE ONLY public.diaprogramavuelo DROP CONSTRAINT fk_diaprogr_relations_programa;
       public       postgres    false    210    2823    199    199    210                        2606    24977     escala fk_escala_relations_lugar    FK CONSTRAINT     ?   ALTER TABLE ONLY public.escala
    ADD CONSTRAINT fk_escala_relations_lugar FOREIGN KEY (idlugar) REFERENCES public.lugar(idlugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 J   ALTER TABLE ONLY public.escala DROP CONSTRAINT fk_escala_relations_lugar;
       public       postgres    false    2802    205    200            "           2606    24987 #   escala fk_escala_relations_programa    FK CONSTRAINT     ?   ALTER TABLE ONLY public.escala
    ADD CONSTRAINT fk_escala_relations_programa FOREIGN KEY (codlinea, idprograma) REFERENCES public.programa_vuelo(codlinea, idprograma) ON UPDATE RESTRICT ON DELETE RESTRICT;
 M   ALTER TABLE ONLY public.escala DROP CONSTRAINT fk_escala_relations_programa;
       public       postgres    false    210    2823    200    200    210            !           2606    24982 #   escala fk_escala_relations_tipoesca    FK CONSTRAINT     ?   ALTER TABLE ONLY public.escala
    ADD CONSTRAINT fk_escala_relations_tipoesca FOREIGN KEY (idtipoescala) REFERENCES public.tipoescala(idtipoescala) ON UPDATE RESTRICT ON DELETE RESTRICT;
 M   ALTER TABLE ONLY public.escala DROP CONSTRAINT fk_escala_relations_tipoesca;
       public       postgres    false    2832    212    200            &           2606    25007 (   evento_pista fk_evento_p_relations_lugar    FK CONSTRAINT     ?   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT fk_evento_p_relations_lugar FOREIGN KEY (idlugar) REFERENCES public.lugar(idlugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT fk_evento_p_relations_lugar;
       public       postgres    false    2802    201    205            '           2606    25012 (   evento_pista fk_evento_p_relations_pista    FK CONSTRAINT     ?   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT fk_evento_p_relations_pista FOREIGN KEY (pis_idlugar, numpista) REFERENCES public.pista(idlugar, numpista) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT fk_evento_p_relations_pista;
       public       postgres    false    201    209    209    201    2820            $           2606    24997 +   evento_pista fk_evento_p_relations_programa    FK CONSTRAINT     ?   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT fk_evento_p_relations_programa FOREIGN KEY (codlinea, idprograma) REFERENCES public.programa_vuelo(codlinea, idprograma) ON UPDATE RESTRICT ON DELETE RESTRICT;
 U   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT fk_evento_p_relations_programa;
       public       postgres    false    2823    210    210    201    201            #           2606    24992 +   evento_pista fk_evento_p_relations_tipo_eve    FK CONSTRAINT     ?   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT fk_evento_p_relations_tipo_eve FOREIGN KEY (idtipoevento) REFERENCES public.tipo_evento(idtipoevento) ON UPDATE RESTRICT ON DELETE RESTRICT;
 U   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT fk_evento_p_relations_tipo_eve;
       public       postgres    false    201    213    2835            %           2606    25002 (   evento_pista fk_evento_p_relations_vuelo    FK CONSTRAINT     ?   ALTER TABLE ONLY public.evento_pista
    ADD CONSTRAINT fk_evento_p_relations_vuelo FOREIGN KEY (idvuelo) REFERENCES public.vuelo(idvuelo) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.evento_pista DROP CONSTRAINT fk_evento_p_relations_vuelo;
       public       postgres    false    215    2841    201            (           2606    25017 ,   horaprogramavuelo fk_horaprog_relations_hora    FK CONSTRAINT     ?   ALTER TABLE ONLY public.horaprogramavuelo
    ADD CONSTRAINT fk_horaprog_relations_hora FOREIGN KEY (idhora) REFERENCES public.hora(idhora) ON UPDATE RESTRICT ON DELETE RESTRICT;
 V   ALTER TABLE ONLY public.horaprogramavuelo DROP CONSTRAINT fk_horaprog_relations_hora;
       public       postgres    false    203    202    2791            )           2606    25022 0   horaprogramavuelo fk_horaprog_relations_programa    FK CONSTRAINT     ?   ALTER TABLE ONLY public.horaprogramavuelo
    ADD CONSTRAINT fk_horaprog_relations_programa FOREIGN KEY (codlinea, idprograma) REFERENCES public.programa_vuelo(codlinea, idprograma) ON UPDATE RESTRICT ON DELETE RESTRICT;
 Z   ALTER TABLE ONLY public.horaprogramavuelo DROP CONSTRAINT fk_horaprog_relations_programa;
       public       postgres    false    203    203    210    210    2823            *           2606    25032 !   lugar fk_lugar_relations_tipo_lug    FK CONSTRAINT     ?   ALTER TABLE ONLY public.lugar
    ADD CONSTRAINT fk_lugar_relations_tipo_lug FOREIGN KEY (idtipolugar) REFERENCES public.tipo_lugar(idtipolugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 K   ALTER TABLE ONLY public.lugar DROP CONSTRAINT fk_lugar_relations_tipo_lug;
       public       postgres    false    2838    214    205            ,           2606    25042 &   ocupacion fk_ocupacio_relations_accion    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT fk_ocupacio_relations_accion FOREIGN KEY (idaccion) REFERENCES public.accion(idaccion) ON UPDATE RESTRICT ON DELETE RESTRICT;
 P   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT fk_ocupacio_relations_accion;
       public       postgres    false    196    2761    207            -           2606    25047 &   ocupacion fk_ocupacio_relations_escala    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT fk_ocupacio_relations_escala FOREIGN KEY (esc_codlinea, idprograma, consec) REFERENCES public.escala(codlinea, idprograma, consec) ON UPDATE RESTRICT ON DELETE RESTRICT;
 P   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT fk_ocupacio_relations_escala;
       public       postgres    false    2777    207    207    207    200    200    200            +           2606    25037 (   ocupacion fk_ocupacio_relations_pasajero    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT fk_ocupacio_relations_pasajero FOREIGN KEY (ndocumento) REFERENCES public.pasajero(ndocumento) ON UPDATE RESTRICT ON DELETE RESTRICT;
 R   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT fk_ocupacio_relations_pasajero;
       public       postgres    false    2816    208    207            .           2606    25052 %   ocupacion fk_ocupacio_relations_silla    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT fk_ocupacio_relations_silla FOREIGN KEY (codlinea, placaavion, idsilla) REFERENCES public.silla(codlinea, placaavion, idsilla) ON UPDATE RESTRICT ON DELETE RESTRICT;
 O   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT fk_ocupacio_relations_silla;
       public       postgres    false    211    207    207    207    211    211    2828            /           2606    25057 $   pasajero fk_pasajero_relations_lugar    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pasajero
    ADD CONSTRAINT fk_pasajero_relations_lugar FOREIGN KEY (idlugar) REFERENCES public.lugar(idlugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 N   ALTER TABLE ONLY public.pasajero DROP CONSTRAINT fk_pasajero_relations_lugar;
       public       postgres    false    205    208    2802            0           2606    25062    pista fk_pista_relations_lugar    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pista
    ADD CONSTRAINT fk_pista_relations_lugar FOREIGN KEY (idlugar) REFERENCES public.lugar(idlugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 H   ALTER TABLE ONLY public.pista DROP CONSTRAINT fk_pista_relations_lugar;
       public       postgres    false    205    209    2802            1           2606    25067 -   programa_vuelo fk_programa_relations_lineaaer    FK CONSTRAINT     ?   ALTER TABLE ONLY public.programa_vuelo
    ADD CONSTRAINT fk_programa_relations_lineaaer FOREIGN KEY (codlinea) REFERENCES public.lineaaerea(codlinea) ON UPDATE RESTRICT ON DELETE RESTRICT;
 W   ALTER TABLE ONLY public.programa_vuelo DROP CONSTRAINT fk_programa_relations_lineaaer;
       public       postgres    false    204    210    2799            2           2606    25072 *   programa_vuelo fk_programa_relations_lugar    FK CONSTRAINT     ?   ALTER TABLE ONLY public.programa_vuelo
    ADD CONSTRAINT fk_programa_relations_lugar FOREIGN KEY (idlugar) REFERENCES public.lugar(idlugar) ON UPDATE RESTRICT ON DELETE RESTRICT;
 T   ALTER TABLE ONLY public.programa_vuelo DROP CONSTRAINT fk_programa_relations_lugar;
       public       postgres    false    205    210    2802            3           2606    25077    silla fk_silla_relations_avion    FK CONSTRAINT     ?   ALTER TABLE ONLY public.silla
    ADD CONSTRAINT fk_silla_relations_avion FOREIGN KEY (codlinea, placaavion) REFERENCES public.avion(codlinea, placaavion) ON UPDATE RESTRICT ON DELETE RESTRICT;
 H   ALTER TABLE ONLY public.silla DROP CONSTRAINT fk_silla_relations_avion;
       public       postgres    false    211    2764    197    197    211            4           2606    25087    vuelo fk_vuelo_relations_avion    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vuelo
    ADD CONSTRAINT fk_vuelo_relations_avion FOREIGN KEY (codlinea, placaavion) REFERENCES public.avion(codlinea, placaavion) ON UPDATE RESTRICT ON DELETE RESTRICT;
 H   ALTER TABLE ONLY public.vuelo DROP CONSTRAINT fk_vuelo_relations_avion;
       public       postgres    false    215    2764    197    197    215            ?      x?????? ? ?      ?      x?????? ? ?      ?   I   x?3??)?K-?2??M,*2?9}3S???s?lN???2 Ô3(Rg???????e?钟????????? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?   ?   x?Mϻ?0??ښ?????? ?[?'?Xܯ;n??ٯ;?Ō	_???
)??bTI?Q#U?NjF*N??*?H?~M????Ly??_^03y???3s??̗"*??????2?G??'H?      ?      x?????? ? ?      ?   ?   x?340?t,?L?KN?240??I,I???9?2?3???s?s?2A?&???y??\1z\\\ ??      ?   4  x?}??N1??;O?' ?D??E??????˰?8?t????y?`?y?s?n?C??7?O?ɲ?*&?x?%?uq]?;????ur?????b
?XM?@	4Rl@ol???:g??N??EKm̎???{?!?wuiKҦ?h?g?AgJ?'t?P-????A??D?Q?:|??Ь.(?M?Q??*?????????t?#?????6???A?p??=?$?N??%4?r???1??WP=q5??̬???۞L????ۘs?t(F>C3????^I??WNv????iI?q??v??????o^ݍԣ?ޚ?? ?????      ?   R   x?M?;
?0E???bd~a?Ҭ?&?H??[E-n????z?}?(r????????f2H??R ʿ????e"?6.?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?   Y   x?3?H?,?2?tI-H,*I?M?+??2??-??L?,???2?t?,MIL?2?tL-?/(M-*?W??+I-?KL???K??2C??????qqq ??      ?      x?????? ? ?      ?      x?????? ? ?     