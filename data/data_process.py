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
    appender(user_relative_time)


def appender(user_relative_time):
    # Append items to lines.
    i = 0
    with open('modified_user_info', 'r') as istr:
        with open('output.csv', 'w') as ostr:
            i = 0
            for line in istr:
                line = line.rstrip('\n') + ',' + str(user_relative_time[i])
                i += 1
                # Replace sample message with items to append.
                print(line, file=ostr)

user_generate("modified_user_info")
