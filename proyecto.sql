PGDMP     %    7                z           proyecto_db    14.2    14.2 )    (           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            )           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            *           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            +           1262    49781    proyecto_db    DATABASE     o   CREATE DATABASE proyecto_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE proyecto_db;
                postgres    false            ?            1259    49782    juego    TABLE     ?   CREATE TABLE public.juego (
    nombre_juego character varying(50) NOT NULL,
    clasificacion character varying(10) NOT NULL,
    genero character varying(10) NOT NULL,
    descripcion character varying(50)
);
    DROP TABLE public.juego;
       public         heap    postgres    false            ?            1259    49797    modalidad_pago    TABLE     ?   CREATE TABLE public.modalidad_pago (
    id_pago character varying(20) NOT NULL,
    nombre character varying(20) NOT NULL,
    periodo character varying(10) NOT NULL,
    precio integer NOT NULL,
    version_id character varying(20) NOT NULL
);
 "   DROP TABLE public.modalidad_pago;
       public         heap    postgres    false            ?            1259    49792 
   plataforma    TABLE     ?   CREATE TABLE public.plataforma (
    nombre character varying(20) NOT NULL,
    modelo character varying(10) NOT NULL,
    fecha_lanzamiento date NOT NULL
);
    DROP TABLE public.plataforma;
       public         heap    postgres    false            ?            1259    49818    posee_tarjeta    TABLE     ?   CREATE TABLE public.posee_tarjeta (
    id integer NOT NULL,
    usuario character varying(15) NOT NULL,
    tarjeta character varying(18) NOT NULL
);
 !   DROP TABLE public.posee_tarjeta;
       public         heap    postgres    false            ?            1259    49817    posee_tarjeta_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.posee_tarjeta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.posee_tarjeta_id_seq;
       public          postgres    false    217            ,           0    0    posee_tarjeta_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.posee_tarjeta_id_seq OWNED BY public.posee_tarjeta.id;
          public          postgres    false    216            ?            1259    49812    tarjeta    TABLE     ?   CREATE TABLE public.tarjeta (
    numero character varying(18) NOT NULL,
    clave character varying(3) NOT NULL,
    nombre character varying(20) NOT NULL,
    fecha_v date NOT NULL
);
    DROP TABLE public.tarjeta;
       public         heap    postgres    false            ?            1259    49802    transaccion    TABLE        CREATE TABLE public.transaccion (
    numero integer NOT NULL,
    fecha_hora date NOT NULL,
    monto integer NOT NULL,
    descuento integer NOT NULL,
    id_pago character varying(20) NOT NULL,
    nickname character varying(15) NOT NULL,
    tarjeta character varying(18) NOT NULL
);
    DROP TABLE public.transaccion;
       public         heap    postgres    false            ?            1259    49807    usuario    TABLE       CREATE TABLE public.usuario (
    nickname character varying(15) NOT NULL,
    email character varying(20) NOT NULL,
    nombre character varying(20) NOT NULL,
    fecha_nac date NOT NULL,
    telefono character varying(10) NOT NULL,
    plataforma character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ?            1259    49787    version    TABLE     ?   CREATE TABLE public.version (
    version_id character varying(20) NOT NULL,
    requisito character varying(10) NOT NULL,
    "año_creacion" integer NOT NULL,
    juego character varying(50) NOT NULL,
    plataforma character varying(20) NOT NULL
);
    DROP TABLE public.version;
       public         heap    postgres    false            x           2604    49821    posee_tarjeta id    DEFAULT     t   ALTER TABLE ONLY public.posee_tarjeta ALTER COLUMN id SET DEFAULT nextval('public.posee_tarjeta_id_seq'::regclass);
 ?   ALTER TABLE public.posee_tarjeta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217                      0    49782    juego 
   TABLE DATA           Q   COPY public.juego (nombre_juego, clasificacion, genero, descripcion) FROM stdin;
    public          postgres    false    209   >4                  0    49797    modalidad_pago 
   TABLE DATA           V   COPY public.modalidad_pago (id_pago, nombre, periodo, precio, version_id) FROM stdin;
    public          postgres    false    212   [4                 0    49792 
   plataforma 
   TABLE DATA           G   COPY public.plataforma (nombre, modelo, fecha_lanzamiento) FROM stdin;
    public          postgres    false    211   x4       %          0    49818    posee_tarjeta 
   TABLE DATA           =   COPY public.posee_tarjeta (id, usuario, tarjeta) FROM stdin;
    public          postgres    false    217   ?4       #          0    49812    tarjeta 
   TABLE DATA           A   COPY public.tarjeta (numero, clave, nombre, fecha_v) FROM stdin;
    public          postgres    false    215   ?4       !          0    49802    transaccion 
   TABLE DATA           g   COPY public.transaccion (numero, fecha_hora, monto, descuento, id_pago, nickname, tarjeta) FROM stdin;
    public          postgres    false    213   ?4       "          0    49807    usuario 
   TABLE DATA           [   COPY public.usuario (nickname, email, nombre, fecha_nac, telefono, plataforma) FROM stdin;
    public          postgres    false    214   ?4                 0    49787    version 
   TABLE DATA           \   COPY public.version (version_id, requisito, "año_creacion", juego, plataforma) FROM stdin;
    public          postgres    false    210   	5       -           0    0    posee_tarjeta_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.posee_tarjeta_id_seq', 1, false);
          public          postgres    false    216            z           2606    49786    juego juego_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.juego
    ADD CONSTRAINT juego_pkey PRIMARY KEY (nombre_juego);
 :   ALTER TABLE ONLY public.juego DROP CONSTRAINT juego_pkey;
       public            postgres    false    209            ?           2606    49801 "   modalidad_pago modalidad_pago_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.modalidad_pago
    ADD CONSTRAINT modalidad_pago_pkey PRIMARY KEY (id_pago);
 L   ALTER TABLE ONLY public.modalidad_pago DROP CONSTRAINT modalidad_pago_pkey;
       public            postgres    false    212            ~           2606    49796    plataforma plataforma_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.plataforma
    ADD CONSTRAINT plataforma_pkey PRIMARY KEY (nombre);
 D   ALTER TABLE ONLY public.plataforma DROP CONSTRAINT plataforma_pkey;
       public            postgres    false    211            ?           2606    49823     posee_tarjeta posee_tarjeta_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.posee_tarjeta
    ADD CONSTRAINT posee_tarjeta_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.posee_tarjeta DROP CONSTRAINT posee_tarjeta_pkey;
       public            postgres    false    217            ?           2606    49816    tarjeta tarjeta_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (numero);
 >   ALTER TABLE ONLY public.tarjeta DROP CONSTRAINT tarjeta_pkey;
       public            postgres    false    215            ?           2606    49806    transaccion transaccion_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_pkey PRIMARY KEY (numero);
 F   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_pkey;
       public            postgres    false    213            ?           2606    49811    usuario usuario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (nickname);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    214            |           2606    49791    version version_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.version
    ADD CONSTRAINT version_pkey PRIMARY KEY (version_id);
 >   ALTER TABLE ONLY public.version DROP CONSTRAINT version_pkey;
       public            postgres    false    210            ?           2606    49834 -   modalidad_pago modalidad_pago_version_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.modalidad_pago
    ADD CONSTRAINT modalidad_pago_version_id_fkey FOREIGN KEY (version_id) REFERENCES public.version(version_id) ON UPDATE CASCADE ON DELETE CASCADE;
 W   ALTER TABLE ONLY public.modalidad_pago DROP CONSTRAINT modalidad_pago_version_id_fkey;
       public          postgres    false    210    3196    212            ?           2606    49859 (   posee_tarjeta posee_tarjeta_tarjeta_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.posee_tarjeta
    ADD CONSTRAINT posee_tarjeta_tarjeta_fkey FOREIGN KEY (tarjeta) REFERENCES public.tarjeta(numero) ON UPDATE CASCADE ON DELETE CASCADE;
 R   ALTER TABLE ONLY public.posee_tarjeta DROP CONSTRAINT posee_tarjeta_tarjeta_fkey;
       public          postgres    false    215    217    3206            ?           2606    49854 (   posee_tarjeta posee_tarjeta_usuario_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.posee_tarjeta
    ADD CONSTRAINT posee_tarjeta_usuario_fkey FOREIGN KEY (usuario) REFERENCES public.usuario(nickname) ON UPDATE CASCADE ON DELETE CASCADE;
 R   ALTER TABLE ONLY public.posee_tarjeta DROP CONSTRAINT posee_tarjeta_usuario_fkey;
       public          postgres    false    3204    217    214            ?           2606    49839 $   transaccion transaccion_id_pago_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_id_pago_fkey FOREIGN KEY (id_pago) REFERENCES public.modalidad_pago(id_pago) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_id_pago_fkey;
       public          postgres    false    212    3200    213            ?           2606    49844 %   transaccion transaccion_nickname_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_nickname_fkey FOREIGN KEY (nickname) REFERENCES public.usuario(nickname) ON UPDATE CASCADE ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_nickname_fkey;
       public          postgres    false    214    3204    213            ?           2606    49849 $   transaccion transaccion_tarjeta_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.transaccion
    ADD CONSTRAINT transaccion_tarjeta_fkey FOREIGN KEY (tarjeta) REFERENCES public.tarjeta(numero) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY public.transaccion DROP CONSTRAINT transaccion_tarjeta_fkey;
       public          postgres    false    213    3206    215            ?           2606    49864    usuario usuario_plataforma_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_plataforma_fkey FOREIGN KEY (plataforma) REFERENCES public.plataforma(nombre) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_plataforma_fkey;
       public          postgres    false    211    214    3198            ?           2606    49824    version version_juego_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.version
    ADD CONSTRAINT version_juego_fkey FOREIGN KEY (juego) REFERENCES public.juego(nombre_juego) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.version DROP CONSTRAINT version_juego_fkey;
       public          postgres    false    3194    209    210            ?           2606    49829    version version_plataforma_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.version
    ADD CONSTRAINT version_plataforma_fkey FOREIGN KEY (plataforma) REFERENCES public.plataforma(nombre) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.version DROP CONSTRAINT version_plataforma_fkey;
       public          postgres    false    210    211    3198                  x?????? ? ?             x?????? ? ?            x?????? ? ?      %      x?????? ? ?      #      x?????? ? ?      !      x?????? ? ?      "      x?????? ? ?            x?????? ? ?     