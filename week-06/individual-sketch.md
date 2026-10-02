# Individual Sketch Week 6 Round 1
**Student:** Na Cha
**Date:** 10/1/2026

---

## 1. Tonight's Prompt

**Step 1: The mapping table.** Exactly these four columns, one row for every entity in `domain-model.md`. No entity is skipped.


| Entity | Verdict | Becomes | If no class, where it went |
|---|---|---|---|
| Member | one class | Member | - |
| Address | no class | - | three String fields on Member |

**Verdict** is one of exactly three values: `one class`, `several classes`, `no class`. **Becomes** is the class name or names. The last column is filled in only on a `no class` row and says what holds that information instead; otherwise put a dash.

| Entity | Verdict | Becomes | If no class, where it went |
| --- | --- | --- | --- |
| Menu | one class | menu | - |
| Employee | one class | employee | - |
| Manager | one class | manager | - |
| Customer | one class | customer | - |
| Order | one class | order | - |
| OrderLine | one class | orderline | - |
| Inventory | one class | inventory | - |
| Item | one class | item | - |
| CoffeeShopSystem | one class | coffeeshopsystem | - |
| PaymentManager | one class | paymentmanager | - |

---

**Step 2: The classes.** For every class in your **Becomes** column, one block in exactly this shape:

### Manager
- Responsible for: 
- Knows: 
- Does: 

### Menu
- Responsible for: knowing which items are available on the list.
- Knows: Items[]: inventorylist
- Does: placeOrder(ItemId: int): items; currentHolds(): List<items>

### Employee
- Responsible for: knowing who the employee is.
- Knows: EmployeeID: int; Orders[]: List<Orders>
- Does: getOrder(OrderID: int): order; Orders[]: List<Orders>

### Manager
- Responsible for: knowing who the manager is.
- Knows: ManagerID: int
- Does: UpdateMenu(addItem: ItemID, removeItem: ItemID);

### Customer
- Responsible for: knowing who a customer is.
- Knows: customerID: int; FirstName: String; LastName: String
- Does: placeOrder(ItemId: int);

### Order
- Responsible for: knowing the order.
- Knows: CustomerID: int; OrderID: int; Items[]: list<items>; TotalCost: double; isComplete: String
- Does: recordOrder(Order: OrderID)

### OrderLine
- Responsible for: knowing the correlated employees, orders, items. 
- Knows: OrderID: int; EmployeeID: int; ItemID: int
- Does: checkInventory(ItemID: int)

### Inventory
- Responsible for: knowing the inventory of current items.
- Knows: Item[]: list<items>
- Does: updateItems(Item: int); checkItems(Item: int)

### Item
- Responsible for: knowing the items.
- Knows: ItemID: int; Cost: double; Stock: int
- Does: getItemCount(ItemID: int): Stock: int

---

**Step 3: Where you'd put a hierarchy or an interface.** Pick the two or three sets of classes that have the most in common. Exactly these three columns:


| Classes | What I would do | Why |
|---|---|---|
| Customer, Order, Employee | nothing | they all carry an id and share nothing else |



---

## 2. What I'm Not Sure About

I'm not sure about the "does" functions, because it still needs to be discussed in the group in regards to what they actually do. The classes can have multiple methods despite the relationships.

---

**Commit this file before group discussion begins.**