# Individual Sketch Week 7
**Student:** Na Cha
**Date:** 10/8/2026

## Checklist

Check every box before you commit. **10 points.**

- [ ] One Mermaid sequence diagram for the **main flow** of your use case, under step 1 **(4 pts)**
- [ ] Every solid arrow is a method that's already in your class diagram, **or** has a `MISSING` note directly under it **(3 pts)**
- [ ] The diagram renders on GitHub **(1 pt)**
- [ ] Section 2 of the template says what you're least sure of **(2 pts)**
- [ ] Committed to `week-07/individual-sketch.md` **(required: nothing is graded without it)**

---

### UC-1: Place an Order

**Actor:** Customer

**Precondition:** The customer has built an order with at least one item, and has chosen a size and customizations for every item.

**Postcondition:** The order is in the barista queue with a confirmation number, and every item on it carries the price it was placed at.

| Actor Action | System Response |
|---|---|
| **1.** Customer asks to place the order. | |
| | **2.** System confirms that every item on the order can be sold right now. |
| | **3.** System works out the price of each item as configured, and records that price on the order. |
| | **4.** If the customer is a loyalty member, system applies the loyalty discount. |
| | **5.** System records the order's total. |
| | **6.** System gives the order a confirmation number. |
| | **7.** System adds the order to the end of the barista queue. |
| | **8.** System shows the customer the confirmation number and the total. |

**Alternative flow 2a: An item can no longer be sold.**

| Actor Action | System Response |
|---|---|
| | **2a1.** System tells the customer which item can no longer be sold. |
| **2a2.** Customer removes that item or changes it to one that can be sold. | |

*Rejoins the main flow at step 1.*

## 1. Tonight's Prompt

**Step 1: The sequence diagram.** One Mermaid `sequenceDiagram` for the **main flow** of your use case. Leave the alternative flows out. Every arrow follows these rules:

1. The actor is an `actor`. Every class is a `participant`, named exactly as it is in your class diagram.
2. The actor's first arrow goes to the class in your model that should receive the request.
3. Every solid arrow (`->>`) is a method call, labeled `methodName(arguments)`. **The method must already exist on the class the arrow points to**, in your class diagram.
4. **A class can only call a class it's connected to by a line in your class diagram.**
5. Every method that returns something gets a dashed return arrow (`-->>`) labeled with what comes back.
6. When rule 3 or rule 4 fails, draw the arrow you need anyway and put a `MISSING` note directly under it: the method you propose, with its full signature, and why that class.

```mermaid
sequenceDiagram
  actor Member
  participant Library
  participant Catalog

  Member ->> Library: searchByTitle("Dune")
  Library ->> Catalog: findByTitle("Dune")
  Note over Catalog: MISSING. Proposed: Catalog.findByTitle(title: String): Book, because Catalog holds every book.
  Catalog -->> Library: book
  Library -->> Member: book
```

```mermaid
sequenceDiagram
    actor Customer
    participant CoffeeShopSystemInput
    participant CoffeeShopSystemLogic
    participant Order
    participant Item

    Customer ->> CoffeeShopSystemInput: placeOrder(order: Order, loyaltymember: boolean)

    Note over CoffeeShopSystemLogic: MISSING. Proposed: CoffeeShopSystemInput.placeOrder(order: Order, loyaltyMember: boolean): String, because it needs to return the confirmation number and total to customer.

    CoffeeShopSystemInput ->> CoffeeShopSystemLogic: available(order: Order)
    Note over CoffeeShopSystemLogic: MISSING. Proposed: CoffeeShopSystemLogic.available(order: Order): boolean, because CoffeeShopSystemLogic holds Menu and Inventory and decides whether an item can be sold/available.
    CoffeeShopSystemLogic -->> CoffeeShopSystemInput: true

    CoffeeShopSystemInput -->> Order: recordOrderPrice()
    Note over Order: MISSING. Proposed: Order.recordOrderPrice(): boolean, because Order holds orderItemList, which can configure and record the price of an order.

    loop for each item in Order.orderItemList
        Order ->> Item: calculateConfiguredPrice(size, customizations)
        Note over Item: MISSING. Proposed: Item.calculateConfiguredPrice(size: String, customization: List<String>): double, because the use case prices and item by size and customization, but the group's Item class doesn't have method to calcualte configured price.
        Item -->> Order: configuredPrice
        Order ->> Item: setPrice(configuredPrice)
    end
    Order -->> CoffeeShopSystemInput: true

    CoffeeShopSystemInput ->> CoffeeShopSystemLogic: getLoyaltyDiscount(customerId)
    Note over CoffeeShopSystemLogic: MISSING. Proposed: getLoyaltyDiscount(customerId: String): Double, because discount is applied if customer is loyalty member.
    CoffeeShopSystemLogic -->> CoffeeShopSystemInput: loyaltyDiscount
    CoffeeShopSystemInput ->> Order: applyDiscount(discount double)
    Order -->> CoffeeShopSystemInput: true
    
    CoffeeShopSystemInput ->> Order: calculateTotal()
    Note over Order: MISSING. Proposed: Order.calculateTotal(): boolean, because Order has totalCost but there are no method to add up item prices and apply the discount.
    Order -->> CoffeeShopSystemInput: true

    CoffeeShopSystemInput ->> Order: getTotalCost()
    Order -->> CoffeeShopSystemInput: totalCost

    CoffeeShopSystemInput ->> Order: generateConfirmationNumber()
    Note over Order: MISSING. Proposed: Order.generateConfirmationNumber(): String, because Order has orderId but no method to create it or return it.
    Order --> CoffeeShopSystemInput: confirmationNumber

    CoffeeShopSystemInput ->> CoffeeShopSystemLogic: addToBaristaQueue(order: Order)
    Note over CoffeeShopSystemLogic: MISSING. Proposed addToBaristaQueue(order: Order): boolean, because the queue is needed for Barista's list of orders in the system logic.
    CoffeeSystemLogic -->> CoffeeSystemInput: true

    CoffeeShopSystemInput -->> Customer: confirmationNumber + totalCost

```

---

## 2. What I'm Not Sure About


I am not sure for: "CoffeeShopSystemInput ->> CoffeeShopSystemLogic: available(order: Order)" because I think while it is helpful to have the method, the order themselves should already be checked by CoffeeShopSystemLogic because it has access to Menu and Inventory.

---

**Commit this file before group discussion begins.**