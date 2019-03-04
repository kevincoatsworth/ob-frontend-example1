# ob-frontend-example1

Welcome to the OrangeBus example frontend api. There's not much here at the moment but by the end of this we'll have a frontend service which includes:

* a user journey through multiple pages
* pages that contain form elements with server side validation

If you've followed the steps to get setup you should be able to clone this repository, open it in IntelliJ and run the tests. Hopefully, they should all be green!!

Clone the app not to your machine and navigate to it in Terminal and run the following to run the tests

```
sbt test
```

You should see 3 passing tests (all green) that test the HomePageController (referred to as HomePageControllerSpec, which refers to the test file)

Have a look around at the files within the test folder and the app folder. It might not make much sense at the moment but don't worry, if you work through the guide in this repository it'll all become clear.

Once you've had a look around it's time to start implement a new page, run the following command to check out the step1-about-us-page

```
git checkout step1-about-us-page
```

## Adding a new page: About us

After running the above command in terminal you should have a new test file `AboutUsControllerSpec`

If you run the tests now the app won't compile and you should receive a message about the type AboutUsController not being found.

We've put the relevant tests in but the implementation is missing. We need to fix this by doing the following:

* Adding a new file app/controllers/AboutUsController.scala
* Adding a new route to conf/routes

You should be able to refer to the current app/controllers/HomeController, conf/routes and views/index.scala.html files to implement the functionality in order to get the tests passing.

**Note: Don't worry about running the app and viewing it in your browser, we're only concentrating on getting the tests passing, we'll soon get to running the service and viewing it in a browser**

Once you have the tests passing commit your work through terminal and push your changes to the remote repository. Now is a good time to raise a Pull Request and tag in some people to review your code.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step2-add-user-page
git merge master
```

## Adding a new page: Add User

We have the homepage and about us page within our app, now we want to start building functionality that allows us to add a user.

Within this branch there's a new controller - AddUserController, this has been implemented but there are no tests for it. In order to have confidence in our code so we can change it, we need to ensure all functionality is covered by tests.

Open the test/AddUserControllerSpec.scala file and there are 3 tests listed similar to the HomeControllerSpec tests. You need to add these 3 tests to the AddUserControllerSpec and make sure they pass.

As you update the tests you can run the spec on it's own using the following command in terminal:

```
sbt "test-only *AddUserControllerSpec"
```

Once the tests are passing, commit your work and raise a Pull Request.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step3-add-user-content
git merge master
```
## Adding content: Add User Content

The pages we've been adding are pretty meaningless at the moment. Without content they don't really provide anything to the user, we'll start to change this by adding content. You'll also get to run the app and see what you've built so far.

We've added some content to the home page, in order to view it run the following command form terminal to run the app.

```
sbt run
```

The above command will start the service and if you navigate to http://localhost:9000 in your browser you should see the home page.

After viewing the app in your browser, stop it (ctrl+c) in terminal and you should be able to run the spec that tests this content:

```
sbt "test-only *HomeViewSpec"
```

**Note: With regards to testing content, some people think there's value in it and some don't. We've included tests for content in this app so you have a better understanding of how to test view files.**

In order to get a feel for updating view files and testing content, the next step is for you to add some content to the `add-user` page. Add the following content to the add user page:

* Please follow the link below to add a new user:
* (insert the following href link) `<a id="add-user-link" href="/add-user/name">Add New User</a>`

Please see below for some tips on how to add the above content.

* Create a new spec file test/views/AddUserViewSpec.scala (refer to the HomeViewSpec to write the relevant tests)
* Open app/views/add_user.scala.html and add the relevant content
* Once you've added the content and the tests work, you can run the app from terminal and view the add-user page at http://localhost:9000/add-user

**Note: Don't worry about implementing the controller for the `/add-user/name` page, we'll do that in the next branch.**

Once the tests are passing, commit your work and raise a Pull Request.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step4-add-user-telephone
git merge master
```

## Adding form fields: Submitting user telephone details

Now you've got a feel for adding pages and content we can start creating the journey that allows the user to submit their details using forms.

Your task within this branch is to add a page which allows users to submit their telephone number. The branch contains the following files that make up the `Add User Name` page, these files should help you create the new `Add User Telephone` page.

* test/forms/UserNameFormSpec
* test/views/AddUserNameViewSpec
* test/controllers/AddUserNameControllerSpec
* app/views/add_user_name.scala.html
* app/controllers/AddUserNameController
* app/forms/UserNameForm
* app/models/UserName

The 7 files above include tests and implementation for the `Add User Name` page. Go ahead and run the app.

```
sbt run
```

Once running visit http://localhost:9000/add-user/name in your browser and you'll see the new page. Try submitting it with and without values to see what you get.

The page you need to add is the `Add User Telephone Number`. The specs for this new page exist but the implementation is missing (if you run sbt test you'll see lots of red!)

Use the implementation for the `Add User Name` page to refer to, and add the code to create the page and get the tests passing:

* The tests for the new page are in there but broken, we need to change that
* Start by implementing the get method within the AddUserTelephoneController
    * Refer to the AddUserNameController already created, as you implement the get method you'll have to start building out the form and model
* When you implement the UserTelephone and UserTelephoneForm models keep in mind
    * The type on the model can be an Int or a String, choose whatever you think fits
    * Experiment with `nonEmptyText` and `number` for the validation. Which do you think you should use for accepting a users telephone number?
* The add_user_telephone.scala.html file exists but there's nothing in it
    * Refer to the add_user_name.scala.html file to get an overview of how it should be implemented
    * Remember you have to pass through an argument of UserTelephoneForm in order to display the form within the page
* When you have the get method working on the controller, implement the post method
    * On a successful post submission return an Ok response with text of `form submitted!!!`
    * If the post request fails a BadRequest should be returned with the relevant form error

Once the tests are passing, commit your work and raise a Pull Request.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step5-add-user-email
git merge master
```

## Adding form fields: Submitting user email

You should now have 2 pages that allow users to add their name and telephone number. The final form page to add for the add user journey is a page to allow them to add their email address (don't worry about the pages not being linked up, we'll do that in a futures step, for now we're just concentrating on adding the pages.

The `Add User Email` page requires the opposite of what you did on the last branch, the implementation exists but there's no tests.

*Note: In a real scenario if you're following TDD you should never have an implementation missing without tests to cover the functionality.*

If you run the app and visit http://localhost:9000/add-user/email in your browser, you should be able to test the form works and submit an email. Try this now.

When your happy the implementation is working, you need to add the tests. Refer to the previous form pages and add the test code for the following files:

* test/controllers/AddUserEmailControllerSpec.scala
* test/forms/UserEmailFormSpec.scala
* test/views/AddUserEmailViewSpec.scala

*Remember to run sbt "test-only *[FILENAME] as you're working to check the tests are passing"

As mentioned above, you'd never have an implementation before your tests, we're just trying to get you used to where specific tests should live and how they are written.

Once the tests are passing, commit your work and raise a Pull Request.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step6-confirmation-page
git merge master
```

## Confirmation page: Adding a confirmation page

Now we have all the pages needed to create a user, we need to display a confirmation page. To do this we need some way to persist the submitted data across pages, we'll do this using sessions.

The AddUserNameController post method has been updated to add on session data to the submitted request. Have a look at this file and the AddUserNameControllerSpec to work out what the test looks like.

Once you understand the additional session data in these two files, implement the same session functionality:

* Add additional tests to check the session data in the following files 
    * test/controllers/AddUserEmailControllerSpec.scala
    * test/controllers/AddUserTelephoneControllerSpec.scala
* Once you have the tests update the implementation to get them passing - refer to AddUserNameController to help you


When all 3 form pages are saving the data to session on submission you're ready to finish the confirmation page.

Run the app and visit the following url `http://localhost:9000/add-user/confirmation` and you should see the confirmation page. This is the page users will see so they can confirm their data is correct before submitting it.

The confirmation page contains some content along with list that at the moment only contains `Name`

Note: If you've booted up the app and haven't submitted the name form the value will be `not set`. If you go to the name page and submit a name then come back to the confirmation page it should show the name you submitted.

* Add the users Telephone and email data to the confirmation page
    * You'll have to update app/models/UserDetails to have two additional arguments for the telephone and email
    * The app/controllers/AddUserConfirmationController needs updating so you can extract the session data and populate UserDetails
    * app/views/add_user_confirmation needs to include the additional data
* Remember to TDD the functionality
    * AddUserConfirmationViewSpec will need updating to include the extra content
    * Update AddUserConfirmationControllerSpec so it tests for when a session value doesn't exist (check the last test)

####One last thing....routes

One thing we haven't done yet is link the pages together to create the user journey. Until now we've been writing the tests, adding the code to get the tests passing and then viewing each page individually in the browser.

We need to link the form submissions up so the user is automatically sent down the correct journey to the final confirmation page.

On the `step3-add-user-content` branch you added a link to the Add New User page. From this page, when a successful submission is made you should redirect the user to the `Add User Telephone Number` page.

Below is an example of what a redirect looks like.

```
Example: Redirect(routes.AddUserTelephoneController.get())
```

* Add redirects to `AddUserNameController` `AddUserTelephoneController` and `AddUserTelephoneController` (use the example above)
* Remember to keep the `withSession` method so the submitted data is stored to the session
* All controller POST tests will need updating so the status code is a redirect (303)

Along with updating the status code you should also add additional tests to check each redirect location is correct. See below for an example of this. 

```
redirectLocation(result) mustBe Some([ENTER REDIRECT LOCATION HERE])
```

There's a lot of work in this branch but it's hopefully starting to make some sense.

Once you've added the functionality and the tests are passing, commit your work and raise a Pull Request.

After the code has been reviewed and approved for merging you can merge it into master and checkout the next step. Run the following in your local terminal.

```
git checkout master
git pull
git checkout step7-submit-to-backend
git merge master
```