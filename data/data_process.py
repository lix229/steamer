import csv

# def user_generate(filename):
#     user_relative_time = []
#     with open(filename, 'r') as original_file:
#         user_old = ''
#         for lines in original_file:
#             lines_list = lines.rsplit(',')
#             if lines_list[0] != user_old:
#                 if user_old != '':
#                     for i in user_absolute_time:
#                         user_relative_time.append(i/user_total_time)
#                 user_old = lines_list[0]
#                 user_total_time = 0
#                 user_absolute_time = []
#             user_total_time += float(lines_list[3])
#             user_absolute_time.append(float(lines_list[3]))
#         for i in user_absolute_time:
#             user_relative_time.append(i/user_total_time)
#         # Adding the last user
#     print(user_relative_time)
    
def user_generate(filename):
    user_relative_time = []
    with open (filename, 'r') as csvFile:
        csvList = csv.reader(csvFile, delimiter = ',')
        user_old = ''
        for rows in csvList:
            if rows[0] != user_old:
                if user_old != '':
                    for i in user_absolute_time:
                        user_relative_time.append(i/user_total_time)
                user_old = rows[0]
                user_total_time = 0
                user_absolute_time = []
            user_total_time += float(rows[3])
            user_absolute_time.append(float(rows[3]))
        for i in user_absolute_time:
            user_relative_time.append(i/user_total_time)
            



def appender(user_relative_time, filename):
    # Append items to lines.
    i = 0
    with open('steam-200k.csv', 'r') as istr:
        with open('output.txt', 'w') as ostr:
            for line in istr:
                line = line.rstrip('\n') + ',' + str(user_relative_time[i])
                # Replace sample message with items to append.
                print(line, file=ostr)

user_generate("modified_user_info")
