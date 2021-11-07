class Usuario:
    '''
    name = ''
    lName = ''
    uName = ''
    genero = ''
    fnacimiento = ''
    celectronico = ''
    contraseña = ''
    '''
    def __init__(self, name, lName, uName, genero, fnacimiento, celectronico, contraseña):
        self.name = name
        self.lName = lName
        self.uName = uName
        self.genero = genero
        self.fnacimiento = fnacimiento
        self.celectronico = celectronico
        self.contraseña = contraseña
        
    #METODOS GETTERS
    def getName(self):
        return self.name
    
    def getLName(self):
        return self.lName

    def getUName(self):
        return self.uName

    def getGenero(self):
        return self.genero

    def getFnacimiento(self):
        return self.fnacimiento

    def getCelectronico(self):
        return self.celectronico

    def getContraseña(self):
        return self.contraseña

    #METODOS SETTERS  
    def setName(self, name):
        self.name = name  

    def setLName(self,lName):
        self.lName = lName

    def setUName(self,uName):
        self.uName = uName

    def setGenero(self,genero):
        self.genero =genero

    def setFnacimiento(self, fnacimiento):
        self.fnacimiento =fnacimiento

    def setCelectronico(self,celectronico):
        self.celectronico = celectronico

    def setContraseña(self, contraseña):
        self.contraseña = contraseña