# Individual Sketch Week 10
**Student:** Na Cha
**Date:** 10/29/2026

---

## 1. Tonight's Prompt

## Checklist

Check every box before you commit. **10 points.**

- [ ] Step 1 has the whole body of your method in Java, with every call it makes **(3 pts)**
- [ ] Step 2 has a row for every collection your method walks that another class owns, with exactly one of the five values under **What it gets** **(3 pts)**
- [ ] Every row of step 2 says `yes` or `no` under **Could it change it?** **(2 pts)**
- [ ] Section 2 of the template says what you're least sure of **(2 pts)**
- [ ] Committed to `week-10/individual-sketch.md` **(required: nothing is graded without it)**

---

Week 8 decided how a class gets hold of another object. Tonight a class needs to look at **everything another object is holding**: every order in a queue, every line on an order. The question is **what it gets from the owner** to do that.

**Which use case is yours.** Sort your group by first name, A to Z. The first and third people take UC-2. The second and fourth take UC-3. In a group of three, the first and third take UC-2 and the second takes UC-3.

Open `week-10-use-cases.md` and your group's sequence diagram for your use case in `docs/design/use-cases.md`. If your group has no diagram for it, work from the use case text.

**About the example.** It uses the library system from the textbook, not Brew & Byte. It shows you the *shape* of what to write and nothing else.

Copy steps 1 and 2 into **section 1 of your sketch file** and put your work directly under each step.

---

**Step 1: The method.** Write the whole body of one method, in Java, in one code block:

- **UC-2:** the method that uses up the ingredients for every item on the order, including the ingredients its customizations add (step 5).
- **UC-3:** the method that counts how many of each menu item sold today (steps 2 and 3).

```
// UC-2

// AsIsItem

private Ingredient[] ingredients;

public boolean useIngredient(){
    throw new UnsupportedOperationException("Not implemented yet");
}

public void setIngredientList(Ingredient[] ingredientList) {
    ingredientList.add(new Ingredient("name", "id", 1));
}

// CustomizableItem

private List<Ingredient> baseIngredientList;
private List<Ingredient> finalIngredientList;

public boolean removeIngredientFromFinalList(Ingredient i){
    try {
        for (Ingredient j : this.finalIngredientList) {
            if (j.equals(i)) {finalIngredientList.remove(j);}
        }
    } catch (Exception e) {
        return false;
    }
    return true;
}

// UC-3

//Records

public List<DaySales> pullTodaySales(){
    return this.DaySales;
}
```

Write it against your group's classes as they are now in `src/main/java`. If you need a method that doesn't exist yet, write the call anyway, and put a comment on that line naming the class it belongs to. Don't change any files in the repo; this lives in your sketch only.

**Step 2: The walk table.** One row for every collection your method walks that belongs to **another** class: a list, an array, a set or a map. If your method walks the same class's collection twice, that's still one row.

Exactly these four columns:

| Walks it | Whose collection | What it gets | Could it change it? |
|---|---|---|---|
| `OverdueReport` | `Member`'s holds | a copy | no |

**What it gets** is exactly one of these five values:

- `the collection itself`: the owner hands over its own field, like `getHolds()` whose body is `return holds;`. This is also the value when the walker made the list and handed it to the owner, because both now hold the same list.
- `a copy`: a new collection with the same objects in it, like `List.copyOf(holds)` or `new ArrayList<>(holds)`.
- `a read-only view`: the owner's own collection wrapped so that any change throws an exception, like `Collections.unmodifiableList(holds)`.
- `an iterator`: the owner hands out something that walks its collection, and nothing else. The owner implements `Iterable<Hold>`, so the walker writes `for (Hold hold : member)`.
- `the answer`: the owner walks its own collection and hands back only the result, like `member.countOverdue(today)`. Your method then doesn't walk it at all, but the row still goes in.

**Could it change it?** `yes` if your method, or anything holding what your method got, could add to the owner's collection, take something out of it, or reorder it. `no` if it couldn't.

| Walks it | Whose collection | What it gets | Could it change it? |
|---|---|---|---|
| `SalesReport` | `DaySales`'s holds | a copy | yes |
| `IngredientReport` | `Ingredient` | a copy | yes |

---

## 2. What I'm Not Sure About

Due to the group's codebase, I wasn't quite sure which classes did what. Over past few weeks there was a lot of decisions that made some classes redudant or broken into facade-type classes. Not to mention the refactoring was an issue.

---

**Commit this file before group discussion begins.**