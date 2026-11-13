# Design Log: Week 12
**Student:** Na Cha 
**Group:** 4
**Date:** 11/12/26

**Last week's feedback:** not posted yet
**Where I used it:** not posted yet

---

## Part 1: The Problem

> Tonight wasn't the activity you did. In two or three sentences, say what the problem actually was.

The problem tonight was identifying what to change to accomodate the changes for requirement 2.8. Where loyalty discount needs to be applied without needing to tell or ask the customer.

---

## Part 2: What We Ended With

> Describe what your group ended with, as of your group's last commit tonight, clearly enough that someone who wasn't in your room could rebuild it. Name the file it's in.

As of the last commit tonight, my group added `discountRule.java`, which checks the customer loyalty member to get the according discounts. The discounts are the classes we also created, namely, `applyDiscountLoyalty.java` and `applyDiscountNone.java` which implements `applyDiscount.java`.

---

## Part 3: One Decision That Moved or Held

> Take one decision you made alone in your sketch. Say what you chose and why it looked right at the time. Then say what happened to it tonight: what changed it, or what you heard and held against.

Initially I wanted to have the `applyDiscount` implementations determine the loyalty member status. But upon further thinking, and the lecture about breaking things up using the strategy approach, I took out their logic to determine this and made it into it's own class, `discountRule`.

---

## Part 4: Argue the Other Side

> Take the option your group didn't choose and make its strongest case, fairly enough that someone who wanted it would recognize their own argument. Then say what beat it, or that nothing did.

One reason we should keep the loyalty member logic in the `applyDiscount` implementations is that we can make sure the logic stays sound, and doesn't change should something happen to another critical class like `Order` or similar. It is hard-coded in that sense. But this is also a glaring issue when a class changes in the future, and we cannot come back to adjust it.

---

## Part 5: What Could Break

> Name one specific thing in your design that could turn out wrong, the situation that would expose it, and what you'd need to see to find out.

Currently, in our design, I could see an issue with loyalty discount being either negative or absurdly big, if, say, an order contained an item it shouldn't have with a price it shouldn't have. So the discount could become a problem. But we will have to implement this further to determine in such niche scenarios, though these scenario are slightly unlikely.
