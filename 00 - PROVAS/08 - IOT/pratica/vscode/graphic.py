# -*- coding: utf-8 -*-
"""
Created on Wed Jun 19 08:41:22 2024

@author: liq1ct
"""

import pyodbc
import time
import requests
import json
import matplotlib.pyplot as plt
import pandas as pd

def InserirBD(sinal):
        server = 'CA-C-00652\\SQLEXPRESS'
        database = 'aulaIOT (cr)'
        cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER='+server+';DATABASE='+database+';Trusted_Connection=yes')
        cursor = cnxn.cursor()
        cursor.execute(f"INSERT Sensor (Temperatura, Umidade) VALUES ({sinal[0]},{sinal[1]})")
        cursor.commit()
        print("Inserido com sucesso!")


def apresentar(sinal):
        print(f"Temperatura: {sinal[0]}")
        print(f"Umidade: {sinal[1]}")
        
        
def SelectBD():
        server = 'CA-C-00652\\SQLEXPRESS'
        database = 'aulaIOT (cr)'
        cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER='+server+';DATABASE='+database+';Trusted_Connection=yes')
        cursor = cnxn.cursor()
        cursor.execute(f"Select ID, Temperature, Humidity FROM temp_hum_data")
        
        return cursor.fetchall()


def create_df():
    ids = []
    temp=[]
    umi=[]
    for i in SelectBD():
        ids.append(i[0])
        temp.append(i[1])
        umi.append(i[2]) 
    df = pd.DataFrame({"id":ids, "temperatura": temp, "Umidade": umi})
    return df
       
        
df = create_df()


print(len(df))
        
plt.title("Temperatura X IDS")
plt.plot(df.id, df.Umidade, marker = 0, label = 'Umidade')
plt.plot(df.id, df.temperatura, marker = 0, label = "temperatura")
plt.ylabel("Temperatura")
plt.legend()
plt.show()


# proxies = {'https': "http://disrct:etsps2024401@10.224.200.26:8080"}
# nome = input("Digite o seu nome: ")
# url = "https://iiot-7276b-default-rtdb.firebaseio.com/" + nome + ".json"
# while True:
    
#     data_json = requests.get(url, proxies=proxies).content

#     with open('temp_and_hum.json', 'wb') as data: 
#             data.write(data_json)

#     temperatura = json.loads(data_json)['Temperatura']
#     humidade = json.loads(data_json)['Humidade']

#     valores = (temperatura,humidade)
#     InserirBD(valores)
#     apresentar(valores)
#     time.sleep(5)


