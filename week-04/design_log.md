# Design Log — Week 4
### ICS 372 | Fall
**Student:** Na Cha 
**Group:** 4  
**Date:** 9/17/2026
**Topic:** Step by Step, Then Message by Message — detailed use cases, and what tracing them did to the model.

---

## Part 1 — The Problem

Tonight, the problem was a given use case of a customer placing an order. Which I had to dissect into a call-and-response, as well as steps in how the process is meant to be. Such as precondition of the customer having items to order, the main flow of how the process actually is supposed to go like from the actor, customer, placing an order, and the responses from the system after every step. Of course there was postconditions as well which is what has to be true at the end of the main flow, to which I stated that an order is finished. There was also assumptions at most steps and alternative steps that could've occurred should certain conditions either met or not.

---

## Part 2 — Your Design Decision

In group-artifact-1.md my group decided on the design that a customer has select their coffee/items before placing an order. Which the system will look at their items and find the prices. After the customer confirms on their end on what they want, they checkout and place the order with any notes about customizing their order. The system then saves the order, and sends this note alongside the order to a barista to fulfill.

We also came up with a diagram that we all agreed on in group-artifact-2.md which also included a manager to address a price or item change by the manager.

---

## Part 3 — How You Got There

My first alternative flow is from when a customer's loyalty membership is checked in order for a discount to be applied. This is because of my own experience in some stores which automatically applies applicable discounts. 

My other alternative flow is when the customer changes their mind about a customized order, where they have to immediately address the issue by alerting a barista about their order. If the order has already been taken to be made, then it is ignored and the original customization is processed into the placed order. This is from my experience in stores where there are customization options for orders.

For pricing in regards to my model, the price the customer, in this case Sam, was meant to pay the original price placed on the order prior to any changes made after the fact. This is because once the order is validated and made, it is locked-in, meaning no changes will update the order after it is placed.

---

## Part 4 — The Road Not Taken

There was a disagreement on when the price is kept on a customer's order. Whether it should be when the saveOrder() is called for an order, or confirmOrder(). But the group settled on confirmOrder() since it is the logical end before checking out or during checking out. So any price or item name changes prior to checking out will not update the order's items' current price.

---

## Part 5 — What You're Uncertain About

We almost certainly did not have enough time to make a good plausible sequence diagram. While it was for customer placing an order, there were other entities that should've been fleshed out like manager, and items. While we had extra time during this particular meeting, we did not have any more particulars to add into the diagram for now.

---

## Word Count: 389 words