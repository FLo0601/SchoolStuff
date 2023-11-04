from Helper import Helper
from KeyValuePair import KeyValuePair


class CRUDWindow:
    def __init__(self, helper: Helper, filename: str):
        self.helper = helper
        self.filename = filename
        createMenu = KeyValuePair("1. Add new password", self.createPW)
        readMenu = KeyValuePair("2. Read all passwords", self.readDB)
        updateMenu = KeyValuePair("3. Update one entry", self.updateDB)
        self.helper.listKeyValue = [createMenu, readMenu, updateMenu]

    def createPW(self):
        f = open(self.filename, "a")
        print("Please input the password you want to add: ")
        newPW = str(input())
        f.write(newPW)
        f.close()

    def readDB(self):
        f = open(self.filename, "r")
        print(f.read())
        f.close()
    
    def updateDB(self):
        print("Which password: ")
        pwToUpdate = input()
        f = open(self.filename, "r")
        fileContent = f.readlines()
        f.close()

        
        
        f = open(self.filename, "w")
        f.writelines(fileContent)

    def findLine(self, lineToFind, listToQuery):
        index = 0
        while index < len(list):
            if listToQuery[index] == lineToFind:
                return index
            index = index + 1
        
