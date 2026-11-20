# Individual Sketch Week 13
**Student:** Na Cha
**Date:** 11/19/2026

---

## 1. Tonight's Prompt

# Week 13: Individual Sketch
### ICS372 | Object-Oriented Design and Implementation

**25 minutes, alone.** Commit to `week-13/individual-sketch.md`.

## Checklist

Check every box before you commit. **10 points.**

- [X] Step 1 names the model classes `BaristaController` would have to hold that it doesn't hold now, has a row for every `if` it would have to copy, and the total under the table **(4 pts)**
- [X] Step 2 has your `BaristaController` in Java, and every class in the case you added or changed for it **(4 pts)**
- [X] Section 2 of the template says what you're least sure of **(2 pts)**
- [X] Committed to `week-13/individual-sketch.md` **(required: nothing is graded without it)**

---

Tonight you start from code somebody else wrote. The case is below. Read it whole before you start: every class, the test, and the requirements at the end.

The case has three packages. `model` holds the shop's data. `view` holds the screens, which only print. `controller` holds one class for each screen, with a method for each button on it.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

**Step 1: What 3.7 would cost.** Requirement 3.7 says that if the manager isn't in, a barista can add a menu item. Suppose the barista's screen gets the same Add Item form the manager's screen has, so `BaristaController` gets a method `onAddItem(String name, String price, String ingredientNames)` that does exactly what `ManagerController.onAddItem` does.

Don't write it. Work out what it would take, in two parts.

(a) Under the heading `New fields:`, name every model class `BaristaController` would have to hold as a field that it doesn't hold now, or write `none`.

### New fields:
Barista needs a Menu class. ```private final Menu menu```

(b) Every `if` statement in `ManagerController.onAddItem` that `BaristaController.onAddItem` would have to copy, in a table with exactly these two columns, one row for each `if`:

| What the `if` checks | The rule about the business it keeps |
|---|---|
| `copies == 0` | a book with no copies left can't be checked out |

The example row is from the textbook's library system, not the case. It shows only the shape.

- **What the `if` checks** is the condition inside the `if`'s parentheses, copied from the case.
- Under the table, write the total: `Total: N copied`.

| What the `if` checks | The rule about the business it keeps |
|---|---|
| `priceInCents <= 0` | The price must be more than zero. |
| `menu.find(name) != null` | There is already an item with the same name on the menu. |
| `ingredient == null` | Does not stock said ingredient. |

**Step 2: Your fix.** Change the case so that `BaristaController` can add a menu item **without copying any `if` from `ManagerController`**, and so that **a test could check each of those rules without building a controller or a screen.**

Write `BaristaController` whole, in Java, in one code block, with its `onAddItem` method. Put every other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.

```java
public class BaristaController {
    private final Inventory inventory;
    private final BaristaScreen screen;
    private final Menu menu; // something like this

    public BaristaController(Inventory inventory, BaristaScreen screen, Menu menu) {
        this.inventory = inventory;
        this.screen = screen;
        this.menu = menu; // something like this
    }

    public void onAddItem(String name, String price, String ingredientNames) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents > 0) { // something like this
            if (!menu.find(name)) {
                screen.showMessage(name + " is already on the menu.");
                return;
            }
            List<Ingredient> recipe = new ArrayList<>();
            
            for (String ingredientName : ingredientNames.split(",")) {
                Ingredient ingredient = inventory.find(ingredientName.trim());
                if (ingredient != null) { // something like this
                    recipe.add(ingredient);
                } else {
                    screen.showMessage("We don't stock " + ingredientName.trim() + ".");
                    return;
                }
            }

            menu.add(new MenuItem(name, priceInCents, recipe));
            screen.showMessage(name + " is on the menu.");
            showMenu();

        } else {
            screen.showMessage("The price must be more than zero.");
            return;
        }
    }

    // Requirement 3.6: the Mark Out button.
    public void onMarkOut(String ingredientName) {
        Ingredient ingredient = inventory.find(ingredientName);
        if (ingredient == null) {
            screen.showMessage("We don't stock " + ingredientName + ".");
            return;
        }
        ingredient.markOut();
        screen.showMessage(ingredientName + " is marked out.");
    }
}
```

**Section 2 of the template: what you're not sure about.** Name the part of your fix you're least sure would work, and what would show you.

**Do step 1 first, and quickly.** Step 2 is the one that matters, and a rough fix you can explain is worth more than a perfect count.

---

## The Case

Money is in whole cents, so $4.50 is `450`. The case compiles, and its test passes. Package and import lines are left out.

**`src/main/.../model/Ingredient.java`**

```java
public class Ingredient {
    private final String name;
    private int quantity;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public boolean isOut() { return quantity == 0; }
    public void markOut() { quantity = 0; }
    public void restock(int amount) { quantity += amount; }
}
```

**`src/main/.../model/Inventory.java`**

```java
public class Inventory {
    private final Map<String, Ingredient> ingredients = new HashMap<>();

    public void add(Ingredient ingredient) {
        ingredients.put(ingredient.getName(), ingredient);
    }

    public Ingredient find(String name) {
        return ingredients.get(name);
    }
}
```

**`src/main/.../model/MenuItem.java`**

```java
public class MenuItem {
    private final String name;
    private int priceInCents;
    private final List<Ingredient> ingredients;

    public MenuItem(String name, int priceInCents, List<Ingredient> ingredients) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.ingredients = List.copyOf(ingredients);
    }

    public String getName() { return name; }
    public int getPriceInCents() { return priceInCents; }
    public void setPriceInCents(int priceInCents) { this.priceInCents = priceInCents; }
    public List<Ingredient> getIngredients() { return ingredients; }
}
```

**`src/main/.../model/Menu.java`**

```java
public class Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public void add(MenuItem item) {
        items.add(item);
    }

    public MenuItem find(String name) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public List<MenuItem> getItems() {
        return List.copyOf(items);
    }
}
```

**`src/main/.../view/ManagerScreen.java`**

```java
public class ManagerScreen {
    public void showMenu(List<String> lines) {
        System.out.println("Manager: the menu");
        for (String line : lines) {
            System.out.println("  " + line);
        }
    }

    public void showMessage(String message) {
        System.out.println("Manager: " + message);
    }
}
```

**`src/main/.../view/CounterScreen.java`**

```java
public class CounterScreen {
    public void showMenu(List<String> lines) {
        System.out.println("Counter: today's menu");
        for (String line : lines) {
            System.out.println("  " + line);
        }
    }
}
```

**`src/main/.../view/BaristaScreen.java`**

```java
public class BaristaScreen {
    public void showMessage(String message) {
        System.out.println("Barista: " + message);
    }
}
```

**`src/main/.../controller/ManagerController.java`**

```java
public class ManagerController {
    private final Menu menu;
    private final Inventory inventory;
    private final ManagerScreen screen;

    public ManagerController(Menu menu, Inventory inventory, ManagerScreen screen) {
        this.menu = menu;
        this.inventory = inventory;
        this.screen = screen;
    }

    // The Add Item button. The form has a name, a price like 4.50,
    // and the ingredients separated by commas, like "espresso, milk".
    public void onAddItem(String name, String price, String ingredientNames) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents <= 0) {
            screen.showMessage("The price must be more than zero.");
            return;
        }
        if (menu.find(name) != null) {
            screen.showMessage(name + " is already on the menu.");
            return;
        }
        List<Ingredient> recipe = new ArrayList<>();
        for (String ingredientName : ingredientNames.split(",")) {
            Ingredient ingredient = inventory.find(ingredientName.trim());
            if (ingredient == null) {
                screen.showMessage("We don't stock " + ingredientName.trim() + ".");
                return;
            }
            recipe.add(ingredient);
        }
        menu.add(new MenuItem(name, priceInCents, recipe));
        screen.showMessage(name + " is on the menu.");
        showMenu();
    }

    // The Change Price button.
    public void onChangePrice(String name, String price) {
        int priceInCents = (int) Math.round(Double.parseDouble(price) * 100);
        if (priceInCents <= 0) {
            screen.showMessage("The price must be more than zero.");
            return;
        }
        MenuItem item = menu.find(name);
        if (item == null) {
            screen.showMessage(name + " isn't on the menu.");
            return;
        }
        item.setPriceInCents(priceInCents);
        showMenu();
    }

    private void showMenu() {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : menu.getItems()) {
            lines.add(item.getName() + "  " + String.format("$%.2f", item.getPriceInCents() / 100.0));
        }
        screen.showMenu(lines);
    }
}
```

**`src/main/.../controller/CounterController.java`**

```java
public class CounterController {
    private final Menu menu;
    private final CounterScreen screen;

    public CounterController(Menu menu, CounterScreen screen) {
        this.menu = menu;
        this.screen = screen;
    }

    // Requirement 3.6: an item with an ingredient that's out doesn't show.
    public void showMenu() {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : menu.getItems()) {
            boolean available = true;
            for (Ingredient ingredient : item.getIngredients()) {
                if (ingredient.isOut()) {
                    available = false;
                }
            }
            if (available) {
                lines.add(item.getName() + "  " + String.format("$%.2f", item.getPriceInCents() / 100.0));
            }
        }
        screen.showMenu(lines);
    }
}
```

**`src/main/.../controller/BaristaController.java`**

```java
public class BaristaController {
    private final Inventory inventory;
    private final BaristaScreen screen;

    public BaristaController(Inventory inventory, BaristaScreen screen) {
        this.inventory = inventory;
        this.screen = screen;
    }

    // Requirement 3.6: the Mark Out button.
    public void onMarkOut(String ingredientName) {
        Ingredient ingredient = inventory.find(ingredientName);
        if (ingredient == null) {
            screen.showMessage("We don't stock " + ingredientName + ".");
            return;
        }
        ingredient.markOut();
        screen.showMessage(ingredientName + " is marked out.");
    }
}
```

**`src/test/.../controller/AddItemTest.java`**

```java
class AddItemTest {
    @Test
    void refusesANameAlreadyOnTheMenu() {
        Inventory inventory = new Inventory();
        inventory.add(new Ingredient("espresso", 100));
        Menu menu = new Menu();
        ManagerController controller = new ManagerController(menu, inventory, new ManagerScreen());

        controller.onAddItem("Mocha", "4.75", "espresso");
        controller.onAddItem("Mocha", "5.25", "espresso");

        assertEquals(1, menu.getItems().size());
        assertEquals(475, menu.find("Mocha").getPriceInCents());
    }
}
```

**The requirements**

- **3.6** If we're out of something the barista needs to be able to tell the system, so it stops showing up on the menu.
- **3.7** If the manager isn't in, a barista can add a menu item. This happens more than you'd think, somebody has an idea for a special and I'm not there.
- **4.2** A manager can add a menu item, change the price of one, or take one off the menu.


---

## 2. What I'm Not Sure About

I am not sure about how the java code were to exactly be implemented, as we were asked to. Since there was no clear specification other than we have to avoid using the same if statements, I just either put them in alternative forms, or backward condition check. But a true implementation should realistically reuse similar code, but with a condition to check if the manager is actually there in the shop before being able to run the method, in my opinion.

---

**Commit this file before group discussion begins.**