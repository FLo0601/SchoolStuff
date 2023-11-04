from KeyValuePair import KeyValuePair

class Helper():
    def __init__(self, listKeyValue, cancellationToken):
        self.listKeyValue = listKeyValue
        self.cancellationToken = cancellationToken

    def navigation(self):
        while not self.cancellationToken:
            counter = 0
            while counter < len(self.listKeyValue):
                print(self.listKeyValue[counter].key)
                counter = counter + 1

            print("What do you want to do? ")
            nextRegion = self.getNumInput()
            if nextRegion is not None: self.listKeyValue[nextRegion - 1].value()

    def getNumInput(self):
        try:
            userInput = int(input())
            return userInput
        except:
            print("User input was incorrect. Please try again")

    def getYesNo(self) -> bool:
        print("Do you really want to exit? ")
        userInput = str(input())
        if userInput.lower() == 'y' or userInput.lower() == 'yes':
            return True
        elif userInput.lower() == 'n' or userInput.lower() == 'no':
            print("\n")
            return False
