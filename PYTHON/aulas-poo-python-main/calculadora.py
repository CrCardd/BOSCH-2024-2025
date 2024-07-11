import math

class Calculator:
    @staticmethod
    def Sum(numberA, numberB):
        return numberA + numberB
    @staticmethod
    def Sub(numberA, numberB):
        return numberA + numberB
    @staticmethod
    def Div(numberA, numberB):
        return numberA + numberB
    @staticmethod
    def Mult(numberA, numberB):
        return numberA + numberB

class CientificCalculator(Calculator):
    def Pi(self):
        return 3.14159265
    def Exp(self, number, exponential):
        return number ** exponential
    def Sqrt(self, number):
        return int(math.sqrt(number))
    def Mod(self, numberA, numberB):
        return int(numberA % numberB)
    def Abs(self, number):
        if(number < 0):
            return int(number - (number*2))
        return number
    def Sqr(self, number):
        return number ** 2



c  = CientificCalculator()
print(Calculator.Mult(2,2))