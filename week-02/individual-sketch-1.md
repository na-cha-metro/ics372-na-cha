# Individual Sketch — Week 2 Round 1
**Student:** Na Cha
**Date:** 9/3/2026

---

## My Answer

Menus should have access view to inventory.

Customers should have menu access and ability to order.

Employees should have access to order fulfillment.

Managers should have access to change menu and update inventory.

---

## Diagram

```mermaid
classDiagram

class Menu{
    +listOfSoldItems
}

class Inventory{
    +ItemName
    +ItemPrice

    -ProductID
}

class CoffeeShop{
    +Display()
}

class Customer{
    +CustomerID
    +FirstName
    +LastName
}

class Employees {
    +EmployeeID
    +FirstName
    +LastName
}

class Managers {
    +ManagerID
    +FirstName
    +LastName
}

class Order {
    +CustomerID
    +OrderID
    +TotalCost
    +Date
    +Status
}

class OrderLine {
    +OrderID
    +EmployeeID
    +ProductID
    +Status
}

CoffeeShop "1" -- "1" Menu : has
CoffeeShop "1" -- "M" Managers : has
Managers --> Employees : manages
Managers --> Inventory : views and manages
Employees --> OrderLine : takes order to fulfill
Menu "1" -- "M" Inventory : displays
Customer "1" --> "M" Order : orders
Customer "1" --> "1" Menu : views
Order -- OrderLine : appends into
OrderLine -- Inventory : checks stock

``` 

---

## What I'm Not Sure About

I think the core systems of this coffee shop point-of-sale system is that it has entites for menus, customers, managers & employees, orders, and inventory but there could be some others as well. Ideally I think, that the customers should also be able to see the quantity in the inventory before placing an order.

---

**Commit this file before group discussion begins.**
