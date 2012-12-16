import time
from rrBrowser import RenrenBrowser
from rrParser import RenrenParser
from rrDB import RenrenDb


rrID = input("Your Renren ID (e.g.239486743): ")
rrUser = input("Your Renren Login Email: ")
rrPassword = input("Your Renren Password: ")

db = RenrenDb()
parser = RenrenParser()
browser = RenrenBrowser(user=rrUser, passwd=rrPassword)
browser.setLogLevel(40)
browser.login()

#net1
browser.friendPage(rrID)
parser.friends()

#net2
flist = db.getRenrenId(2, rrID)
for item in flist:
    loopStart=time.time()
    browser.friendPage(item)
    loopEnd=time.time()
    if (loopEnd-loopStart<10):
        print('loop time={},parsering to kill time'.format(loopEnd-loopStart))
        parser.friends()
        kill=time.time()
        print('time cost ={}'.format(kill-loopEnd))
parser.friends()
