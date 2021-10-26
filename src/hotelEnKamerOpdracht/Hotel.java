package hotelEnKamerOpdracht;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();
    private final int totalRooms;

    public Hotel(int totalRooms) {
        if (totalRooms < 0) {
            throw new IllegalArgumentException("check the parameter");
        }
        this.totalRooms = totalRooms;
    }

    public ArrayList<Room> getBookedRooms() {
        return rooms;

    }

    public int getRooms() {
        return totalRooms;
    }

    public int getDoubleRooms() {
        return (int) rooms.stream().filter(c -> c.getDoubleRoom()).count();
    }

    public int getRoomsOfType(String type) {
        return rooms.stream().filter(c -> c.getType().equals(type)).toList().size();
    }

    public double AveragePrice() {


        return rooms.stream().mapToDouble(c -> c.getPricePerNight()).sum() / rooms.size();
    }

    public double AveragePriceOfType(String type) {
        if (type == null)
            throw new IllegalArgumentException("type is null");

        List<Room> rooms = this.rooms.stream().filter(c -> c.getType() == type).toList();
        double averagePrice = rooms.stream().mapToDouble(c -> c.getPricePerNight()).sum();

        return averagePrice / rooms.size();
    }

    public void addRoom(Room room) {
        if (rooms.size() + 1 <= totalRooms)
            rooms.add(room);
        else
            throw new IllegalStateException("No more rooms can be added");
    }
}
