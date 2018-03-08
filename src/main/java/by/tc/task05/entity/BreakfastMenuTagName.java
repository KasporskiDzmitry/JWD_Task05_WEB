package by.tc.task05.entity;

/**
 * Created by Дима on 04.03.2018.
 */
public enum BreakfastMenuTagName {
    BREAKFAST_MENU, FOOD, NAME, PRICE;

    public static BreakfastMenuTagName getElementTagName(String element) {
        switch (element) {
            case "breakfast-menu":
                return BREAKFAST_MENU;
            case "food":
                return FOOD;
            case "price":
                return PRICE;
            case "name":
                return NAME;
            default:
                throw new EnumConstantNotPresentException(BreakfastMenuTagName.class, element);
        }
    }
}