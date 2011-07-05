package org.nanoconf.event.location

import org.nanoconf.address.Address;
import org.nanoconf.event.Event;
import org.nanoconf.event.location.room.Room;

import grails.test.*

class LocationServiceIntegrationTests extends GroovyTestCase {
    
	def locationService
	
	protected void setUp() {
        super.setUp()
		locationService = new LocationService()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testCreateLocation() {
		def address = new Address(street:"123 Maple",city:"Dallas", state:"TX",postalCode:"75230")
		assert address.save()
		
		def location = new Location(name:"Test Location",address:address)
		assert locationService.createLocation(location)
		
		location.delete(flush:true)
		
		address = new Address(street:"123 Maple",city:"Dallas", state:"TX",postalCode:"75230")
		assert address.save()
		
		assert locationService.createLocation("Test Location",address)
		
		Location.findByNameAndAddress("Test Location",address)?.delete()
	}
	
    void testReadLocation() {
		assert locationService.readLocation(999999) == null
		
		def address = new Address(street:"123 Maple",city:"Dallas", state:"TX",postalCode:"75230")
		assert address.save()
		
		def location = new Location(name:"Test Location",address:address)
		assert locationService.createLocation(location)
		
		assert locationService.readLocation(location.id)
		
		assert locationService.readLocation("Test Location")
		assert locationService.readLocation(address)
		assert locationService.readLocation("Test Location",address)
		assert !locationService.readLocation("Foo")
		
		location.delete(flush:true)
	}
	
	void testCreateRoom() {
		def address = new Address(street:"123 Maple",city:"Dallas", state:"TX",postalCode:"75230")
		assert address.save()
		
		def location = new Location(name:"Test Location",address:address)
		assert locationService.createLocation(location)
		
		def room = new Room(name:"Test Room",location:location)
		assert locationService.createRoom(room)
		
		room.delete(flush:true)
		
		assert locationService.createRoom("Test Room",location)
		
		Room.findByNameAndLocation("Test Room",location)?.delete()
	}
	
	void testReadRoom() {
		
		assert locationService.readRoom(999999) == null
		
		def address = new Address(street:"123 Maple",city:"Dallas", state:"TX",postalCode:"75230")
		assert address.save()
		
		def location = new Location(name:"Test Location",address:address)
		assert locationService.createLocation(location)
		
		def room = new Room(name:"Test Room",location:location)
		assert locationService.createRoom(room)
		
		assert locationService.readRoom(room.id)
		assert locationService.readRoom("Test Room")
		assert locationService.readRoom(location)
		assert locationService.readRoom("Test Room",location)
		assert !locationService.readRoom("Foo")
		
		room.delete(flush:true)
		location.delete(flush:true)
	}
}
