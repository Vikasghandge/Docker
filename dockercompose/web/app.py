echo "from flask import Flask\napp = Flask(__name__)\n@app.route('/')\ndef home():\n    return 'Hello from the web service!'\nif __name__ == '__main__':\n    app.run(host='0.0.0.0')" > web/app.py
