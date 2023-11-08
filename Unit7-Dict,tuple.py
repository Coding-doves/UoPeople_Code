
#========================dis forum =======
# 1. Tuples with `zip` Function:

# Lists
food_stuff = ['tomatoes', 'beans', 'yam']
prices = [2.0, 9.8, 10.5]

# using loop on zip to iterate over both lists simultaneously
print('Tuples->zip - list1 and list2')
for item, price in zip(food_stuff, prices):
    print(f"The price of {item} is ${price}")
print()

# 2. Tuples with `enumerate` Function:

# List
names = ['Ada', 'Nuux', 'Ebere']

# Looping through enumerate to get both index and value
print('Enumerate - indies and values')
for i, name in enumerate(names):
    print(f"Index {i} - {name}\n")

# 3. Tuples with Dictionary's `items` Method:

# Dictionary
bio = {'name': 'Ada', 'age': 125, 'city': 'Lagos'}

# Loop using items to iterate over key-value pairs
print("Tuples->items - key-value pair")
for key, value in bio.items():
    print(f"{key.capitalize()}: {value}\n")

# 4. Combination: Tuples with List, Dictionary, Items and Zip
identity_number = ('F02', 'F06', 'F10')
family_grouping = [('Mr Nuux Bouh', 'Mrs Nuux Bouh', 'Son Bouh'),
                    ('Mr Ebere Okonkwo', 'Mrs Ebere Okonkwo', 'Astra Ebere', 'John Ebere'),
                    ('Mr Nuux Bouh', 'Mrs Ada Bouh', 'Star Bouh')]

print("Zip, Looping, Tuples")
for i, f in zip(identity_number, family_grouping):
    print(f'{i}:')
    for j in f:
        print(f'\t{j}')
print()

print("Dictionary")
d = dict(zip(identity_number, family_grouping))
print(f'{d}\n')

print("Dictionary, Items, Tuples - Output same as Zip...")
for key, value in d.items():
    print(f'{key}:')
    for j in value:
        print(f'\t{j}')
print()

#======================== Assignment =======
'''Invented dictionary - input = dict()'''
stud_cour = {
    'Stud1': ['CS1101', 'CS2402', 'CS2001'],
    'Stud2': ['CS2402', 'CS2001', 'CS1102']
}

def inverted(stud_courses):
    ''' iterate through the dict '''
    inverted_dict = dict()

    for stud, courses in stud_courses.items():
        # iterate through the courses
        for course_output in courses:
            # if course is not in the newly created dict; add it & make student its value
            if course_output not in inverted_dict:
                inverted_dict[course_output] = [stud]
            else:
                # if course is present, join student to its list
                inverted_dict[course_output].append(stud)

    print_dict(inverted_dict)

def print_dict(inverted):
    print('{\n')
    for i, (course, stud) in enumerate(inverted.items()):
        print('{}: {}'.format(course, stud), end='' if i == len(inverted) - 1 else ',\n')
        
    print('\n\n}')


print('Sample input')
print_dict(stud_cour)
print('\nInverted Output')
inverted(stud_cour)
