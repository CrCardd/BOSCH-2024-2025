--_____________QUESTAO_4
SELECT 
	D.Nome,
	MAX(F.Salario) 'Maior sal�rio',
	MIN(F.Salario) 'Menor sal�rio',
	ROUND(SUM(F.Salario)/COUNT(F.Salario),2) 'M�dia salarial' 

FROM Funcionario F
INNER JOIN Departamento D ON D.Departamento = F.Departamento

GROUP BY D.Departamento, D.Nome