package org.nanoconf.event

import org.nanoconf.address.Address
import org.nanoconf.event.attendee.Attendee
import org.nanoconf.event.location.Location;
import org.nanoconf.event.session.Session
import org.nanoconf.event.speaker.Speaker
import org.nanoconf.event.sponsor.Sponsor

class Event {
	
	String name
	Location location
	
	static hasMany = [
		sessions:Session,
		attendees:Attendee,
		speakers:Speaker,
		sponsors:Sponsor
	]
	
    static constraints = {
		name blank:false
		location nullable:true
    }
}
