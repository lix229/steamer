# -*- coding:utf-8 -*-
import json
import csv
import ast
import re

def process_csv(input_csv):
    data = []
    with open(input_csv,"r") as csvfile:
        reader = csv.reader(csvfile)
        rows = [row for row in reader]
    print(rows)#输出所有数据
    for name in rows:
        temp = name[1]
        pattern = re.compile('\W')
        temp = re.sub(pattern, '', temp)
        temp = temp.upper()
        if not temp in data:
            print(temp)
            data.append(temp)
    print(data)

    return data
    #data=np.array(rows)#rows是数据类型是‘list',转化为数组类型好处理
    # print("out0=",type(data),data.shape)
    # print("out1=",data)


def process_json(input_json_file, output_json_file):
    data = process_csv("steam-200k.csv")
    file_in = open(input_json_file, "r")
    file_out = open(output_json_file, "w")
    # load数据到变量json_data
    json_data = json.load(file_in)
    print(json_data)
    print("after update  --->")
    print(type(json_data))
    #修改json中的数据
    json_data_new = {}
    for i in json_data:
        temp = json_data[i].get("name")
        pattern = re.compile('\W')
        temp = re.sub(pattern, '', temp)
        temp = temp.upper()
        if temp in data:
            print(temp)
            json_data_new[i] = json_data[i]
    print(json_data_new)

    # 将修改后的数据写回文件
    file_out.write(json.dumps(json_data_new))
    file_in.close()
    file_out.close()


process_json("api.json","apiout.json")
#process_csv("steam-200k.csv")
