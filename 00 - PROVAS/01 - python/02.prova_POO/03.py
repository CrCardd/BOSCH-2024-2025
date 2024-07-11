class Conta:
    __contas = 0
    def __init__(self,nome_do_cliente,numero_da_agencia,saldo_cliente,tipo_conta):
        self.__nome_do_cliente = nome_do_cliente
        self.__numero_da_agencia = numero_da_agencia
        self.__saldo_cliente = saldo_cliente
        self.__tipo_conta = tipo_conta

    @staticmethod 
    def contas():
        Conta.__contas += 1
        print(f'total de contas no banco: [{Conta.__contas}]')
    
    def mostrar_cliente(self):
        print(f'Nome:\t{self.__nome_do_cliente}\nNúmero da agência:\t{self.__numero_da_agencia}\nSaldo:\tR${self.__saldo_cliente}\nTipo de conta:\t{self.__tipo_conta}\n\n')

clientes = []
while 1:
    nome = input('Por favor digite o nome do novo cliente:\n>>> ')
    numero_da_agencia = int(input('Por favor digite o numero da agência do novo cliente:\n>>> '))
    saldo_cliente = int(input('Por favor digite o saldo do novo cliente:\n>>> '))
    
    op = 0
    while op!= '1' and op!='2':
        op = input('\n1 - Corrente\n2 - Poupança\n\nPor favor digite o tipo de conta do novo cliente:\n>>> ')
    match op:
        case '1':
            tipo_conta = 'Corrente'
        case '2':
            tipo_conta = 'Poupança'
    
    o = Conta(nome,numero_da_agencia,saldo_cliente,tipo_conta)
    o.mostrar_cliente()
    Conta.contas()
    clientes.append(o)


