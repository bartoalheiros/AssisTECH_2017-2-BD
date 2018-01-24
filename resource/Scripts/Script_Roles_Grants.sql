use assistech;

CREATE ROLE 
'administrador';

GRANT ALL ON
assistech.* TO 'administrador';

CREATE ROLE 
'funcionario';



CREATE ROLE
'supervisor';

CREATE ROLE
'tecnico';

CREATE ROLE
'atendente';


#select * from mysql.user;

#drop role adm_financ;