from flask import Flask, render_template, request, flash, redirect, url_for, jsonify
from app.Scraper import start

app = Flask(__name__)
app.secret_key = 'dopamin'


@app.route('/')
def my_form():
    return render_template("index.html")


@app.route('/api/<question>', methods=['GET', 'POST'])
def home(question):
    if request.method == 'POST':
        question_api = start(question)

        return jsonify(question_api)


if __name__ == "__main__":
    app.run(host='0.0.0.0')

