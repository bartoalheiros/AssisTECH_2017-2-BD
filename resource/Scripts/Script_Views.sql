
use assistech;

/*SELECT  Cod_cliente, Cnpj as 'Cnpj/CPF', Razao_social as 'Nome/Razao_social' from cliente_jur UNION (SELECT * from cliente_fis);*/
CREATE VIEW Uniao as SELECT Cod_cliente, cpf AS cpf_cnpj, Nome AS Nome_Razao_social FROM cliente_fis UNION SELECT *FROM cliente_jur; /*INNER JOIN cliente ON cliente_fis.Cod_cliente = cliente.Cod;*/

CREATE VIEW pri_alta_cliente as SELECT c.Cod, c.prioridade, c.endereco, c.email, c.fone, u.cpf_cnpj, u.nome_razao_social 
FROM cliente as c INNER JOIN Uniao as u on c.Cod = u.Cod_cliente where c.prioridade = 'alta';

CREATE VIEW pri_chamado as SELECT *FROM chamado as c where c.status_chamado = 'Em processo' and c.prioridade = 'Sim';

CREATE VIEW os as SELECT *FROM ordem_servico;

CREATE VIEW equi_datas as SELECT *FROM equipamento e WHERE e.data_entrada between ('2012-11-10') and ('2012-11-18');


