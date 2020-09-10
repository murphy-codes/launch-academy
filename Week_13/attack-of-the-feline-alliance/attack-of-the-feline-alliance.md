## Getting Started

As the weapons tech engineer on the Space Monkey _Starship NCC - Delicious Taco, you have been diligently preparing the ship's weapons at the behest of _The Great Space Monkey Captain Ooo ooo iek the Hairless_. The _Delicious Taco, while working on a banana salvage operation on a suspiciously destroyed Space Monkey ship, is now being attacked by a _Feline Alliance Purrstroyer ship_!

```bash
et get attack-of-the-feline-alliance
cd attack-of-the-feline-alliance
idea .
``` 

Then:

```bash
createdb feline_alliance
```

#### "Hokey religions and ancient weapons are no match for a good blaster by your side, kid."


_The Great Space Monkey Captain Ooo ooo iek the Hairless_ has ordered all hands to arm themselves with blasters incase the _Delicious Taco_ is boarded.

- Create a new flyway migration to create a `blasters` table. This table requires a String `name`, String `type` and Integer `recharge_time`. It optionally has a String `attachment`. After setting it up, run this with flyway.

The _Delicious Taco_ needs its laser cannons prepped and ready to fire!

- Create a new flyway migration to create a `laser_cannons` table. This table requires a String `name`, Integer `recharge_time` and Integer `fire_rate`. After setting it up, run this with flyway.

- Create a `Blaster` entity and ensure you can persist a record using the Entity Manager.

- _The Great Space Monkey Captain Ooo ooo iek the Hairless_ has ordered more power to the laser cannons to break through the _Purrstroyer_'s shields.

- Create a `LaserCannon` entity and ensure you can persist a record using the Entity Manager.

- Create a new flyway migration that adds a Boolean `overload` column to your `laser_cannons` table. After this is setup, run this with flyway.

- Update your LaserCannon entity to ensure you can make use of the `overloard` column and still persist a new LaserCannon.