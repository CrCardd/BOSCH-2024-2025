import os


def error():
    print('\033[1;31mVALOR INVÁLIDO.\033[0;0m')
def limp():
    os.system('cls')



# with open('arquivoNovo.txt','w') as arq2:
#     arq2.write('')

# cE = ['~','*','!','.','#','%','$','(',')','&','_','+','@','\\','?','\'','']
# with open('clientes.txt','r') as arq:
#     for nome in arq:
#         nome = list(nome)
#         for _ in cE:
#             try:
#                 nome.remove(_)
#             except:
#                 pass

#         with open('arquivoNovo.txt','a') as arq2:
#             for i in nome:
#                 arq2.write(f'{i}')




#         print(nome)


            
# #===========================================================================================================================================







# op=0
# som=0
# while op <= 0:
#     while 1:
#         try:
#             op = int(input('Insira um número maior que 0:\n>>> '))
#             break
#         except:
#             limp()
#             error()
#     if op>0:
#         break
#     else:
#         limp()
#         error()

# op = str(op)
# for _ in op:
#     som+=int(_)
# limp()

# print(f'Número:\t\t\t\t {op}\nA soma de todos os algarismos é: {som}')


# #===========================================================================================================================================

# divisoe = [[],[],[]]
# times = ['1_palmeiras', '2_coritiba','1_corintians','3_juventude','2_fluminense','3_bahia','1_cuiaba','2_cascavel','3_ponte preta', '2_parana clube', '3_volta redonda','3_karlla','2_queila','1_Kau','2_dom']

# for _ in times:
#     _=_.split('_')
#     divisoe[int(_[0])-1].append(_[1].title())

# for l in range(len(divisoe)):
#     print(f' {l+1}° divisão:\t',end='')
#     for c in range(len(divisoe[l])):
#         print(divisoe[l][c],end='  ')
#     print('')

# #===============================================================================================================================================


# def buscarNome(listaTel,nome,telefone):
#     if nome == '':
#         nome = input('Digite o nome que deseja pesquisar:\n>>> ')
#         nome = nome.lower()
#     try:
#         limp()
#         print(f'Nome : {nome}\n')
#         for telefone in listaTel[nome]:
#             print(f'Telefone : {telefone}')
#         print('\n\n\n')
#     except:
#             op = input(f'O usuário \'{nome}\' não está em nosso sistema, deseja cadastra-lo? (S/N):\n>>> ')
#             op = op.lower()
#             if op =='s':
#                 listaTel = cadasNome(listaTel,telefone)

# def cadasNome(listaTel,telefone):
#     nome = input('Por favor digite o novo nome a ser cadastrado:\n>>> ')
#     nome = nome.lower()
#     while 1:
#         tel = input(f'Por favor digite o número do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')
#         if tel == '0':
#             break
#         while not tel.isdigit() or len(tel)!=11 :
#             limp()
#             error()
#             tel = input(f'Por favor digite o número do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')
#             if tel == '0':
#                 break
#         if tel == '0':
#             break
#         telefone.append(tel)
#     listaTel = newName(listaTel,nome,telefone)
#     return listaTel


# def newName(lis,nm,tel):
#     lis[nm] = tel
#     return lis




# listaTel = {}
# while 1:
#     op = 0
#     telefone = []
#     while op<1 or op>4:
#         while 1:
#             try:   
#                 print('\n\n')
#                 op = int(input('1 - Inserir novo nome\n2 - Buscar por nome\n3 - Incluir ou retirar telefone\n4 - Excluir usuário\n\n>>> '))
#                 break
#             except:
#                 limp()
#                 error()
#         if op != 1 and op!=2 and op!=3 and op!=4:
#             limp()
#             error()

#     match op:
#         case 1:
#             cadasNome(listaTel,telefone)
        
#         case 2:
#             nome = ''
#             buscarNome(listaTel,nome,telefone)
        
#         case 3:
#             limp()
#             op = input('1 - Retirar\n2 - Adicionar\n>>> ')
#             while op!='1' and op!='2':
#                 limp()
#                 error()
#                 op = input('1 - Retirar\n2 - Adicionar')
#             match int(op):

#                 case 1:
#                     try:
#                         nome = input('Por favor digite o nome do usuário que terá um número retirado:')
#                         buscarNome(listaTel,nome,telefone)
#                         while 1:
#                             try:
#                                 tel = input(f'Por favor digite o número que será RETIRADO do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')
#                                 if tel == '0':
#                                     break
#                                 while not tel.isdigit() or len(tel)!=11:
#                                     limp()
#                                     error()
#                                     tel = input(f'Por favor digite o número que será RETIRADO do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')
#                                     if tel == '0':
#                                         break
#                                 if tel == '0':
#                                     break
#                                 listaTel[nome].remove(tel)
#                                 break
#                             except:
#                                 error()
#                                 print('O número digitado não está correto.')
#                     except:
#                         op = input(f'O usuário \'{nome}\' não está em nosso sistema, deseja cadastra-lo? (S/N):\n>>> ')
#                         op = op.lower()
#                         if op =='s':
#                             listaTel = cadasNome(listaTel,telefone)




#                 case 2:
#                     try:
#                         nome = input('Por favor digite o nome do usuário que receberá um novo número:')
#                         nome = nome.lower()
#                         while 1:
#                             tel = input(f'Por favor digite o NOVO número do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')
#                             if tel == '0':
#                                 break
#                             while not tel.isdigit() or len(tel)!=11:
#                                 limp()
#                                 error()
#                                 tel = input(f'Por favor digite o NOVO número do usuário \'{nome}\' no formato XXXXXXXXXXX( 0 - encerrar):\n>>>')

#                             aux = listaTel[nome][:]
#                             aux.append(tel)
#                             listaTel[nome] = aux           
                        
#                     except:
#                         op = input(f'O usuário \'{nome}\' não está em nosso sistema, deseja cadastra-lo? (S/N):\n>>> ')
#                         op = op.lower()
#                         if op =='s':
#                             listaTel = cadasNome(listaTel,telefone)

#         case 4:
#             nome = input('Por favor digite o nome a ser RETIRADO:\n>>> ')
#             try:
#                 nome = nome.lower()
#                 listaTel.pop(nome)
#             except:
#                 error()
#                 print(f'O usuário {nome} já não está no sistema.\n\n')


#===============================================================================================================================================================
    
# limp()
# print('lista =[]\n\ntam=int(input("Digite o tamanho da lista: "))\n\nfor i in range(1,tam+1,1):\n\tx=int(input("VALOR {} : ".format(i)))\n\tlista.append(x)\nprint("\\nLISTA:")\nprint(lista)\nfor i in range(tam):\n\tfor j in range(tam):\n\t\tif lista[j] > lista[i]:\n\t\t\tlista[i],lista[j]=lista[j],lista[i]\n\nprint("\\nLISTA ORDENADA: ")\nprint(lista)')
# print('\n\n')
# print('\tO programa pede ao usuário o tamanho de uma lista e os valores de cada item da mesma. A lista será ordenada\n em ordem crescente e apresentada ao usuário.')
# print('Primeiro o programa declara \'lista\' como uma lista, para depois poder utilizar o append nela, então ele pede')
# print('ao usuário o tamanho da lista e armazena na variável \'tam\', utiliza de um for para percorrer a quantidade de')
# print('vezes indicada pelo usuário, e pedindo a ele para inserir o valor de cada indice.')
# print('\tNos últimos \'for\' aninhados o programa percorre a lista ja completa comparando o valor valor da frente com')
# print('o anterior, caso o valor da frente seja maior ele irá inverter os valores, a príncipio parece que a lista ficará')
# print('em ordem decrescente, mas ao decorrer do código ele conserta a lista, deixando-a em odem crescente, o problema')
# print('sobre parecer que ficará errado poderia ser concertado invertando o sinal na comparação \'if lista[j] > lista[i]\' e')
# print('alterando os parâmetros do segundo \'for\' para \'for j in range(i,tam).\n\n\n')



