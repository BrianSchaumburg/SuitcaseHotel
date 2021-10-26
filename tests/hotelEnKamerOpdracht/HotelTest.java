package hotelEnKamerOpdracht;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Room roomx, roomy, roomz;

    @Before
    public void setUp() throws Exception {
        hotel = new Hotel(200);
        roomx = new Room("Kamer 1", 150, "classic room", true);
        roomy = new Room("Kamer 1", 150, "classic room", true);
        roomz = new Room("Kamer 1", 150, "suite", true);



    }


    /**
     * tests on errors not included.
     */
    @Test
    public void getDoubleRooms() {
        assertEquals(3, hotel.getDoubleRooms());
    }

    @Test
    public void getRoomsOfType() {
        assertEquals(2, hotel.getRoomsOfType("classic room"));


    }

    @Test
    public void averagePrice() {
        assertEquals((150 * 3 / 3), hotel.AveragePrice(), 0);
    }

    @Test
    public void averagePriceOfType() {
        this.addRoom();
        assertEquals(150 * 2 / 2, hotel.AveragePriceOfType("classic room"), 0);
    }

    @Test
    public void addRoom() {
        hotel.addRoom(roomx);
        hotel.addRoom(roomy);
        hotel.addRoom(roomz);
        assertEquals(3, hotel.getBookedRooms().size());
    }
}