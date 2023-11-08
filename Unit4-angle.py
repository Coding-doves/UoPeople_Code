
import math
# calulating the hypotenuse of a right triangle giving the lenght of 2 legs/sides
# using incremental development
# Hypotensuse = (a**2) + (b**2) = sqrt(c)
def hypotenuse(leg1, leg2):
    side1 = leg1 ** 2
    side2 = leg2 ** 2
    hypo = math.sqrt((side1 + side2))

    return hypo

print()
print('First argument: ', hypotenuse(3, 4)) # (3^2) + (4^2) = sqrt(13)
print()
print('Second argument: ', hypotenuse(2, 3)) # (2^2) + (3^2) = sqrt(13)
print()
print('Third argument: ', hypotenuse(6, 2)) # (6^2) + (2^2) = sqrt(13)
print()

# get per item cost
def unit(quantity, buck_price, percent):
    cost_price = (buck_price / quantity) 
    profit = cost_price * (percent / 100)
    unit_price = cost_price + profit

    return unit_price

# get buck profit
def buck(buck_price,percent):
    return buck_price * (percent / 100)

# main function / starting point
def goods():
    package = input('Enter the name of item: ')
    quantity = int(input('Number of item: '))
    buck_price = int(input('Purchased price: '))
    percentage = int(input("Profit percentage(don't add '%' or /): "))
    

    single = unit(quantity, buck_price, percentage)
    whole = buck(buck_price, percentage)

    print('<===============================>')
    print('One ' + package + ' costs $' + str(single) + ' at the rate of ' + str(percentage) + '%')
    print('All ' + package + ' profit will be $' + str(whole)  + ' at the rate of ' + str(percentage) + '%')
    print()
    
goods()


# Enter a luck number and win $10
def Lucky_number(x): 
    if not isinstance(x, int) or x < 0:
        return('Nahhhhhh!!! I need positive number')
    
    if x == 41479: # Here is a postcondition / the lukcky number
        return 'Congratulation!!! You have won $10'

    return 'Nice Try :('

    
# starting point
def get_luck():
    num = int(input('Lucky number: '))
    result = Lucky_number(num)

    print(result)

    if num < 41479 and result == 'Congratulation!!! You have won $10':
        print('<=================================>')
        print('Ooop! I must have mis-matched the return function. Pls review the code')
    if num > 41479 and result == 'Congratulation!!! You have won $10':
        print('<=================================>')
        print('Ooop! I must have mis-matched the return function. Pls review the code')


get_luck()    
print()
