#AS

Repositori del projecte d'Arquitectura del Software

*Software Architechture project repository*


##Setup

###PostreSQL (Ubuntu)

**Instal·lació:**

Instal·lem el servidor i l'administrador pgAdminIII.

```bash
$> sudo apt-get install postgresql postgresql-contrib
$> sudo apt-get install pgadmin3
```

**Server setup:**

Iniciem una connexió amb el servidor amb l'usuari 'postgres' i posem com a contrasenya 'postgres'. Quan volguem tancar la connexió, introduïm `\q`. Creem també una base de dades que anomenarem 'asdb' (important per a que no haguem de canviar la configuració d'Hibernate).

```bash
$> sudo -u postgres psql postgres
$> \password postgres
$> sudo -u postgres createdb asdb
```

Un cop engegat el servidor PostgreSQL, podem continuar amb Hibernate.
