import sys

#from flask import Flask
#app = Flask(__name__)

#@app.route("/")
#def hello():
#    print("HELLO")
#    return "Hello World!"

#if __name__ == "__main__":
#	app.run(host='0.0.0.0', port=8898)



from adafruit_motorkit import MotorKit 
from adafruit_motor import stepper
import time
kit = MotorKit()


if sys.argv[1] == "up":
	for i in range(10000):
		kit.stepper1.onestep(direction=stepper.BACKWARD, style=stepper.DOUBLE)
#		kit.stepper1.onestep(direction=stepper.FORWARD, style=stepper.DOUBLE)

	print("UP")

if sys.argv[1] == "down":
	for i in range(10000):
#		kit.stepper1.onestep(direction=stepper.BACKWARD, style=stepper.DOUBLE)
		kit.stepper1.onestep(direction=stepper.FORWARD, style=stepper.DOUBLE)

	print("DOWN")

kit.stepper1.release()


#while True:
#	for i in range(2000):
#		kit.stepper1.onestep(direction=stepper.FORWARD, style=stepper.DOUBLE)
#	time.sleep(.5)
#	for i in range(2000):
#		kit.stepper1.onestep(direction=stepper.BACKWARD, style=stepper.DOUBLE)
#	time.sleep(.5)
