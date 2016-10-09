package testing;

import static org.junit.Assert.*;
import game.Game;
import game.InventoryItem;
import game.Location;
import game.Player;
import game.PuzzleRoom;
import game.Room.MovementDirection;

import org.junit.Test;

public class GameLogicTests {
	
	
	@Test
	public void gameInit(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
		assertTrue(testGame.players.get(0).getLocation().getX() == 0);
		assertTrue(testGame.players.get(0).getLocation().getY() == 0);
	}

	@Test
	public void testPlayerCount(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
		System.out.println("Player Size " + testGame.players.size());
		assertTrue(testGame.players.size() == 1);
	}
	
	@Test
	public void testPlayerMovement(){

		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
//		System.out.println(testGame.players.get(0).getLocation().getY());
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.DOWN);
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.DOWN);
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.DOWN);
//		System.out.println(testGame.players.get(0).getLocation().getY());
		System.out.println(testGame.getPlayer(200).getLocation().toString());
		assert(testGame.players.get(0).getLocation().equals(0,1));
		
		
	}
	
	@Test
	public void testPlayerMovementDownUp(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
//		System.out.println(testGame.players.get(0).getLocation().getY());
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.DOWN);
//		System.out.println(testGame.players.get(0).getLocation().getY());
		assert(testGame.players.get(0).getLocation().equals(0,1));
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.UP);
		assert(testGame.players.get(0).getLocation().equals(0,0));
		
	}
	
	@Test
	public void testPlayerMovementRight(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
//		System.out.println(testGame.players.get(0).getLocation().getY());
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.RIGHT);
//		System.out.println(testGame.players.get(0).getLocation().getY());
		assert(testGame.players.get(0).getLocation().equals(1,0));
//		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.UP);
//		assert(testGame.players.get(0).getLocation().equals(0,0));
		
	}
	
	@Test
	public void testPlayerMovementRightLeft(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
//		System.out.println(testGame.players.get(0).getLocation().getY());
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.RIGHT);
//		System.out.println(testGame.players.get(0).getLocation().getY());
		assert(testGame.players.get(0).getLocation().equals(1,0));
		testGame.rooms.get(0).MovePlayer(testGame.players.get(0), MovementDirection.LEFT);
		assert(testGame.players.get(0).getLocation().equals(0,0));
		
	}
	
	
	@Test
	public void testItemPlacement(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
		testGame.players.get(0).addItem(new InventoryItem(Game.itemType.KEY));
		assert(testGame.players.get(0).getInventory().get(0).getType().equals(Game.itemType.KEY));
	}
	
	@Test
	public void testMultiplePlayerItems(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		testGame.players.add(new Player(201, testGame.rooms.get(0)));
		testGame.players.get(0).addItem(new InventoryItem(Game.itemType.KEY));
		testGame.players.get(0).addItem(new InventoryItem(Game.itemType.BOOK));
		assert(testGame.players.get(0).getInventory().get(0).getType().equals(Game.itemType.KEY));
		assert(testGame.players.get(0).getInventory().get(0).getType().equals(Game.itemType.BOOK));
		assertTrue(testGame.players.get(0).getInventory().size() == 2);
	}
	
	@Test
	public void itemPlacementTet(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		Player player201 = new Player(201, testGame.rooms.get(0));
		testGame.players.add(player201);
		InventoryItem keyInventoryItem = new InventoryItem(Game.itemType.KEY);
		testGame.rooms.get(0).board.getSquare(player201.getLocation()).setItem(keyInventoryItem);
		assertTrue(testGame.rooms.get(0).board.getSquare(player201.getLocation()).getItem().equals(keyInventoryItem)); 
	}
	
	@Test
	public void playerItemPickupMove(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		Player player201 = new Player(201, testGame.rooms.get(0));
		testGame.players.add(player201);
		InventoryItem keyInventoryItem = new InventoryItem(Game.itemType.KEY);
		testGame.rooms.get(0).board.getSquare(player201.getLocation()).setItem(keyInventoryItem);
		Location currentLocation = player201.getLocation();
		testGame.rooms.get(0).MovePlayer(player201, MovementDirection.RIGHT);
		testGame.rooms.get(0).updatePlayerMoves(player201);
		assertFalse(testGame.rooms.get(0).board.getSquare(player201.getLocation()).getItem().equals(keyInventoryItem));
		 
	}
	
	@Test
	public void getNeighboursLength(){
		Game testGame = new Game();
		testGame.rooms.add(new PuzzleRoom(10));
		Player player201 = new Player(201, testGame.rooms.get(0));
		testGame.players.add(player201);
		testGame.rooms.get(0).MovePlayer(player201, MovementDirection.DOWN);
		testGame.rooms.get(0).MovePlayer(player201, MovementDirection.DOWN);
		System.out.println(player201.getLocation().toString());
	}
	
	
	
	
}