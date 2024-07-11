class Aluno:
    def __init__(self,nome,idade,turma,planta):
        self.__nome = nome
        self.__idade = idade
        self.__turma = turma
        self.__planta = planta
    
    def get_nome(self):
        return self.__nome
    def get_idade(self):
        return self.__idade
    def get_turma(self):
        return self.__turma
    def get_planta(self):
        return self.__planta
    def get_aluno(self):
        return f'ALUNO: {self.__nome}\t| IDADE: {self.__idade} |\tTURMA: {self.__turma} |\tPLANTA: {self.__planta} \n'
    
with open("alunos.txt", "w", encoding="utf-8") as arquivo:
     arquivo.write('')

while 1:

    nome = input("Digite o nome do aluno: ")
    idade = input("Digite a idade do aluno: ")
    turma= input("Digite a turma do aluno: ")
    planta = input("Digite a planta do aluno: ")

    aluno = Aluno(nome,idade,turma,planta)
    with open("alunos.txt", "a", encoding="utf-8") as arquivo:
        arquivo.write(aluno.get_aluno())