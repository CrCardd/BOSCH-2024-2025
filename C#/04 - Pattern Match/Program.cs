int num = 500;

if(num is 400 or 500)
{
    
}
if(num is <500 and >400 and int number)
{

}

List<int> list = [1, 2, 3, 4, 5];

int[] list2 = [0, ..list, 6, 7, 8];     //ADICIONA NO MEIO

foreach(var x in list2[2..5])           //PERCORRE DO INDICE <2> ATE O INDICE <5>
    Console.WriteLine(x);

Console.WriteLine(list[^2]);            //ACESSA O <penultimo> ITEM

if(list2 is [.., 1, 2, 3]){}            //SE TERMINA COM <1,2,3>
if(list2 is [1, 2, 3, ..]){}            //SE COMEÇA COM <1,2,3>
if("Olá mundo" is [.., 'm', 'u', 'n', 'd', 'o']){}        //SE TERMINA COM <"mundo">


int var1 = 3;
string var2 = "ACCEPTED";
bool var3 = false;

int result = 
    (var1, var2, var3) switch
    {
        (0, "ACCEPTED", true) => 1,
        (>0, "ACCEPTED", false) => 1,
        (>0 and <18, "ACCEPTED" or "FAIL", true) => 1,
        (>18, _, false) => 1,
        _ => 0
    };



List<int> values = [1, 2, 3, 4, 5, 6];
var result2 = values switch
    {
        [1, 2, _, 4, ..] or [.., 5, 6] => "OK",
        [1, 2, int value, ..] => value.ToString(),
        _ => "VISH"
    };

var result3 = 5123 switch 
    {
        <1231 => 3,
        1231 => 4,
        >=1233 => 5,
        _ => 6
    };


Instrutor[] instrutores = 
    [
        new Instrutor("don", 1.4f),
        new Instrutor("queila", 1.45f),
        new Instrutor("trevis", 2.45f),
    ];



foreach(var instrutor in instrutores)
{
    string result4 = instrutor switch
    {
        { Altura: <1.7f} => "!ALTO",
        { Altura: >2.1f, Nome: not "trevis"} => "GIGANTE",
        _ => ""
    };
}

var etsCutiriba = new ETS("Curitiba", instrutores);

foreach(var instrutor in etsCutiriba.Instrutores)                   // PODE ESTOURAR ERRO CASO UM DOS CAMPOS SEJA NULO
    Console.WriteLine(instrutor);

foreach(var instrutor in etsCutiriba?.Instrutores ?? [])            // UTILIZA DE '?' PARA VALIDAR SE UM DOS OBJETOS É NULO OU NAO, CASO NULO RETORNA '[]'
    Console.WriteLine(instrutor?.Nome ?? "Sem nome");




public record Instrutor(string Nome, float Altura);
public record ETS(string Cidade, Instrutor[] Instrutores);
