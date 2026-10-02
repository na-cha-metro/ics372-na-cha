# Design Log — Week 6
### ICS 372 | Fall 2026
**Student:** Na Cha 
**Group:** 4  
**Date:** 10/1/2026
**Topic:** No Topic Title tonight.

---

## Part 1 — The Problem

The problem today was to map entity tables, classes, and hierarchy or interface based on the group design-model.md. I was trying to figure out which entity deserved its own class and which doesn't or rely on other classes. My verdict, based the group's design model, chose to keep each entity their own class.

---

## Part 2 — Your Design Decision

My group decided that there are some entities in the CoffeeShopSystem that do not have classes. Such as, Kiosk, Menu, Inventory, and OrderList, of which all are handled by the CoffeeShopSystem, and CoffeeShopSystemLogic. Where CoffeeShopSystem has multiple classes and becomes CoffeeShopSystemInput and CoffeeShopSystemLogic respectively. This is because the CoffeeShopSystem can be broken up into two main functional parts of input and logic processing output.

---

## Part 3 — How You Got There

Before the group discussion, I did not include an entity such as Kiosk. The group discussed that since Kiosk is technically a part of the system, it should be absorbed in to the main system and not be its own entity, because it is not necessarily needed to function on its own. So Kiosk became a part of the main CoffeeShopSystem. As for Menu, Inventory, and OrderList, these were discussed to be essentially parts required by the CoffeeShopSystem. They were also put into CoffeeShopSystem because of logic needing these entities, which could just refer them as a list or array of their respective identities of items. 

We also renamed Person entity to User as that served as a better interface than an individualized Person entity. It encapsulates what it should be better. We also added two entity that extends Item entity to have customized items, CustomizeableItem, and uncustomized items, asIsItem. Though the agrument of whether or not they need to be their own is one I made since I saw it as unnecessary, which I then changed my mind to agree when the proposal of a custom entity represents the user notes for customization.

---

## Part 4 — The Road Not Taken

I disagreed on how we should split up the Item entity. Because my approach to the design was that we just needed it to have it's note inside of the Item when it is in the CoffeeShopSystemLogic. But both of my teammates changed my mind, because some items might just not be in the system and need it's own CustomizeableItem entity, for example, a special drink not consisting of certain ingredients that was not in the system, with the new entity that extends item, it can be implemented into the system.

---

## Part 5 — What You're Uncertain About

If I, and my group had more information on what to exactly look out for, we could perhaps flesh out the design of our system more in regards to how an order is exactly processed in the CoffeeShopSystemLogic, and how it interacts with the CoffeeShopSystemInput to fulfill these orders and update inventory after doing so. This is because while we had an approach in mind, the checks with the 4 questions in regards to how a customer buying a customized item worked and the process through it to if it can be sold, made us reconfigure CoffeeShopSystemLogic and added a getCost to Order. But ultimately inventory management in the CoffeeShopSystemLogic has to probably be managed by the Barista due to updateOrders.

---

## Word Count: 470 words

---
