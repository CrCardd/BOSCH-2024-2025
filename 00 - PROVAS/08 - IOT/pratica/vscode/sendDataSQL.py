import pyodbc
import time
import json
import requests


#GET INTERNET
proxies = {'https' : "http://disrct:etsps2024401@10.224.200.26:8080"}
user = 'Cristian'
url = 'https://iiot-7276b-default-rtdb.firebaseio.com/' + user + '.json'


def insertBD(signal):
    server = 'CA-C-00652\\SQLEXPRESS'
    database = 'aulaIOT (cr)'
    cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER='+server+';DATABASE='+database+';Trusted_Connection=yes')
    cursor = cnxn.cursor()
    cursor.execute(f"INSERT temp_hum_data (Temperature, Humidity, led_min, led_middle, led_max) VALUES ({signal[0]},{signal[1]},{signal[2]},{signal[3]},{signal[4]})")
    cursor.commit()
    print("Sucess!")









#-------------------MAIN----------------------------#
data_json = requests.get(url,proxies=proxies).content

data = [json.loads(data_json)['Sensor']['Temperature'],json.loads(data_json)['Sensor']['Humidity'],json.loads(data_json)['Leds']['led_min'],json.loads(data_json)['Leds']['led_middle'],json.loads(data_json)['Leds']['led_max']]

insertBD(data)

print(data)


