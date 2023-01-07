FE (Front End) --> What we can see on web page ..> UI (user interface) GUI (graphic user interface)
it has 3 components : HTML, CSS, JS

BE (Back End) --> DB (data base), sever-side
-------------- 

HTML --> structure
CSS  --> provide style
JS   --> logic, actions
------
DEvTools
<p>, <h>, <i>, <strong>, <ol>, <ul>, <li>, <u>, <br/>

<p> Some text </p>

--------

Selenium First Day 12.03.2022

- Selenium --> automation tool for web application
- maven repository --> place with libraries where we can get needed library and added to the project


driver.get() --> this method will naviagte/ open the link provided

driver.getTitle ---> used to get current page title

driver.close() ---> to close browser intsance after test is done

--------------------
12.06.22
- What is Selenium ?
- automation tool helps to test web applications, open source, Library(.jar files)

- Why selenium?
  PRO:
- open sorce, free, supports multiple languages, and platforms, it has a huge community

CONS:
- no custumer service because is open source,
- we can not automate everything with Selenium ex. captcha, pictures,
- we can not test a desktop app with selenium

-------------------
Maven
It a build automation tool, it help to create builds during development
It a place to store and manage dependencies.
What is a dependency? it's a library

Maven also creates a project structure:

src
main
test
pom.xml

- Selenium dependency - maven repository
- Webdrivermanager - this dedendency helps to manage drivers for different browsers.
--------------

Navigations:
- driver.get()
- drive.close()
- driver.navigate().forward()
- driver.navigate().back()
-----
- driver.getTitle()
- driver.getCurrentUrl()
-------------------------

findElements()---> method used to find a web elemnet

Type of return for this method is also webElement.

driver.findElement(Locator)

Selenium has 8 different locators:
1) linkText --> this locator will search or any text value between
   <a href ="www.google.com"> My text </a>

        driver.findElement(By.linkText("My text"))

2) name --> when we have a webelement which have an attribute name, we can use it's value to search the wen-element.

<input name="q">

driver.findElement(By.name("q")).

3) className --> this locator look for the value for class attribute

4) id --> we indenty a webElement that has "id" attribute, ids are unique values

driver.findElement(By.id("global-enhancements-search-query")

5) partialLinkText --> it a locator simialar to linkText but with possibility to use just a part of the full text, could make sense when we have lnger value

6)tagName--> find tagname of the webelement

driver.findElement(By.tagName("h3"));

7) CSS selectors

8) xpath selectors

--------------
12.07.22

Selenium has 8 locators:
- linkText(), partilaLinkedText(), className(), id(), tagName(),by.name() cssSelector(), xpath()

- click()--> will perform clicks for us, a mouse click
- sendKeys() --> allows to input a string
  --- Keys.ENTER

 -------
driver.get("link")

driver.navigate().to()
--> this is an older method to navigate to the link, and when usuing this method, selenium(driver) will not wait for the page to be fully loaded. And can make the test flaky.[flaky -- test is unstable].

driver.close()-->
driver.quite()-->
---------------------

getText()--> will return a text value( string) of the webelement

isDisplayed() return a boolean is the webelements is displayed or not on the webpage
----------------

cssSelector

element[attribute]

element[a="value"] --. label[for="ctl00_MainContent_username"]

element [a*="partial_value"] --> label[for*="username"]

#value --> same as id   ---> By.cssSelector("#ctl00_MainContent_username")
.value --> same as class ---> By.cssSelector(".button")

element>elementchild --> .login>label (to read class with value login, this element has label as child)

div[class="login"] === .login
-----------

Xpath

We have 2 types of xpath:
1. Ablosute
   / - starts with a single slash
   It will starts form the beging of HTML, and because of that is not relieable
   It can break easy after a mininal changes in HTML structure
   /html/body/main/div/div[1]/div/div[3]/div[11]/div[2]/div[10]/div[1]/div/div/ol/li[3]/div/div/a/div[2]/h3



2. Relative

// -start with double slash

it will navihate to the first elemtns with the given tag
//p

//element[@class="class_value"]
//element[@class="class_value"]/p/label --? use single lablel to navigate to a child element
//element[@class="class_value"]/../../ --? navigation from child to parent
(//element[@class="class_value"])[2]


12.10.22

- What is Selenium?
- automation tool, that support testing for web applications, and is open source
- It is supported by multiple languages, and can be run in different OS system

- What is web element?
- anything on the web page( buttons, links, image)

- What are locators?
  -Locators are more like a metgod from Selenium library (By.id(""))

How we can find a weblements using selenium what method is used for it?
- findElememt() --> a single webelement
- findElements() --> a List of webelements

NoSuchElementException --> mist common error in Selenium

-----
getText() --> to retrive the text of the webElement, it does return a string value
getAttribute() -->
<input id="search_form_input_homepage" class="js-search-input search__input--adv" type="text" autocomplete="off" name="q" tabindex="1" value="" autocapitalize="off" autocorrect="off">


driver.findElement(By.id("search_form_input_homepage")).getAttribute("class").

----------
Locators:
- 8 locators
- We are using 8 locators beacause to be more flexibile when we can not one or another one, so we can easy switch the type of locators
- Having multiple locators we assure us to be able to find any locator for any webelement


1. linkText --> it will search for any text value between tag <a> TextHere </a>
2. id --> id is something unique value
- Dynamic --> is when value of attribute is changing, it is imposibile to use and only case it can work if it has a partila value which is stable
- Non-Dynamic (static) --> an attribute value which is persistent, and is not changing often

3. name --> will look for a name attribute by value
4. className --> will look for a calss name value and it return a webelement
   5.tagName --> will indentify a webelement using tag name <a>, <h3> >>> in xpath //h3
   6.partialLinkText --> it will search for a partial value of a the text
   7.cssSelector
   driver.findElement(By.cssSelector("#search_form_input_homepage"));

<div class="h461" id="h7">
            <div name="h313">
                <a href="https://www.google.com"> GOOGLE </a>
                <a href="https://www.etsy.com"> ETSY </a>

            </div>
</div>

--> #h7  -- by ID
-->.h461 -- by class
--> div[name="h313"]
--> div.h461
--> div[class="h461"]
--> div>a ; div[name="h313"]>a
--> a[href*="google"]

* in css is used to search for partial value
8.

1)Absolute Xpath -> from the root of the html page, and this locator is not reliable starts from the html tag
2)Relative xpath -> starts with dounble slash "//" and pints to the particular webelement

--> //div[@name="h313"]; //div[@class="h461"]; --> search by attribute abd it value
--> //div[@class="h461"]//a --> navigation between parent and child
-->(//div[@class="h461"]//a)[2]
--> //a[context(text(),"ETSY")] ; //a[.="ETSY"];--> search by text value
--> //*[.="ETSY"]
--> //a[.="ETSY"]/../../

----------------------
Checkboxes
Radiobutons
driver.findElement(By.xpath("")).click()

--> isSelected() --> will return true/false
--> isEnabled() --> will is the checkbox is enabled, it will return a bolean value

-----
To make your screen full zise use the command:
driver.manage().window().maximize();

-----
How we can handle a checkbox/ radiobuttons?
- isSelected()
  ---> boolean value
- isEnabled()
  ---> boolean value

---------
Maven
Build automation tool, which provides a folder structure and pom.xml file to store and manage dependancies

What is a build?
creates folders, compiling the code, testing, and "deploying".

pom.xml --> manage dependecies, versioning



DropDowns, findElements, Java Faker
---------------------------------

FindElements()
WebElement name = driver.findElement(By.xpath("//input[@id=\"et_pb_contact_name_0\"]"));--> return one element

List<WebElement> list = driver.findElements(By.) --> more than 1 element

12.13.22
---------------------
DropDowns
To handle dropdowns in selenium we need to use 'Select'

There are 2 types of dropdowns:

1- Select dropdowns --> they are created using <select> tag in the HTML

<select>
	<option1>
	<option2>
	<option3>
</select>

2- HTML Dropdown : --> any dropdown which is created withour using select class
-> These dropdown are handled as regular webElement
-------
What can be tested for a dropdown?
--> check if a value in dropdown was bu deafault selected
--> What are existing options
--> After we select a dropdown that particular value is displayed


1. We indentify the webelement that holds dropdown
2. We need to create a 'Select' class (comes from Selenium library)
3. We need to pass the value of webElement into Select object

There are 3 ways to opperate with select class:

WebElement dropdown = driver.findElement(By.);
Select select = new Select(dropdown);

Select select = new Select(driver.findElement(By.));


1)  selectByVisibileText("ALGERIA");

This method will accept a string value


   <select class="dropdown-menu-lists" id="dropdowm-menu-1">

                  <option value="java">JAVA</option>  //index 0
                  <option value="c#">C#</option>      //index 1
                  <option value="python">Python</option> //index 2
                  <option value="sql">SQL</option> // index 3
   </select>

        select.byVisibileText("JAVA");


2) selectByIndex() --> this will accept a int value
   selectByIndex(2)


3) selectByValue() --> will accept string value
   selectByValue("sql")


 -------------

useful methods from select class:

select.getFirstSelectedOption();
- Will return a webelement and to get the value from it we need to use getText()
- Also this return the default selected value

select.getOptions();
return the list of all options with webelements

List<WebElement> dropdownOptions = select.getOptions();


  <table>
  	<thead>
  	</thead>

  		<tbody>

  		<tr> 
  			<td> </td>
  			<td> </td>
  			<td> </td>
  		</tr>

  		<tr> 
  			<td> </td>
  			<td> </td>
  			<td> </td>
  		</tr>

  		<tr> 
  			<td> </td>
  			<td> </td>
  			<td> </td>
  		</tr>

  		</tbody>
 </table>


In case we needt to indentify a particular cell
We first find a table with it's table, then indentify row and column
Ex:
//*[@class="SampleTable"]//tbody/tr[2]/td[7]

In case we need to perform some actions a row level

Ex:
//*[@class="SampleTable"]//tbody/tr --> list of all rows

//*[@class="SampleTable"]//tbody/tr[2] --> a single row


In case we need to indentify a column
Ex: //*[@class="SampleTable"]//tbody/tr/td[7] --> list of vlaues in all of the columns


tr --> horizontal
td --> verical


We always start with a table body --> table row --> table column
------------------------------------------------------------------


12.17.22


Java
- Selenium (webdriver)
- WebdriverManager
- java faker
------------------->


How we automated test cases?

1. We created a class
   We created a logic, we used webdrivermanager, we also instantiate an object for browser in the class/ method


2. How we did verify if the test pass or not

We used if/else statement
or boolean values

if(driver.getTitle().equals("Gift box - Etsy")){
System.out.println("Pass");
}
else {
System.out.println("Fails");
}


--------------------

What is TestNG?

TestNg - is a unit testing framework, but also alows to perform functional tetsing

In TestNg we create testing flow using annotations

TestNG- Test Next Generation
---------
Most common used annotations:

@BeforeClass --> will run first thing inside of the class
@AfterClass ---> will run last thing inside of the class
@BeforeMethod --> will run before each test
@AfterMethod --> will run after each test
@Test --> this is method where the test logic is created (the test itself)

------
Assertion --> allows us to verify actual values againts expected ones

Assertion is the point which makes the test pass or fail

-------------------
How we can skip the test from runnig?
There are 2 ways:
1) @Ignore annotation
2) commenting the test
   ex: @Ignore
   @Test
   public void verifyTitle2(){


 -------------------
Priority --> we can set priority on TestNG for each test

@Test(priority = 0) --> this is a default priority, even if is not set is there

priority could be any integer positive or negative (ex. -1, 1,2,3)

The smallest priority will run first ex: "-1" will run before "1".
We even can sum up two numbers
-----
Dependecy

dependsOnMethods ="login" --> allows to add dependecy to another test

--------------------------------
12.19.22

What is a TestNG?
- TestNg is a unit testing framewrok
- TestNG enabled used uf annotations and allows to create different test flows in the same class.

Annotations:
@BeforeClass --> it will run fisrt inside of the class
@AfterClass  ---> it will run last inside of the class
@Test --> we create independent tests
@BeforeMethod/ @Aftdemethod --> before/after each test

Assertions:
Allows to verify values, indicates point where the tets can fail or not.


Assert.assertEquals--> compares two values
Assert.assertTrue --> verify the condition to be true
Assert.assertFalse --> verify the condition to be false

Assert.assertFail --> if you want to make you test to fail
---------------------
Priority --> determine the order for the test, lower number mean high priority,
default priority = 0.

Dependencies --> allows to create a test dependent on another test
---------------

Dependencies takes precedence over priorities
dependsOnMethods =" methodName" aka test name
-----------------------------
12.20.22
Iframes 
--> Inline Frame
Whenever there is an iframe present in the page source (we can find it using //iframe),
in order to perform actions with elements inside of the iframe we need to 
switch focus of the driver.
Selenium can not work on two different frames at the same time
-----
If we try to locate an element inside of the iframe before switching we will get error
NoSuchElementException

To handle an iframe we need to use : driver.switch().frame(webElement of the iframe)
--------
How to locate an iframe could be done as regular webelement
But we also can use indexes 
ex: driver.switch().frame(0)
Or we can use frameID --> ex: driver.switch().frame("idvalue")
--------
Once we are done with actions for iframe elements, we need to switch to main/parent HTML

To switch to parent: driver.switch().parent()---> will focus to parent frame
To switch to default/ main: driver.switch().defaultContent() --> will focus on default frame


1 -->HTML -- default
2    --> HTML
3       -->HTML
----------------
Windows/tabs
Selenium doesn't see the different between new window or new tab, so is being handled in same way.
Driver can focus only at one window at the moment, in order to change focus we need to get
the address of the current windows : driver.getWindowHandle()--> return a unique string
that is a window address

In order to switch windows/tab we need to use for loop, and create a logic.
driver.getWindowHandles()---> will return the list of all open tabs/windows.

for(String window: driver.getWindowHandles()){
if(!window.equals(mainWindow)){
driver.switchTo().window(window);
}
}
-------------------
Soft assertion
In this assertion we can allow the assertion to fail and test to continue.
Soft assertion will not stop the execution of the code (test). And we can verify soft 
assertions separately. 
We need to create an object : SoftAssert obj = new SoftAssert();
In order to verify the results of the assertion 
we need to use a method -->
softAssert.assertAll();
-------
Soft assertion can be used for small cosmetic details on the test flow.


---------------
Iframes

- What is an iframe?
- Inline frame,  HTML--> HTML
- How to handle iframes ?
- We need to switch to the iframe which contains elements we want to interact with.
  - driver.switch().frame("index")-->
  - driver.switch().frame("id")
  -driver.switch().frame(webelement)
  
- How to switch back to the main frame?
- driver.switch().parentFrame();--> the previous frame
- driver.switch().defaultFrame(): --> the main frame(HTML)

Soft assertion

- What is a soft assertion ?
- It's a type of assertion that allows test to continue even when it fails
- How to identify the failures?
- softAssert.assertAll() --> will display the failed test 

When we can use soft assertion ?
It allows to run a test until the end of it, usually we can put "secondary importance"
things to assert.

Windows/Tabs

- Selenium doesn't see the difference between tab/ or windows
- To identify and switch tabs we can use for loop, since selenium doesn't
have a special class to handle it
- driver.getWindowHandle() --> returns a string value of tab 
- driver.getWindowHandles() --> returns a Set of string
--------------
12.21.22

Configuration Properties 
This is a separate file.
Why do we need to use that file ?
--> it a place to configure the project
--> can can do configuration of the env; browser;
--> to save the secure information like login/ password

---------
1) Create a path to file ---> telling the system where file is located
2) Properties object
3) Open the using FileInputStream
4) Loading properties file into properties object
5) Read this file using getProperty() method
-----------
What the driver utility does ?
- It helps to write less repeatable code
- It is using singelton design pattern for driver in order to create only one
- instance at the time 
- it also allows easy/ dynamic way to switch between browser using configuration file.

------------
01.03.23
Recap 

Locators :
8 locators: linkText(), name, className, id, tagName, partialLinkedText, css, xpath.

css- element[attribute]

xpath- 
--> absolute (single /)
--> relative (double //)
to locate a text //div[.="myText"]
<---->

What is testNG?
--> Unit testing framework
We use annotations to create test: 
@BeforeClass/ @AfterClass
@BeforeMethod/ @AfterMethod
@Test
----
Assertions
--> Allows to verify actual value against expected one.
Assertion will pass or the fail the test.

SoftAssertion --> it will skip a assertion that failed

Assertion regular it will stop running the code if it fails
----------------------------

@Ignore --> will skip a test from running
we also can skip it using comment //

Priority we can set when the test is created, and this will provide an order for running the test

Dependencies --> when we have a test that depends on another one 
-------------

Alerts 
We have 2 types of alerts
--> HTML alert --> it alert handled as a regular webElement
--> JSAlert --> We need to create an Alert object to use it
        --> 1 Warning --> we only accept it
        --> 2 Confirmation --> we can accept or decline
        --> 3 Prompt --> we can accept, decline and input text

Alert alerts = new Alert();
----------------

Iframes --> it is an HTML inside of another HTML

The webDriver can not focus on 2 frames (HTMLs) at the same time
a)
  1) We need to locate the iframe as regular webelement
  2) driver.switchTo().frame(weblement)
b)
byId value if the iframe has an id attribute 
c)
by Index(0)

---------
How to switch back to main frame --> switch default content --> it will navigate to main frame

How to switch to previous frame --> switch to parent 

-----------
  Windows/Tabs
How to handle a separate tabs?
We can use window handle 
We also to need create logic (loop) to switch the window
-----------

POM --> Page Object Model
POM --> is not a framework but is a design pattern 
 In a page object model we create a separate page for weblements, and store them inside
of that page

In order to make them accessible from different classes we need to use:
a constructor
public className() {
PageFactory.initElements(Driver.getDriver(), this);
}

initElements --> creates connection between current java classes and webdriver

@FindBy --> annotation that comes from Selenium
It helps to locate webelements

@FindBy (id = "ctl00_MainContent_username")
public WebElement username;

------
What to remember about POM?
--> We create separate class for each page of the application
--> we can store all webelements and its related methods in that class
--> To use the webelements we need to create a object from that page
---------------------

01.04.2023

Synchronization 

We need to align the webdriver with the flow of the page, when we have multiple moving elements,
or elements which will take time to load/ appear on the page

Because the webdriver is fast we need to slow it down in some cases
The webelements might be visible only a particular time 
----
How to handle it?
We can use:

Thread.sleep()--> IS NOT recommended. This is a java class that will stop the full program from running

ExplicitWait --> we can add an explicit condition the webelment to be visible/ or clickable 

In order to use explicit wait  we need to create an object from WebDriverWait
-------

When we have elements that appear when we do hover over and then disappear after the
mouse is moved is hard to get the locator for a particular element.
We open dev tool --> Sources ---> search for pause sign (left side), use keyboard to click on it.
MAC --> CMD+\
That will stop UI from moving until you click back on play button.

Action Class:

Actions Class comes from Selenium library 
And it allows handling actions such:
1. moveToElement
2. doubleClick
3. contextClick
4. dragAndDrop

Actions actions = new Actions(Driver.getDriver()); The object takes a driver a param

actions.moveToElement(hoversOverPage.avatar1).perform()
actions.moveToElement(hoversOverPage.avatar1).build().perform()
.perform() is required at the end of each action from action class


































































