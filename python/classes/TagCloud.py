class TagCloud:
    def __init__(self):
        self.__tags =  dict()
    
    def add(self, tag):
        #if (tag in self.tags.keys()):
        #    self.tags[tag] += 1
        #    return
        #self.tags[tag] = 1
        

        self.__tags[tag.lower()] = self.__tags.get(tag.lower(), 0) + 1

    def __getitem__(self, item):
        if (item.lower() not in self.__tags.keys()):
            print(f"Key word {item} not found ")
            return
        print(self.__tags[item.lower()])

    def __setitem__(self, key, value):
        self.__tags[key.lower()] = value

    def __len__(self):
        return len(self.__tags)

    def __iter__(self):
        return iter(self.__tags)


cloud = TagCloud()
cloud.add('python')
cloud.add('python')
cloud.add('Python')
cloud['Python']
cloud["java"]
cloud["java"] = 70
cloud["java"]
print(len(cloud))
print(cloud._TagCloud__tags)

