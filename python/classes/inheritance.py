class Animal:
    def __init__(self):
        print("Animal Constructor")
        self.age = 7

    def eat(self):
        print("eat")

class Mammal(Animal):
    def __init__(self):
        super().__init__()
        print("Mammal Constructor")
        self.weight = 30

    def move(self):
        print("walk")

    def breast_feed(self):
        print("milk")

class Bird(Animal):
    def __init__(self):
        self.wings = 2

    @classmethod
    def fly(self):
        print("fly")

#Multiple inheritance
class Bat(Mammal, Bird):
    pass

class Fish:
    def swim(self):
        print("swim")

o = Mammal()
print(isinstance(o, object))
print(issubclass(Fish, object))
print(issubclass(Bat, Animal)) #Multi level Inheritance
Bat.fly()