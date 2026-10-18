package ftv.items;

public interface IItemsFactory {
    IInventoryItem createItem(ItemTypes type);
}
