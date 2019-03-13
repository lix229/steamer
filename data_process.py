import xlrd
import csv


def read():
    loc = ("abc.csv")
    ID = []
    GameList = []
    TimeList = []
    Relative = []
    wb = xlrd.open_workbook(loc)
    sheet = wb.sheet_by_index(0)
    total = 0
    cnt = 0
    ID.append(sheet.cell_value(0, 0))
 
    with open('test.csv', 'a', newline='') as csvFile:
        writer = csv.writer(csvFile)
        for i in range(sheet.nrows):
            i += 1
            GameList.append(sheet.cell_value(i, 1))
            TimeList.append(sheet.cell_value(i, 3))
            total += float(sheet.cell_value(i, 3))
            
            if(i < sheet.nrows-1):
                if(ID[cnt] != sheet.cell_value(i+1, 0)):
                    row = []
                    for i in TimeList:
                        Relative.append(i/total)
                    for i in range(len(GameList)):
                        row.append(ID[cnt])
                        row.append(GameList[i])
                        row.append(TimeList[i])
                        row.append(Relative[i])
                        writer.writerow(row)
                    GameList = []
                    TimeList = []
                    ID.append(sheet.cell_value(i+1, 0))
                    cnt += 1

    csvFile.close()


read()
