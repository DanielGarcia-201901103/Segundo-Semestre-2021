from flask import Flask, render_template
from ObImagen import Imagen
from ObUsuario import Usuario
from ObVideo import Video

#Lista de objetos
imagen = []  #urLI, dateI, categoryI
users = []  #Name, LName, UName, Genero, Fnacimiento, Celectronico, contraseña
vide = []  #  urLV, dateV, categoryV

#Variables administrador
adminName = 'William Corado'
adminUsername = 'admin'
adminEmail = 'admin@ipc1.com'
adminPassword = 'admin@ipc1'


app = Flask(__name__)
#Esta es la ruta principal del login
@app.route('/')
def login():
    return render_template('Login.html')

#Esta es la ruta del registro de usuario    
@app.route('/registro')
def registr():
    return 'dasdsfasdf'

#Esta es la ruta del administrador    
@app.route('/admin')
def adminis():
    return 'aqui va un metodo'

#Esta es la ruta de la vista del post usuarios    
@app.route('/vistaPost')
def vispost():
    return 'aqui va un metodo'



# METODOS PARA EL LOGIN  
  # -------Ingreso de nombre de usuario y contraseña  
           # validaciones para buscar el usuario y si no se encuentra debe de decir que no existe y pedir crear nuevo usuario en la url correspondiente pero si, existe y no se escribio bien debe de decir que hay credenciales incorrectas
           # si es el administrador dirigir a nueva url
def iniciarSesion(): #al presionar el boton de iniciar sesion debe de utilizar este metodo
    espacioNombreusuario = "aqui se guarda lo que se ingresa en pantalla del login"
    espaciopasswordUsuario = "aqui se guarda lo que se ingresa en pantalla del login"
    if adminUsername == espacioNombreusuario and adminPassword == espaciopasswordUsuario: #if para el admin
        #aqui debe ir el enlace para que pase a la vista del adminsitrador
        breakpoint
    #en este espacio buscará al usuario correspondiente 
    


def registroUsers(): #al presionar el boton de resgistrarse debe de utilizar este metodo
    nombre= "aqui recibe el nombre que ingresa el usuario"
    apellido = "aqui recibe el aprellido del usuario"
    usuarioO = "aqui recibe el nombre de usuario del usuario"
    gener = "aqui recibe el genero del usuario"
    fenacimiento = "aqui recibe la fecha de nacimiento del usuario"
    correo = "aqui recibe el correo del usuario"
    users.append(Usuario(nombre,apellido,usuarioO,gener,fenacimiento,correo))
    #for u in users:
        
    
if __name__ == '__main__':
    app.run(debug=True)