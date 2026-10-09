# Design Log — Week 7
### ICS 372 | Fall
**Student:** Na Cha 
**Group:** 4  
**Date:** 10/8/2026
**Topic:** Who Does the Work: assigning responsibilities.

---

## Part 1 — The Problem

The problem tonight was designing a sequence diagram based on my group's class-model.md and tackling a set of given use-cases.

For the individual, I tackled UC-1, which was when a customer placed an order. When designing the sequence diagram for it, I noticed that there were many functions, most notably:

`CoffeeShopSystemLogic.available(order: Order)`

---

## Part 2 — Your Design Decision

The notable method:

`CoffeeShopSystemLogic.available(order: Order)` 

was used to check if an item in the order was available during the order process. Particularly because the system has to confirm whether an order can be sold or not. Because this function was missing, the system logic would most likely check an order status proceduraly based on my understanding.

---

## Part 3 — How You Got There

Assuming I am understanding the question for part 2, which it asks for a sketch so individual sketch, the one job I put on a class and moved it somewhere else was calculateConfiguredPrice(). It was a missing method, but needded for the use-case. I initially thought about it being in Order because it would calculated by CoffeeShopSystemLogic by being first sent to CoffeeShopSystemInput. But after some thinking, I believed it belonging to Item class was more fitting because it can calculate how much the item was, and being accessible to Order to modify.

---

## Part 4 — The Road Not Taken

In the group's table, the 2nd job, which is "Say what an item costs as the customer configured it", I initially proposed that we went with Item being the owner. But the team argued that Order is the class that would be responsible for collecting the items in an order for it to be ordered. So we went with Order being the owner of this job after I considered their approach. I essentially proposed that Item would be handling job 2, but the team argued that Item already handles knowing the identity of an item and its price and such. So Order should handle the job of what an item costed after or without configurations.

---

## Part 5 — What You're Uncertain About

Definitely `CoffeeShopSystemLogic` (CSSLogic), or `CoffeeShopSystemInput` (CSSInput). This is because we assigned too many responsiblities to these two classes that more or less seemed to represent an aggregate of multiple classes. So we have to break them up into smaller classes so its easier to write and implement as code. Though this also causes uncertainty as to how we should approach each being their own classses.

With CSSLogic, we can break it up into Menu, Inventory, and Orderline (or OrderList).

The same is similar for CSSInput, we can break or rename it entirely also into Orderline/Orderlist.

---

## Word Count: 359 words

---