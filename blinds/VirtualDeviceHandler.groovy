
metadata {
	definition (name: "Blinds Relay", namespace: "glinski", author: "glinski") {
		capability "Switch"
        capability "Refresh"
		    capability "Polling"
        
        command "changeSwitchState", ["string"]
	}

	simulator {
		
	}

	tiles {    
        
		 standardTile("blinds", "device.blinds", width: 1, height: 1, canChangeIcon: true) {
			state "open", label:'${name}', action:"blinds.open", icon:"st.st.vents.vent-open-text", backgroundColor:"#e7e7e7"
			state "closed", label:'${name}', action:"blinds.closed", icon:"st.vents.vent-closed", backgroundColor:"#676767"
		}
        
    standardTile("setopen", "device.setopen", inactiveLabel: false, decoration: "flat", width: 1, height: 1) {
			state("default", label:'Set Open', action:"setopen", icon:"st.st.vents.vent-open-text")
		}
    
    standardTile("setclosed", "device.setclosed", inactiveLabel: false, decoration: "flat", width: 1, height: 1) {
			state("default", label:'Set Closed', action:"setopen", icon:"st.st.vents.vent-closed")
		}

		main "blinds"
		details (["blinds", "setopen", "setclosed"])
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Virtual siwtch parsing '${description}'"
}

/*
def poll() {
	log.debug "Executing 'poll'"   
        
        def lastState = device.currentValue("switch")
    	sendEvent(name: "switch", value: device.deviceNetworkId + ".refresh")
        sendEvent(name: "switch", value: lastState);
}*/


def refresh() {
	log.debug "Executing 'refresh'"
    
	poll();
}

def setopen() {
	log.debug "Executing 'setclosed'"	     
    
  sendEvent(name: "blinds", value: device.deviceNetworkId + ".setclosed");    
  sendEvent(name: "blinds", value: "setclosed");    
}

def setclosed() {
	log.debug "Executing 'setopen'"	     
    
  sendEvent(name: "blinds", value: device.deviceNetworkId + ".setopen");    
  sendEvent(name: "blinds", value: "setopen");    
}

def open() {
	log.debug "Executing 'open'"	     
    
  sendEvent(name: "setopen", value: device.deviceNetworkId + ".closed");    
  sendEvent(name: "setopen", value: "on");    
}

def closed() {
	log.debug "Executing 'closed'"
	    
	sendEvent(name: "blinds", value: device.deviceNetworkId + ".closed");     
  sendEvent(name: "blinds", value: "closed");
}
/*
def changeSwitchState(newState) {

	log.trace "Received update that this switch is now $newState"
	switch(newState) {
    	case 1:
			sendEvent(name: "switch", value: "on")
            break;
    	case 0:
        	sendEvent(name: "switch", value: "off")
            break;
    }
}
*/
