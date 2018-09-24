# Projeto Segurança
Projeto com falhas de segurança.

Utilizado no curso de Arquitetura Java da Caelum - https://www.caelum.com.br/curso-arquitetura-java

Rode no terminal:

```bash
mysql -u root -p seguranca
insert into usuario(nome, login, senha) values('Admin', 'admin', '$2a$10$ggY6QemLtXTV9z7pr0xKf.gdjhplcldE9iwo.IPIeCbvdRGM4UifC');
```

Para logar na aplicação acesse: http://localhost:8080/seguranca e utilize o login **admin** e a senha **123456**
