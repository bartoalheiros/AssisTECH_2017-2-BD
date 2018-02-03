use assistech;

#a princípio, os privilégios listados, foram dados ao administrador,
#mas isso pode mudar.
CREATE ROLE 'administrador';
GRANT INSERT, SELECT, UPDATE, DELETE ON
assistech.* TO 'administrador';
CREATE USER 'administrador1'@'localhost' IDENTIFIED BY 'admin1passw';
GRANT 'administrador' TO 'administrador1';

CREATE ROLE 
'funcionario';
GRANT SELECT, UPDATE ON assistech.funcionario TO 'funcionario';
GRANT SELECT ON assistech.contracheque TO 'funcionario'; 
GRANT SELECT, UPDATE ON assistech.jornada_de_trabalho TO 'funcionario'; 
GRANT SELECT ON asssitech.jornada_de_trabalho_tem TO 'funcionario';
GRANT SELECT, UPDATE ON assistech.dia TO 'funcionario'; 
GRANT SELECT, UPDATE ON assistech.turno TO 'funcionario';
CREATE USER 'funcionario1'@'localhost' IDENTIFIED BY 'func1passw';
GRANT 'funcionario' TO 'funcionario1';

CREATE ROLE
'supervisor';
CREATE USER 'supervisor1'@'localhost' IDENTIFIED BY 'supv1passw';
GRANT INSERT, SELECT, DELETE, UPDATE ON assistech.insumo TO 'supervisor';
GRANT SELECT, INSERT, UPDATE, DELETE ON assistech.categoria_insumo TO 'supervisor';
GRANT 'supervisor' TO 'supervisor1';

CREATE ROLE
'tecnico';
CREATE USER 'tecnico1'@'localhost' IDENTIFIED BY 'tec1passw';
GRANT SELECT ON assistech.tecnico_esta_em_equipe TO 'tecnico';
GRANT SELECT ON assistech.kpi TO 'tecnico';

CREATE ROLE
'atendente';
GRANT SELECT, UPDATE, INSERT ON
assistech.chamado TO 'atendente';
CREATE USER 'atendente1'@'localhost' IDENTIFIED BY 'atend1passw';

select * from mysql.user;

select current_role();

#drop role adm_financ;