import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        listaEmpregado listWorkers = new listaEmpregado();
        PointList pointList = new PointList();

        Empregado user = new Empregado();
        
        
        
        user.setName("adm");
        user.setCpf("adm");
        user.setBirth("adm");
        user.setPassword("131621");
        user.setAdm(true);
        listWorkers.add(user);

        while(true)
        {
        user = new Empregado();
        System.out.printf("\n\n\nPor favor insira seu cpf:\n>>>  ");
        user.setCpf(scanner.nextLine());

        System.out.printf("Por favor insira sua senha:\n>>>  ");
        user.setPassword(scanner.nextLine());

        user = listWorkers.listCompare(user, listWorkers);
        
        if(user == null){
            System.out.printf("Login não encontrado!");
            return;
        }
        if(user.isAdm()){
            System.err.printf("\n\nAdministrador logado com sucesso!\n");
            boolean operand = true;
            String resp;
            int caso;    
            System.out.printf("\n[1] Cadastrar novo empregado\n[2] Bater ponto\n[3] Listar empregados\n[2] Pesquisar empregado");
            do{
                System.out.printf("\n>>>  ");
                caso = scanner.nextInt();
                scanner.nextLine();
            } while ( caso < 1 ||  caso > 4 );

            switch (caso) {
                case 1:
                    while(operand){
                        
                        Empregado newEmpregado = new Empregado();
        
                        System.out.printf("\nnome:\n>>>  ");
                        newEmpregado.setName(scanner.nextLine());
        
                        System.out.printf("\ncpf:\n>>>  ");
                        newEmpregado.setCpf(scanner.nextLine());
        
                        System.out.printf("\ndata de nascimento:\n>>>  ");
                        newEmpregado.setBirth(scanner.nextLine());
        
                        System.out.printf("\nsenha:\n>>>  ");
                        newEmpregado.setPassword(scanner.nextLine());
                        
                        System.out.printf("\nadm ( 0 - false | 1 - true ):");
                        int setAdm;
                        do{
                            System.out.printf("\n>>>  ");
                            setAdm = scanner.nextInt();
                            scanner.nextLine();
                        } while ( setAdm != 1 &&  setAdm != 0);
                        if(setAdm==1){
                            newEmpregado.setAdm(true);
                        }else{
                            newEmpregado.setAdm(false);
                        }
                        
                        listWorkers.add(newEmpregado);
                        System.err.printf("Deseja cadastrar novo empregado? (S/N)");
                        do{
                            System.out.printf("\n>>>  ");
                            resp = scanner.nextLine();
                        } while(!(resp.equals("S") || resp.equals("s") || resp.equals("N") || resp.equals("n")));
                        if( resp.equals("N") || resp.equals("n")){
                            break;
                        }
                    }
                    break;
            
                case 2:
                    Point point = new Point();
                    System.out.printf("\nPor favor insira seu cpf:\n>>>  ");
                    point.setCpf(scanner.nextLine());
        
                    System.out.printf("\nPor favor insira a hora atual:\n>>>  ");
                    point.setHour(scanner.nextInt());
                    scanner.nextLine();
        
                    System.out.printf("\nPor favor insira os minutos atuais:\n>>>  ");
                    point.setMinute(scanner.nextInt());
                    scanner.nextLine();
        
                    System.out.printf("\nPor favor insira o dia de hoje:\n>>>  ");
                    point.setDay(scanner.nextInt());
                    scanner.nextLine();
                    
                    System.out.printf("\nPor favor insira o mês que estamos:\n>>>  ");
                    point.setMonth(scanner.nextInt());
                    scanner.nextLine();
        
                    pointList.add(point);
                    break;

                case 3:
                    for( int i = 0 ; i < listWorkers.getSize() ; i ++ )
                        System.out.printf("%s\n",listWorkers.listarEmpregados(listWorkers, i));
                break;
                case 4:
                    System.out.printf("\n\nInsira o CPF do empregado desejado:\n>>>  ");
                    String cpf = scanner.nextLine();
                    for ( int i = 0 ; i < pointList.getSize() ; i++ )
                    {
                        String result = pointList.searchEmployer(i, cpf);
                        if( result == null )
                        {
                            System.out.printf("\nEmpregado não encontrado!\n");
                        } else
                        {
                            System.out.printf("%s\n",result);
                        }

                    }
                    break;
            }


        }
        else{
            System.out.printf("\n\nEmpregado logado com sucesso!");
            
            Point point = new Point();
            System.out.printf("\nPor favor insira seu cpf:\n>>>  ");
            point.setCpf(scanner.nextLine());

            System.out.printf("\nPor favor insira a hora atual:\n>>>  ");
            point.setHour(scanner.nextInt());
            scanner.nextLine();

            System.out.printf("\nPor favor insira os minutos atuais:\n>>>  ");
            point.setMinute(scanner.nextInt());
            scanner.nextLine();

            System.out.printf("\nPor favor insira o dia de hoje:\n>>>  ");
            point.setDay(scanner.nextInt());
            scanner.nextLine();
            
            System.out.printf("\nPor favor insira o mês que estamos:\n>>>  ");
            point.setMonth(scanner.nextInt());
            scanner.nextLine();

            pointList.add(point);
        }    
        }
    }
}
