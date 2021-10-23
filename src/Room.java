public class Room {
   private String code; double pricePerNight; private String type;  private boolean doubleRoom;

   public void setCode(String code) {
      if (code.trim().isEmpty()) {
         errorGooien();
      }
      this.code = code;
   }

   public void setPricePerNight(double pricePerNight) {
      if (pricePerNight < 0) {
         errorGooien();
      }

      this.pricePerNight = pricePerNight;
   }

   public void setType(String type) {
      if (type.trim().isEmpty()) {
         errorGooien();
      }
      if (type.equals("suite") || type.equals("bridal suite") || type.equals("classic room")) {
         this.type = type;
      }
      else
         errorGooien();
   }

   public void setDoubleRoom(boolean doubleRoom) {

      this.doubleRoom = doubleRoom;
   }
   public void errorGooien()
   {
      throw new IllegalArgumentException("Check de parameter");
   }

   public Room(String code, double pricePerNight, String type, boolean doubleRoom) {
      setCode(code);
      setPricePerNight(pricePerNight);
      setType(type);setDoubleRoom(doubleRoom);
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
   public boolean getDoubleRoom()
   {
      return this.doubleRoom;
   }

   public String getCode() {
      return code;
   }

   public double getPricePerNight() {
      return pricePerNight;
   }

   public String getType() {
      return type;
   }
}
