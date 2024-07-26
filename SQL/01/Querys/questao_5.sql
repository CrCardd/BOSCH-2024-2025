--_____________QUESTAO_5
CREATE FUNCTION salario_maior_que(@base INT)
RETURNS TABLE
AS
	RETURN
	(
		SELECT 
			D.Nome 'Departamento',
			COUNT(F.Salario) 'Quantidade de funcionários'

		FROM Funcionario F
		INNER JOIN Departamento D ON D.Departamento = F.Departamento

		WHERE F.Salario >= @base

		GROUP BY D.Departamento, D.Nome
	)

--SELECT * FROM salario_maior_que(0)