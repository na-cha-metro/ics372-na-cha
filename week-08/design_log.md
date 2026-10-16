# Design Log — Week 8
### ICS 372 | Fall
**Student:** Na Cha 
**Group:** 4  
**Date:** 10/15/2026
**Topic:** No topic given tonight.

---

## Part 1 — The Problem

Tonight, the issue was implementing the use-cases and classes into code. For example, the classes: Order, CSSLogic, CSSInput, Customer, Item, etc.

As well, as making sure the code complies in order to satisfy use-case 1.

---

## Part 2 — Your Design Decision

My group has not fully settled on how we should instaniate it. According to the code should get the menu, we need it to be from an inventory which should perhaps contain Items for the Order. But one thing is for sure, is that we need to refactor/redesign. 

---

## Part 3 — How You Got There

If it were based on my sketch, the approach I had it is to get it from CSSLogic's available method with CSSInput. At the time, the approach looked right, because we just need to verify if the order can be made before it resumes the main flow. If I chose it from Order, while similar in approach, it would perhaps be simplier because it just needs to inquiry CSSLogic.

---

## Part 4 — The Road Not Taken

A unified CoffeeShopSystem singleton. Because it a single static system that would globally govern and manage everything in the store. Because personally, I think there should be only ONE CoffeeShopSystem/POS system. I brought up the point and argued my case, but because of how we had CSSLogic and CSSInput, it was futile, refactor and redesign was deeply needed first. Not to mention, it is convoluted with CSSLogic and CSSInput.

---

## Part 5 — What You're Uncertain About

I am uncertain about if we should create a new class, say, CoffeeShopSystem, to be the singleton, or if another approach, say inventory, is better for this. Because if it is a singleton, it could manage inventory of items, orderlists of orders, ingredients etc. My group is still brainstorming this part, but the consensus is we will have to figure it out in the future, which I agree, due to how we initially designed our CoffeeShopSystem.

---

## Word Count: 259 words

---