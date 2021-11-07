from flask import Flask, request, jsonify
from flask import render_template
from flask_restful import Api
from flask_cors import CORS, cross_origin
'''
from flask_restful import Api
from flask_cors import CORS, cross_origin
CORS(app)
api = Api(app)
'''
from ObImagen import Imagen
from ObUsuario import Usuario
from ObVideo import Video

app = Flask(__name__)
CORS(app)
api = Api(app)

# Lista de objetos
imagen = []  # urLI, dateI, categoryI
userslista = []  # Name, LName, UName, Genero, Fnacimiento, Celectronico, contraseña
vide = []  # urLV, dateV, categoryV


# Variables administrador
adminName = 'William Corado'
adminUsername = 'admin'
adminEmail = 'admin@ipc1.com'
adminPassword = 'admin@ipc1'

userslista.append(Usuario('a', "b", 'c', "d","e", 'e@ipc1.com', 'f@ipc1'))

@app.route('/usuario', methods=['GET'])
def getUsuario(): 
    content = request.get_json()
    nombreUsuar = content['nombreUsuar']
    contrase = content['contraseñUsuar']
    global userslista
    for usuari in userslista:
        if usuari.getUName() == nombreUsuar and  usuari.getContraseña()== contrase :
            ob = {
                "nombre":  usuari.getName(),
                "apellido": usuari.getLName(),
                "usuario": usuari.getUName(),
                "genero": usuari.getGenero(),
                "fnacimiento": usuari.getFnacimiento(),
                "correo": usuari.getCelectronico(),
                "contraseña": usuari.getContraseña()
            }
            return(jsonify(ob))
        elif  nombreUsuar=='admin' and contrase=='admin@ipc1':
            return "estas en admin"
    mensaje = { "Mensaje": "El usuario no existe"}
    return(jsonify(mensaje))

@app.route('/usuario', methods=['PUT'])
def actualizarUsuario():
    content = request.get_json()
    nombreUsuar = content['nombreUsuar']
    contrase = content['contraseñUsuar']
    global userslista
    for i in range (len(userslista)):
        if nombreUsuar == userslista[i].getUName():
            userslista[i].setUName(request.json['usuario'])
            userslista[i].setName(request.json['nombre'])
            userslista[i].setLName(request.json['apellido'])
            userslista[i].setFnacimiento(request.json['fnacimiento'])
            userslista[i].setContraseña(request.json['contraseña'])
            return jsonify({"mensaje": "se actualizo correctamente"})

    return jsonify({"mensaje": "no se encontro para actualizar"})

@app.route('/usuario', methods=['POST'])
def AgregarUsuario(): #agrega usuario a la lista
    content = request.get_json()
    global userslista
    uName = content['usuarioO']
    name = content['nombre']
    lName = content['apellido']
    genero = content['gener']
    fnacimiento = content['fenacimiento']
    celectronico = content['correo']
    contraseña = content['contrase']
    nuev = Usuario(name,lName,uName,genero,fnacimiento,celectronico,contraseña)
    userslista.append(nuev)
    jsonify({" mensaje": "se agrego correctamente"})
    return content

@app.route('/usuario', methods = ['DELETE'])
def EliminarUsuario():
    content = request.get_json()
    nombreUsuar = content['nombreUsuar']
    contrase = content['contraseñUsuar']
    global userslista
    for i in range(len(userslista)):
        if nombreUsuar == userslista[i].getUName():
            del userslista[i]
            return jsonify({"mensaje": "se eliminpo correctante" + str(nombreUsuar)})
    return jsonify({"mensaje": "no se encontró el usuario"})

# Esta es la ruta del administrador
@app.route('/admin')
def adminis():
    return jsonify({"nombre": "admin"})

# Esta es la ruta de la vista del post usuarios


@app.route('/vistaPost')
def vispost():
    return 'aqui va un metodo'


if __name__ == '__main__':
    app.run(host = "localhost",debug=True, port=5000)
