use assistech;

#Trigger1. Para atualizar o atributo  "idade" da tabela DEPENDENTE
delimiter |
create trigger update_age
before insert on assistech.dependente
for each row
begin
	#este bloco if corrige o erro que pode ocorrer pela simples subtração do ano_atual - ano_nasc.
    #se o ano 'virou', mas o mês chegou e o dia não é subtraído 1 da data de aniversario calculada
    #pois a pessoa oficialmente ainda não fez aniversário.
    if  ( MONTH(curdate()) < MONTH(new.Data_nascimento) or MONTH(curdate()) >= MONTH(new.Data_nascimento) ) and DAY(curdate()) < DAY(New.Data_nascimento) then
		set new.Idade = ((YEAR(curdate())) - YEAR(new.Data_nascimento))-1;
        elseif MONTH(curdate()) >= MONTH(new.Data_nascimento) and DAY(curdate()) >= DAY(new.Data_nascimento) then
			set new.Idade = (YEAR(curdate())) - YEAR(new.Data_nascimento);
    end if;
end|

drop trigger upd_num_func_del;

#Trigger2.1  Para atualizar   o atributo "Num.Funcionarios" de UNIDADE DE SUPORTE ao Inserir um Funcionário.
delimiter |
create trigger upd_num_func_ins
after insert on assistech.funcionario
for each row
begin
	SET @num_func:=(select Nro_funcionarios from assistech.unidade_de_suporte where Cod=new.CodigoUnidadeDeSuporte);
    UPDATE assistech.unidade_de_suporte SET Nro_funcionarios = @num_func + 1 WHERE  Cod=new.CodigoUnidadeDeSuporte;
end |

#Trigger2.2  Para atualizar   o atributo "Num.Funcionarios" de UNIDADE DE SUPORTE ao Remover um Funcionário.
delimiter |
create trigger upd_num_func_del
after delete on assistech.funcionario
for each row
begin
	SET @num_func:=(select Nro_funcionarios from assistech.unidade_de_suporte where Cod=old.CodigoUnidadeDeSuporte);
    UPDATE assistech.unidade_de_suporte SET Nro_funcionarios = @num_func - 1 WHERE  Cod=old.CodigoUnidadeDeSuporte;
end |

#Trigger3.  Para  gerar o valor do atributo "dt_devida" de ORDEM DE SERVICO
delimiter |
create trigger set_dta_devida
before insert on assistech.ordem_servico
for each row
begin
	 SET @dta_atual:=curdate();
     SET @last_month_day:=DAY(LAST_DAY( @dta_atual ));
     SET @mes_atual:=MONTH(@dta_atual);
     SET @prazo:=new.Prazo_em_dias;
     SET @ano_atual:=YEAR(@dta_atual);
     SET @dia_atual:=DAY(@dta_atual);
     
     if (@ano_atual %4 = 0) AND (@ano_atual % 100 != 0) OR (@ano_atual % 400 = 0)  then
		if @mes_atual=2 AND (@prazo + @dia_atual) > 29 then
			set @diferenca:=abs(@prazo-@dia_atual);
            
        end if;	
	 end if;
		
end |

#select abs(7);
#SELECT DAY(LAST_DAY( curdate() )) as DIAS_MES;

#drop trigger upd_num_funcionarios; #show triggers in assistech;