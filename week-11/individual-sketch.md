# Individual Sketch Week 11
**Student:** Na Cha
**Date:** 11/05/2026

---

## 1. Tonight's Prompt

# Week 11: Individual Sketch
### ICS372 | Object-Oriented Design and Implementation

**25 minutes, alone.** Commit to `week-11/individual-sketch.md`.

## Checklist

Check every box before you commit. **10 points.**

- [ ] Step 1 has a row for every file in the case that would have to change, and the total under the table **(4 pts)**
- [ ] Step 2 has your changed `OrderDesk` in Java, and anything else in the case you changed for it **(4 pts)**
- [ ] Section 2 of the template says what you're least sure of **(2 pts)**
- [ ] Committed to `week-11/individual-sketch.md` **(required: nothing is graded without it)**

---

Tonight you start from code somebody else wrote. Open `week-11-the-case.md`. Read it whole before you start: every file, and the requirement at the end.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

**Step 1: What the barista's screen costs.** Don't write the screen. Work out what adding it would do to the case as it stands.

In a table with exactly these three columns, one row for every file in the case that would have to change:

| File | What changes in it | Why it has to change |
|---|---|---|
| `Circulation.java` | the constructor gets a fourth parameter | the new notice has to be handed in |

The example row is from the textbook's library system, not the case. It shows only the shape.

- Count every file under `src/main` and `src/test`, including any test that would stop compiling.
- **Don't count `ShopSetup`** or the new screen class.
- Under the table, write the total: `Total: N files`.

| File | What changes in it | Why it has to change |
|---|---|---|
| `OrderDesk.java` | a method to show queue to barista at the desk screen  | because orders has to be on the barista's screen right away according to `requirement 1.4`, granted this method could also be in `OrderQueue.java` |
| `OrderDesk.java` | a method to remove and update the current displayed order for the barista screen after it is marked complete | because `requirement 3.3` says an order has to leave the barista screen or tablet when it is marked complete |

`Total: 2 files`

**Step 2: Your fix.** Change `OrderDesk`, and anything else in the case you need to, so that after your change, adding the barista's screen, or any screen after it, changes no file you already have except `ShopSetup`.

Write the changed `OrderDesk` whole, in Java, in one code block. Put any other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.

```
package edu.metrostate.oodi.brewandbyte.model;

import edu.metrostate.oodi.brewandbyte.view.ManagerWarnings;
import edu.metrostate.oodi.brewandbyte.view.PickupBoard;
import java.time.LocalDateTime;

public class OrderDesk {
    private final OrderQueue queue;
    private final Inventory inventory;
    private final SalesLedger ledger;
    private final ManagerWarnings warnings;
    private final PickupBoard pickup;

    private Order currentOrder;

    public OrderDesk(OrderQueue queue, Inventory inventory, SalesLedger ledger,
                     ManagerWarnings warnings, PickupBoard pickup) {
        this.queue = queue;
        this.inventory = inventory;
        this.ledger = ledger;
        this.warnings = warnings;
        this.pickup = pickup;
    }

    public void place(Order order) {
        queue.add(order);
        this.currentOrder = order;
    }

    public void completeNext(LocalDateTime now) {
        Order order = queue.next();
        order.markComplete(now);
        for (Ingredient low : inventory.useUp(order)) {
            warnings.lowStock(low);
        }
        queue.remove(order);
        ledger.record(order);
        pickup.call(order.getConfirmationNumber());

        // sets to null if no order left
        // to fulfill req. 3.3
        // like in displayCurrentOrder()
        // barista view class should call it to update view
        // after marked as complete
        if (queue.next() == null) {
            this.currentOrder = null;
        }
    }

    public Order displayCurrentOrder() {
        // something like this for req 1.3 barista being 
        // shown the immediate order
        // when it is placed, barista view class should technically call this
        return currentOrder;
    }
}
```

---

## 2. What I'm Not Sure About

Not sure if it will work as expected. The idea was that the barista view class can call `completeNext()` which had an addition to set current order to null if there is no order for requirement 3.3, an order leaves the tablet after it is complete. And after doing so, it calls `displayCurrentOrder()`, which returns the current order. While I did not add the barista screen view, I assume it has a behavioural mehtod to update the current displayed order. I could've named the function to `getCurrentOrder()` as well I suppose for my additions to`OrderDesk.java`.

---

**Commit this file before group discussion begins.**