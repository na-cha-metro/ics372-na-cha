# Design Log: Week 11
**Student:** Na Cha 
**Group:** 4
**Date:** 11/05/26

**Last week's feedback:** First log since last week feedback not yet posted
**Where I used it:** last week feedback not yet posted

---

## Part 1: The Problem

> Tonight wasn't the activity you did. In two or three sentences, say what the problem actually was.

Tonight we were tasked with estimating costs for implementing a barista screen. Such as, what classes needed to be changed or modified and what features needed to be used. Observers listeners for view etc. As well as for UC-2 based on the group's class-models and shop code.

---

## Part 2: What We Ended With

> Describe what your group ended with, as of your group's last commit tonight, clearly enough that someone who wasn't in your room could rebuild it. Name the file it's in.

For the UC-2, my group ended with listeners for both low ingredients, and server order confirmation number. Because these listeners are needed for loose coupling, combating the issue where classes rely on one another too much. So if one breaks, the other doesnt. Essentially decoupling I suppose.

---

## Part 3: One Decision That Moved or Held

> Take one decision you made alone in your sketch. Say what you chose and why it looked right at the time. Then say what happened to it tonight: what changed it, or what you heard and held against.

In my sketch I went with methods instead of listeners. I chose it because at the time it seemed right to have such methods do the work of showing, and removing the current order on the barista screen display. During the group though, I realized that listeners might have more use, as compared to what I was trying to achieve in my individual sketch methods.

---

## Part 4: Argue the Other Side

> Take the option your group didn't choose and make its strongest case, fairly enough that someone who wanted it would recognize their own argument. Then say what beat it, or that nothing did.

A good reason to not use listeners and use methods, is perhaps the complexity if there is a lot of listeners, clutter basically. However, in certain situations the approach with method is not ideal, like in the UC-2 today, where we had to figure out a way for listenrs to alert during certain conditions.

---

## Part 5: What Could Break

> Name one specific thing in your design that could turn out wrong, the situation that would expose it, and what you'd need to see to find out.

Easily implementation of listeners. Lambda or not, since as of current writing, my group have not fully compiled the code nor completed it. Therefore, there could be many issues with what we have so far in regards to listeners working as intended or not. We'd need to actually have a working test to see if there are any underlying issues that needs to be addressed.
