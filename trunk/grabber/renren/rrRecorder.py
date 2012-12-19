import pickle


class RenrenRecorder:
    
    def load(self, path):
        self.relationPath = path+'/relation.p'
        self.profilePath = path+'/profile.p'
        try:
            self.relation = pickle.load(open(self.relationPath, 'rb'))
        except FileNotFoundError:
            self.relation = {}
        try:
            self.profile = pickle.load(open(self.profilePath, 'rb'))
        except FileNotFoundError:
            self.profile = {}
    
    def __init__(self, path):
        self.load(path)
    
    def save(self):
        pickle.dump(self.relation, open(self.relationPath, 'wb'))
        pickle.dump(self.profile, open(self.profilePath, 'wb'))
    
    def __del__(self):
        self.save()
    
    def addRelation(self, renrenId, friendList):
        if renrenId in self.relation:
            self.relation[renrenId] = self.relation[renrenId] | friendList
        else:
            self.relation[renrenId] = friendList
    
    def addProfile(self, profileList):
        self.profile.update(profileList)
    
    def getFriends(self, renrenId):
        if renrenId in self.relation:
            return self.relation[renrenId]
        else:
            return {}
        