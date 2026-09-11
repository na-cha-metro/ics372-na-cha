# Design Log — Week 3
### ICS 372 | Fall
**Student:** Na Cha 
**Group:** 4  
**Date:** 9/10/2026
**Topic:** What Did She Actually Ask For — reading a requirements document and turning it into use cases.

---

## Part 1 — The Problem

The problem was picking apart a given document for the right information and listing their requirements. Some requiremnts were tricky to place, such as the whether a Barista can actually add an menu item, which contradicts itself where the Manager is only one allowed to adjust and add items to the menu. I've placed the Barista's ability on adding new items to Non-Functional and the Manager to Functional, but I doubt the Barista takes priority over the Manager. This leads to the next problem of use-case to put into a diagram, which I did customer and took the bits required but I believe there are more use cases for customer.

---

## Part 2 — Your Design Decision

My group decided that Barista can add an item when there is no manager, being non-functional. Which is exactly what I thought, as we debated on whether or not it is functional, but concluding that it is not needed for the Coffee Shop POS system to function. We did not produce a diagram for the first group artifact since it was not required, but we did produce a use-case diagram which can be found in "group-artifact-2.md" as well as our table.

---

## Part 3 — How You Got There

Before the group discussion, my questions to the owner of this shop is whether or not Managers should bear more responsibilities and grunt work of fulfilling inventory checks. As well as, managers seeing the end-of-day salesreport and what to actually include in the said report. And whether or not the Manager has absolute authority on the menus and inventory.

During the group discussion, we concluded that the manager should be assumed to be acting in good faith in the actions they take. Such as, the managers having a lock on adding items to the menu so they can control what is shown or what is taken out from the ordering menu. I also disagreed slightly on if a Barista gets priority action when a customer has an issue with their order and the Barista has to resolve it. Since I believed that the Manager should be involved in such cases as they are the authority on decisions being made in the store. This is because the information was contradictory by stating that a customer's order issue is to be resolved by the employees, but also that a placed order cannot be changed once a Barista receives it. Finally the discussion led to talking about whether there will be a system that enforces how orders are taken and which is made first. Such as, if bigger orders have priority. For now, the group settled on the assumption that the Barista is responsible for fulfilling the orders based on when they were placed.

I put an order in the use-case diagram because it functioned as both viewing the menu and checking out i.e. placing the order. As well as a note on the order before the checkout use-case.

---

## Part 4 — The Road Not Taken

We disagreed slightly over whether the warning system for low stock or backorder should notify both Baristas and Managers, not just managers. But settled on the choice of it notifying only the manager. This is because I stated that since the manager held power over the inventory and menu, it is only natural that the manager is also notified in cases of low supply of ingredients. Which after hearing my point, the group members agreed and we made classified it as functional.

---

## Part 5 — What You're Uncertain About

Between all of the current use-cases, I believe view and complete order should be two seperate use-cases, where there is an option to view and an option to checkout. This was in my initial proposal use-case diagram to the group as well.

---

## Word Count: 491 words