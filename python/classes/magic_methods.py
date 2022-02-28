class Point:
    #magic methods
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)

    def __str__(self):
        return f"({self.x}, {self.y})"

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y

    def __gt__(self, other):
        return self.x > other.x and self.y > other.y


    def draw(self):
        print(f"({self.x}, {self.y})")

    #class methods
    @classmethod
    def zero(cls):
        return cls(0, 0)




point = Point.zero()
pnt = Point(1, 3)
#point.draw()
print(point + pnt)
print(point > pnt)