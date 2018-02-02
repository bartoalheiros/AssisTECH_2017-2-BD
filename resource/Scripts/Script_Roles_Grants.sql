use assistech;

CREATE ROLE administrador;

GRANT INSERT, SELECT, UPDATE, DELETE ON
assistech.* TO 'administrador';

CREATE USER 'administrador1'@'localhost' IDENTIFIED BY 'admin1';
#CREATE USER 'read_user1'@'localhost' IDENTIFIED BY 'read_user1pass';
#CREATE USER 'read_user2'@'localhost' IDENTIFIED BY 'read_user2pass';
#CREATE USER 'rw_user1'@'localhost' IDENTIFIED BY 'rw_user1pass';

CREATE ROLE 
'funcionario';

CREATE ROLE
'supervisor';

GRANT INSERT, UPDATE, DELETE ON
assistech.insumo TO 'supervisor';

CREATE ROLE
'tecnico';

CREATE ROLE
'atendente';


select * from mysql.user;

select current_role();

#drop role adm_financ;