class Usuario:
    Name = ''
    LName = ''
    UName = ''
    Genero = ''
    Fnacimiento = ''
    Celectronico = ''
    contraseña = ''

    def __init__(self, Name, LName, UName, Genero, Fnacimiento, Celectronico, contraseña):
        self.Name = Name
        self.LName = LName
        self.UName = UName
        self.Genero = Genero
        self.Fnacimiento = Fnacimiento
        self.Celectronico = Celectronico
        self.contraseña = contraseña
