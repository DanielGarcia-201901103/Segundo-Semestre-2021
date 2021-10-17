from flask import Flask, render_template

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

if __name__ == '__main__':
    app.run(debug=True)