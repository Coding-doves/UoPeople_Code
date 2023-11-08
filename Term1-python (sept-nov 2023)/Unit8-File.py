# ================= prog Assin++++++++
'''
    from a file, read the text and convert it to a dictionary
'''
def read_file(f):
    text = dict()
   
    with open(f, 'r') as file:
        for i in file:
            i = i.strip()
            if '{' not in i and '}' not in i and i != '':
                try:
                    k, v = i.split(':')
                    if ',' in v:
                        # if there are more than one values
                        v = [lis for lis in v.split(',')]
                    text[k] = v

                    
                except ValueError:
                    print('Could not split text')
    return text


'''
    pass dictionary to be inverted
'''
def inverted_dict(dictionary):
    inverted_key = dict()

    for k, v in dictionary.items():
        if isinstance(v, list):
            # if key has multiple values (list)
            for i in v:
                if i not in inverted_key:
                    inverted_key[i] = [k]
                else:
                    inverted_key[i].append(k)
        else:
            # if key has one value
            if v not in inverted_key:
                inverted_key[v] = [k]
            else:
                inverted_key[v].append(k)

    # print output line by line inside new file
    inverted_key = print_dict(inverted_key)

    return inverted_key


'''
    pass invert dictionary to a new file
    string representation of dictionary 
'''
def new_file(f, details):
    try:
        with open(f, 'w') as file:
            file.write(str(details))
            print(f'\nSuccessful - Open {f} to veiw\n')

    except Exception as e:
        print('Error: {}'.format(e))


''' print output line by line in new file '''
def print_dict(inverted):
    str_dic = '{\n'
    for i, (course, stud) in enumerate(inverted.items()):
        str_dic += f'{course}: {stud}' + ('\n' if i == len(inverted) - 1 else ',\n\n')
        
    str_dic += '}'
    return str_dic


r_file = read_file('Unit8-dictFile')
in_dict = inverted_dict(r_file)
new_file('Unit8-output', in_dict)
