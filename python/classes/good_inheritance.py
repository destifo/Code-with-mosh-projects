from abc import ABC, abstractmethod

class InvalidOperationError(Exception):
    pass


class Stream(ABC):
    def __init__(self):
        self.__opened = False

    def open(self):
        if self.__opened:
            raise InvalidOperationError("Stream is already open")
        self.__opened = True

    def close(self):
        if not self.__opened:
            raise InvalidOperationError("Stream is already closed")
        self.__opened = False

    @abstractmethod
    def read(self):
        pass


class FileStream(Stream):
    def read(self):
        print(" Reading from a file ")


class NetworkStream(Stream):
    def read(self):
        print(" Reading from a Network ")


stream = Stream()
# Good Inheritance example 