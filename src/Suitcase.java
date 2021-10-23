import java.lang.reflect.Array;
import java.util.ArrayList;

public class Suitcase {
  /* RULES:
     four categories tops, bottoms, footwear, dresses - counts as bottom and top, accessories
    five pieces in the suitcase
    must have one top,bottom, and shoes
    maximum 3 pieces of the same category
   weight of each item must be greater than 0 and smaller than 10
    total weight must be smaller than 0 */
    public enum type
  {
      top, bottom, footwear, dress, accessory;
  }
  private ArrayList<String> items = new ArrayList<>();
    private ArrayList<type> broughtCategories =new ArrayList<>();
    private int weight;
    public Suitcase()
    {

    }
    public void toevoegenItem(String itemName, type type, double weight)
    {
        if (itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Check the name ");
        }
            //check the weight
            if (weight < 0 || weight > 20) {
                throw new IllegalStateException("The weight must not be smaller than 0 or greater than 10");
            }

        //check the categories
        if(broughtCategories.stream().filter(c->c == Suitcase.type.bottom).count()>3
        || broughtCategories.stream().filter(c-> c == Suitcase.type.top).count()>3
       || broughtCategories.stream().filter(c -> c == Suitcase.type.footwear).count()>3

                || broughtCategories.stream().filter(c-> c == Suitcase.type.accessory).count()>3
        )
        {
            throw new IllegalStateException("the category can not be brought more than 3 times ");
        }
        switch (type) {
            case dress -> {
                broughtCategories.add(Suitcase.type.top);
                broughtCategories.add(Suitcase.type.bottom);

            }
            case top, bottom, footwear,accessory -> broughtCategories.add(type);
        }
        items.add(itemName);
        this.weight+=weight;

    }
    public boolean checkItemName(String itemName)
    {
        if (itemName.trim().isEmpty()) {
            throw new IllegalStateException("The ItenName is empty. ");
        }
        switch (itemName) {
            case "shirts":
            case "pants":
            case "shorts":
            case "dress":
            case "shoes":
            case "sandals":
            case "hats":
            case "sunglasses":
             return true;

            default: return false;
        }
    }
    public boolean ableToLeave()
    {
        if(broughtCategories.stream().filter(c -> c == type.footwear).count()>3
            || broughtCategories.stream().filter(c -> c == type.bottom).count()>3
                || broughtCategories.stream().filter(c -> c == type.top).count()>3)
        {
            return true;
        }
    else
        return false;
    }


}
