*You can continue to work on the codebase you established in Part 1.*

## Core User Stories

### Validate Your Products

```no-highlight
As a wish list maintainer
I want to ensure I enter a valid product
So that I can protect myself against bad data
```

- My URL must start with `http:` or `https:`
- I must specify a unique name
- I must enter a numeric price
- When attempting to save my wish list item, I'm presented with errors if the record can't be saved, and I'm prompted to re-enter the product information

### Average Item Price Per Category

```no-highlight
As a wish list maintainer
I want to know the average price of products per category
So that I can see how expensive things are in a particular category
```

Acceptance Criteria:

- When in the menu where I want to "View Products In a Category", for each category, the average price of items in the category is indicated alongside each category in square brackets after the category name

## Non-Core User Stories

### Export to CSV

```no-highlight
As a wish list maintainer
I want to export my wish list
So that I can share it with people that will buy the items for me
```

Acceptance Criteria:

- There's a row for every record in the database
- Each row includes the product's name, price, URL, and if present, category name

### Import from CSV

```no-highlight
As a wish list maintainer
I want to import my wish list
So that I can reload information into my database
```

Acceptance Criteria:

- There's an option on the main menu to import a csv
- When I select that option I'm prompted for a file name
- I can load in a CSV in the same format as my export
- I should receive an error message if the file does not exist
- Each row in the import file is representative of a product - attempt to validate and save the record based on the information provided
- If a category name is provided, find or create a category on the basis of the name
- At the end of the import, it should tell me how many rows were imported, and how many failed