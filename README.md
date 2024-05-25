<h1>Java Based Currency Converter</h1>

<h3>Technologies used:</h3> 
IntelliJ IDE, 
Javax Swing
JUnit testing

<h3>Criteria of the Project:</h3>
Self contained application that converts sums of money to other major currencies. User will not be able to add non-numeric input without showing an error. Tests should match this conversion rate, and show the same output message for each. 

When launched, the currency converter's GUI starts up, offering two panels. Each one has a drop down menu where two countries' currencies can be compared and calculated at the standard rate of conversion. User will be able to put in any input, returned in a formatted string with two decimal spaces. 

For ease of sake, the values I use are:
<ul>

<li>India at 1 USD to 74.0 INR</li>

<li>China at 1 USD to 6.5 CNY</li>

<li>US at 1 USD to 1 USD</li>

<li>England at 1 USD to 0.75 GBP</li>

<li>Japan at 1 USD to 110.0 JPY</li>

<li>Russia at 1 USD to 74.0</li>

</ul>
Tests were constructed alongside the project itself. JUnit allows for setting up a new instance of the currency converter for each test, as there is no memory storage for this application, and purely acts as a calculator. I also found that continually adding the convertButton to simulate clicking the button in the GUI was the exact same regardless, and added it to the @BeforeEach method to save on code space, even if it is a line.

Arguably, I wonder if the dispose method is essential in this case, as when the GUI is closed, it'll close the entire application, however, I don't think it's bad practice to have it.

Albeit I do account for special characters as well as non numeric input and empty input, I am still brainstorming for more robust edge cases. When I add to the tests, I will update this README if anything changes. 


<h3>Final thoughts for now:</h3> 

The Javax Swing class is something I hadn't played around with during my bootcamp, so I did utilize code generation for that bit. 
This was a good refresher for not having messed with code for a while, and reminded me that its good to set up getters, even in something that doesn't do too much. At the very least, it was what allowed me to call those methods in the tests themselves. 
Most of my time went into making the tests, and then into the Swing GUI itself. 
Because of this, I could probably make my next small Java projects a little easier. 

I did consider utilizing an API from the exchangerates site, but in testing alone, I would be utilizing the feature itself quite a bit, and I don't want to pay the fee for every time over the alloted single usage per day. 

As far as this goes however, I think most of what I would add later on will be either additional or updated values for the currency converter itself, more test cases, and seeing where it is that I can streamline some of the code itself. 
