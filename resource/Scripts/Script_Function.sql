#Das funções só tentamos a primeira

#Edvaldo
DELIMITER $
CREATE FUNCTION fn_hora(m VARCHAR(13))
RETURNS INT

determINistic
BEGIN

DECLARE CargaHoraria int(8);
DECLARE Trabalha_sabado VARCHAR(3);
DECLARE aux INT (11);
DECLARE r INT (11);

SET aux = ( SELECT CargaHoraria
FROM assistech.funcionario F
INNER JOIN assistech.jornada_de_trabalho J 
ON F.IdJornada=J.Id
WHERE Matricula = m) ;

IF (SELECT Trabalha_sabado from jornada_de_trabalho JOIN assistech.funcionario ON Id=( SELECT IdJornada
FROM assistech.funcionario F
INNER JOIN assistech.jornada_de_trabalho J 
ON F.IdJornada=J.Id
WHERE Matricula = m) = 'sim') THEN

SET r = aux*6;
ELSE
SET r= aux*5;
END IF;
RETURN r;

END $

#Bartô
delimiter |
CREATE FUNCTION fn_hora_semana(mat VARCHAR(13))
returns int
deterministic
begin

	declare done int default 0;
    #declare done_i int default 0;
    declare current_fmat int;
    declare current_idJorn int;
    declare current_seqDia int;
    declare current_codTurno int;
    declare horas int;
    declare total int;
    declare Contador int default 1;
    #declare fmatcur cursor for select Matricula from assistech.funcionario;
    declare idJornada_cur cursor for select Id_jornada from assistech.jornada_de_trabalho_tem;
    declare seqDia_cur cursor for select seq_dia from assistech.jornada_de_trabalho_tem;
    declare codTurno_cur cursor for select cod_turno from assistech.jornada_de_trabalho_tem;
    declare continue handler for not found set done = 1;
    #declare continue handler for not found set done_i = 1;
    SET total = (SELECT COUNT(*) from
			assistech.funcionario F JOIN jornada_de_trabalho J
				ON F.IdJornada=J.Id 
			JOIN jornada_de_trabalho_tem Jt
				ON J.Id=Jt.Id_jornada
            JOIN dia D
				ON Jt.seq_dia=D.sequencial
			JOIN turno T
				ON Jt.cod_turno=T.codigo
			where F.Matricula = mat);
    
    #open fmatcur;
    open idJornada_cur;
    open seqDia_cur;
    open codTurno_cur;
    
    WHILE Contador <= total DO
		
    
    repeat 
		fetch  idJornada_cur into current_idJorn; 
        fetch  seqDia_cur into current_seqDia; 
        fetch  codTurno_cur into current_codTurno; 
        
        SET horas = horas +
        abs((SELECT sum(HOUR(hora_final) )
			from 
			assistech.funcionario F JOIN jornada_de_trabalho J
				ON F.IdJornada=J.Id 
			JOIN jornada_de_trabalho_tem Jt
				ON J.Id=Jt.Id_jornada
            JOIN dia D
				ON Jt.seq_dia=D.sequencial
			JOIN turno T
				ON Jt.cod_turno=T.codigo
			where F.Matricula = mat and Id_jornada=current_idJorn and seq_dia=current_seqDia and cod_turno=current_codTurno)
         -
         (SELECT sum(HOUR(hora_inicio ))
			from 
			assistech.funcionario F JOIN jornada_de_trabalho J
				ON F.IdJornada=J.Id 
			JOIN jornada_de_trabalho_tem Jt
				ON J.Id=Jt.Id_jornada
			JOIN dia D
				ON Jt.seq_dia=D.sequencial
			JOIN turno T
				ON Jt.cod_turno=T.codigo
			where F.Matricula = mat and Id_jornada=current_idJorn and seq_dia=current_seqDia and cod_turno=current_codTurno));   
            
            until done
	end repeat;
   
	close idJornada_cur;
    close  seqDia_cur;
	close  codTurno_cur;

return horas;

end |

select *
			from 
			assistech.funcionario F JOIN jornada_de_trabalho J
				ON F.IdJornada=J.Id 
			JOIN jornada_de_trabalho_tem Jt
				ON J.Id=Jt.Id_jornada
			JOIN dia D
				ON Jt.seq_dia=D.sequencial
			JOIN turno T
				ON Jt.cod_turno=T.codigo
			where F.Matricula = mat;

SELECT hora_final, hora_inicio from assistech.funcionario F JOIN jornada_de_trabalho J
				ON F.IdJornada=J.Id 
			JOIN jornada_de_trabalho_tem Jt
				ON J.Id=Jt.Id_jornada
			JOIN turno T
				ON Jt.cod_turno=T.codigo
			where F.Matricula = '3221219790133';

SELECT HOUR(hora_inicio) from turno where codigo=0;

drop function fn_hora_semana;

SELECT * from assistech.funcionario where Matricula='3221219790133';

SELECT * from jornada_de_trabalho_tem where Id_jornada='32163329';

SELECT fn_hora('3221219790133');

