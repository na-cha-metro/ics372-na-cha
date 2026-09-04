# Individual Sketch — Week 2 Round 2
**Student:** Na Cha
**Date:** 9/3/2026

---

## My Answer

**State 1:**

The moment an order entity is created when a customer is building the order, it should document who the customer is, what it's order identifier is, the total, the date, and the current status of the order. But if it wasn't submitted yet, the status is irrelavent since it is not in the system yet.

The fields for order should be the following:

Order(int CustomerID, int OrderID, numeric TotalCost, date Date, string Status)

**State 2:**

When the order has been submitted the order status should be changed to pending and also appended to an order list or orderline with its own status for the employees to see and fulfill.

The fields for orders is the same when it is submitted.

Order(int CustomerID, int OrderID, numeric TotalCost, date Date, string Status)

**State 3:**

When the order is complete, the orderline status updates, as well as the customer's order through it's order id/identifier. And when the customer picks it up, I believe the status should be changed into completed or fulfilled to indicate that the order is done.

The fields for orders stays the same, but the status is updated to completed.

**The change & unchanged:**

The only real change between each state is the status of the order, as the order remains the same. Should a customer cancel, the status is changed to cancel.

**The methods needed to progress into the next State:**

In order for Order to move states, it will need an updateStatus method, and perhaps a getStatus method for verification purposes.


## What I'm Not Sure About

However, if I were to assume that there is no orderline needed for orders, then there would be an extra field of EmployeeID in Order.

---

**Commit this file before group discussion begins.**
