# Individual Sketch Week 11
**Student:** Na Cha
**Date:** 11/05/2026

---

## 1. Tonight's Prompt

# Week 11: Individual Sketch
### ICS372 | Object-Oriented Design and Implementation

**25 minutes, alone.** Commit to `week-11/individual-sketch.md`.

## Checklist

Check every box before you commit. **10 points.**

- [ ] Step 1 has a row for every file in the case that would have to change, and the total under the table **(4 pts)**
- [ ] Step 2 has your changed `OrderDesk` in Java, and anything else in the case you changed for it **(4 pts)**
- [ ] Section 2 of the template says what you're least sure of **(2 pts)**
- [ ] Committed to `week-11/individual-sketch.md` **(required: nothing is graded without it)**

---

Tonight you start from code somebody else wrote. Open `week-11-the-case.md`. Read it whole before you start: every file, and the requirement at the end.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

**Step 1: What the barista's screen costs.** Don't write the screen. Work out what adding it would do to the case as it stands.

In a table with exactly these three columns, one row for every file in the case that would have to change:

| File | What changes in it | Why it has to change |
|---|---|---|
| `Circulation.java` | the constructor gets a fourth parameter | the new notice has to be handed in |

The example row is from the textbook's library system, not the case. It shows only the shape.

- Count every file under `src/main` and `src/test`, including any test that would stop compiling.
- **Don't count `ShopSetup`** or the new screen class.
- Under the table, write the total: `Total: N files`.

| File | What changes in it | Why it has to change |
|---|---|---|
| `OrderDesk.java` | a method to show queue to barista at the desk screen  | because orders has to be on the barista's screen right away according to `requirement 1.4`, granted this method could also be in `OrderQueue.java` |
| `OrderDesk.java` | a method to remove and update the current displayed order for the barista screen after it is marked complete | because `requirement 3.3` says an order has to leave the barista screen or tablet when it is marked complete |

**Step 2: Your fix.** Change `OrderDesk`, and anything else in the case you need to, so that after your change, adding the barista's screen, or any screen after it, changes no file you already have except `ShopSetup`.

Write the changed `OrderDesk` whole, in Java, in one code block. Put any other class you added or changed in the same block, under it. Any approach you can make work is fine. If you're not sure your idea compiles, write it anyway and put a comment on the line you're unsure of.


---

## 2. What I'm Not Sure About

placeholder

---

**Commit this file before group discussion begins.**