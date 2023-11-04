from Helper import Helper
from MainWindow import MainWindow

cancellationToken = False
helper = Helper([], cancellationToken)
main = MainWindow(helper)
main.helper.navigation()