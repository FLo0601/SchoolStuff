import os
from CRUDWindow import CRUDWindow
from Helper import Helper
from KeyValuePair import KeyValuePair

class MainWindow:
    def __init__(self, helper: Helper):
        self.helper = helper
        createMenu = KeyValuePair("1. Create new file", self.createNew)
        openMenu = KeyValuePair("2. Open existing file", self.openExisiting)
        exitMenu = KeyValuePair("3. Exit", self.exitWindow)
        self.helper.listKeyValue = [createMenu, openMenu, exitMenu]

    def createNew(self):
        print("Give the file you want to create a name: ")
        fileName = str(input())

        try:
            f= open(fileName, "x")
            f.close()
        except:
            print("The file already exists")
    
    def openExisiting(self):
        print("Give the name of the file you want to open")
        fileName = str(input())

        if os.path.exists(fileName):
            crudWindow = CRUDWindow(self.helper, fileName)
            crudWindow.helper.navigation()
        else:
            print("The File doesnt exist yet.")

    def exitWindow(self):
        print("Do you really want to exit? (Y)es (N)o")
        self.helper.cancellationToken = self.helper.getYesNo()
        