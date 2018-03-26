# CSIS 3020 : Web Programming and Design
## Assignment 4

### Objective:
To create a browser-based flashcard application that is a kind of quiz or drill.

* Process:
    * user is shown a picture and has to enter or choose the corresponding word (or phrase).
    * user is shown the correct answer
    * application moves on to the next picture

* Requirements:
    * HTML page must have a space for a picture and four buttons
    * Buttons must be labeled.
    * Choices can either by written as labels in a button, or they can be text next to a button.
    * There should be two additional buttons for “correct answer” and “next”
    * Page should show the number of images that have been shown so far in this round, and the number of the user’s correct answers.
    * For managing pictures:
        * you should have a list of urls to load the pictures
        * pictures themselves can and should be on the Web
        * use JavaScript or JQuery code to compose and write out the line of HTML to load the next image in the appropriate space
    * For choices:
        * when a new picture is loaded, all of the buttons should have names that were randomly chosen from among the names that go with other pictures
        * button holding the correct answer should be randomly chosen
    * Display a message, once user has selected choice
    * Clicking on the “correct answer” button should highlight the choice that was correct
    * Clicking on the “correct answer” button should work even if no choice was made.
    * Clicking on the “Next” button should set up the next challenge by loading a new image and relabeling the 4 buttons.
    * Ideally, when the page is first loaded, it should create a random ordering in which to show the images



