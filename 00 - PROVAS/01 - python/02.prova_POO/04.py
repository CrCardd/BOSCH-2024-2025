class Bosch:
    def __init__(self,nome,cnpj,nacionalidade,nome_do_responsavel,paises_de_atuacao,produtos):
        self.nome = nome
        self.cnpj = cnpj
        self.nacionalidade = nacionalidade
        self.nome_do_responsavel = nome_do_responsavel
        self.paises_de_atuacao = paises_de_atuacao
        self.produtos = produtos

    def get_nome_responsavel(self):
        return self.nome_do_responsavel
    def get_paises_atuacao(self):
        return self.paises_de_atuacao
    def pesquisar_pais_atuacao(self):
        pais = input('Digite o país que deseja procurar:\n>>> ')
        pais = pais.lower()
        pais = pais.title()
        if pais in self.paises_de_atuacao:
            print(f'A empresa [{self.nome}] está presente no país \'{pais}\'')
        else:
            print(f'A empresa [{self.nome}] não atua no país \'{pais}\'')
    def add_produto(self):
        dicionario = {}
        produt = input('Insira o nome do novo produto:\n>>> ')    
        produt.lower()
        while 1:
            try:
                preco = int(input(f'Digite o preço do produto \'{produt}\'\n>>> '))
                break
            except:
                print('Erro. Valor inválido!')
        descricao = input('Escreva a descrição do produto:\n>>> ') 
        
        dicionario['nome'] = produt
        dicionario['preco'] = f'R${preco}'
        dicionario['descricao'] = descricao
        self.produtos.append(dicionario)
    def retorar_relatorio_produtos(self):
        for _ in range(len(empresa.produtos)):
            print(f'NOME: {empresa.produtos[_]['nome']}\t PREÇO: {empresa.produtos[_]['preco']}\t| DESCRIÇÃO: {empresa.produtos[_]['descricao']}')
    def pesquisar_produto(self,produt):
        for _ in range(len(self.produtos)):
            if produt == self.produtos[_]['nome']:
                print(produt)
                print(f'NOME: {empresa.produtos[_]['nome']}\t PREÇO: {empresa.produtos[_]['preco']}\t| DESCRIÇÃO: {empresa.produtos[_]['descricao']}')
    
class Area(Bosch):
    def __init__(self, nome, cnpj, nacionalidade, nome_do_responsavel, paises_de_atuacao, produtos,sigla_do_setor,funcao,lucro,inicio_auditoria,fim_auditoria):
        super().__init__(nome, cnpj, nacionalidade, nome_do_responsavel, paises_de_atuacao, produtos)
        self.sigla_do_setor = sigla_do_setor
        self.funcao = funcao
        self.lucro = lucro
        self.inicio_auditoria = inicio_auditoria
        self.fim_auditoria = fim_auditoria
    def get_relatorio_finan(self):
        return f'=-=-=-=-=-=-=-=-=-=-=\nSETOR: {self.sigla_do_setor}\nLucro\t{self.lucro}'
    def get_auditoria(self):
        return f'\nAuditoria (inicio):\t{self.inicio_auditoria}\nAuditoria (fim):\t{self.fim_auditoria}\nResponsável:\t{self.nome_do_responsavel}'
    
class Departamento(Area):
    funcionarios = []
    def __init__(self, nome, cnpj, nacionalidade, nome_do_responsavel, paises_de_atuacao, produtos, sigla_do_setor, funcao, lucro, inicio_auditoria, fim_auditoria,quantidade_funcionarios):
        super().__init__(nome, cnpj, nacionalidade, nome_do_responsavel, paises_de_atuacao, produtos, sigla_do_setor, funcao, lucro, inicio_auditoria, fim_auditoria)
        self.quantidade_funcionarios = quantidade_funcionarios
        for _ in range(self.quantidade_funcionarios):
            op = input(f'Digite o nome do {_+1}° funcionário:\n>>> ')
            Departamento.funcionarios.append(op)
    def contratar_funcionario(self,nome):
        print(f'O funcionário [{nome}] foi contratado!')
        Departamento.funcionarios.append(nome)   
    def treinar_funcionario(self,nome):
        if nome in Departamento.funcionarios:
            print(f'O funcionário [{nome}] irá realizar um treinamento!')
        else: 
            print(f'O(A) Sr(a) [{nome}] não está contratado(a) na empresa.')
    def get_funcionarios(self):
        return len(Departamento.funcionarios)



empresa = Bosch('Robert Bosch',9990999,'Alemã','Presidente',['Brasil','Argentina','Alemanha','Japao'],    [{ 'nome' : 'bomba', 'preco' : 'R$8.000', 'descricao' : 'Bomba flex fluel'}, { 'nome' : 'carro', 'preco' : 'R$95.000', 'descricao' : 'carro elétrico'}])
print(90*'=')
print('EMPRESA')
print(f'Nome do responsável ( presidente ): {empresa.get_nome_responsavel()}')
for _ in empresa.get_paises_atuacao():
    print(_,end='\t')
print('')
empresa.pesquisar_pais_atuacao()
empresa.add_produto()
empresa.retorar_relatorio_produtos()
op = input('Digie o produto que deseja pesquisar:\n>>> ')
op.lower()
empresa.pesquisar_produto(op)
#==================================================================
print(90*'=')
print('AREA')
area = Area('Area Area',8880888,'Brasileiro','CEO',['Brasil'],[{'nome': 'produto1','preco' : 'inserir preco', 'descricao' : 'inserir descriacao'},{'nome': 'produto2','preco' : 'inserir preco', 'descricao' : 'inserir descriacao'}],'AA','Olhar a Area','R$18000000','10/08/2022','29/02/2024')
print(f'\n===================\nNome do responsável: {area.get_nome_responsavel()}')
print(area.get_relatorio_finan())
print(area.get_auditoria())
#==================================================================
print(90*'=')
print('DEPARTAMENTO')
departamento = Departamento('QMM',1110111,'Brasileiro','GESTOR',['Brasil'],[{'nome': 'produto1','preco' : 'inserir preco', 'descricao' : 'inserir descriacao'},{'nome': 'produto2','preco' : 'inserir preco', 'descricao' : 'inserir descriacao'}],'QMV','Cuidar da Qualidade','R$800.000','09/02/2019','24/05/2021',2)
print(f'Nome do responsável: {departamento.get_nome_responsavel()}')
nome = input('Digite o nome do novo funcionário que será contratado:\n>>> ')
departamento.contratar_funcionario(nome)
print(f'O departamento {departamento.sigla_do_setor} possui [{departamento.get_funcionarios()}] funcionários.')