class Video:
    '''
    urlV = ''
    dateV = ''
    categoryV = ''
    '''
    def __init__(self, urLV, dateV, categoryV):
        self.urlV = urLV
        self.dateV = dateV
        self.categoryV = categoryV
     #METODOS GETTERS
    def getUrlv(self):
        return self.urlV

    def getDatev(self):
        return self.dateV

    def getCategoryv(self):
        return self.categoryV
    #METODOS SETTERS
    def setUrlv(self, urlV):
        self.urlV = urlV
    
    def setDatev(self, dateV):
        self.dateV = dateV

    def setCategoryv(self, categoryV):
        self.categoryV = categoryV