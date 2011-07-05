package org.nanoconf.event.session

import groovy.time.*

import org.nanoconf.event.Event
import org.nanoconf.event.location.room.Room
import org.nanoconf.event.speaker.Speaker

class Session {
	
	String name
	String description
	Date start
	Date end
	Room room
	Event event	
	
	static belongsTo = [Event,Speaker]
	static hasMany = [speakers:Speaker]
	
    static constraints = {
		name blank:false
		description blank:false
		room nullable:true
    }

	static mapping = {
		description type: 'text'
		start column: 'start_date_time'
		end column: 'end_date_time'
	}
	
	int duration(){
		TimeDuration duration = TimeCategory.minus(end,start)
		duration.toMilliseconds() / 60000
	}
}
