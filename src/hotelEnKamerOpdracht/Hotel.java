package hotelEnKamerOpdracht;

import java.util.ArrayList;

public class Hotel {
    ArrayList<Room> rooms = new ArrayList<>();

    public Hotel(int totalRooms) {
        if (totalRooms < 0) {
            throw new IllegalArgumentException("check the parameter");
        }
        this.totalRooms = totalRooms;
    }

    private int totalRooms;

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
        double sum = 0;
        for (int i = 0; i < rooms.size(); i++) {
            sum += rooms.get(i).getPricePerNight();
        }

        return sum / rooms.size();
    }

    public double AveragePriceOfType(String type) {
        if (type == null)
            throw new IllegalArgumentException("type is null");
        double sum = 0;
        int count = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getType().equals(type))
                sum += rooms.get(i).getPricePerNight();
            count++;
        }
        return sum / count;
    }

    public void addRoom(Room room) {
        if (rooms.size() + 1 <= totalRooms)
            rooms.add(room);
        else
            throw new IllegalStateException("No more rooms can be added");
    }
}
