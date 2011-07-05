package org.nanoconf.event.speaker

import org.nanoconf.event.Event;
import org.nanoconf.event.session.Session;
import org.nanoconf.person.Person

class Speaker extends Person {
	
	Event event
	
	static belongsTo = [Event]
	static hasMany = [session:Session]
	
    static constraints = {
    }
}
