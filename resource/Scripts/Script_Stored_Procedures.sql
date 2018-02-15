#Procedure 2
#Juliana

DELIMITER $$


DROP PROCEDURE IF EXISTS kpi_atendimento $$


CREATE PROCEDURE kpi_atendimento(Matricula_tec varchar(13), Data_1 DATE, Data_2 DATE) 


main: BEGIN


SELECT Matricula_tecnico, KPI_1, Dsc_KPI_1, KPI_2, Dsk_KPI_2, dt_inicio_periodo, dt_final_periodo

FROM kpi

WHERE Matricula_tecnico = Matricula_tec and Data_1 = dt_inicio_periodo and Data_2 = dt_final_periodo;

END $$


end

call kpi_atendimento ('3221219790138', '20160303', '20160412');


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