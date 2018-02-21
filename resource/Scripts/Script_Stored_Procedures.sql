#Procedure 2
#Juliana e Bartô
#TODO: gerar a linha INSERT na tabela KPI
DROP PROCEDURE IF EXISTS kpi_atendimento;

DELIMITER $$

CREATE PROCEDURE kpi_atendimento(Matricula_tec varchar(13), Data_1 DATE, Data_2 DATE, Seq_kpi int) 


main: BEGIN

declare num_atendimentos int;

SELECT COUNT(id_atendimento) into num_atendimentos FROM atendimento WHERE (Mat_tec_campo = Matricula_tec AND DAY(Dta_atendimento) >= DAY(Data_1) AND DAY(Dta_atendimento) <= DAY(Data_2));

INSERT INTO kpi VALUES(Seq_kpi, Matricula_tec,num_atendimentos, 0, 'Total de Máquinas Consertadas por Semana', '', Data_1, Data_2, CURDATE());


END $$

call kpi_atendimento ('3221219790123', '2017-03-01','2017-03-15', 166545);


DELIMITER ;

#Juliana
#3. Procedore para identificar todos os itens do estoque que estejam com a qtd_atual mais baixa que a qtd_minima


DELIMITER $$


DROP PROCEDURE IF EXISTS verifica_qtd $$

CREATE PROCEDURE verifica_qtd() 


main: BEGIN


Select * from Item_estoque where Quantidade_Atual < Quantidade_minima;



END $$



call verifica_qtd;