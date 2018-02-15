
/*1 para retornar o total de hora semanal de trabalho de um FUNCIONADIO a partir de sua jornada de trabalho*/

use assistech

DROP FUNCTION fn_hora;

-- Edvaldo e Bartô
DELIMITER $
 CREATE FUNCTION fn_hora(m varchar(13) )
 returns int(8)
 
 deterministic
 begin
 
declare carg int(8);
declare r int (8);
declare tra varchar(3);
    
select j.Trabalha_sabado into tra
from funcionario as f
inner join jornada_de_trabalho as j
on f.IdJornada = j.Id
where f.Matricula = m;

select f.CargaHoraria into carg
from funcionario as f
where f.Matricula = m;

if  tra = 'Sim' then
set r = (carg * 5) + 4;
elseif 
 tra = 'Não' then
set r =  (carg * 5);


 end if;
 return r;
 end $
 
 select fn_hora('3221219790129');


#Juliana
# Cria a função, assinatura entrando com uma variavel do tipo INT
DELIMITER $
CREATE FUNCTION faturas_pagas(fatura INT)
RETURNS BOOLEAN

determINistic
BEGIN

# Cria uma variavel para armazenar o total de faturas que já foram pagas
DECLARE totalFaturasPagas int(8);

# Cria uma variavel para armazenar o numero de parcelas da fatura
DECLARE totalFaturas int(3);

# Recupera o número de faturas pagas
SET totalFaturasPagas = ( select  count(c.Cod)
FROM cliente as c
INNER JOIN fatura as f ON c.Cod = f.Cod_cliente
INNER JOIN parcela_pagto_fatura as pg ON f.Cod = pg.Cod_fatura WHERE c.Cod = fatura);

  # Recupera o número de faturas totais
SET totalFaturas = ( SELECT Num_parcelas FROM fatura WHERE Cod_cliente = fatura);

  # Se o número total de parcelas da fatura for maior que o número de parcelas já pagas retorna 1
  IF ((totalFaturas - totalFaturasPagas) > 0) THEN
    return TRUE;
  ELSE
    RETURN FALSE ;
  END IF;

END $

# Chamada da função
SELECT faturas_pagas(122211);


