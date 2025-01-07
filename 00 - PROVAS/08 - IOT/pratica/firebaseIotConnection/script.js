import {service} from "./js/datebaseConfig.js"

const endPoint = "/Cristian"

// Definindo estrutura do corpo do meu objeto do banco.
var body = {
    
}

// Carregando dados do meu banco
const loadData = () => {
    service.load(endPoint).then( data => {
        body = data;
        console.log(body);
        setTempValues();

    })
}

// ==================  Colocando os dados no HTML   ==================


const setTempValues = () => {
    const TempElement = document.getElementById("Temperature")
    const HumidElement = document.getElementById("Humidity")

    let Hvalue = 0;
    let Tvalue = 0;

    Hvalue = body.Sensor.Humidity;
    Tvalue = body.Sensor.Temperature;
    
    console.log(Hvalue);
    console.log(Tvalue);
    
    TempElement.innerHTML = Tvalue
    HumidElement.innerHTML = Hvalue
}

console.log('script loaded');


setInterval(() => {
    loadData();
}, 2000);