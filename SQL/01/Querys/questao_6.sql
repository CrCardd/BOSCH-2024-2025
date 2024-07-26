--_____________QUESTAO_6
SELECT TOP 1 
	F.Nome,
	F.Lider,
	CONVERT(VARCHAR(10), F.DataContratacao, 103) 'Data de contratacao',
	(SELECT Grade FROM GradeSalarial G WHERE F.Salario >= G.Sal_min AND F.Salario <= G.Sal_max) 'Grade Salarial'

FROM Funcionario F 



ORDER BY F.DataContratacao ASC



