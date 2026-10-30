# Design Log — Week 10
### ICS 372 | Fall
**Student:** Na Cha 
**Group:** 4  
**Date:** 10/29/2026
**Topic:** Reuse — the hierarchy under requirement change, generics

---

## Part 1 — The Problem

Tonight we were to write java codes to UC-2 and UC-3. I started with UC-3 first according to the task. While working on it, I noticed that because of the refactor my team is currently going through with our project, I could only realistically use `pullTodaySales()` from Records class for this. After that I went to UC-2 and used the AsIsitem class's `setIngredientList(Ingredient[] ingredientList)`, `useIngredient()` and CustomizableItem class's `removeIngredientFromFinalList(Ingredient i)` to fulfill the use-case.

---

## Part 2 — Your Design Decision

My group decided that ItemList walks through a copy of Order for UC-2. A copy because we do not want to change the original. For UC-3, we agreed that Record walks through the List<Order> itself. And that Order walks through Item for name and quantity of the item for UC-3 with a copy so it does not mutate any private data.

---

## Part 3 — How You Got There

Based on the walk-table, the count was 0 I believe. Where another class can modify data from another. Because we used some data that are either immutable or copies, so as to not allow modification.

---

## Part 4 — The Road Not Taken

We considered adding the method to pull completed orders from a specific date directly from OrderList itself with an immutable date search parameter. This would lessen the logic and need for another class. But we went and rethought about adding Record class back to the original flow. So we had it come back as to hold the completed orders when they are pulled from the OrderList after being marked as complete. This is also because Record has a method that can get the order lists from a certain date.

---

## Part 5 — What You're Uncertain About

Perhaps the next class(es) that would walk through the barista's screen or manager, is the Inventory or OrderedItem class. Im still not sure, since as mention we are refactoring, so I will have to consult with the group. But from my understanding those should be the next ones, or similarly Menu.

---

## Word Count: 236 words

---