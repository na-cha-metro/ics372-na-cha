# Individual Sketch — Week 4 Round 1
**Student:** Na Cha
**Date:** 9/17/2026

*Delete every italic instruction and every bracketed placeholder before you commit. What is left should read as your writing, not as a form with answers inserted.*

---

## 1. Tonight's Prompt

*Copy this round's prompt into this section exactly as it was given to you, including every numbered step. Then answer each step directly underneath it.*

*Every numbered step gets an answer. A step you ran out of time on gets one line saying what you had so far. A step with nothing under it scores as a step you did not do, no matter how good the rest of the file is.*

*Where a step asks for a diagram, the Mermaid block goes under that step. Every diagram is a Mermaid code block inside this file. Never an image, never a screenshot, never a link.*

[Paste the prompt here, then write your answer under each numbered step.]

Take one of these two, split across your group:

Customer Places Order

Barista Marks an Order Complete

Working alone, on yours:

1. Write the main flow, using the call-and-response format from the template. Precondition, numbered steps alternating between actor and system, postcondition.

**Precondition:** In order for the customer to be able to place an order, the customer must have items in their cart, like type of coffee or latte before placing the order.

**Main Flow:**
    (1) The customer (actor 1), checkouts their order at the system along with any notes regarding the order.
    (2) The customer (actor 1) pays at checkout and the system also checks if they are a loyalty member and applies discounts when necessary.
    (3) A prompt from the system/barista screen that the customer's order has been successfully made. Along with an order #/id or similar so the customer can pick it up when it is done.
    (4) The order is made and the system updates the inventory.
    (5) The order is done and the customer (actor 1) is called to pick up their order.

**Postcondition:** Customer picks up order and order has been fulfilled so the (postcondition) end state is met.

2. Then go back through it and annotate every step with what it assumes. One phrase per step in the margin. Step 2 assumes the item is available. Step 5 assumes the order can still be changed. Do this for every step, even the ones that seem to assume nothing.

(1) The customer (actor 1), checkouts their order at the system along with any notes regarding the order. **assumes customer has items to be ordered**

(2) The customer (actor 1) pays at checkout and the system also checks if they are a loyalty member and applies discounts when necessary. **assumes payment method is valid and customer is a loyalty member**

(3) A prompt from the system/barista screen that the customer's order has been successfully made. Along with an order #/id or similar so the customer can pick it up when it is done. **assumes there is an order id to be given and tracked by the customer and barista/system**

(4) The order is made and the system updates the inventory. **assumes there is enough ingredients for the order**

(5) The order is done and the customer (actor 1) is called to pick up their order. **assumes customer picks up the order**

3. Turn two of those assumptions into alternative flows. Keyed to the step where they branch, with what happens instead and where it rejoins — or that it ends the use case.

If a customer is not a loyalty member: discount is not applied and the process of checking out continues.

If the customer changes their mind on the order note after placing the order: they must notify the customer otherwise the note is followed when making hte order.

---

## 2. What I'm Not Sure About

*One or two sentences. What feels uncertain or wrong about what you just produced?*

*This is about your own thinking, and it is required every week. It is not the same thing as a question written for a stakeholder. When the prompt asks you for one of those, it belongs up in section 1 with the step that asked for it, and it does not replace this section.*

Step 1: I am not sure about how the system should exactly check a customer's loyalty membership. There could be conditions like total orders history that is counted or it could be a tracking system like email.

Step 1: The customer's changed notes should be notified immediately to the barista else the original note is taken for the order.

---

**Commit this file before group discussion begins.**
