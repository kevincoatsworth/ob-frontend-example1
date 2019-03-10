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
