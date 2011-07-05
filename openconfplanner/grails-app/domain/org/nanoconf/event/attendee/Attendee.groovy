package org.nanoconf.event.attendee

import org.nanoconf.event.Event
import org.nanoconf.event.session.Session
import org.nanoconf.person.Person

class Attendee extends Person {
	
	static belongsTo = [event:Event]
	static hasMany = [sessions:Session]
	
    static constraints = {
    }
}
