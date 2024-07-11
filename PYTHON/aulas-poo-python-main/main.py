# class Casa:
#     energia = False
#     def __init__(self, area: int, cor: str, rua: str, morador: str ="nycollas"):
#         self.area = area
#         self.cor  = cor
#         self.rua  = rua
#         self.morador = morador
#         self.luzes   = False

#     @staticmethod
#     def ligar_energia():
#         print("ligar energia ")
#         Casa.energia =  True

#     def __del__(self):
#         pass 

#     def ligar_luzes(self):
#         if self.energia == True:
#             self.luzes = True
#             print(f"casa de {self.morador} com luzes ligadas")
#         else:
#              print("Sem luz")
#     def desligar_luzes(self):
#             self.luzes = False

#     @staticmethod
#     def cortar_energia():
#         print("cortar energia ")
#         Casa.energia =  False

    
         

# casa_joao = Casa(120, 'azul', 'juscelino k.', "joao")
# casa_maria = Casa(70, 'rosa', 'juscelino k.')


# print(casa_joao)
# print(casa_maria.morador)
        
# print(casa_joao.energia)
# print(casa_maria.energia)
# casa_joao.ligar_luzes()

# Casa.ligar_energia()
# print(casa_joao.energia)
# casa_joao.ligar_luzes()
# print(casa_maria.energia)

# morador = ""

# exemplo = Casa(
#     120, 
#     'verde', 
#     'Auto da XV', 
#     morador
# )

# morador = input("insira o nome do morador: ")

# ternario = Casa( 
#     120, 
#     'verde', 
#     'Auto da XV', 
#     "Sem morador" if morador == "" or morador == None  else "irineu"
# )


