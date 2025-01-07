class Livro():
    

    def __init__(self, titulo, autor, qtd_paginas, guardado=True):
        self.titulo = titulo
        self.autor = autor
        self.qtd_paginas = qtd_paginas
        self.guardado = guardado
        self.pagina_atual = 0

    def pegar_livro(self):
        if self.guardado == True:
            self.guardado = False
            print('Pegou o livro.')
        else:
            print('O livro não está disponível!\n')
        
    def devolver_livro(self):
        if self.guardado == False:
            self.guardado = True
            print('O livro foi guardado.')
        else:
            print('O livro já foi guardado!\n')

    def virar_uma_pagina(self):
        if self.guardado == False and self.pagina_atual<self.qtd_paginas:
            self.pagina_atual += 1
            print(f'Página: [{self.pagina_atual}]')

        elif self.guardado==True:
            print('O livro está guardado!\n')
        else:
            print('O livro chegou ao fim!\n')

    def virar_n_paginas(self,qtd):
        if self.guardado == False and self.pagina_atual+qtd <= self.qtd_paginas:
            self.pagina_atual += qtd
            print(f'Página: [{self.pagina_atual}]')
        elif self.guardado==True:
            print('O livro está guardado!\n')
        else:
            print('Limite de páginas ultrapassado!\n')

    def voltar_uma_pagina(self):
        if self.guardado == False and self.pagina_atual-1>=1:
            self.pagina_atual -= 1
            print(f'Página: [{self.pagina_atual}]')

        elif self.guardado==True:
            print('O livro está guardado!\n')
        else:
            print('Limite de páginas ultrapassado!\n')

    def voltar_n_paginas(self,qtd):
        if self.guardado == False and self.pagina_atual-qtd >= 1:
            self.pagina_atual -= qtd
            print(f'Página: [{self.pagina_atual}]')
    
    def ler_livro(self):
        print(f'Livro   -->  {self.titulo}\nAutor   -->  {self.autor}\nPáginas --> {self.qtd_paginas}')

    def ir_para_pagina(self,qtd):
        if self.guardado == False and qtd>=1 and qtd<=self.qtd_paginas:
            self.pagina_atual = qtd
            print(f'Página: [{self.pagina_atual}]')

        elif self.guardado==True:
            print('O livro está guardado!\n')
        else:
            print('Limite de páginas ultrapassado!\n')


livro = Livro('O Pequeno Princípe','...',169)


while True:
    op=0
    while op>8 or op<1:
        while 1:
            try:
                op = int(input('1 - pegar livro\n2 - devolver livro\n3 - virar uma pagina\n4 - virar n paginas\n5 - voltar uma pagina\n6 - voltar n paginas\n7 - detalhes do livro\n8 - Ir para página\n>>>'))
                break
            except:
                print('Erro. Valor inválido!\n')

    match op:
        case 1:
            livro.pegar_livro()
        case 2:
            livro.devolver_livro()
        case 3:
            livro.virar_uma_pagina()
        case 4:
            while 1:
                try:
                    qtd = int(input('Digite quantas páginas deseja avançar:\n>>> '))
                    break
                except:
                    print('Erro. Valor inválido!\n')
            livro.virar_n_paginas(qtd)
        case 5:
            livro.voltar_uma_pagina()
        case 6:
            while 1:
                try:
                    qtd = int(input('Digite quantas páginas deseja voltar:\n>>> '))
                    break
                except:
                    print('Erro. Valor inválido!\n')
            livro.voltar_n_paginas(qtd)
        case 7:
            livro.ler_livro()
        case 8:
            while 1:
                try:
                    pag = int(input('Digite a página a qual deseja ir:\n>>> '))
                    break
                except:
                    print('Erro. Valor inválido!\n')
            livro.ir_para_pagina(pag)
