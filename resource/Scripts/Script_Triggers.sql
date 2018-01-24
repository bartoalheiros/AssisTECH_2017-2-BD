use assistech;

#Trigger1. Para atualizar o atributo  "idade" da tabela DEPENDENTE
delimiter |
create trigger update_age
before insert on assistech.dependente
for each row
begin
	SET @ano_atual:=YEAR(curdate());
    SET @idade:=(@ano_atual) - YEAR(new.Data_nascimento);
    SET @mes_atual:=MONTH(curdate());
    SET @dia_atual:=DAY(curdate());
    SET @mes_nasc:=MONTH(new.Data_nascimento);
    SET @dia_nasc:=DAY(new.Data_nascimento);
   
    if  @mes_atual<@mes_nasc then
		set @idade:=@idade-1;
        elseif @mes_atual>=@mes_nasc and @dia_atual>=@dia_nasc then
			set @idade:=@idade;
    end if;
    
    set new.Idade=@idade;
end|

#Trigger2.  Para atualizar   o atributo "Num.Funcionarios" de UNIDADE DE SUPORTE
delimiter |
create trigger upd_num_funcionarios
after insert on assistech.funcionario
for each row
begin
	SET @num_func:=(select Nro_funcionarios from assistech.unidade_de_suporte where Cod=new.CodigoUnidadeDeSuporte);
    UPDATE assistech.unidade_de_suporte SET Nro_funcionarios = @num_func + 1 WHERE  Cod=new.CodigoUnidadeDeSuporte;
end |


#show triggers in assistech;

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