package game;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<InventoryItem> playerInventory;
//	private String nameString;
	private Location location;
	private int playerNumber;
	private Room currentRoom;
	
	
	
	
	public Player(int number, Room room){
//		this.nameString = nameString;
		this.playerInventory = new ArrayList<InventoryItem>();
		this.location = new Location(0, 0);
		this.playerNumber = number;
		this.currentRoom = room;

		// check this

	}
	
	public Room getRoom(){
		return this.currentRoom;
	}
	
	public void updateRoom(Room room){
		this.currentRoom = room;
	}
	
	public void addItem(InventoryItem item){
		this.playerInventory.add(item);
		
	}
	
	public void removeItem(InventoryItem item){
		playerInventory.remove(item);
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	public void updateLocation(Location location){
		this.location = location;
	}
	
	public void pushItem(){
		// get neighbouts
		// if neighbour has movable item
		// if square in push direction empty / not door / exists
		// can push
		// else cannot push
	}
	
	public void setPlayerNumber(int newCharacter){
		this.playerNumber = newCharacter;
	}
	
	public int getCharacter(){
		return this.playerNumber;
	}
	

	// possible player movement
	
	// possible player push
	
	// possible player pull
	
	// possible pickup
	
	// possible drop
	
	
	// inventory
	
	// current view direction
	
	// location
	
}
