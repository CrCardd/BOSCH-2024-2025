--_____________QUESTAO_7_A
ALTER TABLE Funcionario 
ADD Ativo BIT

SELECT * FROM Funcionario



--_____________QUESTAO_7_B
UPDATE Funcionario
SET Ativo = 1


--_____________QUESTAO_7_C
CREATE TRIGGER desativar_funcionario
ON Funcionario
INSTEAD OF DELETE
AS
BEGIN
	UPDATE Funcionario
		SET Ativo = 0

		WHERE EDV IN (SELECT EDV FROM deleted Funcionario)

END



