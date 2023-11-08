subList1 = ["Ada Okonkwo", "Nuux Buol", "Dennis Mmemma", "Yousef Elegedi", "Kel Chong"]
subList2 = ["John-Mark Igbo", "Brone Don", "Brown Jonny", "James Freeman", "Fidelis Iceberg"]

print("printing the new list")
print(subList1)
print()
print(subList2)
print()

print("append a new name")
subList2.append("Kriti Brown")
print(subList2)
print()

print("remove second employee's name")
rm = subList1.pop(1)
print(rm)
print()

print("merged list")
subList1.extend(subList2)
print(subList1)
print()

salary_list = [1000, 500, 200, 400, 350, 220, 250, 760, 600, 540]

print("Salary list")
print(salary_list)
print()

rise = 0
for i in range(len(salary_list)):
    rise = salary_list[i] * (4 / 100)
    salary_list[i] += rise

print("Salary Raise")
print(salary_list)
print()

print("Sorted salary list")
salary_list.sort()
print(salary_list)
print()

print("Top 3 sorted salary list")
print(salary_list[:3])
print()

# sentence to word list
sent = input("Sentence please: ")
print()

word = sent.split()
print("string converted to list")
print(word)
print()

rev_word = word[::-1]
print("Reverse word list")
print(rev_word)
print()

sentence = " ".join(word)
print("back to string")
print(sentence)
print()

# "equivalent" but not "identical" 
eq = ["Happy", "day"]
iden = ["Happy", "day"]
check = eq is iden
print(check)
print()

# "equivalent" and "identical" 
eq = ["Happy", "day"]
iden = eq
check = eq is iden
print(check)
print()

def mod_list(d):
    d[1] = "Night"
    return ' '.join(d)

print(mod_list(iden))
print()
