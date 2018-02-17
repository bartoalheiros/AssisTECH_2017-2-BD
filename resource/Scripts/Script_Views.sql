
use assistech;

/*SELECT  Cod_cliente, Cnpj as 'Cnpj/CPF', Razao_social as 'Nome/Razao_social' from cliente_jur UNION (SELECT * from cliente_fis);*/
CREATE VIEW Uniao as SELECT Cod_cliente, cpf AS cpf_cnpj, Nome AS Nome_Razao_social FROM cliente_fis UNION SELECT *FROM cliente_jur; /*INNER JOIN cliente ON cliente_fis.Cod_cliente = cliente.Cod;*/

CREATE VIEW pri_alta_cliente as SELECT c.Cod, c.prioridade, c.endereco, c.email, c.fone, u.cpf_cnpj, u.nome_razao_social 
FROM cliente as c INNER JOIN Uniao as u on c.Cod = u.Cod_cliente where c.prioridade = 'alta';

CREATE VIEW pri_chamado as SELECT *FROM chamado as c where c.status_chamado = 'Em processo' and c.prioridade = 'Sim';

CREATE VIEW os as SELECT *FROM ordem_servico;

CREATE VIEW equi_datas as SELECT *FROM equipamento e WHERE e.data_entrada between ('2012-11-10') and ('2012-11-18');

CREATE VIEW OS_Fatura_andamento as SELECT os.Num_Ordem_Servico, os.Dt_devida, os.Prazo_em_dias, os.Cod_orcamento, os.Cod_fatura, f.Valor_total, f.Cod_cliente FROM ordem_servico as os INNER JOIN fatura as f on os.Cod_fatura = f.Cod WHERE f.Status_ = 'Em andamento';

CREATE VIEW funcio_super as SELECT *FROM funcionario as f WHERE EXISTS (SELECT *FROM supervisor as s WHERE f.matricula = s.matricula);

CREATE VIEW funcio_tecnico as SELECT *FROM funcionario as f INNER JOIN tecnico as t on f.matricula = t.matricula_tecnico; -- WHERE EXISTS (SELECT *FROM tecnico as t WHERE f.matricula = t.matricula_tecnico);

CREATE VIEW funcio_adm_fin as SELECT *FROM funcionario as f WHERE EXISTS (SELECT *FROM adm_financeiro as a WHERE f.matricula = a.matricula);

CREATE VIEW jornada_fun as SELECT *FROM jornada_de_trabalho as jt INNER JOIN funcionario as f on jt.id = f.idJornada WHERE jt.Trabalha_sabado = 'Sim' and f.CargaHoraria = 8;

CREATE VIEW kpi_data as SELECT kpi.sequencial, kpi.matricula_tecnico, kpi.kpi_1, kpi.kpi_2, kpi.dt_inicio_periodo, 
kpi.dt_final_periodo, t.dias_trabalhados, t.nro_consertos, t.voltas 
FROM kpi INNER JOIN tecnico as t on kpi.matricula_tecnico = t.matricula_tecnico 
WHERE kpi.dt_final_periodo between ('2016-04-12') and ('2018-12-30');

CREATE VIEW contrachaque as SELECT *FROM contracheque as c WHERE c.data_ between ('2014-04-01') and ('2014-04-30');

CREATE VIEW servico_incompleto as SELECT *FROM servico as s WHERE s.status_servico = 'incompleto';


