def appender():
    # Append items to lines.
    with open('steam-200k.csv', 'r') as istr:
        with open('output.txt', 'w') as ostr:
            for line in istr:
                line = line.rstrip('\n') + 'sample message'
                # Replace sample message with items to append.
                print(line, file=ostr)
