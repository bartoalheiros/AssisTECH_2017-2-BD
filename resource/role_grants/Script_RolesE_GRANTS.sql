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

#Trigger1. Para atualizar o atributo  "idade" da tabela DEPENDENTE
delimiter |
create trigger update_age
before insert on assistech.dependente
for each row
begin
	SET new.Idade = (select EXTRACT(YEAR from  curdate())) - (select EXTRACT(YEAR from new.Data_nascimento));
end|

#select * from mysql.user;

#drop role adm_financ;