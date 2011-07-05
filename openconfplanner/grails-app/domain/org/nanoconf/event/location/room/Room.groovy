package org.nanoconf.event.location.room

import org.nanoconf.event.location.Location
import org.nanoconf.event.session.Session

class Room {
	
	String name
	Location location
	
	static belongsTo = [Location]
	static hasMany = [sessions:Session]
	
    static constraints = {
    }
}
