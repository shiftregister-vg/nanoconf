package org.nanoconf.event.location

import org.nanoconf.address.Address
import org.nanoconf.event.Event
import org.nanoconf.event.location.room.Room

class Location {
	
	String name
	Address address
	
	static hasMany = [rooms:Room]
	
    static constraints = {
		name blank:false
    }
}
