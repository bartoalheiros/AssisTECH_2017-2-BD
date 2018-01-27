delimiter |
CREATE FUNCTION fn_hora_semana(m VARCHAR(13))
returns int
deterministic
begin

declare r int;

select CargaHoraria into r from assistech.funcionario where Matricula = m;

return r*5;
end |

SELECT fn_hora_semana('3221219790126');