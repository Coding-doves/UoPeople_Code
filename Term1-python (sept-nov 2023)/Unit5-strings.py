def display_name():
    n = input('Entering my name: ')
    name = ''
    # Reverse name
    j = len(n) - 1

    for i in range(len(n)):
        name += n[j]
        j -= 1

    print(name)

display_name()

# disscusion forum

low = "lettER"
low1 = "Letter"
# 1

def any_lowercase1(s):
    for c in s:
        if c.islower():
            return True
        else:
            return False

print(any_lowercase1(low))
print(any_lowercase1(low1))

print()


# 2

def any_lowercase2(s):
    for c in s:
        if 'c'.islower():
            return 'True'
        else:
            return 'False'

print(any_lowercase2(low))
print(any_lowercase2(low1))

print()

# 3

def any_lowercase3(s):
    for c in s:
        flag = c.islower()
    return flag

print(any_lowercase3(low))
print(any_lowercase3(low1))

print()

# 4

def any_lowercase4(s):
    flag = False
    for c in s:
        flag = flag or c.islower()
    return flag

print(any_lowercase4(low))
print(any_lowercase4('mummY'))

print()

# 5

def any_lowercase5(s):
     for c in s:
          if not c.islower():
               return False
     return True

print(any_lowercase5(low))
print(any_lowercase5(low1))
