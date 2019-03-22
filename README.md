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