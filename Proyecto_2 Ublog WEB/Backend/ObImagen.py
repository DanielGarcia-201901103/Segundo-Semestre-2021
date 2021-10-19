class Imagen:
    '''
    urLI = ''
    dateI = ''
    categoryI = ''
    '''
    def __init__(self, urLI, dateI, categoryI):
        self.urlI = urLI
        self.dateI = dateI
        self.categoryI = categoryI
    #METODOS GETTERS
    def getUrli(self):
        return self.urlI

    def getDatei(self):
        return self.dateI

    def getCategoryi(self):
        return self.categoryI
    #METODOS SETTERS
    def setUrli(self, urlI):
        self.urlI = urlI
    
    def setDatei(self, dateI):
        self.dateI = dateI

    def setCategoryi(self, categoryI):
        self.categoryI = categoryI

    