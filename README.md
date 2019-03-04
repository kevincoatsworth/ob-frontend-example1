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