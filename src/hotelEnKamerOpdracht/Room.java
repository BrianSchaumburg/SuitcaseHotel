package hotelEnKamerOpdracht;

public class Room {
   private double pricePerNight;
    private String code;
    private String type;
    private boolean doubleRoom;

    public Room(String code, double pricePerNight, String type, boolean doubleRoom) {
        setCode(code);
        setPricePerNight(pricePerNight);
        setType(type);
        setDoubleRoom(doubleRoom);
    }

    public Room(String code, double pricePerNight, String type) {
        setCode(code);
        setPricePerNight(pricePerNight);
        setType(type);
        setDoubleRoom(true);
    }

    public Room(String code, double pricePerNight) {
        setCode(code);
        setType("classic room");
        setDoubleRoom(true);
        setPricePerNight(pricePerNight);
    }

    public void errorGooien() {
        throw new IllegalArgumentException("Check de parameter");
    }

    public boolean getDoubleRoom() {
        return this.doubleRoom;
    }

    public void setDoubleRoom(boolean doubleRoom) {

        this.doubleRoom = doubleRoom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code.trim().isEmpty()) {
            errorGooien();
        }
        this.code = code;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight < 0) {
            errorGooien();
        }

        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.trim().isEmpty()) {
            errorGooien();
        }
        if (type.equals("suite") || type.equals("bridal suite") || type.equals("classic room")) {
            this.type = type;
        } else
            errorGooien();
    }
}
