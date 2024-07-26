--_____________QUESTAO_9
BEGIN TRANSACTION

	-- ANTES DE SER DISTRIBUIDO 
	--SELECT * FROM Funcionario


	DELETE FROM Funcionario WHERE Lider LIKE 'Jonas'




	DECLARE @media_salarios_func_sairam FLOAT


	SELECT 
		@media_salarios_func_sairam = ROUND(SUM(F.Salario)/(SELECT COUNT(EDV) FROM Funcionario WHERE Ativo = 1),2)
	FROM Funcionario F 
	WHERE F.Lider = 'Jonas'


	UPDATE Funcionario
		SET Salario += @media_salarios_func_sairam

		WHERE Ativo = 1


	-- DEPOIS DE SER DISTRIBUIDO 
	--SELECT * FROM Funcionario



ROLLBACK




