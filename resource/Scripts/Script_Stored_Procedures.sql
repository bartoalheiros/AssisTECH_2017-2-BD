#1. Para atualizar situação no ALMOXARIFADO dos  ITEM DE ESTOQUE. Quando solicitados  pelo SUPERVISOR.
delimiter |
create procedure upd_situacao()
begin

if exists (Select * from Item_estoque where Quantidade_Atual < Quantidade_minima) then
	
end if;
		
end |

#Juliana
#3. Procedore para identificar todos os itens do estoque que estejam com a qtd_atual mais baixa que a qtd_minima


DELIMITER $$


DROP PROCEDURE IF EXISTS verifica_qtd $$

CREATE PROCEDURE verifica_qtd() 


main: BEGIN


Select * from Item_estoque where Quantidade_Atual < Quantidade_minima;



END $$


call verifica_qtd;