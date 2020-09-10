You've been tasked with loading our product catalog.

## Getting Started

```no-highlight
createdb launch_catalog
et get java-product-database
cd java-product-database
idea .
```

## Core User Stories

- Jackson and Hibernate have been included in your `pom.xml` for you.
- You will need to create the configuration for Hibernate.

## Seed the Product Catalog

```no-highlight
As a catalog manager
I want to load products from JSON
So that the catalog is easier to maintain
```

Acceptance Criteria:

- Running the `Seeder` will insert the products listed in `catalog.json` into the database.

Implementation Details:

- You will need to install Jackson in order to get the catalog into a malleable data structure
- You will need to configure Hibernate to point to your launch_catalog database
- You will need to create a POJO `Product` - use Hibernate (or the JPA, if you read ahead) to perform this task
- You can use a Hibernate mapping file, or you can read ahead and use an annotated class

## Non-Core User Stories

### Re-run the Seed Script

```no-highlight
As a catalog manager
I want to load products from JSON repeatedly
So that the catalog is easier to maintain
```

Acceptance Criteria:

- Running the script multiple times does not result in duplicate rows

Implementation Details:

- Use the name to query the database. If the product already exists, do not insert it.

### Category Normalization

```no-highlight
As a catalog manager
I want to manage a list of categories
So that the products are easier to find
```

Acceptance Criteria:

- Create a `categories` table and populate it on the basis of what is in `catalog.json` as part of your `Seeder` routine.
- Load `categories` as you load your products into the database. Use a similar technique to what you implemented above so that duplicate category names are not inserted.
- Your products should reference this table in some way.