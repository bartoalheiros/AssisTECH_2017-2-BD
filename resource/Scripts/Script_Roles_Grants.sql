#Assistech BD S
#author: Bartô
use assistech;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON assistech.* TO 'admin'@'localhost';

FLUSH PRIVILEGES;

CREATE USER 'funcionario1'@'localhost' IDENTIFIED BY 'func1passw';
GRANT SELECT, UPDATE ON assistech.funcionario TO 'funcionario1'@'localhost';
GRANT SELECT ON assistech.contracheque TO 'funcionario1'@'localhost';
GRANT SELECT, UPDATE ON assistech.jornada_de_trabalho TO 'funcionario1'@'localhost';
GRANT SELECT ON jornada_de_trabalho_tem TO 'funcionario1'@'localhost';
GRANT SELECT, UPDATE ON assistech.dia TO 'funcionario1'@'localhost'; 
GRANT SELECT, UPDATE ON assistech.turno TO 'funcionario1'@'localhost';

FLUSH PRIVILEGES;

CREATE USER 'supervisor1'@'localhost' IDENTIFIED BY 'supv1passw';
GRANT INSERT, SELECT, DELETE, UPDATE ON assistech.insumo TO 'supervisor1'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON assistech.categoria_insumo TO 'supervisor1'@'localhost';

FLUSH PRIVILEGES;

CREATE USER 'tecnico1'@'localhost' IDENTIFIED BY 'tec1passw';
GRANT SELECT ON assistech.tecnico_esta_em_equipe TO 'tecnico1'@'localhost';
GRANT SELECT ON assistech.kpi TO 'tecnico1'@'localhost';

FLUSH PRIVILEGES;

CREATE USER 'atendente1'@'localhost' IDENTIFIED BY 'atend1passw';
GRANT SELECT, UPDATE, INSERT ON
assistech.chamado TO 'atendente1'@'localhost';

FLUSH PRIVILEGES;






###############################################################
#Codigos de teste. Desconsiderar
select * from mysql.user;

#SHOW GRANTS FOR 'administrador1'@'localhost';

drop role administrador;
drop role funcionario;

show grants for 'funcionario1'@'localhost';