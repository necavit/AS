#AS

El codi de la pràctica es troba al directori `word-guess`. L'informe de la pràctica es troba al directori `report`.


##Setup

####Maven

[Maven](http://en.wikipedia.org/wiki/Apache_Maven) és una eina que ens permet la gestió de tot el cicle de vida d'un projecte. Entre d'altres, automatitza la gestió de dependències i les fases que es poden executar: validació, compilació, empaquetat, testeig, desplegament...

Farem servir Maven per a facilitar la gestió de dependències.

**Instal·lació (Ubuntu):**

Si tenim les capçaleres ben actualitzades, s'hauria de descarregar la versió 3 de Maven:

```bash
sudo apt-get install maven
```

Si exeutem `mvn --version` en un terminal ens ha de dir: `Apache Maven 3.0.4 ...`.

**Integració amb Eclipse**

Per integrar-ho fàcilment amb Eclipse, podem instal·lar el plugin m2e. Si cerquem 'maven' a l'Eclipse marketplace, hi ha una entrada que ens instal·larà tots els components necessaris. No és la versió de desenvolupament de Maven, sinó només les eines d'integració!

**POM.xml**

El fitxer de configuració de Maven del projecte és el `pom.xml`. Aquí es defineix tant la gestió de dependències com tot el flux de l'execució d'un build.

####PostreSQL (Ubuntu)

**Instal·lació:**

Instal·lem el servidor i l'administrador pgAdminIII.

```bash
sudo apt-get install postgresql postgresql-contrib
sudo apt-get install pgadmin3
```

**Server setup:**

Iniciem una connexió amb el servidor amb l'usuari 'postgres':

```bash
sudo -u postgres psql postgres
```

Un cop iniciada, ens assegurem que posem com a contrasenya 'postgres', mitjançant la comanda `\password postgres` (ens demanarà quina nova contrasenya se li assignarà a l'usuari 'postgres'). Quan volguem tancar la connexió, introduïm `\q`.

Creem també una base de dades que anomenarem 'asdb' (important per a que no haguem de canviar la configuració d'Hibernate):

```bash
sudo -u postgres createdb asdb
```

Un cop engegat el servidor PostgreSQL, podem continuar amb Hibernate.
