from machine import Pin
import time
import network
import urequests
import ujson
import dht


dht_sensor = dht.DHT11(Pin(33))

led_loading = Pin(25,Pin.OUT)


led_min    =  Pin(14,Pin.OUT)    #GREEN
led_middle =  Pin(27,Pin.OUT)   #YEELOW
led_max    =  Pin(26,Pin.OUT)   #RED


temp_min = 25
temp_max = 27



def read_dht11():
    try:
        dht_sensor.measure()
        temp = dht_sensor.temperature()
        hum = dht_sensor.humidity()
        print("Temperatura: {}°C  Umidade: {}%".format(temp, hum))
        
        return (temp, hum)
        
        
    except OSError as e:
        print("")
    
def temp_level_leds(data):
    temperature = 0
    humidity    = 0
    
    
    try:
        temperature = data[0]
        humidity    = data[1]
    
    
        if(temperature <= temp_min):
            led_min.on()
        else:
            led_min.off()
            
        if(temperature >= temp_max):
            led_max.on()
        else:
            led_max.off()

        if(temperature > temp_min and temperature < temp_max):
            led_middle.on()
        else:
            led_middle.off()
        
    except OSError as e:
        print("Falha na leitura do sensor:", e)


#Credenciais do WIFI
nome = "Bobiaram"
senha = "rapaz401"

# Endereço do firebase
FIREBASE_URL = "https://iiot-7276b-default-rtdb.firebaseio.com/"
SECRET_KEY = ""

headers = {
    "Content-Type": "application/json",
    "Authorization": "Bearer " + SECRET_KEY
}
url = FIREBASE_URL + "/Cristian.json"


def conectarWifi():
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    if not wlan.isconnected():
        print("Conectando no WiFi...")
        wlan.connect(nome, senha)
        while not wlan.isconnected():
            pass
    print("Wifi conectado... IP: {}".format(wlan.ifconfig()[0]))

def enviarFire(data):
    
    led_loading.on()
    
    response = urequests.put(url, data=ujson.dumps(data), headers=headers)
    print("Firebase Response:", response.text)
    response.close()
    
    led_loading.off()
    
    



#------------------------MAIN------------------------#
conectarWifi()
while True:
    
    info = read_dht11()    
    temp_level_leds(info)
    
    temp_data = {
        'Temperature' : info[0],
        'Humidity'    : info[1]
    }
    
    leds_data = {
        'led_min' : led_min.value(),
        'led_middle' : led_middle.value(),
        'led_max' : led_max.value()
    }
    
    
    data = {
        'Sensor' : temp_data,
        'Leds'   : leds_data
    }
    
    
    enviarFire(data)
    
    led_min.off()
    led_middle.off()
    led_max.off()
    time.sleep(30)



    

