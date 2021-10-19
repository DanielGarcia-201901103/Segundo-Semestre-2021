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
@app.route('/admin')
def vispost():
    return 'aqui va un metodo'



# METODOS PARA EL LOGIN  
  # -------Ingreso de nombre de usuario y contraseña  
           # validaciones para buscar el usuario y si no se encuentra debe de decir que no existe y pedir crear nuevo usuario en la url correspondiente pero si, existe y no se escribio bien debe de decir que hay credenciales incorrectas
           # si es el administrador dirigir a nueva url
def iniciarSesion():
    pass

    

if __name__ == '__main__':
    app.run(debug=True)