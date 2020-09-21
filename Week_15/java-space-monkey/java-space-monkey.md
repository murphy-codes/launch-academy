# Java Space Monkey

## Getting Started

```no-highlight
et get java-space-monkey
cd java-space-monkey
idea .
```

This assignment comes with the controller and model already set up for you.

## It all depends on you!

As a Space Monkey Engineer in training on the Space Monkey _Starship NCC - Delicious Taco_, it is your job to keep the ship's technology running. Moments ago your ship was fired upon by the evil cat government, The Feline Alliance. Though your ship survived, the viewscreens are currently not working on the bridge. The Great Space Monkey Captain Ooo ooo iek the Hairless has ordered you to solve this problem by adding new views based on the Great Captain's specifications.

## First things first!

The Great Space Monkey Captain Ooo ooo iek the Hairless has ordered you to create a way to see all the viewscreens that need fixing.

- Create an `index.html` inside your viewscreens templates.
- Fill in `index.html` using Thymeleaf syntax to show the name, role and location of each viewscreen.

## What about Banana Power?

The Great Space Monkey Captain Ooo ooo iek the Hairless has ordered you to create a way to see if the other viewscreens elsewhere have enough banana power to be properly fixed! He wants to look at each viewscreen in turn.

- Create a `show` template that lists all of an individual viewscreen's info
- Each viewscreen requires at least 500 bananas to generate enough banana power to work properly. If a viewscreen doesn't have enough bananas, add the text _"Not enough nanas..."_ to the template

# Non-Core

## For posterity...

The Great Space Monkey Captain Ooo ooo iek the Hairless has ordered you to create a default layout for a the sequential view screens.

- Create a fragments folder inside your templates.
- Create a layout.html
- Ooo ooo iek wants the ship's name to show on each viewscreen that uses this template so add an `h1` with the ship's name to the layout.
- The great captain also wants his name added at the bottom of every page.
