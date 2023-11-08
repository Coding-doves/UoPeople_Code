def do_n(func, n): #print function object n times
    for i in range(n):
        func()

def Helo():
    print('welcome')

do_n(Helo, 4)    
print()

#countup
def countup(n):
    if n >= 0:
        print('Blastoff!')
    else:
        print(n)
        countup(n+1)

print('countup Negative number')
countup(-3)
print()
print('countup Zero')
countup(0)
print()
print('countup postive number')
countup(3)
print()

#countdown
def countdown(n):
    if n <= 0:
        print('Blastoff!')
    else:
        print(n)
        countdown(n-1)

num = int(input('Enter a number: \n'))
countdown(num)
print()

#division; error handled
def divide():
    num1 = int(input('Enter first number: \n'))
    num2 = int(input('Enter second number: \n'))

    if (num2 == 0):
        print('Dividing by 0 not acceptable')
    else:
        print(num1 / num2)

divide()

#if/else Nested Conditional
age = int(input('Enter Your age: \n'))

if age > 17:
    card = input('Do you hae a voting card (Y/N): \n')
    if (card == 'Y'):
        print("Voting access granted")
    elif (card == 'N'):
        print("Access denied")
else:
    print("Wait till adulthood")

#if/else Chain conditional
age = int(input('Enter Your age: \n'))

if age > 17 and card == 'Y':
    card = input('Do you hae a voting card (Y/N): \n')
    print("Voting access granted")
elif age > 17 and card == 'N':
    card = input('Do you hae a voting card (Y/N): \n')
    print("Access denied")
else:
    print("Wait till adulthood")
