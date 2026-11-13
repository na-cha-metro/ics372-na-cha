# Individual Sketch Week 12
**Student:** Na Cha
**Date:** 11/12/2026

---

## 1. Tonight's Prompt

# Week 12: Individual Sketch
### ICS372 | Object-Oriented Design and Implementation

**20 minutes, alone.** Commit to `week-12/individual-sketch.md`.

## Checklist

Check every box before you commit. **10 points.**

- [ ] Step 1 has a row for every file under `src/main` in the case that would have to change, and the total under the table **(4 pts)**
- [ ] Step 2 has your changed `Order` in Java, and anything else in the case you added or changed for it **(4 pts)**
- [ ] Section 2 of the template says what you're least sure of **(2 pts)**
- [ ] Committed to `week-12/individual-sketch.md` **(required: nothing is graded without it)**

---

Tonight you start from code somebody else wrote. The case is below. Read it whole before you start: every class, and the requirement at the end.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

**Step 1: What 50 cents an item would cost.** Requirement 2.8 says *loyalty members get their discount automatically*, and it never said what the discount is. The case guessed 10 percent off the order. **Suppose the owner answers that members get 50 cents off every item they order.** Three lattes would be $1.50 off. This is a what-if for the case only; in your group's project, 2.8 is still open.

Don't write the change. Work out what it would do to the case as it stands. In a table with exactly these three columns, one row for every file that would have to change:

| File | What changes in it | Why it has to change |
|---|---|---|
| `Circulation.java` | the late fee goes from 25 cents a day to 50 | it works out the fee itself |

The example row is from the textbook's library system, not the case. It shows only the shape.

- Count only files under `src/main`. **Don't count the test.**
- Under the table, write the total: `Total: N files`.

| File | What changes in it | Why it has to change |
|---|---|---|
| `Order.java` | add discount attribute, and method to apply total to order | Because of member loyalty discount |

**Step 2: Your fix.** Change the case so that after your change, switching to that rule, or to any rule after it, changes **exactly one class under `src/main`**, and that class isn't `Order`, `Receipt` or `DaySales`.

Write the changed `Order` whole, in Java, in one code block. Put any other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.

```java
public class Order {
    private final Customer customer;              // null for a walk-up customer
    private final List<OrderLine> lines = new ArrayList<>();

    private double memberdiscount = 0.50; //something like this
    private double total = 0; //something like this

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void add(OrderLine line) {
        lines.add(line);
    }

    public Customer getCustomer() { return customer; }

    public int subtotalInCents() {
        int subtotal = 0;
        int items = 0; //something like this
        for (OrderLine line : lines) {
            items +=1; //something like this
            subtotal += line.priceInCents();
        }
        int loyalty = items * this.memberdiscount; //something like this
        return subtotal - loyalty;
    }

    public int totalInCents() {
        int subtotal = subtotalInCents();
        if (customer != null && customer.isLoyaltyMember()) {
            return subtotal - subtotal / 10;
        }
        return subtotal;
    }
}
```

**Section 2 of the template: what you're not sure about.** Name the part of your fix you're least sure would work, and what would show you.

**Do step 1 first, and quickly.** Step 2 is the one that matters, and a rough fix you can explain is worth more than a perfect count.

---

## The Case

Money is in whole cents, so $4.50 is `450`. The case compiles, and its test passes. Imports are left out.

**`src/main/.../model/Customer.java`**

```java
public class Customer {
    private final String name;
    private final boolean loyaltyMember;

    public Customer(String name, boolean loyaltyMember) {
        this.name = name;
        this.loyaltyMember = loyaltyMember;
    }

    public String getName() { return name; }
    public boolean isLoyaltyMember() { return loyaltyMember; }
}
```

**`src/main/.../model/OrderLine.java`**

```java
public class OrderLine {
    private final MenuItem item;
    private final int quantity;

    public OrderLine(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() { return quantity; }
    public int priceInCents() { return item.getPriceInCents() * quantity; }
}
```

**`src/main/.../model/Order.java`**

```java
public class Order {
    private final Customer customer;              // null for a walk-up customer
    private final List<OrderLine> lines = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void add(OrderLine line) {
        lines.add(line);
    }

    public Customer getCustomer() { return customer; }

    public int subtotalInCents() {
        int subtotal = 0;
        for (OrderLine line : lines) {
            subtotal += line.priceInCents();
        }
        return subtotal;
    }

    public int totalInCents() {
        int subtotal = subtotalInCents();
        if (customer != null && customer.isLoyaltyMember()) {
            return subtotal - subtotal / 10;
        }
        return subtotal;
    }
}
```

**`src/main/.../model/Receipt.java`**

```java
public class Receipt {
    public static String forOrder(Order order) {
        StringBuilder text = new StringBuilder();
        text.append("Subtotal: ").append(dollars(order.subtotalInCents())).append("\n");
        Customer customer = order.getCustomer();
        if (customer != null && customer.isLoyaltyMember()) {
            text.append("Loyalty discount (10%): -")
                .append(dollars(order.subtotalInCents() / 10)).append("\n");
        }
        text.append("Total: ").append(dollars(order.totalInCents()));
        return text.toString();
    }

    private static String dollars(int cents) {
        return String.format("$%d.%02d", cents / 100, cents % 100);
    }
}
```

**`src/main/.../model/DaySales.java`**

```java
public class DaySales {
    private final List<Order> completed = new ArrayList<>();

    public void record(Order order) {
        completed.add(order);
    }

    public int revenueInCents() {
        int revenue = 0;
        for (Order order : completed) {
            revenue += order.totalInCents();
        }
        return revenue;
    }

    public int loyaltySavingsInCents() {
        int savings = 0;
        for (Order order : completed) {
            Customer customer = order.getCustomer();
            if (customer != null && customer.isLoyaltyMember()) {
                savings += order.subtotalInCents() / 10;
            }
        }
        return savings;
    }
}
```

**`src/test/.../model/OrderTotalTest.java`**

```java
class OrderTotalTest {
    @Test
    void memberGetsTheDiscount() {
        Order order = new Order(new Customer("Ana", true));
        order.add(new OrderLine(new MenuItem("Latte", 450), 3));
        assertEquals(1215, order.totalInCents());
    }

    @Test
    void walkUpPaysFullPrice() {
        Order order = new Order(null);
        order.add(new OrderLine(new MenuItem("Latte", 450), 3));
        assertEquals(1350, order.totalInCents());
    }
}
```

`MenuItem` has a name and a price in cents, with a getter for each, and nothing else.

**The requirement, from Week 2:**

- **2.8** Loyalty members get their discount automatically. They shouldn't have to ask.

**The answer to suppose for step 1:** members get 50 cents off every item they order.


---

## 2. What I'm Not Sure About

Unsure about if the modified method satisify the condition to apply discount for requirement 2.8. Since we did not have to compile the code beforehand, so I adjusted some logic with what I think should be added in `Order.java`. Of course the logic can be polished if we are able to see the expected result vs real result.

---

**Commit this file before group discussion begins.**