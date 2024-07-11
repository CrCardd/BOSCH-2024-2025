# class Matematica:
#     def __init__ (self):
#         self.public = "public"
#         self.__Pi = 3.14159265

#     def get_pi(self):
#         return self.__Pi

#     def piv2(self):
#         return self.__Pi * 2

# mat = Matematica()
# mat.public = "uma string"
# print(mat.get_pi())
# print(mat.__Pi)
# print(mat.piv2())



#! herança 

#! pai
# class InstrumentoEscrita:
#     def __init__(self, material):
#         self.material = material

#     def Escrever(self):
#         print("escrevendo..")
#     def Desenhar(self):
#         print("Desenhando em sentidos aleatórios")

# #!filho
# class lapis(InstrumentoEscrita):
#     def __init__(self):
#         super().__init__("grafite")


# class Canetinha(InstrumentoEscrita):
#     def __init__(self):
#         super().__init__('tinta')

#     def Desenhar(self):
#         print("Desenhando em sentidos horizontais")


# print("instrumento de escrita")
# instrumento = InstrumentoEscrita("cera")
# instrumento.Desenhar()
# print(f"Material : {instrumento.material}\n")

# print("lápis")
# l = lapis()
# l.Desenhar()
# print(f"Material : {l.material}\n")

# print('Canetinha')
# c = Canetinha()
# c.Desenhar()
# print(f"Material : {l.material}\n")


# --------------------------------------------------------

class Personagem:
    _vida = 0
    _força = 0
    _inteligencia = 0
    _dinheiro_por_minuto = 0

    def __init__(self):
        self._vida = 100
        self._força = 10
        self._inteligencia = 10
        self._dinheiro_por_minuto = 10
        pass

    def getVida(self):
        return self._vida

    def Minerar(self):
        return self._força

class Goblin(Personagem):

    def __init__(self):
        super().__init__()
        self._força = 14
        self._inteligencia = 8
        self._dinheiro_por_minuto = 11
    

random = Personagem()
print(f"Vida de um personagem aleatório: {random.getVida()}")
print(f"Força de mineração: {random.Minerar()}")

g = Goblin()
print(f"Vida de um Goblin: {g.getVida()}")
print(f"Força de mineração: {g.Minerar()}")

