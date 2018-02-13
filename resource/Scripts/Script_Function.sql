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

SELECT fn_hora(3221219790118);

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


