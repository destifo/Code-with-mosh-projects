class Price:
    def __init__(self, price):
        self.price = price

    @property
    def price(self):
        return self.price

    @price.setter
    def price(self, price):
        if price < 0:
            raise ValueError("Price can't be negative")
        self.price = price

