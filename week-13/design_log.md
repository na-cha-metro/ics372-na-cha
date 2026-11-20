# Design Log: Week 13
**Student:** Na Cha 
**Group:** 4
**Date:** 11/19/26

**Last week's feedback:** Add the total line, argue the other option fairly in Part 4, and say in Part 5 how you'd catch the failure.
**Where I used it:** Individual sketch total line added. 

---

## Part 1: The Problem

> Tonight wasn't the activity you did. In two or three sentences, say what the problem actually was.

Tonight, we had to trace classes that relied on certain classes in the model, and involve controller classes to mitigate this, as well as a facade class change for this.

---

## Part 2: What We Ended With

> Describe what your group ended with, as of your group's last commit tonight, clearly enough that someone who wasn't in your room could rebuild it. Name the file it's in.

As of current writing, based on the commits in the group repo, we added the methods into the facade to add items to menu, update an item price to fulfill requirment (4.2). For returning a menu for the screen to display the menu to the customer requirement (2.1), we are currently reusing the getMenu() method. Though, a more in-depth method for it is probably needed, in this ShopFacade. 

---

## Part 3: One Decision That Moved or Held

> Take one decision you made alone in your sketch. Say what you chose and why it looked right at the time. Then say what happened to it tonight: what changed it, or what you heard and held against.

Items are made before being handed to ShopFacade to add to menu. This is because in the `ShopSetup`, we had it where we created items that implmented certain `Item` classes, like `CustomizableItem`, or `ConfiguredItem`. So for now, we decided on making `ShopFacade` have an `addItemToMenu` method that takes in the parameters to add an item to the menu.

---

## Part 4: Argue the Other Side

> Take the option your group didn't choose and make its strongest case, fairly enough that someone who wanted it would recognize their own argument. Then say what beat it, or that nothing did.

We didn't choose to keep the item being made beforehand, and a reason why we should've kept it like this is because we could potentially be handing in the wrong item type into the shopfacade's menu. And there is no way to change the type after it is made, unless we remove it from the menu and add it again. Making it beforehand, would act as a check.

---

## Part 5: What Could Break

> Name one specific thing in your design that could turn out wrong, the situation that would expose it, and what you'd need to see to find out.

Easy, our facade's new adding methods to the menu. A controller could easily add something that it isn't supposed to, like barista adding a wrong item to the menu, and manager now has to fix it.
