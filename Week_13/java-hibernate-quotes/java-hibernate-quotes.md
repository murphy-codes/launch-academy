## Getting Started

```no-highlight
et get java-hibernate-quotes
cd java-hibernate-quotes
idea .
```

## Quotes in Java

Using the article to guide you, configure a Maven project to communicate with the `quotes` database we created during database week.

If you no longer have the database, you can run the following:

```no-highlight
createdb quotes
psql quotes
```

Paste the following Data Definition Language (DDL) into your active `psql` session.

```sql
CREATE TABLE quotes (
  id SERIAL PRIMARY KEY,
  quote TEXT,
  author VARCHAR(255),
  subject VARCHAR(255)
);
```

Once your schema is properly set up, adapt the `Author` example from the previous article so that you can successfully save a Quote via a Java `main` function.
