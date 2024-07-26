--_____________QUESTAO_8
CREATE FUNCTION search_func_letter(@letter VARCHAR(1))
RETURNS TABLE 
AS
	RETURN
	(
		SELECT 
			Nome,
			CASE WHEN Ativo = 1 THEN 'Ativo' ELSE 'Inativo' END 'Atual'
		FROM Funcionario
		
		WHERE Nome LIKE @letter + '%'
	)

--SELECT * FROM search_func_letter('D')
