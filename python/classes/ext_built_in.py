class Text(str):
    def duplicate(self):
        return self + self


class TrackableList(list):
    def append(self, elt):
        print("Append called")
        super().append(elt)