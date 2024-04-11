
initialised = False

class Pseudo:
    def __init__(self):
        self.modulus = 2**32
        self.a = 1664525
        self.c = 1013904223
        self.seed = 1234567

    def next(self, limit):
        self.seed = (self.a * self.seed + self.c) % self.modulus
        return self.seed % limit

p = Pseudo()

def nextNumber():
    global initialised, p
    if (not initialised):
        number = input("Please enter your student number: ")
        p.seed = int(number)
        initialised = True
    return p.next(1000)

n = nextNumber()


#Creating a set for both the unique numbers and the duplicate numbers 
duplicate_numbers = set()
unique_numbers = set()

#A for loop which will iterate 100 times to find duplicates and unique numbers
for i in range(100):
    #This will generate a set of numbers
    num = nextNumber()
    #This if statement will check whether that number is present in unique_numbers set
    if num in unique_numbers:
        #It will append add that number to the duplicate numbers set
        duplicate_numbers.add(num)
    else:
        #Otherwise it will add to the unique numbers set
        unique_numbers.add(num)

#This will output the results of the number of unique and duplicate numbers
print(len(unique_numbers), "unique numbers:")
print(unique_numbers)
print(len(duplicate_numbers),"duplicates:")
print(duplicate_numbers)
