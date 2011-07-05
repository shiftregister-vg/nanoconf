package org.nanoconf.event.location

import org.nanoconf.address.Address;
import org.nanoconf.event.location.room.Room;

class LocationService {

    static transactional = true

    def createLocation(Location location) {
		location.save(failOnError:true)
    }
	
	def createLocation(String name, Address address){
		createLocation(new Location(name:name, address:address))
	}
	
	def readLocation(long id){
		Location.get(id)
	}
	
	def readLocation(long[] ids){
		Location.getAll(ids)
	}
	
	def readLocation(String name){
		Location.findAllByName(name)
	}
	
	def readLocation(String name, Address address){
		Location.findAllByNameAndAddress(name,address)
	}
	
	def readLocation(Address address){
		Location.findAllByAddress(address)
	}
	
	def createRoom(Room room){
		room.save(failOnError:true)
	}
	
	def createRoom(String name, Location location){
		createRoom(new Room(name:name,location:location))
	}
	
	def readRoom(long id){
		Room.get(id)
	}
	
	def readRoom(long[] ids){
		Room.getAll(ids)
	}
	
	def readRoom(String name){
		Room.findAllByName(name)
	}
	
	def readRoom(Location location){
		Room.findAllByLocation(location)
	}
	
	def readRoom(String name, Location location){
		Room.findAllByNameAndLocation(name,location)
	}
}
