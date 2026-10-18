package ftv.items;


import ftv.items.impl.*;

public class ItemsFactory implements IItemsFactory {
    public IInventoryItem createItem(ItemTypes type) {
        return switch (type) {
            case Bicycle -> new Bicycle();
            case ElectroBicycle -> new ElectroBicycle();
            case Samocat -> new Samocat();
            case Charger -> new Charger();
            case Headphones -> new Headphones();
            case Helmet -> new Helmet();
        };
    }
}
