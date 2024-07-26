--_____________QUESTAO_4
SELECT 
	D.Nome,
	MAX(F.Salario) 'Maior salário',
	MIN(F.Salario) 'Menor salário',
	ROUND(SUM(F.Salario)/COUNT(F.Salario),2) 'Média salarial' 

FROM Funcionario F
INNER JOIN Departamento D ON D.Departamento = F.Departamento

GROUP BY D.Departamento, D.Nome