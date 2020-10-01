You can continue to work on the codebase you established in Part 1.

## Core User Stories

#### Party API

```no-highlight
As a party planner
I want a list API endpoint for my parties
So I can see my parties as a JSON
```

Acceptance Criteria

- When I go to `/api/v1/parties` I should see my list of parties in JSON Format

```no-highlight
As a party planner
I want a list API endpoint for my friends
So I can see my friends as a JSON
```

Acceptance Criteria

- When I go to `/api/v1/friends` I should see my list of my friends in JSON Format


#### Inviting Friends to a Party

```no-highlight
As a party planner
I want to see who I have already invited to my party
So that I can plan who else to invite
```

_Note: Initially, you won't have friends invited to your parties until you have created an invite form. You may wish to hardcode an invite for a friend until the form is functional._

Acceptance Criteria:

- On a party's show page, I should see a list of the friends that I have invited to the party.
- I should see each person's first and last name.

```no-highlight
As a party planner
I want to add a friend to my invitee list
So that I can know who is invited to each party
```

Acceptance Criteria:

- On a party's show page, I should see a form with a dropdown field that shows all of my friends.
- When I select a friend and click the "Invite" button, their name should show in my list of invited friends.

#### Validations and Error Handling

```no-highlight
As a party planner
I want to receive error messages on my new party form
So I know why my new party is not submitting
```

- If the new party form submission is unsuccessful, I should remain on the new parties page. The form should still be filled with the values that were provided when the form was previously submitted (this is already happening as a part of a prior story).
- I should see error messages explaining why the form submission was unsuccessful.

```no-highlight
As a party planner
I want to receive error messages on my new friend form
So that I know why I am not able to add my friend
```

Acceptance Criteria:

- If the new friend form submission is unsuccessful, I should remain on the new friend page. The form should be filled with the values that were provided when the form was last submitted (this is already happening as a part of a prior story).
- I should see error messages explaining why the form submission was unsuccessful.

### Optional User Stories

**PLEASE DO NOT START THESE STORIES UNTIL YOU HAVE FINISHED PARTS 1-3 OF THE ASSIGNMENT AND THE CORE USER STORIES**:

```no-highlight
As a party planner
I want to change my party's details
So the party has all of the most up-to-date information
```

Acceptance Criteria:

- For each of my parties, there should be a link from the party's show page that takes you to the party's edit page. On this page there is a form to edit the party, and it is pre-filled with the party's details.
- I must supply a name, location, and description.
- If the form submission is successful, I should be brought to the party's show page, and I should see a message that lets me know that the party has been successfully updated.
- If the form submission is unsuccessful, I should remain on the party's edit page, and I should see error messages explaining why the form submission was unsuccessful. The form should be pre-filled with the values that were provided when the form was submitted.

```no-highlight
As a party creator
I want to cancel my party
So nobody comes to a party that is not taking place
```

Acceptance Criteria:

- There should be a delete button on the party's show page.
- If I click on the delete button, the party should be deleted and I should be redirected to the parties index page. Also, all of the party's invitations should be deleted as well.

```no-highlight
As a party member
I want to delete friends from the invitation list
If I no longer want to invite them
```

Acceptance Criteria:

- On a party's show page, there should be a button to delete each invitee.
- If I click the button, I should see a message that says that the invitee has been deleted, and their name should no longer show up on the show page.

```no-highlight
As a party planner
I want to see RSVPs to a party
So I know which friends will be attending
```

Acceptance Criteria:

- On a party's show page, there should be a list of RSVPs. Each RSVP should include whether they can attend or not ("YES"/"NO"), the party member who left the RSVP, an optional included message, and the date of when the RSVP was created.
- RSVPs should be listed most recent first.

```no-highlight
As a party member
I want to submit my RSVP to a party
So that I can communicate with the host whether I can attend or not
```

Acceptance Criteria:

- On the party's show page, there should be a form to create a RSVP on the party.
- I must select if I can attend or not, and select my name from a dropdown that only shows the people invited to this particular party. I can optionally supply a message for the RSVP.
- If the new RSVP form submission is successful, I should be brought to the party's show page, and I should see a success message that lets me know that the RSVP has been successfully created and added to the list of RSVPs for this party.
- If the new RSVP form submission is unsuccessful, I should remain on the party's show page, and I should see error messages explaining why the form submission was unsuccessful. The form should be pre-filled with the values that were provided when the form was submitted.
