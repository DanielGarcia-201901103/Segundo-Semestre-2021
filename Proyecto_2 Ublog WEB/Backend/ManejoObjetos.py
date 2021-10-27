from flask import Flask, request
from ObImagen import Imagen
from ObUsuario import Usuario
from ObVideo import Video
#Lista de objetos
imagen = []  #urLI, dateI, categoryI
userslista = []  #Name, LName, UName, Genero, Fnacimiento, Celectronico, contraseña
vide = []  #  urLV, dateV, categoryV

#Variables administrador
adminName = 'William Corado'
adminUsername = 'admin'
adminEmail = 'admin@ipc1.com'
adminPassword = 'admin@ipc1'


app = Flask(__name__)
#Esta es la ruta principal del login
@app.route('/usuarioIniciar', methods = ['GET'])
def iniciarSesion(): #al presionar el boton de iniciar sesion debe de utilizar este metodo
    espacioNombreusuario = "aqui se guarda lo que se ingresa en pantalla del login"
    espaciopasswordUsuario = "aqui se guarda lo que se ingresa en pantalla del login"
    if adminUsername == espacioNombreusuario and adminPassword == espaciopasswordUsuario: #if para el admin
        #aqui debe ir el enlace para que pase a la vista del adminsitrador
        breakpoint
    #en este espacio buscará al usuario correspondiente 
  

#Esta es la ruta del registro de usuario    
@app.route('/usuarioRegistro', methods = ['POST'])
def registroUsers(): #al presionar el boton de resgistrarse debe de utilizar este metodo
    contenido = request.get_json()
    print(contenido)
    nombre= contenido['nombre']
    apellido = contenido['apellido']
    usuarioO = contenido['usuarioO']
    gener = contenido['gener']
    fenacimiento = contenido['fenacimiento']
    correo = contenido['correo']
    contrase = contenido['contrase']
    nuevLibro = Usuario()
    nuevLibro.name = str(nombre)
    nuevLibro.lName = str(apellido)
    nuevLibro.uName = str(usuarioO)
    nuevLibro.genero = str(gener)
    nuevLibro.fnacimiento = str(fenacimiento)
    nuevLibro.celectronico = str(correo)
    nuevLibro.contraseña = str(contrase)
    userslista.append(nuevLibro)
    return {"message": "ok"}


#Esta es la ruta del administrador    
@app.route('/admin')
def adminis():
    return 'aqui va un metodo'

#Esta es la ruta de la vista del post usuarios    
@app.route('/vistaPost')
def vispost():
    return 'aqui va un metodo'

if __name__ == '__main__':
    app.run(debug=True)